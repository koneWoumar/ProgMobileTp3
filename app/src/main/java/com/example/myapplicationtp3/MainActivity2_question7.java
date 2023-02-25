package com.example.myapplicationtp3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2_question7 extends AppCompatActivity {

    Context context ;
    LinearLayout contener;
    Button addfile ;
    Button stopActivity ;
    EditText champ_text ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_question7);
        //
        context = getApplicationContext();
        addfile = (Button) findViewById(R.id.btn_add_q7) ;
        stopActivity = (Button) findViewById(R.id.bntexit_q7);
        champ_text = findViewById(R.id.file_name);
        contener = findViewById(R.id.conteneur);
        //
        this.chargerListView(); //pre_chargement du conteneur avec la liste des fichier du context de l'app
        //bouton d'arret de l'activité
        stopActivity.setOnClickListener(view -> {
            this.finish();
        });

        //bouton d'ajout de fichier
        addfile.setOnClickListener(view -> {
            String nom_file=champ_text.getText().toString();
            this.creatFileInAppContext(nom_file);
            this.chargerListView();
        });
    }
    //methode qui charge la liste des fichier dans la listview
    private void chargerListView(){
        //
        String[] file_name_list = context.fileList(); // obtening the list of file in the app context
        contener.removeAllViews();//vider le conteneur layout ici
        //
        for(String file_name:file_name_list){
            //LinearLayout cadre = findViewById(R.id.conteneur);
            View item = getLayoutInflater().inflate(R.layout.item_file_question7,null);// recuperation du layout item
            TextView item_text = item.findViewById(R.id.item_name); //getting the textview of the item card to be shown
            item_text.setText(file_name);//setting the name of file to the item text

            Button item_btn_sup = (Button) item.findViewById(R.id.button_sup);//getting the delete button on the item card
            item_btn_sup.setOnClickListener(view -> {
                this.deleteFileInAppContext(file_name);
                this.chargerListView();
            });

            contener.addView(item);
        }
    }
    //
    //methode qui cree un fichier dans le contexte de l'application
    private void creatFileInAppContext(String file_name){
        File file = new File(context.getFilesDir(), file_name); //onbtention du fichier
        if(!file.exists()){
            try {
                file.createNewFile(); //creation du fichier s'il n'existe pas
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //
    //methode qui supprime un fichier dans le contexte de l'application
    private void deleteFileInAppContext(String file_name){
        File file = new File(context.getFilesDir(), file_name); //onbtention du fichier
        if(file.exists()){
            file.delete(); // suppression du fichier s'il existe
        }
    }
}