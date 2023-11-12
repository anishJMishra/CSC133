package com.gamecodeschool.snake;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class SnakeActivity extends Activity  {

    // Declare an instance of SnakeGame
    SnakeGame mSnakeGame;

    View view;



    // Set the game up
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the pixel dimensions of the screen
        Display display = getWindowManager().getDefaultDisplay();

        //view = findViewById(R.id.view);
        //view.setOnKeyListener(mSnakeGame);



        // Initialize the result into a Point object
        Point size = new Point();
        display.getSize(size);

        // Create a new instance of the SnakeEngine class
        mSnakeGame = new SnakeGame(this, size);

        // Make snakeEngine the view of the Activity
        setContentView(mSnakeGame);
    }

    // Start the thread in snakeEngine
    @Override
    protected void onResume() {
        super.onResume();
        mSnakeGame.resume();
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent keyEvent) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_W:
                Log.d("TAG", "Key pressed: " + keyCode);
                mSnakeGame.updateMovement(Snake.Heading.UP);
                return true;
            case KeyEvent.KEYCODE_A:
                mSnakeGame.updateMovement(Snake.Heading.LEFT);
                return true;
            case KeyEvent.KEYCODE_S:
                mSnakeGame.updateMovement(Snake.Heading.DOWN);
                return true;
            case KeyEvent.KEYCODE_D:
                mSnakeGame.updateMovement(Snake.Heading.RIGHT);
                return true;
        }

        return false;
    }

    // Stop the thread in snakeEngine
    @Override
    protected void onPause() {
        super.onPause();
        mSnakeGame.pause();
    }
}
