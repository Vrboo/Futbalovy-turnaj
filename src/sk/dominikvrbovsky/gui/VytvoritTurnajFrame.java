package sk.dominikvrbovsky.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import sk.dominikvrbovsky.Brankar;
import sk.dominikvrbovsky.HracVPoli;
import sk.dominikvrbovsky.Tim;
import sk.dominikvrbovsky.Trener;
import sk.dominikvrbovsky.Turnaj;
import sk.dominikvrbovsky.enums.PoziciaHracaVPoli;
import sk.dominikvrbovsky.enums.TrenerskaLicencia;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

/**
 * Okno sprevádzajúce používateľa programu pri vytváraní turnaja
 * @author Dominik Vrbovský
 *
 */
public class VytvoritTurnajFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldNazovTurnaja;
	
	/**
	 * Všetky tímy turnaja
	 */
	private ArrayList<Tim> timyTurnaja;
	
	private JTextPane txtPaneTimyTurnaja;


	/**
	 * Konštrutkor pre JFrame VytvoritTurnajFrame
	 */
	public VytvoritTurnajFrame() {
		this.timyTurnaja = new ArrayList();
		setTitle("Vytvorte futbalov\u00FD turnaj");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 385);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 50));
		panel.setBackground(new Color(128, 128, 128));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Vytvorte futbalov\u00FD turnaj");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setPreferredSize(new Dimension(10, 285));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setPreferredSize(new Dimension(5, 30));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("N\u00E1zov turnaja:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setPreferredSize(new Dimension(200, 14));
		panel_2.add(lblNewLabel_1, BorderLayout.WEST);
		
		txtFieldNazovTurnaja = new JTextField();
		txtFieldNazovTurnaja.setBackground(new Color(240, 248, 255));
		txtFieldNazovTurnaja.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldNazovTurnaja.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		txtFieldNazovTurnaja.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		txtFieldNazovTurnaja.setPreferredSize(new Dimension(250, 10));
		panel_2.add(txtFieldNazovTurnaja);
		txtFieldNazovTurnaja.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Vytvori\u0165 turnaj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtFieldNazovTurnaja.getText().equals("")) {
					JOptionPane.showMessageDialog(VytvoritTurnajFrame.this, "Zadajte názov turnaja");
					return;
				}
				
				if (timyTurnaja.size() < 2) {
					JOptionPane.showMessageDialog(VytvoritTurnajFrame.this, "Turnaja sa musia zúčastniť minimálne 2 tímy");
					return;
				}
				 
				if (timyTurnaja.size() % 2 != 0) {
					JOptionPane.showMessageDialog(VytvoritTurnajFrame.this, "Turnaj musí obsahovať párny počet tímov");
					return;
				}
				
				Tim[] timy = timyTurnaja.toArray(new Tim[0]);
				Turnaj turnaj = new Turnaj(txtFieldNazovTurnaja.getText(), timy);
				JFrame turnaJFrame = new TurnajFrame(turnaj);
				turnaJFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setPreferredSize(new Dimension(103, 30));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		panel_1.add(btnNewButton_1, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(130, 10));
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnNewButton = new JButton("+ Prida\u0165 t\u00EDm");
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Object> udajeZDialogu = new HashMap();
				JDialog dialog = new PridatTimDialog(VytvoritTurnajFrame.this, true, udajeZDialogu, timyTurnaja);
				dialog.setVisible(true);
				
				if (((Boolean)udajeZDialogu.get("stlacenePridatTim")).booleanValue()) {
					String nazovTimu = (String)udajeZDialogu.get("nazovTimu");
					String trenerMeno = (String)udajeZDialogu.get("trenerMeno");
					String trenerLicencia = (String)udajeZDialogu.get("trenerLicencia");
					String brankarMeno = (String)udajeZDialogu.get("brankarMeno");
					int brankarCisloDresuString = ((Integer)udajeZDialogu.get("brankarCisloDresu")).intValue();
					String obrancaMeno = (String)udajeZDialogu.get("obrancaMeno");
					int obrancaCisloDresuString = ((Integer)udajeZDialogu.get("obrancaCisloDresu")).intValue();
					String utocnikMeno = (String)udajeZDialogu.get("utocnikMeno");
					int utocnikCisloDresuString = ((Integer)udajeZDialogu.get("utocnikCisloDresu")).intValue();
					
					Trener trener = new Trener(trenerMeno, TrenerskaLicencia.getEnumFromString(trenerLicencia));
					Brankar brankar = new Brankar(brankarMeno, brankarCisloDresuString);
					HracVPoli obranca = new HracVPoli(obrancaMeno, obrancaCisloDresuString, PoziciaHracaVPoli.OBRANCA);
					HracVPoli utocnik = new HracVPoli(utocnikMeno, utocnikCisloDresuString, PoziciaHracaVPoli.UTOCNIK);
					
					Tim tim = new Tim(nazovTimu, trener, brankar, obranca, utocnik);
					timyTurnaja.add(tim);
					
					StringBuilder stringBuilder = new StringBuilder();
					for (Tim timTurnaja : timyTurnaja) {
						stringBuilder.append(" " + (timyTurnaja.indexOf(timTurnaja) + 1) + ". " ).append(timTurnaja.getNazov()).append("\n");
					}
					txtPaneTimyTurnaja.setText(stringBuilder.toString());
				} 
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(144, 238, 144));
		panel_3.add(btnNewButton);
		
		JButton btnOdstrniTm = new JButton("- Odobra\u0165 t\u00EDm");
		btnOdstrniTm.setBorder(null);
		btnOdstrniTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Object> udajeZDialogu = new HashMap();
				JDialog dialog = new ZmazatTimDialog(VytvoritTurnajFrame.this, true, udajeZDialogu);
				dialog.setVisible(true);
				
				if (((Boolean)udajeZDialogu.get("stlaceneZmazatTim")).booleanValue()) {
					String nazovTimu = (String)udajeZDialogu.get("nazovTimu");
					
					boolean zmazane = false;
					for (Tim timTurnaja : timyTurnaja) {
						if (timTurnaja.getNazov().equals(nazovTimu)) {
							zmazane = timyTurnaja.remove(timTurnaja);
							break;
						}
					}
					if (!zmazane) {
						JOptionPane.showMessageDialog(VytvoritTurnajFrame.this, "Zadali ste nesprávny názov");
						return;
					}
					if (timyTurnaja.size() == 0) {
						txtPaneTimyTurnaja.setText("Žiadne zúčastnené tímy");
						return;
					}
					StringBuilder stringBuilder = new StringBuilder();
					for (Tim timTurnaja : timyTurnaja) {
						stringBuilder.append(" " + (timyTurnaja.indexOf(timTurnaja) + 1) + ". " ).append(timTurnaja.getNazov()).append("\n");
					}
					txtPaneTimyTurnaja.setText(stringBuilder.toString());
				} 
			}
		});
		btnOdstrniTm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOdstrniTm.setForeground(Color.BLACK);
		btnOdstrniTm.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnOdstrniTm.setBackground(new Color(240, 128, 128));
		panel_3.add(btnOdstrniTm);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		txtPaneTimyTurnaja = new JTextPane();
		txtPaneTimyTurnaja.setText(" Žiadne zúčastnené tímy ");
		txtPaneTimyTurnaja.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		txtPaneTimyTurnaja.setEditable(false);
		txtPaneTimyTurnaja.setBorder(null);
		txtPaneTimyTurnaja.setBackground(Color.WHITE);
		scrollPane.setViewportView(txtPaneTimyTurnaja);
		this.setLocationRelativeTo(null);
	}

}
