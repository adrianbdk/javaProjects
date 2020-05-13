import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String... args) throws IOException, WrongNumberException {

        try {

            Firma Comp1 = new Firma(new NrTelefoniczny("48", "510555666"), "X-Kom");
            Firma Comp2 = new Firma(new NrTelefoniczny("49", "510777888"), "Zabka");
            Firma Comp3 = new Firma(new NrTelefoniczny("51", "510999101"), "Allegro");

            Osoba pers1 = new Osoba(new NrTelefoniczny("52", "510102103"), "Nikodem", "Braun");
            Osoba pers2 = new Osoba(new NrTelefoniczny("53", "510104106"), "Tymoteusz", "Adamczyk");

            TreeMap<NrTelefoniczny, Wpis> PhoneBook = new TreeMap<>();

            PhoneBook.put(Comp1.getNrTel(), Comp1);
            PhoneBook.put(Comp2.getNrTel(), Comp2);
            PhoneBook.put(Comp3.getNrTel(), Comp3);

            PhoneBook.put(pers1.getNrTel(), pers1);
            PhoneBook.put(pers2.getNrTel(), pers2);


            for (Map.Entry<NrTelefoniczny, Wpis> entry : PhoneBook.entrySet()) {
                System.out.println("Key: " + entry.getKey());
                entry.getValue().opis();
            }

        } catch (WrongNumberException exc) {
            System.out.println(exc.getMessage());
        }
    }
}

class WrongNumberException extends Exception {
    public WrongNumberException(String exc) {
        super(exc);
    }
}