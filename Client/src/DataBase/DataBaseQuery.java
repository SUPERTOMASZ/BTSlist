package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import Data.Duty;
import Data.Station;
import Data.Worker;

public class DataBaseQuery 
{

	Connection c;
	
	public DataBaseQuery()
	{
		c = null;
		try 
	    {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:assets/base.db");
	    }
	    catch (SQLException e)
	    {
            System.err.println("Problem z baz¹");
	    }
	    catch (ClassNotFoundException e)
	    {
            System.err.println("Class not found");
	    }
	    
	}
	
	public void insert(Worker worker)
	{
		try 
		{
			Statement temp=c.createStatement();
			String order1="INSERT INTO Pracownicy(imie,nazwisko) VALUES("+" \" "
			+worker.getName()+" \" , \" "
			+worker.getSurname()+" \" );";
			temp.executeUpdate(order1);
		} 
		catch (SQLException e) 
		{
            System.err.println("Problem z poleceniem");
		}
		
		
		end();
		
	}
	
	public void insert(Duty duty)
	{
		// nie zadzia³a -  w tabeli jest id_pracowniki, w duty data do przeobienia 
		try 
		{
			Statement temp=c.createStatement();
			String order1="INSERT INTO Dyzury(data,id_pracownika) VALUES("+" \" "
			+duty.getData()+" \" , \" "
			+duty.getWorker()+" \" );";
			temp.executeUpdate(order1);
		} 
		catch (SQLException e) 
		{
            System.err.println("Problem z poleceniem");
		}
		
		
		end();
	}
	
	public void insert (Station bts)
	{
		try 
		{
			Statement temp=c.createStatement();
			String order1="INSERT INTO Bts (NRStacji,nrNetWorks,nrPTC,nrPTK,wlasciciel," +
					  "nazwaStacji,nazwaPTC,nazwaPTK,region,obszar,dataSkasowania," +
					  "ulica,numer,kodPocztowy,miasto,gmina,powiat,wojewodztwo,typ," +
					  "kandydat,wspX,wspY,wys,wysBud,opisDostepu,opisStacji,nrPlus,nrPlay,nrElektrowni,dateAktualizacji)" +
					  " VALUES(" +
					  "\""+bts.getStationNum()+" \" ," +
					  " \" "+bts.getNetWorksNum()+" \" ," +
					  " \"  "+bts.getPTCNum()+" \"," +
					  "\" "+bts.getPTKNum()+"\" , " +
					  "\" "+bts.getOwner()+" \"," +
					  " \" "+bts.getStationName()+"\" ," +
					  " \"  "+bts.getPTCName()+" \", "+
					  " \" "+bts.getPTKName()+" \","+
					  " \" "+bts.getRegion()+" \" ," +
					  " \" "+bts.getArea()+"\" ,"+
					  " \" "+bts.getDeletedData()+" \" ," +
					  " \" "+bts.getStreet()+" \" ," +
					  " \" "+bts.getStreetNo()+" \" ," +
					  " \" "+bts.getZip_Code()+" \" ," +
					  " \" "+bts.getCity()+" \" ," +
					  " \" "+bts.getCommunity()+" \" ," +
					  " \" "+bts.getDistrict()+" \" ," +
					  " \" "+bts.getProvince()+" \" ," +
					  " \" "+bts.getType()+" \" ," +
					  " \" "+bts.getCandidat()+" \" ," +
					  " \" "+bts.getCordX()+" \" ," +
					  " \" "+bts.getCordY()+" \", " +
					  checIsNumber(bts.getHeight())+ "," +
					  checIsNumber(bts.getBuilding_height())+ "," +
					  " \" "+bts.getAccessDescribe()+" \", " +
					  " \" "+bts.getStationDescribe()+" \", " +
					  " \" "+bts.getPlusNum()+" \", " +
					  " \" "+bts.getPlayNum()+" \" " +
					  " \" "+bts.getPowerPlantNum()+" \" " +
					  " \" "+bts.getUpdatedTime()+" \" " +
					  " );";
			temp.executeUpdate(order1);
		} 
		catch (SQLException e) 
		{
            System.err.println("Problem z poleceniem");
		}
		
		
		end();
		
		
	}
	
	public void delete(Worker worker)
	{
		
	}
	
	public void delete(Duty duty)
	{
		
	}
	
	public void delete(Station station)
	{
		
	}
	
	public void update(Worker worker)
	{
		
	}
	
	public void update(Duty duty)
	{
		
	}
	
	public void update(Station station)
	{
		
	}
	
	private void end()
	{
		try 
		{
			c.close();
	    } 
		catch (SQLException e) 
		{
	            System.err.println("Problem z zamknieciem polaczenia");
	    }
	}
	
	
	private float checIsNumber(String in)
	{
		float result=-1;
		try{
		 result =Float.parseFloat(in);
		}
		catch(NumberFormatException e)
		{
			
		}
		return result;
		
	}
}
