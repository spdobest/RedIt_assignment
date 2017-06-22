package sptechindia.redit_assignment.ui.account.register.presenter;

import sptechindia.redit_assignment.BaseInterface;

/**
 * Created by sibaprasad on 21/06/17.
 */

public interface RegisterPresenterInterface extends BaseInterface{
	void validate( String name,String emailId, String password,String mobileNumber );
	void setResult( boolean isSuccess, String message );
}
