package Ftp;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.BeanSerializer;

public class SendThread <T> extends Thread
{
	private ArrayList<T> sendList;
	private Connect connect;
	private String path;
	private ArrayList<T> new_list;
	public SendThread(ArrayList<T> list,String path)
	{
		
		this.new_list=new ArrayList<T>();
		System.out.println("wielkosc list "+list.size());
		this.sendList=list;
		for(int i=0;i<list.size();i++)
			new_list.add(list.get(i));
		this.path=path;
		sendList.removeAll(sendList);
	}
	
	@Override
	public  void run() 
	{
		if(new_list.size()>0)
		{
			connect= new Connect();
			System.out.println("wielkosc list po if "+new_list.size());
			ObjectMapper mapper = new ObjectMapper();
			OutputStream out=connect.createStream(path);
			System.out.println("wielkosc list po if "+new_list.size());
					try {
						//if(sendList.size()>0)
						mapper.writeValue(out, new_list);
						
					} catch (JsonGenerationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (JsonMappingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
