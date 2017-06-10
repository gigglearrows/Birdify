package com.appandgo.birdify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        String birdname = "Bird name";
        int birdimage = R.drawable.chiffchaff;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            birdname = extras.getString("birdname");
            birdimage = extras.getInt("birdimage");
        }

        TextView birdNameView = (TextView) findViewById(R.id.birdPlayingName);
        ImageView birdImageView = (ImageView) findViewById(R.id.birdPlayingImage);

        birdNameView.setText(birdname);
        birdImageView.setImageResource(birdimage);

    }
}
