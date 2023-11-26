package com.gamecodeschool.snake;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameRenderer extends SurfaceView {
    private Canvas canvas;
    private Paint paint;

    private Snake snake;
    private Apple apple;
    private Level level;
    private int score;
    private SurfaceHolder surfaceHolder;
    private boolean isPaused;
    private boolean isGameOver;
    private Context context;

    public GameRenderer(Context context, SurfaceHolder surfaceHolder, Paint paint, Snake snake, Apple apple) {
        super(context);
        this.context = context;
        this.surfaceHolder = surfaceHolder;
        this.paint = paint;
        this.snake = snake;
        this.apple = apple;
    }

    public Canvas draw(boolean isGameOver, int score, boolean isPaused, Canvas canvas, Paint paint, Snake snake, Apple apple, Level level, int backgroundColor, Resources resources) {
        this.canvas = canvas;
        this.score = score;
        this.isPaused = isPaused;
        this.paint = paint;
        this.isGameOver = isGameOver;
        // Check and lock canvas
        // Fill the screen with a background color
        canvas.drawColor(backgroundColor); // Example color, adjust as needed

        if (this.isGameOver) {
            drawGameOverScreen();
        } else {
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
                canvas.drawText(resources.getString(R.string.tap_to_play), 200, 700, paint);
            }
        }

        return canvas;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    private void drawGameOverScreen() {
        paint.setColor(Color.RED); // Example color
        paint.setTextSize(250);
        canvas.drawText("Game Over", 200, 400, paint);
        canvas.drawText("Score: " + score, 200, 700, paint);
        paint.setColor(Color.WHITE); // Example color
        paint.setTextSize(120);
        canvas.drawText(context.getResources().getString(R.string.tap_to_play), 200, 900, paint);
    }
}
