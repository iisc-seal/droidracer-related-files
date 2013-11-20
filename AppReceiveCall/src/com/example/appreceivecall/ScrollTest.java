package com.example.appreceivecall;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ScrollView;

public class ScrollTest extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);
	}
	
	
	
	public void onDummmmy(View view){
		Log.v("appreceivecall", "dummy clicked");
//		Button btn = (Button)findViewById(R.id.button_send);
//		btn.requestFocus();
//		long downTime = SystemClock.uptimeMillis();
//    	long eventTime = SystemClock.uptimeMillis() + 100;
//     	
//    	float x = 0.0f;
//    	float y = 0.0f;
//    	// List of meta states found here: developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
//    	int metaState = 0;
//    	MotionEvent motionEvent = MotionEvent.obtain(
//    	    downTime, 
//    	    eventTime, 
//    	    MotionEvent.ACTION_DOWN, 
//    	    x, 
//    	    y, 
//    	    metaState
//    	);
//    	btn.dispatchTouchEvent(motionEvent);
//    	
//    	downTime = SystemClock.uptimeMillis();
//    	eventTime = SystemClock.uptimeMillis() + 100;
////    	float x = btn.getX() + 3f;
////    	float y = btn.getY() + 3f;
//    	x = 0.0f;
//    	y = 0.0f;
//    	// List of meta states found here: developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
//    	metaState = 0;
//    	motionEvent = MotionEvent.obtain(
//    	    downTime, 
//    	    eventTime, 
//    	    MotionEvent.ACTION_UP, 
//    	    x, 
//    	    y, 
//    	    metaState
//    	);
//    	btn.dispatchTouchEvent(motionEvent);
		
	}
	
	public void onSend(View view){
		Button btn = (Button)findViewById(R.id.dummy1);
		btn.setVisibility(View.INVISIBLE);
		
		boolean val = btn.requestFocus();
		long downTime = SystemClock.uptimeMillis();
    	long eventTime = SystemClock.uptimeMillis() + 100;
     	
    	float x = 0.0f;
    	float y = 0.0f;
    	// List of meta states found here: developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
    	int metaState = 0;
    	MotionEvent motionEvent = MotionEvent.obtain(
    	    downTime, 
    	    eventTime, 
    	    MotionEvent.ACTION_DOWN, 
    	    x, 
    	    y, 
    	    metaState
    	);
    	btn.dispatchTouchEvent(motionEvent);
    	
    	downTime = SystemClock.uptimeMillis();
    	eventTime = SystemClock.uptimeMillis() + 100;
//    	float x = btn.getX() + 3f;
//    	float y = btn.getY() + 3f;
    	x = 0.0f;
    	y = 0.0f;
    	// List of meta states found here: developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
    	metaState = 0;
    	motionEvent = MotionEvent.obtain(
    	    downTime, 
    	    eventTime, 
    	    MotionEvent.ACTION_UP, 
    	    x, 
    	    y, 
    	    metaState
    	);
    	btn.dispatchTouchEvent(motionEvent);
	}
	
	public void onDummy1(View view){
		Log.v("AppRecvCall","Dummy1 clicked");
	}
	

}
