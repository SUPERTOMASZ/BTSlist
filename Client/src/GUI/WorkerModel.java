package GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Data.Worker;


public class WorkerModel extends AbstractTableModel 
{
	private ArrayList<Worker> list;
	public WorkerModel(ArrayList<Worker> list)
	{
		this.list=list;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		
		Worker worker = list.get(rowIndex);
		if(columnIndex==0)
			return worker.getName();
		else 
			return worker.getSurname();
		
	}


}
