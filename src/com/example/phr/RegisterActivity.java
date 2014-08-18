package com.example.phr;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.phr.exceptions.ServiceException;
import com.example.phr.exceptions.UserAlreadyExistsException;
import com.example.phr.model.User;
import com.example.phr.service.UserService;
import com.example.phr.serviceimpl.UserServiceImpl;

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
	private TextView textViewPasswordStrength;

	private UserService userService = new UserServiceImpl();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		mBtnRegister = (ImageButton) findViewById(R.id.btnRegister);
		mTextValid = (TextView) findViewById(R.id.valid);
		textViewPasswordStrength = (TextView) findViewById(R.id.textViewPasswordStrength);

		formUsername = (EditText) findViewById(R.id.txtUsernameReg);
		formPassword = (EditText) findViewById(R.id.txtPasswordReg);
		formConfirmPassword = (EditText) findViewById(R.id.confirmPasswordReg);
		passwordValidator = new PasswordValidator();
		formPassword.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable arg0) {
				boolean valid = passwordValidator.validate(formPassword
						.getText().toString());
				if (valid)
					textViewPasswordStrength
							.setText("Password Strength: Strong");
				else
					textViewPasswordStrength.setText("Password Strength: Weak");

			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

		});

		mBtnRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				username = formUsername.getText().toString();
				password = formPassword.getText().toString();
				confirmPassword = formConfirmPassword.getText().toString();

				boolean valid = passwordValidator.validate(password);

				if (password.equals(confirmPassword)) {
					Log.e("tama1", "tama2");
					if (password.length() > 7) {
						User user = new User(username, password);
						try {
							userService.registerUser(user);
						} catch (ServiceException e) {
							mTextValid
									.setText("An error has occured, cannot perform action!");
						} catch (UserAlreadyExistsException e) {
							mTextValid
									.setText("Username already exists, cannot complete registration");
						}
					} else
						mTextValid
								.setText("password length must be at least 8 characters");
				} else {
					mTextValid.setText("passwords does not match");
					Log.e("mali1", "mali2");
				}

			}
		});
	}
}