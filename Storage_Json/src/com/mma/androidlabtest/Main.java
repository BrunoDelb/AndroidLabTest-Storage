package com.mma.androidlabtest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		EditText et_json = (EditText)findViewById (R.id.et_json);
		String json_data = "{\"item\":{\"item11\":\"AAA\",\"item12\":\"BBB\",\"subitem\":[{\"item21\":\"CCC\"},{\"item22\":\"DDD\"}]}}";
		try {
			JSONObject data = new JSONObject (json_data);
			JSONObject item = data.getJSONObject("item");
			JSONArray subitem = item.getJSONArray("subitem");
			et_json.setText("item : " + item.getString("item11") + ", " + item.getString("item12") + ", " + subitem.length() + " subitems");
		} catch (JSONException e) {
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
