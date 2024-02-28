package com.example.calcularnumerosprimos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tx;
    ArrayList<Integer> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.campo1);
        tx=findViewById(R.id.resultado);
        lista=new ArrayList<>();
    }
    public void clic(View view){

        if(et.getText().toString().length()>6){

            Toast.makeText(this,"Mucho número", Toast.LENGTH_SHORT).show();
        }else if(et.getText().toString().length()==0){
            Toast.makeText(this,"Introduce algun numero, por favor", Toast.LENGTH_SHORT).show();
        }
        else{
            try{
                Integer cantidad=Integer.valueOf(et.getText().toString());
                String resultado="Resultado: 👾  ";
                lista=calcularPrimos.calcular(cantidad,lista);
                resultado+=String.valueOf(lista.get(cantidad-1));
                tx.setText(resultado);
            }catch (Exception e){
                e.printStackTrace();
            }

        }


    }
}