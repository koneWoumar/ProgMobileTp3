package com.example.myapplicationtp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity2_question3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_question3);

        //Verification et creation du fichier : question 1
        String filename ="Kone_Angora"; //concatenation des noms des binomes
        this.createFileIfNoteExiste(filename);
        //Ecriture dans le fichier question 2
        String contents = "Bonjour JOHANN Bourcier";
        this.writeToFile(contents,filename);
        //Lecture du fichier du fichier question3
        String fileContent = readContentOfFile(filename);
        TextView champ_contenant = (TextView) findViewById(R.id.content_q3);
        champ_contenant.setText(fileContent);
        //bouton d'arret de l'activité
        Button stop = (Button) findViewById(R.id.bntexit_q3);
        stop.setOnClickListener(view -> {
            this.finish();
        });
        //button de lancement de l'activity question4
        Button btngotoq4 = (Button) findViewById(R.id.bntgotoq4);
        btngotoq4.setOnClickListener(view -> {
            Intent question_4_ActivityIntent = new Intent(MainActivity2_question3.this, MainActivity2_question_4.class);
            startActivity(question_4_ActivityIntent);
        });
    }
    //methode qui cree un fichier s'il existe pas dans le contexte de l'application
    private void createFileIfNoteExiste(String filename){
        Context context = getApplicationContext(); // contexte de l'application
        File file = new File(context.getFilesDir(), filename); //onbtention d'un object File du  fichier
        if(!file.exists()){ //si le fichier n'existe pas
            try {
                file.createNewFile(); //creation du fichier s'il n'existe pas
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //methode qui ecris dans le fichier le string passé en parametre
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