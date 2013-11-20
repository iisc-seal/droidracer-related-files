package com.example.appreceivecall;

import android.util.Log;

public class CustomDefinedException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomDefinedException(String message){
		super(message);
		Log.e("CustomDefinedException",message);
	}

}
