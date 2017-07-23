package com.example.android.salathtime;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import org.json.JSONException;

import java.util.List;

/**
 * Created by Shefi on 9/21/2016.
 */

public class SalathTimeLoader extends AsyncTaskLoader<List<SalathTime>> {


    public String mUrl;
    List<SalathTime> salathTimes;

    public SalathTimeLoader(Context context,String url) {
        super(context);
        this.mUrl=url;
    }


    @Override
    public List<SalathTime> loadInBackground() {

        Log.i("In Salathtime Loader",mUrl);

        try {
            salathTimes =  Queryutils.makeHttpRequest(mUrl);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return salathTimes;
    }


    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}

