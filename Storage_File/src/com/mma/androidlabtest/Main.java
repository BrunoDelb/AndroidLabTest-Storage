package com.mma.androidlabtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
    
	TextView tvOutput;
	
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.main);
        tvOutput = (TextView)findViewById (R.id.tv_output);
        File rootPath = new File (Environment.getExternalStorageDirectory(), "testdir");
        if (!rootPath.exists()) {
            rootPath.mkdirs();
        }
        File file = new File (rootPath, "myfile.txt");
        if (!Environment.getExternalStorageState().equals (Environment.MEDIA_MOUNTED)) {
            Toast.makeText (this, "External storage not mounted", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        try {           
            FileOutputStream fileOutputStream = new FileOutputStream (file, false);
            String data = "my text";
            fileOutputStream.write (data.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
			Toast.makeText (getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] data = new byte [1024];
            fileInputStream.read(data);
            fileInputStream.close();
            tvOutput.setText (new String (data));
        } catch (Exception e) {
			Toast.makeText (getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        file.delete();    
    }
}
