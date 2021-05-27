package sk.dominikvrbovsky.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Dialog slúžiaci na vloženie mena tímu, ktorý chcem zo zoznamu zúčastnených tímov turnaja vymazať
 * @author Dominik Vrbovský
 *
 */
public class ZmazatTimDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFieldNazovTimu;
	
	/**
	 * hashMap, z ktorého si rodič (JFrame)ťahá dáta z dialógu
	 */
	private HashMap<String, Object> udajeZDialogu;

	/**
	 * Konštruktor pre JDialog ZmazatTimDialog
	 * @param parent rodič dialógu
	 * @param modal modalnosť dialógu
	 * @param udajeZDialoguParam hashMap, z ktorého si rodič (JFrame)ťahá dáta z dialógu
	 */
	public ZmazatTimDialog(JFrame parent, boolean modal, HashMap<String, Object> udajeZDialoguParam) {
		super(parent, modal);
		this.udajeZDialogu = udajeZDialoguParam;
		this.udajeZDialogu.put("stlaceneZmazatTim", Boolean.valueOf(false));
		setTitle("Zmaza\u0165 t\u00EDm");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 0, 0, 0));
		{
			JLabel lblNewLabel = new JLabel("Zadajte n\u00E1zov t\u00EDmu:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
			contentPanel.add(lblNewLabel);
		}
		{
			txtFieldNazovTimu = new JTextField();
			txtFieldNazovTimu.setHorizontalAlignment(SwingConstants.CENTER);
			txtFieldNazovTimu.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
			contentPanel.add(txtFieldNazovTimu);
			txtFieldNazovTimu.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Zmaza\u0165 t\u00EDm");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						udajeZDialogu.put("stlaceneZmazatTim", Boolean.valueOf(true));
						udajeZDialogu.put("nazovTimu", txtFieldNazovTimu.getText());
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
				JButton cancelButton = new JButton("Zru\u0161i\u0165");
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
