package com.gamecodeschool.snake;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class Control{
    Control(){};

    public Snake.Heading keyUpdater(Snake mSnake, Snake.Heading heading, int keyCode){
        switch (keyCode) {
            case KeyEvent.KEYCODE_W:
                if(mSnake.getHeading()!=Snake.Heading.DOWN)
                    return Snake.Heading.UP;
                else
                    return heading;
            case KeyEvent.KEYCODE_D:
                if(mSnake.getHeading()!=Snake.Heading.LEFT)
                    return Snake.Heading.RIGHT;
                else
                    return heading;
            case KeyEvent.KEYCODE_S:
                if(mSnake.getHeading()!=Snake.Heading.UP)
                    return Snake.Heading.DOWN;
                else
                    return heading;
            case KeyEvent.KEYCODE_A:
                if(mSnake.getHeading()!=Snake.Heading.RIGHT)
                    return Snake.Heading.LEFT;
                else
                    return heading;
            case KeyEvent.KEYCODE_ENTER:

        }
        return heading;
    }
    public Snake.Heading touchUpdater(Snake.Heading heading, MotionEvent motionEvent, int halfWayPoint){
        if (motionEvent.getX() >= halfWayPoint) {
            switch (heading) {
                // Rotate right
                case UP:
                    return Snake.Heading.RIGHT;

                case RIGHT:
                    return Snake.Heading.DOWN;

                case DOWN:
                    return Snake.Heading.LEFT;

                case LEFT:
                    return Snake.Heading.UP;

            }
        } else {
            // Rotate left
            switch (heading) {
                case UP:
                    return Snake.Heading.LEFT;

                case LEFT:
                    return Snake.Heading.DOWN;

                case DOWN:
                    return Snake.Heading.RIGHT;

                case RIGHT:
                    return Snake.Heading.UP;

            }
        }
        return heading;
    }
}
