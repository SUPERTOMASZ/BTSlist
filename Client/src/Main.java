import java.net.URL;

import GUI.IntroFrame;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		URL url;
		new IntroFrame(100,200);
		
		/*
			String login="developer@btsmaintenancesystem.cba.pl";
			String pass="atem44";
			String protocol="ftp://";
			String host ="btsmaintenancesystem.cba.pl";
			FTPClient ftpClient = new FTPClient();
			try {
				ftpClient.connect("btsmaintenancesystem.cba.pl");
				ftpClient.login(login, pass);
				FTPFile[] temp=ftpClient.listFiles();
				for(int i=0;i<temp.length;i++)
				System.out.println(temp[i].getName());
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		/*
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
