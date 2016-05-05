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

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by rost on 05.05.2016.
 */
public class ThumbsAdapter extends BaseAdapter{
    protected Map<String,ArrayList<String>> data=null;
    protected String[] mKays;
    protected Context context;

    public ThumbsAdapter(Context context, Map<String, ArrayList<String>> data) {
        this.data = data;
        this.context=context;
        mKays=data.keySet().toArray(new String[data.size()]);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(mKays[position]);
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
        String strPath=values.get(0);
        String title=mKays[position];
        ImageView thubm =(ImageView) grid.findViewById(R.id.image);
        thubm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        thubm.setPadding(8,8,8,8);
        TextView thubm_title=(TextView) grid.findViewById(R.id.title);
        thubm.setImageBitmap(BitmapFactory.decodeFile(MainScreen.APP_PATH + "/icon/"+strPath));
        thubm_title.setText(title);
        return grid;
    }
}
