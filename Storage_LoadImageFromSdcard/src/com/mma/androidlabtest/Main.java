package com.mma.androidlabtest;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

public class Main extends Activity {
			 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ImageView imgView = (ImageView)findViewById(R.id.image);
		imgView.setImageDrawable(Drawable.createFromPath(Environment.getExternalStorageDirectory().getPath() + "image.jpg") );      
	}
}
