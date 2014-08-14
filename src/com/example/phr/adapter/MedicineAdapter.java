package com.example.phr.adapter;

import java.util.List;

import com.example.phr.R;
import com.example.phr.model.Medicine;
import com.example.phr.model.Status;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MedicineAdapter extends BaseAdapter {

	private Context mContext;
	private List<Medicine> mListOfMedicine;
	private int positionSelected;

	private static class ViewHolder {
		TextView medicineName;
		TextView intakeStatus;
		TextView purpose;
		TextView frequency;
		ImageView imgMedicine;
	}

	public MedicineAdapter(Context aContext, List<Medicine> aListOfMedicine) {
		mListOfMedicine = aListOfMedicine;
		mContext = aContext;
	}

	@Override
	public int getCount() {
		return mListOfMedicine.size();
	}

	@Override
	public Object getItem(int position) {
		return mListOfMedicine.get(position);
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
			convertView = inflater.inflate(R.layout.item_medicine, parent,
					false);

			viewHolder = new ViewHolder();
			viewHolder.medicineName = (TextView) convertView.findViewById(R.id.txtMedicineName);
			viewHolder.intakeStatus = (TextView) convertView.findViewById(R.id.txtMedicineStatus);
			viewHolder.purpose = (TextView) convertView.findViewById(R.id.txtMedicinePurpose);
			viewHolder.frequency = (TextView) convertView.findViewById(R.id.txtMedicineFrequency);
			viewHolder.imgMedicine = (ImageView) convertView
					.findViewById(R.id.imageViewMedicinePill);

			convertView.setTag(viewHolder);
		}

		viewHolder = (ViewHolder) convertView.getTag();
		viewHolder.medicineName.setText(mListOfMedicine.get(position).getMedicineName()
				.toString());
		viewHolder.intakeStatus.setText(mListOfMedicine.get(position).getIntakeStatus()
				.toString());
		viewHolder.purpose.setText(mListOfMedicine.get(position).getPurpose()
				.toString());
		viewHolder.frequency.setText(mListOfMedicine.get(position).getFrequency()
				.toString());
		viewHolder.imgMedicine.setImageDrawable(mListOfMedicine.get(position)
				.getImgMedicine());

		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		return convertView;
	}

}
