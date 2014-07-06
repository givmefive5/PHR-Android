package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import com.example.phr.adapter.NoteAdapter;
import com.example.phr.model.Note;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class NoteTrackerActivity extends Activity{
	

	ListView mNoteList;
	NoteAdapter noteAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note_tracker);
		
		mNoteList = (ListView) findViewById(R.id.listView_notes);
				
		// FAKE DATA
		List<Note> list = new ArrayList<Note>();
		Note data1 = new Note("What a busy day!", "","Jun 18, 2014","11:40 am");
		
		Note data2 = new Note("I love it!", "","Jun 16, 2014","10:40 am");

		Note data3 = new Note("Oh nooooo!", "","Jun 20, 2014","11:40 pm");
		
		Note data4 = new Note("haaaaah!", "","Jul 05, 2014","5:40 am");
		
		list.add(data4);
		list.add(data3);
		list.add(data2);
		list.add(data1);
		
		
		

		noteAdapter = new NoteAdapter(getApplicationContext(), list);
		mNoteList.setAdapter(noteAdapter);
		mNoteList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.e("note", "CLICKED!");
			}
		});
		
	}

}
