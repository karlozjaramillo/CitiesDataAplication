package com.cj.citiesdataaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtId;
    private EditText txtNombre;
    private EditText txtPoblacion;
    private EditText txtLatitud;
    private EditText txtLongitud;
    private Button btnGuardar;
    private Button btnListar;
    private ListView lvListar;
    private ArrayAdapter<String> adapter;
    MyDbHelper db = new MyDbHelper(this);
    ArrayList<City> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = findViewById(R.id.txtId);
        txtNombre = findViewById(R.id.txtNombre);
        txtPoblacion = findViewById(R.id.txtPoblacion);
        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnListar = findViewById(R.id.btnListar);
        lvListar = findViewById(R.id.lvListar);
        btnGuardar.setOnClickListener(this);
        btnListar.setOnClickListener(this);

//        City city = new City();
//        city.setId(1);
//        city.setNombre("Manizales");
//        city.setPoblacion(434403);
//        city.setLatitud(5.06889);
//        city.setLongitud(-75.51738);
//        city.setId(2);
//        city.setNombre("Bogotá");
//        city.setPoblacion(7743955);
//        city.setLatitud(4.60971);
//        city.setLongitud(-74.08175);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGuardar:
                agregarCiudad();
                break;
            case R.id.btnListar:
                cities = db.selectCity(db.getWritableDatabase());
                ordenarAlfabeticamente();
                adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cities);
                lvListar.setAdapter(adapter);
                break;
        }
    }

    private void agregarCiudad() {
        int id = Integer.parseInt(txtId.getText().toString());
        String nombre = txtNombre.getText().toString();
        int poblacion = Integer.parseInt(txtPoblacion.getText().toString());
        double latitud = Double.parseDouble(txtLatitud.getText().toString());
        double longitud = Double.parseDouble(txtLongitud.getText().toString());

        City city = new City(id, nombre, poblacion, latitud, longitud);
        db.insertCity(db.getWritableDatabase(), city);
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtId.getText().clear();
        txtNombre.getText().clear();
        txtPoblacion.getText().clear();
        txtLatitud.getText().clear();
        txtLongitud.getText().clear();
    }

    private void ordenarAlfabeticamente() {
        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City c1, City c2) {
                return c1.getNombre().compareTo(c2.getNombre());
            }
        });
    }
}