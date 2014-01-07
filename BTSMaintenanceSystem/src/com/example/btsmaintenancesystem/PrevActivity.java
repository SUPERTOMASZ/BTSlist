package com.example.btsmaintenancesystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;


public class PrevActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prev_act);
		Intent intent=getIntent();
		String message = intent.getStringExtra("contatin");
		TextView textView=(TextView) findViewById(R.id.prev_text_view);
		textView.setText(message);
	
		
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		   
		
		return true;
	}
	

}
