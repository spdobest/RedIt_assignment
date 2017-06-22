package sptechindia.redit_assignment.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor( new ReditInterceptor() {
            } )
            .build();

   /* private static OkHttpClient httpClientWIthoutToken = new OkHttpClient.Builder()
            .addInterceptor(new IntereceptorWithoutAccessToken())
            .build();*/

    private static Retrofit retrofit;

    public static <S> S createService(Class<S> serviceClass) {
        retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory( GsonConverterFactory.create())
                .client(httpClient)
                .build();
        return retrofit.create(serviceClass);
    }

   /* public static <S> S createServiceWithoutAccessToken(Class<S> serviceClass) {
        retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientWIthoutToken)
                .build();
        return retrofit.create(serviceClass);
    }*/

}