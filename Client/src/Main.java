import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import Data.Station;
import Ftp.Connect;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		URL url;
		new Connect(); 
		//new MainFrame(800, 600);
		//new IntroFrame(400,600);
		
		ArrayList <Station> stations= new ArrayList<Station>();
			Station station = new Station();
			station.setName("Michal");
			Station station2 = new Station();
			station2.setName("Michal2");
			stations.add(station);
			stations.add(station2);
			ObjectMapper mapper = new ObjectMapper();
			try {
				
				mapper.writeValue(new File("user.json"), stations);
	
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			ObjectMapper mapper1 = new ObjectMapper();
			 
			try {
		 
				// read from file, convert it to user class
				User user = mapper1.readValue(new File("user.json"), Station.class);
		 
				// display to console
				System.out.println(user);
		 
			} catch (JsonGenerationException e) {
		 
				e.printStackTrace();
		 
			} catch (JsonMappingException e) {
		 
				e.printStackTrace();
		 
			} catch (IOException e) {
		 
				e.printStackTrace();
		 
			}
			*/
		

	}

}
