package com.nipel.rboyko.xmlparser;

import android.content.res.XmlResourceParser;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by rost on 29.04.2016.
 */
public class XmlManager {

    private  Map<String,ArrayList<String>> data=null;

    public XmlManager(String type,String path) {
    }

    public XmlManager(String type,XmlResourceParser res) {
        if(type.equals("part")){
            MainScreenXml mainScreenXml=new MainScreenXml(res);
            data=mainScreenXml.getPart_list();
        }
    }

    public Map<String,ArrayList<String>> getData(){
        return  data;
    }
}
