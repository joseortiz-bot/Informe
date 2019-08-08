
package com.example.informe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mapa extends AppCompatActivity {

    Button btnTipos,btnUbicacion,btnSitios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        //poner icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        btnSitios = (Button)findViewById(R.id.btn_Sitios);
        btnTipos = (Button)findViewById(R.id.btn_Tipo);
        btnUbicacion =(Button)findViewById(R.id.btn_Ubicacion);

        btnSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity1.class);
                startActivity(intent);
            }
        });
    }


    public void MapaStios(View view)
    {
        Intent intent = new Intent(getApplicationContext(),MapsActivityTipos.class);
        startActivity(intent);
    }

    //metodo localizacion
    public void MapaUbicacion (View view)
    {
        Intent intent = new Intent(getApplicationContext(),MapsActivity_ubicacion.class);
        startActivity(intent);

    }
}
