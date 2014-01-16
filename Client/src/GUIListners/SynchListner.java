package GUIListners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import Data.Duty;
import Data.Station;
import Data.Worker;
import DataBase.DataBaseQuery;
import Ftp.Connect;
import Ftp.SendThread;
import GUI.MainFrame;

public class SynchListner extends JFrame implements ActionListener 
{
	private MainFrame mainFrame = null;

	public SynchListner()
	{
		
	}
	
	public SynchListner(MainFrame mainFrame)
	{
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object o = e.getSource();
		if (o instanceof JButton)
		{
			JButton b = (JButton)o;
		
			/* kolejnoœæ buttonów:
		    workerSearchBut,  workerAddBut, workerDelButton, workerUpButton, workerSyncButton,
     		dutySearchBut, dutyAddBut, dutyDelBut, dutyUpBut,  dutySynBut, 
			stationSearchBut, stationAddBut, stationDelBut, stationUpBut, stationSynBut 
			 */
			
			if (mainFrame!=null)
			{
				int index = mainFrame.getButtonID(b);
				if (index == 0) //workerSearchBut
				{
					System.out.println(index+"qq");
					new DataBaseQuery().insert(new Worker("aa", "aa"));
				}
				else if (index == 1) //workerAddBut
				{
					System.out.println(index+"qq");
				}
				else if (index == 2) // workerDelButton
				{
					System.out.println(index+"qq");
				}
				else if (index == 3) //workerUpButton
				{ 
					System.out.println(index+"qq");
				}
				else if (index == 4) //workerSyncButton
				{

					System.out.println(mainFrame.getWorkersAdd().size()+" lista");
					SendThread<Worker> thread1= new SendThread<>(mainFrame.getWorkersAdd(),
											Connect.workerPath+Connect.addPath);
					thread1.start();
					SendThread<Worker> thread2= new SendThread<>(mainFrame.getWorkersEd(),
							Connect.workerPath+Connect.upPath);
					thread2.start();
					SendThread<Worker> thread3= new SendThread<>(mainFrame.getWorkersDel(),
							Connect.workerPath+Connect.delPath);
					thread3.start();
					System.out.println("wysylam");
				}
				else if (index == 5) //dutySearchBut
				{
					
				}
				else if (index == 6)//dutyAddBut
				{
					
				}
				else if (index == 7)//dutyDelBut
				{
					
				}
				else if (index == 8)// dutyUpBut
				{
					
				}
				else if (index == 9)//dutySynBut 
				{
					
				}
				else if (index == 10)//stationSearchBut
				{
					
				}
				else if (index == 11)//stationAddBut 
				{
					
				}
				else if (index == 12)//stationDelBut 
				{
					
				}
				else if (index == 13)//stationUpBut 
				{
					
				}
				else if (index == 14)//stationSynBut 
				{
					
				}
				else if (index == -1)
				{
					System.out.println("nie ma buttona");
				}
			
			
			}
		}
	}
	

}
