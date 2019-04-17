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
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GrupeIvesti extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private BaluSistema abs;
	private JTextField kodas_textField;
	private JTextField metai_textField;
	private JTextField spec_textField;

	/**
	 * Create the dialog.
	 */
	public GrupeIvesti(BaluSistema bs) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Prid\u0117ti grup\u0119");
		abs = bs;
		setupDialog();
	}

	private void setupDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{91, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{40, 38, 36, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Grup\u0117s kodas");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			kodas_textField = new JTextField();
			GridBagConstraints gbc_kodas_textField = new GridBagConstraints();
			gbc_kodas_textField.insets = new Insets(0, 0, 5, 0);
			gbc_kodas_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_kodas_textField.gridx = 1;
			gbc_kodas_textField.gridy = 0;
			contentPanel.add(kodas_textField, gbc_kodas_textField);
			kodas_textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Stojimo metai");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			metai_textField = new JTextField();
			GridBagConstraints gbc_metai_textField = new GridBagConstraints();
			gbc_metai_textField.insets = new Insets(0, 0, 5, 0);
			gbc_metai_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_metai_textField.gridx = 1;
			gbc_metai_textField.gridy = 1;
			contentPanel.add(metai_textField, gbc_metai_textField);
			metai_textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Specialyb\u0117");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			spec_textField = new JTextField();
			GridBagConstraints gbc_spec_textField = new GridBagConstraints();
			gbc_spec_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_spec_textField.gridx = 1;
			gbc_spec_textField.gridy = 2;
			contentPanel.add(spec_textField, gbc_spec_textField);
			spec_textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Prid\u0117ti");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(!metai_textField.getText().equals("") && !kodas_textField.getText().equals("") && !spec_textField.getText().equals("")) {
							abs.pridetiGrupe(Integer.parseInt(metai_textField.getText()), kodas_textField.getText(), spec_textField.getText());
							dispose();
						} else {
							JOptionPane.showMessageDialog(GrupeIvesti.this, "Uzpildykite visus laukus", "Klaida", JOptionPane.ERROR_MESSAGE);
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
