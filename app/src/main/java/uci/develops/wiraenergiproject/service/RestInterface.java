package uci.develops.wiraenergiproject.service;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import uci.develops.wiraenergiproject.response.LoginResponse;
import uci.develops.wiraenergiproject.response.RegisterResponse;

/**
 * Created by ArahitoPC on 10/17/2016.
 */
public interface RestInterface {

    @FormUrlEncoded
    @POST("auth/login")
    Call<LoginResponse> Login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/register")
    Call<RegisterResponse> Register(@Field("name") String name, @Field("email") String email, @Field("password") String password);
}
