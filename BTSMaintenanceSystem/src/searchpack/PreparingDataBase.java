package searchpack;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


	public class PreparingDataBase extends SQLiteOpenHelper {

		private Context contex;
		private static String AppPATH;
		private static String BaseName="base";
		
		public PreparingDataBase(Context context)
				 {
			super(context, BaseName+".db", null, 1);
			this.contex=context;
			AppPATH=contex.getApplicationInfo().dataDir;
			File temp = new File(AppPATH+"/databases");
			if(!temp.exists())
				temp.mkdir();
			checkDataBase();
			
		}
		private void checkDataBase()
		{
			
			File db= new File(AppPATH+"/databases/"+BaseName+".db");
			if(!db.exists())
			{
				
				try {
					copyBase(db);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					Log.w("database", "problem przy kopiowaniu");
					e.printStackTrace();
				}
				Log.i("database","skopiowano baze");
			}
			
			Log.i("database","baza istnieje"+db.exists());
			Log.i("database","wazy"+db.length());
			Log.i("database","sciezka"+db.getAbsolutePath());
			
		}
		 private void copyBase(File db) throws IOException
		 {
			 InputStream in = null ;
			 try{
				 in = contex.getAssets().open(BaseName+".db");
			 }
			 catch(IOException e)
			 {
				 Log.w("database","problem z otwarciem pliku z assets");
			 }
			 OutputStream out= new FileOutputStream(db);
			 
			 byte[] buffer = new byte[1024];
		        int length;
		        while ((length = in.read(buffer))>0) 
		        {
		            out.write(buffer,0,length);
		            Log.i("databases","skopiowalem  paczke"+length);
		        }

		        out.flush();
		        out.close();
		        in.close();
			 
			 
			 
		 }
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
		
	}