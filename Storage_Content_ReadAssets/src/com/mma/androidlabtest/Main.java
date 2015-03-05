package com.mma.androidlabtest;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Main extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try {
            InputStream is = getAssets().open("text.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String text = new String(buffer);
            TextView etOutput = (TextView)findViewById(R.id.et_output);
            etOutput.setText(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
