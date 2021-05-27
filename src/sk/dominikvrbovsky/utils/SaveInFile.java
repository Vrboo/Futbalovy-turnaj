package sk.dominikvrbovsky.utils;

import java.io.File;
import java.io.PrintWriter;

/**
 * Pomocná trieda, uchovávajúca jednu metódu na zápis do súboru
 * @author Lukáš Budaj
 *
 */
public class SaveInFile {

	/**
	 * Metóda, ktorá uloží text na vstupe do súboru export.txt
	 * @param text je text, ktorý sa zapíše do súboru
	 * @return true - podarí zápis do súbor; false - nepodarí zápas do súboru
	 */
	public static boolean ulozDoSuboru(String text) {
        File subor = new File("export.txt");
        PrintWriter writer = null;
        
        try {
        	writer = new PrintWriter(subor);
            writer.print(text);
        } catch (Exception e) {
            return false;
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        
        return true;
        
    }
}
