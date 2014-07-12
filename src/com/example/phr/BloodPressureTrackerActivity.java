package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.phr.adapter.BloodPressureAdapter;
import com.example.phr.model.BloodPressure;

public class BloodPressureTrackerActivity extends Activity{

	
	ListView mBloodPressureList;
	BloodPressureAdapter bloodPressureAdapter;
	LinearLayout mBtnBloodPressurePost;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bloodpressure_tracker);
		setTitle("Blood Pressure Tracker");
        getActionBar().setDisplayHomeAsUpEnabled(true);
		mBloodPressureList = (ListView) findViewById(R.id.listView_bloodpressure);
				
		// FAKE DATA
		List<BloodPressure> list = new ArrayList<BloodPressure>();
		BloodPressure data1 = new BloodPressure(1,170,80,"Jun 18, 2014","3:40pm",null,getResources().getDrawable(R.drawable.bloodpressure_normal));
		
		BloodPressure data2 = new BloodPressure(2,180,70,"Jun 19, 2014","1:40pm",null,getResources().getDrawable(R.drawable.bloodpressure_warning));

		BloodPressure data3 = new BloodPressure(3,160,75,"Jun 20, 2014","2:40pm",null,getResources().getDrawable(R.drawable.bloodpressure_normal));
		
		BloodPressure data4 = new BloodPressure(4,170,75,"Jun 21, 2014","2:50pm",null,getResources().getDrawable(R.drawable.bloodpressure_normal));

		list.add(data3);
		list.add(data2);
		list.add(data1);
		list.add(data4);
		
		

		bloodPressureAdapter = new BloodPressureAdapter(getApplicationContext(), list);
		mBloodPressureList.setAdapter(bloodPressureAdapter);
		mBloodPressureList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.e("bloodpressure", "CLICKED!");
			}
		});
		
		mBtnBloodPressurePost = (LinearLayout) findViewById(R.id.bloodpressurePost);
		mBtnBloodPressurePost.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						BloodPressurePostActivity.class);
				startActivity(intent);
			}
		});
		
		
		//Graph	
	//------------------------------
		View bloodPressureChart;

		String[] bloodPressureMonth = new String[] { "Jun 1", "Jun 2", "Jun 3", "Jun 4", "Jun 5","Jun 6", "Jun 7", "Jun 8", "Jun 9", "Jun 10"};

		int[] bloodPressurex = { 1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10 };
		int[] systolic = { 100, 90, 110, 120, 100, 90, 100, 110,90,100 };
		int[] diastolic = { 80, 70, 80, 60, 70, 90, 80, 70,90,80 };

		XYSeries systolicSeries = new XYSeries("Systolic");
		XYSeries diastolicSeries = new XYSeries("Diastolic");

		for (int i = 0; i < bloodPressurex.length; i++) {
			systolicSeries.add(bloodPressurex[i], systolic[i]);
			diastolicSeries.add(bloodPressurex[i], diastolic[i]);
		}

		XYMultipleSeriesDataset systolicDataset = new XYMultipleSeriesDataset();
		
		systolicDataset.addSeries(systolicSeries);
		systolicDataset.addSeries(diastolicSeries);
		
		XYSeriesRenderer systolicRenderer = new XYSeriesRenderer();
		systolicRenderer.setColor(Color.parseColor("#B559BA"));
		systolicRenderer.setPointStyle(PointStyle.CIRCLE);
		systolicRenderer.setFillPoints(true);
		systolicRenderer.setLineWidth(10);
		systolicRenderer.setDisplayChartValues(true);
		systolicRenderer.setChartValuesTextSize(25);
		systolicRenderer.setChartValuesSpacing(20);

		
		XYSeriesRenderer diastolicRenderer = new XYSeriesRenderer();
		diastolicRenderer.setColor(Color.parseColor("#5C77D1"));
		diastolicRenderer.setPointStyle(PointStyle.CIRCLE);
		diastolicRenderer.setFillPoints(true);
		diastolicRenderer.setLineWidth(10);
		diastolicRenderer.setDisplayChartValues(true);
		diastolicRenderer.setChartValuesTextSize(25);
		diastolicRenderer.setChartValuesSpacing(20);

		XYMultipleSeriesRenderer bloodPressureMultiRenderer = new 

		XYMultipleSeriesRenderer();
		bloodPressureMultiRenderer.setXLabels(0);
		bloodPressureMultiRenderer.setChartTitle("Blood Pressure Graph");
		bloodPressureMultiRenderer.setXTitle("Year 2014");
		bloodPressureMultiRenderer.setYTitle("Systolic/Diastolic Pressure (mm hg)");
		bloodPressureMultiRenderer.setZoomButtonsVisible(false);
		bloodPressureMultiRenderer.setAxisTitleTextSize(30);
		bloodPressureMultiRenderer.setChartTitleTextSize(30);
		bloodPressureMultiRenderer.setLegendTextSize(30);
		bloodPressureMultiRenderer.setPointSize(10);
		bloodPressureMultiRenderer.setXAxisMin(0);
		bloodPressureMultiRenderer.setXAxisMax(7);
		
		// margin --- top, left, bottom, right
		bloodPressureMultiRenderer.setMargins(new int[] { 90, 100, 120, 50 });
		bloodPressureMultiRenderer.setLegendHeight(60);

		for (int i = 0; i < bloodPressurex.length; i++) {
			bloodPressureMultiRenderer.addXTextLabel(i + 1, bloodPressureMonth[i]);
		}

		bloodPressureMultiRenderer.setApplyBackgroundColor(true);
		bloodPressureMultiRenderer.setBackgroundColor(Color.argb(0x00, 0x01, 0x01, 0x01));
		bloodPressureMultiRenderer.setMarginsColor(Color.argb(0x00, 0x01, 0x01, 0x01));
		bloodPressureMultiRenderer.setAxesColor(Color.BLACK);
		bloodPressureMultiRenderer.setLabelsColor(Color.BLACK);
		bloodPressureMultiRenderer.setXLabelsColor(Color.BLACK);
		bloodPressureMultiRenderer.setYLabelsColor(0, Color.BLACK);
		bloodPressureMultiRenderer.setAxisTitleTextSize(30);
		bloodPressureMultiRenderer.setLabelsTextSize(30);

		bloodPressureMultiRenderer.addSeriesRenderer(systolicRenderer);
		bloodPressureMultiRenderer.addSeriesRenderer(diastolicRenderer);

		LinearLayout bloodPressureContainer = (LinearLayout) findViewById(R.id.bloopressureGraph);

		bloodPressureChart = ChartFactory.getLineChartView(getBaseContext(),
				systolicDataset, bloodPressureMultiRenderer);

		bloodPressureContainer.addView(bloodPressureChart);
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_tracker_help, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        switch (item.getItemId()) 
        {
        case android.R.id.home: 
            onBackPressed();
            break;
        default:
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
	
}
