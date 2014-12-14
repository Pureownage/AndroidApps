package com.example.contactapp;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
// This sets up a string with contact information
	String[] people = {"Jake 1111111", "Chris 2222222", "Alex 3333333",};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// This sets up list view
		ListView lstView = getListView();
		lstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lstView.setTextFilterEnabled(true);
		// This populates the list with the contact information
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, people));
	}
	
	public void onListItemClick(ListView parent, View v, int position, long id) {
		// This checks to see if something in the list has been selected
		CheckedTextView item = (CheckedTextView) v;
		// This will also pop up on the screen with the information
		Toast.makeText(this, people[position] + " selected", Toast.LENGTH_LONG).show();
	}
}

