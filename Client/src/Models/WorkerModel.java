package Models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Data.Worker;

public class WorkerModel extends AbstractTableModel
{
	private ArrayList<Worker> input;
	public WorkerModel(ArrayList<Worker> input)
	{
		this.input=input;
	}
	@Override
	public int getColumnCount() {
		
		return 2;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return input.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Worker result=input.get(row);
		if(col==0)
			return result.getName();
		else 
			return result.getSurname();
		
	}

}
