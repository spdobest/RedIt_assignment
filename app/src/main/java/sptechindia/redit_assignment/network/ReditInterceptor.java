package sptechindia.redit_assignment.network;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import sptechindia.redit_assignment.utility.NetworkUtil;

public class ReditInterceptor implements Interceptor {

	private String TAG = "Interceptor";

	@Override
	public Response intercept( Chain chain ) throws IOException {

		Log.i( TAG, "intercepting request" );
		Request         original       = chain.request();
		boolean         isFree         = Boolean.parseBoolean( original.headers().get( "isFree" ) );
		Request.Builder requestBuilder = original.newBuilder();
		requestBuilder.removeHeader( "isFree" );
		if ( !( NetworkUtil.accessToke.isEmpty() ) ) {
			String token = NetworkUtil.accessToke;
			requestBuilder.header( "Authorization", "Bearer " + token );
		}
		Request request = requestBuilder.build();
		return chain.proceed( request );
	}
}