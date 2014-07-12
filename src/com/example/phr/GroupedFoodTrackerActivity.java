package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.phr.adapter.GroupedFoodAdapter;
import com.example.phr.model.GroupedFood;

public class GroupedFoodTrackerActivity extends Activity {

	ListView mGroupedFoodList;
	GroupedFoodAdapter groupedfoodAdapter;
	ImageView mBtnGroupedFoodPost;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_groupedfood_tracker);
        getActionBar().setDisplayHomeAsUpEnabled(true);
		setTitle("GroupedFood Tracker");
		mGroupedFoodList = (ListView) findViewById(R.id.listView_groupedfood);
				
		// FAKE DATA
		List<GroupedFood> list = new ArrayList<GroupedFood>();
		GroupedFood data1 = new GroupedFood("Jun","09",1222,883,23,344);
		
		GroupedFood data2 = new GroupedFood("May","01",9822,883,23,344);
		GroupedFood data3 = new GroupedFood("Apr","8",152,883,23,344);

		list.add(data3);
		list.add(data3);
		list.add(data3);
		list.add(data2);
		list.add(data2);
		list.add(data2);
		list.add(data1);
		list.add(data1);
		list.add(data1);

		groupedfoodAdapter = new GroupedFoodAdapter(getApplicationContext(), list);
		mGroupedFoodList.setAdapter(groupedfoodAdapter);
		mGroupedFoodList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.e("groupedfood", "CLICKED!");
			}
		});
		
		mBtnGroupedFoodPost = (ImageView) findViewById(R.id.foodBanner);
		mBtnGroupedFoodPost.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						FoodTrackerPostActivity.class);
				startActivity(intent);
			}
		});
	}

}
