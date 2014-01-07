package com.example.btsmaintenancesystem;

import sms.SmsXML;
import database.PreparingDataBase;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;


public class SMSEditActivity extends Activity {

	private Spinner templateChoose;
	private SmsXML xml;
	private EditText phonoNo;
	private EditText contatin;
	private int templateId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_activity);
		this.templateChoose=(Spinner) findViewById(R.id.templateChoose);
		setTemplateSpinner();
		this.xml= new SmsXML(getApplicationContext(),getAssets());
		phonoNo =(EditText) findViewById(R.id.contatin_edit_text);
		contatin=(EditText) findViewById(R.id.phonoNo_edit_text);
		templateId=0;
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
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	private void setCategorySpinner()
	{
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.SmsInputcategory, R.layout.template_spinner);
		adapter.setDropDownViewResource(R.layout.choosespinneritem_drop_down);
		this.templateChoose.setAdapter(adapter);
	}
	public void phoneNo_button(View view )
	{
		String templateString = "";
		Log.i("phonoNoBut",templateId+"");
		if(templateId==0)
			templateString=SmsXML.xml_entry;
		else if(templateId==1)
				templateString=SmsXML.xml_exit;
		else if(templateId==2)
			templateString=SmsXML.xml_alarm;
					
		xml.editPhonoNo(contatin.getText().toString(), templateString);
		
	}
	public void contatin_button(View view)
	{
		
		xml.editContatin("Luz w dupie", "enter");
		
	}
	

}
