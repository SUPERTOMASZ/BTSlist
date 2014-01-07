package com.example.btsmaintenancesystem;

import database.PreparingDataBase;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class SMSEditActivity extends Activity {

	private Spinner templateChoose;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_activity);
		this.templateChoose=(Spinner) findViewById(R.id.templateChoose);
		setTemplateSpinner();
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		   
		
		return true;
	}
	private void setTemplateSpinner()
	{
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.Smscategory, R.layout.template_spinner);
		adapter.setDropDownViewResource(R.layout.choosespinneritem_drop_down);
		this.templateChoose.setAdapter(adapter);
	}
	

}
