import java.net.URL;

import DataBase.InitThread;
import Ftp.Connect;
import GUI.IntroFrame;
import JSON.JSONMain;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		IntroFrame intro= new IntroFrame(300,400);
		InitThread thread = new InitThread(intro);
		thread.start();
	}

}
