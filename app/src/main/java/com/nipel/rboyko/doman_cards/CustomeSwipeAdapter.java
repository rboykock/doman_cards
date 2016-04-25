package com.nipel.rboyko.doman_cards;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by rost on 15.04.2016.
 */
public class CustomeSwipeAdapter extends PagerAdapter {

    private int[] images_res={R.drawable.ananas,R.drawable.apelsin,R.drawable.banan,R.drawable.kavun,R.drawable.vinigrad,R.drawable.vishnya};
    private Context context;
    private LayoutInflater layoutInflater;
    private Bitmap[] bitmaps_list;
    private String[] desc_list;

    public CustomeSwipeAdapter(Context context,Bitmap[] bitmaps_list,String[] desc_list) {
        this.context = context;
        this.bitmaps_list= bitmaps_list;
        this.desc_list=desc_list;
    }

    @Override
    public int getCount() {
        return bitmaps_list.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.swipe_layout,container,false);
        TextView textView=(TextView) item_view.findViewById(R.id.image_count);
        TextView desc=(TextView)item_view.findViewById(R.id.desc);
        ImageView imageView=(ImageView) item_view.findViewById(R.id.image_view);
        textView.setText("Image :" + position);
        desc.setText(desc_list[position]);
        imageView.setImageBitmap(bitmaps_list[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
