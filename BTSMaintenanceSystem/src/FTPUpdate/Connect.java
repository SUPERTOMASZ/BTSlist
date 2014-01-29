package FTPUpdate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import android.os.AsyncTask;
import android.view.Gravity;
import android.widget.Toast;



public class Connect extends AsyncTask<Void , Void, Void>
{
	private String login="michal@blajar.pl";
	private String pass="Test123";
	private String protocol="ftp://";
	private String host ="blajar.pl";
	public static final  String workerPath="Workers";
	public static final  String dutyPath="Duties";
	public static final  String station="Stations";
	public static final  String addPath="/Add";
	public static final  String upPath="/Update";
	public static final String delPath="/Delete";
	

	private FTPClient ftpClient;
	public Connect()
	{
		
	}
	public boolean connect()
	{
		this.ftpClient = new FTPClient();
		try {
			
			ftpClient.connect(InetAddress.getByName(host));
			ftpClient.login(login, pass);
			
			ftpClient.cwd("ATEM");
			return true;
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public int  coutFiles(String path)
	{
		int result=-1;
		try {
			ftpClient.cwd(path);
			System.out.println(ftpClient.printWorkingDirectory());
			FTPFile[] temp =ftpClient.listFiles();
		
			for(int i=0;i<temp.length;i++)
				System.out.println(temp[i].getName());
			result=temp.length;
			result=result-2;//bo liczone sa .. i .
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	public OutputStream createStream(int ver)
	{
		
		OutputStream out = null;
		try {
			System.out.println( (ver+1));
			out=this.ftpClient.appendFileStream( (ver+1)+".json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	public InputStream createInputStream(int ver)
	{
		InputStream input = null;
		try {
			input=ftpClient.retrieveFileStream(ver+".json");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return input;
	}
	public void finishInputStream(InputStream in)
	{
		
		try {
			in.close();
			ftpClient.completePendingCommand();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void disconect()
	{
		try {
			ftpClient.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public FTPClient getFtpClient() {
		return ftpClient;
	}
	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();

		
	}
	@Override
	protected Void doInBackground(Void... arg0) {
		connect();
		return null;
	}
	
	

}
