package com.jeiveryr.semana2coursera;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFlotante();
    }
    public void agregarFlotante(){
        FloatingActionButton miFlotante=(FloatingActionButton) findViewById(R.id.flabMiFlab);
        miFlotante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),getResources().getString(R.string.mensajitoLoco),Toast.LENGTH_SHORT).show();
                Snackbar.make(view, getResources().getString(R.string.mensajitoLoco),Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
