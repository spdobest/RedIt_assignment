package sptechindia.redit_assignment.ui.home.email.presenter;

import android.content.Context;

import sptechindia.redit_assignment.ui.home.email.interactor.EmailTabInteractor;
import sptechindia.redit_assignment.ui.home.email.view.EmailTabViewInterface;
import sptechindia.redit_assignment.utility.CommonUtils;

/**
 * Created by sibaprasad on 24/06/17.
 */

public class EmailTabPresenter implements EmailTabPresenterInterface {

	Context               context;
	EmailTabViewInterface profileViewInterface;
	EmailTabInteractor    profileInteractor;

	public EmailTabPresenter( Context context, EmailTabViewInterface profileViewInterface ) {
		this.context = context;
		this.profileViewInterface = profileViewInterface;
		profileInteractor = new EmailTabInteractor( context, this );
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
