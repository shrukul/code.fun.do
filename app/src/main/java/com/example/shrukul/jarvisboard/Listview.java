package com.example.shrukul.jarvisboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shrukul on 11/13/16.
 */

public class Listview extends Activity {

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    private Toolbar mToolbar;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        mainListView = (ListView) findViewById( R.id.mainListView);

        String[] values = getIntent().getExtras().getStringArray("values");
        ArrayList<String> valueList = new ArrayList<String>();
        valueList.addAll( Arrays.asList(values) );

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(mToolbar);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, valueList);
        mainListView.setAdapter( listAdapter );
    }
}
