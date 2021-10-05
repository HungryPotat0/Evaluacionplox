package com.evaluacionp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText User,Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User=(EditText) findViewById(R.id.Nombre);
        Pass=(EditText) findViewById(R.id.Contraseña);



    }
    public void validar(View W)
    {
        String us=User.getText().toString();
        String pas=Pass.getText().toString();
        if (us.equals("adm123")&& pas.equals("adm123"))
        {
            Intent I = new Intent(getApplicationContext(),Lista.class);
            startActivity(I);

    }
}}