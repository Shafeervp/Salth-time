package com.example.android.salathtime;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Shefi on 9/21/2016.
 */

public class Queryutils {

    public Queryutils() {
    }


    public static ArrayList<SalathTime> makeHttpRequest(String mUrl) throws JSONException {

         ArrayList<SalathTime> salathTimes=new ArrayList<>();

        String currentTime=checkDate();

        URL url;
        url = createUrl(mUrl);
        InputStream inputStream;
        try {
            HttpURLConnection httpURLconnection=(HttpURLConnection)url.openConnection();

            httpURLconnection.setConnectTimeout(1500);
            httpURLconnection.setReadTimeout(1000);
            httpURLconnection.setRequestMethod("GET");
            httpURLconnection.connect();

            inputStream = httpURLconnection.getInputStream();
            String jsonString=readStream(inputStream);

            salathTimes=extractJson(jsonString,salathTimes);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return salathTimes;

    }

    private static ArrayList<SalathTime> extractJson(String jsonString, ArrayList<SalathTime> salathTimes) throws JSONException {




        JSONObject jsonroot=new JSONObject(jsonString);

        JSONObject data=jsonroot.getJSONObject("data");
        JSONObject timings=data.getJSONObject("timings");

        String fajr=timings.getString("Fajr");
        String sunrise=timings.getString("Sunrise");
        String dhuhr=timings.getString("Dhuhr");
        String asr=timings.getString("Asr");
        String maghrib=timings.getString("Maghrib");
        String isha=timings.getString("Isha");


        salathTimes.add(new SalathTime("Fajr",fajr));
        salathTimes.add(new SalathTime("Sunrise",sunrise));
        salathTimes.add(new SalathTime("Dhuhr",dhuhr));
        salathTimes.add(new SalathTime("Asr",asr));
        salathTimes.add(new SalathTime("Maghrib",maghrib));
        salathTimes.add(new SalathTime("Isha",isha));
       // salathTimes.add(new SalathTime(fajr,sunset));

        return salathTimes;


    }

    private static String readStream(InputStream inputStream) throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        StringBuilder responseString=new StringBuilder();
        String tempString=reader.readLine();


        while (tempString!=null)
        {
            responseString=responseString.append(tempString);
            tempString=reader.readLine();


        }
                return responseString.toString();
    }

    private static URL createUrl(String mUrl) {

        URL url= null;
        try {
            url = new URL(mUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;

    }

    public static String checkDate()

    {

        Date time =new Date(new Date().getTime());


        SimpleDateFormat simpledateformat = new SimpleDateFormat("kk:mm");


        String currentDate=simpledateformat.format(time);
        return currentDate;


    }


}
