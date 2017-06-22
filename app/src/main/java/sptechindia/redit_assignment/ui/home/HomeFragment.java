package sptechindia.redit_assignment.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.base.BaseFragment;
import sptechindia.redit_assignment.ui.adapter.HomePagerAdapter;
import sptechindia.redit_assignment.ui.home.homeTab.HomeTabbedFragment;
import sptechindia.redit_assignment.ui.home.popular.PopularTabbedFragment;

/**
 * Created by sibaprasad on 22/06/17.
 */

public class HomeFragment extends BaseFragment {

	public static final String TAG = "HomeFragment";

	//
	View         rootView;
	AppBarLayout appbarLayoutHome;
	Toolbar      toolbarHome;
	TabLayout    tabLayoutHome;
	ViewPager    viewpagerHome;


	// other class declaration
	HomePagerAdapter homePagerAdapter;


	public static HomeFragment newInstance() {

		Bundle args = new Bundle();

		HomeFragment fragment = new HomeFragment();
		fragment.setArguments( args );
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
		rootView = inflater.inflate( R.layout.fragment_home, container, false );

		initView( rootView );

		setLayout( R.layout.fragment_home );

		return rootView;
	}

	@Override
	public void initView( View rootView ) {
		appbarLayoutHome = ( AppBarLayout ) rootView.findViewById( R.id.appbarLayoutHome );
		toolbarHome = ( Toolbar ) rootView.findViewById( R.id.toolbarHome );
		tabLayoutHome = ( TabLayout ) rootView.findViewById( R.id.tabLayoutHome );
		viewpagerHome = ( ViewPager ) rootView.findViewById( R.id.viewpagerHome );

		// define all click listener here
		setClickListener();

		setupViewPager( viewpagerHome );
	}

	@Override
	public void setClickListener() {

	}

	private void setupViewPager( ViewPager viewPager ) {
		homePagerAdapter = new HomePagerAdapter( getActivity().getSupportFragmentManager() );
		homePagerAdapter.addFragment( new HomeTabbedFragment(), "Home" );
		homePagerAdapter.addFragment( new PopularTabbedFragment(), "Popular" );
		viewPager.setAdapter( homePagerAdapter );
		tabLayoutHome.setupWithViewPager( viewPager );
	}
}
