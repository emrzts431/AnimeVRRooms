package com.example.animevrrooms;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    private Button AnimeRooms;
    private Button YouTube;
    private Button exit;
    Bitmap backgroundFirst;
    Bitmap backgroundSecond;
    float xFirst,yFirst;
    float xSecond,ySecond;
    CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backgroundFirst = BitmapFactory.decodeResource(getResources(),R.drawable.backgroundasd);
        backgroundSecond = BitmapFactory.decodeResource(getResources(),R.drawable.backgroundasd);
        xFirst = yFirst = 0;
        ySecond = 0;
        xSecond = backgroundFirst.getWidth();
        AnimeRooms = (Button) findViewById(R.id.AnimeRooms);
        AnimeRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
        YouTube = (Button) findViewById(R.id.YouTube);
        YouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.youtube.com/c/onuryasemin/featured");
            }
        });
        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        customView = new CustomView(this,backgroundFirst,backgroundSecond,xFirst,yFirst,xSecond,ySecond);
        LinearLayout backgroundDrawLayout = (LinearLayout) findViewById(R.id.backgroundDraw);
        backgroundDrawLayout.addView(customView);
    }
    public void openActivity2(){
        Intent intent = new Intent(this,videos.class);
        startActivity(intent);
    }
    public void goToUrl(String url){
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    @Override
    protected void onPause(){
        super.onPause();
        customView.pause();
    }
    @Override
    protected void onResume(){
        super.onResume();
        customView.resume();
    }

}