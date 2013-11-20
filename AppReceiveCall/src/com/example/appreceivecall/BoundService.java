package com.example.appreceivecall;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BoundService extends Service {

	private final IBinder myBinder = new MyLocalBinder();
	
	@Override
	  public void onCreate() {
		Log.i("appreceivecall", "Local bound Service onCreate");
		
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.i("appreceivecall", "client has bound");
		return myBinder;
	}

	public String getCurrentTime() {
		SimpleDateFormat dateformat = 
                 new SimpleDateFormat("HH:mm:ss MM/dd/yyyy", Locale.US);
		return (dateformat.format(new Date()));
	}

	public class MyLocalBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }
    }	
}