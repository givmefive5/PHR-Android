package com.example.phr;

import com.example.phr.R;
import com.example.phr.graphs.GraphViewData;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
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
    int mProgressStatus = 20;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_summary_report, container, false);
		
		mProgress = (ProgressBar) rootView.findViewById(R.id.progressBar1);                   
	    Drawable draw = getResources().getDrawable(R.drawable.customprogressbar);
	    mProgress.setProgressDrawable(draw);
        mProgress.setProgress(mProgressStatus);
        mProgress.setMax(100);
		
		GraphViewSeries exampleSeries = new GraphViewSeries(new GraphViewData[] {
			    new GraphViewData(1, 2.0d)
			    , new GraphViewData(2, 1.5d)
			    , new GraphViewData(3, 2.5d)
			    , new GraphViewData(4, 1.0d)
			});
			 
		GraphView graphView = new LineGraphView(
		    this.getActivity().getApplicationContext() // context
		    , "GraphViewDemo" // heading
		);
		graphView.addSeries(exampleSeries); // data
		graphView.getGraphViewStyle().setGridColor(Color.GREEN);
		graphView.getGraphViewStyle().setHorizontalLabelsColor(Color.YELLOW);
		graphView.getGraphViewStyle().setVerticalLabelsColor(Color.RED);
		graphView.getGraphViewStyle().setNumHorizontalLabels(5);
		graphView.getGraphViewStyle().setNumVerticalLabels(4);
		graphView.getGraphViewStyle().setVerticalLabelsWidth(300);
       	
		
       	LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutWeight);  
       	layout.addView(graphView); 
       	
       	
       	//-------------------------------------------------------------------
       	
       	View mChart;
        
        String[] mMonth = new String[] {
            "Jan", "Feb" , "Mar", "Apr", "May", "Jun",
            "Jul", "Aug" , "Sep", "Oct", "Nov", "Dec"
        };
        
        int[] x = { 1,2,3,4,5,6,7,8 };
        int[] income = { 2000,2500,2700,3000,2800,3500,3700,3800};
        int[] expense = {2200, 2700, 2900, 2800, 2600, 3000, 3300, 3400 };
 
        // Creating an  XYSeries for Income
        XYSeries incomeSeries = new XYSeries("Income");
 
        for(int i=0;i<x.length;i++){
            incomeSeries.add(x[i], income[i]);
        }
 
        // Creating a dataset to hold each series
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        // Adding Income Series to the dataset
        dataset.addSeries(incomeSeries);
 
        // Creating XYSeriesRenderer to customize incomeSeries
        XYSeriesRenderer weightRenderer = new XYSeriesRenderer();
        weightRenderer.setColor(Color.RED);
        weightRenderer.setPointStyle(PointStyle.CIRCLE);
        weightRenderer.setFillPoints(true);
        weightRenderer.setLineWidth(4);
        weightRenderer.setDisplayChartValues(true);
 
        
 
        // Creating a XYMultipleSeriesRenderer to customize the whole chart
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("Weight Graph");
        multiRenderer.setXTitle("Year 2014");
        multiRenderer.setYTitle("Pound");
        multiRenderer.setZoomButtonsVisible(true);
        for(int i=0;i<x.length;i++){
            multiRenderer.addXTextLabel(i+1, mMonth[i]);
        }
 
        multiRenderer.setApplyBackgroundColor(true);
        multiRenderer.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        multiRenderer.setMarginsColor(getResources().getColor(android.R.color.transparent)); 
        // Adding incomeRenderer and expenseRenderer to multipleRenderer
        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer
        // should be same
        multiRenderer.addSeriesRenderer(weightRenderer);
 
        // Getting a reference to LinearLayout of the MainActivity Layout
        LinearLayout chartContainer = (LinearLayout) rootView.findViewById(R.id.linearLayoutWeight2);
 
        // Creating a Line Chart
        mChart = ChartFactory.getLineChartView(getActivity().getBaseContext(), dataset, multiRenderer);
 
        // Adding the Line Chart to the LinearLayout
        chartContainer.addView(mChart);
        
        
		return rootView;
	}
	
	
	
}
