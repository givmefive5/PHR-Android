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
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;


public class SummaryReportFragment extends Fragment {

	ProgressBar mProgress;
	ProgressBar cProgress;
	int mProgressStatus = 50;
	int cProgressStatus = 80;
	
	
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
		draw = getResources()
				.getDrawable(R.drawable.customprogressbar);
		cProgress.setProgressDrawable(draw);
		cProgress.setProgress(cProgressStatus);
		cProgress.setMax(100);
		
		
		//-----chart
		/*View categoryChart;

		
		   String[] code = new String[] {
		            "Sodium", "Carbohydrate", "Sugar", "Cholesterol"};
		 
		        // Pie Chart Section Value
		        double[] distribution = { 270, 300, 230, 320} ;
		 
		        // Color of each Pie Chart Sections
		        int[] colors = { Color.parseColor("#5C77D1"),Color.parseColor("#C177C9"), Color.parseColor("#E8BB6D"), Color.parseColor("#6D9AE8")};
		 
		        // Instantiating CategorySeries to plot Pie Chart
		        CategorySeries distributionSeries = new CategorySeries(" Calorie Subcategory");
		        for(int i=0 ;i < distribution.length;i++){
		            // Adding a slice with its values and name to the Pie Chart
		            distributionSeries.add(code[i], distribution[i]);
		        }
		 
		        // Instantiating a renderer for the Pie Chart
		        DefaultRenderer defaultRenderer  = new DefaultRenderer();
		        for(int i = 0 ;i<distribution.length;i++){
		            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
		            seriesRenderer.setColor(colors[i]);
		            seriesRenderer.setDisplayBoundingPoints(true);
		            seriesRenderer.setDisplayChartValuesDistance(30);
		            seriesRenderer.setChartValuesTextSize(40);
		          
		            seriesRenderer.setDisplayChartValues(true);
		            defaultRenderer.addSeriesRenderer(seriesRenderer);
		        }
		 
		        defaultRenderer.setChartTitle("Calorie Subcategory \n\n\n\n");
		        defaultRenderer.setChartTitleTextSize(40);
		        defaultRenderer.setLabelsTextSize(50);
		        defaultRenderer.setLegendTextSize(50);
		        defaultRenderer.setZoomButtonsVisible(false);
		        defaultRenderer.setShowLabels(true);  
		        defaultRenderer.isInScroll();
		        
		
		 
		        LinearLayout bloodPressureContainer = (LinearLayout) rootView.findViewById(R.id.piegraph);

				categoryChart = ChartFactory.getPieChartView(getActivity().getBaseContext(), distributionSeries , defaultRenderer);

				bloodPressureContainer.addView(categoryChart);
				*/
		
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
	    renderer.setBarWidth(30);
	    renderer.setMargins(new int[] {20, 30, 15, 0});
        renderer.setXAxisMin(0);
        renderer.setXAxisMax(5);
        renderer.setYAxisMin(0);
        renderer.setChartValuesTextSize(20);
	    renderer.setApplyBackgroundColor(true);
		renderer.setBackgroundColor(Color.argb(0x00, 0x01, 0x01, 0x01));
		renderer.setMarginsColor(Color.argb(0x00, 0x01, 0x01, 0x01));
		
		for (int i = 0; i < kind.length; i++) {
			renderer.addXTextLabel(i + 1, kind[i]);
		}
		
	    dailyChart = ChartFactory.getBarChartView(getActivity().getBaseContext(), buildBarDataset(titles, values), renderer,Type.STACKED);
	    
	    LinearLayout dailyContainer = (LinearLayout) rootView
				.findViewById(R.id.piegraph);
	    
	    dailyContainer.addView(dailyChart);
		
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
