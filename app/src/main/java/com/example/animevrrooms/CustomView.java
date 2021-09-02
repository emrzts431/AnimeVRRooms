package com.example.animevrrooms;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CustomView extends SurfaceView implements  Runnable{
    Thread t = null;
    SurfaceHolder holder;
    boolean isItOkay = false;
    Bitmap backgroundFirst;
    Bitmap backgroundSecond;
    float xFirst,yFirst;
    float xSecond,ySecond;

    public CustomView(Context context,Bitmap backgroundFirst,Bitmap backgroundSecond,float x, float y,float xSecond,float ySecond) {
        super(context);
        holder = getHolder();
        this.backgroundFirst = backgroundFirst;
        this.backgroundSecond = backgroundSecond;
        this.xFirst = x;
        this.yFirst = y;
        this.xSecond = xSecond;
        this.ySecond = ySecond;
    }

    @Override
    public void run() {
        while (isItOkay) {
            if (!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();
            xFirst--;
            xSecond--;
            if(xSecond == 0){
                xFirst = backgroundFirst.getWidth();
            }
            else if(xFirst == 0){
                xSecond = backgroundFirst.getWidth();
            }
            canvas.drawBitmap(backgroundFirst,xFirst,yFirst,null);
            canvas.drawBitmap(backgroundSecond,xSecond,ySecond,null);
            holder.unlockCanvasAndPost(canvas);
        }
    }
    public void resume(){
        isItOkay = true;
        t = new Thread(this);
        t.start();
    }
    public void pause(){
        isItOkay = false;
        while(true){
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            break;
        }
        t = null;
    }
}
