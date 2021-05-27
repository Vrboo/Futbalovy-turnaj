package sk.dominikvrbovsky;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import sk.dominikvrbovsky.intefaces.Odmenitelny;
import java.util.List;

/**
 * Trieda Turnaj predstavuje futbalový turnaj
 * @author Dominik Vrbovský
 *
 */
public class Turnaj {
	
	/**
	 * Názov turnaju
	 */
    private String nazov;
    
    /**
     * Tímy na turnaji
     */
    private Tim[] timy;
    
    /**
     * Všetky zápasy na turnaji. 
     * Prvý rozmer poľa predstavuje kolo, v ktorom sa zápas koná
     * a druhý rozmer poľa je index zápasu v danom kole.
     * Príklad: this.zapasy[4][2] je druhý zápas v štvrtom kole
     */
    private Zapas[][] zapasy;
    
    /**
     * Všetci odmeňovaný členovia na konci turnaja.
     * Odmeňovaní sú všetci brankári a všetky tímy na turnaji a to podľa pravidiel,
     *  ktoré sú vysvetlené v triedach Brankar a Tim 
     */
    private ArrayList<Odmenitelny> odmenovaniClenoviaTurnaja;
    
    /**
     * Počet všetkých kôl turnaja
     */
    private int pocetKol;
    
    /**
     * Kolo, v ktorom sa turnaj aktuálne nachádza 
     */
    private int aktualneKolo;

    /**
     * Konštruktor pre triedu Turnaj
     * @param nazov názov turnaju
     * @param timy všetky tímy na turnaji
     */
    public Turnaj(String nazov, Tim[] timy) {
        this.nazov = nazov;
        this.timy = timy;
        this.pocetKol = timy.length - 1;
        this.aktualneKolo = 0;
        this.odmenovaniClenoviaTurnaja = new ArrayList<Odmenitelny>();
        vylosujZapasy(); 
        
        for (Tim tim : this.timy) {
        	this.odmenovaniClenoviaTurnaja.add(tim);
        	this.odmenovaniClenoviaTurnaja.add(tim.getBrankar());
        }
    }
    
    /**
     * Getter na názov turnaju
     * @return názov turnaju
     */
    public String getNazov() {
		return nazov;
	}

    /**
     * Setter na názov turnaju
     * @param nazov názov turnaju
     */
	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	/**
	 * Getter všetky tímy na turnaji
	 * @return všetky tímy na turnaji
	 */
	public Tim[] getTimy() {
		return timy;
	}

	/**
	 * Setter na všetky tímu na turnaji
	 * @param timy všetky tími na turnaji
	 */
	public void setTimy(Tim[] timy) {
		this.timy = timy;
	}

	/**
	 * Getter na všetky zápasy na turnaji
	 * @return všetky zápasy na turnaji
	 */
	public Zapas[][] getZapasy() {
		return zapasy;
	}

	/**
	 * Setter na všetky zápasy na turnaji
	 * @param zapasy všetky zápasy na turnaji
	 */
	public void setZapasy(Zapas[][] zapasy) {
		this.zapasy = zapasy;
	}

	/**
	 * Getter na počet všetkých kol na turnaji
	 * @return počet všetkých kôl na turnaji
	 */
	public int getPocetKol() {
		return pocetKol;
	}

	/**
	 * Setter na počet všetkých kôl na turnaji
	 * @param pocetKol počet všetkých kôl na turnaji
	 */
	public void setPocetKol(int pocetKol) {
		this.pocetKol = pocetKol;
	}

	/**
	 * Getter na kolo, v ktorom sa turnaj aktualne nachádza
	 * @return kolo, v ktorom sa turnaj aktualne nachádza
	 */
	public int getAktualneKolo() {
		return aktualneKolo;
	}
	
	/**
	 * Setter na kolo, v ktorom sa turnaj aktualne nachádza
	 * @param aktualneKolo kolo, v ktorom sa turnaj aktualne nachádza
	 */
	public void setAktualneKolo(int aktualneKolo) {
		this.aktualneKolo = aktualneKolo;
	}
	
