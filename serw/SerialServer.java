package simpleserver;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class SerialServer extends Thread
{
    private Socket channel;
    private ObjectOutputStream objout;
    private ObjectInputStream objin;
    private Window window;

  
    
      public SerialServer(Socket channel)
    {
        this.channel=channel;
        try
        {
            objout = new ObjectOutputStream(channel.getOutputStream());   
            objout.flush();
            objin = new ObjectInputStream(channel.getInputStream());
        }
        catch(Exception e){}
    }

    public void run()
    {
        Object o=null;
        while(true)
        {
            try 
                {              
                    o=objin.readObject();
                    recive(o);
                    
                    
                } 
                catch (IOException ex) 
                {
                    System.out.print("IO\n");
                    try {
                        objout.close();
                        } catch 
                                (IOException ex1) {
                   
                }
                    this.stop();
                }
                catch (ClassNotFoundException ex)
                {
                    System.out.print("Z³a klasa\n");
                }
                catch(Exception e)
                {
                    System.out.println(e.toString());
                }
        }
    }

    public void send(Object w1) 
    {
       try
       {
            objout.writeObject(w1);
            objout.flush();
       }
       catch(IOException e){}
    }
    
    private void recive(Object o) 
    {
        System.out.println(o.toString());  
    }
}