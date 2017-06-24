package sptechindia.redit_assignment.ui.home.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.adapter.CommonPagerAdapter;
import sptechindia.redit_assignment.base.BaseFragment;
import sptechindia.redit_assignment.ui.profile.AccountTabbedFragment;
import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 22/06/17.
 */

public class ProfileFragment extends BaseFragment {

	private static final String TAG = "ProfileFragment";

	//rootview
	View                    rootView;
	CommonPagerAdapter      commonPagerAdapter;
	TabLayout               tabProfile;
	Toolbar                 toolbarProfile;
	CollapsingToolbarLayout collapse_toolbar;
	FloatingActionButton    fabProfile;
	ViewPager               pagerProfile;

	public static ProfileFragment newInstance() {

		Bundle args = new Bundle();

		ProfileFragment fragment = new ProfileFragment();
		fragment.setArguments( args );
		return fragment;
	}

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
	}

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
		rootView = inflater.inflate( R.layout.fragment_profile, container, false );
		setLayout( R.layout.fragment_popular );
		initView( rootView );
		setClickListener();
		return rootView;
	}

	@Override
	public void initView( View rootView ) {

		tabProfile = ( TabLayout ) rootView.findViewById( R.id.tabProfile );
		toolbarProfile = ( Toolbar ) rootView.findViewById( R.id.toolbarProfile );
		collapse_toolbar = ( CollapsingToolbarLayout ) rootView.findViewById( R.id.collapse_toolbar );
		fabProfile = ( FloatingActionButton ) rootView.findViewById( R.id.fabProfile );
		pagerProfile = ( ViewPager ) rootView.findViewById( R.id.pagerProfile );


		setUpTabs();
	}

	@Override
	public void setClickListener() {

	}

	void setUpTabs() {
		commonPagerAdapter = new CommonPagerAdapter( getActivity().getSupportFragmentManager() );
		commonPagerAdapter.addFragment( AccountTabbedFragment.newInstance( Constants.TAB_POSTS ), "POSTS" );
		commonPagerAdapter.addFragment( AccountTabbedFragment.newInstance( Constants.TAB_COMMENTS ), "COMMENTS" );
		commonPagerAdapter.addFragment( AccountTabbedFragment.newInstance( Constants.TAB_ABOUT ), "ABOUT" );

//		commonPagerAdapter.addFragment( PostFragment.newInstance(), "POSTS" );
//		commonPagerAdapter.addFragment( CommentFragment.newInstance(), "COMMENTS" );
//		commonPagerAdapter.addFragment( AboutFragment.newInstance(), "ABOUT" );


		pagerProfile.setAdapter( commonPagerAdapter );
		tabProfile.setupWithViewPager( pagerProfile );
	}
}
