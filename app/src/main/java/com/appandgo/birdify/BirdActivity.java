package com.appandgo.birdify;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BirdActivity extends BaseActivity {
    private final static String TAG = "BirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_birds);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final Bird bird_data[] = new Bird[]
                {
                        new Bird("Willow Warbler", R.drawable.willowwarbler),
                        new Bird("Wood Warbler", R.drawable.woodwarbler),
                        new Bird("Chiffchaff", R.drawable.chiffchaff),
                        new Bird("Ovenbird", R.drawable.ovenbird),
                        new Bird("Sparrow", R.drawable.sparrow),
                        new Bird("Wren", R.drawable.wren),
                        new Bird("Woodpecker", R.drawable.woodpecker),
                        new Bird("Owl", R.drawable.owl),
                        new Bird("Crow", R.drawable.crow),
                };

        ArrayAdapter adapter = new BirdListAdapter(this, R.layout.bird_list_item, bird_data);

        ListView listView = (ListView) findViewById(R.id.birdlist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playing = new Intent(BirdActivity.this, PlayingActivity.class);
                playing.putExtra("birdname", bird_data[position].name);
                playing.putExtra("birdimage", bird_data[position].image);
                startActivity(playing);
                Log.d(TAG, "Clicked list position" + position);
            }
        });
    }
}