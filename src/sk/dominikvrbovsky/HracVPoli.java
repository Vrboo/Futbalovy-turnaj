package sk.dominikvrbovsky;

import sk.dominikvrbovsky.enums.PoziciaHracaVPoli;

/**
 * Trieda HracVPoli predstavuje hráča tímu, ktorý je v poli ihriska, nie v bráne 
 * @author Dominik Vrbovský
 *
 */
public class HracVPoli extends Hrac {
	
	/**
	 * Pozícia, na ktorej hráč v poli ihriska hrá (Útočník alebo Obranca)
	 */
    private PoziciaHracaVPoli pozicia;
    
    /**
     * Konštruktor pre triedu HracVPoli
     * @param meno je meno hráča v poli ihriska
     * @param cisloDresu je číslo dresu hráča v poli ihriska
     * @param pozicia je pozícia, na ktorej hráč v poli ihriska hrá
     */
    public HracVPoli(String meno, int cisloDresu, PoziciaHracaVPoli pozicia) {
        super(meno, cisloDresu);
        this.pozicia = pozicia;
    }
    
    /**
     * Getter na pozíciu hráča v poli ihriska
     * @return pozícia hráča v poli ihriska
     */
    public PoziciaHracaVPoli getPozicia() {
        return this.pozicia;
    }

    /**
     * Setter na pozíciu hráča v poli ihriska
     * @param pozicia je pozícia, na ktorej hráč v poli ihriska hrá
     */
    public void setPozicia(PoziciaHracaVPoli pozicia) {
        this.pozicia = pozicia;
    }
    
    /**
     * Metóda, ktorá vracia textový reťazec informujúci o mene, čísle dresu a pozícií hráča v poli ihriska
     */
	@Override
	public String toString() {
		return super.toString() + " - " + getPozicia().getStringReprezentacia();
	}
    
    
}
