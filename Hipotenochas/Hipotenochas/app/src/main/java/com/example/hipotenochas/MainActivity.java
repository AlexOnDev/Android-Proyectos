package com.example.hipotenochas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int casillas;
    int bombas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){

            switch (item.getItemId()) {

                case R.id.ins:

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.tituloIns);
                    builder.setMessage(R.string.textoIns);
                    builder.create();
                    builder.show();
                    return true;
                case R.id.nuevo:

                    Intent intent2 = new Intent(MainActivity.this, MainActivityJuego.class);
                    intent2.putExtra("casillas", casillas);
                    intent2.putExtra("bombas", bombas);
                    startActivity(intent2);
                    Toast.makeText(this,"Nuevo Juego", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.config:

                    Toast.makeText(this,"Configurar Juego", Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setTitle("Eliga la dificultad");
                    String[] items = {"Principiante","Amateur","Avanzada"};
                    int checkedItem = 1;
                    alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    casillas = 8;
                                    bombas = 10;
                                    break;
                                case 1:
                                    casillas = 12;
                                    bombas = 30;
                                    break;
                                case 2:
                                    casillas = 16;
                                    bombas = 60;
                                    break;
                            }
                        }
                    }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    AlertDialog alert = alertDialog.create();
                    alert.setCanceledOnTouchOutside(false);
                    alert.show();
                    return true;
                case R.id.selec:
                    Intent intent4 = new Intent(MainActivity.this, MainActivityPersonaje.class);
                    startActivity(intent4);
                    Toast.makeText(this,"Seleccionar Personaje", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }

        }

}