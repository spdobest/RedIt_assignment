package sptechindia.redit_assignment.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
	private static final String ROOT_URL = "http://www.reddit.com";


	private static OkHttpClient httpClient = new OkHttpClient.Builder()
			.connectTimeout( 20, TimeUnit.SECONDS )
			.writeTimeout( 20, TimeUnit.SECONDS )
			.readTimeout( 20, TimeUnit.SECONDS )
			.addInterceptor( new ReditInterceptor() )
			.build();


	private static Retrofit retrofit;

	public static < S > S createService( Class< S > serviceClass ) {

		retrofit = new Retrofit.Builder()
				.baseUrl( ROOT_URL )
				.addConverterFactory( GsonConverterFactory.create() )
				.client( httpClient )
				.build();
		return retrofit.create( serviceClass );
	}


}