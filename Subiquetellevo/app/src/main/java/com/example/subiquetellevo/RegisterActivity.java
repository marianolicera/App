package com.example.subiquetellevo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

import OpenHelper.SQLite_OpenHelper;

public class RegisterActivity extends AppCompatActivity {

    Button btnGrabarUsuario;
    EditText txtNombreUsuario,txtCorreoUsuario, txtContraseniaUsuario,txtContrasenia2;

    //FirebaseFirestore mFirestore;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnGrabarUsuario=(Button)findViewById(R.id.button);
        txtNombreUsuario=(EditText)findViewById(R.id.txtRegistroNombre);
        txtCorreoUsuario=(EditText) findViewById(R.id.txtRegistroEmail);
        txtContraseniaUsuario=(EditText) findViewById(R.id.txtRegistroContrasenia);
        txtContrasenia2=(EditText) findViewById(R.id.txtRegistroContrasenia2);
        //Firestore=FirebaseFirestore.getInstance();

        btnGrabarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v_contraseniaUsu = txtContraseniaUsuario.getText().toString();
                String v_contraseniaUsu2 = txtContrasenia2.getText().toString();
                if (isValidEmailId(txtCorreoUsuario.getText().toString())){
                    if (v_contraseniaUsu.equals(v_contraseniaUsu2)) {
                        helper.abrir();
                        helper.insertarRegistroPersona(String.valueOf(txtNombreUsuario.getText()), String.valueOf(txtCorreoUsuario.getText()), String.valueOf(txtContraseniaUsuario.getText()));
                        helper.cerrar();
                        Toast.makeText(RegisterActivity.this, "Registro exitoso!", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(getApplicationContext(), LoginActivity.class);

                        startActivity(i);
                    } else {
                        Toast.makeText(RegisterActivity.this, "Las claves no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this, "Ingrese un email válido", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
        private boolean isValidEmailId(String email){

            return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
        }
}