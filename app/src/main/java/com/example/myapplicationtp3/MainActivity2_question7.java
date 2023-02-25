package com.example.myapplicationtp3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2_question7 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_question7);
        //bouton d'arret de l'activité
        Button stop = (Button) findViewById(R.id.bntexit_q7);
        stop.setOnClickListener(view -> {
            this.finish();
        });

        //bouton ajouter
        Button add = (Button) findViewById(R.id.btn_add_q7);
        add.setOnClickListener(view -> {
            LinearLayout cadre = findViewById(R.id.conteneur);
            View item = getLayoutInflater().inflate(R.layout.item_child_question7,null);
            cadre.addView(item);
        });
        //

        /*
        //code test
        this.chargerList();
        //
        simpleListView=(ListView)findViewById(R.id.listview_question7);
        String[] from={"item_name","button_sup"};//string array
        int[] to={R.id.item_name,R.id.button_sup};//int array of views id's
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,arrayList,R.layout.item_child_question7,from,to);
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView
        //
         */
    }
}