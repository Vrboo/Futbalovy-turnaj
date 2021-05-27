package sk.dominikvrbovsky.enums;

/**
 * Enum obsahujúci hodnoty trénerských licencii, ktorými môžu tréneri disponovať
 * @author Dominik Vrbovský
 *
 */
public enum TrenerskaLicencia {
	/**
	 * Trénerská licencia s názvom Licencia A
	 */
    LICENCIA_A("Licencia A"),
    
    /**
	 * Trénerská licencia s názvom Licencia B
	 */
    LICENCIA_B("Licencia B"),
    
    /**
	 * Trénerská licencia s názvom Licencia C
	 */
    LICENCIA_C("Licencia C");
	
	
	
	/**
	 * Textový reťazec reprezentujúci trénerskú licenciu
	 */
    private String trenerskaLicencia;
    
    /**
     * Konštruktor pre enum TrenerskaLicencia
     * @param trenerskaLicencia je trénerska licencia, ktorou môže tréner tímu disponovať
     */
    TrenerskaLicencia(String trenerskaLicencia) {
        this.trenerskaLicencia = trenerskaLicencia;
    }
    
    /**
     * Getter na textový reťazec reprezentujúci trénersku licenciu
     * @return
     */
    public String getStringReprezentacia() {
        return this.trenerskaLicencia;
    }
    
    /**
     * Metóda, ktorá na základe textového výrazu na vstupe, vráti hodnotu enumu TrenerskaLicencia
     * @param string je textový výraz, na základe ktoré sa má vytvoriť hodnota enumu TrenerskaLicencia
     * @return hodnota enumu TrenerskaLicencia
     */
    public static TrenerskaLicencia getEnumFromString(String string) {
    	for (TrenerskaLicencia trenerskaLicencia : TrenerskaLicencia.values()) {
    		if (trenerskaLicencia.getStringReprezentacia().equals(string)) 
    			return trenerskaLicencia;
    	}
    	return null;
    }


}
