package com.example.btsmaintenancesystem;

import java.util.ArrayList;

import searchpack.CustomListView;
import station.DataBaseFind;
import station.NearestDataBaseFind;
import station.Station;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import database.DataBaseHelper;



public class GpsActivity extends Activity  {

	
	private CustomListView customListView;
	private ListView list;
	private ArrayList<Station> tempList;
	private DataBaseHelper mydb;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps);

		this.mydb= new DataBaseHelper(getApplicationContext());
		
		
		this.list=(ListView) findViewById(R.id.gpsList);
	
		this.tempList=new ArrayList<Station>();
		
		this.customListView= new CustomListView(this,R.layout.activity_gps,
											tempList);
		this.list.setAdapter(customListView);
		
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		double cordX = 0.0; 
		double cordY = 0.0;
		for (String providerStr : locationManager.getAllProviders()) 
		{
	        Location location = locationManager.getLastKnownLocation(providerStr);
	        if (location != null) 
	        {
	            cordY=location.getLatitude();	
	            Log.i("gps","wspX "+cordX);
	            cordX=location.getLongitude();
	            Log.i("gps","wspY "+cordY);
	            break;
	        }
	    } 

	    
	    if ((cordX==0.0)&&(cordY==0.0))
	    {
	    	//pobraæ ostatni¹ znan¹ lokalizacje z XML
	    }
	    


	   new NearestDataBaseFind(mydb, cordX, cordY, tempList, customListView, getApplicationContext())
	    .execute();
	    
	
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}




	

}
