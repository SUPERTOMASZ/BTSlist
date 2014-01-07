package com.example.btsmaintenancesystem;

import sms.SmsSend;
import sms.SmsXML;
import station.Station;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class BTSMaintenanceActivity extends Activity {

	private TextView textViews[];
	private SmsSend sms;
	private Station station;
	private SmsXML smsXML;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_station_activity);
		
		Bundle bundle=getIntent().getBundleExtra("Station");
		Station station=(Station) bundle.getSerializable("Station");
		makeTextViews();
		setAndColorText(station);
		this.station=station;
		this.smsXML=new SmsXML(getApplicationContext(),getAssets());
		this.sms=new SmsSend(smsXML);
	
		
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private void makeTextViews()
	{
		this.textViews=new TextView[18];
		textViews[0]=(TextView) findViewById(R.id.city_det);
		textViews[1]=(TextView) findViewById(R.id.street_det);
		textViews[2]=(TextView) findViewById(R.id.cordX_det);
		textViews[3]=(TextView) findViewById(R.id.cordY_det);
		textViews[4]=(TextView) findViewById(R.id.PTCname_det);
		textViews[5]=(TextView) findViewById(R.id.PTKname_det);
		
		textViews[6]=(TextView) findViewById(R.id.statNum_det);
		textViews[7]=(TextView) findViewById(R.id.netWorksNum_det);
		textViews[8]=(TextView) findViewById(R.id.PTCNum_det);
		textViews[9]=(TextView) findViewById(R.id.PTKNum_det);
		textViews[10]=(TextView) findViewById(R.id.staName_det);
		textViews[11]=(TextView) findViewById(R.id.owner_det);
		textViews[12]=(TextView) findViewById(R.id.comm_det);
		textViews[13]=(TextView) findViewById(R.id.region_det);
		textViews[14]=(TextView) findViewById(R.id.deletedData_det);
		textViews[15]=(TextView) findViewById(R.id.zip_codData);
		textViews[16]=(TextView) findViewById(R.id.acc_desc_det);
		textViews[17]=(TextView) findViewById(R.id.stat_desc_det);
		
	}
	private void setAndColorText(Station station)
	{
		ImageView imgView = (ImageView) findViewById(R.id.display_ico);
		imgView.setImageResource(((Station) station).getImageId());
		
		final ForegroundColorSpan fcs = new ForegroundColorSpan(Color.rgb(255, 163, 0));
		
		SpannableStringBuilder tab[] = new SpannableStringBuilder[18];
		tab[0]=new SpannableStringBuilder(textViews[0].getText()+" "+station.getCity());
		tab[1]=new SpannableStringBuilder(textViews[1].getText()+" "+station.getStreet());
		tab[2]=new SpannableStringBuilder(textViews[2].getText()+" "+(station.getCordX()+""));
		tab[3]=new SpannableStringBuilder(textViews[3].getText()+" "+(station.getCordY()+""));
		tab[4]=new SpannableStringBuilder(textViews[4].getText()+" "+station.getPTCName());
		tab[5]=new SpannableStringBuilder(textViews[5].getText()+" "+station.getPTKName());
		
		
		tab[6]=new SpannableStringBuilder(textViews[6].getText()+"  "+station.getStationNum());
		tab[7]=new SpannableStringBuilder(textViews[7].getText()+"  "+station.getNetWorksNum());
		tab[8]=new SpannableStringBuilder(textViews[8].getText()+"  "+station.getPTCNum());
		tab[9]=new SpannableStringBuilder(textViews[9].getText()+"  "+station.getPTKNum());
		tab[10]=new SpannableStringBuilder(textViews[10].getText()+"  "+station.getStationName());
		tab[11]=new SpannableStringBuilder(textViews[11].getText()+"  "+station.getOwner());
		tab[12]=new SpannableStringBuilder(textViews[12].getText()+"  "+station.getCommunity());
		tab[13]=new SpannableStringBuilder(textViews[13].getText()+"  "+station.getRegion());
		tab[14]=new SpannableStringBuilder(textViews[14].getText()+"  "+station.getDeletedData());
		tab[15]=new SpannableStringBuilder(textViews[15].getText()+"  "+station.getZip_Code());
		tab[16]=new SpannableStringBuilder(textViews[16].getText()+"  "+station.getAccessDescribe());
		tab[17]=new SpannableStringBuilder(textViews[17].getText()+"  "+station.getStationDescribe());
		
		for(int i=0;i<tab.length;i++)
		{
			tab[i].setSpan(fcs, 0, textViews[i].getText().length(), 
					Spannable.SPAN_INCLUSIVE_INCLUSIVE);
			textViews[i].setText(tab[i]);
		}
	}
	private void navi(Double cordX, Double cordY)
	{
		
		String uri = "geo:0,0?q="+cordX+", "+cordY;
				
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
		intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
		startActivity(intent);
		
	}
	public void  stationEnter(View view)
	{
		
		if(sms.sendEntrySms(station))
			Toast.makeText(getApplicationContext(), "SMS Sent!",
				Toast.LENGTH_LONG).show();
		else
			Toast.makeText(getApplicationContext(),"SMS faild, please try again later!",
				Toast.LENGTH_LONG).show();
	

	}
	public void  stationExit(View view)
	{
		if(sms.sendExitSms(station))
			Toast.makeText(getApplicationContext(), "SMS Sent!",
				Toast.LENGTH_LONG).show();
		else
			Toast.makeText(getApplicationContext(),"SMS faild, please try again later!",
				Toast.LENGTH_LONG).show();
	}
	public void  navigateToStation(View view)
	{
		navi(station.getCordX(),station.getCordY());
		
		

	}
	public void  callToStation(View view)
	{
		

	}
	public void  checkAlarms(View view)
	{
		if(sms.sendAlarmSms(station))
			Toast.makeText(getApplicationContext(), "SMS Sent!",
				Toast.LENGTH_LONG).show();
		else
			Toast.makeText(getApplicationContext(),"SMS faild, please try again later!",
				Toast.LENGTH_LONG).show();

	}
	
}
