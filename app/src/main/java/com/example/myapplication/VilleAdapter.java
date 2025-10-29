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

public class VilleAdapter extends RecyclerView.Adapter<VilleViewHolder> {
    Context context;
    List<String> liste;
    public VilleAdapter(Context con, List<String> lst){
        this.context=con;
        this.liste=lst;
    }
    @NonNull
    @Override
    public VilleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VilleViewHolder(LayoutInflater.from(context).inflate(R.layout.ville,parent,false));
    }
    int selectedPosition = -1;
    int lastSelectedPosition = -1;
    int initCol=0;
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull VilleViewHolder holder, int position) {
        String nomV=liste.get(position);
        holder.setNomVille(nomV);
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
                //holder.itemView.setBackgroundColor(R.color.purple_200);
                Resources res = context.getResources();
                String[] nomPs= res.getStringArray(R.array.nomPark);
                ArrayList<Parking> listP=new ArrayList<Parking>();
                for (int i = 0; i < nomPs.length; i++) {
                    String[] prm=nomPs[i].split("[|]");
                    if (prm[1].equals(nomV)) {
                        listP.add(new Parking(prm[0], prm[1]));
                    }
                }
                ParkingActivity.lstP.setLayoutManager(new LinearLayoutManager(context));
                ParkingActivity.lstP.setAdapter(new ParkingAdapter(context, listP));


            }
        });

    }

    @Override
    public int getItemCount() {
        return liste.size();
    }
}
