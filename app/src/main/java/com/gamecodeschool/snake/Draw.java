package com.gamecodeschool.snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.content.Context;

public class Draw {

    private SurfaceHolder mSurfaceHolder;
    private Paint mPaint;

    private volatile boolean mPaused = true;
    Draw(Paint mPaint, SurfaceHolder mSurfaceHolder){
        this.mPaint = mPaint;
        this.mSurfaceHolder = mSurfaceHolder;
    }
    void background(Canvas mCanvas){
        mCanvas.drawColor(Color.argb(255, 26, 128, 182));
    }
    void drawScore(Canvas mCanvas,int mScore){

        // Set the size and color of the mPaint for the text
        mPaint.setColor(Color.argb(255, 255, 255, 255));
        mPaint.setTextSize(120);

        // Draw the score
        mCanvas.drawText("" + mScore, 20, 120, mPaint);
    }
    void textOutput(Canvas mCanvas,String text,boolean mPaused){
        // Draw some text while paused
        if(mPaused){

            // Set the size and color of the mPaint for the text
            mPaint.setColor(Color.argb(255, 255, 255, 255));
            mPaint.setTextSize(250);

            // Draw the message
            // We will give this an international upgrade soon
            //mCanvas.drawText("Tap To Play!", 200, 700, mPaint);
            mCanvas.drawText(text,
                    200, 700, mPaint);
        }
    }
    void unlockCanvas(Canvas mCanvas){
        // Unlock the mCanvas and reveal the graphics for this frame
        mSurfaceHolder.unlockCanvasAndPost(mCanvas);
    }
}
