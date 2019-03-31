package com.example.weatherpagination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherpagination.api.RetrofitInstance;
import com.example.weatherpagination.api.WeatherService;
import com.example.weatherpagination.model.Data;
import com.example.weatherpagination.model.WeatherData;
import com.example.weatherpagination.ui.RecyclerViewAdapter;
import com.example.weatherpagination.utilits.ImageProvider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private final static String APP_ID="390f04b894ad4ede0ba506c11fefdc2d";
    private final static String CORD="40.409264,49.867092";

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.text_view_temp_min)
    TextView mTempMin;

    @BindView(R.id.text_view_temp_max)
    TextView mTempMax;

    @BindView(R.id.text_view_city)
    TextView mCityName;

    @BindView(R.id.text_view_weather_description)
    TextView mWeatherType;

    @BindView(R.id.image_weather)
    ImageView mWeatherIcon;

   private LinearLayoutManager mLayoutManager;
   private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_wb_sunny_24dp);

        getWeatherData();


    }

    private void getWeatherData() {

        Retrofit retrofit=RetrofitInstance.getRetrofitInstance();
        WeatherService service=retrofit.create(WeatherService.class);

        Call<WeatherData> call =service.getWeatherData(APP_ID,CORD);

        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                if (!response.isSuccessful()){
                    Log.v("Response","Code :"+response.code());
                }

                WeatherData weatherData=response.body();
                List<Data> data =weatherData.getDailyWeatherData().getData();

                mCityName.setText(weatherData.getLocation());
                mTempMax.setText(String.valueOf(weatherData.getCurrentWeatherData().getCurrentTempMax()));
                mTempMin.setText(String.valueOf(weatherData.getCurrentWeatherData().getCurrentTempMin()));
                mWeatherType.setText(weatherData.getCurrentWeatherData().getCurrentWeatherType());

                mWeatherIcon.setImageResource(ImageProvider.getCurrentWeatherImagesId(weatherData.getCurrentWeatherData()));

                initRecyclerView(data);

            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {

                Log.v("Failure",t.getMessage());

            }
        });

    }

    private void initRecyclerView(List<Data> data) {
        mAdapter=new RecyclerViewAdapter(this,data);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
