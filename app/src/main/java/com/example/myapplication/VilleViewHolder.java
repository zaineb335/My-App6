package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VilleViewHolder extends RecyclerView.ViewHolder {
    TextView nomVille;



    public VilleViewHolder(@NonNull View itemView) {
        super(itemView);
        nomVille=itemView.findViewById(R.id.nomV);
    }



    public void setNomVille(String nom) {
        nomVille.setText(nom);
    }
}
