package sptechindia.redit_assignment.ui.profile.presenter;

/**
 * Created by sibaprasad on 24/06/17.
 */

public interface ProfilePresenterInterface {
	void showError(String error);
	void setResult(boolean isSuccess,String message);
	void showProgress();
	void getData();
	void hideProgress();
}
