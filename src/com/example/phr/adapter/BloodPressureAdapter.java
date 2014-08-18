package com.example.phr.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phr.BloodPressureTrackerActivity;
import com.example.phr.R;
import com.example.phr.model.BloodPressure;

public class BloodPressureAdapter extends BaseAdapter{

	

	private Context mContext;
	private List<BloodPressure> mListOfBloodPressure;

	private static class ViewHolder {
		TextView sys;
		TextView dia;
		TextView date;
		TextView time;
		//ImageView image;
	}
	
	
	public BloodPressureAdapter(Context aContext, List<BloodPressure> aListOfBloodPressures) {
		mListOfBloodPressure = aListOfBloodPressures;
		mContext = aContext;
	}

	public int getCount() {
		return mListOfBloodPressure.size();
	}

	public Object getItem(int position) {
		return mListOfBloodPressure.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;

		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(mContext);
			convertView = inflater.inflate(R.layout.item_bloodpressure, parent,
					false);

			viewHolder = new ViewHolder();
			viewHolder.sys = (TextView) convertView
					.findViewById(R.id.txtSys);
			viewHolder.dia = (TextView) convertView
					.findViewById(R.id.txtDia);
			viewHolder.date = (TextView) convertView
					.findViewById(R.id.txtdate);

			viewHolder.time = (TextView) convertView
					.findViewById(R.id.txttime);
			
			//viewHolder.image = (ImageView) convertView
			//		.findViewById(R.id.image);
			
			convertView.setTag(viewHolder);
		}

		viewHolder = (ViewHolder) convertView.getTag();
		viewHolder.sys.setText(String.valueOf(mListOfBloodPressure.get(position).getSystolic()));
		viewHolder.dia.setText(String.valueOf(mListOfBloodPressure.get(position).getDiastolic()));
		viewHolder.date.setText(String.valueOf(mListOfBloodPressure.get(
				position).getDate()));

		viewHolder.time.setText(String.valueOf(mListOfBloodPressure.get(
				position).getTime()));
		
		/*viewHolder.image.setImageDrawable(mListOfBloodPressure.get(position)
				.getImage());*/
		
		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				// FOR STATUS ON CLICK
			}
		});
		return convertView;
	}
}
