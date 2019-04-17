package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaluSistema.BaluSistema;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DestIvesti extends JDialog {

	private BaluSistema abs;
	
	public void setAbs(BaluSistema abs) {
		this.abs = abs;
	}

	private final JPanel contentPanel = new JPanel();
	private JTextField idTextField;
	private JTextField vardasTextField;
	private JTextField pavardeTextField;


	/**
	 * Create the dialog.
	 */
	public DestIvesti(BaluSistema abs) {
		this.abs = abs;
		setupFrame();
		
	}
	private void setupFrame() {
		setTitle("Prid\u0117ti d\u0117stytoj\u0105");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{41, 45, 36, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("ID");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			idTextField = new JTextField();
			GridBagConstraints gbc_idTextField = new GridBagConstraints();
			gbc_idTextField.insets = new Insets(0, 0, 5, 0);
			gbc_idTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_idTextField.gridx = 1;
			gbc_idTextField.gridy = 0;
			contentPanel.add(idTextField, gbc_idTextField);
			idTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Vardas");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			vardasTextField = new JTextField();
			GridBagConstraints gbc_vardasTextField = new GridBagConstraints();
			gbc_vardasTextField.insets = new Insets(0, 0, 5, 0);
			gbc_vardasTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_vardasTextField.gridx = 1;
			gbc_vardasTextField.gridy = 1;
			contentPanel.add(vardasTextField, gbc_vardasTextField);
			vardasTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Pavard\u0117");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			pavardeTextField = new JTextField();
			GridBagConstraints gbc_pavardeTextField = new GridBagConstraints();
			gbc_pavardeTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_pavardeTextField.gridx = 1;
			gbc_pavardeTextField.gridy = 2;
			contentPanel.add(pavardeTextField, gbc_pavardeTextField);
			pavardeTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!idTextField.getText().equals("") && !vardasTextField.getText().equals("") && !pavardeTextField.getText().equals("")) {
							abs.pridetiDest(Integer.parseInt(idTextField.getText()), vardasTextField.getText(), pavardeTextField.getText());
							dispose();
						} else {
							JOptionPane.showMessageDialog(DestIvesti.this, "Uzpildykite visus laukus", "Klaida", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
