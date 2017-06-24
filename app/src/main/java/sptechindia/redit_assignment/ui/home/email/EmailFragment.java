package sptechindia.redit_assignment.ui.home.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.adapter.CommonPagerAdapter;
import sptechindia.redit_assignment.base.BaseFragment;
import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 22/06/17.
 */

public class EmailFragment extends BaseFragment implements View.OnClickListener {

	public static final String TAG = "EmailFragment";


	//widgets declaration
	View rootView;

	AppBarLayout      appbarLayoutHome;
	Toolbar           toolbarHome;
	TabLayout         tabLayoutHome;
	ViewPager         viewpagerHome;
	AppCompatTextView textViewTitleTOolbarHome;


	// other class declaration
	CommonPagerAdapter emailpagerAdapter;

	private BottomSheetDialog bottomSheetDialog;

	public static EmailFragment newInstance() {
		Bundle        args     = new Bundle();
		EmailFragment fragment = new EmailFragment();
		fragment.setArguments( args );
		return fragment;
	}

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		// sortNames = getResources().getStringArray( R.array.profileTabnemes );
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
		textViewTitleTOolbarHome = ( AppCompatTextView ) rootView.findViewById( R.id.textViewTitleTOolbarHome );


		tabLayoutHome = ( TabLayout ) rootView.findViewById( R.id.tabLayoutHome );
		appbarLayoutHome = ( AppBarLayout ) rootView.findViewById( R.id.appbarLayoutHome );
		viewpagerHome = ( ViewPager ) rootView.findViewById( R.id.viewpagerHome );

		toolbarHome.setVisibility( View.GONE );

		// define all click listener here
		setClickListener();
		setupViewPager( viewpagerHome );


	}

	@Override
	public void setClickListener() {

	}

	@Override
	public void onClick( View view ) {
		switch ( view.getId() ) {
			case R.id.imageViewSort:

				break;
		}
	}

	private void setupViewPager( ViewPager viewPager ) {
		emailpagerAdapter = new CommonPagerAdapter( getChildFragmentManager() );

		emailpagerAdapter.addFragment( EmailTabbedFragment.newInstance( Constants.TAB_NOTIFICATION ), Constants.TAB_NOTIFICATION );
		emailpagerAdapter.addFragment( EmailTabbedFragment.newInstance( Constants.TAB_MESSAGE ), Constants.TAB_MESSAGE );
		emailpagerAdapter.addFragment( EmailTabbedFragment.newInstance( Constants.TAB_MODMAIL ), Constants.TAB_MODMAIL );
		viewPager.setAdapter( emailpagerAdapter );
		tabLayoutHome.setupWithViewPager( viewPager );
	}
}
