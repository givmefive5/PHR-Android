package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.phr.adapter.BloodSugarAdapter;
import com.example.phr.model.BloodSugar;

public class BloodSugarTrackerActivity extends Activity{

	
	ListView mBloodSugarList;
	BloodSugarAdapter bloodSugarAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bloodsugar_tracker);
		
		mBloodSugarList = (ListView) findViewById(R.id.listView_bloodsugar);
				
		// FAKE DATA
		List<BloodSugar> list = new ArrayList<BloodSugar>();
		BloodSugar data1 = new BloodSugar(1, 4.5, "after meal" ,"" ,"Jun 10, 2014", "3:40pm", getResources().getDrawable(R.drawable.smileygood));
		
		BloodSugar data2 = new BloodSugar(2, 9.5, "before meal" ,"" ,"Jun 09, 2014", "5:40pm", getResources().getDrawable(R.drawable.bloodsugarbad));

		BloodSugar data3 = new BloodSugar(3, 11, "after meal" ,"" ,"Jun 08, 2014", "8:40pm", getResources().getDrawable(R.drawable.bloodsugarbad));
		
		BloodSugar data4 = new BloodSugar(4, 12.3, "before meal" ,"" ,"Jun 07, 2014", "3:40pm", getResources().getDrawable(R.drawable.bloodsugarbad));

		list.add(data3);
		list.add(data2);
		list.add(data1);
		list.add(data4);
		
		

		bloodSugarAdapter = new BloodSugarAdapter(getApplicationContext(), list);
		mBloodSugarList.setAdapter(bloodSugarAdapter);
		mBloodSugarList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.e("bloodsugar", "CLICKED!");
			}
		});
		
		//Graph	
	//------------------------------
		View bloodSugarChart;

		String[] bloodSugarMonth = new String[] { "Jun 1", "Jun 2", "Jun 3", "Jun 4", "Jun 5","Jun 6", "Jun 7", "Jun 8", "Jun 9", "Jun 10"};

		int[] bloodSugarx = { 1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10 };
		int[] bloodsugar = { 100, 90, 110, 120, 100, 90, 100, 110,90,100 };

		XYSeries bloodSugarSeries = new XYSeries("Glucose Level");

		for (int i = 0; i < bloodSugarx.length; i++) {
			bloodSugarSeries.add(bloodSugarx[i], bloodsugar[i]);
		}

		XYMultipleSeriesDataset bloodsugarDataset = new XYMultipleSeriesDataset();
		
		bloodsugarDataset.addSeries(bloodSugarSeries);
		
		XYSeriesRenderer systolicRenderer = new XYSeriesRenderer();
		systolicRenderer.setColor(Color.parseColor("#B559BA"));
		systolicRenderer.setPointStyle(PointStyle.CIRCLE);
		systolicRenderer.setFillPoints(true);
		systolicRenderer.setLineWidth(10);
		systolicRenderer.setDisplayChartValues(true);
		systolicRenderer.setChartValuesTextSize(25);
		systolicRenderer.setChartValuesSpacing(20);


		XYMultipleSeriesRenderer bloodSugarMultiRenderer = new 

		XYMultipleSeriesRenderer();
		bloodSugarMultiRenderer.setXLabels(0);
		bloodSugarMultiRenderer.setChartTitle("Blood Sugar Graph");
		bloodSugarMultiRenderer.setXTitle("Year 2014");
		bloodSugarMultiRenderer.setYTitle("Glucose Level (mmol/L)");
		bloodSugarMultiRenderer.setZoomButtonsVisible(false);
		bloodSugarMultiRenderer.setAxisTitleTextSize(30);
		bloodSugarMultiRenderer.setChartTitleTextSize(30);
		bloodSugarMultiRenderer.setLegendTextSize(30);
		bloodSugarMultiRenderer.setPointSize(10);
		bloodSugarMultiRenderer.setXAxisMin(0);
		bloodSugarMultiRenderer.setXAxisMax(7);
		
		// margin --- top, left, bottom, right
		bloodSugarMultiRenderer.setMargins(new int[] { 90, 100, 120, 50 });
		bloodSugarMultiRenderer.setLegendHeight(60);

		for (int i = 0; i < bloodSugarx.length; i++) {
			bloodSugarMultiRenderer.addXTextLabel(i + 1, bloodSugarMonth[i]);
		}

		bloodSugarMultiRenderer.setApplyBackgroundColor(true);
		bloodSugarMultiRenderer.setBackgroundColor(Color.argb(0x00, 0x01, 0x01, 0x01));
		bloodSugarMultiRenderer.setMarginsColor(Color.argb(0x00, 0x01, 0x01, 0x01));
		bloodSugarMultiRenderer.setAxesColor(Color.BLACK);
		bloodSugarMultiRenderer.setLabelsColor(Color.BLACK);
		bloodSugarMultiRenderer.setXLabelsColor(Color.BLACK);
		bloodSugarMultiRenderer.setYLabelsColor(0, Color.BLACK);
		bloodSugarMultiRenderer.setAxisTitleTextSize(30);
		bloodSugarMultiRenderer.setLabelsTextSize(30);

		bloodSugarMultiRenderer.addSeriesRenderer(systolicRenderer);

		LinearLayout bloodSugarContainer = (LinearLayout) findViewById(R.id.bloodsugarGraph);

		bloodSugarChart = ChartFactory.getLineChartView(getBaseContext(),
				bloodsugarDataset, bloodSugarMultiRenderer);

		bloodSugarContainer.addView(bloodSugarChart);
		
		
	}
}
