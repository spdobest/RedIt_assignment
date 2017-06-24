package sptechindia.redit_assignment.ui.account.register.view;

/**
 * Created by sibaprasad on 20/10/16.
 */

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.base.BaseDialogFragment;
import sptechindia.redit_assignment.controllers.LoginRegisterCLickListener;
import sptechindia.redit_assignment.customviews.custom_progressbar.SmoothProgressBar;
import sptechindia.redit_assignment.ui.account.register.presenter.RegisterPresenter;
import sptechindia.redit_assignment.utility.CommonUtils;
import sptechindia.redit_assignment.utility.Constants;

public class SignupDialogFragment extends BaseDialogFragment implements ViewInterface, View.OnClickListener, CommonUtils.SnackbarCallback {

	public static final String TAG = "SignupDialogFragment";

	int fromWhichScreen;


	AppCompatImageView imageViewBackToolbar;

	AppCompatTextView textViewTitleToolbarWithBack;

	Toolbar toolbarWithTitleAndBack;

	AppCompatEditText editTextEmailSignup;

	View viewLineEmailSignup;

	AppCompatEditText editTextPwdSignup;

	View viewLinePwdSignup;

	AppCompatEditText editTextFullNameSignup;

	View viewLineNameSignup;

	AppCompatEditText editTextMobileSignup;

	View viewLineMobileSignup;

	RadioButton radiobuttonFemale;

	RadioButton radiobuttonMale;

	RadioGroup radioGroupGender;

	AppCompatButton buttonSignUp;

	SmoothProgressBar smoothProgressbarSignup;

	LinearLayout linearLayoutRootSignup;

	AppCompatImageView imageViewShare, imageViewSort;

	AppCompatButton            buttonALradyUser;
	// presenter
	RegisterPresenter          registerPresenter;
	// for login and register call back
	LoginRegisterCLickListener loginRegisterCLickListener;
	private Animation animation;

	public static SignupDialogFragment newInstance( int fromWhichScreen, boolean isLoginScreen ) {

		Bundle args = new Bundle();
		args.putInt( Constants.BundleKeys.FROM_WHICH_SCREEN, fromWhichScreen );
		SignupDialogFragment fragmentLogIn = new SignupDialogFragment();
		fragmentLogIn.setArguments( args );
		return fragmentLogIn;
	}

