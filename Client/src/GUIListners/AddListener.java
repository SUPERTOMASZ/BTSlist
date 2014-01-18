package GUIListners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.DutyAddEd;
import GUI.MainFrame;
import GUI.StationAddEd;
import GUI.WorkerAddEd;

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
			new WorkerAddEd(mf.getWorkersAdd());
		}
		else if(pattern.equals(mf.getDutyAddBut()))
		{
			new DutyAddEd(mf.getDutiesAdd());
		}
		else if(pattern.equals(mf.getStationAddBut()))
		{
			new StationAddEd(mf.getStationsAdd());
		}
		else
		{
			
		}
			
		
	}

}
