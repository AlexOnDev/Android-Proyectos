package com.example.coloresaleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    int numId;
    ArrayList<Button> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        lista=new ArrayList<>();
        anadeBotones();

    }

    public void anadeBotones(){
        Button b = null;
        LinearLayout li;

        for (int i = 0; i < 6; i++) {
            li = new LinearLayout(this);
            li.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1));
            li.setOrientation(LinearLayout.HORIZONTAL );


            for (int j = 0; j < 6; j++){

                b = new Button(this);
                b.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1));
                b.setText(String.valueOf(numId));
                b.setId(numId);
                li.addView(b);
                b.setOnClickListener(this::clic);
                lista.add(b);
                numId++;
            }
            linearLayout.addView(li);
        }
    }


    public void clic(View view){
        Random a =new Random();
        int i1=a.nextInt(255);
        int i2=a.nextInt(255);
        int i3=a.nextInt(255);

        int numero = view.getId();
        if(numero==35){
            for(Button b: lista){
                b.setBackgroundColor(Color.argb(255,100,0,0));
            }
        }else{
        Button boton = (Button) findViewById(numero);
        boton.setBackgroundColor( Color.argb(255,i1,i2,i3));

        }


       //System.out.println(boton.getText());
    }
}