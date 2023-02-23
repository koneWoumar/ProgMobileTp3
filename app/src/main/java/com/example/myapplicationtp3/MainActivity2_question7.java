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

    //la liste des region
    //ArrayList<String> listeRegion = new ArrayList<String>();
    //la listeview
    //ListView listViewRegion;
    //l'adaptateur de la listeview
    //ArrayAdapter<String> listViewRegionAdapter ;
    //
    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
    ListView simpleListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_question7);
        //bouton d'arret de l'activité
        Button stop = (Button) findViewById(R.id.bntexit_q_7);
        stop.setOnClickListener(view -> {
            this.finish();
        });

        //bouton ajouter
        Button add = (Button) findViewById(R.id.btn_ajouter_question7);
        add.setOnClickListener(view -> {
            LinearLayout cadre = findViewById(R.id.listview_question7);
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
    /*
    private void setButtonEventListner(){
        ListView listview = findViewById(R.id.listview_question7);
        int child_number = listview.getCount();
        for(int i=0;i<1;i++){
            //
            RelativeLayout item = (RelativeLayout) listview.getChildAt(i);
            Button btnsup = (Button) item.findViewById(R.id.button_sup);

            TextView item_text_view = (TextView) item.findViewById(R.id.item_name);
            //
            btnsup.setOnClickListener(views -> {
                String file_name = item_text_view.getText().toString();
                Toast.makeText(this,file_name,Toast.LENGTH_LONG).show();
            });
        }

    } */
}