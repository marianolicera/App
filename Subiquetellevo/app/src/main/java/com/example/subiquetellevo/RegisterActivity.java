package com.example.subiquetellevo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import OpenHelper.SQLite_OpenHelper;

public class RegisterActivity extends AppCompatActivity {

    Button btnGrabarUsuario;
    EditText txtNombreUsuario,txtCorreoUsuario, txtContraseñaUsuario,txtContraseña2;

    //FirebaseFirestore mFirestore;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnGrabarUsuario=(Button)findViewById(R.id.button);
        txtNombreUsuario=(EditText)findViewById(R.id.txtRegistroNombre);
        txtCorreoUsuario=(EditText) findViewById(R.id.txtRegistroEmail);
        txtContraseñaUsuario=(EditText) findViewById(R.id.txtRegistroContraseña);
        txtContraseña2=(EditText) findViewById(R.id.txtRegistroContraseña2);
        //Firestore=FirebaseFirestore.getInstance();

        btnGrabarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (txtContraseñaUsuario == txtContraseña2) {
                    helper.abrir();
                    helper.insertarRegistroPersona(String.valueOf(txtNombreUsuario.getText()),String.valueOf(txtCorreoUsuario.getText()),String.valueOf(txtContraseñaUsuario.getText()));
                    helper.cerrar();

                    //crearDatos();
                    Toast.makeText(RegisterActivity.this, "Registro exitoso!", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);

                    startActivity(i);
                //}else{
                    //Toast.makeText(RegisterActivity.this, "Las claves no coinciden", Toast.LENGTH_SHORT).show();
                //}
            }
        });

    }
}