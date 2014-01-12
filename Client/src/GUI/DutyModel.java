package GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Data.Duty;
import Data.Worker;

public class DutyModel extends AbstractTableModel 
{
	private ArrayList<Duty> list;
	public DutyModel(ArrayList<Duty> list)
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
		Duty duty = list.get(rowIndex);
		if(columnIndex==0)
			return duty.getWorker().getSurname();
		else 
			return duty.getData();
	}

}
