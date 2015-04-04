package it.neokree.example;

import android.app.ActionBar;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;



public class Events extends ActionBarActivity {


    private ProgressDialog pDialog;

    // URL to get contacts JSON
    private static String url = "https://kceg.herokuapp.com/event_and_activities.json";

    // JSON Node names

    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_START = "start_date";
    private static final String TAG_END = "end_date";
    private static final String TAG_DESC = "description";
    private static final String TAG_CONTACT = "contact";
    private static final String TAG_PLACE = "place";

    // contacts JSONArray
    JSONArray contacts = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity2, menu);

        return (super.onCreateOptionsMenu(menu));
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactList = new ArrayList<HashMap<String, String>>();
        android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.setTitle("EVENTS");
        ab.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.fragment_item_list);
        // Calling async task to get json
        new GetContacts().execute();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




    /**
     * Async task class to get json by making HTTP call
     * */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog


        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    contacts = new JSONArray(jsonStr);
                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_NAME);
                        String start = c.getString(TAG_START);
                        String end = c.getString(TAG_END);
                        String desc=c.getString(TAG_DESC);
                        // Phone node is JSON Object
                        String contac = c.getString(TAG_CONTACT);

                        String place = c.getString(TAG_PLACE);
                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        id= Html.fromHtml(id).toString();
                        name= Html.fromHtml(name).toString();
                        start= Html.fromHtml(start).toString();
                        end= Html.fromHtml(end).toString();
                        desc= Html.fromHtml(desc).toString();
                        contac= Html.fromHtml(contac).toString();
                        place= Html.fromHtml(place).toString();
                        // adding each child node to HashMap key => value
                        contact.put(TAG_ID, "ID :"+id);
                        contact.put(TAG_NAME,"NAME :"+ name);
                        contact.put(TAG_START,"STARTING AT :"+ start);
                        contact.put(TAG_END,"ENDING AT :"+ end);
                        contact.put(TAG_DESC,"DESCRIPTION :"+ desc);
                        contact.put(TAG_CONTACT,"CONTACT :"+ contac);
                        contact.put(TAG_PLACE,"PLACE :"+ place);




                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                   Events.this, contactList,
                    R.layout.list_item2, new String[] { TAG_NAME,TAG_PLACE, TAG_START,
                    TAG_END,TAG_DESC,TAG_CONTACT }, new int[] { R.id.name,
                    R.id.place,R.id.start, R.id.end,R.id.desc,R.id.phone});
            ListView lv = (ListView) findViewById(R.id.list);
            lv.setAdapter(adapter);
        }
    }

}