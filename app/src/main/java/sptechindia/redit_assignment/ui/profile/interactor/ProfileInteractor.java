package sptechindia.redit_assignment.ui.profile.interactor;

import android.content.Context;
import android.os.Handler;

import sptechindia.redit_assignment.ui.profile.presenter.ProfilePresenterInterface;

/**
 * Created by sibaprasad on 24/06/17.
 */

public class ProfileInteractor implements ProfileInteractorInterface {

	Context                   context;
	ProfilePresenterInterface profilePresenterInterface;

	public ProfileInteractor( Context context, ProfilePresenterInterface profilePresenterInterface ) {
		this.context = context;
		this.profilePresenterInterface = profilePresenterInterface;
	}

	@Override
	public void getData() {


		new Handler().postDelayed( new Runnable() {
			@Override
			public void run() {
				profilePresenterInterface.setResult( true, "result" );
			}
		}, 3000 );
	}
}
