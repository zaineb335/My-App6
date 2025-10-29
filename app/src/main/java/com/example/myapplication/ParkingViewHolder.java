package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ParkingViewHolder extends RecyclerView.ViewHolder {
        TextView nomPark;

    public ParkingViewHolder(@NonNull View itemView) {
        super(itemView);
        nomPark=itemView.findViewById(R.id.nomPa);
    }


    public void setNomPark(Parking p) {
            nomPark.setText(p.getNomP());
        }
}
