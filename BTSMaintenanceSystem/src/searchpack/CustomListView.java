package searchpack;

import java.util.List;

import station.Station;

import com.example.btsmaintenancesystem.R;
import com.example.btsmaintenancesystem.R.id;
import com.example.btsmaintenancesystem.R.layout;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListView extends ArrayAdapter<Station>
{
	private Context context;
	public CustomListView(Context context, int resource, List<Station> objects) {
		super(context, resource, objects);
		this.context=context;
	}
	private class ViewHolder
	{
		
		TextView city;
		TextView street;
		TextView cordX;
		TextView cordY;
		TextView PTCname;
		TextView PTKname;
		ImageView icon;
	}
	public View getView (int position ,View convertView,ViewGroup parent)
	{
		ViewHolder viewholder= null;
		Station bts = getItem(position);
		LayoutInflater mInflater = (LayoutInflater) 
				context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		
		if(convertView ==null)
		{
			convertView=mInflater.inflate(R.layout.item, null);
			viewholder = new ViewHolder();
			viewholder.city=(TextView) convertView.findViewById(R.id.cityText);
			viewholder.street=(TextView) convertView.findViewById(R.id.streetText);
			viewholder.cordX=(TextView) convertView.findViewById(R.id.cordXText);
			viewholder.cordY=(TextView) convertView.findViewById(R.id.cordYText);
			viewholder.PTCname=(TextView) convertView.findViewById(R.id.PTCnameText);
			viewholder.PTKname=(TextView) convertView.findViewById(R.id.PTKnameText);
			viewholder.icon=(ImageView)convertView.findViewById(R.id.icon);
			convertView.setTag(viewholder);
		}
		else
		{
			viewholder=(ViewHolder) convertView.getTag();
		}
		
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
		tab[0]=new SpannableStringBuilder("MIASTO    :    "+bts.getCity());
		tab[1]=new SpannableStringBuilder("ULICA      :     "+bts.getStreet());
		tab[2]=new SpannableStringBuilder("KOORDYNATY X :     "+bts.getCordX());
		tab[3]=new SpannableStringBuilder("KOORDYNATY Y :     "+bts.getCordY());
		tab[4]=new SpannableStringBuilder("NAZWA PTC    :     "+bts.getPTCName());
		tab[5]=new SpannableStringBuilder("NAZWA PTK    :     "+bts.getPTKName());
		
		for(int i=0;i<tab.length;i++)
			tab[i].setSpan(fcs, 0, 15,  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		
		return tab;
		
		
		
		
	}

}
