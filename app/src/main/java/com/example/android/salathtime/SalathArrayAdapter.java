package com.example.android.salathtime;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shefi on 9/21/2016.
 */

public class SalathArrayAdapter extends ArrayAdapter<SalathTime> {
    public SalathArrayAdapter(Context context, List<SalathTime> mylist) {
        super(context, 0 , mylist);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // return super.getView(position, convertView, parent);

        View listview=convertView;

        if(listview==null)
        {
           listview= LayoutInflater.from(getContext()).inflate(R.layout.salath_linear_view,parent,false);
        }

        SalathTime currenPostition=getItem(position);


        TextView tv1= (TextView) listview.findViewById(R.id.salthname);
        TextView tv2=(TextView)listview.findViewById(R.id.salthtime);

        tv1.setText(currenPostition.getSalthName());
        tv2.setText(currenPostition.getSalathTime());

        return listview;

    }
void dateComparison(SalathTime cp,SalathTime np){

        String localTime=Queryutils.checkDate();
        String currentPositiotime=cp.getSalathTime();
        String nextPositionTime=np.getSalathTime();

            String localtime[]=localTime.split(":");
            String currentpositiotime[]=currentPositiotime.split(":");
            String nextpositiotime[]=nextPositionTime.split(":");

    int localhour=Integer.parseInt(localtime[0]);
            int cuurenthour=Integer.parseInt(currentpositiotime[0]);
    int nexthour=Integer.parseInt(nextpositiotime[0]);


    }

}
