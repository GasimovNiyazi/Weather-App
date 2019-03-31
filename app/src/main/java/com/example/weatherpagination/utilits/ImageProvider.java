package com.example.weatherpagination.utilits;



import com.example.weatherpagination.R;
import com.example.weatherpagination.model.CurrentWeatherData;
import com.example.weatherpagination.model.Data;


public class ImageProvider {



    public static int getDailyWeatherImagesId(Data data){
        switch (data.getWeatherType()){

            case "cloudy":
                return R.drawable.ic_wb_cloudy_24dp;
            case "partly-cloudy-day":
                return R.drawable.ic_partly_cloudy;
            case "sunny":
            case "clear-day":
                return R.drawable.ic_wb_sunny_24dp;
            case "snowy":
               return R.drawable.ic_ac_snowy_24dp;
            default:
                return R.drawable.ic_wb_cloudy_24dp;

        }

    }
    public static int getCurrentWeatherImagesId(CurrentWeatherData data){
        switch (data.getCurrentWeatherType()){

            case "cloudy":
                return R.drawable.ic_wb_cloudy_24dp;
            case "partly-cloudy-day":
                return R.drawable.ic_partly_cloudy;
            case "sunny":
            case "clear-day":
                return R.drawable.ic_wb_sunny_24dp;
            case "snowy":
                return R.drawable.ic_ac_snowy_24dp;
            default:
                return R.drawable.ic_wb_cloudy_24dp;

        }

    }
}
