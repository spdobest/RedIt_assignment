package sptechindia.redit_assignment.ui.account.login.view;

import sptechindia.redit_assignment.BaseInterface;

/**
 * Created by sibaprasad on 21/06/17.
 */

public interface ViewInterface extends BaseInterface {
	void validate();
	void setResult(boolean isSuccess,String message);
}
