package com.jeiveryr.semana2coursera;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout misfiMiIndicadorDeRefres;
    ListView lstmiLista;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFlotante();

        try {
        misfiMiIndicadorDeRefres=(SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorDeRefres);
        lstmiLista=(ListView) findViewById(R.id.lstMiLista);

        String[] electronicos=getResources().getStringArray(R.array.Electronicos);
        lstmiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,electronicos));
        misfiMiIndicadorDeRefres.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescarContenido();
            }
        });
    }catch (Exception e){
         Toast.makeText(getBaseContext(),e.toString(),Toast.LENGTH_SHORT).show();

    }

    }

    public void refrescarContenido(){
        try {

            String[] gatos=getResources().getStringArray(R.array.Gatos);
            lstmiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,gatos));
            misfiMiIndicadorDeRefres.setRefreshing(false);
        }catch (Exception e)
        {
            Toast.makeText(getBaseContext(),e.toString(),Toast.LENGTH_SHORT).show();
        }
    }

    public void agregarFlotante(){
        FloatingActionButton miFlotante=(FloatingActionButton) findViewById(R.id.flabMiFlab);
        miFlotante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getBaseContext(),getResources().getString(R.string.mensajitoLoco),Toast.LENGTH_SHORT).show();
                Snackbar.make(view, getResources().getString(R.string.mensajitoLoco),Snackbar.LENGTH_SHORT)
                        .setAction(getResources().getString(R.string.textoAccion), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SNACKBAR","Click en Snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorAccent))
                        .show();

            }
        });
    }
}
