import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class zad5 {
  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter path: ");
    String path = input.next();
    try{
        Writer writer = new FileWriter("zadanie5/paths.txt", true);
        writer.write(path+"\n");
        writer.close();
    }
    catch (IOException exc){
      System.out.println("No such file");
      return;
    }

    try{
      Reader reader = new FileReader(path);
      while(reader.ready()){
        System.out.print("\nPress any key... ");
        char key = input.next().charAt(0);
        int Random = ThreadLocalRandom.current().nextInt(1,6);
        for(int i = 0; i < Random; i++){
          if(!reader.ready())
            break;
            System.out.print((char) reader.read());
        }
      }
      System.out.println("\nEnd of file");
      reader.close();
      input.close();
    }
    catch(IOException exc){
      System.out.println("ERROR.");
    }
  }


}
