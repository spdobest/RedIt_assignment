package sptechindia.redit_assignment.ui.home.homeTab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.adapter.CommonRecyclerAdapter;
import sptechindia.redit_assignment.adapter.SortListAdapter;
import sptechindia.redit_assignment.base.BaseFragment;
import sptechindia.redit_assignment.controllers.OnRecyclerItemClickListener;
import sptechindia.redit_assignment.model.home.Child;
import sptechindia.redit_assignment.ui.home.FeedDetailDialogFragment;
import sptechindia.redit_assignment.ui.home.homeTab.presenter.HomeTabPresenter;
import sptechindia.redit_assignment.ui.home.homeTab.view.HomeTabViewInterface;
import sptechindia.redit_assignment.utility.CommonUtils;
import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 22/06/17.
 */

public class HomeTabbedFragment extends BaseFragment implements HomeTabViewInterface, View.OnClickListener, OnRecyclerItemClickListener {

	private static final String TAG = "HomeTabbedFragment";

	View rootView;

	HomeTabPresenter      homeTabPresenter;
	RecyclerView          recyclerViewPopular;
	SwipeRefreshLayout    swiperefreshLayout;
	AppCompatTextView     textViewShort;
	CommonRecyclerAdapter commonRecyclerAdapter;

	List< Object > childList = new ArrayList<>();

	BottomSheetDialog bottomSheetDialog;
	SortListAdapter   sortListAdapter;
	int sortListPosition = 0;
	String[] sortNames;

	ProgressDialog      progressDialog;
	LinearLayoutManager linearLayoutManager;

	String tabTitle;

	public static HomeTabbedFragment newInstance( String tabName ) {

		Bundle args = new Bundle();
		args.putString( Constants.BundleKeys.TAB_TITLE, tabName );
		HomeTabbedFragment fragment = new HomeTabbedFragment();
		fragment.setArguments( args );
		return fragment;
	}

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		homeTabPresenter = new HomeTabPresenter( getActivity(), this );
		sortNames = getResources().getStringArray( R.array.shortNames );

		Bundle bundle = getArguments();
		if ( bundle != null ) {
			if ( bundle.containsKey( Constants.BundleKeys.TAB_TITLE ) ) {
				tabTitle = bundle.getString( Constants.BundleKeys.TAB_TITLE );
			}
		}

