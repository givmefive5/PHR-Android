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
    int mProgressStatus = 70;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_summary_report, container, false);
		
		mProgress = (ProgressBar) rootView.findViewById(R.id.progressBar1);                   
	    Drawable draw = getResources().getDrawable(R.drawable.customprogressbar);
	    mProgress.setProgressDrawable(draw);
        mProgress.setProgress(mProgressStatus);
        mProgress.setMax(100);
		
       	
       	//-------------------------------------------------------------------
       	
       	View mChart;
        
        String[] mMonth = new String[] {
            "Jan", "Feb" , "Mar", "Apr", "May", "Jun",
            "Jul", "Aug" , "Sep", "Oct", "Nov", "Dec"
        };
        
        int[] x = { 1,2,3,4,5,6,7,8 };
        int[] pound = { 80,100,90,110,150,120,110,120};
 
        XYSeries poundSeries = new XYSeries("Weight Per Day");
 
        for(int i=0;i<x.length;i++){
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
        
        for(int i=0;i<x.length;i++){
            multiRenderer.addXTextLabel(i+1, mMonth[i]);
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

        LinearLayout chartContainer = (LinearLayout) rootView.findViewById(R.id.graph1);

        mChart = ChartFactory.getLineChartView(getActivity().getBaseContext(), dataset, multiRenderer);
 
        chartContainer.addView(mChart);
        
        
		return rootView;
	}
	
	
	
}
