package com.example.phr;

import com.example.phr.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class HealthTrackerFragment extends Fragment {

	private LinearLayout mBtnFoodTracker;
	private LinearLayout mBtnCheckupTracker;
	private LinearLayout mBtnBloodPressureTracker;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_health_tracker, container,
				false);
		
		mBtnFoodTracker = (LinearLayout)rootView.findViewById(R.id.btnFoodTracker);
		mBtnFoodTracker.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),
						FoodTrackerActivity.class);
				startActivity(intent);
			}
		});
		
		mBtnCheckupTracker = (LinearLayout)rootView.findViewById(R.id.btnCheckupTracker);
		mBtnCheckupTracker.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),
						CheckupTrackerActivity.class);
				startActivity(intent);
			}
		});
		
		
		mBtnBloodPressureTracker = (LinearLayout)rootView.findViewById(R.id.btnBloodPressureTracker);
		mBtnBloodPressureTracker.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),
						BloodPressureTrackerActivity.class);
				startActivity(intent);
			}
		});
		
		return rootView;
	}

}
