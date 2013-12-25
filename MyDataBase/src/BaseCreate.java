import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class BaseCreate {
	
	public static final String DRIVER="org.sqlite.JDBC";
	public static final String DB_URL="jdbc:sqlite:base.db";
	private Connection connection;
	private Statement stat;
	
	public BaseCreate() throws Exception
	{
		try {
			Class.forName(this.DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(DB_URL);
			stat=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(createTables()==false)throw new Exception("nie udalo sie utworzyc tabel");
		
		
	}
	private boolean createTables()
	{
		String BTSTable="CREATE TABLE IF NOT EXISTS Bts" +
				" (id INTEGER PRIMARY KEY AUTOINCREMENT," +
				" NRStacji varchar(10)," +
				" nrNetWorks varchar(10)," +
				" nrPTC varchar(10)," +
				" nrPTK varchar(10)," +
				" wlasciciel varchar(20)," +
				" nazwaStacji varchar(40)," +
				" nazwaPTC varchar(40)," +
				" nazwaPTK varchar(40)," +
				" region varchar(15)," +
				" obszar varchar(15)," +
				" dataSkasowania varchar(15)," +
				" ulica varchar(20)," +
				" numer varchar(8)," +
				"kodPocztowy varchar(20)," +
				"miasto varchar(30)," +
				"gmina varchar(30)," +
				"powiat varchar(30)," +
				"wojewodztwo varchar(30)," +
				"typ varchar(30)," +
				"kandydat varchar(30)," +
				"wspX varchar(10)," +
				"wspY varchar(10)," +
				"wys REAL," +
				"wysBud REAL," +
				"opisDostepu varchar(50)," +
				"opisStacji varchar(50)," +
				"nrPlus varchar(20)," +
				"nrPlay varchar(20)," +
				"dataAktualizacji DATE DEFAULT (DATETIME('now') ) );";
				try {
					stat.execute(BTSTable);
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
					return false;
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
	public boolean insertIntoBtsTable(BTS bts)
	{
		
		
		String order1="INSERT INTO Bts (NRStacji,nrNetWorks,nrPTC,nrPTK,wlasciciel," +
					  "nazwaStacji,nazwaPTC,nazwaPTK,region,obszar,dataSkasowania," +
					  "ulica,numer,kodPocztowy,miasto,gmina,powiat,wojewodztwo,typ," +
					  "kandydat,wspX,wspY,wys,wysBud,opisDostepu,opisStacji,nrPlus,nrPlay)" +
					  " VALUES(" +
					  "\""+bts.getNrStacji()+" \" ," +
					  " \" "+bts.getNrNetWorks()+" \" ," +
					  " \"  "+bts.getNrPTC()+" \"," +
					  "\" "+bts.getNrPTK()+"\" , " +
					  "\" "+bts.getOwner()+" \"," +
					  " \" "+bts.getNazwaStacji()+"\" ," +
					  " \"  "+bts.getNazwaPTC()+" \", "+
					  " \" "+bts.getNazwPTK()+" \","+
					  " \" "+bts.getRegion()+" \" ," +
					  " \" "+bts.getObszar()+"\" ,"+
					  " \" "+bts.getDataSkasowania()+" \" ," +
					  " \" "+bts.getUlica()+" \" ," +
					  " \" "+bts.getNr()+" \" ," +
					  " \" "+bts.getKodPocztowy()+" \" ," +
					  " \" "+bts.getMiasto()+" \" ," +
					  " \" "+bts.getGmina()+" \" ," +
					  " \" "+bts.getPowiat()+" \" ," +
					  " \" "+bts.getWojewodztwo()+" \" ," +
					  " \" "+bts.getTyp()+" \" ," +
					  " \" "+bts.getKandydat()+" \" ," +
					  " \" "+bts.getWspolX()+" \" ," +
					  " \" "+bts.getWspolY()+" \", " +
					  checIsNumber(bts.getWysNadPomMorz())+ "," +
					  checIsNumber(bts.getWysBud())+ "," +
					  " \" "+bts.getOpisDost()+" \", " +
					  " \" "+bts.getOpisStacji()+" \", " +
					  " \" "+bts.getNrPlus()+" \", " +
					  " \" "+bts.getNrPlay()+" \" " +
					  " );";
					
					try {
						Statement temp=connection.createStatement();
						temp.executeUpdate(order1);
						//temp.closeOnCompletion();
						return true;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}
	}
	 public void closeConnection() {
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            System.err.println("Problem z zamknieciem polaczenia");
	            e.printStackTrace();
	        }
	    }


	

}
