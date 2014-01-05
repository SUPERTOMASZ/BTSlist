package com.example.btsmaintenancesystem;

import station.Station;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;


public class BTSActivity extends Activity {

	private TextView textViews[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_station_activity);
		
		Bundle bundle=getIntent().getBundleExtra("Station");
		Station station=(Station) bundle.getSerializable("Station");
		
		
		
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
	private void fillTextViews()
	{
		SpannableStringBuilder [] tab=colorText(bts);
		viewholder.city.setText(tab[0]);
		viewholder.street.setText(tab[1]);
		viewholder.cordX.setText(tab[2]);
		viewholder.cordY.setText(tab[3]);
		viewholder.PTCname.setText(tab[4]);
		viewholder.PTKname.setText(tab[5]);
		viewholder.icon.setImageResource(((Station) bts).getImageId());
		
		return convertView;
		
		
	}
	private SpannableStringBuilder[] colorText(Station bts)
	{
		final ForegroundColorSpan fcs = new ForegroundColorSpan(Color.rgb(255, 163, 0));
		
		SpannableStringBuilder tab[] = new SpannableStringBuilder[6];
		SpannableStringBuilder("MIASTO    :    "+bts.getCity());
	
		
		for(int i=0;i<tab.length;i++)
			tab[i].setSpan(fcs, 0, 15,  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		
		return tab;
		
	}
}
