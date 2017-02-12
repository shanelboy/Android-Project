package a00944390.comp3717.bcit.ca.comp3717project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements
        OnMapReadyCallback {
    public static final String KEY_SENT_TEXT = "text";

    private GoogleMap mMap;

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
        LatLng latlng = new LatLng(49.2057, -122.9110);
        float zoomLevel = (float) 14.0;
        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, zoomLevel));

        final LatLng newWest = new LatLng(49.2057,-122.9110);
        Marker newWestMin = mMap.addMarker(new MarkerOptions()
                .position(newWest)
                .title("New Westminster")
                .snippet("Park name here"));
        final LatLng vancouver = new LatLng(49.2827,-123.1207);
        Marker newVan = mMap.addMarker(new MarkerOptions()
                .position(vancouver)
                .title("Vancouver")
                .snippet("van parks"));
        final LatLng burnaby = new LatLng(49.2057,-122.9200);
        Marker newBurn = mMap.addMarker(new MarkerOptions()
                .position(burnaby)
                .title("Burnaby")
                .snippet("Burnaby parks"));
        newWestMin.showInfoWindow();
        final Intent intent;
        intent = new Intent(this, ParkActivity.class);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker arg0) {
                if(arg0.getTitle().equals("Burnaby")){
                    intent.putExtra(KEY_SENT_TEXT, "Park in New Westminster");
                    startActivity(intent);
                }

                return true;
            }
        });
    }

}
