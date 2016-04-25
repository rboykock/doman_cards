package com.nipel.rboyko.doman_cards;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by rost on 25.04.2016.
 */
public class MainScreen extends AppCompatActivity implements View.OnClickListener {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        Button start_card=(Button) findViewById(R.id.start_card);
        start_card.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_card:   Log.v("CARD","Start card");

                                    break;
        }
    }
}
