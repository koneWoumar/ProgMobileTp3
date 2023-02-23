package com.example.myapplicationtp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity2_question_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_question4);
        //bouton Ok
        Button ok = (Button) findViewById(R.id.buttonok);
        ok.setOnClickListener(view -> {
            //
        });
        //bouton cancel
        Button cancel = (Button) findViewById(R.id.buttoncancel);
        cancel.setOnClickListener(view -> {
            //
        });
        //
        //bouton d'arret de l'activité
        Button stop = (Button) findViewById(R.id.bntexit_q_4);
        stop.setOnClickListener(view -> {
            this.finish();
        });
    }
}