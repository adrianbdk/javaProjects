import java.io.IOException;

public class substring {
    public static void main(String[] args) throws IOException {
        try {
            if (args.length < 3) {
                System.out.println("Not enough data");
                System.exit(1);
            }
            int first, second;
            String txt = args[0];
            first = Integer.parseInt(args[1]);
            second = Integer.parseInt(args[2]);

            if (first < 0 || second < first || second > txt.length()) {
                System.out.println("Incorrect input");
                System.exit(1);
            }
            System.out.println(txt.substring(first, second + 1));
        } catch (NumberFormatException nfe) {
            System.out.println("ERROR -> " + nfe.getLocalizedMessage());
        }
    }
}
