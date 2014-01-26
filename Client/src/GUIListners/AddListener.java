package GUIListners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.DutyAdd;
import GUI.MainFrame;
import GUI.StationAdd;
import GUI.WorkerAdd;

public class AddListener implements ActionListener
{
	private MainFrame mf;
	public AddListener(MainFrame mf)
	{
		this.mf=mf;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("add");
		Object pattern=e.getSource();
		if(pattern.equals(mf.getWorkerAddBut()))
		{
			new WorkerAdd(mf.getWorkersAdd());
		}
		else if(pattern.equals(mf.getDutyAddBut()))
		{
			new DutyAdd(mf.getDutiesAdd());
		}
		else if(pattern.equals(mf.getStationAddBut()))
		{
			new StationAdd(mf.getStationsAdd());
		}
		else
		{
			
		}
			
		
	}

}
