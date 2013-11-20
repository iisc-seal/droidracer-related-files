package com.example.appreceivecall;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {
	
  @Override
  public void onReceive(Context context, Intent intent) {
   Log.v("AppRecvCall", "boot_completed");
  }
} 