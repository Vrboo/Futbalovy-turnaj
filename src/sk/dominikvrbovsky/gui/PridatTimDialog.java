package sk.dominikvrbovsky.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import sk.dominikvrbovsky.Tim;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Dialóg slúžiaci na vkladanie atribútov potrebných na vytvorenie tímu 
 * @author Dominik Vrbovský
 *	
 */
public class PridatTimDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFieldNazovTimu;
	private JTextField txtFieldTrenerMeno;
	private JTextField txtFieldBrankarMeno;
	private JTextField txtFieldObrancaMeno;
	private JTextField txtFieldUtocnikMeno;
	
	/**
	 * hashMap, z ktorého si rodič (JFrame)ťahá dáta z dialógu
	 */
	private HashMap<String, Object> udajeZDialogu;
	private JComboBox<String> comboBoxTrenerLicencia;
	private JSpinner spinnerBrankarCisloDresu;
	private JSpinner spinnerObrancaCisloDresu;
	private JSpinner spinnerUtocnikCisloDresu;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Konštruktor dialogu PridatTimDialog
	 * @param parent rodič dialógu
	 * @param modal modalnosť dialogu
	 * @param udajeZDialoguParam hashMap, z ktorého si rodič (JFrame)ťahá dáta z dialógu
	 * @param timyTurnaja tímy na turnaji
	 */
	public PridatTimDialog(JFrame parent, boolean modal, HashMap<String, Object> udajeZDialoguParam, ArrayList<Tim> timyTurnaja) {
		super(parent, modal);
		this.udajeZDialogu = udajeZDialoguParam;
		this.udajeZDialogu.put("stlacenePridatTim", Boolean.valueOf(false));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Prida\u0165 t\u00EDm");
		setBounds(100, 100, 359, 553);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 5));
		{
			JLabel lblNewLabel = new JLabel("N\u00E1zov t\u00EDmu:");
			lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
		}
		{
			txtFieldNazovTimu = new JTextField();
			txtFieldNazovTimu.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			contentPanel.add(txtFieldNazovTimu);
			txtFieldNazovTimu.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Tr\u00E9ner:");
			lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("");
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Meno:");
			lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtFieldTrenerMeno = new JTextField();
			txtFieldTrenerMeno.setText("Adam Slovák");
			txtFieldTrenerMeno.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			contentPanel.add(txtFieldTrenerMeno);
			txtFieldTrenerMeno.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Licencia");
			lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_3);
		}
		{
			comboBoxTrenerLicencia = new JComboBox<String>();
			comboBoxTrenerLicencia.setModel(new DefaultComboBoxModel(new String[] {"Licencia A", "Licencia B", "Licencia C"}));
			comboBoxTrenerLicencia.setSelectedIndex(0);
			comboBoxTrenerLicencia.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			contentPanel.add(comboBoxTrenerLicencia);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Brank\u00E1r:");
			lblNewLabel_5.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("");
			contentPanel.add(lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Meno:");
			lblNewLabel_7.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_7);
		}
		{
			txtFieldBrankarMeno = new JTextField();
			txtFieldBrankarMeno.setText("Peter Repa");
			txtFieldBrankarMeno.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			contentPanel.add(txtFieldBrankarMeno);
			txtFieldBrankarMeno.setColumns(10);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("\u010C\u00EDslo dresu:");
			lblNewLabel_8.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_8);
		}
		{
			spinnerBrankarCisloDresu = new JSpinner();
			spinnerBrankarCisloDresu.setModel(new SpinnerNumberModel(1, 1, 99, 1));
			spinnerBrankarCisloDresu.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			contentPanel.add(spinnerBrankarCisloDresu);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("Obranca:");
			lblNewLabel_9.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
			lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
			contentPanel.add(lblNewLabel_9);
		}
		{
			JLabel lblNewLabel_10 = new JLabel("");
			contentPanel.add(lblNewLabel_10);
		}
		{
			JLabel lblNewLabel_11 = new JLabel("Meno:");
			lblNewLabel_11.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_11);
		}
		{
			txtFieldObrancaMeno = new JTextField();
			txtFieldObrancaMeno.setText("Jakub Tóth");
			txtFieldObrancaMeno.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			contentPanel.add(txtFieldObrancaMeno);
			txtFieldObrancaMeno.setColumns(10);
		}
		{
			JLabel lblNewLabel_12 = new JLabel("\u010C\u00EDslo dresu:");
			lblNewLabel_12.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_12);
		}
		{
			spinnerObrancaCisloDresu = new JSpinner();
			spinnerObrancaCisloDresu.setModel(new SpinnerNumberModel(3, 1, 99, 1));
			spinnerObrancaCisloDresu.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			contentPanel.add(spinnerObrancaCisloDresu);
		}
		{
			JLabel lblNewLabel_13 = new JLabel("\u00DAto\u010Dn\u00EDk:");
			lblNewLabel_13.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
			lblNewLabel_13.setHorizontalAlignment(SwingConstants.LEFT);
			contentPanel.add(lblNewLabel_13);
		}
		{
			JLabel lblNewLabel_14 = new JLabel("");
			contentPanel.add(lblNewLabel_14);
		}
		{
			JLabel lblNewLabel_15 = new JLabel("Meno:");
			lblNewLabel_15.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_15);
		}
		{
			txtFieldUtocnikMeno = new JTextField();
			txtFieldUtocnikMeno.setText("Roman Dlhý");
			txtFieldUtocnikMeno.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			contentPanel.add(txtFieldUtocnikMeno);
			txtFieldUtocnikMeno.setColumns(10);
		}
		{
			JLabel lblNewLabel_16 = new JLabel("\u010C\u00EDslo dresu:");
			lblNewLabel_16.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_16);
		}
		{
			spinnerUtocnikCisloDresu = new JSpinner();
			spinnerUtocnikCisloDresu.setModel(new SpinnerNumberModel(10, 1, 99, 1));
			spinnerUtocnikCisloDresu.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			contentPanel.add(spinnerUtocnikCisloDresu);
		}
		{
			JLabel lblNewLabel_19 = new JLabel("");
			contentPanel.add(lblNewLabel_19);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setPreferredSize(new Dimension(10, 38));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Prida\u0165 t\u00EDm");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						udajeZDialogu.put("stlacenePridatTim", Boolean.valueOf(true));
						udajeZDialogu.put("nazovTimu", txtFieldNazovTimu.getText());
						udajeZDialogu.put("trenerMeno", txtFieldTrenerMeno.getText());
						udajeZDialogu.put("trenerLicencia", comboBoxTrenerLicencia.getSelectedItem().toString());
						udajeZDialogu.put("brankarMeno", txtFieldBrankarMeno.getText());
						udajeZDialogu.put("brankarCisloDresu",spinnerBrankarCisloDresu.getValue());
						udajeZDialogu.put("obrancaMeno", txtFieldObrancaMeno.getText());
						udajeZDialogu.put("obrancaCisloDresu",spinnerObrancaCisloDresu.getValue());
						udajeZDialogu.put("utocnikMeno", txtFieldUtocnikMeno.getText());
						udajeZDialogu.put("utocnikCisloDresu",spinnerUtocnikCisloDresu.getValue());
						for (Tim tim : timyTurnaja) {
							if (tim.getNazov().equals(txtFieldNazovTimu.getText())) {
								JOptionPane.showMessageDialog(PridatTimDialog.this, "Zadaný názov tímu už je obsadený");
								return;
							}
						}

						if (txtFieldNazovTimu.getText().length() > 5) {
							JOptionPane.showMessageDialog(PridatTimDialog.this, "Názov tímu môže mať max. 5 písmen");
							return;
						}

						dispose();
					}
				});
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Zru\u0161i\u0165");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.setLocationRelativeTo(null);
		
	}

}
