package com.example.android.salathtime;

import java.util.ArrayList;

/**
 * Created by Shefi on 9/21/2016.
 */

public class SalathTime extends ArrayList {
    private  String salthName, salathTime;

    public String getSalthName() {
        return salthName;
    }

    public String getSalathTime() {
        return salathTime;
    }


    public SalathTime(String sunrise, String s) {
        this.salthName = sunrise;
        this.salathTime = s;
    }
}
