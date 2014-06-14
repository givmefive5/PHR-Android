package com.example.phr.adapter;

import java.util.List;

import com.example.phr.R;
import com.example.phr.model.DailyJournal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class JournalAdapter extends BaseAdapter {

	private Context mContext;
	private List<DailyJournal> mListOfJournals;
	private int positionSelected;
	
	private static class ViewHolder {
		TextView weight;
		TextView calories;
		TextView activities;
		TextView date;
		ImageView img;
	}

	public JournalAdapter(Context aContext, List<DailyJournal> aListOfJournals) {
		mListOfJournals = aListOfJournals;
		mContext = aContext;
	}

	@Override
	public int getCount() {
		return mListOfJournals.size();
	}

	@Override
	public Object getItem(int position) {
		return mListOfJournals.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(mContext);
			convertView = inflater.inflate(R.layout.item_journal_daily, parent, false);

			viewHolder = new ViewHolder();
			viewHolder.weight = (TextView) convertView
					.findViewById(R.id.txtWeight);
			viewHolder.calories = (TextView) convertView
					.findViewById(R.id.txtCalories);
			viewHolder.activities = (TextView) convertView
					.findViewById(R.id.txtActivities);
			viewHolder.date = (TextView) convertView
					.findViewById(R.id.txtDate);
			viewHolder.img = (ImageView) convertView
					.findViewById(R.id.imgDailyGemLevel);

			convertView.setTag(viewHolder);
		}

		viewHolder = (ViewHolder) convertView.getTag();
		viewHolder.weight.setText(mListOfJournals.get(position).getWeight()
				.toString());
		viewHolder.calories.setText(mListOfJournals.get(position)
				.getCalories().toString());
		viewHolder.activities.setText(String.valueOf(mListOfJournals.get(
				position).getActivities()));
		viewHolder.date.setText(mListOfJournals.get(position)
				.getDate().toString());
		viewHolder.img.setImageDrawable(mListOfJournals.get(position)
				.getImgUrl());

		
		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				

			}
		});
		return convertView;
	}

}
