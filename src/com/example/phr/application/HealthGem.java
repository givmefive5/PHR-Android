package com.example.phr.application;

import android.app.Application;
import android.content.Context;
public class HealthGem extends Application {

	private static HealthGem HealthGem;
	private static Context context;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		HealthGem.HealthGem = this;
		
		if (context == null) {
			context = this.getApplicationContext();
		}
		
	}
	
	public static HealthGem getInstance() {
		return HealthGem;
	}
	
	public static Context getContext() {
		return context;
	}
	
}
