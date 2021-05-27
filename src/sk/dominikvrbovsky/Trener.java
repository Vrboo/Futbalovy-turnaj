package sk.dominikvrbovsky;

import sk.dominikvrbovsky.enums.TrenerskaLicencia;

/**
 * Trieda, ktorá predstavuje trénera tímu na turnaji
 * @author Dominik Vrbovský
 *
 */
public class Trener extends ClenTimu {
	
	/**
	 * Trénerská licencia, ktorou disponuje tréner tímu na turnaju (Licencia A, Licencia B, Licencia C)
	 */
    private TrenerskaLicencia trenerskaLicencia;
    
    /**
     * Konštruktor pre triedu Trener
     * @param meno je meno trénera tímu
     * @param trenerskaLicencia je trénerská licencia, ktorou tréner disponuje
     */
    public Trener(String meno, TrenerskaLicencia trenerskaLicencia) {
        super(meno);
        this.trenerskaLicencia = trenerskaLicencia;
    }
    
    /**
     * Getter na trénerskú licenciu, ktorou tréner disponuje
     * @return trénerská licencia, ktorou tréner disponuje
     */
    public TrenerskaLicencia getTrenerskaLicencia() {
        return this.trenerskaLicencia;
    }
    
    /**
     * Setter na trénerskú licenciu, ktorou tréner disponuje
     * @param trenerskaLicencia je trenérská licencia, ktorou tréner disponuje
     */
    public void setTrenerskaLicencia(TrenerskaLicencia trenerskaLicencia) {
        this.trenerskaLicencia = trenerskaLicencia;
    }
    
    /**
     * Metóda, ktorá vracia textový reťazec informujúci o mene a trénerskej licencii trénera
     * @return
     */
    public String toString() {
    	return String.format(" %s - %s", getMeno(), getTrenerskaLicencia().getStringReprezentacia());
    }
}
