class Firma extends Wpis {

    private String CompanyName;

    public Firma(NrTelefoniczny F_nrTel, String F_CompanyName) {
        super.setNrTel(F_nrTel);
        CompanyName = F_CompanyName;

    }

    void opis() {
        super.getNrTel().info();
        System.out.println(" " + CompanyName);
    }
}