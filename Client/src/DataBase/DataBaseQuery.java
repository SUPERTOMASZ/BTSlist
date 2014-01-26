package DataBase;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.codehaus.jackson.map.DeserializerFactory.Config;

import Data.Duty;
import Data.Station;
import Data.Worker;
import GUI.MainFrame;

public class DataBaseQuery 
{


	private Connection c;
	public static String BASENAME="base.db";
	public static String BASETABLE= "Bts";
	public static String PRIMARY_KEY="id";
	public static String KEY_STATION_NUM="NRStacji";
	public static String KEY_NETWORKS_NUM="nrNetWorks";
	public static String KEY_PTC_NUM="nrPTC";
	public static String KEY_PTK_NUM="nrPTK";
	public static String KEY_OWNER="wlasciciel";
	public static String KEY_STATION_NAME="nazwaStacji";
	public static String KEY_PTC_NAME="nazwaPTC";
	public static String KEY_PTK_NAME="nazwaPTK";
	public static String KEY_REGION="region";
	public static String KEY_AREA="obszar";
	public static String KEY_DELETED_DATE="dataSkasowania";
	public static String KEY_STREET="ulica";
	public static String KEY_STREET_NO="numer";
	public static String KEY_ZIP_CODE="kodPocztowy";
	public static String KEY_CITY="miasto";
	public static String KEY_COMMUNITY="gmina";
	public static String KEY_DISTRICT="powiat";
	public static String KEY_PROVINCE="wojewodztwo";
	public static String KEY_TYPE="typ";
	public static String KEY_CANDIDATE="kandydat";
	public static String KEY_CORD_X="wspX";
	public static String KEY_CORD_Y="wspY";
	public static String KEY_HEIGHT="wys";
	public static String KEY_BUILDING_HEIGHT="wysBud";
	public static String KEY_ACCESS_DESCRIBE="opisDostepu";
	public static String KEY_STATION_DESCRIBE="opisStacji";
	public static String KEY_PLUS_NUM="nrPlus";
	public static String KEY_PLAY_NUM="nrPlay";
	public static String KEY_POWER_STATION_NUMBER="nrElektrowni";
	public static String KEY_UPDATE_DATE="dataAktualizacji";
	
	private static String WORKERSTABLE= "Pracownicy";
	private static String KEY_NAME= "imie";
	private static String KEY_SURNAME= "nazwisko";


	private static String DUTYTABLE= "Dyzury";
	private static String KEY_DATE= "data";
	private static String KEY_WORKER_ID="id_pracownika";
	
	private static final String [] COLUMNS={PRIMARY_KEY,KEY_STATION_NUM,KEY_NETWORKS_NUM,
		KEY_PTC_NUM,KEY_PTK_NUM,KEY_OWNER,KEY_STATION_NAME,KEY_PTC_NAME,KEY_PTK_NAME,
		KEY_REGION,KEY_AREA,KEY_DELETED_DATE,KEY_STREET,KEY_STREET_NO,KEY_ZIP_CODE,
		KEY_CITY,KEY_COMMUNITY,KEY_DISTRICT,KEY_PROVINCE,KEY_TYPE,KEY_CANDIDATE,
		KEY_CORD_X,KEY_CORD_Y,KEY_HEIGHT,KEY_BUILDING_HEIGHT,KEY_ACCESS_DESCRIBE,
		KEY_STATION_DESCRIBE,KEY_PLUS_NUM,KEY_PLAY_NUM,KEY_POWER_STATION_NUMBER,
		KEY_UPDATE_DATE};
	
	public DataBaseQuery()
	{
		c = null;
		try 
	    {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:res/databases/base.db");
		
			System.out.println("otworzylem c "+(c!=null));
	    }
	    catch (SQLException e)
	    {
	    	e.printStackTrace();
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
			String order1="INSERT INTO Pracownicy(imie,nazwisko) VALUES("+
			" \""+worker.getName().replaceAll(" ", "")+"\" ," +
			" \""+worker.getSurname().replaceAll(" ", "")+"\" );";
			temp.executeUpdate(order1);
		} 
		catch (SQLException e) 
		{
            System.err.println("Problem z poleceniem");
		}
		
		
		end();
		
	}
	
