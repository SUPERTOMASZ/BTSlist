package com.example.btsmaintenancesystem;

import sms.PrepareXML;
import database.PreparingDataBase;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro_activity);
		new PreparingDataBase(getApplicationContext());
		new PrepareXML(getApplicationContext());
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		   
		
		return true;
	}
	public void  startMenu(View view)
	{
		Intent intent = new Intent(this,MenuActivity.class);
	
		startActivity(intent);
		finish();
		
	}

}
