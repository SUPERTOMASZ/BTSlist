package Ftp;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SendThread <T> extends Thread
{
	private ArrayList<T> sendList;
	private Connect connect;
	private String path;
	
	public SendThread(ArrayList<T> list,String path)
	{
		connect= new Connect();
		this.sendList=list;
		
		this.path=path;
		
	}
	
	@Override
	public void run() 
	{
		
		System.out.println(connect.getFtpClient().isConnected());
		System.out.println(sendList.size());
		if(sendList.size()>0)
		{
			ObjectMapper mapper = new ObjectMapper();
			OutputStream out=connect.createStream(path);
		
					try {
							for(int i=0;i<sendList.size();i++)
								mapper.writeValue(out, sendList.get(i));
						} catch (Exception e)
						{
							e.printStackTrace();
						}
				
			
		try {
			out.close();
			connect.disconect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
	}

}
