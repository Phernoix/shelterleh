package com.sp.shelterleh;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;
import com.sp.shelterleh.databinding.ActivityMapsBinding;
import com.google.maps.android.data.geojson.GeoJsonLayer;


import org.json.JSONException;

import java.io.IOException;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng ME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        try{
            GeoJsonLayer layer = new GeoJsonLayer(mMap, R.raw.coveredlinkway,this);
            GeoJsonPolygonStyle polyStyle =layer.getDefaultPolygonStyle();
            polyStyle.setStrokeColor(Color.CYAN);
            polyStyle.setStrokeWidth(2);
            layer.addLayerToMap();
        }catch (IOException e){

        }catch (JSONException e){

        }


        LatLng cck = new LatLng(1.381600, 103.740360);
        mMap.addMarker(new MarkerOptions().position(cck).title("Marker in CCK"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cck));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cck,15));

        /* Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
         */
    }
}