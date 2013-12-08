package com.example.btsmaintenancesystem;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


public class SearchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_activity);
		
		Spinner spinner= (Spinner) findViewById(R.id.spinner1);
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {  
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
		spinner.setAdapter(adapter);
		ListView view = (ListView) findViewById(R.id.listView1);
		
		
		ListView list ; 
	    ArrayAdapter<String> adapter1 ; 


	
		list = (ListView) findViewById(R.id.listView1);
		 
        String cars[] = {"Mercedes", "Fiat", "Ferrari", "Aston Martin", "Lamborghini", "Skoda", "Volkswagen", "Audi", "Citroen"};
 
        ArrayList<String> carL = new ArrayList<String>(); 
        carL.addAll( Arrays.asList(cars) ); 
 
        adapter1 = new ArrayAdapter<String>(this,R.layout.row, carL);
 
        list.setAdapter(adapter1);		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		   
		
		return true;
	}
	

}
