package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import com.example.phr.R;
import com.example.phr.adapter.StatusAdapter;
import com.example.phr.model.Status;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class StatusFeedActivity extends ListActivity {
	
	StatusAdapter statusAdapter;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.activity_status_feed);
		statusAdapter = new StatusAdapter(getApplicationContext(), generateData());
		setListAdapter(statusAdapter);
		
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

	private List<Status> generateData() {
		List<Status> list = new ArrayList<Status>();
		
		Status feeling = new Status();
		feeling.setActionHolder("Feeling");
		feeling.setActionName("happy");
		feeling.setDatettime("January 12, 2014 12:34AM");
		feeling.setStatus("I am positive!");
		feeling.setActionImgUrl(getResources().getDrawable(R.drawable.icon_emotion));
		feeling.setPostViaImgUrl(getResources().getDrawable(R.drawable.icon_small_facebook));
		list.add(feeling);
		
		Status eat = new Status();
		eat.setActionHolder("Eating");
		eat.setActionName("sinigang");
		eat.setDatettime("January 12, 2014 12:34AM");
		eat.setStatus("YUM YUM YUM :)))");
		eat.setActionImgUrl(getResources().getDrawable(R.drawable.icon_food));
		eat.setPostViaImgUrl(getResources().getDrawable(R.drawable.icon_small_facebook));
		list.add(eat);
		
		Status drink = new Status();
		drink.setActionHolder("Drinking");
		drink.setActionName("wine");
		drink.setDatettime("January 12, 2014 12:34AM");
		drink.setStatus("weeeeeeeeeeeeeee");
		drink.setActionImgUrl(getResources().getDrawable(R.drawable.icon_drink));
		drink.setPostViaImgUrl(getResources().getDrawable(R.drawable.icon_small_facebook));
		list.add(drink);
		
		Status doing = new Status();
		doing.setActionHolder("Doing");
		doing.setActionName("jogging");
		doing.setDatettime("January 12, 2014 12:34AM");
		doing.setStatus("day 1 of 365. wish me luck!");
		doing.setActionImgUrl(getResources().getDrawable(R.drawable.icon_activity));
		doing.setPostViaImgUrl(getResources().getDrawable(R.drawable.icon_small_facebook));
		list.add(doing);
		
		Status feeling2 = new Status();
		feeling2.setActionHolder("Feeling");
		feeling2.setActionName("lonely");
		feeling2.setDatettime("January 12, 2014 12:34AM");
		feeling2.setStatus("BYE WORLD");
		feeling2.setActionImgUrl(getResources().getDrawable(R.drawable.icon_emotion));
		feeling2.setPostViaImgUrl(getResources().getDrawable(R.drawable.icon_small_facebook));
		list.add(feeling2);
		
		Status eat2 = new Status();
		eat2.setActionHolder("Eating");
		eat2.setActionName("bulalo");
		eat2.setDatettime("January 12, 2014 12:34AM");
		eat2.setStatus("eat today die tom");
		eat2.setActionImgUrl(getResources().getDrawable(R.drawable.icon_food));
		eat2.setPostViaImgUrl(getResources().getDrawable(R.drawable.icon_small_facebook));
		list.add(eat2);
		
		Status drink2 = new Status();
		drink2.setActionHolder("Drinking");
		drink2.setActionName("coffee");
		drink2.setDatettime("January 12, 2014 12:34AM");
		drink2.setStatus("good morning!");
		drink2.setActionImgUrl(getResources().getDrawable(R.drawable.icon_drink));
		drink2.setPostViaImgUrl(getResources().getDrawable(R.drawable.icon_small_facebook));
		list.add(drink2);
		
		Status doing2 = new Status();
		doing2.setActionHolder("Doing");
		doing2.setActionName("swimming");
		doing2.setDatettime("January 12, 2014 12:34AM");
		doing2.setStatus("bblblblbllblblb... sabi ko sa ilalim ng pool.");
		doing2.setActionImgUrl(getResources().getDrawable(R.drawable.icon_activity));
		doing2.setPostViaImgUrl(getResources().getDrawable(R.drawable.icon_small_facebook));
		list.add(doing2);
		
		return list;
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		int itemPosition = position;
		String itemValue = (String)l.getItemAtPosition(position);
	}
	
}
