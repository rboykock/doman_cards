package com.nipel.rboyko.xmlparser;

import android.content.res.XmlResourceParser;
import android.util.Log;

import com.nipel.rboyko.doman_cards.R;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by rost on 29.04.2016.
 */
public class MainScreenXml {
    private XmlPullParser category_xml;
    private ArrayList<ArrayList> part_list=new ArrayList<ArrayList>();

    public MainScreenXml(String path) {
        parse();
    }

    public MainScreenXml(XmlPullParser xml) {
         category_xml = xml;
         parse();
    }

    public ArrayList<ArrayList> getPart_list(){
        return part_list;
    }

    protected void parse(){
        Boolean lng=false;
        Boolean title=false;
        ArrayList<String> value=null;
        try {
            while (category_xml.getEventType() != XmlPullParser.END_DOCUMENT) {

                if(category_xml.getEventType()==XmlPullParser.START_TAG) {
                    if(category_xml.getName().equals("category")){
                        Log.v("TAGNAME", '<'+category_xml.getName()+'>');
                       // key=category_xml.getAttributeValue(0);
                        value=new ArrayList<String>();
                    }
                    if(category_xml.getName().equals("title")){
                        title=true;
                        if((category_xml.getAttributeName(0).equals("lng")) && (category_xml.getAttributeValue(0).equals("ua"))) {
                              Log.v("TAGNAME", category_xml.getAttributeValue(0));
                              lng=true;
                        }
                    }
                }
                if (category_xml.getEventType() == XmlPullParser.TEXT) {
                    Log.v("TAGNAME", category_xml.getText());
                    if(title){
                        if(lng){
                            value.add(category_xml.getText());
                            lng=false;
                        }else {
                            category_xml.next();
                            continue;
                        }
                    }else {
                        value.add(category_xml.getText());
                    }
                }
                if(category_xml.getEventType() ==XmlPullParser.END_TAG){
                    if(category_xml.getName().equals("category")) {
                        Log.v("TAGNAME", "</"+category_xml.getName()+'>');
                        part_list.add(value);
                    }
                    if(category_xml.getName().equals("title")){
                        title=false;
                    }
                }

                category_xml.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.v("TAGNAME","Done");
    }
}