	/**
	 * Privátna metóda, ktorá vylosuje všetky zápasy, ktoré sa majú na turnaji odohrať formou každý s každým
	 */
	private void vylosujZapasy() {
    	this.zapasy = new Zapas[this.pocetKol][this.timy.length / 2]; // [určenie počtu všetkych kol][určenie počtu zápasov v jednom kole]
    	
    	for (int i = 0; i < this.zapasy.length; i++) { 
    		Zapas[] vsetkyZapasy = this.vytvorVsetkyZapasy(); // zavolanie metódy na vytvorenie všetkých možných zápasov každý s každým
    		ArrayList<Tim> timyVKole = new ArrayList(); // ArrayList, do ktorého sa budú ukladať všetky tímy, ktoré už majú zápas v danom kole
    		for (int j = 0; j < this.zapasy[i].length; j++) {
    			this.zapasy[i][j] = priradZapasDoKola(i, vsetkyZapasy, timyVKole); // do daného kola sa priradí zápas, ktorý nájde ako vhodný pomocna metóda
    		}
    		
    	}
    	
    }
    
	/**
	 * Privátna pomocná metóda, ktorá na základe parametrov na vstupe nájde vhodný zápas do daného kola
	 * @param kolo kolo, do ktorého hľadá vhodný zápas
	 * @param vsetkyZapasy všetky zápasy turnaja, ktore ešte neboli priradené do žiadneho kola
	 * @param timyVKole timy, ktoré už majú zápas v danom kole a teda nemôže už v ňom mať zápas
	 * @return zápas vhodný do daného kola
	 */
    private Zapas priradZapasDoKola(int kolo, Zapas[] vsetkyZapasy, ArrayList<Tim> timyVKole) {
    	Zapas result = null; // premenná, do ktorej sa uloží nájdený vhodný zápas a vráti ju táto metóda
    	
    	for (int k = 0; k < vsetkyZapasy.length; k++) { // prechádzanie všetkých možných zápasov
    		if (vsetkyZapasy[k] != null) { // ak daný zápas ešte nebol použítý pokračuj ďalej (ak bol, tak tam je null)
    			if (!timyVKole.contains(vsetkyZapasy[k].getTim1()) && !timyVKole.contains(vsetkyZapasy[k].getTim2())) { // ak tímy daného zápasu ešte nemajú zápas v danom kole je to vhodný zápas do daného kola
    				// zapas v vsetkyZapasy[k] bol vybratý ako vhodný zápas do kole takže sa vykoná všetko v tomto bloku ...
    				timyVKole.add(vsetkyZapasy[k].getTim1()); // priradí sa domáci tim zapasu do arrayList timyVKole aby sa vedelo že tento tím už má zápas v tomto kole
    				timyVKole.add(vsetkyZapasy[k].getTim2()); // priradí sa hostujuci tim zapasu do arrayListu timyVKole aby sa vedelo že tento tím už má zápas v tomto kole
    				result = vsetkyZapasy[k]; // do premennej result sa priradí nájdený vhodný zápas
    				vsetkyZapasy[k] = null; // aby sa už daný zápas nemohol použiť odstráni sa - danému polu, kde bol zápas priradím null
    				return result; // metóda vráti nájdený vhodný zápas
    			}
    		}
    		
    	}
    	return null; // ak metóda spomedzi všetkých možných záapasov nenašla žiadny vhodný zápas, vrati null
    	
    }
    
    /**
     * Privátna pomocná metóda, ktorá vytvorí všetký možné zápasy formou každý s každým
     * @return všetky zápasy turnaja
     */ 
    private Zapas[] vytvorVsetkyZapasy() {
    	Zapas[] vsetkyZapasy = new Zapas[this.pocetKol * (this.timy.length / 2)]; // [počet všetkých možných zápasov]
    	
    	/*
    	 * Algoritmus na vytvorenie všetkých možných zápasov
    	 */
    	int index = 0; 
    	for (int i = 0; i < this.timy.length - 1; i++) {
    		for (int j = i + 1; j < this.timy.length; j++) {
    			vsetkyZapasy[index] = new Zapas(this.timy[i], this.timy[j]); 
    			index++;
    		}
    	}
    	
    	/*
    	 * Pomiešanie všetkých vytvorených zápasov v poli
    	 */
    	Random rnd = ThreadLocalRandom.current();
        for (int i = vsetkyZapasy.length - 1; i > 0; i--)
        {
          int index1 = rnd.nextInt(i + 1);
          Zapas a = vsetkyZapasy[index1];
          vsetkyZapasy[index1] = vsetkyZapasy[i];
          vsetkyZapasy[i] = a;
        }
    	
    	return vsetkyZapasy;
    }
    
    /**
     * Metóda, ktorá simuluje odohratie všetkých zápasov kola, ktoré je na rade
     */
    public void odohrajKolo() {
    	for (int i = 0; i < this.zapasy[this.aktualneKolo].length; i++) { // prechádzanie všetkých zápasov v kole, ktoré je na rade
    		this.zapasy[this.aktualneKolo][i].odohrajZapas(); // odohratie daného zápasu v kole
    	}
    	this.setAktualneKolo(getAktualneKolo() + 1); // po odohratí zápasov sa zmeni aktuálne kolo 
    }
    
