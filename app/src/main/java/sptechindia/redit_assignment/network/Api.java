package sptechindia.redit_assignment.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import sptechindia.redit_assignment.model.AccessToken;
import sptechindia.redit_assignment.model.home.Child;


public interface Api {


	//https://www.reddit.com/api/v1/access_token
	@POST("/access_token")
	Call<AccessToken > getAccessToken();

    @GET("/.json")
    public List<Child > getArticle();


}