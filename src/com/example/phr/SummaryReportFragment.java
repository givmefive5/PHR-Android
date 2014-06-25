package com.example.phr;

import com.example.phr.R;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class SummaryReportFragment extends Fragment {

	ProgressBar mProgress;
	ProgressBar cProgress;
	int mProgressStatus = 70;
	int cProgressStatus = 500;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_summary_report,
				container, false);

		mProgress = (ProgressBar) rootView.findViewById(R.id.progressBar1);
		Drawable draw = getResources()
				.getDrawable(R.drawable.customprogressbar);
		mProgress.setProgressDrawable(draw);
		mProgress.setProgress(mProgressStatus);
		mProgress.setMax(100);

		// -------------------------------------------------------------------

		cProgress = (ProgressBar) rootView.findViewById(R.id.progressBar2);
		
		cProgress.setProgress(cProgressStatus);
		cProgress.setMax(1865);
		
		
		//-------------------------------------------------------------------
		View mChart;

		String[] mMonth = new String[] { "Jan", "Feb", "Mar", "Apr", "May",
				"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		int[] x = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] pound = { 80, 100, 90, 110, 130, 120, 110, 120 };

		XYSeries poundSeries = new XYSeries("Weight");

		for (int i = 0; i < x.length; i++) {
			poundSeries.add(x[i], pound[i]);
		}

		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();

		dataset.addSeries(poundSeries);

		XYSeriesRenderer weightRenderer = new XYSeriesRenderer();
		weightRenderer.setColor(Color.GREEN);
		weightRenderer.setPointStyle(PointStyle.CIRCLE);
		weightRenderer.setFillPoints(true);
		weightRenderer.setLineWidth(4);
		weightRenderer.setDisplayChartValues(true);

		XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
		multiRenderer.setXLabels(0);
		multiRenderer.setChartTitle("Weight Graph");
		multiRenderer.setXTitle("Year 2014");
		multiRenderer.setYTitle("Pound");
		multiRenderer.setZoomButtonsVisible(false);

		for (int i = 0; i < x.length; i++) {
			multiRenderer.addXTextLabel(i + 1, mMonth[i]);
		}

		multiRenderer.setApplyBackgroundColor(true);
		multiRenderer.setBackgroundColor(Color.argb(0x00, 0x01, 0x01, 0x01));
		multiRenderer.setMarginsColor(Color.argb(0x00, 0x01, 0x01, 0x01));
		multiRenderer.setAxesColor(Color.BLACK);
		multiRenderer.setLabelsColor(Color.BLACK);
		multiRenderer.setXLabelsColor(Color.BLACK);
		multiRenderer.setYLabelsColor(0, Color.BLACK);
		multiRenderer.setAxisTitleTextSize(16);
		multiRenderer.setLabelsTextSize(15);

		multiRenderer.addSeriesRenderer(weightRenderer);

		LinearLayout weightContainer = (LinearLayout) rootView
				.findViewById(R.id.graph1);

		mChart = ChartFactory.getLineChartView(getActivity().getBaseContext(),
				dataset, multiRenderer);

		weightContainer.addView(mChart);

		
		//--------------------------------------------------------------------
		
		View bloodPressureChart;

		String[] bloodPressureMonth = new String[] { "Jan", "Feb", "Mar", "Apr", "May",
				"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		int[] bloodPressurex = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] systolic = { 100, 90, 110, 120, 100, 90, 100, 110 };
		int[] diastolic = { 80, 70, 80, 60, 70, 90, 80, 70 };

		XYSeries systolicSeries = new XYSeries("Systolic");
		XYSeries diastolicSeries = new XYSeries("Diastolic");

		for (int i = 0; i < bloodPressurex.length; i++) {
			systolicSeries.add(bloodPressurex[i], systolic[i]);
			diastolicSeries.add(bloodPressurex[i], diastolic[i]);
		}

		XYMultipleSeriesDataset systolicDataset = new XYMultipleSeriesDataset();
		
		systolicDataset.addSeries(systolicSeries);
		systolicDataset.addSeries(diastolicSeries);
		
		XYSeriesRenderer bloodPressureRenderer = new XYSeriesRenderer();
		bloodPressureRenderer.setColor(Color.GREEN);
		bloodPressureRenderer.setPointStyle(PointStyle.CIRCLE);
		bloodPressureRenderer.setFillPoints(true);
		bloodPressureRenderer.setLineWidth(4);
		bloodPressureRenderer.setDisplayChartValues(true);

		XYMultipleSeriesRenderer bloodPressureMultiRenderer = new XYMultipleSeriesRenderer();
		bloodPressureMultiRenderer.setXLabels(0);
		bloodPressureMultiRenderer.setChartTitle("Blood Pressure Graph");
		bloodPressureMultiRenderer.setXTitle("Year 2014");
		bloodPressureMultiRenderer.setYTitle("Systolic/Diastolic Pressure (mm hg)");
		bloodPressureMultiRenderer.setZoomButtonsVisible(false);

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
		bloodPressureMultiRenderer.setAxisTitleTextSize(16);
		bloodPressureMultiRenderer.setLabelsTextSize(15);

		bloodPressureMultiRenderer.addSeriesRenderer(bloodPressureRenderer);

		LinearLayout bloodPressureContainer = (LinearLayout) rootView
				.findViewById(R.id.graph2);

		bloodPressureChart = ChartFactory.getLineChartView(getActivity().getBaseContext(),
				systolicDataset, bloodPressureMultiRenderer);

		bloodPressureContainer.addView(bloodPressureChart);

		
		return rootView;
	}

}
