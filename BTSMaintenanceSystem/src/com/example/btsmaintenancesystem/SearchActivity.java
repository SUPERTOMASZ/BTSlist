package com.example.btsmaintenancesystem;

import java.util.ArrayList;
import java.util.Arrays;

import searchpack.BTS;
import searchpack.CustomListView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


public class SearchActivity extends Activity {

	
	
	
	private Spinner choseSpinner;
	private ListView list;
	private ArrayList<BTS> tempList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_activity);
		((ImageView)findViewById(R.id.line)).setImageResource(R.drawable.line);
		this.choseSpinner= (Spinner) findViewById(R.id.spinner1);
		setSpinner();
		
		this.list=(ListView) findViewById(R.id.listView1);
		this.tempList=new ArrayList<BTS>();
		//sample of use
		this.tempList.add(new BTS("Sokolowiec1","szybka","55%45","15%23","PTCName","PTKName"));
		this.tempList.add(new BTS("Sokolowiec2","szybka","55%45","15%23","PTCName","PTKName"));
		this.tempList.add(new BTS("Sokolowiec3","szybka","55%45","15%23","PTCName","PTKName"));
		this.tempList.add(new BTS("Sokolowiec3","szybka","55%45","15%23","PTCName","PTKName"));
		this.tempList.add(new BTS("Sokolowiec3","szybka","55%45","15%23","PTCName","PTKName"));
		this.tempList.add(new BTS("Sokolowiec3","szybka","55%45","15%23","PTCName","PTKName"));
		this.tempList.add(new BTS("Sokolowiec3","szybka","55%45","15%23","PTCName","PTKName"));
		CustomListView customListView= new CustomListView(this,R.layout.intro_activity,
											tempList);
		list.setAdapter(customListView);
		
	
	
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		   
		
		return true;
	}
	private void setSpinner()
	{
		
		
		this.choseSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {  
		  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
		// hide selection text  
		((TextView)view).setText(null);  
		// if you want you can change background here  
		}  
		  public void onNothingSelected(AdapterView<?> arg0) {}  
		 });
		
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.category, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
		// Apply the adapter to the spinner
		this.choseSpinner.setAdapter(adapter);
	}
	

}
