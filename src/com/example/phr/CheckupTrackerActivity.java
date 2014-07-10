package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import com.example.phr.adapter.CheckupAdapter;
import com.example.phr.model.Checkup;
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

public class CheckupTrackerActivity extends Activity {

	ListView mCheckupList;
	CheckupAdapter checkupAdapter;
	ImageView mBtnCheckupPost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkup_tracker);
		setTitle("Checkup Tracker");
		mCheckupList = (ListView) findViewById(R.id.listView_checkup);
				
		// FAKE DATA
		List<Checkup> list = new ArrayList<Checkup>();
		Checkup data1 = new Checkup("Cought","Dr. Mark Castilo","Metropolitan","5","June", null);
		
		Checkup data2 = new Checkup("Fever","Dr. Matthew Go","Metropolitan","5","May", null);

		Checkup data3 = new Checkup("Dengue","Dr. Mark Castilo","Metropolitan","6","April",null);

		list.add(data3);
		list.add(data3);
		list.add(data3);
		list.add(data2);
		list.add(data2);
		list.add(data2);
		list.add(data1);
		list.add(data1);
		list.add(data1);

		checkupAdapter = new CheckupAdapter(getApplicationContext(), list);
		mCheckupList.setAdapter(checkupAdapter);
		mCheckupList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.e("checkup", "CLICKED!");
			}
		});
		
		mBtnCheckupPost = (ImageView) findViewById(R.id.checkupBanner);
		mBtnCheckupPost.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						CheckupPostActivity.class);
				startActivity(intent);
			}
		});
	}
}
