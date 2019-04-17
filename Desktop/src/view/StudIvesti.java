package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaluSistema.BaluSistema;
import BaluSistema.Grupe;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class StudIvesti extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField id_textField;
	private JTextField vardas_textField;
	private JTextField pav_textField;
	private JComboBox<Grupe> grupesComboBox;
	private BaluSistema abs;


	/**
	 * Create the dialog.
	 */
	public StudIvesti(BaluSistema bs) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		abs = bs;
		setupFrame();
	
	}
	
	


	private void setupFrame() {
		setTitle("\u012Evesti student\u0105");
		setBounds(100, 100, 467, 298);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{85, 56, 0};
		gbl_contentPanel.rowHeights = new int[]{38, 36, 38, 38, 15, -1, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("ID");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			id_textField = new JTextField();
			GridBagConstraints gbc_id_textField = new GridBagConstraints();
			gbc_id_textField.insets = new Insets(0, 0, 5, 0);
			gbc_id_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_id_textField.gridx = 1;
			gbc_id_textField.gridy = 0;
			contentPanel.add(id_textField, gbc_id_textField);
			id_textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Vardas");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			vardas_textField = new JTextField();
			GridBagConstraints gbc_vardas_textField = new GridBagConstraints();
			gbc_vardas_textField.insets = new Insets(0, 0, 5, 0);
			gbc_vardas_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_vardas_textField.gridx = 1;
			gbc_vardas_textField.gridy = 1;
			contentPanel.add(vardas_textField, gbc_vardas_textField);
			vardas_textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Pavard\u0117");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			pav_textField = new JTextField();
			GridBagConstraints gbc_pav_textField = new GridBagConstraints();
			gbc_pav_textField.insets = new Insets(0, 0, 5, 0);
			gbc_pav_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_pav_textField.gridx = 1;
			gbc_pav_textField.gridy = 2;
			contentPanel.add(pav_textField, gbc_pav_textField);
			pav_textField.setColumns(10);
		}
		{
			JLabel lblStudentoGrup = new JLabel("Studento grup\u0117");
			GridBagConstraints gbc_lblStudentoGrup = new GridBagConstraints();
			gbc_lblStudentoGrup.insets = new Insets(0, 0, 5, 5);
			gbc_lblStudentoGrup.anchor = GridBagConstraints.WEST;
			gbc_lblStudentoGrup.gridx = 0;
			gbc_lblStudentoGrup.gridy = 3;
			contentPanel.add(lblStudentoGrup, gbc_lblStudentoGrup);
		}
		{
			grupesComboBox = new JComboBox<Grupe>();
			grupesComboBox.setModel(new DefaultComboBoxModel<Grupe>());
			grupesComboBox.setMaximumRowCount(12);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 0);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 3;
			for(Grupe g : abs.getGrupes()) {
				grupesComboBox.addItem(g);
			}
			contentPanel.add(grupesComboBox, gbc_comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Prid\u0117ti");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							if(!id_textField.getText().isEmpty() || !vardas_textField.getText().isEmpty() || !pav_textField.getText().isEmpty()) {
								((Grupe) grupesComboBox.getSelectedItem()).pridetiStudenta(Integer.parseInt(id_textField.getText()), vardas_textField.getText(), pav_textField.getText());
								dispose();
							} else {
								JOptionPane.showMessageDialog(StudIvesti.this, "Uzpildykite visus laukus.", "Klaida", JOptionPane.ERROR_MESSAGE);
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
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
