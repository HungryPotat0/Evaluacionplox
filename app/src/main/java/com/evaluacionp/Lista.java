package com.evaluacionp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Lista extends AppCompatActivity {
    int ConMacho=0,ConMacha=0;
    TextView Totales,machos,machas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Totales=(TextView) findViewById(R.id.Total);
        machos=(TextView) findViewById(R.id.Hombres);
        machas=(TextView)findViewById(R.id.Mujeres);
        Bundle B = getIntent().getExtras();

        ConMacho=B.getInt("Machos");
        ConMacha=B.getInt("Hembras");
        int total=ConMacho+ConMacha;
        Totales.setText(total);
        machos.setText(ConMacho);
        machas.setText(ConMacha);






    }
    public void Unomah(View W)
    {
        Intent I = new Intent(getApplicationContext(),Ingreso.class);
        I.putExtra("Machos",ConMacho);
        I.putExtra("Hembras",ConMacha);
        startActivity(I);

    }
}