package com.example.appreceivecall;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

	
	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		long endTime = System.currentTimeMillis() + 5*100;
	      while (System.currentTimeMillis() < endTime) {
	          synchronized (this) {
	              try {
	            	  
	                  wait(endTime - System.currentTimeMillis());
	              } catch (Exception e) {
	              }
	          }
	      }
	      Log.e("appreceivecall", "intent service job completed");
		
	}

	public MyIntentService() {
	 	   super("IntentService-worker");
	}

}
