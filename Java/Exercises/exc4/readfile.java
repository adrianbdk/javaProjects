import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ThreadLocalRandom;

public class readfile{
    public static void main(final String[] args) throws IOException {
        try {
            final String seq = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            //IO
            long save_startIO = System.nanoTime();
            writeRandomIO("randomIO.txt", 1000, seq);
            long save_endIO = System.nanoTime();
            readRandomIO("randomIO.txt");
            long endIO = System.nanoTime();

            //NIO
            long save_startNIO = System.nanoTime();
            writeRandomNIO("randomNIO.txt", 1000, seq);
            long save_endNIO = System.nanoTime();
            readRandomNIO("randomNIO.txt");
            long endNIO = System.nanoTime();

            System.out.println("\nIO Load time: " + (save_endIO - save_startIO) + ", IO save time: " + (endIO - save_endIO) + ", IO total time: " + (endIO - save_startIO));
            System.out.println("NIO Load time: " + (save_endNIO - save_startNIO) + ", NIO save time: " + (endNIO - save_endNIO) + ", NIO total time: " + (endNIO - save_startNIO));

        }catch(IOException exc) {
            System.out.println("Error: " + exc.getLocalizedMessage());
            }
        }


        private static char generateRandomChar (String seq){
            return seq.charAt(ThreadLocalRandom.current().nextInt(seq.length()));
        }

        public static void writeRandomIO(String fname, Integer amountChar, final String seq) throws IOException {
        try {

            Writer writer = new FileWriter(fname);
            for (int i = 0; i < amountChar; i++)
                writer.append(generateRandomChar(seq));

            writer.close();
        }catch (Exception exc){
            System.out.println("Couldn't create file " + exc);
            }

        }

        public static void readRandomIO(String fname) throws IOException {
        try {
            Reader reader = new FileReader(fname);
            System.out.print("IO: ");
            while (reader.ready())
                System.out.print(Character.toChars(reader.read()));

        } catch(FileNotFoundException fnf) {
            System.out.println("Couldn't open file " + fnf.getLocalizedMessage());
            }
        }


        public static void writeRandomNIO(String fname, Integer amountChar, String seq) throws IOException {
            try {
                Files.deleteIfExists(Path.of(fname));
                for (int i = 0; i < amountChar; i++)
                    Files.writeString(Path.of(fname), generateRandomChar(seq) + "", StandardOpenOption.APPEND, StandardOpenOption.CREATE);

            }catch (IOException exc){
                System.out.println("Couldn't create file " + exc.getLocalizedMessage());
            }
        }

        public static void readRandomNIO(String fname) throws IOException {
            try {
                byte[] data = Files.readAllBytes(Path.of(fname));
                System.out.print("\n" + "NIO: " + new String(data));

            }catch (IOException exc){
                System.out.println("Couldn't open file " + exc.getLocalizedMessage());
            }
        }

    }

