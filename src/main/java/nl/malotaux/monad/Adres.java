package nl.malotaux.monad;

public class Adres {
    private final String Straat;
    private final String huisnummer;
    private final String plaats;

    public Adres(String straat, String huisnummer, String plaats) {
        Straat = straat;
        this.huisnummer = huisnummer;
        this.plaats = plaats;
    }

    public String getStraat() {
        return Straat;
    }
}
