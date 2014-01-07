package sms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.util.Log;

public class PrepareXML
{
	private Context context;
	private String appPATH;
	public PrepareXML(Context context)
	{
		this.context=context;
		appPATH=context.getApplicationInfo().dataDir;
		File temp = new File(appPATH+"/xml");
		if(!temp.exists())
		{
			temp.mkdir();
			
		}
		checkDataBase();
	}

private void checkDataBase()
{
	
	File xml= new File(appPATH+"/xml/"+"sms.xml");
	if(!xml.exists())
	{
		
		try {
			copyBase(xml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.w("database", "problem przy kopiowaniu");
			e.printStackTrace();
		}
		Log.i("xml","skopiowano baze");
	}
	
	Log.i("database","baza istnieje"+xml.exists());
	Log.i("database","wazy"+xml.length());
	Log.i("database","sciezka"+xml.getAbsolutePath());
	
}
 private void copyBase(File db) throws IOException
 {
	 InputStream in = null ;
	 try{
		 in = context.getAssets().open("sms.xml");
	 }
	 catch(IOException e)
	 {
		 Log.w("database","problem z otwarciem pliku z assets");
	 }
	 OutputStream out= new FileOutputStream(db);
	 
	 byte[] buffer = new byte[24];
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

}
