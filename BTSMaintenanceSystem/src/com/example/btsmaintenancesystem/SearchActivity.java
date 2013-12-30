package com.example.btsmaintenancesystem;

import java.util.ArrayList;
import java.util.Arrays;

import searchpack.BTS;
import searchpack.CustomListView;
import searchpack.DataBase;
import searchpack.PreparingDataBase;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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

	
	private CustomListView customListView;
	private PreparingDataBase db;
	private Spinner choseSpinner;
	private ListView list;
	private ArrayList<BTS> tempList;
	private EditText editText;
	private String spinnerChoose;
	
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_activity);
		
		this.db= new PreparingDataBase(getApplicationContext());
		
		((ImageView)findViewById(R.id.line)).setImageResource(R.drawable.line);
		this.choseSpinner= (Spinner) findViewById(R.id.spinner1);
		setSpinner();
		
		this.list=(ListView) findViewById(R.id.listView1);
	
		this.editText=(EditText) findViewById(R.id.editText1);
		setEditText();
		
		//sample of use
		
		this.tempList=new ArrayList<BTS>();
		
		this.customListView= new CustomListView(this,R.layout.intro_activity,
											tempList);
		this.list.setAdapter(customListView);
		
		
		
	
	
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
		choseSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int pos, long arg3) {
				
				spinnerChoose=arg0.getItemAtPosition(pos).toString();
				editText.setText(spinnerChoose);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	private void setEditText()
	{
		editText.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if(event.getAction()==KeyEvent.ACTION_DOWN)
				{
					editText.setText("dziala");
					PackageManager m = getPackageManager();
					String s = getPackageName();
					try {
					    PackageInfo p = m.getPackageInfo(s, 0);
					    s = p.applicationInfo.dataDir;
					} catch (NameNotFoundException e) {
					   
					}
					tempList.add(new BTS("Sokolowiec1","szybka","55%45","15%23","PTCName","PTKName"));
					tempList.add(new BTS("Sokolowiec2","szybka","55%45","15%23","PTCName","PTKName"));
					tempList.add(new BTS("Sokolowiec3","szybka","55%45","15%23","PTCName","PTKName"));
					tempList.add(new BTS("Sokolowiec3","szybka","55%45","15%23","PTCName","PTKName"));
					
					customListView.notifyDataSetChanged();
					list.refreshDrawableState();
					return true;
				}
				else
					return false;
				
			}
		});
	}
	
	

}
