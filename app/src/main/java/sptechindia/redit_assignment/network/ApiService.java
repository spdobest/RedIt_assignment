package sptechindia.redit_assignment.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static final String ROOT_URL = "https://www.reddit.com";

	private static OkHttpClient httpClient = new OkHttpClient.Builder()
			.addInterceptor(new ReditInterceptor())
			.build();

	private static Retrofit retrofit;

	public static <S> S createService(Class<S> serviceClass) {
		retrofit = new Retrofit.Builder()
				.baseUrl( ROOT_URL)
				.addConverterFactory( GsonConverterFactory.create())
				.client(httpClient)
				.build();
		return retrofit.create(serviceClass);
	}


}