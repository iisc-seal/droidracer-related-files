package com.example.appreceivecall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListWidgetEx extends Activity{

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        
        String[] values = new String[]{"99934","98855","111","222","33","333","44","55","66","88","100","000","345"};
        ListView lv = (ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
    	        android.R.layout.simple_expandable_list_item_1, values);
        lv.setAdapter(adapter);
       
        
        lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// TODO Auto-generated method stub
//				int j = 0;
//        		for(int i=0;i<55555555;i++){
//        			j=i*2;
//        		}
//        		Log.v("AppRecv",String.valueOf(j));
        		Integer.parseInt(((TextView)v).getText().toString());
        		
        		String number = ((TextView)v).getText().toString();
        		Intent intent = new Intent(ListWidgetEx.this, ActivityB.class);
            	intent.putExtra("message", number + " calling"); //intent can carry key-value pairs like these which are added using putExtra
            	startActivity(intent);
				
			}
        });
	}
	
	public void onDummy2(View v){
		Intent intent = new Intent(this, ActivityA.class);
		intent.putExtra("phone", "123");
    	startActivity(intent);
	}
}
