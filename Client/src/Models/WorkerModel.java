package Models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Data.Worker;
import DataBase.DataBaseQuery;

public class WorkerModel extends AbstractTableModel
{
	private ArrayList<Worker> input;
	public WorkerModel(ArrayList<Worker> input)
	{
		this.input=input;
		System.out.println("worker model");
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
		{
			System.out.println(DataBaseQuery.firstLetter2Up(result.getName()));
			return(DataBaseQuery.firstLetter2Up(result.getName()));
			
		}
		else 
		{
			System.out.println(DataBaseQuery.firstLetter2Up(result.getSurname()));
			return(DataBaseQuery.firstLetter2Up(result.getSurname()));
		}
			
		
	}

}
