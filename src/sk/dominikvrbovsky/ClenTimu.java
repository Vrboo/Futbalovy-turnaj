package sk.dominikvrbovsky;

/**
 * Predstavuje člena tímu na turnaji
 * @author Dominik Vrbovský
 *
 */
public class ClenTimu {
	
	/**
	 * Meno člena tímu
	 */
    private String meno;
    
    /**
     * Konštruktor pre triedu ClenTimu
     * @param meno je meno člena tímu 
     */
    public ClenTimu(String meno) {
        this.meno = meno;
    }

    /**
     * Getter na meno člena tímu
     * @return meno člena tímu
     */
    public String getMeno() {
        return this.meno;
    }
    
    /**
     * Setter na meno člena tímu na turnaji
     * @param meno je meno člena tímu
     */
    public void setMeno(String meno) {
        this.meno = meno;
    }
}
