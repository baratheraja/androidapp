package it.neokree.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
/**
 * Created by baratheraja on 4/4/15.
 */
public class MapActivity extends Activity {

    GoogleMap googleMap;

    private void createMapView(){
        /**
         * Catch the null pointer exception that
         * may be thrown when initialising the map
         */
        try {
            if(null == googleMap){
                googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.mapView)).getMap();

                /**
                 * If the map is still null after attempted initialisation,
                 * show an error to the user
                 */
                if(null == googleMap) {
                    Toast.makeText(getApplicationContext(),
                            "Error creating map", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (NullPointerException exception){
            Log.e("mapApp", exception.toString());
        }
    }
    private void addMarker(){

        /** Make sure that the map has been initialised **/
        if(null != googleMap){
            LatLng latLng = new LatLng(13.012788,80.234109);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

            // Zoom in the Google Map
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(14));
            googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(13.012788, 80.234109))
                            .title("Marker")
                            .draggable(true)
            );
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        createMapView();
        addMarker();
    }
}