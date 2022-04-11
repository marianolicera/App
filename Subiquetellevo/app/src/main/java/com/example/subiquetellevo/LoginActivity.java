package com.example.subiquetellevo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class LoginActivity extends AppCompatActivity {

    Button tvRegistro;
    Button btnIngresar;
    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvRegistro=(Button) findViewById(R.id.registerButton);


        tvRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),RegisterActivity.class);

                startActivity(i);
            }
        });

        btnIngresar=(Button) findViewById(R.id.inButton);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtNomUsu=(EditText) findViewById(R.id.txtNomUsu);
                EditText txtPass = (EditText) findViewById(R.id.txtPassword);
                Cursor cursor=helper.consultarUsuarioContrasenia(txtNomUsu.getText().toString(),txtPass.getText().toString());
                if (cursor.getCount()>0){
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);

                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"usuario o contraseña incorrectos",Toast.LENGTH_LONG).show();
                    txtNomUsu.setText("");
                    txtPass.setText("");
                    txtNomUsu.findFocus();
                }
            }

        });
    }

}