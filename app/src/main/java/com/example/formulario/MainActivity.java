package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private EditText documentTypeStudent;
    private EditText documentNumberStudent;
    private EditText codeStudent;
    private EditText nameStudent;
    private EditText surnameStudent;
    private EditText sexStudent;
    private EditText emailStudent;
    private EditText phoneStudent;
    private Button btnSave;
    private static final String FILE_NAME = "texto.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }

    private void setUpView() {
        documentTypeStudent = findViewById(R.id.documentTypeStudent);
        documentNumberStudent = findViewById(R.id.documentNumberStudent);
        codeStudent = findViewById(R.id.codeStudent);
        nameStudent = findViewById(R.id.nameStudent);
        surnameStudent = findViewById(R.id.surnameStudent);
        sexStudent = findViewById(R.id.sexStudent);
        emailStudent = findViewById(R.id.emailStudent);
        phoneStudent = findViewById(R.id.phoneStudent);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFile();
            }
        });
    }
    private void saveFile(){
        String textoASalvar = documentTypeStudent.getText().toString();
        String textoASalvar1 = documentNumberStudent.getText().toString();
        String textoASalvar2 = codeStudent.getText().toString();
        String textoASalvar3 = nameStudent.getText().toString();
        String textoASalvar4 = surnameStudent.getText().toString();
        String textoASalvar5 = sexStudent.getText().toString();
        String textoASalvar6 = emailStudent.getText().toString();
        String textoASalvar7 = phoneStudent.getText().toString();
        FileOutputStream fileOutputStream = null;

        try{
            fileOutputStream.write(textoASalvar.getBytes());
            fileOutputStream.write(textoASalvar1.getBytes());
            fileOutputStream.write(textoASalvar2.getBytes());
            fileOutputStream.write(textoASalvar3.getBytes());
            fileOutputStream.write(textoASalvar4.getBytes());
            fileOutputStream.write(textoASalvar5.getBytes());
            fileOutputStream.write(textoASalvar6.getBytes());
            fileOutputStream.write(textoASalvar7.getBytes());
            Log.d(tag:"TAG1" msg: "fichero salvado en" + getFilesDir() + "/" + FILE_NAME);

        }catch(Exception e){
            e.printStackTrace();
        }finaly {
            if(fileOutputStream != null){
                try{
                    fileOutputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }

    }
}