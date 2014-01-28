package Ftp;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.BeanSerializer;

import DataBase.DataBaseQuery;

public class SendThread <T> extends Thread
{
	private ArrayList<T> sendList;
	private Connect connect;
	private String path;
	private ArrayList<T> new_list;
	private String table;
	private String category;
	public SendThread(ArrayList<T> list,String table,String category)
	{
		
		this.new_list=new ArrayList<T>();
		System.out.println("wielkosc list "+list.size());
		this.sendList=list;
		for(int i=0;i<list.size();i++)
			new_list.add(list.get(i));
		
		this.path=table+category;
		sendList.removeAll(sendList);
		this.table=table;
		this.category=category;
	}
	
	@Override
	public  void run() 
	{
		if(new_list.size()>0)
		{
			connect= new Connect();
			System.out.println("wielkosc list po if "+new_list.size());
			ObjectMapper mapper = new ObjectMapper();
			int counter=connect.coutFiles(path);
			OutputStream out=connect.createStream(counter);
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
		updateDataBase(table, category, counter);
	
		}
		
	}
	private void updateDataBase(String table,String category,int ver)
	{
		
		if(table.equals(Connect.workerPath))
		{
			if(category.equals(Connect.addPath))
			{
				new DataBaseQuery().updateVersion(
						DataBaseQuery.KEY_VERSION_WORKER_NAME,
						DataBaseQuery.KEY_VERSION_ADD_NAME,
						ver)	;
			}
			else if(category.equals(Connect.upPath))
			{
				new DataBaseQuery().updateVersion(
						DataBaseQuery.KEY_VERSION_WORKER_NAME,
						DataBaseQuery.KEY_VERSION_ED_NAME,
						ver)	;
			}
			else if(category.equals(Connect.delPath))
			{
				new DataBaseQuery().updateVersion(
						DataBaseQuery.KEY_VERSION_WORKER_NAME,
						DataBaseQuery.KEY_VERSION_DEL_NAME,
						ver)	;
			}
			
		}
		else if(table.equals(Connect.dutyPath))
		{
			if(category.equals(Connect.addPath))
			{
				new DataBaseQuery().updateVersion(
						DataBaseQuery.KEY_VERSION_DUTY_NAME,
						DataBaseQuery.KEY_VERSION_ADD_NAME,
						ver)	;
			}
			else if(category.equals(Connect.upPath))
			{
				new DataBaseQuery().updateVersion(
						DataBaseQuery.KEY_VERSION_DUTY_NAME,
						DataBaseQuery.KEY_VERSION_ED_NAME,
						ver)	;
			}
			else if(category.equals(Connect.delPath))
			{
				new DataBaseQuery().updateVersion(
						DataBaseQuery.KEY_VERSION_DUTY_NAME,
						DataBaseQuery.KEY_VERSION_DEL_NAME,
						ver)	;
			}
		}
		else if(table.equals(Connect.station))
		{
			if(category.equals(Connect.addPath))
			{
				new DataBaseQuery().updateVersion(
						DataBaseQuery.KEY_VERSION_STATION_NAME,
						DataBaseQuery.KEY_VERSION_ADD_NAME,
						ver)	;
			}
			else if(category.equals(Connect.upPath))
			{
				new DataBaseQuery().updateVersion(
						DataBaseQuery.KEY_VERSION_STATION_NAME,
						DataBaseQuery.KEY_VERSION_ED_NAME,
						ver)	;
			}
			else if(category.equals(Connect.delPath))
			{
				new DataBaseQuery().updateVersion(
						DataBaseQuery.KEY_VERSION_STATION_NAME,
						DataBaseQuery.KEY_VERSION_DEL_NAME,
						ver)	;
			}	
		}
		
	}
	

}
