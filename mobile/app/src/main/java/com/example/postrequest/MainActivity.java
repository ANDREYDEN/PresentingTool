package com.example.postrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void writeStream(OutputStream out){
        String output = "Hello world";
        try {
            out.write(output.getBytes());
            out.flush();
        } catch (Exception e) {
            //Log.d(e.getMessage());
        }
    }

    public void SendRequest(View view) {
        String IPPORT = "192.168.43.216:5000";

        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("http://"+IPPORT+"/test");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);

            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            writeStream(out);
        } catch (Exception e) {
            //Log.d(e.getMessage());
        }
        finally {
            urlConnection.disconnect();
        }
    }
}
