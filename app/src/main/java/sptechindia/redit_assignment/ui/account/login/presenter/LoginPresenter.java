package sptechindia.redit_assignment.ui.account.login.presenter;

import android.content.Context;
import android.text.TextUtils;

import sptechindia.redit_assignment.ui.account.login.interactor.LoginInteractor;
import sptechindia.redit_assignment.ui.account.login.view.ViewInterface;
import sptechindia.redit_assignment.utility.CommonUtils;
import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 21/06/17.
 */

public class LoginPresenter implements LoginPresenterInterface {

	Context         context;
	ViewInterface   viewInterface;
	LoginInteractor loginInteractor;

	LoginPresenter( Context mContext, ViewInterface mViewInterface ) {
		this.context = mContext;
		this.viewInterface = mViewInterface;
		loginInteractor = new LoginInteractor( context, this );
	}

	@Override
	public void showError( int type ) {

	}

	@Override
	public void showProgress( String message ) {

	}

	@Override
	public void validate( String emailId, String password ) {

		if ( CommonUtils.isInternetAvailable( context ) ) {
			if ( !CommonUtils.isValidEmail( emailId ) ) {
				viewInterface.showError( Constants.ErrorType.INVALID_EMAIL );
			}
			else if ( TextUtils.isEmpty( password ) && password.length() < 6 ) {
				viewInterface.showError( Constants.ErrorType.INVALID_PASSWORD );
			}
			else {
				loginInteractor.doLogin( emailId, password );
			}
		}
		else {
			viewInterface.showError( Constants.ErrorType.NO_INTERNET_CONNECTION );
		}

	}

	@Override
	public void setResult( boolean isSuccess, String message ) {
		viewInterface.setResult( isSuccess, message );
	}
}
