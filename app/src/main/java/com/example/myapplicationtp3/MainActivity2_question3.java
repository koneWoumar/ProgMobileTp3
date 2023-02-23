package com.example.myapplicationtp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity2_question3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_question3);
        //
        //bouton d'arret de l'activité
        Button stop = (Button) findViewById(R.id.bntexit_q3);
        stop.setOnClickListener(view -> {
            this.finish();
        });
    }
}