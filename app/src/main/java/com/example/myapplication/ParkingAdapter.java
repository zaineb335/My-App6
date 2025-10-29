package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ParkingAdapter extends RecyclerView.Adapter<ParkingViewHolder> {
    Context context;
    List<Parking> liste;
    public ParkingAdapter(Context con, List<Parking> lst){
        this.context=con;
        this.liste=lst;
    }
    @NonNull
    @Override
    public ParkingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ParkingViewHolder(LayoutInflater.from(context).inflate(R.layout.parking,parent,false));
    }
    int selectedPosition = -1;
    int initCol=0;
    int lastSelectedPosition = -1;
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ParkingViewHolder holder, int position) {
        Parking p=liste.get(position);
        holder.setNomPark(p);
        if (selectedPosition == holder.getAdapterPosition()) {
            holder.itemView.setBackgroundColor(R.color.purple_200);
        } else {
            holder.itemView.setBackgroundColor(initCol);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                initCol=holder.itemView.getDrawingCacheBackgroundColor();
                lastSelectedPosition = selectedPosition;
                selectedPosition = holder.getAdapterPosition();
                notifyItemChanged(lastSelectedPosition);
                notifyItemChanged(selectedPosition);
                ParkingActivity.selectPark=p.getNomP();

            }
        });

    }


    @Override
    public int getItemCount() {
        return liste.size();
    }
}
