package duty;

import java.util.List;

import station.DisplayStation;

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

public class DutyCustomListView extends ArrayAdapter<Duty>
{
	private Context context;
	public DutyCustomListView(Context context, int resource, List<Duty> objects) {
		super(context, resource, objects);
		this.context=context;
	}
	private class ViewHolder
	{
		
		TextView name;
		TextView date;
	}
	public View getView (int position ,View convertView,ViewGroup parent)
	{
		ViewHolder viewholder= null;
		Duty duty = getItem(position);
		LayoutInflater mInflater = (LayoutInflater) 
				context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		
		if(convertView ==null)
		{
			convertView=mInflater.inflate(R.layout.duty_item, null);
			viewholder = new ViewHolder();
			viewholder.date=(TextView) convertView.findViewById(R.id.dataView);
			viewholder.name=(TextView) convertView.findViewById(R.id.emplnameView);
			convertView.setTag(viewholder);
		}
		else
		{
			viewholder=(ViewHolder) convertView.getTag();
		}
		
		
		viewholder.date.setText(duty.getData());
		viewholder.name.setText(duty.getWorker().getName()+" "+duty.getWorker().getSurname());
		
		
		return convertView;
		
		
	}
	private SpannableStringBuilder[] colorText(DisplayStation bts)
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
