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

		mBtnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				formUsername = (EditText) findViewById(R.id.txtUsername);
				formPassword = (EditText) findViewById(R.id.txtPassword);

				username = formUsername.getText().toString();
				password = formPassword.getText().toString();

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
				}

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
}
