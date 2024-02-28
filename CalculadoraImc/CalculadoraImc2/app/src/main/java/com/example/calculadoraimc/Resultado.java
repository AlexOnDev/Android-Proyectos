package com.example.calculadoraimc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Resultado extends AppCompatActivity {

    ConstraintLayout cl;
    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Double resultado=getIntent().getExtras().getDouble("resultado");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);
        cl = findViewById(R.id.fondo);
        tx=findViewById(R.id.texto);
      if(resultado<15){
          cl.setBackgroundColor(Color.argb(255,255,0,255)); //morado
      } else if(resultado<18.5){
          cl.setBackgroundColor(Color.argb(255,0,0,255)); //azul
      } else if (resultado<24.9){
          cl.setBackgroundColor(Color.argb(255,0,255,0)); //verde
      } else if (resultado<29.9){
          cl.setBackgroundColor(Color.argb(255,0,255,255)); //amarillo
      } else if (resultado>30){
          cl.setBackgroundColor(Color.argb(255,255,0,0)); //rojo
      }
        tx.setText(String.valueOf(resultado));
        System.out.println("******************************");
        System.out.println(resultado);
    }
}
