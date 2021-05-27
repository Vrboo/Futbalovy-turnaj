package sk.dominikvrbovsky;

/**
 * Trieda Zapas predstavuje zápas na turnaji 
 * @author Dominik Vrbovský
 *
 */
public class Zapas {
	
	/**
	 * Domáci tím zápasu
	 */
    private Tim tim1;
    
    /**
     * Hosťujúci tím zápasu
     */
    private Tim tim2;
    
    /**
     * Počet gólov strelených domácim tímom (Počet gólov, ktoré strelil domáci tím)
     */
    private int pocetGolovTim1;
    
    /**
     * Počet gólov strelených hosťujúcim tímom (Počet gólov, ktoré strelil hosťujúci tím)
     */
    private int pocetGolovTim2;

    
    /**
     * Konštruktor pre triedu Zapas
     * @param tim1 je domáci tím zápasu
     * @param tim2 je hosťujúci tím zápasu
     */
    public Zapas(Tim tim1, Tim tim2) {
        this.tim1 = tim1;
        this.tim2 = tim2;
        this.pocetGolovTim1 = - 1;
        this.pocetGolovTim2 = - 1;
    }
    
    /**
     * Getter na domáci tím zápasu
     * @return domáci tím zápasu
     */
	public Tim getTim1() {
		return this.tim1;
	}
	
	/**
	 * Setter na domáci tím zápasu
	 * @param tim1
	 */
	public void setTim1(Tim tim1) {
		this.tim1 = tim1;
	}
	
	/**
	 * Getter na hosťujúci tím zápasu
	 * @return hosťujúci tím zápasu
	 */
	public Tim getTim2() {
		return tim2;
	}
	
	/**
	 * Setter na hosťujúci tím zápasu
	 * @param tim2 hosťujúci tím zápasu
	 */
	public void setTim2(Tim tim2) {
		this.tim2 = tim2;
	}

	/**
	 * Getter na počet golóv strelených domácim tímom zápasu
	 * @return počet golóv strelených domácim tímom zápasu
	 */
	public int getPocetGolovTim1() {
		return pocetGolovTim1;
	}
	
	/**
	 * Setter na počet golóv strelených domácim tímom zápasu
	 * @param pocetGolovTim1 počet golóv strelených domácim tímom zápasu
	 */
	public void setPocetGolovTim1(int pocetGolovTim1) {
		this.pocetGolovTim1 = pocetGolovTim1;
	}
	
	/**
	 * Getter na počet golóv strelených hosťujúcim tímom zápasu
	 * @return počet golóv strelených hosťujúcim tímom zápasu
	 */
	public int getPocetGolovTim2() {
		return pocetGolovTim2;
	}
	
	/**
	 * Setter na počet golóv strelených hosťujúcim tímom zápasu
	 * @param pocetGolovTim2 počet golóv strelených hosťujúcim tímom zápasu
	 */
	public void setPocetGolovTim2(int pocetGolovTim2) {
		this.pocetGolovTim2 = pocetGolovTim2;
	}
	
	/**
	 * Metóda, ktorá simuluje odohratie zápasu a podľa jeho výsledku sa aktualizujú štatistiky oboch tímov
	 */
    public void odohrajZapas() {
    	
    	this.pocetGolovTim1 = (int) (Math.random()*(6-0)) + 0; 
    	this.pocetGolovTim2 = (int) (Math.random()*(6-0)) + 0;
    		
    		
    	if (this.pocetGolovTim1 > this.pocetGolovTim2) {
        	this.tim1.vyhratZapas(pocetGolovTim1, pocetGolovTim2);
        	this.tim2.prehratZapas(pocetGolovTim2, pocetGolovTim1);
        } else if (this.pocetGolovTim1 < this.pocetGolovTim2) {
        	this.tim2.vyhratZapas(pocetGolovTim2, pocetGolovTim1);
        	this.tim1.prehratZapas(pocetGolovTim1, pocetGolovTim2);
       	} else {
        	this.tim2.remizovatZapas(pocetGolovTim2, pocetGolovTim1);
        	this.tim1.remizovatZapas(pocetGolovTim1, pocetGolovTim2);
        }
    	
    	if (getPocetGolovTim1() == 0) {
    		this.tim2.getBrankar().vychytajNulu();
    	}
    	
    	if (getPocetGolovTim2() == 0) {
    		this.tim1.getBrankar().vychytajNulu();
    	}
    }
    
    /**
     * Metóda, ktorá vracia textový reťazec informujúci o názvoch timov a výsledku zápasu
     * @return textový reťazec informujúci o názvoch timov a výsledku zápasu
     */
    public String toStringVysledokZapasu() {
    	return String.format("%s \t %d:%d \t %s", getTim1().getNazov(), getPocetGolovTim1(), getPocetGolovTim2(), getTim2().getNazov());
    }
    
    /**
     * Metóda, ktorá vracia textový reťazec informujúci o názvoch timov tohto zápasu
     * @return textový reťazec informujúci o názvoch timov tohto zápasu
     */
    public String toStringNeodohranyZapas() {
    	return String.format("%s \t - \t %s", getTim1().getNazov(), getTim2().getNazov());
    }
}
