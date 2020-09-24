package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayAdapter<String> adapter;
    private ArrayList<String> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        datos = new ArrayList<String>();
        datos.add("1");
        datos.add("2");
        adapter.addAll(datos);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadComponents();
    }
    public void LoadComponents(){
        GridView container = (GridView)this.findViewById(R.id.container);
        container.setAdapter(adapter);
        Button add = this.findViewById(R.id.add);
        add.setOnClickListener(this);
        Button remove = this.findViewById(R.id.remove);
        remove.setOnClickListener(this);
        Button roll = this.findViewById(R.id.ro);
        roll.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.add){
            datos.add("1");
        } else if(v.getId() == R.id.remove){
            datos.remove(datos.size()-1);
        } else if(v.getId() == R.id.ro){
            int size = datos.size();
            datos.clear();
            int suma = 0;
            for(int i =0;i<size;i++){
                int number = ThreadLocalRandom.current().nextInt(1,6);
                suma += number;
                datos.add(number + "");
            }
            TextView txt = (TextView)this.findViewById(R.id.results);
            txt.setText("el total es: "+ suma);
        }
        adapter.clear();
        adapter.addAll(datos);
    }
}