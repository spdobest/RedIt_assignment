package sptechindia.redit_assignment.ui.home.email.view;

/**
 * Created by sibaprasad on 24/06/17.
 */

public interface EmailTabViewInterface {
	void showError( String error );
	void setResult( boolean isSuccess, String message );
	void showProgress();
	void hideProgress();
}
