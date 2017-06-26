package sptechindia.redit_assignment.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.base.BaseFragment;
import sptechindia.redit_assignment.network.ApiService;
import sptechindia.redit_assignment.ui.home.cominities.CommunitiesFragment;
import sptechindia.redit_assignment.ui.home.email.EmailFragment;
import sptechindia.redit_assignment.ui.home.profile.ProfileFragment;
import sptechindia.redit_assignment.utility.CommonUtils;
import sptechindia.redit_assignment.utility.Constants;
import sptechindia.redit_assignment.utility.FragmentUtils;

import static android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE;

/**
 * Created by sibaprasad on 21/06/17.
 */

public class HomeActivity extends AppCompatActivity implements BaseFragment.ToolbarListener, CommonUtils.SnackbarCallback {

	public static final String TAG = "HomeActivity";

	FragmentUtils fragmentUtils;
	@Bind( R.id.containerHome )
	FrameLayout        containerHome;
	@Bind( R.id.imageViewHomeTab1 )
	AppCompatImageView imageViewHomeTab1;
	@Bind( R.id.imageViewHomeTab2 )
	AppCompatImageView imageViewHomeTab2;
	@Bind( R.id.imageViewHomeTab3 )
	AppCompatImageView imageViewHomeTab3;
	@Bind( R.id.imageViewHomeTab4 )
	AppCompatImageView imageViewHomeTab4;
	@Bind( R.id.main_content )
	CoordinatorLayout  mainContent;

	ApiService apiService;
	Fragment   homeFragment;

	@Override
	public void onBackPressed() {

		Fragment fragment = getSupportFragmentManager().findFragmentById( R.id.containerHome );

		if ( fragment instanceof HomeFragment ) {
			super.onBackPressed();
		}
		else {
			loadHomeFragment();
		}


	}

	@Override
	protected void onCreate( @Nullable Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_home );

		ButterKnife.bind( this );

		fragmentUtils = new FragmentUtils( this );
		apiService = new ApiService();

		changeBottomTabIconColor( Constants.BottomTab.TAB_HOME );


		getSupportFragmentManager().beginTransaction().replace( R.id.containerHome, HomeFragment.newInstance(), HomeFragment.TAG ).commit();


	}

	@OnClick( { R.id.imageViewHomeTab1, R.id.imageViewHomeTab2, R.id.imageViewHomeTab3, R.id.imageViewHomeTab4 } )
	public void onClick( View view ) {
		switch ( view.getId() ) {
			case R.id.imageViewHomeTab1:
				loadHomeFragment();
				break;
			case R.id.imageViewHomeTab2:
				changeBottomTabIconColor( Constants.BottomTab.TAB_COMMUNITIES );
				getSupportFragmentManager().beginTransaction().setTransition( TRANSIT_FRAGMENT_FADE ).replace( R.id.containerHome, CommunitiesFragment.newInstance(), CommunitiesFragment.TAG ).addToBackStack( null ).commit();
				break;
			case R.id.imageViewHomeTab3:
				changeBottomTabIconColor( Constants.BottomTab.TAB_EMAIL );
				getSupportFragmentManager().beginTransaction().setTransition( TRANSIT_FRAGMENT_FADE ).replace( R.id.containerHome, EmailFragment.newInstance(), EmailFragment.TAG ).addToBackStack( null ).commit();
				break;
			case R.id.imageViewHomeTab4:
				changeBottomTabIconColor( Constants.BottomTab.TAB_PROFILE );
				getSupportFragmentManager().beginTransaction().setTransition( TRANSIT_FRAGMENT_FADE ).replace( R.id.containerHome, ProfileFragment.newInstance(), ProfileFragment.TAG ).addToBackStack( null ).commit();
				break;
		}
	}

	@Override
	public void setToolbarTitle( String title ) {

	}

	@Override
	public void setToolbarVisibility( int value ) {

	}

	@Override
	public void setToolbar() {

	}

	private void changeBottomTabIconColor( int tabPoaition ) {

		imageViewHomeTab1.setImageDrawable( ContextCompat.getDrawable( this, R.drawable.ic_home ) );
		imageViewHomeTab2.setImageDrawable( ContextCompat.getDrawable( this, R.drawable.ic_communities ) );
		imageViewHomeTab3.setImageDrawable( ContextCompat.getDrawable( this, R.drawable.ic_email ) );
		imageViewHomeTab4.setImageDrawable( ContextCompat.getDrawable( this, R.drawable.ic_account ) );

		switch ( tabPoaition ) {
			case Constants.BottomTab.TAB_HOME:
				imageViewHomeTab1.setImageDrawable( ContextCompat.getDrawable( this, R.drawable.ic_home_selected ) );
				break;
			case Constants.BottomTab.TAB_COMMUNITIES:
				imageViewHomeTab2.setImageDrawable( ContextCompat.getDrawable( this, R.drawable.ic_communities_selected ) );
				break;
			case Constants.BottomTab.TAB_EMAIL:
				imageViewHomeTab3.setImageDrawable( ContextCompat.getDrawable( this, R.drawable.ic_email_selected ) );
				break;
			case Constants.BottomTab.TAB_PROFILE:
				imageViewHomeTab4.setImageDrawable( ContextCompat.getDrawable( this, R.drawable.ic_account_selected ) );
				break;
		}
	}


	private void loadHomeFragment() {

		if ( homeFragment == null ) {
			homeFragment = HomeFragment.newInstance();
		}
		else {
			homeFragment = getSupportFragmentManager().findFragmentByTag( HomeFragment.TAG );
		}

		changeBottomTabIconColor( Constants.BottomTab.TAB_HOME );
		getSupportFragmentManager().beginTransaction().setTransition( TRANSIT_FRAGMENT_FADE )
				.replace( R.id.containerHome, homeFragment, HomeFragment.TAG ).addToBackStack( null ).commit();

	}

	@Override
	public void onSnackbarActionClick() {

	}


}
