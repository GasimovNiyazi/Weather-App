package com.example.weatherpagination.api;

import com.example.weatherpagination.model.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherService {

    @GET("forecast/{Id}/{cord}")
    Call<WeatherData> getWeatherData(@Path("Id") String appId, @Path("cord") String cordinates);

}
