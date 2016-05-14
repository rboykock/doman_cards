package com.nipel.rboyko.doman_cards;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.nipel.rboyko.adapters.CustomeSwipeAdapter;


public class CardScreen extends AppCompatActivity {

    ViewPager viewPager;
    CustomeSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.card_screen);
        String xml =getIntent().getExtras().getString("xml");
        Log.v("TAGXML",xml);

        viewPager=(ViewPager) findViewById(R.id.view_pager);
        Bitmap[] bitmaps_list=new Bitmap[6];
        bitmaps_list[0]= BitmapFactory.decodeFile(MainScreen.APP_PATH+'/'+MainScreen.IMG_DIR + "/ananas.png");
        bitmaps_list[1]= BitmapFactory.decodeFile(MainScreen.APP_PATH+'/'+MainScreen.IMG_DIR+"/apelsin.png");
        bitmaps_list[2]= BitmapFactory.decodeFile(MainScreen.APP_PATH+'/'+MainScreen.IMG_DIR+"/banan.png");
        bitmaps_list[3]= BitmapFactory.decodeFile(MainScreen.APP_PATH+'/'+MainScreen.IMG_DIR+"/kavun.png");
        bitmaps_list[4]= BitmapFactory.decodeFile(MainScreen.APP_PATH+'/'+MainScreen.IMG_DIR+"/vinigrad.png");
        bitmaps_list[5]= BitmapFactory.decodeFile(MainScreen.APP_PATH+'/'+MainScreen.IMG_DIR+"/vishnya.png");

        String[] desc_list=new String[6];

        desc_list[0]="ананас";
        desc_list[1]="апельсин";
        desc_list[2]="банан";
        desc_list[3]="кавун";
        desc_list[4]="виноград";
        desc_list[5]="вишня";

        adapter=new CustomeSwipeAdapter(this,bitmaps_list,desc_list);
        viewPager.setAdapter(adapter);
    }

}
