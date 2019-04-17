package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaluSistema.BaluSistema;
import BaluSistema.Kursas;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;

public class UzduotisPrideti extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private BaluSistema abs;
	private JTextField maxBalaiTextField;
	private JTextField terminasTextField;
	private JTextField pavTextField;
	private JTextField kursoKodasTextField;

	
	public UzduotisPrideti(BaluSistema bs) {
		setMinimumSize(new Dimension(734, 624));
		setTitle("Prid\u0117ti u\u017Eduot\u012F");
		this.abs = bs;
		setBounds(100, 100, 734, 626);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("S\u0105lyga:");
		lblNewLabel.setBounds(22, 69, 56, 16);
		contentPanel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 98, 291, 302);
		contentPanel.add(scrollPane);
		
		JTextPane salygaTextPane = new JTextPane();
		scrollPane.setViewportView(salygaTextPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(385, 98, 291, 302);
		contentPanel.add(scrollPane_1);
		
		JTextPane vertTvarkaTextPane = new JTextPane();
		scrollPane_1.setViewportView(vertTvarkaTextPane);
		
		JLabel lblNewLabel_1 = new JLabel("Vertinimo tvarka:");
		lblNewLabel_1.setBounds(385, 69, 119, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Max balai:");
		lblNewLabel_2.setBounds(22, 432, 65, 16);
		contentPanel.add(lblNewLabel_2);
		
		maxBalaiTextField = new JTextField();
		maxBalaiTextField.setToolTipText("Makismalus u\u017Eduoties bal\u0173 saki\u010Dius.");
		maxBalaiTextField.setBounds(86, 429, 37, 22);
		contentPanel.add(maxBalaiTextField);
		maxBalaiTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Terminas:");
		lblNewLabel_3.setBounds(22, 464, 65, 16);
		contentPanel.add(lblNewLabel_3);
		
		terminasTextField = new JTextField();
		terminasTextField.setToolTipText("Data ir laiks. (2018-10-12 23:59:59)");
		terminasTextField.setBounds(86, 461, 116, 22);
		contentPanel.add(terminasTextField);
		terminasTextField.setColumns(10);
		
		JCheckBox galimaKeltiCheckBox = new JCheckBox("Galima kelti atsakymus");
		galimaKeltiCheckBox.setBounds(22, 492, 180, 25);
		contentPanel.add(galimaKeltiCheckBox);
		
		JLabel lblNewLabel_4 = new JLabel("U\u017Eduoties pavadinimas:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(22, 32, 163, 16);
		contentPanel.add(lblNewLabel_4);
		
		pavTextField = new JTextField();
		pavTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pavTextField.setBounds(185, 28, 372, 24);
		contentPanel.add(pavTextField);
		pavTextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Kurso kodas:");
		lblNewLabel_5.setBounds(229, 429, 80, 16);
		contentPanel.add(lblNewLabel_5);
		
		kursoKodasTextField = new JTextField();
		kursoKodasTextField.setBounds(313, 426, 116, 22);
		contentPanel.add(kursoKodasTextField);
		kursoKodasTextField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(Kursas k : abs.getKursai()) {
							if(k.getKodas().equals(kursoKodasTextField.getText())) {
								if(!pavTextField.getText().isEmpty() || !terminasTextField.getText().isEmpty() || 
										!maxBalaiTextField.getText().isEmpty() || !salygaTextPane.getText().isEmpty() || !vertTvarkaTextPane.getText().isEmpty()) {
									abs.pridetiUzduoti(pavTextField.getText(), salygaTextPane.getText(), vertTvarkaTextPane.getText(),
											Float.parseFloat(maxBalaiTextField.getText()), terminasTextField.getText(), kursoKodasTextField.getText(), galimaKeltiCheckBox.isSelected());
									dispose();
								} else {
									JOptionPane.showMessageDialog(UzduotisPrideti.this, "Uzpildykite visus laukus.", "Klaida", JOptionPane.ERROR_MESSAGE);
								}
								break;
							}
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("At\u0161aukti");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
