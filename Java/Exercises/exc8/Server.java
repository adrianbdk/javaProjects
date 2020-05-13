import com.github.javafaker.Faker;

import java.net.*;
import java.io.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class Server {
  private ServerSocket serverSocket;

  public static void main(String[] args) throws IOException {
    Server server = new Server();
    server.start(6666);
  }

  public void start(int port) throws IOException {
    try {
      serverSocket = new ServerSocket(port);
      while (true) new ClientHandler(serverSocket.accept()).start();
    } catch (Exception exc) {
      System.out.println("ERROR - " + exc.getMessage());
    }
  }

  public void stop() throws IOException {
    try {
      serverSocket.close();
    } catch (Exception exc) {
      System.out.println("ERROR - " + exc.getMessage());
    }
  }

  private static class ClientHandler extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
      this.clientSocket = socket;
    }

    public void KillConnection() {
      try {
        in.close();
        out.close();
        clientSocket.close();
      } catch (IOException exc) {
        System.out.println("ERROR - " + exc);
      }
    }

    public String randomName() {
      Faker faker = new Faker();
      return faker.elderScrolls().firstName();
    }

    public void run() {
      try {
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        int Random = ThreadLocalRandom.current().nextInt(1, 99);

        String message = in.readLine();
        String time = in.readLine();

        Thread.sleep(Duration.between(LocalTime.now(), LocalTime.parse(time)).toMillis());
        out.println(randomName() + ": " + time + ": " + message);

        KillConnection();
      } catch (IOException | InterruptedException exc) {
        System.out.println("ERROR - " + exc.getMessage());
      }
    }
  }
}
