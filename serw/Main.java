package simpleserver;
 
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
 
         ServerSocket s = new ServerSocket(4444);   
         Socket s1=null;
      
                 
         while (true)
         {
             s1=s.accept();
             System.out.println("Po³¹czono: "+s1.toString()+"\n");
             SerialServer nowy=  new SerialServer(s1);
             nowy.start();
         }
    }
}