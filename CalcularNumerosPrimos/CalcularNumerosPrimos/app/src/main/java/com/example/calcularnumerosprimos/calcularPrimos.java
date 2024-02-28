package com.example.calcularnumerosprimos;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class calcularPrimos {
    public static ArrayList<Integer> calcular(int cantidad, ArrayList<Integer> listado){
        ArrayList<Integer> lista;
        int numeroPrimo=1;

        if(listado.isEmpty()){
            lista=new ArrayList<>();
            for(int i=0; i<cantidad;i++){
                boolean comprobar=true;
                while(comprobar){
                    int contador=0;
                    numeroPrimo++;
                    int divisor=numeroPrimo;
                    while(divisor>0){
                        if(numeroPrimo%divisor==0){
                            contador++;
                        }
                        divisor--;
                    }
                    if(contador==2){
                        lista.add(numeroPrimo);
                        comprobar=false;
                    }

                }
            }
        }
        else{
            lista=listado;
            if(lista.size()>=cantidad){
                return lista;

            }else{
                numeroPrimo=lista.get(lista.size()-1);
                for(int i=lista.size(); i<cantidad;i++){
                    boolean comprobar=true;
                    while(comprobar){
                        int contador=0;
                        numeroPrimo++;

                        int divisor= (int) Math.sqrt(numeroPrimo);
                        while(divisor>0){
                            if(numeroPrimo%divisor==0){
                                contador++;
                            }
                            divisor--;
                        }
                        if(contador==1){
                            lista.add(numeroPrimo);
                            comprobar=false;
                        }

                    }
                }

            }
        }

        return lista;
    }
}
