package sptechindia.redit_assignment.ui.account.login.view;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.base.BaseDialogFragment;
import sptechindia.redit_assignment.ui.home.HomeActivity;
import sptechindia.redit_assignment.utility.CommonUtils;
import sptechindia.redit_assignment.utility.Constants;
import sptechindia.redit_assignment.utility.Debug;


public class LoginDialogFragment extends BaseDialogFragment implements View.OnClickListener {


	public static final String TAG = "LoginDialogFragment";
	TextInputLayout   textinputlayoutForgotPwd;
	AppCompatEditText edittextEmailForgotPwd;
	AppCompatButton   buttonResetForgotPwd;
	ProgressBar       progressBarForgotPwd;


	AppCompatEditText edittextEmailLogin;
	TextInputLayout   tilEMailId;
	AppCompatEditText edittextPasswordLogin;
	TextInputLayout   tilEPwdId;
	AppCompatButton   buttonLogin;
	AppCompatButton   buttonForgotPassword;
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

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
		View rootview = inflater.inflate( R.layout.dialogfragment_login, container, false );
		setLayout( R.layout.dialogfragment_login );
		init( rootview );
		return rootview;// super.onCreateView( inflater, container, savedInstanceState );
	}


	private void init( View rootview ) {
		edittextEmailLogin = ( AppCompatEditText ) rootview.findViewById( R.id.edittextEmailLogin );
		tilEMailId = ( TextInputLayout ) rootview.findViewById( R.id.tilEMailId );

		edittextPasswordLogin = ( AppCompatEditText ) rootview.findViewById( R.id.edittextPasswordLogin );
		tilEPwdId = ( TextInputLayout ) rootview.findViewById( R.id.tilEPwdId );
		buttonLogin = ( AppCompatButton ) rootview.findViewById( R.id.buttonLogin );
		buttonForgotPassword = ( AppCompatButton ) rootview.findViewById( R.id.buttonForgotPassword );

		buttonLogin.setOnClickListener( this );
		buttonForgotPassword.setOnClickListener( this );
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
						}
					}, 1000 );
				}
			}
		} );

		mBottomSheetDialog.show();
	}


	public void onClick( View view ) {
		switch ( view.getId() ) {
			case R.id.buttonLogin:
				startActivity( new Intent( getActivity(), HomeActivity.class ) );
				getActivity().finish();
				break;
			case R.id.buttonForgotPassword:
				showBottomSheetForgotPwd( edittextEmailLogin.getText().toString().trim() );
				break;
		}
	}
}
