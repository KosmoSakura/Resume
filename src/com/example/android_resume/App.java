package com.example.android_resume;

import android.app.Application;
import android.content.Context;

public class App extends Application{
	public static Context context;
	public static ResumeDateBase db;
	
	@Override
	public void onCreate(){
		context = getApplicationContext();
		db = new ResumeDateBase(context);
		
	}
	
}
