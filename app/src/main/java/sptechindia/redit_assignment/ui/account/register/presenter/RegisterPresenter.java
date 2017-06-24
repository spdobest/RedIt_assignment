package sptechindia.redit_assignment.ui.account.register.presenter;

import android.content.Context;
import android.text.TextUtils;

import sptechindia.redit_assignment.ui.account.register.interactor.RegisterInteractor;
import sptechindia.redit_assignment.ui.account.register.view.ViewInterface;
import sptechindia.redit_assignment.utility.CommonUtils;
import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 21/06/17.
 */

public class RegisterPresenter implements RegisterPresenterInterface {

	Context            context;
	ViewInterface      viewInterface;
	RegisterInteractor loginInteractor;

	public RegisterPresenter( Context mContext, ViewInterface mViewInterface ) {
		this.context = mContext;
		this.viewInterface = mViewInterface;
		loginInteractor = new RegisterInteractor( context, this );
	}

	@Override
	public void showError( int type ) {

	}

	@Override
	public void showProgress( String message ) {

	}

	@Override
	public void validate( String name,String emailId, String password,String mobileNumber  ) {

		if ( CommonUtils.isInternetAvailable( context ) ) {
			if ( !CommonUtils.isValidEmail( emailId ) ) {
				viewInterface.showError( Constants.ErrorType.INVALID_EMAIL );
			}
			else if ( TextUtils.isEmpty( password ) && password.length() < 6 ) {
				viewInterface.showError( Constants.ErrorType.INVALID_PASSWORD );
			}
			/*else if ( TextUtils.isEmpty( mobileNumber ) && mobileNumber.length() < 10 ) {
				viewInterface.showError( Constants.ErrorType.INVALID_MOBILE );
			}*/
			else if ( TextUtils.isEmpty( name )  ) {
				viewInterface.showError( Constants.ErrorType.INVALID_NAME );
			}
			else {
				loginInteractor.doRegister( name,emailId, password,mobileNumber );
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
