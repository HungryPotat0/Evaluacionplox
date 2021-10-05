package com.evaluacionp;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Ingreso extends AppCompatActivity {
    ListView Gender;
    EditText Nom, Ape;
    int macho, macha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);
        Gender = (ListView) findViewById(R.id.Genero);
        Nom = (EditText) findViewById(R.id.Name);
        Ape = (EditText) findViewById(R.id.Lastname);
        Bundle B = getIntent().getExtras();

        macho = B.getInt("Machos");
        macha = B.getInt("Hembras");

        ArrayList<String> Sex = new ArrayList<String>();
        Sex.add("Hombre");
        Sex.add("Mujer");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, Sex);
        Gender.setAdapter(adaptador);


    }

    public void Agregar(View w) {
        if (!Nom.equals("") && !Ape.equals("")) {
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Alerta");
            dialogo1.setMessage("¿ Desea continuar ?");
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    aceptar();
                }
            });
            dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    cancelar();
                }
            });
            dialogo1.show();
        } else {
            Toast.makeText(this, "LLene los campos pueh", Toast.LENGTH_LONG).show();
        }


    }

    public void aceptar() {
        String gen = Gender.getSelectedItem().toString();
        if (gen.equals("Hombre")) {
            macho = macho + 1;
        } else if (gen.equals("Mujer")) {
            macha = macha + 1;
        }
        Intent I = new Intent(getApplicationContext(), Lista.class);
        I.putExtra("Machos", macho);
        I.putExtra("Hembras", macha);
        startActivity(I);
    }

    public void cancelar() {
        finish();
    }
}

