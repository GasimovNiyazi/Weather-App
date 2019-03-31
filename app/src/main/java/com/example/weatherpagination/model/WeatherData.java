package com.example.weatherpagination.model;


import com.google.gson.annotations.SerializedName;

public class WeatherData {

    @SerializedName("timezone")
    private String mLocation;
    @SerializedName("currently")
    private CurrentWeatherData mCurrentWeatherData;
    @SerializedName("daily")
    private DailyWeatherData  mDailyWeatherData;

    public CurrentWeatherData getCurrentWeatherData() {
        return mCurrentWeatherData;
    }

    public DailyWeatherData getDailyWeatherData() {
        return mDailyWeatherData;
    }

    public String getLocation() {
        return mLocation;
    }

}
