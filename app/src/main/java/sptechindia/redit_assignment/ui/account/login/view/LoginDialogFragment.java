package sptechindia.redit_assignment.ui.account.login.view;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.base.BaseDialogFragment;
import sptechindia.redit_assignment.controllers.LoginRegisterCLickListener;
import sptechindia.redit_assignment.customviews.custom_progressbar.SmoothProgressBar;
import sptechindia.redit_assignment.ui.account.login.presenter.LoginPresenter;
import sptechindia.redit_assignment.ui.home.HomeActivity;
import sptechindia.redit_assignment.utility.CommonUtils;
import sptechindia.redit_assignment.utility.Constants;
import sptechindia.redit_assignment.utility.Debug;


public class LoginDialogFragment extends BaseDialogFragment implements View.OnClickListener, ViewInterface, CommonUtils.SnackbarCallback {


	public static final String TAG = "LoginDialogFragment";

	// for bottomsheet
	TextInputLayout   textinputlayoutForgotPwd;
	AppCompatEditText edittextEmailForgotPwd;
	AppCompatButton   buttonResetForgotPwd;
	ProgressBar       progressBarForgotPwd;

	// for login and register call back
	LoginRegisterCLickListener loginRegisterCLickListener;


	AppCompatImageView imageViewBackToolbar;

	AppCompatTextView textViewTitleToolbarWithBack;

	Toolbar toolbarWithTitleAndBack;

	AppCompatEditText editTextEmailSignIn;

	View viewLineEmailSignIn;

	AppCompatEditText editTextPwdSignIn;

	View viewLinePwdSignIn;

	AppCompatButton buttonSignInMain;

	SmoothProgressBar smoothProgressbar;

	AppCompatTextView textViewForgotPwdLogin;

	AppCompatTextView textViewSignUp;

	RelativeLayout relativeRootSignin;
	Animation      animation;
	LoginPresenter loginPresenter;
	// for forgot password bottom sheet
	private BottomSheetDialog mBottomSheetDialog;

	public static LoginDialogFragment newInstance( int fromWhichScreen ) {
		Bundle args = new Bundle();
		args.putInt( Constants.BundleKeys.FROM_WHICH_SCREEN, fromWhichScreen );
		LoginDialogFragment fragmentLogIn = new LoginDialogFragment();
		fragmentLogIn.setArguments( args );
		Debug.showLog( TAG, "From Screen " + fromWhichScreen );
		return fragmentLogIn;
	}

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		animation = AnimationUtils.loadAnimation( getActivity(), R.anim.et_anim );
		loginPresenter = new LoginPresenter( getActivity(), this );
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

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
		View rootview = inflater.inflate( R.layout.dialogfragment_login, container, false );
		setLayout( R.layout.dialogfragment_login );
		init( rootview );

