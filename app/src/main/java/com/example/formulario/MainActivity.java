package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

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

            documentTypeStudent = findViewById(R.id.documentTypeStudent);
            documentNumberStudent = findViewById(R.id.documentNumberStudent);
            codeStudent = findViewById(R.id.codeStudent);
            nameStudent = findViewById(R.id.nameStudent);
            surnameStudent = findViewById(R.id.surnameStudent);
            sexStudent = findViewById(R.id.sexStudent);
            emailStudent = findViewById(R.id.emailStudent);
            phoneStudent = findViewById(R.id.phoneStudent);
            btnSave = findViewById(R.id.btnSave);

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ejecutarServicio("http://localhost:8080/developeru/insertar_estudiante.php");
                }
            });
        }

        private void ejecutarServicio(String URL){
            StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String Response){
                    Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error){
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                }

            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parametros=new HashMap<String, String>();
                    parametros.put("documentNumber",documentNumberStudent.getText().toString());
                    parametros.put("documentType",documentTypeStudent.getText().toString());
                    parametros.put("code",codeStudent.getText().toString());
                    parametros.put("sex",sexStudent.getText().toString());
                    parametros.put("surname",surnameStudent.getText().toString());
                    parametros.put("email",emailStudent.getText().toString());
                    parametros.put("name",nameStudent.getText().toString());
                    parametros.put("phone",phoneStudent.getText().toString());
                    return parametros;
                }
            };
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }
    }