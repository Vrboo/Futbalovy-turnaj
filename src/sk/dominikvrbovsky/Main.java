package sk.dominikvrbovsky;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import sk.dominikvrbovsky.gui.VytvoritTurnajFrame;

/**
 * Trieda Main pre projekt ESportTurnaj
 * @author Dominik Vrbovský
 *
 */
public class Main {
	
	/**
	 * Metóda main pre spustenie programu ESportTurnaj
	 * @param args
	 */
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jframe = new VytvoritTurnajFrame();
                jframe.setVisible(true);
            }
        });
    	
    	
    }
    
}
