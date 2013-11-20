package com.example.appreceivecall;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import android.os.Messenger;

public class RemoteService extends Service {

	class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            
        	Bundle data = msg.getData();        	
        	String dataString = data.getString("MyString");
        	Toast.makeText(getApplicationContext(), 
                     dataString, Toast.LENGTH_SHORT).show();
        }
     }
	
	final Messenger myMessenger = new Messenger(new IncomingHandler());
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.i("appreceivecall", "remote bound");
	      return myMessenger.getBinder();
	}
	
	@Override
	  public void onDestroy() {
		Log.i("appreceivecall", "Local bound Service onDestroy");
		
	}

}