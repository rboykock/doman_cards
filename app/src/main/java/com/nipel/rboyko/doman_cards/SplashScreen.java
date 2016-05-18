package com.nipel.rboyko.doman_cards;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.nipel.rboyko.adapters.CustomeSwipeAdapter;
import com.nipel.rboyko.tasks.DownloadFileAsync;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SplashScreen extends AppCompatActivity {

    ViewPager viewPager;
    CustomeSwipeAdapter adapter;
    SharedPreferences preferences;
    static final int DIALOG_DOWNLOAD_PROGRESS=0;
    private ProgressDialog progressDialog;
    static String URL_VERSION="http://10.0.3.2/android/doman_cards.txt";
    static String URL_FILE="http://10.0.3.2/android/update.zip";
    static float CURENT_VERSION;
    final String VERSION="VERSION";
    final String FILE_UPDATE="/update.zip";
    private float NEW_VERSION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.splash);

        Thread getHttpVersion=new Thread(){
            public void run(){
                NEW_VERSION=checkVersion();
            }
        };

        getHttpVersion.start();

        CURENT_VERSION=loadVersion();



        if(CURENT_VERSION< NEW_VERSION){
            saveVersion(NEW_VERSION);
            loadNewVersion();
        }

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

    void saveVersion(float version){
        Log.v("INFO", "Save new version " + String.valueOf(version));
        preferences=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putFloat(VERSION,version);
        editor.commit();
    }

    float loadVersion(){

        preferences=getPreferences(MODE_PRIVATE);
        float version = preferences.getFloat(VERSION, (float) 1.0);
        Log.v("INFO", "Curent version " + String.valueOf(version));
        return version;
    }

    float checkVersion(){
        URL dhurl;
        String version="";

        try {
            dhurl=new URL(URL_VERSION);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(dhurl.openStream()));
            String stringBuffer;
            while ((stringBuffer=bufferedReader.readLine())!=null){
                version+=stringBuffer;
            }
            bufferedReader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return Float.parseFloat(version);
    }

    void loadNewVersion(){
        Log.v("INFO","Load new version ....");
        progressDialog=new ProgressDialog(SplashScreen.this);
        progressDialog.setMessage("Download file ..");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
        progressDialog.setProgress(0);
        progressDialog.show();
        new DownloadFileAsync(progressDialog).execute(URL_FILE, getFilesDir().getAbsolutePath() + '/' + FILE_UPDATE);
    }

}
