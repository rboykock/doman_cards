package com.nipel.rboyko.doman_cards;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rost on 25.04.2016.
 */
public class MainScreen extends AppCompatActivity implements View.OnClickListener {
    static String APP_PATH;
    static String IMG_DIR = "/images";
    static String XML_DIR = "/xml";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        APP_PATH = getFilesDir().getAbsolutePath();
        Log.v("APP_PATH", APP_PATH);

        XmlPullParser category_xml = getResources().getXml(R.xml.main_list);
        Map<String,ArrayList<String>> part_list=new HashMap<String,ArrayList<String>>();
        String key="";
        ArrayList<String> value=new ArrayList<String>();
        try {
            while (category_xml.getEventType() != XmlPullParser.END_DOCUMENT) {
                if(category_xml.getEventType()==XmlPullParser.START_TAG) {
                        if(category_xml.getName().equals("category")){
                            Log.v("TAGNAME", category_xml.getAttributeValue(0));
                            key=category_xml.getAttributeValue(0);
                            value.clear();
                        }
                }
                if (category_xml.getEventType() == XmlPullParser.TEXT) {
                    Log.v("TAGNAME", category_xml.getText());
                    value.add(category_xml.getText());
                }
                if(category_xml.getEventType() ==XmlPullParser.END_TAG){
                    if(category_xml.getName().equals("category")){
                        Log.v("TAGNAME", category_xml.getName());
                        part_list.put(key,value);
                    }
                }

                category_xml.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button start_card = (Button) findViewById(R.id.start_card);
        start_card.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_card:
                Log.v("CARD", "Start card");

                break;
        }
    }
}
