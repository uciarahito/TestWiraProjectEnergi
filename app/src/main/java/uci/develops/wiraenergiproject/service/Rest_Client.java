package uci.develops.wiraenergiproject.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ArahitoPC on 10/17/2016.
 */
public class Rest_Client {
    public static RestInterface Rest_Client;
    public static String URL = "http://api.wiraenergi.co.id/";

    static {
        setRestClient();
    }

    private Rest_Client(){}
    public static RestInterface getRestClient(){ return Rest_Client; }

    private static void setRestClient(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        Rest_Client = retrofit.create(RestInterface.class);
    }
}
