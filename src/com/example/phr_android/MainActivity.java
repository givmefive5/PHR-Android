package com.example.phr_android;

import com.example.phr.exceptions.ServiceException;
import com.example.phr.model.User;
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

	UserService userService = new UserServiceImpl();
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		
		try {
			System.out.println(userService.verifyUser("Matthew", "Go"));
			System.out.println(userService.verifyUser("admin", "admin"));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
	
	public void verifyUser(View view){
		boolean isValid;
		try {
			isValid = userService.verifyUser("admin", "admin");
			Boolean bool = Boolean.valueOf(isValid);
			System.out.println(userService.verifyUser("Matthew", "Go"));
			System.out.println(isValid);
			TextView tvId = (TextView) findViewById(R.id.textView1);
			User user = userService.getUserGivenUsername("admin");
			tvId.setText(" admin admin " + bool.toString() + "  getUser " + user.getPassword());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
