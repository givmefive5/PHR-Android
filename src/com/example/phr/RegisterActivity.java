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

public class RegisterActivity extends Activity {
	
	private ImageButton mBtnRegister;
	private String password;
	private String username;
	private PasswordValidator passwordValidator;
	private EditText formUsername;
	private EditText formPassword;
	private TextView mTextValid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		mBtnRegister = (ImageButton) findViewById(R.id.btnRegister);
		mTextValid =(TextView) findViewById(R.id.valid);
		
		
		mBtnRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				formUsername = (EditText) findViewById(R.id.txtUsernameReg);
				formPassword = (EditText) findViewById(R.id.txtPasswordReg);
				
				username = formUsername.getText().toString();
				password = formPassword.getText().toString();
				
				passwordValidator = new PasswordValidator();
				
				boolean valid = passwordValidator.validate(password);
				
				if(valid)
				{
					Log.e("tama1", "tama2");
					Intent intent = new Intent(getApplicationContext(), RegisterUserInformationActivity.class);
					startActivity(intent);
				}
				else
				{
					mTextValid.setText("mali daw");
					Log.e("mali1", "mali2");
				}
				
			}
		});
	}

}