    /**
     * Metóda, ktorá udelí odmeny všetkým členom, ktorý majú nárok na odmenu (implementujúci interface Odmenitelny)
     */
    public void udelOdmeny() {
		for (Odmenitelny odmenitelny : this.odmenovaniClenoviaTurnaja) {
			odmenitelny.odmenit();
		}
	}
    
    /**
     * Metóda, ktorá zistí a vráti tím, ktorý vyhral resp. vedie tabuľku
     * @return tím, ktorý vyhral resp. vedie tabuľku
     */
    public Tim getVitazaTurnaju() {
		List<Tim> util = new ArrayList<Tim>(); // pre lepšiu prácu so zoznamom všetkých tímov sa do ArrayListu uložia všetky tímy turnaja
    	for (int i = 0; i < this.timy.length; i++) util.add(this.timy[i]); // nasetovanie arrayListu všetkými tímami v turnaja
    	Tim najlepsiTim = util.get(0); // premenna kde sa bude ukladať vždy aktualne najlepši tim; inicializačne to bude vždy prvý element arrayListu
    	
    	for (int i = 0; i < util.size(); i++) { 
    		for (int j = 1; j < util.size(); j++) {
    			if (util.get(j).getPocetBodov() > najlepsiTim.getPocetBodov()) { // ak ma prehľadávaný tím v arrayListe viac bodov ako najlepší tím ...
    				najlepsiTim = util.get(j); // tak sa tento tím priradi do premennej najlepsiTim
    			} else if (util.get(j).getPocetBodov() == najlepsiTim.getPocetBodov()) { // ak ma prehľadávaný tim v arrayListe rovnaký počet bodov ako najlepší tím...
    				if (najlepsiTim.getRozdielVSkore() < util.get(j).getRozdielVSkore()) { // tak rozhoduje kto má vačší rozdiel v skore
    					najlepsiTim = util.get(j); // ak má prehľadávaný tim v arrayListe väčší rozdiel v skore priradí sa do premennej najlepsiTim
    				}
    			}
    		}
    	}
    	return najlepsiTim;
	}

    /**
     * Metóda, ktorá vo forme textového reťazca vráti tabuľku tímov zoradenú od najlepší po najhorší tím (bodovo)
     * @return vo forme textového reťazca tabuľka tímov zoradena od najlepšieho po najhorší tím (bodovo)
     */
    public String toStringTabulkaTimov() {
    	StringBuilder stringBuilder = new StringBuilder();
    	List<Tim> util = new ArrayList<Tim>(); // pre lepšiu prácu so zoznamom všetkých tímov sa do ArrayListu uložia všetky tímy turnaja
    	for (int i = 0; i < this.timy.length; i++) util.add(this.timy[i]); // nasetovanie arrayListu všetkými tímami v turnaja
    			
    	stringBuilder.append("     Tím    \t\tVýhry\tRemizy\tPrehry\tSkóre\tBody").append("\n");
    	stringBuilder.append("-----------------------------------------------------------------------------").append("\n");
    	
    	/*
    	 * Algoritmus na vytvorenie tabuľky; bližšie okomentovaný v metóde getVitazaTurnaja()
    	 */
    	for (int i = 0; i < this.timy.length; i++) {
    		Tim najlepsiTim = util.get(0);
    		for (int j = 1; j < util.size(); j++) {
    			if (util.get(j).getPocetBodov() > najlepsiTim.getPocetBodov()) {
    				najlepsiTim = util.get(j);
    			} else if (util.get(j).getPocetBodov() == najlepsiTim.getPocetBodov()) {
    				if (najlepsiTim.getRozdielVSkore() < util.get(j).getRozdielVSkore()) {
    					najlepsiTim = util.get(j); 
    				}
    			}
    		}
    		util.remove(najlepsiTim);
			stringBuilder.append(" " + (i+1) + ". " + najlepsiTim.toStringTabulka()).append("\n");
    	}
    	return stringBuilder.toString();
    }