		progressDialog = new ProgressDialog( getActivity() );
		progressDialog.setMessage( "Loading..." );
	}

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
		rootView = inflater.inflate( R.layout.fragment_hometabbed, container, false );
		setLayout( R.layout.fragment_popular );
		initView( rootView );
		setClickListener();
		return rootView;
	}

	@Override
	public void initView( View rootView ) {
		recyclerViewPopular = ( RecyclerView ) rootView.findViewById( R.id.recyclerViewPopular );
		swiperefreshLayout = ( SwipeRefreshLayout ) rootView.findViewById( R.id.swiperefreshLayout );

		linearLayoutManager = new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false );
		recyclerViewPopular.setLayoutManager( linearLayoutManager );
		textViewShort = ( AppCompatTextView ) rootView.findViewById( R.id.textViewShort );

		textViewShort.setOnClickListener( this );
		showProgress();


		swiperefreshLayout.setOnRefreshListener( new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				refreshContent();
			}
		} );

		commonRecyclerAdapter = new CommonRecyclerAdapter( childList, Constants.ROW_POPULAR_GIF, false, this );
		recyclerViewPopular.setAdapter( commonRecyclerAdapter );


		if ( childList.size() == 0 ) {
			homeTabPresenter.getData();
		}

		recyclerViewPopular.addOnScrollListener( new RecyclerView.OnScrollListener() {
			@Override
			public void onScrollStateChanged( RecyclerView recyclerView, int newState ) {
				super.onScrollStateChanged( recyclerView, newState );

				if ( newState == RecyclerView.SCROLL_STATE_IDLE ) {
					int firstVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition();
					commonRecyclerAdapter.setVisiblePosition( firstVisiblePosition );
				}

			}

			@Override
			public void onScrolled( RecyclerView recyclerView, int dx, int dy ) {
				super.onScrolled( recyclerView, dx, dy );
			}
		} );

	}


	@Override
	public void setClickListener() {

	}


	@Override
	public void showProgress() {
		progressDialog.show();
		showProgressBar();
	}

	@Override
	public void getData( List< Child > listChild ) {
		progressDialog.hide();
		swiperefreshLayout.setRefreshing( false );
		Log.i( TAG, "getData: " + listChild );

		childList.clear();
		//	childList.add( new ModelVideo( "Spm", "asdadas", "asda", "asdasd" ) );
		for ( Child child : listChild ) {
			childList.add( child );
		}

		if ( tabTitle.equalsIgnoreCase( Constants.TAB_HOME ) ) {
			Collections.reverse( childList );
		}

		commonRecyclerAdapter.notifyDataSetChanged();

	}

	@Override
	public void showError( String message ) {
		progressDialog.hide();
		CommonUtils.showSnackBar( swiperefreshLayout, message, Snackbar.LENGTH_LONG );
	}

	@Override
	public void hideProgress() {
		progressDialog.hide();
	}

	@Override
	public void onClick( View view ) {
		switch ( view.getId() ) {
			case R.id.textViewShort:
				showSortBottomSheetDialog();
				break;
		}
	}

	protected void showSortBottomSheetDialog() {
		ListView       listviewSort;
		List< String > stringList = new ArrayList< String >( Arrays.asList( sortNames ) );

		if ( bottomSheetDialog == null ) {
			bottomSheetDialog = new BottomSheetDialog( getActivity() );
		}

		bottomSheetDialog.setContentView( R.layout.bottomsheet_sort );
		listviewSort = ( ListView ) bottomSheetDialog.findViewById( R.id.listviewSort );

		sortListAdapter = new SortListAdapter( getActivity(), stringList );
		sortListAdapter.setSelectedRow( sortListPosition );
		listviewSort.setAdapter( sortListAdapter );
		listviewSort.setOnItemClickListener( new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick( AdapterView< ? > adapterView, View view, int i, long l ) {
				sortListPosition = i;
				sortListAdapter.setSelectedRow( sortListPosition );
				bottomSheetDialog.dismiss();
			}
		} );
		Log.i( TAG, "openSortBottomSheetDialog: " );

		bottomSheetDialog.show();
	}

	private void refreshContent() {
		homeTabPresenter.getData();
		new Handler().postDelayed( new Runnable() {
			@Override
			public void run() {

			}
		}, 3000 );
	}

	@Override
	public void onResume() {
		super.onResume();

	}

	@Override
	public void onCommentClick( Child child ) {
		FeedDetailDialogFragment.newInstance( Constants.BundleKeys.COMMENT_SCREEN, child ).show( getChildFragmentManager(), FeedDetailDialogFragment.TAG );
	}

	@Override
	public void onFeedClick( Child child ) {
		FeedDetailDialogFragment.newInstance( Constants.BundleKeys.HOME_SCREEN, child ).show( getChildFragmentManager(), FeedDetailDialogFragment.TAG );
	}

	@Override
	public void onShareClick( Child child ) {
		Intent shareIntent = new Intent( Intent.ACTION_SEND );
		shareIntent.setType( "text/plain" );
		shareIntent.putExtra( Intent.EXTRA_TEXT, child.getData().getUrl() );
		startActivity( Intent.createChooser( shareIntent, "Share link using" ) );
	}

	@Override
	public void onUpClick( Child child ) {
		FeedDetailDialogFragment.newInstance( Constants.BundleKeys.HOME_SCREEN, child ).show( getChildFragmentManager(), FeedDetailDialogFragment.TAG );
	}

	@Override
	public void onDownClick( Child child ) {
		FeedDetailDialogFragment.newInstance( Constants.BundleKeys.HOME_SCREEN, child ).show( getChildFragmentManager(), FeedDetailDialogFragment.TAG );
	}
}
