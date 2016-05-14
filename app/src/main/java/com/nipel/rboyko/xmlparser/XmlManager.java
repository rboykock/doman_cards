package com.nipel.rboyko.xmlparser;

import android.content.res.XmlResourceParser;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by rost on 29.04.2016.
 */
public class XmlManager {

   // private  Map<String,ArrayList<String>> data=null;
    private ArrayList<ArrayList> data=null;

    public XmlManager(String type,String path) {
    }

    public XmlManager(String type,XmlPullParser xml) {
        if(type.equals("part")){
            MainScreenXml mainScreenXml=new MainScreenXml(xml);
            data=mainScreenXml.getPart_list();
        }
    }

    public ArrayList<ArrayList> getData(){
        return  data;
    }
}
