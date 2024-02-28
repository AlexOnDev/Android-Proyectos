package com.example.hipotenochas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPersonaje extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personaje);
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
                //metodoAdd()
                Intent intent = new Intent(MainActivityPersonaje.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(this,"Configurar Juego", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void clic(View view){
        RadioButton r = (RadioButton) view;
        if(r.getText().toString().equals("Mario")){
            getSupportActionBar().setIcon(getResources().getDrawable(R.drawable.mario));
        } else if(r.getText().toString().equals("Luigi")){
            getSupportActionBar().setIcon(getResources().getDrawable(R.drawable.luigi));
        }else{
            getSupportActionBar().setIcon(getResources().getDrawable(R.drawable.peach));
        }


    }
}
