package com.example.android.salathtime;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<List<SalathTime>> {

    private final static String URL_ADHAN="http://api.aladhan.com/timingsByCity?city=Bangalore&country=IN&method=2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("In  Main Activity",URL_ADHAN);

        getSupportLoaderManager().initLoader(1,null,this);

    }


    @Override
    public Loader<List<SalathTime>> onCreateLoader(int id, Bundle args) {

        return new SalathTimeLoader(this,URL_ADHAN);
    }



    @Override
    public void onLoadFinished(Loader<List<SalathTime>> loader, List<SalathTime> data) {

        ListView listView=(ListView)findViewById(R.id.list_view_main);
        SalathArrayAdapter adapter=new SalathArrayAdapter(MainActivity.this, data);
        listView.setAdapter(adapter);

    }

    @Override
    public void onLoaderReset(Loader<List<SalathTime>> loader) {
        loader.reset();

    }
}
