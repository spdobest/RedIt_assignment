package sptechindia.redit_assignment.ui.home.email;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.adapter.CommonRecyclerAdapter;
import sptechindia.redit_assignment.base.BaseFragment;
import sptechindia.redit_assignment.controllers.OnRecyclerItemClickListener;
import sptechindia.redit_assignment.model.ModelMessage;
import sptechindia.redit_assignment.model.ModelText;
import sptechindia.redit_assignment.model.home.Child;
import sptechindia.redit_assignment.ui.home.email.presenter.EmailTabPresenter;
import sptechindia.redit_assignment.ui.home.email.view.EmailTabViewInterface;
import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 23/06/17.
 */

public class EmailTabbedFragment extends BaseFragment implements OnRecyclerItemClickListener, EmailTabViewInterface {
	public static final String TAG = "EmailTabbedFragment";
	//widget Declaration
	RecyclerView recycler_view;
	String       title;

	int rowType = 0;

	CommonRecyclerAdapter commonRecyclerAdapter;
	List< Object > listData = new ArrayList<>();

	SwipeRefreshLayout swiperefreshLayout;

	EmailTabPresenter emailTabPresenter;

	public static EmailTabbedFragment newInstance( String title ) {

		Bundle args = new Bundle();
		args.putString( Constants.BundleKeys.TITLE, title );
		EmailTabbedFragment fragment = new EmailTabbedFragment();
		fragment.setArguments( args );
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
		View rootView = inflater.inflate( R.layout.fragment_recyclerview, container, false );
		initView( rootView );

		setLayout( R.layout.fragment_recyclerview );

		setupRecyclerView();

		return rootView;
	}

	@Override
	public void setUserVisibleHint( boolean isVisibleToUser ) {
		super.setUserVisibleHint( isVisibleToUser );
		if ( isVisibleToUser ) {

		}
	}

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );

		emailTabPresenter = new EmailTabPresenter( getActivity(), this );

		Bundle bundle = getArguments();


		if ( bundle != null ) {
			if ( bundle.containsKey( Constants.BundleKeys.TITLE ) ) {
				title = bundle.getString( Constants.BundleKeys.TITLE );
			}
		}
		if ( title.equalsIgnoreCase( Constants.TAB_NOTIFICATION ) ) {
			rowType = Constants.ROW_TEXT;
		}
		else if ( title.equalsIgnoreCase( Constants.TAB_MESSAGE ) ) {
			rowType = Constants.ROW_MESSAGE;
		}
		else if ( title.equalsIgnoreCase( Constants.TAB_MODMAIL ) ) {
			rowType = Constants.ROW_TEXT;
		}
	}

	@Override
	public void onViewCreated( View view, @Nullable Bundle savedInstanceState ) {
		super.onViewCreated( view, savedInstanceState );
	}

	public void initView( View rootView ) {
		recycler_view = ( RecyclerView ) rootView.findViewById( R.id.recycler_view );
		recycler_view.setLayoutManager( new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false ) );
		swiperefreshLayout = ( SwipeRefreshLayout ) rootView.findViewById( R.id.swiperefresh );
		swiperefreshLayout.setOnRefreshListener( new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				refreshContent();
			}
		} );

		emailTabPresenter.getData();
	}

	@Override
	public void setClickListener() {

	}

	private void setupRecyclerView() {
		switch ( rowType ) {
			case Constants.ROW_MESSAGE:
				for ( int i = 0; i < 10; i++ ) {
					listData.add( new ModelMessage( "SIBAPRASADdsdfjs fjhsgdjhfgsd fhjgsdjhf sdjfghsdjf " + i, "SIBAPRASADdsdfjs fjhsgdjhfgsd fhjgsdjhf sdjfghsdjf" + i, Constants.ROW_MESSAGE ) );
				}
				break;
			case Constants.ROW_TEXT:
				for ( int i = 0; i < 10; i++ ) {
					listData.add( new ModelText( "SIBAPRASAD " + i, Constants.ROW_TEXT ) );
				}
				break;
		}
		commonRecyclerAdapter = new CommonRecyclerAdapter( listData, rowType, true, this );
		recycler_view.setAdapter( commonRecyclerAdapter );
	}


	@Override
	public void onCommentClick( Child child ) {

	}

	@Override
	public void onFeedClick( Child child ) {

	}

	@Override
	public void onShareClick( Child child ) {

	}

	@Override
	public void onUpClick( Child child ) {

	}

	@Override
	public void onDownClick( Child child ) {

	}

	private void refreshContent() {
		new Handler().postDelayed( new Runnable() {
			@Override
			public void run() {
				swiperefreshLayout.setRefreshing( false );
			}
		}, 3000 );
	}

	@Override
	public void showError( String error ) {

	}

	@Override
	public void setResult( boolean isSuccess, String message ) {

	}

	@Override
	public void showProgress() {

	}

	@Override
	public void hideProgress() {

	}
}