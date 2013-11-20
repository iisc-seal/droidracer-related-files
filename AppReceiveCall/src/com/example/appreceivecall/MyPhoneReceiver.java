package com.example.appreceivecall;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyPhoneReceiver extends BroadcastReceiver {
	
  @Override
  public void onReceive(Context context, Intent intent) {
    Bundle extras = intent.getExtras();
    if (extras != null) {
      String state = extras.getString(TelephonyManager.EXTRA_STATE);
      Log.w("DEBUG_PHONE", state);
      if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
        String phoneNumber = extras
            .getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
        Log.w("DEBUG_PHONE", phoneNumber);
        
        Intent inte = new Intent(context, ActivityA.class);
//    	inte.putExtra("phone", phoneNumber); //intent can carry key-value pairs like these which are added using putExtra
    	
    	//not needed
//        Intent inte = new Intent("android.intent.action.MAIN");
//    	intent.setComponent(new ComponentName("com.example.appreceivecall", "com.example.appreceivecall.ActivityA"));
    	
    	
    	inte.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	context.startActivity(inte);	
      }
    }
  }
} 
