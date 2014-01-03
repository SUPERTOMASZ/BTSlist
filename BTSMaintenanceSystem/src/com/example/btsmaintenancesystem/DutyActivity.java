package com.example.btsmaintenancesystem;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import database.DataBaseHelper;
import duty.Duty;
import duty.DutyCustomListView;


public class DutyActivity extends Activity {

	private ArrayList<Duty> duties;
	private ListView dutiesList;
	private DutyCustomListView dutiesListAdapter;
	private DataBaseHelper db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.duty_activity);
		
		this.db=new DataBaseHelper(getApplicationContext());
		this.duties=db.getDuties();
		this.dutiesList= (ListView) findViewById(R.id.dutyList);
		this.dutiesListAdapter= new DutyCustomListView(this,R.layout.intro_activity,
											duties);
		 View header = getLayoutInflater().inflate(R.layout.duty_list_header, dutiesList, false);
		 this.dutiesList.addHeaderView(header);
		 
		this.dutiesList.setAdapter(dutiesListAdapter);
		
	
		
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		   
		
		return true;
	}
	

}
