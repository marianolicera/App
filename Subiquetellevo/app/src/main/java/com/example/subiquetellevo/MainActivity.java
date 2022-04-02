package com.example.subiquetellevo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view) {
        //está el boton cliqueado?
        boolean checked = ((RadioButton) view).isChecked();

        //chequear cual fue cliqueado
        switch (view.getId()) {
            case R.id.radio_android:
                if (checked) {
                    //epic
                    break;
                }
            case R.id.radio_ios:
                if (checked) {
                    //epic ios
                    break;
                }
        }
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.checkbox_programacion:
                if (checked){
                    break;
                }
            case R.id.checkbox_juegos:
                if (checked){
                    break;
                }
            case R.id.checkbox_redes:
                if (checked){
                    break;
                }
        }
    }
}