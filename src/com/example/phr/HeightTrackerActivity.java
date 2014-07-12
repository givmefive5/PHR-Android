package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import com.example.phr.adapter.HeightAdapter;
import com.example.phr.model.Height;

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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class HeightTrackerActivity extends Activity{
	
	ListView mHeightList;
	HeightAdapter heightAdapter;
	ImageButton mBtnAddHeight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_height_tracker);
		setTitle("Height Tracker");
		mHeightList = (ListView) findViewById(R.id.listView_height);
				
		// FAKE DATA
		List<Height> list = new ArrayList<Height>();
		Height data1 = new Height(1,160,"5'8",null,"Jun","5","", "7:30 pm");
		
		Height data2 = new Height(1,165,"6'1",null,"Jun","20","", "5:30 am");

		Height data3 = new Height(1,167,"6'2",null,"Jun","30","", "8:30 pm");
		Height data4 = new Height(1,167,"6'2",null,"Jul","01","", "10:30 pm");
		Height data5 = new Height(1,167,"6'2",null,"Jul","03","", "11:30 pm");

		list.add(data5);
		list.add(data4);
		list.add(data3);
		list.add(data2);
		list.add(data1);
		

		heightAdapter = new HeightAdapter(getApplicationContext(), list);
		mHeightList.setAdapter(heightAdapter);
		mHeightList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.e("height", "CLICKED!");
			}
		});
		
		
		//Graph	
		//------------------------------
			View heightChart;

			String[] heightMonth = new String[] { "Jun 5", "Jun 20", "Jun 30", "Jul 01", "Jul 03"};

			int[] heightx = { 1, 2, 3, 4, 5};
			int[] height = { 160, 160, 167, 167, 167};

			XYSeries heightSeries = new XYSeries("Height in cm");

			for (int i = 0; i < heightx.length; i++) {
				heightSeries.add(heightx[i], height[i]);
			}

			XYMultipleSeriesDataset heightDataset = new XYMultipleSeriesDataset();
			
			heightDataset.addSeries(heightSeries);
			
			XYSeriesRenderer cmRenderer = new XYSeriesRenderer();
			cmRenderer.setColor(Color.parseColor("#B559BA"));
			cmRenderer.setPointStyle(PointStyle.CIRCLE);
			cmRenderer.setFillPoints(true);
			cmRenderer.setLineWidth(10);
			cmRenderer.setDisplayChartValues(true);
			cmRenderer.setChartValuesTextSize(25);
			cmRenderer.setChartValuesSpacing(20);


			XYMultipleSeriesRenderer heightMultiRenderer = new 

			XYMultipleSeriesRenderer();
			heightMultiRenderer.setXLabels(0);
			heightMultiRenderer.setChartTitle("Height Graph");
			heightMultiRenderer.setXTitle("Year 2014");
			heightMultiRenderer.setYTitle("Height (cm)");
			heightMultiRenderer.setZoomButtonsVisible(false);
			heightMultiRenderer.setAxisTitleTextSize(30);
			heightMultiRenderer.setChartTitleTextSize(30);
			heightMultiRenderer.setLegendTextSize(30);
			heightMultiRenderer.setPointSize(10);
			heightMultiRenderer.setXAxisMin(0);
			heightMultiRenderer.setXAxisMax(7);
			
			// margin --- top, left, bottom, right
			heightMultiRenderer.setMargins(new int[] { 90, 100, 120, 50 });
			heightMultiRenderer.setLegendHeight(60);

			for (int i = 0; i < heightx.length; i++) {
				heightMultiRenderer.addXTextLabel(i + 1, heightMonth[i]);
			}

			heightMultiRenderer.setApplyBackgroundColor(true);
			heightMultiRenderer.setBackgroundColor(Color.argb(0x00, 0x01, 0x01, 0x01));
			heightMultiRenderer.setMarginsColor(Color.argb(0x00, 0x01, 0x01, 0x01));
			heightMultiRenderer.setAxesColor(Color.BLACK);
			heightMultiRenderer.setLabelsColor(Color.BLACK);
			heightMultiRenderer.setXLabelsColor(Color.BLACK);
			heightMultiRenderer.setYLabelsColor(0, Color.BLACK);
			heightMultiRenderer.setAxisTitleTextSize(30);
			heightMultiRenderer.setLabelsTextSize(30);

			heightMultiRenderer.addSeriesRenderer(cmRenderer);

			LinearLayout bloodSugarContainer = (LinearLayout) findViewById(R.id.heightGraph);

			heightChart = ChartFactory.getLineChartView(getBaseContext(),
					heightDataset, heightMultiRenderer);

			bloodSugarContainer.addView(heightChart);
			
			
		mBtnAddHeight = (ImageButton) findViewById(R.id.btnAddHeight);
		mBtnAddHeight.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						HeightTrackerPostActivity.class);
				startActivity(intent);
			}
		});
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
