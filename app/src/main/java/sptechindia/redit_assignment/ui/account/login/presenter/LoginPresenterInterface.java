package sptechindia.redit_assignment.ui.account.login.presenter;

import sptechindia.redit_assignment.BaseInterface;

/**
 * Created by sibaprasad on 21/06/17.
 */

public interface LoginPresenterInterface   extends BaseInterface{
	void validate(String emailId,String password);
	void setResult(boolean isSuccess,String message);
}
