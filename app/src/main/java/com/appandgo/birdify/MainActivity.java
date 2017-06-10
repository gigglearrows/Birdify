package com.appandgo.birdify;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends BaseActivity {
    private static final String TAG = "HomeActivity";
    private final Bird popular_birds[] = new Bird[]
            {
                    new Bird("Ovenbird", R.drawable.ovenbird),
                    new Bird("Sparrow", R.drawable.sparrow),
                    new Bird("Woodpecker", R.drawable.woodpecker),
                    new Bird("Owl", R.drawable.owl),
            };
    private SnappingHorizontalScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        scrollView = (SnappingHorizontalScrollView) findViewById(R.id.popularbirdscroll);
        scrollView.setOnScreenSwitchListener(onScreenSwitchListener());
        inflateLayoutsToHorizontalView(scrollView);
    }

    /**
     * on horizontal scrollview page changed
     */
    private SnappingHorizontalScrollView.OnScreenSwitchListener onScreenSwitchListener() {
        return new SnappingHorizontalScrollView.OnScreenSwitchListener() {

            @Override
            public void onScreenSwitched(int screen) {

            }
        };
    }

    @SuppressLint("InflateParams")
    public void inflateLayoutsToHorizontalView(ViewGroup layout) {

        LayoutInflater inflater = (LayoutInflater) getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        scrollView.removeAllViews(); // remove old views first

        for (Bird bird : popular_birds) {
            // Inflate layout from xml
            View view = inflater.inflate(R.layout.popular_bird_item, null, false);

            ImageView imgView = (ImageView) view.findViewById(R.id.popularbirdimg);
            TextView txtView = (TextView) view.findViewById(R.id.popularbirdname);

            imgView.setImageResource(bird.image);
            txtView.setText(bird.name);

            scrollView.addView(view);
        }
    }

}
