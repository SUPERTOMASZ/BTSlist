package com.example.btsmaintenancesystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_activity);
		
	
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}
	public void  searchMenu(View view)
	{
		Intent intent = new Intent(this,SearchActivity.class);
	
		startActivity(intent);
		
		
	}
	public void  aboutMenu(View view)
	{
		Intent intent = new Intent(this,AboutActivity.class);
	
		startActivity(intent);
		
		
	}
	public void  dutyMenu(View view)
	{
		Intent intent = new Intent(this,DutyActivity.class);
	
		startActivity(intent);
		
		
	}

}
