package com.nipel.rboyko.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.nipel.rboyko.doman_cards.MainScreen;
import com.nipel.rboyko.doman_cards.R;
import com.nipel.rboyko.listener.MainListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by rost on 05.05.2016.
 */
public class ThumbsAdapter extends BaseAdapter{
    protected ArrayList data=null;
    protected MainListener mainListener=new MainListener();
    protected Context context;

    public ThumbsAdapter(Context context, ArrayList data) {
        this.data = data;
        this.context=context;
        //mKays=data.keySet().toArray(new String[data.size()]);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        if(convertView==null){
            grid=new View(context);
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid=inflater.inflate(R.layout.cellgrid,parent,false);
        } else {
            grid=(View)convertView;
        }
        ArrayList<String> values=(ArrayList<String>) getItem(position);
        String icon=values.get(0);
        String xml=values.get(1);
        String title=values.get(2);
        ImageView thubm =(ImageView) grid.findViewById(R.id.image);
        thubm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        thubm.setPadding(8, 8, 8, 8);
        TextView thubm_title=(TextView) grid.findViewById(R.id.title);
        thubm.setImageBitmap(BitmapFactory.decodeFile(MainScreen.APP_PATH + "/icon/" + icon));
        thubm_title.setText(title);
        //thubm.setOnClickListener(mainListener);
        return grid;
    }
}
