package sptechindia.redit_assignment.ui.account.register.interactor;

import android.content.Context;
import android.os.Handler;

import sptechindia.redit_assignment.ui.account.register.presenter.RegisterPresenterInterface;

/**
 * Created by sibaprasad on 21/06/17.
 */

public class RegisterInteractor implements RegisterInteractorInterface {

	Context                    context;
	RegisterPresenterInterface registerPresenterInterface;

	public RegisterInteractor( Context context, RegisterPresenterInterface loginPresenterInterface ) {
		this.context = context;
		this.registerPresenterInterface = loginPresenterInterface;
	}

	@Override
	public void doRegister( String name,String emailId, String password,String mobileNumber  ) {
		registerPresenterInterface.showProgress( "Please Wait..." );
		new Handler().postDelayed( new Runnable() {
			@Override
			public void run() {
				registerPresenterInterface.setResult( true,"Register  Successfully" );
			}
		}, 3000 );
	}
}
