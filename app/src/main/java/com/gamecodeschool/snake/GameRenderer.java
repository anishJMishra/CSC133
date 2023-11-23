package com.gamecodeschool.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class GameRenderer {
    private Canvas canvas;
    private Paint paint;
    private SurfaceHolder surfaceHolder;
    private Snake snake;
    private Apple apple;
    private int score;

    private boolean isPaused;
    private Context context;

    public GameRenderer(Context context,SurfaceHolder surfaceHolder, Paint paint, Snake snake, Apple apple) {
        this.context = context;
        this.surfaceHolder = surfaceHolder;
        this.paint = paint;
        this.snake = snake;
        this.apple = apple;
    }

    public void draw(int score, boolean isPaused) {
        this.score = score;
        this.isPaused = isPaused;

        // Check and lock canvas
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();

            // Fill the screen with a background color
            canvas.drawColor(Color.BLACK); // Example color, adjust as needed

            // Draw the score
            paint.setColor(Color.WHITE); // Example color, adjust as needed
            paint.setTextSize(120);
            canvas.drawText("Score: " + score, 20, 120, paint);

            // Draw the apple and the snake
            apple.draw(canvas, paint);
            snake.draw(canvas, paint);

            // Draw some text while paused
            if (isPaused) {
                paint.setTextSize(250);
                canvas.drawText(context.getResources().getString(R.string.tap_to_play), 200, 700, paint);
            }

            // Unlock the canvas and post the draw
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}
