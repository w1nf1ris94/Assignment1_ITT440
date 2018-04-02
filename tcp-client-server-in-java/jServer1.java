import java.net.*;
import java.io.*;

public class jServer1{
 
  public static void main(String [] args) throws Exception
  {
    ServerSocket serverSock = new ServerSocket(36846);
    System.out.println(" [+] Server are ready... ");
   
    Socket sock = serverSock.accept();
    
    InputStream iStream = sock.getInputStream();
    DataInputStream input = new DataInputStream(iStream);
    
    OutputStream oStream = sock.getOutputStream();
    DataOutputStream output = new DataOutputStream(oStream);   
  
    String msg1 = input.readLine();
    System.out.println(msg1);   
    
    String msg2 = "Waalaikumusalam";
    output.writeBytes(msg2);
    
    String msg3 = input.readLine();
    System.out.println(msg3);   

       

    input.close();
    iStream.close();
  //  sock.close();
    serverSock.close(); 
  }

}
