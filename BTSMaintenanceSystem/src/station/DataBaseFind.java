package station;

import java.util.ArrayList;

import database.DataBaseHelper;

import searchpack.CustomListView;
import android.content.Context;
import android.os.AsyncTask;
import android.view.Gravity;
import android.widget.Toast;

public class DataBaseFind extends AsyncTask<Void , Void, Void>
{

	private Double cordX;
	private Double cordY;
	private ArrayList<DisplayStation> list;
	private CustomListView customListView;
	private DataBaseHelper db;
	private ArrayList<DisplayStation> temp;
	private Context context;
	
	public DataBaseFind(DataBaseHelper db, Double cordX, Double cordY, ArrayList<DisplayStation> list,
			CustomListView customListView, Context contex)
	{
		this.cordY=cordY;
		this.cordX=cordX;
		this.list=list;
		this.customListView=customListView;
		this.db=db;
		this.context=contex;
	}

	@Override
	protected Void doInBackground(Void... params) {

		temp=db.findNearest(cordX, cordY);
		return null;
	}
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();

		Toast toast = Toast.makeText(context,
				"rozpoczêto wyszukiwanie, prosze czekaæ", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.TOP, 0, 0);
		toast.show();
	}
	@Override
	protected void onPostExecute(Void result)
{
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		for(int i=0;i<list.size();i++)
				list.remove(i);
		customListView.clear();
		for(int i=0;i<temp.size();i++)
				list.add(temp.get(i));
				
		customListView.notifyDataSetChanged();
		
		Toast toast = Toast.makeText(context,
				"zakoñczono wyszukiwanie", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.TOP, 0, 0);
		toast.show();
	}
	

	

}
