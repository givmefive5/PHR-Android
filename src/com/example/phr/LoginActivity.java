package com.example.phr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.phr.R;

public class LoginActivity extends Activity {
	
	private EditText formUsername;
	private EditText formPassword;
	
	private ImageButton mBtnLogin;
	private ImageButton mBtnRegister;
	
	private String username;
	private String password;
	private PasswordValidator passwordValidator;
	private TextView mTextValid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		mBtnLogin = (ImageButton) findViewById(R.id.btnLogin);
		mTextValid =(TextView) findViewById(R.id.checkLogin);
		
		mBtnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				formUsername = (EditText) findViewById(R.id.txtUsername);
				formPassword = (EditText) findViewById(R.id.txtPassword);
				
				username = formUsername.getText().toString();
				password = formPassword.getText().toString();
				
				if(password.length()>0 && username.length()>0)
				{
					Intent intent = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(intent);
				}
					
				else
				{
					mTextValid.setText("Please Input Password & Username" );
				}
					
					
				
				
			}
		});
		
		mBtnRegister = (ImageButton) findViewById(R.id.btnRegister);
		
		mBtnRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
				startActivity(intent);
			}
		});
	}

}
