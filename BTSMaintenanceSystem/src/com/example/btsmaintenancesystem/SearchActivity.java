package com.example.btsmaintenancesystem;

import java.util.ArrayList;
import java.util.Arrays;

import searchpack.BTS;
import searchpack.CustomListView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;


public class SearchActivity extends Activity  {

	
	
	
	private Spinner choseSpinner;
	private ListView list;
	private ArrayList<BTS> tempList;
	private EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_activity);
		
		((ImageView)findViewById(R.id.line)).setImageResource(R.drawable.line);
		this.choseSpinner= (Spinner) findViewById(R.id.spinner1);
		setSpinner();
		
		this.list=(ListView) findViewById(R.id.listView1);
	
		this.editText=(EditText) findViewById(R.id.editText1);
		setEditText();
		//sample of use
		this.tempList=new ArrayList<BTS>();
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
		
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.category, R.layout.choosespinneritem);
		adapter.setDropDownViewResource(R.layout.choosespinneritem_drop_down);
		choseSpinner.setAdapter(adapter);
		
	}
	private void setEditText()
	{
		editText.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if(event.getAction()==KeyEvent.ACTION_DOWN)
				{
					editText.setText("dziala");
					//Tutaj Tomis³aw trzeba zrobic obsluge bazy danych
					return true;
				}
				else
					return false;
				
			}
		});
	}
	
	

}
