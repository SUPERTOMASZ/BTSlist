package database;

import java.util.ArrayList;

import searchpack.CustomListView;
import android.content.Context;
import android.os.AsyncTask;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

public class DataBaseTask extends AsyncTask<Void , Void, Void>
{
	private String choose;
	private String keyword;
	private ArrayList<Station> list;
	private CustomListView customListView;
	private DataBaseHelper db;
	private ArrayList<Station> temp;
	private EditText edit;
	private Context context;
	public DataBaseTask(DataBaseHelper db,String choose,String keyword,ArrayList<Station> list,
			CustomListView customListView,EditText edit,Context contex)
	{
		
		this.choose=choose;
		this.keyword=keyword;
		this.list=list;
		this.customListView=customListView;
		this.db=db;
		this.edit=edit;
		this.context=contex;
	}

	@Override
	protected Void doInBackground(Void... params) {

		temp=db.getBTS(keyword,choose);
		return null;
	}
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	
		edit.setEnabled(false);
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
		edit.setEnabled(true);
		Toast toast = Toast.makeText(context,
				"zakoñczono wyszukiwanie", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.TOP, 0, 0);
		toast.show();
	}
	

	

}
