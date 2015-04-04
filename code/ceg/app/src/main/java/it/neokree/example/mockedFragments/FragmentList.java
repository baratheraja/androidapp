package it.neokree.example.mockedFragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

import it.neokree.example.MainActivity;
import it.neokree.example.R;
import it.neokree.example.ServiceHandler;

/**
 * Created by neokree on 11/01/15.
 */
public class FragmentList extends Fragment{

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    ImageView image = new ImageView(getActivity());
    image.setLayoutParams(new RelativeLayout.LayoutParams(
            LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
    image.setBackgroundResource(R.drawable.ceg2);
    return image;
        }
}
