package com.example.weatherpagination.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private final static String BASE_URL="https://api.darksky.net/";


    private  static Retrofit sRetrofit;

    public static Retrofit getRetrofitInstance(){

        if (sRetrofit == null) {
            sRetrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
 return sRetrofit;
    }

}
