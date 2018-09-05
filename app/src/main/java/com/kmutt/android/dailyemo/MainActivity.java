package com.kmutt.android.dailyemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    private Button btnTest;
    int heartrate = 0;
    boolean traffitIsJam = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btnTest = (Button)findViewById(R.id.btnTest);

        showHeartrate();

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                URL url = null;
                try {
                    url = new URL("https://api.fitbit.com/1/user/6TJZXF/activities/heart/date/today/6m.json");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                HttpURLConnection urlConnection = null;
                try {
                    urlConnection = (HttpURLConnection) url.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    urlConnection.setDoOutput(true);
                    urlConnection.setChunkedStreamingMode(0);

                    OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
                    writeStream(out);

                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    readStream(in);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    urlConnection.disconnect();
                }
//
//                HttpClient http = client.get("https://api.fitbit.com/1/user/6TJZXF/activities/heart/date/today/6m.json");
//                JSONData response = JsonParser.parse(http);
//                System.out.println(response.rows[1].elements[1].distance.text);
            }
        });
    }

    private String readStream(InputStream in) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = in.read();
            while(i != -1) {
                bo.write(i);
                i = in.read();
            }
            return bo.toString();
        } catch (IOException e) {
            return "";
        }
    }

    private void writeStream(OutputStream out) {
    }

    private void handleUserActivity(int type, int confidence) {


    }



    private void showHeartrate() {

        if(heartrate > 100){
            //change color
            checkTraffic();
        }
    }

    private void checkTraffic() {
    }
}
