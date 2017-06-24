package sptechindia.redit_assignment.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.adapter.CommonPagerAdapter;
import sptechindia.redit_assignment.base.BaseFragment;
import sptechindia.redit_assignment.ui.home.homeTab.HomeTabbedFragment;
import sptechindia.redit_assignment.utility.CommonUtils;
import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 22/06/17.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {

	public static final String TAG = "HomeFragment";

	//widgets declaration
	View              rootView;
	AppBarLayout      appbarLayoutHome;
	Toolbar           toolbarHome;
	TabLayout         tabLayoutHome;
	ViewPager         viewpagerHome;
	AppCompatTextView textViewTitleTOolbarHome;


	// other class declaration
	CommonPagerAdapter homePagerAdapter;
	CoordinatorLayout  coordinateLayoutActionRoot, main_content;
	FloatingActionButton fabMain, fab1, fab2, fab3;
	LinearLayout llAction1, llAction2, llAction3;
	RotateAnimation rotateLeft, rotateRight;
	private Animation fabOpenAnimation;
	private Animation fabCloseAnimation;
	private boolean isFabMenuOpen = false;

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
		getAnimations();
		return rootView;
	}

	@Override
	public void initView( View rootView ) {
		appbarLayoutHome = ( AppBarLayout ) rootView.findViewById( R.id.appbarLayoutHome );
		toolbarHome = ( Toolbar ) rootView.findViewById( R.id.toolbarHome );
		tabLayoutHome = ( TabLayout ) rootView.findViewById( R.id.tabLayoutHome );
		viewpagerHome = ( ViewPager ) rootView.findViewById( R.id.viewpagerHome );
		textViewTitleTOolbarHome = ( AppCompatTextView ) rootView.findViewById( R.id.textViewTitleTOolbarHome );
		main_content = ( CoordinatorLayout ) rootView.findViewById( R.id.main_content );
		coordinateLayoutActionRoot = ( CoordinatorLayout ) rootView.findViewById( R.id.coordinateLayoutActionRoot );
		fabMain = ( FloatingActionButton ) rootView.findViewById( R.id.fabMain );
		llAction1 = ( LinearLayout ) rootView.findViewById( R.id.llAction1 );
		llAction2 = ( LinearLayout ) rootView.findViewById( R.id.llAction2 );
		llAction3 = ( LinearLayout ) rootView.findViewById( R.id.llAction3 );
		fab1 = ( FloatingActionButton ) rootView.findViewById( R.id.fab1 );
		fab2 = ( FloatingActionButton ) rootView.findViewById( R.id.fab2 );
		fab3 = ( FloatingActionButton ) rootView.findViewById( R.id.fab3 );
		fabMain.setOnClickListener( this );
		main_content.setOnClickListener( this );
		coordinateLayoutActionRoot.setOnClickListener( this );
		llAction1.setOnClickListener( this );
		llAction2.setOnClickListener( this );
		llAction3.setOnClickListener( this );

		// define all click listener here
		setClickListener();
		toolbarHome.setTitle( " Red It " );

		setupViewPager( viewpagerHome );
	}

	@Override
	public void setClickListener() {

	}

	private void setupViewPager( ViewPager viewPager ) {
		homePagerAdapter = new CommonPagerAdapter( getActivity().getSupportFragmentManager() );
		homePagerAdapter.addFragment( HomeTabbedFragment.newInstance( Constants.TAB_HOME ), Constants.TAB_HOME );
		homePagerAdapter.addFragment( HomeTabbedFragment.newInstance( Constants.TAB_POPULAR ), Constants.TAB_POPULAR );
		viewPager.setAdapter( homePagerAdapter );
		tabLayoutHome.setupWithViewPager( viewPager );
	}

	private void getAnimations() {

		fabOpenAnimation = AnimationUtils.loadAnimation( getActivity(), R.anim.fab_open );

		fabCloseAnimation = AnimationUtils.loadAnimation( getActivity(), R.anim.fab_close );

		rotateLeft = new RotateAnimation( 0, 90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f );
		rotateLeft.setDuration( 200 );
		rotateLeft.setInterpolator( new LinearInterpolator() );

		rotateRight = new RotateAnimation( 90
				, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f );
		rotateRight.setDuration( 200 );
		rotateRight.setInterpolator( new LinearInterpolator() );

	}

	private void expandFabMenu() {
		coordinateLayoutActionRoot.setVisibility( View.VISIBLE );


		fabMain.startAnimation( rotateRight );

		llAction1.startAnimation( fabOpenAnimation );
		llAction2.startAnimation( fabOpenAnimation );
		llAction3.startAnimation( fabOpenAnimation );

		llAction1.setClickable( true );
		llAction2.setClickable( true );
		llAction3.setClickable( true );

		isFabMenuOpen = true;


	}

	private void collapseFabMenu() {

		coordinateLayoutActionRoot.setVisibility( View.GONE );
		fabMain.startAnimation( rotateLeft );

		llAction1.startAnimation( fabCloseAnimation );
		llAction2.startAnimation( fabCloseAnimation );
		llAction1.setClickable( false );
		llAction2.setClickable( false );

		llAction3.startAnimation( fabCloseAnimation );
		llAction3.setClickable( false );
		isFabMenuOpen = false;

	}

	@Override
	public void onClick( View view ) {
		switch ( view.getId() ) {
			case R.id.fabMain:
				if ( isFabMenuOpen ) {
					collapseFabMenu();
				}
				else {
					expandFabMenu();
				}
				break;
			case R.id.coordinateLayoutActionRoot:
				collapseFabMenu();
				break;
			case R.id.llAction1:
				CommonUtils.showSnackBar( main_content, "Feed Add Action", Snackbar.LENGTH_SHORT );
				break;
			case R.id.llAction2:
				CommonUtils.showSnackBar( main_content, "Feed Remove Action", Snackbar.LENGTH_SHORT );
				break;
			case R.id.llAction3:
				CommonUtils.showSnackBar( main_content, "Feed Suscribe Action", Snackbar.LENGTH_SHORT );
				break;

		}
	}
}
