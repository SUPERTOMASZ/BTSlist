package DataBase;

import java.util.ArrayList;

import Data.Worker;
import Ftp.Connect;
import Ftp.SendThread;
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
		workerConnect.disconect();
		workerConnect.connect();
		int workerEd=workerConnect.coutFiles(Connect.workerPath+Connect.upPath);
		workerConnect.disconect();
		workerConnect.connect();
		int workerDel=workerConnect.coutFiles(Connect.workerPath+Connect.delPath);
		System.out.println(workerAdds+" "+workerEd+" "+workerDel);
		
		workerConnect.disconect();
		DataBaseQuery db= new DataBaseQuery();
		//db.insert(new Worker("Michal","Blach"));
		
		
		
		
		introFrame.setVisible(false);
		new MainFrame(800, 600);
	}

}
