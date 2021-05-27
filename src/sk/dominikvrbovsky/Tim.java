package sk.dominikvrbovsky;

import java.util.ArrayList;
import sk.dominikvrbovsky.intefaces.Odmenitelny;

/**
 * Trieda Tim predstavuje tím na turnaji
 * @author Dominik Vrbovský
 *
 */
public class Tim implements Odmenitelny{
	
	/**
	 * Suma, ktorú dostane tím na konci turnaja za každý získaný bod na turnaji
	 */
	private static final double ODMENA_ZA_KAZDY_BOD = 25.00;
	
	/**
	 * Názov tímu
	 */
    private String nazov;
    
    /**
     * Hráči tímu
     */
    private ArrayList<Hrac> hraci;
    
    /**
     * Tréner tímu
     */
    private Trener trener;
    
    /**
     * Počet bodov získaných bodov
     */
    private int pocetBodov;
    
    /**
     * Počet strelených gólov 
     */
    private int pocetStrelenychGolov;
    
    /**
     * Počet inkasovaných gólov
     */
    private int pocetInkasovanychGolov;
    
    /**
     * Počet vyhraných zápasov
     */
    private int pocetVyhranychZapasov;
    
    /**
     * Počet prehraných zápasov
     */
    private int pocetPrehranychZapasov;
    
    /**
     * Počet remizovaných zápasov
     */
    private int pocetRemizovanychZapasov;
    
    /**
     * Suma, ktorou je tím na konci turnaja odmenený za počet získaných na turnaji
     */
    private double odmenaZaPocetBodov;
    
    /**
     * Konštrutkor pre triedu Tim
     * @param nazov názov tímu
     * @param trener tréner tímu
     * @param brankar brankár tímu
     * @param obranca obranca tímu
     * @param utocnik útočník tímu
     */
    public Tim(String nazov, Trener trener, Brankar brankar, HracVPoli obranca, HracVPoli utocnik) {
        this.nazov = nazov;
        this.trener = trener;
        this.hraci = new ArrayList<>();
        this.hraci.add(brankar);
        this.hraci.add(utocnik);
        this.hraci.add(obranca);
        this.pocetBodov = 0;
        this.pocetStrelenychGolov = 0;
        this.pocetInkasovanychGolov = 0;
        this.pocetPrehranychZapasov = 0;
        this.pocetVyhranychZapasov = 0;
        this.pocetRemizovanychZapasov = 0;
        this.odmenaZaPocetBodov = 0;
    }
    
    /**
     * Getter na názov tímu
     * @return názov tímu
     */
	public String getNazov() {
		return this.nazov;
	}
	
	/**
	 * Setter na názov tímu
	 * @param nazov názov tímu
	 */
	public void setNazov(String nazov) {
		this.nazov = nazov;
	}
	
	/**
	 * Getter na všetkých hráčov tímu
	 * @return všetci hráči tímu
	 */
	public ArrayList<Hrac> getHraci() {
		return this.hraci;
	}
	
	/**
	 * Setter na všetkých hráčov tímu
	 * @param hraci všetci hráči tímu
	 */
	public void setHraci(ArrayList<Hrac> hraci) {
		this.hraci = hraci;
	}
	
	/**
	 * Getter na trénera tímu
	 * @return tréner tímu
	 */
	public Trener getTrener() {
		return this.trener;
	}
	
	/**
	 * Setter na trénera tímu
	 * @param trener tréner tímu
	 */
	public void setTrener(Trener trener) {
		this.trener = trener;
	}
	
	/**
	 * Getter na počet získaných bodov tímu
	 * @return počet získaných bodov tímu
	 */
	public int getPocetBodov() {
		return this.pocetBodov;
	}
	
	/**
	 * Setter na počet získaných bodov tímu
	 * @param pocetBodov počet získaných bodov tímu
	 */
	public void setPocetBodov(int pocetBodov) {
		this.pocetBodov = pocetBodov;
	}
	
	/**
	 * Getter na počet strelených gólov 
	 * @return počet strelených gólov 
	 */
	public int getPocetStrelenychGolov() {
		return this.pocetStrelenychGolov;
	}
	
