package searchpack;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataBase  
{
	private MyDataBaseHelper baseHelp;
	private SQLiteDatabase db;
	private Context contex;
	public DataBase(Context contex)
	{
		this.contex=contex;
		this.baseHelp= new MyDataBaseHelper(contex, "base.db", null, 1);
		db=baseHelp.getReadableDatabase();
		Log.i("DataBase",db.getPath());
		
		
	}
	

}
