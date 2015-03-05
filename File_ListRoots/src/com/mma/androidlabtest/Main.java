package com.mma.androidlabtest;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class Main extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        EditText et_output = (EditText)findViewById (R.id.et_output);
        File file = this.getFilesDir();
        String text = "Local storage : " + file.getAbsolutePath();
        File[] files = File.listRoots();
        for (int i = 0; i < files.length; i++){
        	String filename = files[i].getAbsolutePath();
        	filename.replaceAll (new String(new byte[]{0}), "");
        	File rootFile = new File (filename);
        	if (file.isDirectory()) {
                for (int j = 0; j < rootFile.listFiles().length; j++){
            		text += rootFile.listFiles() [j].getAbsolutePath() + "\r\n";
                }
        	}
        }
        et_output.setText (text);
    }
}
