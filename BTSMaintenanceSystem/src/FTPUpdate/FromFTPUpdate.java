package FTPUpdate;

import android.content.Context;
import android.os.AsyncTask;
import android.view.Gravity;
import android.widget.Toast;

public class FromFTPUpdate extends AsyncTask<Void , Void, Void>
{

	private Connect connect;
	private Context context;
	public FromFTPUpdate(Context context)
	{
		this.context=context;
	}
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		
		Toast toast = Toast.makeText(context,
				"rozpoczêto aktualizacjê ,", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.TOP, 0, 0);
		toast.show();
		this.connect=new Connect();
		
		
	}
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
