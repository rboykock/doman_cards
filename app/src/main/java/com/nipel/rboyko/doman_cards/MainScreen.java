package com.nipel.rboyko.doman_cards;


import android.app.ActionBar;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.nipel.rboyko.adapters.ThumbsAdapter;
import com.nipel.rboyko.listener.MainListener;
import com.nipel.rboyko.xmlparser.MainScreenXml;
import com.nipel.rboyko.xmlparser.XmlManager;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by rost on 25.04.2016.
 */
public class MainScreen extends AppCompatActivity {
    public static String APP_PATH;
    public static Context CONTEXT;
    public static ArrayList<ArrayList> DATA;

    static String IMG_DIR = "/images";
    static String XML_DIR = "/xml";


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_gv);
        APP_PATH = getFilesDir().getAbsolutePath();
        Log.v("APP_PATH", APP_PATH);

        CONTEXT=getApplicationContext();


        DATA=new XmlManager("part",getResources().getXml(R.xml.main_list)).getData();

        GridView gridView1=(GridView)findViewById(R.id.gridView1);

        gridView1.setAdapter(new ThumbsAdapter(this, DATA));
        gridView1.setOnItemClickListener(new MainListener());


    }
}
