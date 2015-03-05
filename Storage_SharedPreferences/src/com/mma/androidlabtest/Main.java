package com.mma.androidlabtest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Main extends Activity {

    EditText et_username;
    EditText et_password;
    CheckBox cb_keepSession;
    SharedPreferences sharedPreferences;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_password);
        cb_keepSession = (CheckBox)findViewById(R.id.cb_keepSession);
        Button btnSubmit = (Button)findViewById(R.id.submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
	            Editor editor = sharedPreferences.edit();
	            editor.putString("username", et_username.getText().toString());
	            editor.putString("password", et_password.getText().toString());
	            editor.putBoolean("keepSession", cb_keepSession.isChecked());
	            editor.commit();
				finish();
			}
		});
        sharedPreferences = getSharedPreferences ("demo", Context.MODE_PRIVATE);
        et_username.setText (sharedPreferences.getString("username", ""));
        et_password.setText (sharedPreferences.getString("password", ""));
        cb_keepSession.setChecked (sharedPreferences.getBoolean ("keepSession", false));
    }
    
    public void onResume() {
        super.onResume();
    }
    
    public void onPause() {
        super.onPause();
    }
}
