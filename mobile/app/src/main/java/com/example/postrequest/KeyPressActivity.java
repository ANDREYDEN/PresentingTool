package com.example.postrequest;

import android.view.KeyEvent;

public class KeyPressActivity implements KeyEvent.Callback {
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                MainActivity.ClickKey("right");
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                MainActivity.ClickKey("left");
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
        return false;
    }
}
