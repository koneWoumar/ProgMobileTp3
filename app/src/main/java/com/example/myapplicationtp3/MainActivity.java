package com.example.myapplicationtp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button de lancement de l'activity qestion_1_3
        Button btngotoq1_3 = (Button) findViewById(R.id.bntgotoq1_3);
        btngotoq1_3.setOnClickListener(view -> {
            Intent question_3_ActivityIntent = new Intent(MainActivity.this, MainActivity2_question3.class);
            startActivity(question_3_ActivityIntent);
        });

        //
        //button de lancement de l'activity
        Button btngotoq4 = (Button) findViewById(R.id.bntgotoq4);
        btngotoq4.setOnClickListener(view -> {
            Intent question_4_ActivityIntent = new Intent(MainActivity.this, MainActivity2_question_4.class);
            startActivity(question_4_ActivityIntent);
        });

        //button de lancement de l'activity
        Button btngotoq_5_6 = (Button) findViewById(R.id.bntgotoq_5_6);
        btngotoq_5_6.setOnClickListener(view -> {
            Intent question_5_6_ActivityIntent = new Intent(MainActivity.this, MainActivity2_question_6.class);
            startActivity(question_5_6_ActivityIntent);
        });

        //button de lancement de l'activity
        Button btngotoq_7 = (Button) findViewById(R.id.bntgotoq_7);
        btngotoq_7.setOnClickListener(view -> {
            Intent question_7_ActivityIntent = new Intent(MainActivity.this, MainActivity2_question7.class);
            startActivity(question_7_ActivityIntent);
        });

        //bouton d'arret de l'activité
        Button stop = (Button) findViewById(R.id.bntexit_main);
        stop.setOnClickListener(view -> {
            this.finish();
        });
    }
}
//activity_main_activity2_question4