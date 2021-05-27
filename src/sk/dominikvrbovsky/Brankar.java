package sk.dominikvrbovsky;

import sk.dominikvrbovsky.intefaces.Odmenitelny;

/**
 * Treida Brankar predstavuje brankára tímu 
 * @author Dominik Vrbovský
 *
 */
public class Brankar extends Hrac implements Odmenitelny {
	
	/**
	 * Suma, ktorú dostane brankár na konci turnaja za každé čísté konto, ktoré sa mu podarí dosiahnuť
	 */
	private static final double ODMENA_ZA_KAZDE_CISTE_KONTO = 11.5;
	
	/**
	 * Počet čistých kont, ktoré sa brankárovi podarilo dosiahnuť
	 */
    private int pocetCistychKont;
    
    /**
     * Suma, ktorou je brankár na konci turnaja odmenený za počet čistých kont, ktoré sa mu podarilo dosiahnuť
     */
    private double odmenaZaPocetCistychKont;
    
    /**
     * Konštruktor pre triedu Brankar
     * @param meno je meno brankára tímu
     * @param cisloDresu je číslo dresu brankára tímu
     */
    public Brankar(String meno, int cisloDresu) {
        super(meno, cisloDresu);
        this.pocetCistychKont = 0;
        this.odmenaZaPocetCistychKont = 0;
    }
    
    /**
     * Getter na počet čistých kont, ktoré sa brankárovi podarilo dosiahnuť
     * @return
     */
    public int getPocetCistychKont() {
        return this.pocetCistychKont;
    }
    
    /**
     * Setter na počet čistých kont, ktoré sa brankárovi podarilo dosiahnuť
     * @param pocetCistychKont
     */
    public void setPocetCistychKont(int pocetCistychKont) {
        this.pocetCistychKont = pocetCistychKont;
    }
    
    /**
     * Getter na sumu, ktorou je brankár na konci turnaja odmenený za počet čistých kont, ktoré sa mu podarilo dosiahnuť
     * @return
     */
	public double getOdmenaZaPocetCistychKont() {
		return odmenaZaPocetCistychKont;
	}
	
	/**
	 * Setter na sumu, ktorou je brankár na konci turnaja odmenený za počet čistých kont, ktoré sa mu podarilo dosiahnuť
	 * @param odmenaZaPocetCistychKont
	 */
	public void setOdmenaZaPocetCistychKont(double odmenaZaPocetCistychKont) {
		this.odmenaZaPocetCistychKont = odmenaZaPocetCistychKont;
	}
	
	/**
	 * Metóda, ktorá hovorí, že brankárovi sa podarilo dosiahnuť čisté konto 
	 */
	public void vychytajNulu() {
		this.setPocetCistychKont(getPocetCistychKont() + 1);
	}
	
	/**
	 * Metóda, ktorá vypočítá sumu, ktorou by bol brankár odmenený pri aktuálnom počte čistých kont
	 */
	@Override
	public double vypocitajOdmenu() {
		return this.ODMENA_ZA_KAZDE_CISTE_KONTO * this.pocetCistychKont;
	}
	
	/**
	 * Metóda, ktorá hovorí akou sumou je brankár odmenený na konci turnaja
	 */
	@Override
	public void odmenit() {
		this.setOdmenaZaPocetCistychKont(vypocitajOdmenu());
	}
	
	/**
	 * Metóda, ktorá vracia textový reťazec informujúci o sume, ktorou je brankár odmenený na konci turnaja
	 */
	@Override
	public String toStringKonecnaOdmena() {
		return String.format(" %s - %.2f€", getMeno(), getOdmenaZaPocetCistychKont());
	}
	
	/**
	 * Metóda, ktorá vracia textový reťazec informujúci o sume, ktorou by bol brankár odmenený pri aktuálnom počte čistých kont
	 */
	@Override
	public String toStringPriebeznaOdmena() {
		return String.format(" %s - %.2f€", getMeno(), vypocitajOdmenu());
	}
	
	
	
	
	
	

	
    
    
}
