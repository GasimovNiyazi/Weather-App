package com.example.weatherpagination.model;

import com.google.gson.annotations.SerializedName;

public class Data{

    @SerializedName("icon")
    private String mWeatherType;
    @SerializedName("temperatureMax")
    private Double mTempMax;
    @SerializedName("temperatureMin")
    private Double mTempMin;

    public String getWeatherType() {
        return mWeatherType;
    }

    public Integer getTempMax() {
        return mTempMax.intValue();
    }

    public Integer getTempMin() {
        return mTempMin.intValue();
    }
}
