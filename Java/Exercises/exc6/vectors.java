import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class WektoryRoznejDlugosciException extends Exception {
  public WektoryRoznejDlugosciException(String error) {
    super(error);
  }
}

public class vectors {
  public static void main(String[] args) throws IOException, WektoryRoznejDlugosciException {
    Scanner input = new Scanner(System.in);

    try {
      System.out.println("Enter first vector: ");
      String first = input.nextLine();
      final var vect1 =
          Arrays.stream(first.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

      System.out.println("Enter second vector: ");
      String second = input.nextLine();
      final var vect2 =
          Arrays.stream(second.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

      System.out.println(addVector(vect1, vect2));

    } catch (NumberFormatException nfe) {
      System.out.println("Incorrect input! " + nfe.getMessage());
    }
  }

  public static List<Integer> addVector(List<Integer> vec1, List<Integer> vec2)
      throws WektoryRoznejDlugosciException {

    if (vec1.size() != vec2.size()) {
      throw new WektoryRoznejDlugosciException(
          "Vectors are not equal!\n"
              + "size of first vec: "
              + vec1.size()
              + "\nsize of second vec: "
              + vec2.size());
    }

    return IntStream.range(0, vec1.size())
        .map(i -> (vec1.get(i) + vec2.get(i)))
        .boxed()
        .collect(Collectors.toList());
  }
}
