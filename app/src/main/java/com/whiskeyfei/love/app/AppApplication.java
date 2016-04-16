package com.whiskeyfei.love.app;


import android.app.Application;
import android.content.Context;


public class AppApplication extends Application {


	private static Context mContext;

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();
	}



	public static Context get(){
		return mContext;
	}
}
