package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import com.example.phr.adapter.JournalAdapter;
import com.example.phr.model.DailyJournal;
import com.example.phr.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class JournalFragment extends Fragment {

	ListView mDailyJournalList;
	LinearLayout mJournalTabsPlaceholder;
	JournalAdapter journalAdapter;
	Button mBtnStatus;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_journal, container,
				false);

		mDailyJournalList = (ListView) rootView
				.findViewById(R.id.listView_daily_journal);
		mJournalTabsPlaceholder = (LinearLayout) rootView
				.findViewById(R.id.journalTabsPlaceholder);

		/*-----------------------OLD POST STATUS BUTTONS------------------
		mDailyJournalList.setOnScrollListener(new OnScrollListener() {
			int prevVisibleItem = 0;

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				if (prevVisibleItem != firstVisibleItem) {
					if (prevVisibleItem < firstVisibleItem)
						mJournalTabsPlaceholder.setVisibility(View.GONE);
					else
						mJournalTabsPlaceholder.setVisibility(View.VISIBLE);

					prevVisibleItem = firstVisibleItem;
				}
			}

			@Override
			public void onScrollStateChanged(AbsListView arg0, int scrollState) {
				// TODO Auto-generated method stub
				/*
				 * if(scrollState == OnScrollListener.SCROLL_STATE_IDLE)
				 * mJournalTabsPlaceholder.setVisibility(View.VISIBLE); else
				 * mJournalTabsPlaceholder.setVisibility(View.GONE);
				 /
			}
		});
		*/

		// FAKE DATA
		List<DailyJournal> list = new ArrayList<DailyJournal>();
		DailyJournal data1 = new DailyJournal();
		data1.setWeight("10");
		data1.setCalories("1000");
		data1.setActivities("Jogging, Swimming");
		data1.setDate("June 10, 2014");
		data1.setImgUrl(getResources().getDrawable(R.drawable.level_1_diamond));
		DailyJournal data2 = new DailyJournal();
		data2.setWeight("20");
		data2.setCalories("2000");
		data2.setActivities("Swimming");
		data2.setDate("June 11, 2014");
		data2.setImgUrl(getResources().getDrawable(R.drawable.level_1_diamond));
		DailyJournal data3 = new DailyJournal();
		data3.setWeight("30");
		data3.setCalories("3000");
		data3.setActivities("Running, Swimming");
		data3.setDate("June 13, 2014");
		data3.setImgUrl(getResources().getDrawable(R.drawable.level_1_diamond));
		list.add(data3);
		list.add(data3);
		list.add(data3);
		list.add(data2);
		list.add(data2);
		list.add(data2);
		list.add(data1);
		list.add(data1);
		list.add(data1);

		journalAdapter = new JournalAdapter(this.getActivity()
				.getApplicationContext(), list);
		mDailyJournalList.setAdapter(journalAdapter);
		mDailyJournalList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.e("JOURNAL", "CLICKED!");
			}
		});

		mBtnStatus = (Button) rootView.findViewById(R.id.btnStatus);
		mBtnStatus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),
						NewStatusActivity.class);
				startActivity(intent);
			}
		});

		return rootView;
	}
}
