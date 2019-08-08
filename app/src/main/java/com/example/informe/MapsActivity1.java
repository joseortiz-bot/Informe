package com.example.informe;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapsActivity1 extends AppCompatActivity implements GoogleMap.OnInfoWindowClickListener,GoogleMap.OnMarkerDragListener,OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker markerPrueba,markerDrag,infoWindows;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        //poner icono action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Chile = new LatLng(-31.7613365, -71.3187697);
        mMap.addMarker(new MarkerOptions().position(Chile).draggable(true).title("Santiago de Chile").snippet("Santiago, la capital y la ciudad más grande de Chile, se ubica en un valle rodeado de cimas nevadas de los Andes y la Cordillera de la Costa chilena"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Chile,3));

        LatLng Ucrania = new LatLng(49.4871968, 31.2718321);
        mMap.addMarker(new MarkerOptions().position(Ucrania).draggable(true).title("Ciudad de Ucrania").snippet("Ucrania es un extenso país de Europa Oriental, Limita con Rusia hacia el este, con Bielorrusia al norte, con Polonia, Eslovaquia y Hungría hacia el oeste."));

        LatLng Puerto_Varas = new LatLng(-41.3178431, -72.9827187);
        mMap.addMarker(new MarkerOptions().position(Puerto_Varas).draggable(true).title("Puerto Varas").snippet("Puerto Varas es una ciudad y comuna chilena ubicada en la provincia de Llanquihue (región de Los Lagos). Fue creada a partir de la colonización alemana con inmigrantes que se asentaron a orillas del lago Llanquihue entre los años 1852 y 1853. "));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Chile,3));

        LatLng Dubai = new LatLng(25.0750095, 55.1887609);
        mMap.addMarker(new MarkerOptions().position(Dubai).draggable(true).title("Dubái").snippet("Dubái7 —en árabe, دبيّ, Dubayy— es uno de los siete emiratos que conforman los Emiratos Árabes Unidos, cuya capital es la ciudad homónima. Está situado en la costa del golfo Pérsico, en el desierto de Arabia. "));

        //Marcador de prueba
        LatLng nueva_york = new LatLng(40.7308619, -73.9871558);
        markerPrueba = googleMap.addMarker(new MarkerOptions()
        .position(nueva_york)
        .title("nueva york"));

        //España
        LatLng España = new LatLng(39.3262345, -4.8380649);
        markerDrag = googleMap.addMarker(new MarkerOptions()
                .position(España)
                .title("España")
                .draggable(true));
        //informacion
        LatLng Españ = new LatLng(39.3262345, -4.8380649);
        infoWindows = googleMap.addMarker(new MarkerOptions()
                        .position(Españ)
                        .title("Españ"));
        //
        LatLng ucrani = new LatLng(49.4871968, 31.2718321);
        infoWindows = googleMap.addMarker(new MarkerOptions()
                .position(ucrani)
                .title("ucrani"));
        //
        LatLng chil = new LatLng(-31.7613365, -71.3187697);
        infoWindows = googleMap.addMarker(new MarkerOptions()
                .position(chil)
                .title("chil"));
        //
        LatLng Duba = new LatLng(25.0750095, 55.1887609);
        infoWindows = googleMap.addMarker(new MarkerOptions()
                .position(Duba)
                .title("Duba"));



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Chile,3));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Ucrania,3));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Puerto_Varas,3));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dubai,3));
//clic en el marcador
        googleMap.setOnMarkerClickListener(this);
        //Arrastrar el marcador
        googleMap.setOnMarkerDragListener(this);
        //Dialog
        googleMap.setOnInfoWindowClickListener(this);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        String lat,lng;
        if(marker.equals(markerPrueba)){
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this,lat + "," + lng,Toast.LENGTH_SHORT).show();
            Toast.makeText(this,  "Nueva york" ,Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
      if(marker.equals(markerDrag)){
          Toast.makeText(this,"Start",Toast.LENGTH_LONG).show();
      }
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        if(marker.equals(markerDrag)){
            String newTitle = String.format(Locale.getDefault(),
                    getString(R.string.market_delait_latlng),
                    marker.getPosition().latitude,
                    marker.getPosition().longitude);
            setTitle(newTitle);
        }

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        if(marker.equals(markerDrag)){
            Toast.makeText(this,"Stop",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        if(marker.equals(infoWindows)){

            Tofragme.newInstance(marker.getTitle(),
                    getString(R.string.Chile))
                    .show(getSupportFragmentManager(), null);

            Tofragme.newInstance(marker.getTitle(),
                    getString(R.string.ucrania))
                    .show(getSupportFragmentManager(), null);
            Tofragme.newInstance(marker.getTitle(),
                    getString(R.string.Dubai))
                    .show(getSupportFragmentManager(), null);
        }
    }
}
