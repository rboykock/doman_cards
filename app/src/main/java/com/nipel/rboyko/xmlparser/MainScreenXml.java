package com.nipel.rboyko.xmlparser;

import android.content.res.XmlResourceParser;
import android.util.Log;

import com.nipel.rboyko.doman_cards.R;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rost on 29.04.2016.
 */
public class MainScreenXml {
    private XmlPullParser category_xml;
    private Map<String,ArrayList<String>> part_list=new HashMap<String,ArrayList<String>>();

    public MainScreenXml(String path) {
        parse();
    }

    public MainScreenXml(XmlResourceParser res) {
         category_xml = res;
         parse();
    }

    public Map<String,ArrayList<String>> getPart_list(){
        return part_list;
    }

    protected void parse(){
        String key="";
        ArrayList<String> value=null;
        try {
            while (category_xml.getEventType() != XmlPullParser.END_DOCUMENT) {
                if(category_xml.getEventType()==XmlPullParser.START_TAG) {
                    if(category_xml.getName().equals("category")){
                        Log.v("TAGNAME", category_xml.getAttributeValue(0));
                        key=category_xml.getAttributeValue(0);
                        value=new ArrayList<String>();
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
    }
}
