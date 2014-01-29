package com.example.btsmaintenancesystem;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;

import FTPUpdate.Connect;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;


public class UpdateActivity extends Activity {

	private String login="michal@blajar.pl";
	private String pass="Test123";
	private String protocol="ftp://";
	private String host ="blajar.pl";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update_activity);
		

		
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		   
		
		return true;
	}
	public void updateButton(View view)
	{
		
		
		
		

		new Connect().execute();

		
		
		//button.setText(connect.connect()+"");
		
	}
	

}
