package GUIListners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Data.Station;
import Data.Worker;
import GUI.DutyEd;
import GUI.EdStation;
import GUI.MainFrame;
import GUI.WorkerAdd;
import GUI.WorkerEd;

public class EdListener implements ActionListener
{
	private MainFrame mf;
	private Station station;
	public EdListener(MainFrame mf)
	{
		this.mf=mf;
		this.station=station;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("ed");
		Object pattern=e.getSource();
		
		if(pattern.equals(mf.getWorkerUpButton()))
		{
			int [] selected;
			selected=mf.getWorkerTable().getSelectedRows();
			for(int i=0;i<selected.length;i++)
			{
				new WorkerEd(mf.getWorkersEd(), mf.getWorkeResultList().get(selected[i]));
			}
			
		}
		else if(pattern.equals(mf.getDutyUpBut()))
		{
			int [] selected;
			selected=mf.getDutyTable().getSelectedRows();
			for(int i=0;i<selected.length;i++)
			{
				new DutyEd(mf.getDutiesEd(),mf.getDutyResultList().get(selected[i]));
			}
		}
		else if(pattern.equals(mf.getStationUpBut()))
		{
			int [] selected;
			selected=mf.getStationTable().getSelectedRows();
			for(int i=0;i<selected.length;i++)
			{
				
				new EdStation(mf.getStationsEd(),mf.getStationResultList().get(selected[i]));
			}
		}
		else
		{
			
		}
			
		
	}

}
