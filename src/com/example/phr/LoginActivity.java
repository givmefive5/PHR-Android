package com.example.phr;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.phr.exceptions.ServiceException;
import com.example.phr.model.User;
import com.example.phr.service.UserService;
import com.example.phr.serviceimpl.UserServiceImpl;

public class LoginActivity extends Activity {

	private ImageButton mBtnLogin;
	private EditText mTxtUsername;
	private EditText mTxtPassword;
	private TextView mTxtLoginError;

	private UserService userService = new UserServiceImpl();

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		mBtnLogin = (ImageButton) findViewById(R.id.btnLogin);
		mTxtUsername = (EditText) findViewById(R.id.txtUsername);
		mTxtPassword = (EditText) findViewById(R.id.txtPassword);
		mTxtLoginError = (TextView) findViewById(R.id.txtLoginError);

		mBtnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mTxtLoginError.setVisibility(View.GONE);
				User user = new User(mTxtUsername.getText().toString(),
						mTxtPassword.getText().toString());
				try {
					boolean isValid = userService.validateUserLogin(user);
					if (isValid) {
						Intent intent = new Intent(getApplicationContext(),
								MainActivity.class);
						startActivity(intent);
					} else {
						mTxtLoginError.setText("Invalid login information");
						mTxtLoginError.setVisibility(View.VISIBLE);
					}
				} catch (ServiceException e) {
					mTxtLoginError.setText("System Error");
					mTxtLoginError.setVisibility(View.VISIBLE);
					e.printStackTrace();
				}
			}
		});
	}

}
