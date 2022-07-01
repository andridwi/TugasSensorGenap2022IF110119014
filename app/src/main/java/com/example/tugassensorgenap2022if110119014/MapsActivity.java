 /*  NIM : 10119014
  *  NAMA : Andri Dwi P
  *  KELAS : IF-1
  */
package com.example.tugassensorgenap2022if110119014;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.tugassensorgenap2022if110119014.databinding.ActivityMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity{

    private ActivityMapsBinding binding;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        client = LocationServices.getFusedLocationProviderClient(this);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        getCurrentLocation();
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null ) {
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {
                            LatLng lokasiSaatIni = new LatLng(location.getLatitude(), location.getLongitude());
                            LatLng lokasi1 = new LatLng(-6.97857, 107.83353);
                            LatLng lokasi2 = new LatLng(-6.98159,107.83457);
                            LatLng lokasi3 = new LatLng(-6.98348,107.83555);
                            LatLng lokasi4 = new LatLng(-6.98320,107.82909);
                            LatLng lokasi5 = new LatLng(-6.96601,107.82961);

                            googleMap.addMarker(new MarkerOptions().position(lokasiSaatIni).title("Lokasi Saat Ini"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi1).title("Shinju Ramen"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi2).title("Mixue"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi3).title("Cimol Mahmud "));
                            googleMap.addMarker(new MarkerOptions().position(lokasi4).title("SaungAnaking"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi5).title("Warung Nasi Ampera"));

                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasiSaatIni, 15));
                        }
                    });
                }
            }
        });
    }
}