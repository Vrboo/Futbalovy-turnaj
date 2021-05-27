package sk.dominikvrbovsky.enums;

/**
 * Enum obsahujúci pozície, na ktorých môže hráč v poli hrať
 * @author Dominik Vrbovský
 *
 */
public enum PoziciaHracaVPoli {
	/**
	 * Pozícia útočník
	 */
    UTOCNIK("Útočník"),
    
    /**
     * Pozícia obranca
     */
    OBRANCA("Obranca");
	
	
	
	/**
	 * Textový reťazec reprezentujúci pozíciu hráča v poli ihriska
	 */
    private String poziciaHracaVPoli;
    
    /**
     * Konštruktor pre enum PoziciaHracaVPoli
     * @param poziciaHracaVPoli je pozícia hráča v poli ihriska
     */
    PoziciaHracaVPoli(String poziciaHracaVPoli) {
        this.poziciaHracaVPoli = poziciaHracaVPoli;
    }

    /**
     * Getter na textový reťazec reprezentujúci pozíciu hráča v poli ihriska
     * @return textový reťazec reprezentujúci pozíciu hráča v poli ihriska
     */
    public String getStringReprezentacia() {
        return this.poziciaHracaVPoli;
    }
}
