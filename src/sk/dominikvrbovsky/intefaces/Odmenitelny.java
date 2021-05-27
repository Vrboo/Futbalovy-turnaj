package sk.dominikvrbovsky.intefaces;

/**
 * Interface, ktorý implementujú objekty, ktoré sú odmenené na konci turnaja (Brankár, Tím)
 * @author Dominik Vrbovský
 *
 */
public interface Odmenitelny {
	
	/**
	 * Vypočíta sumu, ktorou by bol objekt odmenený pri jeho aktuálnych parametroch
	 * @return suma, ktorou by bol objekt odmenený na konci turnaja
	 */
	double vypocitajOdmenu();
	
	/**
	 * Metóda, ktorá hovori akou sumou je objekt odmenený na konci turnaja
	 */
	void odmenit();
	
	/**
	 * Metóda, ktorá vracia textový reťazec informujúci o sume, ktorou by bol objekt odmenený pri jeho aktuálných parametroch
	 * @return textový reťazec informujúci o sume, ktorou by bol objekt odmenený pri jeho aktuálných parametroch
	 */
	String toStringPriebeznaOdmena();
	
	/**
	 * Metóda, ktorá vracia textový reťazec informujúci o sume, ktorou je objekt odmenený na konci turnaja
	 * @return textový reťazec informujúci o sume, ktorou je objekt odmenený na konci turnaja
	 */
	String toStringKonecnaOdmena();
}
