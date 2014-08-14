package com.example.phr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.example.phr.R;

public class LoginActivity extends Activity {
	
	private ImageButton mBtnLogin;
	private ImageButton mBtnRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		mBtnLogin = (ImageButton) findViewById(R.id.btnLogin);
		
		mBtnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
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
