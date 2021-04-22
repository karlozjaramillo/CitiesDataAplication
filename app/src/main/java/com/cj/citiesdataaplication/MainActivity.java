package com.cj.citiesdataaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText txtId;
    private EditText txtNombre;
    private EditText txtPoblacion;
    private EditText txtLatitud;
    private EditText txtLongitud;
    private Button btnGuardar;
    private ListView lvListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHelper db = new MyDbHelper(this);
        City city = new City();
        city.setId(1);
        city.setNombre("Manizales");
        city.setPoblacion(434403);
        city.setLatitud(5.06889);
        city.setLongitud(-75.51738);
        city.setId(2);
        city.setNombre("Bogotá");
        city.setPoblacion(7743955);
        city.setLatitud(4.60971);
        city.setLongitud(-74.08175);

        db.insertCity(db.getWritableDatabase(), city);

        ArrayList<City> cities = db.selectCity(db.getWritableDatabase());
        for (City citySelected : cities) {
            System.out.println("ID: " + citySelected.getId() + "\n" +
                    "Nombre: " + citySelected.getNombre() + "\n" +
                    "Población: " + citySelected.getPoblacion() + "\n" +
                    "Latitud: " + citySelected.getLatitud() + "\n" +
                    "Longitud: " + citySelected.getLatitud());
        }
    }
}