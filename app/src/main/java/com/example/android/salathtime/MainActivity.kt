package com.example.android.salathtime

//import android.app.LoaderManager
//import android.content.Loader
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ListView

/**
 * Created by shafe on 7/23/2017.
 */



class MainActivity : AppCompatActivity() , LoaderManager.LoaderCallbacks<List<SalathTime>> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportLoaderManager.initLoader(1,null,this)

    }

        override fun onCreateLoader(id: Int, args: Bundle): Loader<List<SalathTime>> {
            Log.i("IN oncreate loader","pass")
            return SalathTimeLoader(this,URL_ADHAN)
        }


    override fun onLoadFinished(loader: Loader<List<SalathTime>>?, list: List<SalathTime>?) {
        val listview:ListView= findViewById(R.id.list_view_main) as ListView
        val salathArrayAdapter:SalathArrayAdapter = SalathArrayAdapter(this,list)
        listview.adapter=salathArrayAdapter

    }

    override fun onLoaderReset(list: Loader<List<SalathTime>>) {
        list.reset()
    }


    companion object {

        private val URL_ADHAN = "http://api.aladhan.com/timingsByCity?city=Bangalore&country=IN&method=2"
    }



}

//private fun  LoaderManager.initLoader(i: Int, nothing: Nothing?, mainActivity2: MainActivity2) {}
