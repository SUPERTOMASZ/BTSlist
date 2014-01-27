package Ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Connect 
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
		connect();
	}
	public boolean connect()
	{
		this.ftpClient = new FTPClient();
		try {
			
			ftpClient.connect(host);
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
	public OutputStream createStream(String path)
	{
		int cout=coutFiles(path);
		OutputStream out = null;
		try {
			System.out.println( (cout+1));
			out=this.ftpClient.appendFileStream( (cout+1)+".json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	public InputStream createInputStream(String name,int ver)
	{
		InputStream input = null;
		try {
			input=ftpClient.retrieveFileStream("1.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return input;
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
	
	

}
