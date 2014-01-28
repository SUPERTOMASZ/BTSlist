package GUIListners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;

import Data.Duty;
import Data.Station;
import Data.Worker;
import DataBase.DataBaseQuery;
import Ftp.Connect;
import Ftp.SendThread;
import GUI.MainFrame;

public class SynchListner implements ActionListener 
{
	private MainFrame mf = null;

	
	public SynchListner(MainFrame mf)
	{
		this.mf = mf;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object pattern=e.getSource();
		if(pattern.equals(mf.getWorkerSyncButton()))
		{
			
			SendThread<Worker> thread1= new SendThread<>(mf.getWorkersAdd(),
									Connect.workerPath,Connect.addPath);
			thread1.start();
			SendThread<Worker> thread2= new SendThread<>(mf.getWorkersEd(),
					Connect.workerPath,Connect.upPath);
			thread2.start();
			System.out.println("przed wysylka "+mf.getWorkersDel().size());
			SendThread<Worker> thread3= new SendThread<>(mf.getWorkersDel(),
					Connect.workerPath,Connect.delPath);
			thread3.start();
			System.out.println("wysylam workerow");
			
			
			
			
			
		}
		else if(pattern.equals(mf.getDutySynBut()))
		{
			SendThread<Duty> thread1= new SendThread<>(mf.getDutiesAdd(),
					Connect.dutyPath,Connect.addPath);
			thread1.start();
			SendThread<Duty> thread2= new SendThread<>(mf.getDutiesEd(),
					Connect.dutyPath,Connect.upPath);
			thread2.start();
			SendThread<Duty> thread3= new SendThread<>(mf.getDutiesDel(),
					Connect.dutyPath,Connect.delPath);
			thread3.start();
			System.out.println("wysylam dyzury");
			
		}
		else if(pattern.equals(mf.getStationSynBut()))
		{
			SendThread<Station> thread1= new SendThread<>(mf.getStationsAdd(),
					Connect.station,Connect.addPath);
			thread1.start();
			SendThread<Station> thread2= new SendThread<>(mf.getStationsEd(),
					Connect.station,Connect.upPath);
			thread2.start();
			SendThread<Station> thread3= new SendThread<>(mf.getStationsDel(),
					Connect.station,Connect.delPath);
			thread3.start();
			System.out.println("wysylam dyzury");
		
			
		}
		else
		{
			
		}
		
		
	}
	

}
