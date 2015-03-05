package com.mma.androidlabtest;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Main extends Activity {

	ListView listView;
	ArrayList<String> files = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		listView = (ListView)findViewById (R.id.listView);
		Button btn_go = (Button)findViewById (R.id.btn_go);
		btn_go.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				File[] rootFiles = File.listRoots();
				for (int i = 0; i < rootFiles.length; i++) {
					File[] directory = rootFiles [i].listFiles();
					for (int j = 0; j < directory.length; j++) {
						files.add(directory [j].getAbsolutePath());
					}
				}
				ArrayAdapter<String> adapter = new ArrayAdapter<String> (Main.this, android.R.layout.simple_expandable_list_item_1, files);
				listView.setAdapter(adapter);
			}
		});
	}

}
