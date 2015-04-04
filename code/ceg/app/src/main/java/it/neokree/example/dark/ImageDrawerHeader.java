package it.neokree.example.dark;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.pushbots.push.Pushbots;

import it.neokree.example.About;
import it.neokree.example.Events;
import it.neokree.example.MainActivity2Activity;
import it.neokree.example.MapActivity;
import it.neokree.example.News;
import it.neokree.example.R;
import it.neokree.example.customHandler;
import it.neokree.example.mockedActivity.Settings;
import it.neokree.example.mockedFragments.FragmentButton;
import it.neokree.example.mockedFragments.FragmentIndex;
import it.neokree.example.mockedFragments.FragmentList;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
/**
 * Created by neokree on 18/01/15.
 */
public class ImageDrawerHeader extends MaterialNavigationDrawer {
    @Override

    public void init(Bundle savedInstanceState) {
        Pushbots.sharedInstance().init(this);

        String s=Pushbots.sharedInstance().regID();
        Log.d("REGid",">"+s);
       // Pushbots.sharedInstance().setCustomHandler(customHandler.class);
        /* set the header image */
        this.setDrawerHeaderImage(R.drawable.ceg);
        // create sections
        this.addSection(newSection("Home",new FragmentList() ).setSectionColor(Color.parseColor("#8bc34a")));
        this.addSection(newSection("About",new Intent(this,About.class)).setSectionColor(Color.parseColor("#8bc34a")));
        this.addSection(newSection("News",new Intent(this,News.class)).setSectionColor(Color.parseColor("#8bc34a")));
        this.addSection(newSection("Contacts",new Intent(this,MainActivity2Activity.class)).setSectionColor(Color.parseColor("#8bc34a")));
        this.addSection(newSection("Events", new Intent(this, Events.class)).setSectionColor(Color.parseColor("#8bc34a")));
        this.addSection(newSection("Map",new Intent(this,MapActivity.class)).setSectionColor(Color.parseColor("#8bc34a")));

        this.addSection(newSection("Section",R.drawable.ic_hotel_grey600_24dp,new FragmentButton()).setSectionColor(Color.parseColor("#03a9f4")));
           // create bottom section

    }
}
