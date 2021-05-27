package sk.dominikvrbovsky;

/**
 * Trieda Hrac predstavuje hráča tímu na turnaji
 * @author Dominik Vrbovský
 *
 */
public class Hrac extends ClenTimu {
	
	/**
	 * Číslo dresu hráča
	 */
    private int cisloDresu;

    /**
     * Konštruktor pre triedu Hrac
     * @param meno je meno hráča
     * @param cisloDresu je číslo dresu hráča
     */
    public Hrac(String meno, int cisloDresu) {
        super(meno);
        this.cisloDresu = cisloDresu;
    }

    /**
     * Getter na číslo dresu hráča
     * @return číslo dresu hráča
     */
    public int getCisloDresu() {
        return this.cisloDresu;
    }

    /**
     * Setter na číslo dresu hráča
     * @param cisloDresu je číslo dresu hráča
     */
    public void setCisloDresu(int cisloDresu) {
        this.cisloDresu = cisloDresu;
    }
    
    /**
     * Metóda, ktorá vracia textový reťazec s menom a číslom dresu hráča
     */
    public String toString() {
    	return String.format("%s - číslo dresu: %d", getMeno(), getCisloDresu());
    }
}
