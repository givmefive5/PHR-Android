package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import com.example.phr.R;
import com.example.phr.adapter.ActionAdapter;
import com.example.phr.model.StatusAction;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class AddActionActivity extends ListActivity {
	
	ActionAdapter actionAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("What are you doing?");
		setContentView(R.layout.activity_add_actions);
		
		actionAdapter = new ActionAdapter(getApplicationContext(), generateData());
		setListAdapter(actionAdapter);
	}

	private List<StatusAction> generateData() {
		List<StatusAction> list = new ArrayList<StatusAction>();
		
		StatusAction feeling = new StatusAction();
		feeling.setActionName("Feeling");
		feeling.setImgUrl(getResources().getDrawable(R.drawable.icon_emotion));
		list.add(feeling);
		
		StatusAction eat = new StatusAction();
		eat.setActionName("Eating");
		eat.setImgUrl(getResources().getDrawable(R.drawable.icon_food));
		list.add(eat);
		
		StatusAction drink = new StatusAction();
		drink.setActionName("Drinking");
		drink.setImgUrl(getResources().getDrawable(R.drawable.icon_drink));
		list.add(drink);
		
		StatusAction doing = new StatusAction();
		doing.setActionName("Doing an Activity");
		doing.setImgUrl(getResources().getDrawable(R.drawable.icon_activity));
		list.add(doing);
		
		return list;
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		int itemPosition = position;
		String itemValue = (String)l.getItemAtPosition(position);
	}
	
}
