package com.mma.androidlabtest;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends ListActivity {
			 
	String[] items;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ListView listView = getListView();
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setTextFilterEnabled(true);
		items = getResources().getStringArray(R.array.my_array);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, items));
	}

	public void onListItemClick(ListView listView, View v, int position, long id) {
		listView.setItemChecked(position, listView.isItemChecked (position));
		Toast.makeText(this, items [position], Toast.LENGTH_SHORT).show();
	}
};
