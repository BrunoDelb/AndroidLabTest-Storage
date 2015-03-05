package com.mma.androidlabtest;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main extends ListActivity {
			 
	TextView etSelection;
	ArrayList<String> items=new ArrayList<String>();

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		etSelection = (TextView)findViewById(R.id.et_selection);
		try {
			InputStream inputStream = getResources().openRawResource(R.raw.data);
			DocumentBuilder builder=DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse (inputStream, null);
			NodeList nodeList = document.getElementsByTagName("item");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element item = (Element)nodeList.item(i);
				items.add(item.getAttribute("value"));
			}
			inputStream.close();
		} catch (Exception e) {
		}
		setListAdapter(new ArrayAdapter<String>(
			this, 
			android.R.layout.simple_list_item_1, 
			items
		));
	}

	public void onListItemClick(ListView parent, View v, int position, long id) {
		etSelection.setText (items.get (position).toString());
	}
}
