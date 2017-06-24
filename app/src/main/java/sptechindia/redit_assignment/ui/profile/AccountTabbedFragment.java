package sptechindia.redit_assignment.ui.profile;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
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
import sptechindia.redit_assignment.ui.profile.presenter.ProfilePresenter;
import sptechindia.redit_assignment.ui.profile.view.ProfileViewInterface;
import sptechindia.redit_assignment.utility.CommonUtils;
import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 22/06/17.
 */

public class AccountTabbedFragment extends BaseFragment implements ProfileViewInterface, OnRecyclerItemClickListener {

	private static final String TAG = "AccountTabbedFragment";

	View         rootView;
	RecyclerView recycler_view;

	String tabTitle;
	int    rowType;

	CommonRecyclerAdapter commonRecyclerAdapter;
	List< Object > listData = new ArrayList<>();

	SwipeRefreshLayout swiperefresh;


	ProfilePresenter profilePresenter;

	public static AccountTabbedFragment newInstance( String tabTitle ) {

		Bundle args = new Bundle();
		args.putString( Constants.BundleKeys.TAB_TITLE, tabTitle );
		AccountTabbedFragment fragment = new AccountTabbedFragment();
		fragment.setArguments( args );
		return fragment;
	}


	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		Bundle bundle = getArguments();
		if ( bundle != null ) {
			if ( bundle.containsKey( Constants.BundleKeys.TAB_TITLE ) ) {
				tabTitle = bundle.getString( Constants.BundleKeys.TAB_TITLE );
			}
		}

		profilePresenter = new ProfilePresenter( getActivity(), this );

		if ( tabTitle.equalsIgnoreCase( Constants.TAB_POSTS ) ) {
			rowType = Constants.ROW_IMAGE;
		}
		else if ( tabTitle.equalsIgnoreCase( Constants.TAB_COMMENTS ) ) {
			rowType = Constants.ROW_MESSAGE;
		}
		else if ( tabTitle.equalsIgnoreCase( Constants.TAB_ABOUT ) ) {
			rowType = Constants.ROW_IMAGE_WITH_TEXT;
		}

	}

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
		rootView = inflater.inflate( R.layout.fragment_recyclerview, container, false );
		setLayout( R.layout.fragment_recyclerview );
		initView( rootView );
		//	setClickListener();
		return rootView;
	}

	@Override
	public void onViewCreated( View view, @Nullable Bundle savedInstanceState ) {
		super.onViewCreated( view, savedInstanceState );

	 profilePresenter.getData();
	}

	@Override
	public void initView( View rootView ) {
		recycler_view = ( RecyclerView ) rootView.findViewById( R.id.recycler_view );
		recycler_view.setLayoutManager( new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false ) );

		swiperefresh = ( SwipeRefreshLayout ) rootView.findViewById( R.id.swiperefresh );
		setUPList();

		swiperefresh.setOnRefreshListener( new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				refreshContent();
			}
		} );
	}

	@Override
	public void setClickListener() {

	}

	private void setupRecyclerView() {
		switch ( rowType ) {

			case Constants.ROW_IMAGE:
				for ( int i = 0; i < 10; i++ ) {
					listData.add( new ModelMessage( "SIBAPRASADdsdfjs fjhsgdjhfgsd fhjgsdjhf sdjfghsdjf " + i, "SIBAPRASADdsdfjs fjhsgdjhfgsd fhjgsdjhf sdjfghsdjf" + i, Constants.ROW_TEXT ) );
				}
				break;

			case Constants.ROW_MESSAGE:
				for ( int i = 0; i < 10; i++ ) {
					listData.add( new ModelMessage( "SIBAPRASADdsdfjs fjhsgdjhfgsd fhjgsdjhf sdjfghsdjf " + i, "SIBAPRASADdsdfjs fjhsgdjhfgsd fhjgsdjhf sdjfghsdjf" + i, Constants.ROW_TEXT ) );
				}
				break;
			case Constants.ROW_TEXT:
				for ( int i = 0; i < 10; i++ ) {
					listData.add( new ModelText( "SIBAPRASAD " + i, Constants.ROW_TEXT ) );
				}
				break;
			case Constants.ROW_IMAGE_WITH_TEXT:
				for ( int i = 0; i < 10; i++ ) {
					listData.add( new ModelMessage( "SIBAPRASADdsdfjs fjhsgdjhfgsd fhjgsdjhf sdjfghsdjf " + i, "SIBAPRASADdsdfjs fjhsgdjhfgsd fhjgsdjhf sdjfghsdjf" + i, Constants.ROW_TEXT ) );
				}
				break;
		}

		commonRecyclerAdapter.notifyDataSetChanged();

	}

	void setUPList() {
		commonRecyclerAdapter = new CommonRecyclerAdapter( listData, rowType, true, this );
		recycler_view.setAdapter( commonRecyclerAdapter );
		setupRecyclerView();
	}

	@Override
	public void showError( String error ) {
		CommonUtils.showSnackBar( swiperefresh, error, Snackbar.LENGTH_SHORT );
	}

	@Override
	public void setResult( boolean isSuccess, String message ) {
		CommonUtils.showSnackBar( swiperefresh, message, Snackbar.LENGTH_SHORT );
	}

	@Override
	public void showProgress() {
		showProgress();
	}

	@Override
	public void hideProgress() {
		hideProgressBar();
	}

	private void refreshContent() {
		profilePresenter.getData();
		new Handler().postDelayed( new Runnable() {
			@Override
			public void run() {

			}
		}, 3000 );
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
}
