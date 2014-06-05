package com.example.phr;

import com.example.phr.service.UserService;
import com.example.phr.service.UserServiceImpl;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		UserService userService = new UserServiceImpl();
		System.out.println(userService.verifyUser("Matthew", "Go"));
		System.out.println(userService.verifyUser("admin", "admin"));
	}

	public void verifyUser(View view){
		UserService userService = new UserServiceImpl();
		boolean isValid = userService.verifyUser("admin", "admin");
		Boolean bool = Boolean.valueOf(isValid);
		System.out.println(userService.verifyUser("Matthew", "Go"));
		System.out.println(isValid);
		TextView tvId = (TextView) findViewById(R.id.textView1);
		tvId.setText(bool.toString());
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
