package DataBase;

import java.io.InputStream;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import Data.Duty;
import Data.Station;
import Data.Worker;
import Ftp.Connect;
import GUI.IntroFrame;
import GUI.MainFrame;

public class InitThread extends Thread
{

	private int worAddVer=0;
	private int worUpVer=0;
	private int worDelVer=0;
	private int dutyAddVer=0;
	private int dutyEdVer=0;
	private int dutyDelVer=0;
	private int statAddVer=0;
	private int statEdVer=0;
	private int statDelVer=0;
	private IntroFrame introFrame;
	public InitThread(IntroFrame introFrame)
	{
		this.introFrame=introFrame;
	
	}
	private void getVersionFromDataBase()
	{
		this.worAddVer=(new DataBaseQuery().getVersion
				(DataBaseQuery.KEY_VERSION_WORKER_NAME,
						DataBaseQuery.KEY_VERSION_ADD_NAME));
		this.worUpVer=(new DataBaseQuery().getVersion
				(DataBaseQuery.KEY_VERSION_WORKER_NAME,
						DataBaseQuery.KEY_VERSION_ED_NAME));
		this.worDelVer=(new DataBaseQuery().getVersion
				(DataBaseQuery.KEY_VERSION_WORKER_NAME,
						DataBaseQuery.KEY_VERSION_DEL_NAME));
		
		this.dutyAddVer=(new DataBaseQuery().getVersion
				(DataBaseQuery.KEY_VERSION_DUTY_NAME,
						DataBaseQuery.KEY_VERSION_ADD_NAME));
		this.dutyEdVer=(new DataBaseQuery().getVersion
				(DataBaseQuery.KEY_VERSION_DUTY_NAME,
						DataBaseQuery.KEY_VERSION_ED_NAME));
		this.dutyDelVer=(new DataBaseQuery().getVersion
				(DataBaseQuery.KEY_VERSION_DUTY_NAME,
						DataBaseQuery.KEY_VERSION_DEL_NAME));
		
		this.statAddVer=(new DataBaseQuery().getVersion
				(DataBaseQuery.KEY_VERSION_WORKER_NAME,
						DataBaseQuery.KEY_VERSION_ADD_NAME));
		this.statEdVer=(new DataBaseQuery().getVersion
				(DataBaseQuery.KEY_VERSION_WORKER_NAME,
						DataBaseQuery.KEY_VERSION_ED_NAME));
		this.statDelVer=(new DataBaseQuery().getVersion
				(DataBaseQuery.KEY_VERSION_WORKER_NAME,
						DataBaseQuery.KEY_VERSION_DEL_NAME));
		
		
	}
	private synchronized ArrayList<Worker>  getNewWorkerList(Connect connect,int locVer,int serVer)											
	{
		ObjectMapper mapper =new ObjectMapper();
		ArrayList<Worker> result= new ArrayList<Worker>();
			try {
				for(int i=(locVer+1);i<=serVer;i++)
				{
					
					InputStream in=connect.createInputStream(i);
					ArrayList<Worker> temp= new ArrayList<Worker>();
					temp=mapper.readValue(in,
							new TypeReference<ArrayList<Worker>>() { });
					connect.finishInputStream(in);
					for(int j=0;j<temp.size();j++)
					{
						result.add(temp.get(j));
					}
				}
				
			} catch (Exception e){ e. printStackTrace();}
			connect.disconect();
			return result;
		
			
		
	}
	private synchronized ArrayList<Duty>  getNewDutyList(Connect connect,int locVer,int serVer)											
	{
		ObjectMapper mapper =new ObjectMapper();
		ArrayList<Duty> result= new ArrayList<Duty>();
			try {
				for(int i=(locVer+1);i<=serVer;i++)
				{
					
					InputStream in=connect.createInputStream(i);
					ArrayList<Duty> temp= new ArrayList<Duty>();
					temp=mapper.readValue(in,
							new TypeReference<ArrayList<Duty>>() { });
					connect.finishInputStream(in);
					for(int j=0;j<temp.size();j++)
					{
						result.add(temp.get(j));
					}
				}
			} catch (Exception e){ e. printStackTrace();}
			connect.disconect();
			return result;

	}
	private synchronized ArrayList<Station>  getNewStationList(Connect connect,int locVer,int serVer)											
	{
		ObjectMapper mapper =new ObjectMapper();
		ArrayList<Station> result= new ArrayList<Station>();
			try {
				for(int i=(locVer+1);i<=serVer;i++)
				{
					
					InputStream in=connect.createInputStream(i);
					ArrayList<Station> temp= new ArrayList<Station>();
					temp=mapper.readValue(in,
							new TypeReference<ArrayList<Station>>() { });
					connect.finishInputStream(in);
					for(int j=0;j<temp.size();j++)
					{
						result.add(temp.get(j));
					}
				}
			} catch (Exception e){ e. printStackTrace();}
			connect.disconect();
			return result;

	}
	private void getWorkers()
	{
		Connect workerConnect = new Connect();
		workerConnect.connect();
		int workerAddSer=workerConnect.coutFiles(Connect.workerPath+Connect.addPath);
		ArrayList<Worker> workerAddNew=getNewWorkerList(workerConnect,worAddVer, workerAddSer);
		for(int i=0;i<workerAddNew.size();i++)
		{
			new DataBaseQuery().insert(workerAddNew.get(i));
		}
		workerConnect.disconect();
		new DataBaseQuery().updateVersion(DataBaseQuery.KEY_VERSION_WORKER_NAME,
				DataBaseQuery.KEY_VERSION_ADD_NAME,
				workerAddSer)	;
		//////////////
		workerConnect.connect();
		int workerEdSer=workerConnect.coutFiles(Connect.workerPath+Connect.upPath);
		ArrayList<Worker> workerEdNew=getNewWorkerList(workerConnect,worUpVer, workerEdSer);
		for(int i=0;i<workerEdNew.size();i++)
		{
			new DataBaseQuery().update(workerEdNew.get(i));
		}
		workerConnect.disconect();
		new DataBaseQuery().updateVersion(DataBaseQuery.KEY_VERSION_WORKER_NAME,
				DataBaseQuery.KEY_VERSION_ED_NAME,
				workerEdSer)	;
		///////////////
		workerConnect.connect();
		int workerDelSer=workerConnect.coutFiles(Connect.workerPath+Connect.delPath);
		ArrayList<Worker> workerDelNew=getNewWorkerList(workerConnect,worDelVer, workerDelSer);
		for(int i=0;i<workerDelNew.size();i++)
		{
			new DataBaseQuery().delete(workerDelNew.get(i));
		}
		workerConnect.disconect();
		new DataBaseQuery().updateVersion(DataBaseQuery.KEY_VERSION_WORKER_NAME,
				DataBaseQuery.KEY_VERSION_DEL_NAME,
				workerDelSer)	;
	}
	private void getDuties()
	{
		Connect dutyConnect = new Connect();
		dutyConnect.connect();
		int dutyAddSer=dutyConnect.coutFiles(Connect.dutyPath+Connect.addPath);
		ArrayList<Duty> dutyAddNew=getNewDutyList(dutyConnect,dutyAddVer, dutyAddSer);
		for(int i=0;i<dutyAddNew.size();i++)
		{
			new DataBaseQuery().insert(dutyAddNew.get(i));
		}
		dutyConnect.disconect();
		new DataBaseQuery().updateVersion(DataBaseQuery.KEY_VERSION_DUTY_NAME,
				DataBaseQuery.KEY_VERSION_ADD_NAME,
				dutyAddSer)	;
		//////////////
		dutyConnect.connect();
		int dutyEdSer=dutyConnect.coutFiles(Connect.dutyPath+Connect.upPath);
		ArrayList<Duty> dutyEdNew=getNewDutyList(dutyConnect,dutyEdVer, dutyEdSer);
		for(int i=0;i<dutyEdNew.size();i++)
		{
			new DataBaseQuery().update(dutyEdNew.get(i));
		}
		dutyConnect.disconect();
		new DataBaseQuery().updateVersion(DataBaseQuery.KEY_VERSION_DUTY_NAME,
				DataBaseQuery.KEY_VERSION_ED_NAME,
				dutyEdSer)	;	
		///////////////
		dutyConnect.connect();
		int dutyDelSer=dutyConnect.coutFiles(Connect.dutyPath+Connect.delPath);
		ArrayList<Duty> dutyDelNew=getNewDutyList(dutyConnect,dutyDelVer, dutyDelSer);
		for(int i=0;i<dutyDelNew.size();i++)
		{
			new DataBaseQuery().delete(dutyDelNew.get(i));
		}
		dutyConnect.disconect();
		new DataBaseQuery().updateVersion(DataBaseQuery.KEY_VERSION_DUTY_NAME,
				DataBaseQuery.KEY_VERSION_DEL_NAME,
				dutyDelSer)	;
	}
	private void getStations()
	{
		Connect stationConnect = new Connect();
		stationConnect.connect();
		int stationAddSer=stationConnect.coutFiles(Connect.station+Connect.addPath);
		ArrayList<Station> stationAddNew=getNewStationList(stationConnect,statAddVer, stationAddSer);
		for(int i=0;i<stationAddNew.size();i++)
		{
			new DataBaseQuery().insert(stationAddNew.get(i));
		}
		stationConnect.disconect();
		new DataBaseQuery().updateVersion(DataBaseQuery.KEY_VERSION_STATION_NAME,
				DataBaseQuery.KEY_VERSION_ADD_NAME,
				stationAddSer)	;
		//////////////
		stationConnect.connect();
		int stationEdSer=stationConnect.coutFiles(Connect.station+Connect.upPath);
		ArrayList<Station> stationEdNew=getNewStationList(stationConnect,statEdVer, stationEdSer);
		for(int i=0;i<stationEdNew.size();i++)
		{
			new DataBaseQuery().update(stationEdNew.get(i));
		}
		stationConnect.disconect();
		new DataBaseQuery().updateVersion(DataBaseQuery.KEY_VERSION_STATION_NAME,
				DataBaseQuery.KEY_VERSION_ED_NAME,
				stationEdSer)	;	
		///////////////
		stationConnect.connect();
		int stationDelSer=stationConnect.coutFiles(Connect.station+Connect.delPath);
		ArrayList<Station> stationDelNew=getNewStationList(stationConnect,stationDelSer, stationDelSer);
		for(int i=0;i<stationDelNew.size();i++)
		{
			new DataBaseQuery().delete(stationDelNew.get(i));
		}
		stationConnect.disconect();
		new DataBaseQuery().updateVersion(DataBaseQuery.KEY_VERSION_STATION_NAME,
											DataBaseQuery.KEY_VERSION_DEL_NAME,
											stationDelSer)	;		
	}
	@Override
	public void run() 
	{
		
		getVersionFromDataBase();
		getWorkers();
		getDuties();
		getStations();
		
		introFrame.setVisible(false);
		new MainFrame(800, 600);
	}

}
