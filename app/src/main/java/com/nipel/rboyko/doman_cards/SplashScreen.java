package com.nipel.rboyko.doman_cards;


import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nipel.rboyko.adapters.CustomeSwipeAdapter;

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

    }
}
