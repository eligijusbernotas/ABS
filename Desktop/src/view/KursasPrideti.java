package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaluSistema.BaluSistema;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KursasPrideti extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField kodasTextField;
	private JTextField pavTextField;
	private String dabartinisDest;
	private BaluSistema abs;


	/**
	 * Create the dialog.
	 */
	public KursasPrideti(BaluSistema bs, String destID) {
		this.abs = bs;
		this.dabartinisDest = destID;
		setTitle("Prid\u0117ti kurs\u0105");
		setBounds(100, 100, 450, 182);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 184, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Kurso kodas:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			kodasTextField = new JTextField();
			GridBagConstraints gbc_kodasTextField = new GridBagConstraints();
			gbc_kodasTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_kodasTextField.insets = new Insets(0, 0, 5, 5);
			gbc_kodasTextField.gridx = 2;
			gbc_kodasTextField.gridy = 1;
			contentPanel.add(kodasTextField, gbc_kodasTextField);
			kodasTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Kurso pavadinimas:");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			pavTextField = new JTextField();
			GridBagConstraints gbc_pavTextField = new GridBagConstraints();
			gbc_pavTextField.insets = new Insets(0, 0, 5, 5);
			gbc_pavTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_pavTextField.gridx = 2;
			gbc_pavTextField.gridy = 2;
			contentPanel.add(pavTextField, gbc_pavTextField);
			pavTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JLabel lblNewLabel_2 = new JLabel("Kursas bus prid\u0117tas dabartiniam d\u0117stytojui");
				buttonPane.add(lblNewLabel_2);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!kodasTextField.getText().isEmpty() && !pavTextField.getText().isEmpty()) {
							abs.pridetiKursa(kodasTextField.getText(), pavTextField.getText(), Integer.parseInt(dabartinisDest));
							dispose();
							
						}else {
							JOptionPane.showMessageDialog(KursasPrideti.this, "Prasome uzpildyti visus laukus.", "Klaida", JOptionPane.ERROR_MESSAGE);
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
