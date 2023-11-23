package com.gamecodeschool.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;

public class GameRenderer extends SurfaceView {
    private Canvas canvas;
    private Paint paint;

    private Snake snake;
    private Apple apple;
    private int score;

    private boolean isPaused;
    private Context context;

    public GameRenderer(Context context)   {

        super(context);
    }

    public Canvas draw(int score, boolean isPaused, Canvas canvas, Paint paint, Snake snake, Apple apple, Level level, int backgroundColor) {
        this.canvas = canvas;
        this.score = score;
        this.isPaused = isPaused;
        this.paint = paint;

        // Check and lock canvas



            // Fill the screen with a background color
            canvas.drawColor(backgroundColor); // Example color, adjust as needed

            // Draw the score
            paint.setColor(Color.WHITE); // Example color, adjust as needed
            paint.setTextSize(120);
            canvas.drawText("Score: " + score, 20, 120, paint);

            // Draw the apple and the snake
            apple.draw(canvas, paint);
            snake.draw(canvas, paint);
            level.draw(canvas, paint);

            // Draw some text while paused
            if (isPaused) {
                paint.setTextSize(250);
                canvas.drawText(getResources().getString(R.string.tap_to_play), 200, 700, paint);
            }


        return canvas;
    }
}
