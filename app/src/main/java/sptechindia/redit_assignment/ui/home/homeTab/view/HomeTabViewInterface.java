package sptechindia.redit_assignment.ui.home.homeTab.view;

import java.util.List;

import sptechindia.redit_assignment.model.home.Child;

/**
 * Created by sibaprasad on 23/06/17.
 */

public interface HomeTabViewInterface {
	void showProgress();
	void getData( List<Child>  listChild );
	public void showError(String message);
	void hideProgress();
}
