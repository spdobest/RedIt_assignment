package sptechindia.redit_assignment.ui.account.login.interactor;

import android.content.Context;

import sptechindia.redit_assignment.ui.account.login.presenter.LoginPresenterInterface;

/**
 * Created by sibaprasad on 21/06/17.
 */

public class LoginInteractor implements LoginInteractorInterface {

	Context                 context;
	LoginPresenterInterface loginPresenterInterface;

	public LoginInteractor( Context context, LoginPresenterInterface loginPresenterInterface ) {
		this.context = context;
		this.loginPresenterInterface = loginPresenterInterface;
	}

	@Override
	public void doLogin( String email, String password ) {
		loginPresenterInterface.showProgress( "Please Wait..." );



	}
}
