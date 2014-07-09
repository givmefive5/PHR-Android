package com.example.phr.adapter;

import java.util.List;

import com.example.phr.CheckupTrackerActivity;
import com.example.phr.HeightTrackerActivity;
import com.example.phr.R;
import com.example.phr.model.Height;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class HeightAdapter extends BaseAdapter {

	private Context mContext;
	private List<Height> mListOfHeight;

	private static class ViewHolder {
		TextView time;
		TextView heightInch;
		TextView heightCm;
		TextView day;
		TextView month;
	}

	public HeightAdapter(Context aContext, List<Height> aListOfHeights) {
		mListOfHeight = aListOfHeights;
		mContext = aContext;
	}

	@Override
	public int getCount() {
		return mListOfHeight.size();
	}

	@Override
	public Object getItem(int position) {
		return mListOfHeight.get(position);
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
			convertView = inflater.inflate(R.layout.item_height, parent,
					false);

			viewHolder = new ViewHolder();
			viewHolder.time = (TextView) convertView
					.findViewById(R.id.txtTime);
			viewHolder.heightInch = (TextView) convertView
					.findViewById(R.id.txtInch);
			viewHolder.heightCm = (TextView) convertView
					.findViewById(R.id.txtCm);

			viewHolder.day = (TextView) convertView
					.findViewById(R.id.txtHeightDay);
			
			viewHolder.month = (TextView) convertView
					.findViewById(R.id.txtHeightMonth);
			
			convertView.setTag(viewHolder);
		}

		viewHolder = (ViewHolder) convertView.getTag();
		viewHolder.time.setText(mListOfHeight.get(position).getHeightTime()
				.toString());
		viewHolder.heightInch.setText(mListOfHeight.get(position).getHeightInInch()
				.toString());
		viewHolder.heightCm.setText(String.valueOf(mListOfHeight.get(
				position).getHeightInCm()));

		viewHolder.day.setText(String.valueOf(mListOfHeight.get(
				position).getHeightDay()));
		
		viewHolder.month.setText(String.valueOf(mListOfHeight.get(
				position).getHeightMonth()));
		
		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				// FOR STATUS ON CLICK
				Intent intent = new Intent(mContext,
						HeightTrackerActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);;
				v.getContext().startActivity(intent);
			}
		});
		return convertView;
	}

}
