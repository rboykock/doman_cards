package com.nipel.rboyko.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.nipel.rboyko.doman_cards.SplashScreen;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFileAsync extends AsyncTask<String,String,String> {

    private  ProgressDialog progressDialog;

    public DownloadFileAsync(ProgressDialog progressDialog){
        this.progressDialog=progressDialog;
    }

    @Override
    protected void onPreExecute(){

    }

    @Override
    protected String doInBackground(String... params) {
        String url=params[0];
        String file=params[1];
        int count;
        try {
            URL dhurl=new URL(params[0]);
            URLConnection connection=  dhurl.openConnection();
            connection.connect();
            int lengthOfFile=connection.getContentLength();
            Log.v("INFO", "Length download file " + lengthOfFile);

            InputStream inputStream=new BufferedInputStream(dhurl.openStream());
            OutputStream outputStream=new FileOutputStream(file);
            byte data[]=new byte[1024];

            long total=0;

            while((count=inputStream.read(data)) !=-1){
                total+=count;
                publishProgress(""+(int)((total*100/lengthOfFile)));
                outputStream.write(data,0,count);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "DONE";
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(Integer.parseInt(values[0]));
    }

    @Override
    protected void onPostExecute(String unused){

    }
}