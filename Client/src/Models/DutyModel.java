package Models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Data.Duty;
import Data.Worker;

public class DutyModel extends AbstractTableModel
{
	private ArrayList<Duty> input;
	public DutyModel(ArrayList<Duty> input)
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
		Duty result=input.get(row);
		if(col==0)
			return result.getWorker().getSurname();
		else if(col==1)
			return result.getData();
		else 
			return "";
		
	}

}
