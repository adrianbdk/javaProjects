abstract public class Wpis {

    private NrTelefoniczny nrTel;

    abstract void opis();

    public NrTelefoniczny getNrTel() {
        return nrTel;
    }

    public void setNrTel(NrTelefoniczny nrTel) {
        this.nrTel = nrTel;
    }
}
