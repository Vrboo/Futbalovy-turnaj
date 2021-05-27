package sk.dominikvrbovsky.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import sk.dominikvrbovsky.Turnaj;
import sk.dominikvrbovsky.utils.SaveInFile;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

/**
 * Okno, ktoré sprevádza používateľa počas priebehu turnaja
 * @author Dominik Vrbovský
 *
 */
public class TurnajFrame extends JFrame {

	private JPanel contentPane;
	private Turnaj turnaj;
	private JLabel labelNazovTurnaja;
	private JLabel labelKolo;
	private JButton btnTabulka;
	private JButton btnVysledky;
	private JButton btnProgram;
	private JButton btnTimy;
	private JButton btnOdmeny;
	private JButton btnExport;
	private JButton btnOdohratKolo;
	private JScrollPane scrollPane;
	private JTextPane textPaneObsah;

	/**
	 * Konštruktor pre JFrame TurnajFrame
	 * @param turnajParam inštancia triedy Turnaj, ktorá uchováva všetky informácie o turnaji
	 */
	public TurnajFrame(Turnaj turnajParam) {
		this.turnaj = turnajParam;
		JFrame thisFrame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setPreferredSize(new Dimension(10, 60));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		labelNazovTurnaja = new JLabel("");
		labelNazovTurnaja.setForeground(new Color(255, 255, 255));
		labelNazovTurnaja.setFont(new Font("Yu Gothic UI", Font.BOLD, 35));
		labelNazovTurnaja.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelNazovTurnaja, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 45));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnTabulka = new JButton("Tabuľka");
		btnTabulka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneObsah.setText(turnaj.toStringTabulkaTimov());
			}
		});
		btnTabulka.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		btnTabulka.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTabulka.setBackground(new Color(135, 206, 250));
		btnTabulka.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		panel_2.add(btnTabulka);
		
		btnVysledky = new JButton("Výsledky");
		btnVysledky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneObsah.setText(turnaj.toStringVysledkyOdohranychZapasov());
			}
		});
		btnVysledky.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		btnVysledky.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVysledky.setBackground(new Color(135, 206, 250));
		btnVysledky.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		panel_2.add(btnVysledky);
		
		btnProgram = new JButton("Program");
		btnProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneObsah.setText(turnaj.toStringNeodohraneZapasy());
			}
		});
		btnProgram.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		btnProgram.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProgram.setBackground(new Color(135, 206, 250));
		btnProgram.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		panel_2.add(btnProgram);
		
		btnTimy = new JButton("Tímy");
		btnTimy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneObsah.setText(turnaj.toStringSupiskyTimov());
			}
		});
		btnTimy.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		btnTimy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTimy.setBackground(new Color(135, 206, 250));
		btnTimy.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		panel_2.add(btnTimy);
		
		btnOdmeny = new JButton("Odmeny");
		btnOdmeny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (turnaj.getAktualneKolo() != turnaj.getPocetKol()) {
					textPaneObsah.setText(turnaj.toStringPriebeznyStavOdmien());
				} else {
					textPaneObsah.setText(turnaj.toStringKonecnyStavOdmien());
				}
			}
		});
		btnOdmeny.setBorder(null);
		btnOdmeny.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOdmeny.setBackground(new Color(135, 206, 250));
		btnOdmeny.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		panel_2.add(btnOdmeny);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(248, 248, 255));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btnOdohratKolo = new JButton("Odohrať kolo");
		btnOdohratKolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turnaj.odohrajKolo();
				
				if (turnaj.getAktualneKolo() != turnaj.getPocetKol()) {
					labelKolo.setText(turnaj.getAktualneKolo() + "/" + turnaj.getPocetKol() + " kolo");
					textPaneObsah.setText(turnaj.toStringVysledkyZapasovVPoslednomOdohratomKole());
				} else {
					turnajParam.udelOdmeny();
					textPaneObsah.setText(turnaj.toStringVysledkyZapasovVPoslednomOdohratomKole());
					btnOdohratKolo.setEnabled(false);
					labelKolo.setText("Turnaj ukončený - Víťaz: " + turnaj.getVitazaTurnaju().getNazov());
				}
			}
		});
		btnOdohratKolo.setBorder(null);
		btnOdohratKolo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOdohratKolo.setBackground(new Color(255, 222, 173));
		btnOdohratKolo.setPreferredSize(new Dimension(95, 40));
		panel_3.add(btnOdohratKolo, BorderLayout.SOUTH);
		btnOdohratKolo.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		
		labelKolo = new JLabel("3/5 kolo");
		labelKolo.setHorizontalAlignment(SwingConstants.CENTER);
		labelKolo.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		labelKolo.setPreferredSize(new Dimension(46, 30));
		labelKolo.setBackground(new Color(192, 192, 192));
		panel_3.add(labelKolo, BorderLayout.NORTH);
		
		btnExport = new JButton("Export");
		btnExport.setBorder(null);
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SaveInFile.ulozDoSuboru(textPaneObsah.getText())) {
					JOptionPane.showMessageDialog(thisFrame, "Export prebehol úspešne"); 
				} else {
					JOptionPane.showMessageDialog(thisFrame, "Export zlyhal");	
				}
			}
		});
		btnExport.setPreferredSize(new Dimension(80, 23));
		btnExport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExport.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnExport.setBackground(new Color(245, 245, 245));
		panel_3.add(btnExport, BorderLayout.EAST);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		textPaneObsah = new JTextPane();
		textPaneObsah.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		textPaneObsah.setEditable(false);
		scrollPane.setViewportView(textPaneObsah);
		this.setLocationRelativeTo(null);
		
		myInit();
	}
	
	/**
	 * Moja inicializácia premenných
	 */
	private void myInit() {
		labelNazovTurnaja.setText(turnaj.getNazov());
		labelKolo.setText(turnaj.getAktualneKolo() + "/" + turnaj.getPocetKol() + " kolo");
		textPaneObsah.setText(turnaj.toStringTabulkaTimov());
	}
	
}
