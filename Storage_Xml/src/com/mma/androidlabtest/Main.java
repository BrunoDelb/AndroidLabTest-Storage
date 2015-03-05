package com.mma.androidlabtest;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		EditText et_xml = (EditText)findViewById (R.id.et_xml);
		try {
			InputStream in = getResources().openRawResource(R.raw.numbers);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse (in, null);
			NodeList numbers = document.getElementsByTagName("number");
			String text = "";
			for (int i = 0; i < numbers.getLength(); i++) {
				Element item = (Element)numbers.item(i);
				text = text + item.getAttribute("value") + " ";
			}
			et_xml.setText(text);
			in.close();
		} catch (Throwable t) {
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
