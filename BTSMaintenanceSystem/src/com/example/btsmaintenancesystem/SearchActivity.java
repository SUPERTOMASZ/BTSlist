package com.example.btsmaintenancesystem;

import java.util.ArrayList;

import database.DataBaseHelper;
import database.PreparingDataBase;


import searchpack.CustomListView;
import station.DataBaseTask;
import station.Station;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
	private ArrayList<Station> tempList;
	private EditText editText;
	private String spinnerChoose="nazwa stacji";
	private DataBaseHelper mydb;
	private Intent intent ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_activity);
		
		this.intent= new Intent(this,BTSMaintenanceActivity.class);
		this.db= new PreparingDataBase(getApplicationContext());
		this.mydb= new DataBaseHelper(getApplicationContext());
		
		
		((ImageView)findViewById(R.id.line)).setImageResource(R.drawable.line);
		this.choseSpinner= (Spinner) findViewById(R.id.spinner1);
		setSpinner();
		
		this.list=(ListView) findViewById(R.id.listView1);
		setCustomList();
	
		this.editText=(EditText) findViewById(R.id.editText1);
		setEditText();
		
		
		
		this.tempList=new ArrayList<Station>();
		
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
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	private void setCustomList()
	{
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
			
				Bundle bundle = new Bundle();
				bundle.putSerializable("Station",tempList.get(arg2) );
				intent.putExtra("Station", bundle);
				
				
				startActivity(intent);
	                
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
					Log.i("searchActivity","wcisnalem szukanie");
				
				
					InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					mgr.hideSoftInputFromWindow(editText.getWindowToken(), 0);
				
					new DataBaseTask(mydb,spinnerChoose,editText.getText().toString(),
							tempList,customListView,editText,getApplicationContext())
					.execute();
				
					return true;
				}
				else
					return false;
				
			}
		});
	}

	public CustomListView getCustomListView() {
		return customListView;
	}


	public void setCustomListView(CustomListView customListView) {
		this.customListView = customListView;
	}


	public PreparingDataBase getDb() {
		return db;
	}


	public void setDb(PreparingDataBase db) {
		this.db = db;
	}


	public Spinner getChoseSpinner() {
		return choseSpinner;
	}


	public void setChoseSpinner(Spinner choseSpinner) {
		this.choseSpinner = choseSpinner;
	}


	public ListView getList() {
		return list;
	}


	public void setList(ListView list) {
		this.list = list;
	}


	public ArrayList<Station> getTempList() {
		return tempList;
	}


	public void setTempList(ArrayList<Station> tempList) {
		this.tempList = tempList;
	}


	public EditText getEditText() {
		return editText;
	}


	public void setEditText(EditText editText) {
		this.editText = editText;
	}


	public String getSpinnerChoose() {
		return spinnerChoose;
	}


	public void setSpinnerChoose(String spinnerChoose) {
		this.spinnerChoose = spinnerChoose;
	}


	public DataBaseHelper getMydb() {
		return mydb;
	}


	public void setMydb(DataBaseHelper mydb) {
		this.mydb = mydb;
	}
	

}
