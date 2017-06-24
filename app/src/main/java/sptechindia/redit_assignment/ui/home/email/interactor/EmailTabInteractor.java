package sptechindia.redit_assignment.ui.home.email.interactor;

import android.content.Context;
import android.os.Handler;

import sptechindia.redit_assignment.ui.home.email.presenter.EmailTabPresenterInterface;

/**
 * Created by sibaprasad on 24/06/17.
 */

public class EmailTabInteractor implements EmailTabInteractorInterface {

	Context                    context;
	EmailTabPresenterInterface profilePresenterInterface;

	public EmailTabInteractor( Context context, EmailTabPresenterInterface profilePresenterInterface ) {
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
