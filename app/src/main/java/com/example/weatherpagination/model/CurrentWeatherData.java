package com.example.weatherpagination.model;

import com.google.gson.annotations.SerializedName;

public class CurrentWeatherData {

@SerializedName("icon")
    private String mCurrentWeatherType;
@SerializedName("temperature")
    private Double mCurrentTempMax;
@SerializedName("apparentTemperature")
    private Double mCurrentTempMin;

    public String getCurrentWeatherType() {
        return mCurrentWeatherType;
    }

    public Integer getCurrentTempMax() {
        return mCurrentTempMax.intValue();
    }

    public Integer getCurrentTempMin() {
        return mCurrentTempMin.intValue();
    }
}
