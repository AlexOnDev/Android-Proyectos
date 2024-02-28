package com.example.hipotenochas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

    public class finActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.findeljuego);
        }
        public void clic(View view){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

}
