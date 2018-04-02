import java.io.*;
import java.net.*;
import java.util.*;

public class jServer{

  public static void main(String[]argv) throws Exception{
  
    String clientMsg1, clientMsg2;
    ServerSocket welcomeSocket = new ServerSocket(36846);
    
    System.out.println("[+] Connected to Socket Successfully\n ");
    
    while(true)
    {
      Socket connSocket = welcomeSocket.accept();
      BufferedReader inClient = new 
BufferedReader (new InputStreamReader(connSocket.getInputStream())); 
      
      DataOutputStream clientOut = new 
DataOutputStream(connSocket.getOutputStream());
      
      System.out.println("[+] Getting Message From Client...\n");

      clientMsg1 = inClient.readLine();
      System.out.println("Message Received: " + clientMsg1);
 
      String sendMsg1, sendMsg2;

      sendMsg1 = "Waalaikumusalam\n";
      clientOut.writeBytes(sendMsg1);
      
      clientMsg2 = inClient.readLine();
      System.out.println("[+] Waiting For Client Another Message\n");
      System.out.println("Message Received: " + clientMsg2);
     
      sendMsg2 = "Are You A Muslim?\n";
      clientOut.writeBytes(sendMsg2);

      connSocket.close();      
      clientOut.close();

    }
  }	

}
