import java.net.*;
import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Client {

  private Socket clientSocket;
  private PrintWriter out;
  private BufferedReader in;

  public void startConnection(String ip, int port) throws IOException {
    try {
      while (true) {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        break;
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    }
  }

  public void stopConnection() {
    try {
      in.close();
      out.close();
      clientSocket.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void checkTime(LocalTime time) throws WrongTimeException {
    if (time.isBefore(LocalTime.now())) throw new WrongTimeException("It's already after " + time);
  }

  public void sendMessage(String msg) {
    try {
      out.println(msg);
    } catch (Exception exc) {
      System.out.println("ERROR - " + exc);
    }
  }

  public static void main(String[] args) throws IOException {
    Client client = new Client();
    client.startConnection("127.0.0.1", 6666);
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your message: ");
    String notification = input.nextLine();
    while (true) {
      try {
        DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern("H:mm:ss");
        System.out.print("Enter when you want to send your message: ");
        String timeString = input.nextLine();
        LocalTime time = LocalTime.parse(timeString, parseFormat);
        checkTime(time);
        client.sendMessage(notification);
        client.sendMessage(timeString);
        break;
      } catch (WrongTimeException e) {
        System.out.println(e.getMessage());
      } catch (DateTimeParseException e) {
        System.out.println("Incorrect date");
      }
    }
    try {
      System.out.println(client.in.readLine());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    client.stopConnection();
    input.close();
  }
}

class WrongTimeException extends Exception {
  public WrongTimeException(String exc) {
    super(exc);
  }
}
