package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import com.example.phr.adapter.CheckupAdapter;
import com.example.phr.adapter.JournalAdapter;
import com.example.phr.model.Checkup;
import com.example.phr.model.DailyJournal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class CheckupFragment extends Fragment {

	ListView mCheckupList;
	CheckupAdapter checkupAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_checkup, container,
				false);

		mCheckupList = (ListView) rootView
				.findViewById(R.id.listView_checkup);
		

		
		// FAKE DATA
		List<Checkup> list = new ArrayList<Checkup>();
		Checkup data1 = new Checkup();
		data1.setAilment("Cough");
		data1.setDoctor("Dr. Mark Castilo");
		data1.setClinic("Metropolitan");
		data1.setDay("5");
		data1.setMonth("June");
		
		
		Checkup data2 = new Checkup();
		data2.setAilment("Fever");
		data2.setDoctor("Dr. Matthew Go");
		data2.setClinic("Metropolitan");
		data2.setDay("5");
		data2.setMonth("May");

		Checkup data3 = new Checkup();
		data3.setAilment("Dengue");
		data3.setDoctor("Dr. Mark Castilo");
		data3.setClinic("Metropolitan");
		data3.setDay("6");
		data3.setMonth("April");

		list.add(data3);
		list.add(data3);
		list.add(data3);
		list.add(data2);
		list.add(data2);
		list.add(data2);
		list.add(data1);
		list.add(data1);
		list.add(data1);

		checkupAdapter = new CheckupAdapter(this.getActivity()
				.getApplicationContext(), list);
		mCheckupList.setAdapter(checkupAdapter);
		mCheckupList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.e("checkup", "CLICKED!");
			}
		});
		
		

		return rootView;
	}
}
