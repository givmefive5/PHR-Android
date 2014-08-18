package com.example.phr.application;

import android.app.Application;
import android.content.Context;

public class HealthGem extends Application {

	private static HealthGem healthGem;
	private static Context context;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		HealthGem.healthGem = this;
		
		if (context == null) {
			context = this.getApplicationContext();
		}
		
	}
	
	public static HealthGem getInstance() {
		return healthGem;
	}
	
	public static Context getContext() {
		return context;
	}
	
}
