package sptechindia.redit_assignment.ui.home.homeTab.presenter;

import java.util.List;

import sptechindia.redit_assignment.model.home.Child;

/**
 * Created by sibaprasad on 23/06/17.
 */

public interface HomeTabPresenterInterface {
	public void showProgress();
	public void getData();
	public void setData( List<Child> listChild );
	public void showError(String message);
}
