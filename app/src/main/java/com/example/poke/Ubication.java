package com.example.poke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Ubication extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubication);
    }

    public void onMapReady(GoogleMap map) {
        LatLng latLng = new LatLng(36.679582, -5.444791);
        float zoom = 13;
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
        map.addMarker(new MarkerOptions().position(latLng));
    }
}