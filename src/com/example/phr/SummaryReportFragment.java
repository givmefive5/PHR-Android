package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import com.example.phr.R;
import android.graphics.Color;
import android.graphics.Paint.Align;
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
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;


public class SummaryReportFragment extends Fragment {

	ProgressBar mProgress;
	ProgressBar cProgress;
	int mProgressStatus = 70;
	
	
	
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

		View dailyChart;
		
		String[] kind = new String[] { "Calorie", "Sugar", "Sodium", "Cholesterol", "Carbohydrade"};
		
		String[] titles = new String[] { "Max", "Current" };
	    List<double[]> values = new ArrayList<double[]>();
	    values.add(new double[] { 14230, 12300, 14240, 15244, 15900});
	    values.add(new double[] { 5230, 7300, 9240, 10540, 7900});
	    int[] colors = new int[] { Color.rgb(204, 85, 0), Color.WHITE };
	    XYMultipleSeriesRenderer renderer = buildBarRenderer(colors);
	    setChartSettings(renderer, "Daily Consume", "Kind", "Measure", 0.5,
	        12.5, 0, 24000, Color.WHITE, Color.LTGRAY);
	    renderer.getSeriesRendererAt(0).setDisplayChartValues(true);
	    renderer.getSeriesRendererAt(1).setDisplayChartValues(true);
	    renderer.setXLabelsAlign(Align.LEFT);
	    renderer.setYLabelsAlign(Align.LEFT);
	    renderer.setPanEnabled(true, false);
	    renderer.setZoomEnabled(false);
	    renderer.setZoomRate(1.1f);
	    renderer.setBarSpacing(100);
	    renderer.setBarWidth(10);
	    renderer.setMargins(new int[] {20, 30, 15, 0});
        renderer.setXAxisMin(-1);
        renderer.setXAxisMax(5);
        renderer.setYAxisMin(0);
        renderer.setChartValuesTextSize(20);
	    renderer.setApplyBackgroundColor(true);
		renderer.setBackgroundColor(Color.argb(0x00, 0x01, 0x01, 0x01));
		renderer.setMarginsColor(Color.argb(0x00, 0x01, 0x01, 0x01));
		
		for (int i = 0; i < kind.length; i++) {
			renderer.addXTextLabel(i + 1, kind[i]);
		}
		
	    dailyChart = ChartFactory.getBarChartView(getActivity().getBaseContext(), buildBarDataset(titles, values), renderer,
	            Type.STACKED);
	    
	    LinearLayout dailyContainer = (LinearLayout) rootView
				.findViewById(R.id.linearLayoutWeight);
	    
	    dailyContainer.addView(dailyChart);
	    
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
		weightRenderer.setColor(Color.BLUE);
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
		multiRenderer.setAxesColor(Color.WHITE);
		multiRenderer.setLabelsColor(Color.WHITE);
		multiRenderer.setXLabelsColor(Color.WHITE);
		multiRenderer.setYLabelsColor(0, Color.WHITE);
		multiRenderer.setAxisTitleTextSize(16);
		multiRenderer.setLabelsTextSize(15);
		multiRenderer.setChartValuesTextSize(20);

		multiRenderer.addSeriesRenderer(weightRenderer);

		LinearLayout weightContainer = (LinearLayout) rootView
				.findViewById(R.id.graph1);

		mChart = ChartFactory.getLineChartView(getActivity().getBaseContext(),
				dataset, multiRenderer);

		weightContainer.addView(mChart);

		
		//--------------------------------------------------------------------
		View bloodPressureChart;

		String[] bloodPressureMonth = new String[] { "Jan", "Feb", "Mar", 

"Apr", "May",
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
		
		XYSeriesRenderer systolicRenderer = new XYSeriesRenderer();
		systolicRenderer.setColor(Color.BLUE);
		systolicRenderer.setPointStyle(PointStyle.CIRCLE);
		systolicRenderer.setFillPoints(true);
		systolicRenderer.setLineWidth(4);
		systolicRenderer.setDisplayChartValues(true);
		
		XYSeriesRenderer diastolicRenderer = new XYSeriesRenderer();
		diastolicRenderer.setColor(Color.RED);
		diastolicRenderer.setPointStyle(PointStyle.CIRCLE);
		diastolicRenderer.setFillPoints(true);
		diastolicRenderer.setLineWidth(4);
		diastolicRenderer.setDisplayChartValues(true);

		XYMultipleSeriesRenderer bloodPressureMultiRenderer = new 

		XYMultipleSeriesRenderer();
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
		bloodPressureMultiRenderer.setAxesColor(Color.WHITE);
		bloodPressureMultiRenderer.setLabelsColor(Color.WHITE);
		bloodPressureMultiRenderer.setXLabelsColor(Color.WHITE);
		bloodPressureMultiRenderer.setYLabelsColor(0, Color.WHITE);
		bloodPressureMultiRenderer.setAxisTitleTextSize(16);
		bloodPressureMultiRenderer.setLabelsTextSize(15);

		bloodPressureMultiRenderer.addSeriesRenderer(systolicRenderer);
		bloodPressureMultiRenderer.addSeriesRenderer(diastolicRenderer);

		LinearLayout bloodPressureContainer = (LinearLayout) rootView
				.findViewById(R.id.graph2);

		bloodPressureChart = ChartFactory.getLineChartView(getActivity().getBaseContext(),
				systolicDataset, bloodPressureMultiRenderer);

		bloodPressureContainer.addView(bloodPressureChart);
		

		
		return rootView;
	}

	

	protected void setChartSettings(XYMultipleSeriesRenderer renderer,
			String title, String xTitle, String yTitle, double xMin,
			double xMax, double yMin, double yMax, int axesColor,
			int labelsColor) {
		renderer.setChartTitle(title);
		renderer.setXTitle(xTitle);
		renderer.setYTitle(yTitle);
		renderer.setXAxisMin(xMin);
		renderer.setXAxisMax(xMax);
		renderer.setYAxisMin(yMin);
		renderer.setYAxisMax(yMax);
		renderer.setAxesColor(axesColor);
		renderer.setLabelsColor(labelsColor);
	}
	 
	 protected XYMultipleSeriesRenderer buildBarRenderer(int[] colors) {
			XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
			renderer.setAxisTitleTextSize(16);
			renderer.setChartTitleTextSize(20);
			renderer.setLabelsTextSize(15);
			renderer.setLegendTextSize(15);
			int length = colors.length;
			for (int i = 0; i <length; i++) {
				SimpleSeriesRenderer r = new SimpleSeriesRenderer();
				r.setColor(colors[i]);
				renderer.addSeriesRenderer(r);
			}
			return renderer;
		}
	 
	 protected XYMultipleSeriesDataset buildBarDataset(String[] titles,
				List<double[]> values) {//The data source and the pie chart almost, is by some key value pairs
			XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
			int length = titles.length;
			for (int i = 0; i <length; i++) {
				CategorySeries series = new CategorySeries(titles[i]);
				double[] v = values.get(i);
				int seriesLength = v.length;
				for (int k = 0; k <seriesLength; k++) {
					series.add(v[k]);
				}
				dataset.addSeries(series.toXYSeries());
			}
			return dataset;
		}
}