		return rootview;
	}

	private void init( View rootview ) {
		imageViewBackToolbar = ( AppCompatImageView ) rootview.findViewById( R.id.imageViewBackToolbar );
		toolbarWithTitleAndBack = ( Toolbar ) rootview.findViewById( R.id.toolbarWithTitleAndBack );
		editTextEmailSignIn = ( AppCompatEditText ) rootview.findViewById( R.id.editTextEmailSignIn );
		viewLineEmailSignIn = rootview.findViewById( R.id.viewLineEmailSignIn );
		editTextPwdSignIn = ( AppCompatEditText ) rootview.findViewById( R.id.editTextPwdSignIn );
		viewLinePwdSignIn = rootview.findViewById( R.id.viewLinePwdSignIn );
		buttonSignInMain = ( AppCompatButton ) rootview.findViewById( R.id.buttonSignInMain );
		smoothProgressbar = ( SmoothProgressBar ) rootview.findViewById( R.id.smoothProgressbar );
		textViewForgotPwdLogin = ( AppCompatTextView ) rootview.findViewById( R.id.textViewForgotPwdLogin );
		textViewSignUp = ( AppCompatTextView ) rootview.findViewById( R.id.textViewSignUp );
		relativeRootSignin = ( RelativeLayout ) rootview.findViewById( R.id.relativeRootSignin );
		textViewTitleToolbarWithBack = ( AppCompatTextView ) rootview.findViewById( R.id.textViewTitleToolbarWithBack );

		rootview.findViewById( R.id.imageViewShare ).setVisibility( View.GONE );
		rootview.findViewById( R.id.imageViewSort ).setVisibility( View.GONE );


		buttonSignInMain.setOnClickListener( this );
		textViewForgotPwdLogin.setOnClickListener( this );
		textViewSignUp.setOnClickListener( this );

		editTextEmailSignIn.setOnFocusChangeListener( new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange( View v, boolean hasFocus ) {
				if ( hasFocus ) {
					viewLineEmailSignIn.setBackgroundColor( ContextCompat.getColor( getActivity(), R.color.colorPrimaryDark ) );
					viewLineEmailSignIn.setVisibility( View.VISIBLE );
					viewLineEmailSignIn.startAnimation( animation );
					viewLinePwdSignIn.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
				}
				else {
					viewLineEmailSignIn.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
				}
			}
		} );

		editTextPwdSignIn.setOnFocusChangeListener( new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange( View v, boolean hasFocus ) {
				if ( hasFocus ) {
					viewLinePwdSignIn.setBackgroundColor( ContextCompat.getColor( getActivity(), R.color.colorPrimaryDark ) );
					viewLinePwdSignIn.setVisibility( View.VISIBLE );
					viewLinePwdSignIn.startAnimation( animation );
					viewLineEmailSignIn.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
				}
				else {
					viewLinePwdSignIn.setBackgroundColor( Color.parseColor( "#d3d3d3" ) );
				}
			}
		} );

		textViewTitleToolbarWithBack.setText( "Login" );
		imageViewBackToolbar.setOnClickListener( this );

	}

	private void showBottomSheetForgotPwd( final String email ) {

		if ( mBottomSheetDialog == null ) {
			mBottomSheetDialog = new BottomSheetDialog( getActivity() );
		}
		//similar
		mBottomSheetDialog.setContentView( R.layout.bottomsheet_forgotpwd );
		textinputlayoutForgotPwd = ( TextInputLayout ) mBottomSheetDialog.findViewById( R.id.textinputlayoutForgotPwd );
		edittextEmailForgotPwd = ( AppCompatEditText ) mBottomSheetDialog.findViewById( R.id.edittextEmailForgotPwd );
		buttonResetForgotPwd = ( AppCompatButton ) mBottomSheetDialog.findViewById( R.id.buttonResetForgotPwd );
		progressBarForgotPwd = ( ProgressBar ) mBottomSheetDialog.findViewById( R.id.progressBarForgotPwd );

		edittextEmailForgotPwd.setText( email );

		buttonResetForgotPwd.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick( View view ) {
				if ( CommonUtils.isValidEmail( edittextEmailForgotPwd.getText().toString().trim() ) ) {
					textinputlayoutForgotPwd.setError( "Invalid Email" );
				}
				else {
					buttonResetForgotPwd.setVisibility( View.INVISIBLE );
					progressBarForgotPwd.setVisibility( View.VISIBLE );
					new Handler().postDelayed( new Runnable() {
						@Override
						public void run() {
							buttonResetForgotPwd.setVisibility( View.VISIBLE );
							progressBarForgotPwd.setVisibility( View.INVISIBLE );
							mBottomSheetDialog.dismiss();
							CommonUtils.showSnackBar(  relativeRootSignin, "Password Reset Successfully" , Snackbar.LENGTH_SHORT );
						}
					}, 1000 );
				}
			}
		} );

		mBottomSheetDialog.show();
	}


	public void onClick( View view ) {
		switch ( view.getId() ) {
			case R.id.buttonSignInMain:
				loginPresenter.validate( editTextEmailSignIn.getText().toString().trim(), editTextPwdSignIn.getText().toString().trim() );
				break;
			case R.id.buttonResetForgotPwd:
				showBottomSheetForgotPwd( editTextEmailSignIn.getText().toString().trim() );
				break;
			case R.id.textViewSignUp:
				dismiss();
				loginRegisterCLickListener.onRegisterClick();
				break;
			case R.id.imageViewBackToolbar:
				dismiss();
				break;
			case R.id.textViewForgotPwdLogin:
				showBottomSheetForgotPwd( editTextEmailSignIn.getText().toString().trim() );
				break;
		}
	}


	@Override
	public void showError( int type ) {
		switch ( type ) {
			case Constants.ErrorType.INVALID_EMAIL:
				CommonUtils.showSnackBar( relativeRootSignin, "Invalid Email Id", Snackbar.LENGTH_LONG );
				break;
			case Constants.ErrorType.INVALID_PASSWORD:
				CommonUtils.showSnackBar( relativeRootSignin, "Invalid Password, Minimum length is 6", Snackbar.LENGTH_LONG );
				break;
			case Constants.ErrorType.NO_INTERNET_CONNECTION:
				CommonUtils.showSnackBar( this, relativeRootSignin, "No Internet Connection", "Retry", Snackbar.LENGTH_INDEFINITE );
				break;
		}
	}

	@Override
	public void showProgress( String message ) {
		relativeRootSignin.setEnabled( false );
		smoothProgressbar.setVisibility( View.VISIBLE );
	}

	@Override
	public void validate() {

	}

	@Override
	public void setResult( boolean isSuccess, String message ) {
		relativeRootSignin.setEnabled( true );
		smoothProgressbar.setVisibility( View.GONE );
		if ( isSuccess ) {
			Intent intentHome = new Intent( getActivity(), HomeActivity.class );
			startActivity( intentHome );
			getActivity().finish();
		}
		else {
			CommonUtils.showSnackBar( this, relativeRootSignin, "Server Error", "Retry", Snackbar.LENGTH_INDEFINITE );
		}
	}

	@Override
	public void onSnackbarActionClick() {
		loginPresenter.validate( editTextEmailSignIn.getText().toString().trim(), editTextPwdSignIn.getText().toString().trim() );
	}
}
