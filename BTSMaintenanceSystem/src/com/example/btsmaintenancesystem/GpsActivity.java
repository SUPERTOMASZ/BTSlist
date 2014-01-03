package com.example.btsmaintenancesystem;

import java.util.ArrayList;

import database.DataBaseHelper;
import database.PreparingDataBase;

import station.DataBaseFind;
import station.DataBaseTask;
import station.Station;

import searchpack.CustomListView;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;



public class GpsActivity extends Activity  {

	
	private CustomListView customListView;
	private PreparingDataBase db;
	private ListView list;
	private ArrayList<Station> tempList;
	private DataBaseHelper mydb;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps);
		
		this.db= new PreparingDataBase(getApplicationContext());
		this.mydb= new DataBaseHelper(getApplicationContext());
		
		
		((ImageView)findViewById(R.id.line)).setImageResource(R.drawable.line);
		
		this.list=(ListView) findViewById(R.id.listView1);
	
		this.tempList=new ArrayList<Station>();
		
		this.customListView= new CustomListView(this,R.layout.intro_activity,
											tempList);
		this.list.setAdapter(customListView);
		
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		Double cordX = 0.0; 
		Double cordY = 0.0;
		for (String providerStr : locationManager.getAllProviders()) 
		{
	        Location location = locationManager.getLastKnownLocation(providerStr);
	        if (location != null) 
	        {
	            cordX=location.getLatitude();	
	            cordY=location.getLongitude();
	            break;
	        }
	    } 
	    
	    if ((cordX==0.0)&&(cordY==0.0))
	    {
	    	//pobraæ ostatni¹ znan¹ lokalizacje z XML
	    }
	    
	       
	    new DataBaseFind(mydb, cordX, cordY, tempList, customListView, getApplicationContext())
		.execute();
	    
	
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
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



	public DataBaseHelper getMydb() {
		return mydb;
	}


	public void setMydb(DataBaseHelper mydb) {
		this.mydb = mydb;
	}
	

}
