package sptechindia.redit_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sptechindia.redit_assignment.controllers.LoginRegisterCLickListener;
import sptechindia.redit_assignment.ui.account.login.view.LoginDialogFragment;
import sptechindia.redit_assignment.ui.account.register.view.SignupDialogFragment;
import sptechindia.redit_assignment.ui.home.HomeActivity;

public class AccountActivity extends AppCompatActivity implements LoginRegisterCLickListener{

	@Bind( R.id.textViewSkipNow )
	AppCompatTextView textViewSkipNow;
	@Bind( R.id.buttonLogin_welcome )
	AppCompatButton   buttonLoginWelcome;
	@Bind( R.id.buttonRegister_welcome )
	AppCompatButton   buttonRegisterWelcome;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_account );
		ButterKnife.bind( this );
	}

	@OnClick( { R.id.textViewSkipNow, R.id.buttonLogin_welcome, R.id.buttonRegister_welcome } )
	public void onClick( View view ) {
		switch ( view.getId() ) {
			case R.id.textViewSkipNow:
				startActivity( new Intent( AccountActivity.this, HomeActivity.class ) );
				finish();
				break;
			case R.id.buttonLogin_welcome:
				onLoginClick();
				break;
			case R.id.buttonRegister_welcome:
				onRegisterClick();
				break;
		}
	}

	@Override
	public void onLoginClick() {
		LoginDialogFragment.newInstance( 1 ).show( getSupportFragmentManager(), LoginDialogFragment.TAG );
	}

	@Override
	public void onRegisterClick() {
		SignupDialogFragment.newInstance( 1, false ).show( getSupportFragmentManager(), SignupDialogFragment.TAG );
	}
}
