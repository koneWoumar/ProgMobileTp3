package com.example.myapplicationtp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2_question_6 extends AppCompatActivity {

    ArrayList<HashMap<String,String>> arrayList;
    Context context ;
    ListView simpleListView;
    Button addfile ;
    Button stop ;
    EditText champ_text ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_question6);
        //
        arrayList=new ArrayList<>();
        context = getApplicationContext();
        simpleListView = (ListView)findViewById(R.id.listview_q6);
        addfile = (Button) findViewById(R.id.btn_add_q6) ;
        stop = (Button) findViewById(R.id.bntexit_q6);
        champ_text = findViewById(R.id.nom_fichier_q6);

        //pre_charger la liste des fichier existant dans le dossier contexte de l'application
        this.chargerListView();
        //button addfile
        addfile.setOnClickListener( view -> {
            if(champ_text.getText().toString().equals("")){
                Toast.makeText(this,"please type file name first",Toast.LENGTH_LONG).show();
            }
            else{
                String contenu_champs_text = champ_text.getText().toString();
                this.creatFile(contenu_champs_text);
                this.chargerListView();
                champ_text.setText("");
            }
        });

        //bouton d'arret de l'activité
        stop.setOnClickListener(view -> {
            this.finish();
        });
    }
    //methode qui charge la liste des fichier dans la listview
    private void chargerListView(){
        //
        String[] file_name_list = context.fileList();
        //
        arrayList = new ArrayList<>();
        for(String file_name:file_name_list){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("item_name",file_name);
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        //
        String[] from={"item_name","button_sup"};//string array
        int[] to={R.id.item_name};//int array of views id's
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,arrayList,R.layout.item_file_question_5_6,from,to);
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView
        //
    }
    //methode qui cree un fichier dans le contexte de l'application
    private void creatFile(String file_name){
        File file = new File(context.getFilesDir(), file_name); //onbtention du fichier
        if(!file.exists()){
            try {
                file.createNewFile(); //creation du fichier s'il n'existe pas
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
