
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

public class videos extends Activity {
    private Button AssasinationClassroom;
    private Button BokuNo;
    private Button YagamisRoomLight;
    private Button YagamisRoomDark;
    private Button Valorant;
    private Button exit;
    Bitmap backgroundFirst;
    Bitmap backgroundSecond;
    float xFirst,yFirst;
    float xSecond,ySecond;
    CustomView customView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        backgroundFirst = BitmapFactory.decodeResource(getResources(),R.drawable.backgroundasd);
        backgroundSecond = BitmapFactory.decodeResource(getResources(),R.drawable.backgroundasd);
        xFirst = yFirst = 0;
        ySecond = 0;
        xSecond = backgroundFirst.getWidth();
        AssasinationClassroom = (Button) findViewById(R.id.AssasinationClassroom);
        AssasinationClassroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://youtu.be/CAZneSatZkY");
            }
        });
        YagamisRoomLight = (Button) findViewById(R.id.YagamisRoomLight);
        YagamisRoomLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://youtu.be/Hhdvph9sH1M");
            }
        });
        BokuNo = (Button) findViewById(R.id.BokuNo);
        BokuNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://youtu.be/2cfCUDSz4M4");
            }
        });
        YagamisRoomDark = (Button) findViewById(R.id.YagamisRoomDark);
        YagamisRoomDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://youtu.be/vuIfzig8zuc");
            }
        });
        Valorant = (Button) findViewById((R.id.Valorant));
        Valorant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://youtu.be/uHp7q2r8KV0");
            }
        });
        exit = (Button) findViewById(R.id.Exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        customView = new CustomView(this,backgroundFirst,backgroundSecond,xFirst,yFirst,xSecond,ySecond);
        LinearLayout backgroundDrawLayout = (LinearLayout) findViewById(R.id.backgroundDrawSecond);
        backgroundDrawLayout.addView(customView);
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