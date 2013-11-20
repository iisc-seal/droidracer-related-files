package com.example.appreceivecall;

import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;
import android.telephony.PhoneNumberUtils;
import android.net.Uri;

public class ActivityB extends Activity{

	public void onCreate(Bundle savedInstanceState) {
		try {
	        File crashLogDirectory = new File(Environment.getExternalStorageDirectory().getCanonicalPath() + "crashLogDirectory");
	        crashLogDirectory.mkdirs();

	        Thread.setDefaultUncaughtExceptionHandler(new UEHandler());
	    } catch (Exception e) {
	        Log.e("AppReceiveCall", "Exception setting up exception handler! " + e.toString());
	    }
        super.onCreate(savedInstanceState);
        
        String msg = "";
        
        setContentView(R.layout.activity_b);
        
        Intent intent = getIntent();
        EditText txt = (EditText)findViewById(R.id.editText1);
        
        if(intent.getAction()!=null && intent.getAction().equals(Intent.ACTION_DIAL)){
        	Uri data = getIntent().getData();
        	if (data != null && (data.getScheme().equals("tel"))) {
                String number = PhoneNumberUtils.getNumberFromIntent(getIntent(), this);
                if (number != null) {
                    msg = number;
                }
            }
        }
        
        if(intent.getStringExtra("message")!=null){
        	msg = msg + " " + intent.getStringExtra("message");
        	txt.setText(msg);
        }
		else
			try {
				throw new CustomDefinedException("Expected extras not present");
			} catch (CustomDefinedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//        if(intent.getExtras() != null){
//        	array = intent.getExtras().getSparseParcelableArray("uistate");
//        }
	}
	
	public void onHomeClick(View view){
		Intent intent = new Intent(this, EntryActivity.class);
		
		startActivity(intent);
	}
	
	@Override
    protected void onStart(){
    	super.onStart();
    	Log.v("AppReceiveCall", "onStart completed (Activity B)");
		
    }
}



