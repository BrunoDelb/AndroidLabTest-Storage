package com.mma.androidlabtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity {

	EditText etContent;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		etContent = (EditText)findViewById (R.id.et_content);
		Button btnWriteInternal = (Button)findViewById (R.id.btn_write_internal);
		btnWriteInternal.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				writeInternal (getApplicationContext(), "test.txt", etContent.getText().toString());
			}
		});
		Button btnReadInternal = (Button)findViewById (R.id.btn_read_internal);
		btnReadInternal.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				etContent.setText(readInternal (getApplicationContext(), "test.txt"));
			}
		});
		Button btnWriteExternal = (Button)findViewById (R.id.btn_write_external);
		btnWriteExternal.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				writeExternal (getApplicationContext(), "test.txt", etContent.getText().toString());
			}
		});
		Button btnReadExternal = (Button)findViewById (R.id.btn_read_external);
		btnReadExternal.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				etContent.setText(readExternal (getApplicationContext(), "test.txt"));
			}
		});
	}

	public static boolean isSdCardReadable() {
		try {
			String storageState = Environment.getExternalStorageState();
			if (storageState.equals (Environment.MEDIA_MOUNTED)) {
				return true;
			} else if (storageState.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
		}
		return false;
	}
	
	public void writeInternal (Context context, String filename, String data) {
		try {
			if (isSdCardReadable()) {
				FileOutputStream fileOutputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
				fileOutputStream.write(data.getBytes());
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		} catch (Exception e) {
		}
	}

	public static void writeExternal (Context context, String filename, String data) {
		try {
			if (isSdCardReadable()) {
				FileOutputStream fileOutputStream = new FileOutputStream(new File (Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "/" + filename));
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
				outputStreamWriter.append(data);
				outputStreamWriter.close();
				fileOutputStream.close();
			}
		} catch (Exception e) {
		}
	}

	public static String readExternal (Context context, String filename) {
		try {
			if(isSdCardReadable()) {
				InputStream inputStream = context.openFileInput (Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "/" + filename);
				if (inputStream != null) {
					InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					String receiveString = "";
					StringBuilder stringBuilder = new StringBuilder();
					while ((receiveString = bufferedReader.readLine()) != null) {
						stringBuilder.append(receiveString);
					}
					inputStream.close();
					return stringBuilder.toString();
				}
			}
		} catch (Exception e) {
		}
		return "";
	} 

	public static String readInternal (Context context, String filename) {
		try {
			if(isSdCardReadable()) {
				InputStream inputStream = context.openFileInput(filename);
				if ( inputStream != null) {
					InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					String data = "";
					StringBuilder stringBuilder = new StringBuilder();
					while ((data = bufferedReader.readLine()) != null) {
						stringBuilder.append(data);
					}
					inputStream.close();
					return stringBuilder.toString();
				}
			}
		} catch (Exception e) {
		}
		return "";
	}
}
