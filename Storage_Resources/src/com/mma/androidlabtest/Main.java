package com.mma.androidlabtest;

import java.io.DataInputStream;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Main extends Activity {
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        InputStream inputStream = this.getResources().openRawResource(R.raw.file);
        DataInputStream dataInputStream = new DataInputStream(inputStream);        
        try {
			String content = dataInputStream.readLine();
			TextView tvOutput = (TextView)findViewById (R.id.tv_output);
			tvOutput.setText (content);
		} catch (Exception e) {
		}
        try {
	        dataInputStream.close();
	        inputStream.close();
		} catch (Exception e) {
		}
    }
}
