package com.example.weatherpagination.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherpagination.R;
import com.example.weatherpagination.model.Data;
import com.example.weatherpagination.utilits.ImageProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IconLeftViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image_item_icon)
    ImageView mWeatherIcon;

    @BindView(R.id.text_view_item_date)
    TextView mTextDate;

    @BindView(R.id.text_view_item_weather_description)
    TextView mTextWeatherType;

    @BindView(R.id.text_view_Item_temp_max)
    TextView mTextTempMax;

    @BindView(R.id.text_view_Item_temp_min)
    TextView mTextTempMin;

    public IconLeftViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void updateUi(Data data){
        
        mWeatherIcon.setImageResource(ImageProvider.getDailyWeatherImagesId(data));

        mTextWeatherType.setText(data.getWeatherType());
        mTextDate.setText("Monday");
        mTextTempMax.setText(String.valueOf(data.getTempMax()));
        mTextTempMin.setText(String.valueOf(data.getTempMin()));
    }

}
