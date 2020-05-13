class Osoba extends Wpis {

    private String name;
    private String surname;

    public Osoba(NrTelefoniczny O_nrTel, String O_name, String O_surname) {
        name = O_name;
        surname = O_surname;
        super.setNrTel(O_nrTel);
    }

    void opis() {
        super.getNrTel().info();
        System.out.println(" " + name + " " + surname);
    }
}