	/**
	 * Setter na počet strelených gólov 
	 * @param pocetStrelenychGolov počet strelených gólov
	 */
	public void setPocetStrelenychGolov(int pocetStrelenychGolov) {
		this.pocetStrelenychGolov = pocetStrelenychGolov;
	}

	/**
	 * Getter na počet inkasovaných gólov 
	 * @return počet inkasovaných gólov 
	 */
	public int getPocetInkasovanychGolov() {
		return this.pocetInkasovanychGolov;
	}

	/**
	 * Setter na počet inkasovaných gólov 
	 * @param pocetInkasovanychGolov počet inkasovaných gólov
	 */
	public void setPocetInkasovanychGolov(int pocetInkasovanychGolov) {
		this.pocetInkasovanychGolov = pocetInkasovanychGolov;
	}

	/**
	 * Getter na počet vyhratých gólov 
	 * @return počet vyhratých gólov 
	 */
	public int getPocetVyhranychZapasov() {
		return this.pocetVyhranychZapasov;
	}

	/**
	 * Setter na počet vyhratých gólov 
	 * @param pocetVyhranychZapasov počet vyhratých gólov
	 */
	public void setPocetVyhranychZapasov(int pocetVyhranychZapasov) {
		this.pocetVyhranychZapasov = pocetVyhranychZapasov;
	}

	/**
	 * Getter na počet prehratých gólov 
	 * @return počet prehratých gólov 
	 */
	public int getPocetPrehranychZapasov() {
		return this.pocetPrehranychZapasov;
	}

	/**
	 * Setter na počet prehratých gólov 
	 * @param pocetPrehranychZapasov počet prehratých gólov
	 */
	public void setPocetPrehranychZapasov(int pocetPrehranychZapasov) {
		this.pocetPrehranychZapasov = pocetPrehranychZapasov;
	}
	
	/**
	 * Getter na počet remizovaných gólov 
	 * @return počet remizovaných gólov 
	 */
	public int getPocetRemizovanychZapasov() {
		return this.pocetRemizovanychZapasov;
	}

	/**
	 * Setter na počet remizovaných gólov 
	 * @param pocet remizovaných gólov
	 */
	public void setPocetRemizovanychZapasov(int pocet) {
		this.pocetRemizovanychZapasov = pocet;
	}
	
	/**
	 * Getter na sumu, ktorou je tím na konci turnaja odmenený za počet získaných bodov
	 * @return suma, ktorou je tím na konci turnaja odmenený za počet získaných bodov 
	 */
	public double getOdmenaZaPocetBodov() {
		return odmenaZaPocetBodov;
	}

	/**
	 * Setter na sumu, ktorou je tím na konci turnaja odmenený za počet získaných bodov
	 * @param odmenaZaPocetBodov suma, ktorou je tím na konci turnaja odmenený za počet získaných bodov
	 */
	public void setOdmenaZaPocetBodov(double odmenaZaPocetBodov) {
		this.odmenaZaPocetBodov = odmenaZaPocetBodov;
	}
	
	/**
	 * Getter na brankára tímu
	 * Metóda nájde bránkára spomedzi všetkých hráčov a vráti ho
	 * @return brankár tímu
	 */
	public Brankar getBrankar() {
		for (Hrac hrac : this.hraci) {
			if (hrac instanceof Brankar) return (Brankar)hrac;
		}
		return null;
	}
	
	/**
	 * Getter na rozdiel v celkovom skore (počet strelených gólov : pocčet inkasovaných gólov) tímu
	 * @return rozdiel v skóre 
	 */
	public int getRozdielVSkore() {
		return this.pocetStrelenychGolov - this.pocetInkasovanychGolov;
	}
	
	/**
	 * Metóda, ktorá hovorí, že tím vyhral zápas a ná zaklade toho a parametrov na vstupe sa mu nasetujú atribúty
	 * @param pocetStrelenychGolov počet gólov, ktoré tím strelil 
	 * @param pocetInkasovanychGolov počet gólov, ktorí tím inkasoval
	 */
	public void vyhratZapas(int pocetStrelenychGolov, int pocetInkasovanychGolov) {
		this.setPocetVyhranychZapasov(getPocetVyhranychZapasov() + 1);
		this.setPocetStrelenychGolov(getPocetStrelenychGolov() + pocetStrelenychGolov);
		this.setPocetInkasovanychGolov(getPocetInkasovanychGolov() + pocetInkasovanychGolov);
		this.setPocetBodov(getPocetBodov() + 3);
	}
	
