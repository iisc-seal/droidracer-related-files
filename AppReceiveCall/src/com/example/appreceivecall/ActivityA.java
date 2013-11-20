package com.example.appreceivecall;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import android.os.Bundle;
import android.os.Looper;
import android.app.Activity;
import android.app.backup.RestoreObserver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;


public class ActivityA extends Activity{

	String phoneNo = new String();
	static String str = "new";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Intent intent = getIntent();
        EditText phone = (EditText) findViewById(R.id.pn);
        phoneNo = intent.getStringExtra("phone");
        phoneNo.length();
        phone.setText(phoneNo);
        Log.v("AppRecv","Entered Activity A's onCreate");
//        Button btn = new Button(this);
//        btn.setText("new");
//        FrameLayout rl =  (FrameLayout)(getWindow().getDecorView().findViewById(android.R.id.content));
//        rl.addView(btn);
//        int id = btn.getId();
//        btn.setText("ss");
    }
	
	@Override
    protected void onStart(){
    	super.onStart();
    
    	Log.v("AppReceiveCall", "onStart completed (Activity A)");
    }
	
	@Override
    protected void onRestart(){
    	super.onRestart();
    
    	Log.v("AppReceiveCall", "onRestart completed (Activity A)");
    }
	
	@Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
    	super.onRestoreInstanceState(savedInstanceState);
    
    	Log.v("AppReceiveCall", "onRestoreInstanceState completed (Activity A)");
    }
	
	@Override
    protected void onPause(){
    	super.onPause();
    
    	Log.v("AppReceiveCall", "onPause completed (Activity A)");
    }
	
	@Override
    protected void onStop(){
    	super.onStop();
    	Intent intent = new Intent();
    	intent.setAction("testAction");
    	intent.putExtra("returnedData", "Result has been returned from Activity A");
    	intent.putExtra("testint", 23);
    	setResult(RESULT_OK, intent);
    	finish();
    	Log.v("AppReceiveCall", "onStop completed (Activity A)");
    }
	
	@Override
    protected void onDestroy(){
    	super.onDestroy();
    
    	Log.v("AppReceiveCall", "onDestroy completed (Activity A)");
    }
	
	@Override
    protected void onResume(){
    	super.onResume();
    
    	Log.v("AppReceiveCall", "onResume completed (Activity A)");
    }
	
	@Override
    protected void onSaveInstanceState(Bundle outState){
    	super.onSaveInstanceState(outState);
    
    	Log.v("AppReceiveCall", "onSaveInstanceState completed (Activity A)");
    }
	
	public void onAddContact(View view){
		str = "old";
		Button btn = (Button)view;
		btn.setText("haha");
		EditText phone = (EditText) findViewById(R.id.pn);
        phoneNo = "123";
        phone.setText(phoneNo);
		Intent intent = new Intent(this, ContactList.class);
    	intent.putExtra("phone", phone.getText().toString() );
    	
    	startActivity(intent);	
    	
//    	Intent intent = new Intent(this, ActivityA.class);
//    	intent.putExtra("phone", "99950"); //intent can carry key-value pairs like these which are added using putExtra
//    	startActivity(intent);
	}
	
	public void onIgnore(View view){
		Intent intent = new Intent(this, ActivityB.class);
    	intent.putExtra("message",  "Contact not added");
    	startActivity(intent);	
	}


}
