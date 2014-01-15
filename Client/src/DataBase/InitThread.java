package DataBase;

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
		Connect workerConect = new Connect();
		System.out.println(workerConect.coutFiles(Connect.workerPath+Connect.addPath));
		introFrame.setVisible(false);
		new MainFrame(800, 600);
	}

}