	@Override
	public void onAttach( Context context ) {
		super.onAttach( context );

		try {
			loginRegisterCLickListener = ( LoginRegisterCLickListener ) context;
		}
		catch ( ClassCastException e ) {
			throw new ClassCastException( "AccountActivity must implement OnHeadlineSelectedListener" );
		}

	}

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		animation = AnimationUtils.loadAnimation( getActivity(), R.anim.et_anim );
		registerPresenter = new RegisterPresenter( getActivity(), this );
	}

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
		View rootview = inflater.inflate( R.layout.dialogfragment_signup, container, false );
		setLayout( R.layout.dialogfragment_signup );
		init( rootview );
		return rootview;// super.onCreateView( inflater, container, savedInstanceState );
	}

	private void init( View rootView ) {
		imageViewBackToolbar = ( AppCompatImageView ) rootView.findViewById( R.id.imageViewBackToolbar );
		textViewTitleToolbarWithBack = ( AppCompatTextView ) rootView.findViewById( R.id.textViewTitleToolbarWithBack );
		toolbarWithTitleAndBack = ( Toolbar ) rootView.findViewById( R.id.toolbarWithTitleAndBack );
		editTextEmailSignup = ( AppCompatEditText ) rootView.findViewById( R.id.editTextEmailSignup );
		viewLineEmailSignup = rootView.findViewById( R.id.viewLineEmailSignup );
		editTextPwdSignup = ( AppCompatEditText ) rootView.findViewById( R.id.editTextPwdSignup );
		viewLinePwdSignup = rootView.findViewById( R.id.viewLinePwdSignup );
		editTextFullNameSignup = ( AppCompatEditText ) rootView.findViewById( R.id.editTextFullNameSignup );
		viewLineNameSignup = rootView.findViewById( R.id.viewLineNameSignup );
		editTextMobileSignup = ( AppCompatEditText ) rootView.findViewById( R.id.editTextMobileSignup );
		viewLineMobileSignup = rootView.findViewById( R.id.viewLineMobileSignup );
		radiobuttonFemale = ( RadioButton ) rootView.findViewById( R.id.radiobuttonFemale );
		radiobuttonMale = ( RadioButton ) rootView.findViewById( R.id.radiobuttonMale );
		radioGroupGender = ( RadioGroup ) rootView.findViewById( R.id.radioGroupGender );
		buttonSignUp = ( AppCompatButton ) rootView.findViewById( R.id.buttonSignUp );
		smoothProgressbarSignup = ( SmoothProgressBar ) rootView.findViewById( R.id.smoothProgressbarSignup );
		linearLayoutRootSignup = ( LinearLayout ) rootView.findViewById( R.id.linearLayoutRootSignup );
		buttonALradyUser = ( AppCompatButton ) rootView.findViewById( R.id.buttonALradyUser );

		textViewTitleToolbarWithBack.setText( getString( R.string.signup ) );

		rootView.findViewById( R.id.imageViewShare ).setVisibility( View.GONE );
		rootView.findViewById( R.id.imageViewSort ).setVisibility( View.GONE );


		editTextEmailSignup.setOnFocusChangeListener( new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange( View v, boolean hasFocus ) {
				if ( hasFocus ) {
					viewLineEmailSignup.setBackgroundColor( ContextCompat.getColor( getActivity(), R.color.colorPrimaryDark ) );
					viewLineEmailSignup.setVisibility( View.VISIBLE );
					viewLineEmailSignup.startAnimation( animation );

					viewLinePwdSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
					viewLineEmailSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
					viewLineMobileSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );

				}
				else {
					viewLineEmailSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
				}
			}
		} );

		editTextPwdSignup.setOnFocusChangeListener( new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange( View v, boolean hasFocus ) {
				if ( hasFocus ) {
					viewLinePwdSignup.setBackgroundColor( ContextCompat.getColor( getActivity(), R.color.colorPrimaryDark ) );
					viewLinePwdSignup.setVisibility( View.VISIBLE );
					viewLinePwdSignup.startAnimation( animation );

					viewLineNameSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
					viewLineEmailSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
					viewLineMobileSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );

				}
				else {
					viewLinePwdSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
				}
			}
		} );

		editTextFullNameSignup.setOnFocusChangeListener( new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange( View v, boolean hasFocus ) {
				if ( hasFocus ) {
					viewLineNameSignup.setBackgroundColor( ContextCompat.getColor( getActivity(), R.color.colorPrimaryDark ) );
					viewLineNameSignup.setVisibility( View.VISIBLE );
					viewLineNameSignup.startAnimation( animation );

					viewLinePwdSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
					viewLineEmailSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
					viewLineMobileSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
				}
				else {
					viewLineNameSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
				}
			}
		} );

		editTextMobileSignup.setOnFocusChangeListener( new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange( View v, boolean hasFocus ) {
				if ( hasFocus ) {
					viewLineMobileSignup.setBackgroundColor( ContextCompat.getColor( getActivity(), R.color.colorPrimaryDark ) );
					viewLineMobileSignup.setVisibility( View.VISIBLE );
					viewLineMobileSignup.startAnimation( animation );

					viewLinePwdSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
					viewLineEmailSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
					viewLineNameSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
				}
				else {
					viewLineMobileSignup.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
				}
			}
		} );

		// set click listener to views
		buttonSignUp.setOnClickListener( this );
		buttonALradyUser.setOnClickListener( this );
		imageViewBackToolbar.setOnClickListener( this );

	}

	@Override
	public void showError( int type ) {
		switch ( type ) {
			case Constants.ErrorType.INVALID_EMAIL:
				CommonUtils.showSnackBar( linearLayoutRootSignup, "Invalid Email Id", Snackbar.LENGTH_LONG );
				break;
			case Constants.ErrorType.INVALID_NAME:
				CommonUtils.showSnackBar( linearLayoutRootSignup, "Invalid Name", Snackbar.LENGTH_LONG );
				break;
			case Constants.ErrorType.INVALID_PASSWORD:
				CommonUtils.showSnackBar( linearLayoutRootSignup, "Invalid Password, Minimum length is 6", Snackbar.LENGTH_LONG );
				break;
			case Constants.ErrorType.NO_INTERNET_CONNECTION:
				CommonUtils.showSnackBar( this, linearLayoutRootSignup, "No Internet Connection", "Retry", Snackbar.LENGTH_INDEFINITE );
				break;
		}
	}

	@Override
	public void showProgress( String message ) {
		smoothProgressbarSignup.setVisibility( View.VISIBLE );
	}

	@Override
	public void validate() {

	}

	@Override
	public void setResult( boolean isSuccess, String message ) {
		dismiss();
		loginRegisterCLickListener.onLoginClick();
	}

	@Override
	public void onClick( View view ) {
		switch ( view.getId() ) {
			case R.id.imageViewBackToolbar:
				dismiss();
				break;
			case R.id.buttonALradyUser:
				dismiss();
				loginRegisterCLickListener.onLoginClick();
				break;
			case R.id.buttonSignUp:
				registerPresenter.validate( editTextFullNameSignup.getText().toString().trim(), editTextEmailSignup.getText().toString().trim(), editTextPwdSignup.getText().toString().trim(), editTextMobileSignup.getText().toString().trim() );
				break;
		}
	}

	@Override
	public void onSnackbarActionClick() {
		registerPresenter.validate( editTextFullNameSignup.getText().toString().trim(), editTextEmailSignup.getText().toString().trim(), editTextPwdSignup.getText().toString().trim(), editTextMobileSignup.getText().toString().trim() );
	}
}
