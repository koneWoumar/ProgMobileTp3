package com.example.myapplicationtp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2_question_6 extends AppCompatActivity {

    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
    ListView simpleListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_question6);
        //bouton d'arret de l'activité
        Button stop = (Button) findViewById(R.id.bntexit_q6);
        stop.setOnClickListener(view -> {
            this.finish();
        });
        //
        this.chargerList();
        //
        simpleListView=(ListView)findViewById(R.id.listview_q6);
        String[] from={"item_name","button_sup"};//string array
        int[] to={R.id.item_name,R.id.button_sup};//int array of views id's
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,arrayList,R.layout.item_child_question7,from,to);
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView
        //

    }

    private void chargerList(){
        //
        HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
        hashMap.put("item_name","file1");
        hashMap.put("button_sup","sup");
        arrayList.add(hashMap);//add the hashmap into arrayList
        //
        hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
        hashMap.put("item_name","file2");
        hashMap.put("button_sup","sup");
        arrayList.add(hashMap);
        //
        hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
        hashMap.put("item_name","file3");
        hashMap.put("button_sup","sup");
        arrayList.add(hashMap);
        //
    }

}
