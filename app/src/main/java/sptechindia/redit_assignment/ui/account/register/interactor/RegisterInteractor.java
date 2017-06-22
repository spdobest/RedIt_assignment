package sptechindia.redit_assignment.ui.account.register.interactor;

import android.content.Context;

import sptechindia.redit_assignment.ui.account.register.presenter.RegisterPresenterInterface;

/**
 * Created by sibaprasad on 21/06/17.
 */

public class RegisterInteractor implements RegisterInteractorInterface {

	Context                    context;
	RegisterPresenterInterface loginPresenterInterface;

	public RegisterInteractor( Context context, RegisterPresenterInterface loginPresenterInterface ) {
		this.context = context;
		this.loginPresenterInterface = loginPresenterInterface;
	}

	@Override
	public void doRegister( String name,String emailId, String password,String mobileNumber  ) {
		loginPresenterInterface.showProgress( "Please Wait..." );



	}
}
