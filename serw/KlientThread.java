package com.example.klient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import android.util.Log;

public class KlientThread extends Thread
{
 
 private ObjectOutputStream objout;
 private ObjectInputStream objin;
 private String ip;
 private int port;
 private MainActivity main;
 
 public KlientThread(String ip, int port, MainActivity main)
    {
	 	this.ip = ip;
	 	this.port=port;
	 	this.main=main;
    }
       
    public void run()
    {
    	Log.i("", "v");
    	try
          {
              Socket klient = new Socket(ip, port);
              objout=new ObjectOutputStream(klient.getOutputStream());
              objout.flush();
              objin=new ObjectInputStream(klient.getInputStream());
          }
          catch(IOException e)
          {
              e.printStackTrace();
          }
    
        Object o = null;
        while(true)
        {
            try
            {
            	Log.i("", "y");
                o=objin.readObject();
                recive(o);
            }
            catch(IOException e)
            {
            	Log.i("", e.toString());
            	
            }
            catch (ClassNotFoundException ex)
            {
            	Log.i("", ex.toString());
            	
            }
            catch(Exception e)
            {
            	Log.i("", e.toString());
            	
            }
        	finally
            {
            	try {
					objout.close();
					} catch (IOException e) {}
            }
        }
        
    }
    
    public void recive(Object x)
    {
    	try
    	{
    		Log.i("", x.toString());
    		objout.flush();
    		
    	}
    	catch(Exception e)
    	{
    		  /// main.textField.setText("q");
    		    	
       	}
    }
    
    public void send(Object w1) 
    {
       try
       {
           objout.writeObject(w1);
       }
       catch(Exception e)
       {
    	   Log.i("", e.toString());   
       }
    }
    
 
            
}
