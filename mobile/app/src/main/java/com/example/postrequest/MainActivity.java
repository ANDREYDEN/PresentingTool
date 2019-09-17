package com.example.postrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        ip = intent.getStringExtra(EnterIPActivity.EXTRA_MESSAGE);
    }

    public void HideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        HideSystemUI();
    }

    public void ClickKey(String key) {
        try {
            Runtime.getRuntime().exec(String.format("curl --data key=%s http://%s:5000/test", key, ip));
        }
        catch (IOException e) {

        }
    }

    public void ClickRight(View view) {
        ClickKey("right");
    }

    public void ClickLeft(View view) {
        ClickKey("left");
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    ClickKey("right");
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    ClickKey("left");
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }
}
