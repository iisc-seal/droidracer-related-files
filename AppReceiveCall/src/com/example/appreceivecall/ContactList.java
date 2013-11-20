package com.example.appreceivecall;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ContactList extends ListActivity {

	public void onCreate(Bundle icicle) {
		
	    super.onCreate(icicle);
	    String[] values = new String[]{"99934","98855","111","222","33","333","44","55","66","88","100","000","345"};
//	    String[] values = new String[]{"99934","98855",""};
	    Intent intent = getIntent();
	    values[2] = intent.getStringExtra("phone");
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	        android.R.layout.simple_list_item_1, values);
	    setListAdapter(adapter);
	    
	    ListView lv = getListView();
	    lv.setOnItemLongClickListener(new OnItemLongClickListener() {
	        
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Log.e("model_checking_debug", "list item long click listener hit");
				
				return false;
			}
	        });
	  }
	
	@Override 
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Do something when a list item is clicked
	//	l.getChildAt(index)
//		try{		
		Log.e("model_checking_debug", "list item click listener hit");
		Integer.parseInt(((TextView)v).getText().toString());
		
		String number = ((TextView)v).getText().toString();
		Intent intent = new Intent(this, ActivityB.class);
    	intent.putExtra("message", number + " calling"); //intent can carry key-value pairs like these which are added using putExtra
    	
    	
		
    	startActivity(intent);
//		}catch(Exception e){
//			Log.w("AppReceiveCall Exception", "ex caught");
//		}
    }
    
	
    
}
