package com.mma.androidlabtest;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.Phones;
import android.provider.ContactsContract;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class Main extends ListActivity {
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Cursor cursor = getContentResolver().query(
        	ContactsContract.Contacts.CONTENT_URI, 	// uri
        	null, 									// projection
        	null, 									// selection
        	null, 									// selection args
        	null									// sort order
        );
        startManagingCursor(cursor); 
        ListAdapter adapter = new SimpleCursorAdapter(
			this,															// context
			android.R.layout.simple_list_item_2, cursor,					// layout 
			new String[] {ContactsContract.CommonDataKinds.Phone.NUMBER}, 	// from
			new int[] {android.R.id.text1, android.R.id.text2}				// to
		);
        setListAdapter(adapter);
    }
}
