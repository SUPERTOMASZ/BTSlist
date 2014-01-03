import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class BaseRead {
	
	private FileInputStream fileIn;
	private BaseCreate bc;
	public BaseRead()
	{
		try {
			this.fileIn= new FileInputStream(new File("baza.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.bc= new BaseCreate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private BTS readOne(String input)
	{
		//System.out.println(input);
		String temp[]=new String [33];
		String tmpString="";
		for(int i=0;i<temp.length-1;i++)
		{
			tmpString = input.substring(0, input.indexOf(";"));
			//System.out.println("wpisywany "+tmpString);
			temp[i]=tmpString;
			input=input.substring(input.indexOf(";")+1);
			//System.out.println("tymczasowy "+input);
			
		}
		temp[32]=input;
		BTS tmp = new BTS();
		tmp.setNrStacji(temp[0]);
		tmp.setNrNetWorks(temp[1]);
		tmp.setNrPTC(temp[2]);
		tmp.setNrPTK(temp[3]);
		tmp.setOwner(temp[4]);
		tmp.setNazwaStacji(temp[5]);
		tmp.setNazwaPTC(temp[6]);
		tmp.setNazwPTK(temp[7]);
		tmp.setRegion(temp[8]);
		tmp.setObszar(temp[9]);
		tmp.setTopListy(temp[10]);
		tmp.setDataSkasowania(temp[11]);
		tmp.setUlica(temp[12]);
		tmp.setNr(temp[13]);
		tmp.setKodPocztowy(temp[14]);
		tmp.setMiasto(temp[15]);
		tmp.setGmina(temp[16]);
		tmp.setPowiat(temp[17]);
		tmp.setWojewodztwo(temp[18]);
		tmp.setUlicaInaczej(temp[19]);
		tmp.setTyp(temp[20]);
		tmp.setKandydat(temp[21]);
		tmp.setWspolX(convert(temp[22]));        //!!
		tmp.setWspolY(convert(temp[23]));		 //!!
		tmp.setWysNadPomMorz(temp[24]);
		tmp.setWysBud(temp[25]);
		tmp.setZagiel(temp[26]);
		tmp.setOpisDost(temp[27]);
		tmp.setOpisStacji(temp[28]);
		tmp.setNrPlus(temp[29]);
		tmp.setNrPlay(temp[30]);
		tmp.setRainbowSite(temp[31]);
		tmp.setFiltr(temp[32]);
		return tmp;
		
		
		
	}
	public void read()
	{
		
		Scanner scanner = new Scanner(fileIn);
		BTS temp ;
		int i=0;
		while(scanner.hasNext())
		{
			temp=readOne(scanner.nextLine());
			bc.insertIntoBtsTable(temp);
			i++;
			System.out.println(i);
		
		}
		
		bc.closeConnection();
		
	}

	   public static String convert(String cord)
        {
            Float st = 0f;
            Float min = 0f;
            Float sec = 0f;
            
            String temp[] = cord.split("s");
            try
            {
                st = Float.parseFloat(temp[0]);
            }
            catch(Exception e){}
            String temp1[] = temp[1].split("-");
            try
            {
                min = Float.parseFloat(temp1[0]);
            }
            catch(Exception e){}
            try
            {
                sec = Float.parseFloat(temp1[1]);
            }
            catch(Exception e){}
            
            Float result = st + min/60 + sec/3600;
            String res = result.toString();
             
            return res;		
			
			//jesli ma zwracać Float to wstawić
			//if (res.length()>10)            
            //    result = Float.parseFloat(res);
			//return result;
        }
}
