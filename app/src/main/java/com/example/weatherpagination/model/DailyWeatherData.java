package com.example.weatherpagination.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DailyWeatherData{

   @SerializedName("data")
    private List<Data> mData=new ArrayList<>();

    public List<Data> getData() {
        return mData;
    }
}