	/**
	 * Metóda, ktorá hovorí, že tím remizoval zápas a ná zaklade toho a parametrov na vstupe sa mu nasetujú atribúty
	 * @param pocetStrelenychGolov počet gólov, ktoré tím strelil 
	 * @param pocetInkasovanychGolov počet gólov, ktorí tím inkasoval
	 */
	public void remizovatZapas(int pocetStrelenychGolov, int pocetInkasovanychGolov) {
		this.setPocetRemizovanychZapasov(getPocetRemizovanychZapasov() + 1);
		this.setPocetStrelenychGolov(getPocetStrelenychGolov() + pocetStrelenychGolov);
		this.setPocetInkasovanychGolov(getPocetInkasovanychGolov() + pocetInkasovanychGolov);
		this.setPocetBodov(getPocetBodov() + 1);
	}
	
	/**
	 * Metóda, ktorá hovorí, že tím prehral zápas a ná zaklade toho a parametrov na vstupe sa mu nasetujú atribúty
	 * @param pocetStrelenychGolov počet gólov, ktoré tím strelil 
	 * @param pocetInkasovanychGolov počet gólov, ktorí tím inkasoval
	 */
	public void prehratZapas(int pocetStrelenychGolov, int pocetInkasovanychGolov) {
		this.setPocetPrehranychZapasov(getPocetPrehranychZapasov() + 1);
		this.setPocetStrelenychGolov(getPocetStrelenychGolov() + pocetStrelenychGolov);
		this.setPocetInkasovanychGolov(getPocetInkasovanychGolov() + pocetInkasovanychGolov);
	}
	
	/**
	 * Metóda, ktorá vracia textový reťazec reprezetujúci tím v tabuľke turnaja
	 * @return textový reťazec reprezetujúci tím v tabuľke turnaja
	 */
	public String toStringTabulka() {
		return String.format("%s \t\t %d \t %d \t %d \t %d:%d \t %d", getNazov(), getPocetVyhranychZapasov(), getPocetRemizovanychZapasov(), getPocetPrehranychZapasov(), getPocetStrelenychGolov(), 
				getPocetInkasovanychGolov(), getPocetBodov());
	}
	
	/**
	 * Metóda, ktorá vracia textový reťazec informujúci o názve tímu a jeho všetkých hráčoch 
	 * @return textový reťazec informujúci o názve tímu a jeho všetkých hráčoch 
	 */
	public String toStringSupiskaTimu() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(getNazov() + "\n");
		stringBuilder.append("\tTréner:\t" ).append(getTrener().toString()).append("\n");
		stringBuilder.append("\tBrankár:\t" ).append(getBrankar().toString()).append("\n");
		stringBuilder.append("\tHráči v poli:");
		
		for (Hrac hrac : this.hraci) {
			if (hrac instanceof HracVPoli) {
				stringBuilder.append("\n\t\t").append(hrac.toString());
			}
		}
		
		return stringBuilder.toString();
	}
	
	/**
	 * Metóda, ktorá vypočítá sumu, ktorou by bol tím odmenený pri aktuálnom počte zíkaných bodov
	 */
	@Override
	public double vypocitajOdmenu() {
		return this.ODMENA_ZA_KAZDY_BOD * this.getPocetBodov();
	}
	
	/**
	 * Metóda, ktorá hovorí akou sumou je tím odmenený na konci turnaja
	 */
	@Override
	public void odmenit() {
		this.setOdmenaZaPocetBodov(this.vypocitajOdmenu());
	}

	/**
	 * Metóda, ktorá vracia textový reťazec informujúci o sume, ktorou je tím odmenený na konci turnaja
	 */
	@Override
	public String toStringPriebeznaOdmena() {
		return String.format(" %s - %.2f€", getNazov(), vypocitajOdmenu());
	}
	
	/**
	 * Metóda, ktorá vracia textový reťazec informujúci o sume, ktorou by bol tím odmenený pri aktuálnom počte získaných bodov
	 */
	@Override
	public String toStringKonecnaOdmena() {
		return String.format(" %s - %.2f€", getNazov(), getOdmenaZaPocetBodov());
	}
	
    
    


}
