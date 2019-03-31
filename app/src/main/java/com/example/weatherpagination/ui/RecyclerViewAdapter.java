package com.example.weatherpagination.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.weatherpagination.R;
import com.example.weatherpagination.model.Data;


import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<Data> mDataList;

    public RecyclerViewAdapter(Context context, List<Data> dataList) {
        mContext = context;
        mDataList = dataList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view;
                view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_daily_weather,viewGroup,false);
                return new IconLeftViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        IconLeftViewHolder holder=(IconLeftViewHolder)viewHolder;
        holder.updateUi(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return  mDataList.size();
    }
}
