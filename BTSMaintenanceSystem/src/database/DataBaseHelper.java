package database;

import java.util.ArrayList;


import com.example.btsmaintenancesystem.R;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
	
	
	private static String BASENAME="base.db";
	private static String TABLE= "Bts";
	private static String PRIMARY_KEY="id";
	private static String KEY_STATION_NUM="NRStacji";
	private static String KEY_NETWORKS_NUM="nrNetWorks";
	private static String KEY_PTC_NUM="nrPTC";
	private static String KEY_PTK_NUM="nrPTK";
	private static String KEY_OWNER="wlasciciel";
	private static String KEY_STATION_NAME="nazwaStacji";
	private static String KEY_PTC_NAME="nazwaPTC";
	private static String KEY_PTK_NAME="nazwaPTK";
	private static String KEY_REGION="region";
	private static String KEY_AREA="obszar";
	private static String KEY_DELETED_DATE="dataSkasowania";
	private static String KEY_STREET="ulica";
	private static String KEY_STREET_NO="numer";
	private static String KEY_ZIP_CODE="kodPocztowy";
	private static String KEY_CITY="miasto";
	private static String KEY_COMMUNITY="gmina";
	private static String KEY_DISTRICT="powiat";
	private static String KEY_PROVINCE="wojewodztwo";
	private static String KEY_TYPE="typ";
	private static String KEY_CANDIDATE="kandydat";
	private static String KEY_CORD_X="wspX";
	private static String KEY_CORD_Y="wspY";
	private static String KEY_HEIGHT="wys";
	private static String KEY_BUILDING_HEIGHT="wysBud";
	private static String KEY_ACCESS_DESCRIBE="opisDostepu";
	private static String KEY_STATION_DESCRIBE="opisStacji";
	private static String KEY_PLUS_NUM="nrPlus";
	private static String KEY_PLAY_NUM="nrPlay";
	private static String KEY_POWER_STATION_NUMBER="nrElektrowni";
	private static String KEY_UPDATE_DATE="dataAktualizacji";
	
	private static final String [] COLUMNS={PRIMARY_KEY,KEY_STATION_NUM,KEY_NETWORKS_NUM,
		KEY_PTC_NUM,KEY_PTK_NUM,KEY_OWNER,KEY_STATION_NAME,KEY_PTC_NAME,KEY_PTK_NAME,
		KEY_REGION,KEY_AREA,KEY_DELETED_DATE,KEY_STREET,KEY_STREET_NO,KEY_ZIP_CODE,
		KEY_CITY,KEY_COMMUNITY,KEY_DISTRICT,KEY_PROVINCE,KEY_TYPE,KEY_CANDIDATE,
		KEY_CORD_X,KEY_CORD_Y,KEY_HEIGHT,KEY_BUILDING_HEIGHT,KEY_ACCESS_DESCRIBE,
		KEY_STATION_DESCRIBE,KEY_PLUS_NUM,KEY_PLAY_NUM,KEY_POWER_STATION_NUMBER,
		KEY_UPDATE_DATE};
	

	public DataBaseHelper(Context context)
	{
		super(context, BASENAME, null, 1);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	/*
	  public void addBook(Book book){
                //for logging
        Log.d("addBook", book.toString()); 
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, book.getTitle()); // get title 
        values.put(KEY_AUTHOR, book.getAuthor()); // get author
 
        // 3. insert
        db.insert(TABLE_BOOKS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
 
        // 4. close
        db.close(); 
    }
	 */
	public ArrayList<Station> getBTS(String keyword,String choose)
	{
		
		ArrayList<Station> result = new ArrayList<Station>();
		int num_col=convertFromSpinner(choose);
		 Log.i("wybor",COLUMNS[num_col]);
		 String cond;
		 if(num_col==0)
		 {
			 cond="";
		 }
		 else
		 {
			 cond=COLUMNS[num_col]+" LIKE '%"+keyword+"%'";
		 }
		// cond=COLUMNS[6]+" LIKE '%"+"nazwa"+"%'";
		SQLiteDatabase db =this.getReadableDatabase();
		Cursor cursor= db.query(TABLE,COLUMNS,cond,
				null,null,null,null);
		Log.i("database","cursor utworzony");
		Log.i("ile wierszy ",cursor.getCount()+"");
		for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
		{
			Log.i("wybor","przebieg petli");
			result.add(makeBTSfromCursor(cursor));
		}
	//	cursor.move
		//Log.i("database result",""+cursor.getString(cursor.getColumnIndex(COLUMNS[0])));
		return result;
	}
	private Station makeBTSfromCursor(Cursor cursor)
	{
		Station station= new Station();
		String bufferTab[]= new String[COLUMNS.length];
		Log.i("tworzenie poj BTS","utwrzono tablice");
		for(int i=0;i<COLUMNS.length;i++)
		{
			Log.i("tworzenie poj BTS","przebieg petli "+i);
			int nr=cursor.getColumnIndex(COLUMNS[i]);
			Log.i("nr kolumny ",""+nr);
			Log.i("wartosc",cursor.getString(nr));
			Log.i("wartosc z tabeli",COLUMNS[i]);
			bufferTab[i]=cursor.getString(cursor.getColumnIndex(COLUMNS[i]));
		}
		Log.i("tworzenie poj BTS","po petli");
		station.setStationNum(bufferTab[1]);
		station.setNetWorksNum(bufferTab[2]);
		station.setPTCNum(bufferTab[3]);
		station.setPTKNum(bufferTab[4]);
		station.setOwner(bufferTab[5]);
		station.setStationName(bufferTab[6]);
		station.setPTCName(bufferTab[7]);
		station.setPTKName(bufferTab[8]);
		station.setRegion(bufferTab[9]);
		station.setArea(bufferTab[10]);
		station.setDeletedData(bufferTab[11]);
		station.setStreet(bufferTab[12]);
		station.setStreetNo(bufferTab[13]);
		station.setZip_Code(bufferTab[14]);
		station.setCity(bufferTab[15]);
		station.setCommunity(bufferTab[16]);
		station.setDistrict(bufferTab[17]);
		station.setProvince(bufferTab[18]);
		station.setType(bufferTab[19]);
		station.setCandidat(bufferTab[20]);
		station.setCordX(bufferTab[21]);
		station.setCordY(bufferTab[22]);
		station.setHeight(bufferTab[23]);
		station.setBuilding_height(bufferTab[24]);
		station.setAccessDescribe(bufferTab[25]);
		station.setStationDescribe(bufferTab[26]);
		station.setPlusNum(bufferTab[27]);
		station.setPlayNum(bufferTab[28]);
		station.setPowerPlantNum(bufferTab[29]);
		station.setUpdatedTime(bufferTab[30]);
		Log.i("tworzenie poj BTS","ukonczono tworzenie bts");
		
		return station;
	}
	private int convertFromSpinner(String input)
	{
		int i;
		
		if(input.equals("numer stacji"))
			i=1;
		else if(input.equals("numer NetWorks"))
			i=2;
		else if(input.equals("numer PTC"))
			i=3;
		else if(input.equals("numer PTK"))
			i=4;
		else if(input.equals("wlasciciel"))
			i=5;
		else if(input.equals("nazwa stacji"))
			i=6;
		else if(input.equals("nazwa PTC"))
			i=7;
		else if(input.equals("nazwa PTK"))
			i=8;
		else if(input.equals("region"))
			i=9;
		else if(input.equals("obszar"))
			i=10;
		else if(input.equals("ulica"))
			i=12;
		else if(input.equals("kod pocztowy"))
			i=14;
		else if(input.equals("miasto"))
			i=15;
		else if(input.equals("gmina"))
			i=16;
		else if(input.equals("powiat"))
			i=17;
		else if(input.equals("wojewodztwo"))
			i=18;
		else
			i=0;
		
		return i;
		
		
		
	}
	
	// 0 PRIMARY_KEY="id"; (ALL)
	// 1 KEY_STATION_NUM="NRStacji";
	// 2 KEY_NETWORKS_NUM="nrNetWorks";
	// 3 KEY_PTC_NUM="nrPTC";
	// 4 KEY_PTK_NUM="nrPTK";
	// 5 KEY_OWMER="wlasciciel";
	// 6 KEY_STATION_NAME="nazwaStacji";
	// 7 KEY_PTC_NAME="nazwaPTC";
	// 8 KEY_PTK_NAME="nazwaPTK";
	// 9 KEY_REGION="region";
	// 10 KEY_AREA="obszar";
	// 11 KEY_DELETED_DATE="dataSkasowania";
	// 12 KEY_STREET="ulica";
	// 13 KEY_STREET_NO="numer";
	// 14 KEY_ZIP_CODE="kodPocztowy";
	// 15 KEY_CITY="miasto";
	// 16 KEY_COMMUNITY="gmina";
	// 17 KEY_DISTRICT="powiat";
	// 18 KEY_PROVINCE="wojewodztwo";
	// 19 KEY_TYPE="typ";
	// 20 KEY_CANDIDATE="kandydat";
	// 21 KEY_CORD_X="wspX";
	// 22 KEY_CORD_Y="wspY";
	// 23 KEY_HEIGHT="wys";
	// 24 KEY_BUILDING_HEIGHT="wysBud";
	// 25 KEY_ACCESS_DESCRIBE="opisDostepu";
	// 26 KEY_STATION_DESCRIBE="opisStacji";
	// 27 KEY_PLUS_NUM="nrPlus";
	// 28 KEY_PLAY_NUM="nrPlay";
	// 29 KEY_POWER_STATION_NUMBER="nrElektrowni";
	// 30 KEY_UPDATE_DATE="dataAktualizacji";
}
