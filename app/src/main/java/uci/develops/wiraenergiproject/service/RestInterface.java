package uci.develops.wiraenergiproject.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import uci.develops.wiraenergiproject.response.LoginResponse;

/**
 * Created by ArahitoPC on 10/17/2016.
 */
public interface RestInterface {

    @GET("login/{email}/{password}")
    Call<LoginResponse> Login(@Path("email") String email, @Path("password") String password);
}
