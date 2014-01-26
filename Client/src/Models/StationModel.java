package Models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Data.Duty;
import Data.Station;
import Data.Worker;

public class StationModel extends AbstractTableModel
{
	private ArrayList<Station> input;
	public StationModel(ArrayList<Station> input)
	{
		this.input=input;
		
	}
	@Override
	public int getColumnCount() {
		
		return 1;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return input.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Station result=input.get(row);
		return result.getStationName();
		
	}

}