	public void insert(Duty duty,int workerId)
	{
		
		try 
		{
			System.out.println(workerId);
			Statement temp=c.createStatement();
			String order1="INSERT INTO Dyzury(data,id_pracownika) VALUES"+
			"( '"+duty.getData()+"' ,"+workerId+");";
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
					  "nazwaStacji,nazwaPTC,nazwaPTK,region," +
					  "ulica,numer,kodPocztowy,miasto,typ," +
					  "wspX,wspY,wys,wysBud,opisDostepu,opisStacji,nrPlus,nrPlay,nrElektrowni" +
					  ")"+
					  " VALUES(" +
					  " \""+bts.getStationNum()+"\" ," +
					  " \" "+bts.getNetWorksNum()+"\" ," +
					  " \""+bts.getPTCNum()+"\"," +
					  " \""+bts.getPTKNum()+"\" , " +
					  " \""+bts.getOwner()+"\" ," +
					  " \""+bts.getStationName()+"\" ," +
					  " \""+bts.getPTCName()+"\", "+
					  " \""+bts.getPTKName()+"\","+
					  " \""+bts.getRegion()+"\" ," +
					  " \""+bts.getStreet()+"\" ," +
					  " \""+bts.getStreetNo()+"\" ," +
					  " \""+bts.getZip_Code()+"\" ," +
					  " \""+bts.getCity()+"\" ," +
					  " \""+bts.getType()+"\" ," +
					  " \""+bts.getCordX()+"\" ," +
					  " \""+bts.getCordY()+"\", " +
					  checIsNumber(bts.getHeight())+ "," +
					  checIsNumber(bts.getBuilding_height())+ "," +
					  " \""+bts.getAccessDescribe()+"\", " +
					  " \""+bts.getStationDescribe()+"\", " +
					  " \""+bts.getPlusNum()+"\", " +
					  " \""+bts.getPlayNum()+"\" , " +
					  " \""+bts.getPowerPlantNum()+"\" " +
					  " );";
		System.out.println(order1);
			temp.executeUpdate(order1);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
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
		Statement temp;
		try {
			temp = c.createStatement();
			String order ="UPDATE Pracownicy SET" +
					" imie='"+worker.getName()+"',"+
					" nazwisko='"+worker.getSurname()+
					"' WHERE id_pracownika="+worker.getID()+" ;";
			temp.executeUpdate(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void update(Duty duty)
	{
		Statement temp;
		try {
			temp = c.createStatement();
			String order ="UPDATE Dyzury SET" +
					" id_pracownika='"+duty.getWorker().getID()+"',"+
					" data='"+duty.getData()+"';";
					
			temp.executeUpdate(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Station bts)
	{
		Statement temp;
		try {
			temp = c.createStatement();
			String order="UPDATE Bts SET " +
				  "NRStacji=\" "+bts.getStationNum()+"\" ," +
				  "nrNetWorks=\" "+bts.getNetWorksNum()+"\" ," +
				  "nrPTC=\" "+bts.getPTCNum()+"\"," +
				  "nrPTK=\""+bts.getPTKNum()+"\" , " +
				  "wlasciciel=\" "+bts.getOwner()+"\" ," +
				  "nazwaStacji=\" "+bts.getStationName()+"\" ," +
				  "nazwaPTC=\" "+bts.getPTCName()+"\", "+
				  "nazwaPTK=\" "+bts.getPTKName()+"\","+
				  "region=\" "+bts.getRegion()+"\" ," +
				  "ulica=\" "+bts.getStreet()+"\" ," +
				  "numer=\" "+bts.getStreetNo()+"\" ," +
				  "kodPocztowy= \" "+bts.getZip_Code()+"\" ," +
				  "miasto=\" "+bts.getCity()+"\" ," +
				  "typ=\" "+bts.getType()+"\" ," +
				  "wspX=\" "+bts.getCordX()+"\" ," +
				  "wspY=\" "+bts.getCordY()+"\", " +
				  "wys="+checIsNumber(bts.getHeight())+ "," +
				  "wysBud="+checIsNumber(bts.getBuilding_height())+ "," +
				  "opisDostepu=\""+bts.getAccessDescribe()+"\", " +
				  "opisStacji=\""+bts.getStationDescribe()+"\", " +
				  "nrPlus=\""+bts.getPlusNum()+"\", " +
				  "nrPlay=\""+bts.getPlayNum()+"\" , " +
				  "nrElektrowni=\""+bts.getPowerPlantNum()+"\"" +
				  " ;";
		
			System.out.println(order);
		temp.executeUpdate(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private String convertCategoriesFromCombo(String input) throws Exception
	{
		
	
		if (input.contains(MainFrame.stationCatList[0]))
		{
			return "nazwaStacji";
			
		}
		else if (input.contains(MainFrame.stationCatList[1]))
		{
			return "nazwaPTC";
		}
		else if (input.contains(MainFrame.stationCatList[2]))
		{
			return "nazwaPTK";
		}
		else if (input.contains(MainFrame.stationCatList[3]))
		{
			return "nrNetWorks";
		}
		else if (input.contains(MainFrame.stationCatList[4]))
		{
			return "nrPTC";
		}
		else if (input.contains(MainFrame.stationCatList[5]))
		{
			return "nrPTK";
		}
		else 
			throw new Exception();

	}
	
	public ArrayList<Station> getBTS(String keyword,String choose)
	{
		
		keyword=convertString(keyword);
		try {
			choose=convertCategoriesFromCombo(choose);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement stat = null;
		ArrayList<Station> resultList = new ArrayList<Station>();
	        try {
	
	        	stat = c.createStatement();
	           String order="SELECT * FROM "+BASETABLE+" WHERE "+choose +" LIKE '%"+keyword+"%' ;";
	            System.out.println(order);
	        	ResultSet rs = stat.executeQuery(order);
	           while( rs.next())
	           {
	        	   Station station= new Station();
	        	   station.setID(rs.getInt(1));
	        	   station.setStationNum(rs.getString(2));
	        	   station.setNetWorksNum(rs.getString(3));
	        	   station.setPTCNum(rs.getString(4));
	        	   station.setPTKNum(rs.getString(5));
	        	   station.setOwner(rs.getString(6));
	        	   station.setStationName(rs.getString(7));
	        	   station.setPTCName(rs.getString(8));
	        	   station.setPTKName(rs.getString(9));
	        	   station.setRegion(rs.getString(10));
	        	   station.setArea(rs.getString(11));
	        	   station.setDeletedData(rs.getString(12));
	        	   station.setStreet(rs.getString(13));
	        	   station.setStreetNo(rs.getString(14));
	        	   station.setZip_Code(rs.getString(15));
	        	   station.setCity(rs.getString(16));
	        	   station.setCommunity(rs.getString(17));
	        	   station.setDistrict(rs.getString(18));
	        	   station.setProvince(rs.getString(19));
				   station.setType(rs.getString(20));
					station.setCandidat(rs.getString(21));
					station.setCordX(checIsNumber(rs.getString(22)));
					station.setCordY(checIsNumber(rs.getString(23)));
					station.setHeight(rs.getString(24));
					station.setBuilding_height(rs.getString(25));
					station.setAccessDescribe(rs.getString(26));
					station.setStationDescribe(rs.getString(27));
					station.setPlusNum(rs.getString(28));
					station.setPlayNum(rs.getString(29));
					station.setPowerPlantNum(rs.getString(30));
					station.setUpdatedTime(rs.getString(31));
				resultList.add(station);
	        
	           }
	           
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	        end();
	        return resultList;
	        
	      

	
	}
	public ArrayList<Worker> getWorkers(String keyword,String category)
	{
		
		keyword=DataBaseQuery.convertFromPolish(keyword);
		category=DataBaseQuery.convertFromPolish(category);
		Statement stat = null;
		ArrayList<Worker> resultList = new ArrayList<Worker>();
		String order="SELECT * FROM "+WORKERSTABLE
				+" WHERE "+category+" LIKE '%"+keyword+"%' ;";
	        	ResultSet rs;
				try {
					  stat = c.createStatement();
					rs = stat.executeQuery(order);
											
					 while( rs.next())
			           {
						 String name=firstLetter2Up(rs.getString(2).replaceAll(" ", ""));
						 String surname=firstLetter2Up(rs.getString(3).replaceAll(" ", ""));
			        	   Worker worker= new Worker();
			        	   worker.setID(rs.getInt(1));
			        	   worker.setName(name);
			        	   worker.setSurname(surname);
			        	   System.out.println(firstLetter2Up(worker.getName()));
						resultList.add(worker);
			        	 
			           }
			           end();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          
	           return resultList;
	}
	public ArrayList<Duty> getDuties(String keyword,String category)
	{
		
		
		keyword=convertFromPolish(keyword);
		category=convertFromPolish(category);
		System.out.println(keyword);
		System.out.println(category);
		Statement stat = null;
		ArrayList<Duty> resultList = new ArrayList<Duty>();
	        	ResultSet rs;
				try {
					  stat = c.createStatement();
					rs = stat.executeQuery( "SELECT * FROM "+DUTYTABLE+
							" NATURAL JOIN "+WORKERSTABLE+" WHERE "+
							category+" LIKE '%"+keyword+"%' ;");
					 while( rs.next())
			           {
			        	   Duty duty= new Duty();
			        	   Worker worker= new Worker();
			        	   duty.setData(rs.getString(2).replaceAll(" ", ""));
			        	   worker.setID(rs.getInt(3));
			        	   worker.setName(firstLetter2Up(rs.getString(4).replaceAll(" ", "")));
			        	   worker.setSurname(firstLetter2Up(rs.getString(5).replaceAll(" ", "")));
			        	   duty.setWorker(worker);
			        	   
						resultList.add(duty);
			        	 
			           }
			           end();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          
	           return resultList;
	}
	public int getWorkerId(String name,String surname)
	{
		
		name=DataBaseQuery.convertFromPolish(name);
		surname=DataBaseQuery.convertFromPolish(surname);
		Statement stat = null;
	        	ResultSet rs;
				try {
					  stat = c.createStatement();
					rs = stat.executeQuery( "SELECT * FROM "+WORKERSTABLE+
							" WHERE Imie=' "+ name+ " ' AND Nazwisko=' "+surname+" ' ;");
					
						
						if(rs.next())
						{
							int id=rs.getInt(1);
							end();
							return id;
						}
						else
						{
							end();
							return(-1);
						}

	      }
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}

	private String convertString(String input)
	{
		input=input.toLowerCase();
		input=input.replaceAll(" ","");
		input=input.replaceAll("¹", "a");
		input=input.replaceAll("æ", "c");
		input=input.replaceAll("ê", "e");
		input=input.replaceAll("³", "l");
		input=input.replaceAll("ñ", "n");
		input=input.replaceAll("ó", "o");
		input=input.replaceAll("œ", "s");
		input=input.replaceAll("Ÿ", "z");
		input=input.replaceAll("¿", "z");
		return input;
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
		float result=0;
		try{
		 result =Float.parseFloat(in);
		}
		catch(NumberFormatException e)
		{
			
		}
		catch(NullPointerException e)
		{
			
		}
		
		return result;
		
	}
	public static String firstLetter2Up(String in)
	{
		
		return (in.substring(0, 1).toUpperCase() + in.substring(1));
		
	}
	public static  String convertFromPolish(String input)
	{
		input=input.toLowerCase();
		input=input.replaceAll("¹", "a");
		input=input.replaceAll("æ", "c");
		input=input.replaceAll("ê", "e");
		input=input.replaceAll("³", "l");
		input=input.replaceAll("ñ", "n");
		input=input.replaceAll("ó", "o");
		input=input.replaceAll("œ", "s");
		input=input.replaceAll("Ÿ", "z");
		input=input.replaceAll("¿", "z");
		return input;
	}
	
}
