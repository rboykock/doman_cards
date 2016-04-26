package com.nipel.rboyko.doman_cards;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;

public class SplashScreen extends AppCompatActivity {

    ViewPager viewPager;
    CustomeSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.splash);

        Thread splashTimer =new Thread() {
            public void run() {
                try {
                    int splashTimer = 0;
                    while (splashTimer < 5000) {
                        sleep(100);
                        splashTimer = splashTimer + 100;
                    }
                    startActivity(new Intent("com.nipel.rboyko.doman_cards.MAINSCREEN"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };
        splashTimer.start();


        /*
        viewPager=(ViewPager) findViewById(R.id.view_pager);
        Bitmap[] bitmaps_list=new Bitmap[6];
        bitmaps_list[0]= BitmapFactory.decodeFile(img_dir+"/ananas.png");
        bitmaps_list[1]= BitmapFactory.decodeFile(img_dir+"/apelsin.png");
        bitmaps_list[2]= BitmapFactory.decodeFile(img_dir+"/banan.png");
        bitmaps_list[3]= BitmapFactory.decodeFile(img_dir+"/kavun.png");
        bitmaps_list[4]= BitmapFactory.decodeFile(img_dir+"/vinigrad.png");
        bitmaps_list[5]= BitmapFactory.decodeFile(img_dir+"/vishnya.png");

        String[] desc_list=new String[6];

        desc_list[0]="ананас";
        desc_list[1]="апельсин";
        desc_list[2]="банан";
        desc_list[3]="кавун";
        desc_list[4]="виноград";
        desc_list[5]="вишня";

        adapter=new CustomeSwipeAdapter(this,bitmaps_list,desc_list);
        viewPager.setAdapter(adapter);

*/
        //ImageView imageView=(ImageView)findViewById(R.id.imageView);
       // Bitmap img= BitmapFactory.decodeFile(img_dir+"/ananas.png");
       // imageView.setImageBitmap(img);
    }
}
