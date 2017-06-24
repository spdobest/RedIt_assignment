package sptechindia.redit_assignment.ui.home.homeTab.presenter;

import android.content.Context;
import android.util.Log;

import java.util.List;

import sptechindia.redit_assignment.model.home.Child;
import sptechindia.redit_assignment.ui.home.homeTab.interactor.HomeTabInteractor;
import sptechindia.redit_assignment.ui.home.homeTab.view.HomeTabViewInterface;
import sptechindia.redit_assignment.utility.CommonUtils;

/**
 * Created by sibaprasad on 23/06/17.
 */
public class HomeTabPresenter implements HomeTabPresenterInterface {

	private static final String TAG = "HomeTabPresenter";

	HomeTabViewInterface popularViewInterface;
	Context              context;
	HomeTabInteractor    popularInteractor;

	public HomeTabPresenter( Context context, HomeTabViewInterface popularPresenterInterface ) {
		this.popularViewInterface = popularPresenterInterface;
		this.context = context;
		popularInteractor = new HomeTabInteractor( context, this );
	}

	@Override
	public void showProgress() {
		popularViewInterface.showProgress();
	}

	@Override
	public void getData() {
		if ( CommonUtils.isInternetAvailable( context ) ) {
			popularInteractor.getData();
		}
		else {
			popularViewInterface.showError( "No Internet Connection" );
		}
	}

	@Override
	public void setData(  List<Child>   listChild ) {
		Log.i( TAG, "setData: "+listChild );
		popularViewInterface.getData( listChild );
	}

	@Override
	public void showError( String message ) {
		popularViewInterface.showError( message );
	}

}
