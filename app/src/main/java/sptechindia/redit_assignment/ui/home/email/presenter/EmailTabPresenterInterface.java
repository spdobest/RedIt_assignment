package sptechindia.redit_assignment.ui.home.email.presenter;

/**
 * Created by sibaprasad on 24/06/17.
 */

public interface EmailTabPresenterInterface {
	void showError( String error );
	void setResult( boolean isSuccess, String message );
	void showProgress();
	void getData();
	void hideProgress();
}
