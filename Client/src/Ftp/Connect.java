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
	private String login="developer@btsmaintenancesystem.cba.pl";
	private String pass="atem44";
	private String protocol="ftp://";
	private String host ="btsmaintenancesystem.cba.pl";
	private FTPClient ftpClient;
	public Connect()
	{
		this.ftpClient = new FTPClient();
		try {
			ftpClient.connect("btsmaintenancesystem.cba.pl");
			ftpClient.login(login, pass);
			ftpClient.cwd("ATEM");
			ftpClient.deleteFile("new");
			ftpClient.deleteFile("test");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendFileToDirectory(new File("user.json"), "Workers", "new.json");

	}
	public boolean sendFileToDirectory(File file,String path,String newFileName)
	{
			byte[] temp=new byte[1024];
			int length;
		try {
			ftpClient.cwd(path);
			OutputStream streamOut=ftpClient.appendFileStream(newFileName);
			InputStream in = new FileInputStream(file);
			while((length=in.read(temp))>0 )
			{
				System.out.println(length);
				streamOut.write(temp, 0, length);
				streamOut.flush();
			}
			streamOut.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	

}
