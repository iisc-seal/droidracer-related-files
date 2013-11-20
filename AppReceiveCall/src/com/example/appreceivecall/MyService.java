package com.example.appreceivecall;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service{

	private static final String TAG = "appreceivecall-MyService";
	
	@Override
	  public void onCreate() {
		Log.i(TAG, "Service onCreate 2");
		
	}
	@Override
	 public void onStart(Intent intent, int startId) {
	    // For time consuming an long tasks you can launch a new thread here...
	    Toast.makeText(this, " Service Started", Toast.LENGTH_LONG).show();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		Log.i(TAG, "Service onStartCommand");
		final int currentId = startId;
		
		Runnable r = new Runnable() {
		       public void run() {
		for (int i = 0; i < 1; i++)
		{
			long endTime = System.currentTimeMillis() + 10*1000;
			while (System.currentTimeMillis() < endTime) {
	          synchronized (this) {
	              try {
	                  wait(endTime - System.currentTimeMillis());
	              } catch (Exception e) {
	              }
	          }
		 }
//			while(i >= 0){
//				i--;
//			}
		 Log.i(TAG, "Service running" + currentId);
	     }
//		stopSelf();
		       }
		};
		
		Thread t = new Thread(r);
		t.start();
	     return Service.START_STICKY;
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.i(TAG, "Service onBind");
		return null;
	}
	
	@Override
	  public void onDestroy() {
		Log.i(TAG, "Service onDestroy");
		stopSelf();
	}
	
}
