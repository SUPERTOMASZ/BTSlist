package com.example.btsmaintenancesystem;

import sms.SmsXML;
import station.DataBaseTask;
import database.PreparingDataBase;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;
import android.widget.Toast;


public class SMSEditActivity extends Activity {

	private Spinner templateChoose;
	private Spinner hashTags;
	private SmsXML xml;
	private EditText phonoNo;
	private EditText contatin;
	private int templateId;
	private int hashId;
	private String tempContain;
	private String templateString;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_activity);
		this.templateChoose=(Spinner) findViewById(R.id.templateChoose);
		setTemplateSpinner();
		this.xml= new SmsXML(getApplicationContext(),getAssets());
		this.phonoNo =(EditText) findViewById(R.id.phonoNo_edit_text);
		this.contatin=(EditText) findViewById(R.id.contatin_edit_text);
		this.templateId=0;
		this.tempContain="";
		this.hashTags=(Spinner) findViewById(R.id.contatin_spinner);
		setCategorySpinner();
		setEditText();

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
		this.templateChoose.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int pos, long arg3) {
				
				templateId=pos;
			
				Log.i("phonoNoBut",templateId+"");
				if(templateId==0)
					templateString=SmsXML.xml_entry;
				else if(templateId==1)
						templateString=SmsXML.xml_exit;
				else if(templateId==2)
					templateString=SmsXML.xml_alarm;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	private void setEditText()
	{
		
		contatin.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if(event.getAction()==KeyEvent.ACTION_DOWN)
				{
					Log.i("searchActivity","wcisnalem szukanie");
				
				
					InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					mgr.hideSoftInputFromWindow(contatin.getWindowToken(), 0);
					tempContain+=contatin.getText().toString();
					contatin.setText("");
				
					return true;
				}
				else
					return false;
				
			}
		});
		
	}
	private void setCategorySpinner()
	{
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.SmsInputcategory, R.layout.choosespinneritem);
		adapter.setDropDownViewResource(R.layout.choosespinneritem_drop_down);
		this.hashTags.setAdapter(adapter);
		
	
		this.hashTags.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int pos, long arg3) {
				
				if(pos==1)
					tempContain+="#nrStacji#";
				else if(pos ==2)
					tempContain+="#nrNET#";
				else if(pos ==3)
					tempContain+="#nrPTC#";
				else if(pos ==4)
					tempContain+="#nrPTK#";

				((TextView)arg1).setText(null);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			
				
			}
		});
	}
	public void phoneNo_button(View view )
	{
		
					
		xml.editPhonoNo(phonoNo.getText().toString(), templateString);
		Toast toast = Toast.makeText(getApplicationContext(),
				"zmieniono docelowy numer", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.TOP, 0, 0);
		toast.show();
		
	}
	public void contatin_button(View view)
	{
		
		xml.editContatin(tempContain, templateString);
		tempContain="";
		Toast toast = Toast.makeText(getApplicationContext(),
				"zmieniono tresc", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.TOP, 0, 0);
		toast.show();
		
		
	}
	public void prevBut(View view)
	{
		Intent intent = new Intent(this, PrevActivity.class);
	    intent.putExtra("contatin", tempContain);
	    startActivity(intent);
		
		
	}

}
