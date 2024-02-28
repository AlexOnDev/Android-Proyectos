package com.example.hipotenochas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class finActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findeljuego2);
    }
    public void clic(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
