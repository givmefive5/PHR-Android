package com.example.phr;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.phr.application.HealthGem;
import com.example.phr.exceptions.ServiceException;
import com.example.phr.local_db.SPreference;
import com.example.phr.service.UserService;
import com.example.phr.serviceimpl.UserServiceImpl;

public class LoginActivity extends Activity {

	private EditText formUsername;
	private EditText formPassword;

	private ImageButton mBtnLogin;
	private ImageButton mBtnRegister;

	private String username;
	private String password;
	private PasswordValidator passwordValidator;
	private TextView mTextValid;

	private UserService userService = new UserServiceImpl();

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();

		StrictMode.setThreadPolicy(policy);

		setContentView(R.layout.activity_login);
		mBtnLogin = (ImageButton) findViewById(R.id.btnLogin);
		mTextValid = (TextView) findViewById(R.id.checkLogin);

		formUsername = (EditText) findViewById(R.id.txtUsername);
		formPassword = (EditText) findViewById(R.id.txtPassword);
		final SPreference sp = new SPreference(HealthGem.getContext());
		
		formUsername.setText(sp.loadPreferences("id"));

		mBtnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				username = formUsername.getText().toString();
				password = formPassword.getText().toString();
				
				sp.savePreferences("id", username);
/*
				if (password.length() > 0 && username.length() > 0) {
					try {
						boolean isValid = userService.validateUser(username,
								password);
						if (isValid) {
							Intent intent = new Intent(getApplicationContext(),
									MainActivity.class);
							startActivity(intent);
						} else {
							mTextValid.setText("Invalid Username/Password");
						}
					} catch (ServiceException e) {
						mTextValid.setText("Error in Internet Connection");
					}

				}

				else {
					mTextValid.setText("Please Input Password & Username");
				}*/

			}
		});

		mBtnRegister = (ImageButton) findViewById(R.id.btnRegister);

		mBtnRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						RegisterActivity.class);
				startActivity(intent);
			}
		});
	}
	
	
	
	
	/**
	 *   Method used to get Shared Preferences */

	public SharedPreferences getPreferences() 
	{
	    return getSharedPreferences("HealthGemPreferences", MODE_PRIVATE);
	}
	/**
	 *  Method used to save Preferences */
	public void savePreferences(String key, String value) 
	{
	    SharedPreferences sharedPreferences = getPreferences();
	    SharedPreferences.Editor editor = sharedPreferences.edit();
	    editor.putString(key, value);
	    editor.commit();
	}
	/**
	 *  Method used to load Preferences */
	public String loadPreferences(String key) 
	{
	    try {
	        SharedPreferences sharedPreferences = getPreferences();
	        String strSavedMemo = sharedPreferences.getString(key, "");
	        return strSavedMemo;
	    } catch (NullPointerException nullPointerException) 
	    {
	        Log.e("Error caused at  TelaSketchUtin loadPreferences method",
	                ">======>" + nullPointerException);
	        return null;
	    }
	}
	/**
	 *  Method used to delete Preferences */
	public boolean deletePreferences(String key)
	{
	    SharedPreferences.Editor editor=getPreferences().edit();
	    editor.remove(key).commit();
	    return false;
	}
}
