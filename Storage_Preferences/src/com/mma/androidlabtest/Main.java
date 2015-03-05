package com.mma.androidlabtest;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class Main extends PreferenceActivity 
	implements OnSharedPreferenceChangeListener, OnPreferenceClickListener {

	SharedPreferences sharedPreferences;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.mypreferences);
		sharedPreferences = getPreferenceManager().getSharedPreferences();
		sharedPreferences.registerOnSharedPreferenceChangeListener(this);
		findPreference("edittext").setOnPreferenceClickListener(this);
	}

	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		Toast.makeText(this,key + ":" + sharedPreferences.getString(key, ""), Toast.LENGTH_SHORT).show();		
	}

	public boolean onPreferenceClick(Preference preference) {
		if (preference.getKey().equals("edittext")){
			SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
			Toast.makeText (this, sharedPreferences.getString ("edittext", "default"), Toast.LENGTH_LONG).show();
			Editor editor = sharedPreferences.edit();
			editor.putString("edit", "New value !");
			editor.commit();
		} else {		
			Toast.makeText(this, preference.getTitle() + " (" + preference.getKey() + ")", Toast.LENGTH_LONG).show();
		}
		return true;
	}
}
