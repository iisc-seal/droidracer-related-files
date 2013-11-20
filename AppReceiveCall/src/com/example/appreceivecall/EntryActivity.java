package com.example.appreceivecall;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.example.appreceivecall.BoundService.MyLocalBinder;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class EntryActivity extends Activity {
	//static int tmpV = 0;
	String str = "";
	TestClass t1;
	int toggle = 0;
	
	BoundService myService;
    boolean isBound = false;
	  
    @Override 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        
//        Button btn = (Button)findViewById(R.id.btnGotoA);
//        btn.setLongClickable(true);
//
//        btn.setOnLongClickListener(new View.OnLongClickListener() {
//			public boolean onLongClick(View v) {
//				// TODO Auto-generated method stub
//				synchronized(this){
//				EditText editText = (EditText)findViewById(R.id.phone);
//				editText.setText("long clicked by us");
//				Log.v("appRecvCall", "Button A long clicked");
//				}
//				return false;
//				//return true in next experiment
//			}
//			
//		});
//        
//        Runnable r = new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				Log.v("appreceivecall", "I'm running!");
//				synchronized(this){
//					Log.e("appreceivecall", "entered lock 1 in onCreate");
//					synchronized(this){
//					Log.e("appreceivecall", "entered lock 2 in onCreate");
//					}
//				}
//			}
//		};
//		Thread tr = new Thread(r);
//		tr.start();
//        
    	
      String[] projection = { TutListDatabase.ID, TutListDatabase.COL_TITLE };
      Cursor tutorials = getContentResolver().query(TutListProvider.CONTENT_URI, projection, null, null, null);
      if(tutorials != null){
      	tutorials.moveToFirst();
      }
      Cursor tutorials1 = getContentResolver().query(TutListProvider.CONTENT_URI, projection, null, null, null);
    	
    	
//        btn.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				EditText editText = (EditText)findViewById(R.id.phone);
//				editText.setText("short clicked");
//				Log.v("appRecvCall", "Button A short clicked");
//				return;
//				//return true in next experiment
//			}
//			
//		});
        //code to set key and text change listeners for edittext / textview
        
//        EditText editText = (EditText)findViewById(R.id.phone);
//        editText.setOnKeyListener(new EditText.OnKeyListener() {
//           	@Override
//			public boolean onKey(View v, int keyCode, KeyEvent event) {
//				// TODO Auto-generated method stub
//           		Log.v("AppRecvCall", "onKeyListener hit");
//				return false;
//			}
//            });
//    
//        editText.addTextChangedListener(new TextWatcher(){
//            
//			@Override
//			public void afterTextChanged(Editable s) {
//				// TODO Auto-generated method stub
//				Log.v("AppRecvCall", "Text in edit text has changed");
//			}
//
//			@Override
//			public void beforeTextChanged(CharSequence s, int start, int count,
//					int after) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onTextChanged(CharSequence s, int start, int before,
//					int count) {
//				// TODO Auto-generated method stub
//				
//			}
//        }); 
     //   final LayoutInflater  inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    //    inflater.i
    	
      t1 = new TestClass();
        Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				str = "123";
			}
		};
		Thread t = new Thread(r);
		t.start();
		str = "456";
		t1.n1 = 23;
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_entry, menu);
        return true;
    }
    
    @Override()
    protected void onResume(){
    	super.onResume();    	
    /*	File dir = getDir("mcd_dir", Context.MODE_PRIVATE); 
		File file = new File(dir, "mcd_msgLogs");
		
		try {
			byte[] contentInBytes = "wassup\n".getBytes();
			FileOutputStream fop = new FileOutputStream(file,true);
			fop.write(contentInBytes);
			fop.flush();
			contentInBytes = "giggig\n".getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
//    	try{
    	doNothing();
//    	}catch(NullPointerException e){
//    		Log.e("appreceivecall", "caught NPE");
//    	}
    	Log.e("AppReceiveCall", "onResume completed (Activity Entry)");
    }
    
    public synchronized void doNothing(){
		Log.v("dummy","did nothing");
		try {
			doSomething();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private synchronized void doSomething() throws Exception {
    	Log.e("apprecvcall", "i did something");
    }

    
    
    @Override
    protected void onStart(){
    	super.onStart();
    	Log.v("AppReceiveCall", "onStart completed (Activity Entry)");
    	
    	//code piece to traverse view group from root view group
//    	ViewGroup vg = (ViewGroup)findViewById(android.R.id.content);
//    	if(vg != null){
//    		for(int i=0; i < vg.getChildCount(); i++){
//    			View v = vg.getChildAt(i);
//    			Log.v("AppRecvCall",v.toString());
//    			if(ViewGroup.class.isInstance(v)){
//    				Log.v("AppRecvCall", "view is an instance of viewGroup");
//    				for(int j=0; j < ((ViewGroup)v).getChildCount(); j++){
//    					View vc = ((ViewGroup)v).getChildAt(j);
//    					if(ViewGroup.class.isInstance(vc)){
//    	    				Log.v("AppRecvCall", "child view is an instance of viewGroup");
//    					}
//    				}
//    			}
//    		}
//    	}
    }
    
    @Override
    protected void onPause(){
    	super.onPause();
    	 	
    	
    	Log.v("AppReceiveCall", "onPause completed Activity Entry");
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
    	super.onRestoreInstanceState(savedInstanceState);
    
    	Log.v("AppReceiveCall", "onRestoreInstanceState completed (Activity Entry)");
    	
    	if(savedInstanceState != null){
        	EditText et = (EditText)findViewById(R.id.phone);
        	et.setText(savedInstanceState.getString("phone"));
        }
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState){
    	super.onSaveInstanceState(outState);
    	EditText et = (EditText)findViewById(R.id.phone);
    	outState.putString("phone", et.getText().toString());
    	Log.v("AppReceiveCall", "onSaveInstanceState completed (Activity Entry)");
    }
    
    @Override
    protected void onStop(){
    	super.onStop();
    	Log.v("AppReceiveCall", "onStop completed (Activity Entry)");
    }
    
   
    private ServiceConnection myConnection = new ServiceConnection() {

	    public void onServiceConnected(ComponentName className,
	            IBinder service) {
	        MyLocalBinder binder = (MyLocalBinder) service;
	        myService = binder.getService();
	        isBound = true;
	    }
	    
	    public void onServiceDisconnected(ComponentName arg0) {
	        isBound = false;
	    }
	    
	   };
    public void onGotoB(View view){
//    	Intent intent1 = new Intent(this, MyService.class);
//    	startService(intent);
    	
//    	Intent intentSer = new Intent(this, BoundService.class);
//        bindService(intentSer, myConnection, Context.BIND_AUTO_CREATE);
    	
    	EditText phoneNo = (EditText)findViewById(R.id.phone); 
//    	Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+(phoneNo.getText()).toString()));
//    	startActivity(intent);	
    	
    	
    	final Intent mainIntent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+(phoneNo.getText()).toString()));
    	final List<ResolveInfo> pkgAppsList = this.getPackageManager().queryIntentActivities( mainIntent, 0);
    	boolean flag = false;
    	for(int i=0;i<pkgAppsList.size();i++){
    		ResolveInfo ri = pkgAppsList.get(i);
    		if(ri.activityInfo.name.equals("com.example.appreceivecall.ActivityB")){
    			flag = true;
    			break;
    		}
    	}
    	if(flag){
    	Intent intent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+(phoneNo.getText()).toString()));
    	intent.setClassName("com.example.appreceivecall", "com.example.appreceivecall.ActivityB");
    	intent.putExtra("message", "reached from entry activity");
    	
    	
    	
    	startActivity(intent);
    	}
    }
    
    
    public void onGotoA(View view){
    	synchronized (this) {
			Log.v("appreceivecall","synchronized");
		}
    	EditText phoneNo = (EditText)findViewById(R.id.phone);
    	Intent intent = new Intent(this, ActivityA.class);
    	intent.putExtra("phone", phoneNo.getText().toString()); //intent can carry key-value pairs like these which are added using putExtra
			
//    	startActivity(intent);	
    	
    	
    	startActivityForResult(intent, 13);

//    	Button b = (Button)findViewById(R.id.btnGotoB);
//    	b.setVisibility(View.INVISIBLE);
//    	Intent intent = new Intent("android.intent.action.MAIN");
//    	intent.setComponent(new ComponentName("com.example.launchmodetest", "com.example.launchmodetest.MainActivity"));
//    	startActivity(intent);
    	
    }
    
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//    	Parcel parcel1 = Parcel.obtain();
//    	Parcel parcel2 = Parcel.obtain();
//    	int testintTmp = data.getIntExtra("testint", 31);
//    	File dir = getDir("mcd_dir", Context.MODE_PRIVATE); 
//		File file = new File(dir, "mcd_intentBytes");
//		File file1 = new File(dir, "mcd_bundleBytes");
//		if(!file1.exists()){
//			data.writeToParcel(parcel1, data.getFlags());
//	    	byte[] intentBytes = parcel1.marshall();
//	    	data.getExtras().writeToParcel(parcel2, data.getFlags());
//	    	byte[] bundleBytes = parcel2.marshall();
//	    	int byteLgt = intentBytes.length;
//	    	int byteLgt1 = bundleBytes.length;
//
//			try {
//				FileOutputStream fos = new FileOutputStream(file);
//				FileOutputStream fos1 = new FileOutputStream(file1);
//				
//				fos.write(intentBytes);
//				fos1.write(bundleBytes);
//				
//				fos.flush();
//				fos1.flush();
//				fos.close();
//				fos1.close();
//				
//				int length = (int) file.length();
//				int length1 = (int) file1.length();
//
//				parcel1.recycle();
//				parcel2.recycle();
//				//test
//				FileInputStream fis = new FileInputStream(file);
//				FileInputStream fis1 = new FileInputStream(file1);
//
//				byte[] readIntentBytes = new byte[(int) file.length()];
//				byte[] readIntentBytes1 = new byte[(int) file1.length()];
//
//				fis.read(readIntentBytes);
//				parcel1 = Parcel.obtain();
//				parcel1.unmarshall(readIntentBytes, 0, readIntentBytes.length);
//				fis1.read(readIntentBytes1);
//				parcel2 = Parcel.obtain();
//				parcel2.unmarshall(readIntentBytes1, 0, readIntentBytes1.length);
//				Intent intent = new Intent();
//				intent.readFromParcel(parcel1);
//				Bundle bundle = new Bundle();
//				bundle.readFromParcel(parcel2);
//				String msg1 = bundle.getString("returnedData");
//				int testint = bundle.getInt("testint", 31);
//				System.out.println();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else{
//			try {
//				FileInputStream fis = new FileInputStream(file);
//				byte[] readIntentBytes = new byte[(int) file.length()];
//				fis.read(readIntentBytes);
//				parcel1 = Parcel.obtain();
//				parcel1.unmarshall(readIntentBytes, 0, readIntentBytes.length);
//				Intent intent = new Intent();
//				intent.readFromParcel(parcel1);
//				String msg1 = intent.getStringExtra("returnedData");
//				System.out.println();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
     super.onActivityResult(requestCode, resultCode, data);
     if(resultCode==RESULT_OK && requestCode==13){
      String msg = data.getStringExtra("returnedData");
      EditText et = (EditText)findViewById(R.id.phone);
      et.setText(msg);
     }
    }
    
    public void onSpin(View view){
    	Intent intent = new Intent(this, CallIntentsActivity.class);
    	startActivity(intent);
    }
    
    public void onListClick(View view){
    	Intent intent = new Intent(this, ListWidgetEx.class);
    	startActivity(intent);
    }
    
    public void onScrollClick(View view){
    	Intent intent = new Intent(this, ScrollTest.class);
    	startActivity(intent);
    }
    
    public void onDummy(View view){
    	EditText et = (EditText)findViewById(R.id.phone);
    //	int j = et.hashCode();
    	et.setText("gig");
    	EditText et1 = (EditText)findViewById(R.id.phone);
   // 	int i = et1.hashCode();
    	
    	et.setVisibility(View.INVISIBLE);
    	EditText et2 = (EditText)findViewById(R.id.phone);
    	int k = et2.hashCode();
    	
    	Intent intent = new Intent(this, ScrollTest.class);
    	startActivity(intent);
    	
    	//broadcat message
//    	Intent intent = new Intent();
//    	intent.setAction(Intent.ACTION_BOOT_COMPLETED);
//    	intent.setComponent(new ComponentName("com.example.appreceivecall", "com.example.appreceivecall.EntryActivitty"));
//    	//experiment here giving visible activity context instead of this
//    	sendBroadcast(intent);
//        Button btn = (Button)findViewById(R.id.btnGotoA);
//    	
//    	long downTime = SystemClock.uptimeMillis();
//    	long eventTime = SystemClock.uptimeMillis();
//     	
//    	float x = 0.0f;
//    	float y = 0.0f;
//    	// List of meta states found here: developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
//    	// testing eclipse refresh: THEJAS
//    	int metaState = 0;
//    		
//    	
//    	MotionEvent motionEvent = MotionEvent.obtain(
//    	    downTime, 
//    	    eventTime, 
//    	    MotionEvent.ACTION_DOWN, 
//    	    x, 
//    	    y, 
//    	    metaState
//    	);
//    	
//    	btn.dispatchTouchEvent(motionEvent);
    	 
	    	
//    	downTime = SystemClock.uptimeMillis();
//    	eventTime = SystemClock.uptimeMillis();
//    	motionEvent = MotionEvent.obtain(
//        	    downTime, 
//        	    eventTime, 
//        	    MotionEvent.ACTION_UP, 
//        	    x, 
//        	    y, 
//        	    metaState
//        	);
//        	
//        	btn.dispatchTouchEvent(motionEvent);
    	
//    	try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	

    
//    	downTime = SystemClock.uptimeMillis();
//    	eventTime = SystemClock.uptimeMillis()+3000;
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
//    	
//    	Intent intent = new Intent(this, ScrollTest.class);
//    	startActivity(intent);
    }
    
    @Override
    protected void onDestroy(){
    	super.onDestroy();
    	if(isBound){
    	    unbindService(myConnection);
    	}
    	Log.v("AppReceiveCall", "onDestroy completed (Activity Entry)");
    }
    
   
}
