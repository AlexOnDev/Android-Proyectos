package com.example.hipotenochas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


public class MainActivityJuego extends AppCompatActivity {

    LinearLayout linearLayout;
    int contador=0;
    int n=8;
    int numId=0;
    int bombas=10;
    int contadorBombas;
    ArrayList<Button> lista;
    HashSet<Integer> listaRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);

        linearLayout = findViewById(R.id.linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        Intent intent = getIntent();

        Bundle b = intent.getExtras();

        if(b.getInt("casillas")!=0 || b.getInt("bombas")!=0){
            n = b.getInt("casillas");
            bombas = b.getInt("bombas");

        }

        contadorBombas=bombas;
        lista=new ArrayList<>();
        anadeHijos();
    }

    public void anadeHijos(){
        Button b = null;
        LinearLayout li;
        generarRandom();

        for (int i = 0; i < n; i++) {
            li = new LinearLayout(this);
            li.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1
            ));
            li.setOrientation(LinearLayout.HORIZONTAL );
            li.setId(View.generateViewId());

            for (int j = 0; j < n; j++){
                b = new Button(this);
                b.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        1

                ));
                b.setText(String.valueOf(numId));
                b.setId(numId);
                b.setForeground(getResources().getDrawable(R.drawable.luckyblock));
                b.setTextColor(getResources().getColor(R.color.white));
                b.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                li.addView(b);
                b.setOnClickListener(this::clic);

                if(n==16){
                    b.setTextSize(2);
                }
                b.setOnLongClickListener(this::setOnLongClickListener);
                lista.add(b);
                numId++;

            }
            linearLayout.addView(li);
        }
        for(Button b1: lista){
            for(Integer e: listaRandom){
                if(b1.getId()==e){
                    b1.setText(String.valueOf(-1));
                }
            }
        }
    }

    private boolean setOnLongClickListener(View view) {
        Button b = (Button) view;
        if(Integer.valueOf(b.getText().toString())>=0){
            for(Integer bombas: listaRandom){
                lista.get(bombas).setForeground(getResources().getDrawable(R.drawable.mina));
            }
            Intent intent4 = new Intent(this, finActivity.class);
            startActivity(intent4);
        }else{
            b.setForeground(getResources().getDrawable(R.drawable.bandera));
            contadorBombas--;
        }
        if(contadorBombas==0){
            Intent intent3 = new Intent(this, finActivity2.class);
            startActivity(intent3);
        }

        return true;
    }

    public void clic(View view) {
        int pos = view.getId();
        if(lista.get(pos).getText().toString().equals("-1")){
            for(Integer bombas: listaRandom){
                lista.get(bombas).setForeground(getResources().getDrawable(R.drawable.mina));
            }

            Intent intent2 = new Intent(this, finActivity.class);
            startActivity(intent2);
            //Toast.makeText(this,"Nuevo Juego", Toast.LENGTH_SHORT).show();

        } else{
            int resultado = 0;
            if(n==8){
                resultado = logicaDe8(pos);
            }else if(n==12){
                resultado=logicaDe12(pos);
            }else{
                resultado=logicaDe16(pos);
            }
            if (resultado >= 0) {
                /*switch (resultado) {
                    case 1:
                        lista.get(pos).setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        lista.get(pos).setBackgroundColor(Color.BLUE);
                        break;
                    case 3:
                        lista.get(pos).setBackgroundColor(Color.YELLOW);
                        break;
                    case 4:
                        lista.get(pos).setBackgroundColor(Color.GREEN);
                        break;
                    case 5:
                        lista.get(pos).setBackgroundColor(Color.CYAN);
                        break;
                    case 6:
                        lista.get(pos).setBackgroundColor(Color.MAGENTA);
                        break;
                    case 7:
                        lista.get(pos).setBackgroundColor(getColor(R.color.naranja));
                        break;
                    case 8:
                        lista.get(pos).setBackgroundColor(getColor(R.color.morado));
                        break;
                }*/
                lista.get(pos).setBackground(getResources().getDrawable(R.drawable.brickblock));
                lista.get(pos).setForeground(null);
                lista.get(pos).setText(String.valueOf(contador));
                System.out.println(contador);
                contador = 0;

            }
        }

    }
    private int logicaDe8(int pos){
            if(pos==0){
                sumarAbajo(pos);
                sumarAbajoDer(pos);
                sumarDer(pos);
            } else if(pos==56){
                sumarDer(pos);
                sumarArriba(pos);
                sumarArribaDer(pos);

            }else if(pos==7){
                sumarAbajoIzq(pos);
                sumarAbajo(pos);
                sumarIzq(pos);

            }else if(pos==63){
                sumarIzq(pos);
                sumarArribaIzq(pos);
                sumarArriba(pos);

            }else if(pos==8 || pos==16 || pos==24 || pos==32 || pos==40 || pos==48){
                sumarAbajo(pos);
                sumarAbajoDer(pos);
                sumarDer(pos);
                sumarArriba(pos);
                sumarArribaDer(pos);
            } else if(pos==15 || pos==23 || pos==31 || pos==39 || pos==47 || pos==55){
                sumarAbajoIzq(pos);
                sumarAbajo(pos);
                sumarIzq(pos);
                sumarArribaIzq(pos);
                sumarArriba(pos);
            } else if(pos==1 || pos==2 || pos==3 || pos==4 || pos==5 || pos==6){
                sumarAbajoIzq(pos);
                sumarAbajo(pos);
                sumarAbajoDer(pos);
                sumarIzq(pos);
                sumarDer(pos);
            } else if(pos==57 || pos==58 || pos==59 || pos==60 ||pos==61 || pos==62){
                sumarIzq(pos);
                sumarDer(pos);
                sumarArribaIzq(pos);
                sumarArriba(pos);
                sumarArribaDer(pos);
            }else{
                System.out.println("a");
                sumarAbajoIzq(pos);
                sumarAbajo(pos);
                sumarAbajoDer(pos);
                sumarIzq(pos);
                sumarDer(pos);
                sumarArribaIzq(pos);
                sumarArriba(pos);
                sumarArribaDer(pos);


        }
        return contador;

    }
    private int logicaDe12(int pos){
            if(pos==0){
                sumarAbajo(pos);
                sumarAbajoDer(pos);
                sumarDer(pos);
            } else if(pos==132){
                sumarDer(pos);
                sumarArriba(pos);
                sumarArribaDer(pos);

            }else if(pos==11){
                sumarAbajoIzq(pos);
                sumarAbajo(pos);
                sumarIzq(pos);

            }else if(pos==143){
                sumarIzq(pos);
                sumarArribaIzq(pos);
                sumarArriba(pos);

            }else if(pos==12 || pos==24 || pos==36 || pos==48 || pos==60 || pos==72 || pos==84 || pos==96 || pos==108 || pos==120){
                sumarAbajo(pos);
                sumarAbajoDer(pos);
                sumarDer(pos);
                sumarArriba(pos);
                sumarArribaDer(pos);
            } else if(pos==23 || pos==35 || pos==47 || pos==59 || pos==71 || pos==83 || pos==95 || pos==107 || pos==119 || pos==131){
                sumarAbajoIzq(pos);
                sumarAbajo(pos);
                sumarIzq(pos);
                sumarArribaIzq(pos);
                sumarArriba(pos);
            } else if(pos==1 || pos==2 || pos==3 || pos==4 || pos==5 || pos==6 || pos==7 || pos==8 || pos==9 || pos==10){
                sumarAbajoIzq(pos);
                sumarAbajo(pos);
                sumarAbajoDer(pos);
                sumarIzq(pos);
                sumarDer(pos);
            } else if(pos==133 || pos==134 || pos==135 || pos==136 ||pos==137 || pos==138 || pos==139 || pos==140 ||pos==141 || pos==142){
                sumarIzq(pos);
                sumarDer(pos);
                sumarArribaIzq(pos);
                sumarArriba(pos);
                sumarArribaDer(pos);
            }else{
                System.out.println("a");
                sumarAbajoIzq(pos);
                sumarAbajo(pos);
                sumarAbajoDer(pos);
                sumarIzq(pos);
                sumarDer(pos);
                sumarArribaIzq(pos);
                sumarArriba(pos);
                sumarArribaDer(pos);

            }

        return contador;
    }
    private int logicaDe16(int pos){
        if(pos==0){
            sumarAbajo(pos);
            sumarAbajoDer(pos);
            sumarDer(pos);
        } else if(pos==240){
            sumarDer(pos);
            sumarArriba(pos);
            sumarArribaDer(pos);

        }else if(pos==15){
            sumarAbajoIzq(pos);
            sumarAbajo(pos);
            sumarIzq(pos);

        }else if(pos==255){
            sumarIzq(pos);
            sumarArribaIzq(pos);
            sumarArriba(pos);

        }else if(pos==16 || pos==32 || pos==48 || pos==64 || pos==80 || pos==96 ||
        pos==112 || pos==128 || pos==144 || pos==160 || pos==176 || pos==192 ||
        pos==208 || pos==224){
            sumarAbajo(pos);
            sumarAbajoDer(pos);
            sumarDer(pos);
            sumarArriba(pos);
            sumarArribaDer(pos);
        } else if(pos==31 || pos==47 || pos==63 || pos==79 || pos==95 || pos==111 ||
                pos==127 || pos==1143 || pos==159 || pos==1175 || pos==191 || pos==207 ||
                pos==223 || pos==239){
            sumarAbajoIzq(pos);
            sumarAbajo(pos);
            sumarIzq(pos);
            sumarArribaIzq(pos);
            sumarArriba(pos);
        } else if(pos==1 || pos==2 || pos==3 || pos==4 || pos==5 || pos==6 ||
                pos==7 || pos==8 || pos==9 || pos==10 || pos==11 || pos==12 ||
                pos==13 || pos==14){
            sumarAbajoIzq(pos);
            sumarAbajo(pos);
            sumarAbajoDer(pos);
            sumarIzq(pos);
            sumarDer(pos);
        } else if(pos==241 || pos==242 || pos==243 || pos==244 || pos==245 || pos==246 ||
                pos==247 || pos==248 || pos==249 || pos==250 || pos==251 || pos==252 ||
                pos==253 || pos==254){
            sumarIzq(pos);
            sumarDer(pos);
            sumarArribaIzq(pos);
            sumarArriba(pos);
            sumarArribaDer(pos);
        }else{
            System.out.println("a");
            sumarAbajoIzq(pos);
            sumarAbajo(pos);
            sumarAbajoDer(pos);
            sumarIzq(pos);
            sumarDer(pos);
            sumarArribaIzq(pos);
            sumarArriba(pos);
            sumarArribaDer(pos);


        }
        return contador;
    }
    private void sumarArribaIzq(int pos){
        if(lista.get(pos-n-1).getText().toString().equals("-1")){
            System.out.println("Arriba izq xd");
            contador++;
        }

    }
    private void sumarArriba(int pos){
        if(lista.get(pos-n).getText().toString().equals("-1")){
            System.out.println("Arriba xd");
            contador++;
        }

    }
    private void sumarArribaDer(int pos){
        if(lista.get(pos-n+1).getText().toString().equals("-1")){
            System.out.println("Arriba der xd");
            contador++;
        }
    }
    private void sumarIzq(int pos){
        if(lista.get(pos-1).getText().toString().equals("-1")){
            System.out.println("A la izquierda xd");
            contador++;
        }
    }
    private void sumarDer(int pos){
        if(lista.get(pos+1).getText().toString().equals("-1")){
            System.out.println("A la derecha kabum");
            contador++;
        }
    }
    private void sumarAbajoIzq(int pos){
        if(lista.get(pos+n-1).getText().toString().equals("-1")){
            System.out.println("abajo izq xd");
            contador++;
        }
    }
    private void sumarAbajo(int pos){
        if(lista.get(pos+n).getText().toString().equals("-1")){
            System.out.println("abajo xd");
            contador++;
        }
    }
    private void sumarAbajoDer(int pos){
        if(lista.get(pos+n+1).getText().toString().equals("-1")){
            System.out.println("abajo der xd");
            contador++;
        }
    }
    private void generarRandom(){
        listaRandom = new HashSet<>();
        Random r=new Random();
        while(listaRandom.size()<bombas){
            listaRandom.add(r.nextInt(n*n));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        switch (item.getItemId()) {
            case R.id.volver:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(this,"Volver Juego", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }

    }




}


