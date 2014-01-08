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
		tmp.setWspolX(convert(temp[23]));        //!!
		tmp.setWspolY(convert(temp[22]));		 //!!
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
		String tempString;
		BTS temp ;
		int i=0;
		//for( i=0;i<10;i++)
		while(scanner.hasNext())
		{
			tempString=scanner.nextLine();
			tempString=convertFromPolish(tempString);
			temp=readOne(tempString);
			bc.insertIntoBtsTable(temp);
			i++;
			if(i%200==0)
			System.out.println(i);
		
		}
		bc.insertWorkerBtsTable(new Worker("Sebastian","Salat"));
		bc.insertWorkerBtsTable(new Worker("Piotr","Piotrowski"));
		bc.insertWorkerBtsTable(new Worker("Krzysztof","Rymut"));
		bc.insertWorkerBtsTable(new Worker("Rafal","Urbanowicz"));
		
		bc.insertDutyTable(null, null);
		bc.insertDutyTable(null, null);
		bc.insertDutyTable(null, null);
		bc.insertDutyTable(null, null);
		bc.insertDutyTable(null, null);
		
		
		
		bc.insertUpdateDate(null, null, null, null);
		
		
		bc.closeConnection();
		
	}
	private String convertFromPolish(String input)
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

	   public static float convert(String cord)
        {
            Float st = 0f;//stopnie
            Float min = 0f;//minuty
            Float sec = 0f;//sekundy
            String splitedString[];
 
            try
            {
            	splitedString=cord.split("s");//dzielimy kordynaty na przed i po s,
            									//aby wydobyc stopnie
            	cord=splitedString[1];
            	st=Float.parseFloat(splitedString[0]);
            	//System.out.println("stopnie "+st);
                
            }
            catch(Exception e){
            	return 0;
            }
  
            try
            {
            	splitedString=cord.split("-");//wydobywamy minuty w analogicnzy sposob
            	cord=splitedString[1];
            	min=Float.parseFloat(splitedString[0]);
            	//System.out.println("minuty "+st);
            }
            catch(Exception e){
            	return 0;
            }
            	try{
            	sec=Float.parseFloat(splitedString[1]);
            	//System.out.println("sekundy "+st);
            	}
            	 catch(Exception e){
                 	return 0;
                 }	
            
          
            	Float result=st + min/60 + sec/3600;
            	//System.out.println("wynik"+result);
            return (result);		
			
            
        }
}
