import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
*  Email Client SMTP Program.
*  Receives necessary email input from the keyboard or file
*  Stores them in separate variables.
*  Connects to a SMTP Server.
*  Waits for a starting message from the server.
*  Sends an introductory command to the server.
*  Receives a response from the server and displays it.
*  Sends a MAIL FROM command to the server.
*  Receives a second response from the server and displays it.
*  Sends a RCPT TO command to the server.
*  Receives a third response from the server and displays it.
*  Sends a DATA command to the server.
*  Receives a fourth response from the server and displays it.
*  Sends an email message to the server.
*  Sends a . to indicate message end to the server.
*  Receives a fifth response from the server and displays it.
*  Sends a QUIT command to the server.
*  Closes the socket and exits.
*
*  author: Lisa Pham
*  Email:  thupham@chapman.edu
*  Date:  2/23/2021
*  version: 1.0
*/

class Email {

  public static void main(String[] argv) throws Exception {
    // Get user input
    BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("From: ");
    final String senderAdr = inFromUser.readLine();

    System.out.print("To: ");
    final String receiverAdr = inFromUser.readLine();

    System.out.print("Sender: ");
    final String senderName = inFromUser.readLine();

    System.out.print("Receiver: ");
    final String receiverName = inFromUser.readLine();

    System.out.print("Subject: ");
    final String subject = inFromUser.readLine();

    System.out.print("Message Body: ");
    String str = "";
    String body = "";
    while ((str=inFromUser.readLine())!= null) {
      body += str + "\n";
    }

    // Finished getting user input
    System.out.println();

    // Connect to the server
    Socket clientSocket = null;

    try {
      clientSocket = new Socket("smtp.chapman.edu", 25);
      System.out.println("Connected to server.");
    } catch (Exception e) {
      System.out.println("Failed to open socket connection");
      System.exit(0);
    }
    PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader inFromServer =  new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));

    System.out.println("Starting messages. \n");

    // Exchange messages with the server
    String welcome = inFromServer.readLine();
    System.out.println("FROM SERVER:" + welcome);
    System.out.println();

    String hello = "HELO icd.chapman.edu";
    System.out.println("FROM CLIENT:" + hello);
    outToServer.println(hello);
    String sHello = inFromServer.readLine();
    System.out.println("FROM SERVER:" + sHello);
    System.out.println();

    String mailFrom = "MAIL FROM: " + senderAdr;
    System.out.println("FROM CLIENT:" + mailFrom);
    outToServer.println(mailFrom);
    String sMailFrom = inFromServer.readLine();
    System.out.println("FROM SERVER:" + sMailFrom);
    System.out.println();

    String mailTo = "RCPT TO: " + receiverAdr;
    System.out.println("FROM CLIENT:" + mailTo);
    outToServer.println(mailTo);
    String sMailTo = inFromServer.readLine();
    System.out.println("FROM SERVER:" + sMailTo);
    System.out.println();

    String data = "DATA";
    System.out.println("FROM CLIENT:" + data);
    outToServer.println(data);
    String sData = inFromServer.readLine();
    System.out.println("FROM SERVER:" + sData);
    System.out.println();

    String line1 = "To: " + receiverName + " (" + receiverAdr + ")";
    System.out.println("FROM CLIENT:" + line1);
    outToServer.println(line1);

    String line2 = "From: " + senderName + " (" + senderAdr + ")";
    System.out.println("FROM CLIENT:" + line2);
    outToServer.println(line2);

    String line3 = "Subject: " + subject;
    System.out.println("FROM CLIENT:" + line3);
    outToServer.println(line3);

    String line4 = body;
    System.out.println("FROM CLIENT:\n\n" + line4);
    outToServer.println(line4);

    System.out.println("FROM CLIENT: .");
    outToServer.println(".");
    String sEnd = inFromServer.readLine();
    System.out.println("FROM SERVER:" + sEnd);
    System.out.println();

    String quit = "QUIT";
    System.out.println("FROM CLIENT:" + quit);
    outToServer.println(quit);
    String sQuit = inFromServer.readLine();
    System.out.println("FROM SERVER:" + sQuit);
    System.out.println();

    // Close the socket connection
    clientSocket.close();
  }
}
