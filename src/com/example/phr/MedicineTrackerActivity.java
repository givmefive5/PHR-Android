package com.example.phr;

import java.util.ArrayList;
import java.util.List;
import com.example.phr.adapter.MedicineAdapter;
import com.example.phr.model.Medicine;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MedicineTrackerActivity extends Activity {
	
	MedicineAdapter medicineAdapter;
	ListView mMedicineList;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medicine_tracker);
		mMedicineList = (ListView) findViewById(R.id.listViewMedicineTracker);
		medicineAdapter = new MedicineAdapter(getApplicationContext(), generateData());
		mMedicineList.setAdapter(medicineAdapter);
	}

	private List<Medicine> generateData() {
		List<Medicine> list = new ArrayList<Medicine>();
		
		Medicine pill1 = new Medicine();
		pill1.setMedicineName("Tempra");
		pill1.setIntakeStatus("TAKEN");
		pill1.setPurpose("Cold");
		pill1.setFrequency("2x / Day");
		pill1.setImgMedicine(getResources().getDrawable(R.drawable.icon_medicine));
		list.add(pill1);
		
		Medicine pill2 = new Medicine();
		pill2.setMedicineName("Absorica");
		pill2.setIntakeStatus("NOT TAKEN");
		pill2.setPurpose("Supplement");
		pill2.setFrequency("1x / Day");
		pill2.setImgMedicine(getResources().getDrawable(R.drawable.icon_medicine));
		list.add(pill2);
		
		Medicine pill3 = new Medicine();
		pill3.setMedicineName("Valrubicin");
		pill3.setIntakeStatus("TAKEN");
		pill3.setPurpose("Vitamin");
		pill3.setFrequency("5x / Day");
		pill3.setImgMedicine(getResources().getDrawable(R.drawable.icon_medicine));
		list.add(pill3);
		
		Medicine pill4 = new Medicine();
		pill4.setMedicineName("Kytril Injection");
		pill4.setIntakeStatus("TAKEN");
		pill4.setPurpose("Maintenance");
		pill4.setFrequency("1x / Day");
		pill4.setImgMedicine(getResources().getDrawable(R.drawable.icon_medicine));
		list.add(pill4);
		

		list.add(pill1);
		list.add(pill2);
		list.add(pill3);
		list.add(pill4);
		list.add(pill1);
		list.add(pill2);
		list.add(pill3);
		list.add(pill4);
		list.add(pill1);
		list.add(pill2);
		list.add(pill3);
		list.add(pill4);
		list.add(pill1);
		list.add(pill2);
		list.add(pill3);
		list.add(pill4);
		
		return list;
	}
	

}
