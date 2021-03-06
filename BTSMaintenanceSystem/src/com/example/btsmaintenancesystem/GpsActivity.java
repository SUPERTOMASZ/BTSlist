package com.example.btsmaintenancesystem;

import java.util.ArrayList;

import searchpack.CustomListView;
import station.DataBaseFind;
import station.NearestDataBaseFind;
import station.DisplayStation;
import GPSHelper.GPSHelper;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import database.DataBaseHelper;



public class GpsActivity extends Activity {

	
	private CustomListView customListView;
	public CustomListView getCustomListView() {
		return customListView;
	}


	public void setCustomListView(CustomListView customListView) {
		this.customListView = customListView;
	}
	private ListView list;
	private ArrayList<DisplayStation> tempList;
	private DataBaseHelper mydb;
	private GPSHelper gpsHelper;
	private Double cordX;
	private Double cordY;
	private Intent intent ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps);

		this.mydb= new DataBaseHelper(this);
		
		this.gpsHelper=new GPSHelper(GpsActivity.this,this);
		
		this.list=(ListView) findViewById(R.id.gpsList);
	
		this.tempList=new ArrayList<DisplayStation>();
		
		this.customListView= new CustomListView(this,R.layout.activity_gps,
											tempList);
		this.list.setAdapter(customListView);
		this.intent= new Intent(this,BTSMaintenanceActivity.class);
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

		
	   Log.i("GpsActivity", this.gpsHelper.canGetLocation()+"");
	   if(this.gpsHelper.canGetLocation()==false)
		  this.gpsHelper.showSettingsAlert();
	   else
	   {
		    makeList();
	   }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void makeList()
	{
		 new NearestDataBaseFind(mydb, gpsHelper.getLatitude(),
				 gpsHelper.getLongitude(), tempList,
				 customListView, getApplicationContext())
		    .execute();
	}





	

}
