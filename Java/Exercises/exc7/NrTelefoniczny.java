class NrTelefoniczny implements Comparable<NrTelefoniczny> {

    private String nrKierunkowy;

    private String nrTelefonu;

    public NrTelefoniczny(String nrKier, String nrTel) throws WrongNumberException {
        if (nrKier.length() != 2)
            throw new WrongNumberException("Area code is wrong");
        if (nrTel.length() != 9)
            throw new WrongNumberException("Telephone number is wrong");
        nrKierunkowy = nrKier;
        nrTelefonu = nrTel;
    }

    @Override
    public int compareTo(NrTelefoniczny nrTel) {
        int compare = nrKierunkowy.compareTo(nrTel.nrKierunkowy);
        if (compare == 0)
            compare = nrTelefonu.compareTo(nrTel.nrTelefonu);

        return compare;
    }

    void info() {
        System.out.print("+" + nrKierunkowy);
        for (int i = 0; i < 9; i += 3)
            System.out.print(" " + nrTelefonu.substring(i, i + 3));
    }
}
