package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaluSistema.BaluSistema;
import BaluSistema.IkeltasDarbas;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class VertintiView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField vertinimasTextField;
	private BaluSistema abs;
	private int studentoID;
	private IkeltasDarbas darbas;
	
	

	@Override
	public void setVisible(boolean arg0) {
		this.darbas = abs.getDarbasByStudID(studentoID);
		super.setVisible(arg0);
	}



	public VertintiView(BaluSistema bs, int studID, DarbasView dv) {
		this.abs = bs;
		this.studentoID = studID;
		this.darbas = abs.getDarbasByStudID(studentoID);
		setMinimumSize(new Dimension(780, 505));
		setTitle(darbas.getUzduotiesPav() + " - " + darbas.getStudentoID());
		setBounds(100, 100, 780, 503);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 42, 489, 220);
			contentPanel.add(scrollPane);
			
			JTextPane atsTextPane = new JTextPane();
			atsTextPane.setEditable(false);
			atsTextPane.setText(darbas.getAtsakymas());
			scrollPane.setViewportView(atsTextPane);
		}
		
		JLabel lblAtsakymas = new JLabel("Atsakymas:");
		lblAtsakymas.setBounds(12, 13, 83, 16);
		contentPanel.add(lblAtsakymas);
		
		JLabel lblJsKomentaras = new JLabel("J\u016Bs\u0173 komentaras:");
		lblJsKomentaras.setBounds(12, 275, 114, 16);
		contentPanel.add(lblJsKomentaras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 304, 489, 101);
		contentPanel.add(scrollPane);
		
		JTextPane komentarasTextPane = new JTextPane();
		komentarasTextPane.setText(darbas.getKomentaras());
		scrollPane.setViewportView(komentarasTextPane);
		
		JLabel lblvertinimas = new JLabel("\u012Evertinimas:");
		lblvertinimas.setBounds(513, 71, 77, 16);
		contentPanel.add(lblvertinimas);
		
		JLabel lblMaxBalai = new JLabel("Max balai:");
		lblMaxBalai.setBounds(513, 42, 77, 16);
		contentPanel.add(lblMaxBalai);
		
		String floatString = Float.toString(abs.getUzduotisByPav(darbas.getUzduotiesPav()).getMaxBalai());
		JLabel maxBalaiLabel = new JLabel(floatString);
		maxBalaiLabel.setBounds(602, 42, 56, 16);
		contentPanel.add(maxBalaiLabel);
		
		vertinimasTextField = new JTextField();
		vertinimasTextField.setBounds(602, 68, 56, 22);
		vertinimasTextField.setText(Float.toString(darbas.getIvertinimas()));
		contentPanel.add(vertinimasTextField);
		vertinimasTextField.setColumns(10);
		
		JLabel lblkelimoData = new JLabel("\u012Ekelimo data:");
		lblkelimoData.setBounds(513, 13, 83, 16);
		contentPanel.add(lblkelimoData);
		
		DateFormat tmp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JLabel dateLabel = new JLabel(tmp.format(darbas.getIkelimoData()));
		dateLabel.setBounds(602, 13, 114, 16);
		contentPanel.add(dateLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!vertinimasTextField.getText().isEmpty()) {
							darbas.setIvertinimas(Float.parseFloat(vertinimasTextField.getText()));
							darbas.setKomentaras(komentarasTextPane.getText());
							darbas.setIvertinimoData(new Date());
							abs.updateIkeltasDarbas(darbas);
							dv.displayTable();
							dispose();
						}
						JOptionPane.showMessageDialog(VertintiView.this, "Ivertinkite darba.", "Klaida", JOptionPane.ERROR_MESSAGE);
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
