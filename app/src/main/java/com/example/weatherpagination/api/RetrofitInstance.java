package com.example.weatherpagination.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private final static String BASE_URL="https://api.darksky.net/";

     private  static HttpLoggingInterceptor mLoggingInterceptor=new HttpLoggingInterceptor();


    private  static Retrofit sRetrofit;

    public static Retrofit getRetrofitInstance(){

        mLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(mLoggingInterceptor)
                .build();

        if (sRetrofit == null) {
            sRetrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
 return sRetrofit;
    }

}
