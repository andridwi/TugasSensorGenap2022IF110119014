 /*  NIM : 10119014
  *  NAMA : Andri Dwi P
  *  KELAS : IF-1
  */
package com.example.tugassensorgenap2022if110119014;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tugassensorgenap2022if110119014.databinding.ActivityMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;


    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));

            LatLng lokasiSaatIni = new LatLng( -6.977164, 107.832948);
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
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(callback);
    }
}