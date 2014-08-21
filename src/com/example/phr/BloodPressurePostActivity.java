package com.example.phr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.phr.exceptions.OutdatedAccessTokenException;
import com.example.phr.exceptions.ServiceException;
import com.example.phr.local_db.DatabaseHandler;
import com.example.phr.model.BloodPressure;
import com.example.phr.service.BloodPressureService;
import com.example.phr.serviceimpl.BloodPressureServiceImpl;

public class BloodPressurePostActivity extends Activity {

	private ImageButton mBtnAddPhoto;
	private TextView textViewBloodPressureCalendar;
	private TextView textViewBloodPressureClock;
	private TextView textViewbloodpressureStatus;
	private NumberPicker systolicPicker;
	private NumberPicker diastolicPicker;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bloodpressure_post);
		setTitle("Blood Pressure");

		mBtnAddPhoto = (ImageButton) findViewById(R.id.btnAddImageBloodPressure);
		mBtnAddPhoto.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
				startActivity(intent);
			}
		});

		systolicPicker = (NumberPicker) findViewById(R.id.systolicPicker);
		diastolicPicker = (NumberPicker) findViewById(R.id.diastolicPicker);
		textViewbloodpressureStatus = (TextView) findViewById(R.id.textViewbloodpressureStatus);
		textViewBloodPressureCalendar = (TextView) findViewById(R.id.textViewBloodPressureCalendar);
		textViewBloodPressureClock = (TextView) findViewById(R.id.textViewBloodPressureClock);

		Time today = new Time(Time.getCurrentTimezone());
		today.setToNow();

		textViewBloodPressureCalendar.setText(today.month + " / "
				+ today.monthDay + " / " + today.year);
		textViewBloodPressureClock.setText(today.format("%k:%M:%S"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_status_post, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_item_status_post:
			try {
				addBloodPressureToDatabase();
			} catch (ServiceException e) {
				// output error message or something
				System.out.println(e.getMessage());
			} catch (OutdatedAccessTokenException e) {
				// Message - > Log user out
				e.printStackTrace();
			}
			onBackPressed();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	private void addBloodPressureToDatabase() throws ServiceException,
			OutdatedAccessTokenException {
		DatabaseHandler db = new DatabaseHandler(this.getApplicationContext());
		Log.e("Insert: ", "Inserting ..");
		BloodPressure bp = new BloodPressure(systolicPicker.getCurrent(),
				diastolicPicker.getCurrent(), textViewBloodPressureCalendar
						.getText().toString(), textViewBloodPressureClock
						.getText().toString(), textViewbloodpressureStatus
						.getText().toString());
		db.addBloodPressure(bp);
		BloodPressureService bpService = new BloodPressureServiceImpl(
				this.getApplicationContext());
		bpService.addBloodPressure(bp);
	}
}
