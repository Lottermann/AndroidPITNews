package de.dokoliho.androidpitnews;

import android.app.Activity;
import android.os.*;
import android.widget.TextView;

import java.io.*;
import java.net.*;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final TextView textView = new TextView(this);
        setContentView(textView);
        new Thread() {
            @Override
            public void run() {
                populateTextView(textView);
            }
        }.start();
    }

    private void populateTextView(final TextView textView) {

        URL url = null;
        HttpURLConnection urlConnection = null;

        try {
//            url = new URL("http://www.androidpit.com/feed/main.xml");
//            urlConnection = (HttpURLConnection) url.openConnection();
//            InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
            System.out.println("1");
            runOnUiThread(
                    new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("Hello World");
                        }
                    });

            System.out.println("2");
//            isr.close();
        }
//        catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
        finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

    }



}