    /**
     * Metóda, ktorá vráti v podobe textového reťazca výsledky všetkých odohraných zápasov v turnaji
     * @return v podobe textového reťazca výsledky všetkých odohraných zápasov v turnaji
     */
    public String toStringVysledkyOdohranychZapasov() {
    	StringBuilder stringBuilder = new StringBuilder();
    	if (this.aktualneKolo == 0) { 
    		stringBuilder.append("Zatiaľ sa neodohrali žiadne zápasy");
    		return stringBuilder.toString();
    	}
    	
    	for (int i = 0; i < this.aktualneKolo; i++) {
    		stringBuilder.append("---------- ").append((i+1) + ". kolo").append(" ----------\n");
    		for (int j = 0; j < this.zapasy[i].length; j++) {
    		stringBuilder.append(" " + this.zapasy[i][j].toStringVysledokZapasu()).append("\n");
    		}
    		stringBuilder.append("\n\n");
    	}
    	
    	return stringBuilder.toString();
    	
    }
    
    /**
     * Metóda, ktorá vráti v podobe textového reťazca všetky ešte neodohrané zápasy v turnaji
     * @return v podobe textového reťazca všetky ešte neodohrané zápasy v turnaji
     */
    public String toStringNeodohraneZapasy() {
    	StringBuilder stringBuilder = new StringBuilder();
    	if (this.aktualneKolo == this.pocetKol) { 
    		stringBuilder.append("Už sa odohrali všetky zápasy");
    		return stringBuilder.toString();
    	}
    	
    	for (int i = aktualneKolo; i < this.zapasy.length; i++) {
    		stringBuilder.append("---------- ").append((i+1) + ". kolo").append(" ----------\n");
    		for (int j = 0; j < this.zapasy[i].length; j++) {
    		stringBuilder.append(" " + this.zapasy[i][j].toStringNeodohranyZapas()).append("\n");
    		}
    		stringBuilder.append("\n\n");
    	}
    	
    	return stringBuilder.toString();
    }
    
    /**
     * Metóda, ktorá vráti v podobe textového reťazca všetky súpisky hráčov všetkých tímov na turnaji
     * @return v podobe textového reťazca všetky súpisky hráčov všetkých tímov na turnaji
     */
    public String toStringSupiskyTimov() {
    	StringBuilder stringBuilder = new StringBuilder();
    	
    	for (Tim tim : this.timy) {
    		stringBuilder.append(tim.toStringSupiskaTimu()).append("\n\n\n");
    	}
    	
    	return stringBuilder.toString();
    }
    
    /**
     * Metóda, ktorá vráti v podobe textového reťazca všetky odohrané zápasy v poslednom kole
     * @return v podobe textového reťazca všetky odohrané zápasy v poslednom kole
     */
    public String toStringVysledkyZapasovVPoslednomOdohratomKole() {
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append("---------- ").append(this.aktualneKolo + ". kolo").append(" ----------\n");
    	
    	for (int i = 0; i < this.zapasy[this.aktualneKolo - 1].length; i++) {
    		stringBuilder.append(" " + this.zapasy[this.aktualneKolo - 1][i].toStringVysledokZapasu()).append("\n");
    	}
    	
    	return stringBuilder.toString();
    }
    
    /**
     * Metóda, ktorá vráti v podobe textového reťazca priebežný stav odmien 
     * @return vráti v podobe textového reťazca priebežný stav odmien
     */
    public String toStringPriebeznyStavOdmien() {
		StringBuilder timyString = new StringBuilder();
		StringBuilder brankariString = new StringBuilder();
		
		for (Odmenitelny odmenitelny : this.odmenovaniClenoviaTurnaja) {
			if (odmenitelny instanceof Tim) timyString.append(odmenitelny.toStringPriebeznaOdmena()).append("\n\t");
			if (odmenitelny instanceof Brankar) brankariString.append(odmenitelny.toStringPriebeznaOdmena()).append("\n\t");
		}
		return " Priebežný stav odmien:\nTímy:\n\t" + timyString.toString() + "\nBrankári:\n\t" + brankariString.toString();
	}
	
    /**
     * Metóda, ktorá vráti v podobe textového reťazca konečný stav odmien 
     * @return vráti v podobe textového reťazca konečný stav odmien
     */
	public String toStringKonecnyStavOdmien() {
		StringBuilder timyString = new StringBuilder();
		StringBuilder brankariString = new StringBuilder();
		
		for (Odmenitelny odmenitelny : this.odmenovaniClenoviaTurnaja) {
			if (odmenitelny instanceof Tim) timyString.append(odmenitelny.toStringKonecnaOdmena()).append("\n\t");
			if (odmenitelny instanceof Brankar) brankariString.append(odmenitelny.toStringKonecnaOdmena()).append("\n\t");
		}
		return " Konečný stav odmien:\nTímy:\n\t" + timyString.toString() + "\nBrankári:\n\t" + brankariString.toString();
	}
}
