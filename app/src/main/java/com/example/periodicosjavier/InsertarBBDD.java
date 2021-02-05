package com.example.periodicosjavier;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class InsertarBBDD extends AppCompatActivity implements View.OnClickListener{

    RadioButton radioButton1, radioButton2, radioButton3;
    Button btnAnadir;
    EditText editTextNombre;
    String nom;
    String tem;
    DBInterface dbInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_b_b_d_d);


        editTextNombre = (EditText) findViewById(R.id.editText);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        btnAnadir = (Button) findViewById(R.id.button);

        editTextNombre.setOnClickListener(this);
        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        radioButton3.setOnClickListener(this);
        btnAnadir.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioButton:
                if (radioButton1.isChecked())
                    tem = radioButton1.getText().toString();


                break;
            case R.id.radioButton2:
                if (radioButton2.isChecked())
                    tem = radioButton2.getText().toString();

                break;

            case R.id.radioButton3:
                if (radioButton3.isChecked())
                    tem = radioButton3.getText().toString();

                break;


        }

        if (v.getId() == R.id.button) {
            nom = editTextNombre.getText().toString();
            dbInterface = new DBInterface(this);
            dbInterface.abre();
            dbInterface.insertarPeriodico(nom, tem);
            Toast.makeText(getBaseContext(), "Periodico " + nom + " añadido ", Toast.LENGTH_LONG).show();

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

            finish();
        }

    }
}