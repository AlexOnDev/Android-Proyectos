package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Bundle bndl=null;
    Double resultado=0.0;
    EditText txt1, txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void clic(View view){
        txt1=findViewById(R.id.campo1);
        txt2=findViewById(R.id.campo2);


        Double altura=Double.valueOf(txt1.getText().toString());
        Double peso=Double.valueOf(txt2.getText().toString());

        Double resultado=(double)Math.round((peso/(altura*altura))*100)/100;

        System.out.println(resultado);
        Intent intent = new Intent(MainActivity.this, Resultado.class);
        bndl = new Bundle();
        bndl.putDouble("resultado",resultado);
        intent.putExtras(bndl);
        startActivity(intent);
    }
}