package com.nipel.rboyko.doman_cards;


import android.app.ActionBar;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.nipel.rboyko.xmlparser.MainScreenXml;
import com.nipel.rboyko.xmlparser.XmlManager;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rost on 25.04.2016.
 */
public class MainScreen extends AppCompatActivity implements View.OnClickListener {
    public static String APP_PATH;
    static String IMG_DIR = "/images";
    static String XML_DIR = "/xml";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_gv);
        APP_PATH = getFilesDir().getAbsolutePath();
        Log.v("APP_PATH", APP_PATH);

        Map<String,ArrayList<String>> data=new XmlManager("part",getResources().getXml(R.xml.main_list)).getData();
        GridView gridView1=(GridView)findViewById(R.id.gridView1);
        /*
        ArrayList<ImageView> imageViewArrayList=new ArrayList<ImageView>();
        for (Map.Entry<String, ArrayList<String>> etry:data.entrySet()){
            String key=etry.getKey();
            Log.v("XMLTAG", key);
            ArrayList<String> value=etry.getValue();
            Log.v("XMLTAG",value.get(0));
            Log.v("XMLTAG", value.get(1));

            ImageView icon=new ImageView(this);
            //icon.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            Log.v("DIR", APP_PATH + "/icon/" + value.get(0));
            icon.setImageBitmap(BitmapFactory.decodeFile(APP_PATH + "/icon/" + value.get(0)));
            icon.setTag(key);
            icon.setOnClickListener(this);

            gridView1.addView(icon);

        }
*/
        gridView1.setAdapter(new ThumbsAdapter(this,data));
       // Button start_card = (Button) findViewById(R.id.start_card);
      //  start_card.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
       Log.v("VIEWTAG", (String) v.getTag());
    }
}
