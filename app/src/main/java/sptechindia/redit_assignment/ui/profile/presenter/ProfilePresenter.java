package sptechindia.redit_assignment.ui.profile.presenter;

import android.content.Context;

import sptechindia.redit_assignment.ui.profile.interactor.ProfileInteractor;
import sptechindia.redit_assignment.ui.profile.view.ProfileViewInterface;
import sptechindia.redit_assignment.utility.CommonUtils;

/**
 * Created by sibaprasad on 24/06/17.
 */

public class ProfilePresenter implements ProfilePresenterInterface {

	Context              context;
	ProfileViewInterface profileViewInterface;
	ProfileInteractor    profileInteractor;

	public ProfilePresenter( Context context, ProfileViewInterface profileViewInterface ) {
		this.context = context;
		this.profileViewInterface = profileViewInterface;
		profileInteractor = new ProfileInteractor( context, this );
	}

	@Override
	public void showError( String error ) {
		profileViewInterface.showError( error );
	}

	@Override
	public void setResult( boolean isSuccess, String message ) {
		profileViewInterface.setResult( isSuccess, message );
	}

	@Override
	public void showProgress() {
		profileViewInterface.showProgress();
	}

	@Override
	public void getData() {
		if ( CommonUtils.isInternetAvailable( context ) ) {
			profileInteractor.getData();
		}
		else {
			profileViewInterface.showError( "No Internet Connection" );
		}
	}

	@Override
	public void hideProgress() {
		profileViewInterface.hideProgress();
	}
}
