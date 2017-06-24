package sptechindia.redit_assignment.ui.home.homeTab.interactor;

import android.content.Context;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sptechindia.redit_assignment.model.home.Child;
import sptechindia.redit_assignment.model.home.ModelParent;
import sptechindia.redit_assignment.network.Api;
import sptechindia.redit_assignment.network.ApiService;
import sptechindia.redit_assignment.ui.home.homeTab.presenter.HomeTabPresenterInterface;
import sptechindia.redit_assignment.utility.CommonUtils;


/**
 * Created by sibaprasad on 23/06/17.
 */

public class HomeTabInteractor implements HomeTabInteractorInterface {

	private static final String TAG = "HomeTabInteractor";

	HomeTabPresenterInterface popularPresenterInterface;
	Context                   context;

	public HomeTabInteractor( Context context, HomeTabPresenterInterface popularPresenterInterface ) {
		this.popularPresenterInterface = popularPresenterInterface;
		this.context = context;
	}

	@Override
	public void getData() {

		popularPresenterInterface.showProgress();

			Api                       client = ApiService.createService( Api.class );//.createService( ApiService.class);
			final Call< ModelParent > call   = client.getAllFeeds();
			call.enqueue( new Callback< ModelParent >() {
				@Override
				public void onResponse( Call< ModelParent > call, final Response< ModelParent > response ) {
					Log.i( TAG, "Response Code: " + response.code() + " \n " + response.body() );

					ModelParent   modelParent = response.body();
					List< Child > childList   = modelParent.getData().getChildren();
					Log.i( TAG, "onResponse: " + modelParent );
					if ( response.isSuccessful() ) {
						popularPresenterInterface.setData( childList );
					}
				}

				@Override
				public void onFailure( Call< ModelParent > call, Throwable t ) {
					Log.i( TAG, "Request Failed " + t.getMessage() );
					//	getData();
				}
			} );

	}
}
