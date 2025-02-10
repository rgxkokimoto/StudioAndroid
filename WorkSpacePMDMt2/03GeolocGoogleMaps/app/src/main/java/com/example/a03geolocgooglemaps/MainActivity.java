package com.example.a03geolocgooglemaps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Implementación del mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fhMap);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;

        // TODO método para interactuar con el mapa
        //this.mMap.setOnMapClickListener(this);
        //this.mMap.setOnMapLongClickListener(this);


        // Tipos de mapa
        //mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // Add Ubicaciones
        LatLng lol = new LatLng(40.416775, -3.703790);
        LatLng diversia = new LatLng(40.5300823, -3.6422473);
        LatLng plaza_norte = new LatLng(40.540753,-3.6162928);
        LatLng ue = new LatLng(40.5351268,-3.6187895);

        // Marcdores
        mMap.addMarker(new MarkerOptions()
                        .position(lol)
                        .title("Lol")
                        .icon(BitmapDescriptorFactory.defaultMarker()))
                        .showInfoWindow();

        mMap.addMarker(new MarkerOptions()
                        .position(diversia)
                        .title("Diversia")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
                        .showInfoWindow();

        mMap.addMarker(new MarkerOptions()
                        .position(plaza_norte)
                        .title("Plaza Norte")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.vector)))
                        .showInfoWindow();

        mMap.addMarker(new MarkerOptions()
                        .position(ue)
                        .title("Universidad Europea")
                        .snippet("Esto es un snipten de prueba")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.vector)))
                        .showInfoWindow();


        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(plaza_norte, 17f);// Mover la camara a la ubicacion de referencia
        mMap.moveCamera(cameraUpdate);

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

            // Mandar a llamar la app de google maps si esta la aplicación instalada

            @Override
            public void onInfoWindowClick(@NonNull Marker marker) {
                String uri = "google.navigation:q="
                        + marker.getPosition().latitude + ","
                        + marker.getPosition().longitude
                        + "&mode=w"; // w andar , (por defecto) d conducir , b bicicleta, r trasporte público


                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);
            }
        });

    }
    
}