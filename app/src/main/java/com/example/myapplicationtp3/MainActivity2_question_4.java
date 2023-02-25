package com.example.myapplicationtp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity2_question_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_question4);
        //
        EditText champ_text = findViewById(R.id.content_q4);
        String filename ="konewolouhooumar_angorakouame";
        //pré-remplissage du contenu du champs text avec le contenu du fichier creer en question 1-3
        this.createFileIfNoteExiste(filename); //creation du fichier s'il n'existe pas
        String content_of_file = this.readContentOfFile(filename);
        champ_text.setText(content_of_file);
        //setting the code of the ok button
        //bouton Ok
        Button ok = (Button) findViewById(R.id.btnok);
        ok.setOnClickListener(view -> {
            String contenu_champs = champ_text.getText().toString();
            this.writeToFile(contenu_champs,filename);
        });
        //setting the code of the button cancel
        //bouton cancel
        Button cancel = (Button) findViewById(R.id.btncancel);
        cancel.setOnClickListener(view -> {
            String contenu_fchier = this.readContentOfFile(filename);
            champ_text.setText(contenu_fchier);
        });
        //
        //bouton d'arret de l'activité
        Button stop = (Button) findViewById(R.id.bntexit_q4);
        stop.setOnClickListener(view -> {
            this.finish();
        });
        //
    }
    //methode qui cree un fichier s'il existe pas dans le contexte de l'application
    private void createFileIfNoteExiste(String filename){
        Context context = getApplicationContext(); // contexte de l'application
        File file = new File(context.getFilesDir(), filename); //onbtention du fichier
        if(!file.exists()){
            try {
                file.createNewFile(); //creation du fichier s'il n'existe pas
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void writeToFile(String contents,String filename){
        Context context = getApplicationContext();
        try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
            fos.write(contents.getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
        }
    }
    //methode qui lit et renvoie le contenu du fichier
    private String readContentOfFile(String filename){
        Context context = getApplicationContext();
        FileInputStream fis = null;
        try {
            fis = context.openFileInput(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        } finally {
            String contents = stringBuilder.toString();
            return(contents);
        }

    }
}