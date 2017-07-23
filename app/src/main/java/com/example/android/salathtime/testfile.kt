package com.example.android.salathtime

import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ListView

/**
 * Created by shafe on 7/23/2017.
 */

class MainActivity3 : AppCompatActivity(), LoaderManager.LoaderCallbacks<List<SalathTime>> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("In  Main Activity", URL_ADHAN)

        supportLoaderManager.initLoader(1, null,this)

    }


    override fun onCreateLoader(id: Int, args: Bundle): Loader<List<SalathTime>> {

        return SalathTimeLoader(this, URL_ADHAN)
    }


    override fun onLoadFinished(loader: Loader<List<SalathTime>>, data: List<SalathTime>) {

        val listView = findViewById(R.id.list_view_main) as ListView
        val adapter = SalathArrayAdapter(this@MainActivity3, data)
        listView.adapter = adapter

    }

    override fun onLoaderReset(loader: Loader<List<SalathTime>>) {
        loader.reset()

    }

    companion object {

        private val URL_ADHAN = "http://api.aladhan.com/timingsByCity?city=Bangalore&country=IN&method=2"
    }
}
