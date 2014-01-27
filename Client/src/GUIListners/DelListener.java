package GUIListners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DataBase.DataBaseQuery;
import GUI.MainFrame;

public class DelListener implements ActionListener
{
	private MainFrame mf;

	public DelListener(MainFrame mf)
	{
		this.mf=mf;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object pattern=e.getSource();
		if(pattern.equals(mf.getWorkerDelButton()))
		{
			int selected[]=mf.getWorkerTable().getSelectedRows();
			for(int i=0;i<selected.length;i++)
			{
				mf.getWorkersDel().add(mf.getWorkeResultList().get(selected[i]));
				System.out.println(" wielkosc list del"+mf.getWorkersDel().size());
				new DataBaseQuery().delete(mf.getWorkeResultList().get(selected[i]));
			}
		}
		else if(pattern.equals(mf.getDutyDelBut()))
		{
			int selected[]=mf.getDutyTable().getSelectedRows();
			for(int i=0;i<selected.length;i++)
			{
				mf.getDutiesDel().add(mf.getDutyResultList().get(selected[i]));
				new DataBaseQuery().delete(mf.getDutyResultList().get(selected[i]));
			}
		}
		else if(pattern.equals(mf.getStationDelBut()))
		{
			int selected[]=mf.getStationTable().getSelectedRows();
			for(int i=0;i<selected.length;i++)
			{
				mf.getStationsDel().add(mf.getStationResultList().get(selected[i]));
				new DataBaseQuery().delete(mf.getStationResultList().get(selected[i]));
			}
		}
		
		
	}
	

}
