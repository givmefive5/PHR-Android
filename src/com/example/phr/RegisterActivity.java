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
	private String confirmPassword;
	private String username;
	private PasswordValidator passwordValidator;
	private EditText formUsername;
	private EditText formPassword;
	private EditText formConfirmPassword;
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
				formConfirmPassword = (EditText) findViewById(R.id.confirmPasswordReg);
				
				username = formUsername.getText().toString();
				password = formPassword.getText().toString();
				confirmPassword = formConfirmPassword.getText().toString();
				
				passwordValidator = new PasswordValidator();
				
				boolean valid = passwordValidator.validate(password);
				
				if(valid)
				{
					Log.e("tama1", "tama2");
					if(password.equals(confirmPassword))
					{
						Intent intent = new Intent(getApplicationContext(), RegisterUserInformationActivity.class);
						startActivity(intent);
					}
					else
						mTextValid.setText("not same with confirm password");
				}
				else
				{
					mTextValid.setText("mali daw password");
					Log.e("mali1", "mali2");
				}
				
			}
		});
	}

}