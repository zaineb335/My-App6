package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onLogin(View btn){
        EditText user=findViewById(R.id.edt1);
        EditText password=findViewById(R.id.edt2);
        if (user.getText().toString().equals("")==false && password.getText().toString().equals("")==false) {
            Intent inte = new Intent(this, ParkingActivity.class);
            startActivity(inte);
        } else  {
            System.out.println("saisir login et mot de passe");
        }

    }

}