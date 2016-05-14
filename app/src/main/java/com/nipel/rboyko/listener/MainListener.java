package com.nipel.rboyko.listener;


import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.nipel.rboyko.doman_cards.CardScreen;
import com.nipel.rboyko.doman_cards.MainScreen;

/**
 * Created by rost on 10.05.2016.
 */
public class MainListener implements GridView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent("com.nipel.rboyko.doman_cards.CARDSCREEN");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        String xml= (String) MainScreen.DATA.get(position).get(1);
        intent.putExtra("xml",xml);
        MainScreen.CONTEXT.startActivity(intent);

    }
}
