package DataBase;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import Data.Worker;
import Ftp.Connect;
import GUI.IntroFrame;
import GUI.MainFrame;

public class InitThread extends Thread
{
	//tutaj tomasz trzeba zrobic pobranei wersje z bazy 
	private int worAddVer=0;
	private int worUpVer=0;
	private int worDelVer=0;
	private IntroFrame introFrame;
	public InitThread(IntroFrame introFrame)
	{
		this.introFrame=introFrame;
	}
	@Override
	public void run() 
	{
		
		Connect workerConnect = new Connect();
		int workerAdds=workerConnect.coutFiles(Connect.workerPath+Connect.addPath);
		ObjectMapper mapper =new ObjectMapper();
		try {
			ArrayList<Worker> list=mapper.readValue(workerConnect.createInputStream("", 1),
					new TypeReference<ArrayList<Worker>>() { });
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i).getName());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workerConnect.disconect();
		workerConnect.connect();
		int workerEd=workerConnect.coutFiles(Connect.workerPath+Connect.upPath);
		workerConnect.disconect();
		workerConnect.connect();
		int workerDel=workerConnect.coutFiles(Connect.workerPath+Connect.delPath);
		System.out.println(workerAdds+" "+workerEd+" "+workerDel);
		
		workerConnect.disconect();
		
		
		
		
		
		
		introFrame.setVisible(false);
		new MainFrame(800, 600);
	}

}
