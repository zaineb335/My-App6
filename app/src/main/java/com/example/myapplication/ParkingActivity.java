package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class ParkingActivity extends Activity {
private List<String> liste;

    public static RecyclerView lstP;
    public static String selectPark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
        Resources res = getResources();
        String[] nomVs= res.getStringArray(R.array.nomVs);

        liste=new ArrayList<String>();
        for (int i = 0; i < nomVs.length; i++) {
            liste.add(nomVs[i]);
        }
        RecyclerView lstVille=findViewById(R.id.lville);
        lstVille.setLayoutManager(new LinearLayoutManager(this));
        lstVille.setAdapter(new VilleAdapter(getApplicationContext(), liste));
        ParkingActivity.lstP=findViewById(R.id.lPark);



    }
    public void envoyer(View btn){

        String nomP=ParkingActivity.selectPark;
        Intent in=new Intent(this, PlaceActivity.class);
        in.putExtra("nom",nomP);
        if (!nomP.equals("")){
            startActivity(in);
        }
    }

}