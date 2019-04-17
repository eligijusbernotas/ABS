package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BaluSistema.BaluSistema;
import BaluSistema.IkeltasDarbas;
import BaluSistema.Uzduotis;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DarbasView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private BaluSistema abs;
	private String uzdPav;

	public void displayTable() {
		Object[][] temp = new Object[abs.getIkeltiDarbaiByUzdPav(uzdPav).size()][5];
		int index = 0;
			for(IkeltasDarbas u : abs.getIkeltiDarbaiByUzdPav(uzdPav)) {
				temp[index] = new Object[] {u.getStudentoID(), u.getIvertinimas(), u.getIkelimoData(), u.getIvertinimoData(), u.getKomentaras()};
				index++;
			}
			
		table.setModel(new DefaultTableModel(
				temp,
				new String[] {
						"Studento ID", "\u012Evertinimas", "\u012Ekelimo data", "\u012Evertinimo data", "Komentaras"
				}
			));
	}
	
	@Override
	public void setVisible(boolean b) {
		displayTable();
		super.setVisible(b);
	}
	
	public DarbasView(BaluSistema bs, String uzdP) {
		JOptionPane.showMessageDialog(DarbasView.this, uzdP, "Klaida", JOptionPane.ERROR_MESSAGE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.abs = bs;
		this.uzdPav = uzdP;
		setTitle("\u012Ekelti darbai");
		setBounds(100, 100, 796, 458);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 587, 350);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Studento ID", "\u012Evertinimas", "\u012Ekelimo data", "\u012Evertinimo data", "Komentaras"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Float.class, Object.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Vertinti darb\u0105");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount() != 0) {
					VertintiView vertintiView = new VertintiView(abs, (int)table.getValueAt(table.getSelectedRow(), 0), DarbasView.this);
					vertintiView.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(DarbasView.this, "Prasome pasirinkti darba.", "Klaida", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(625, 13, 125, 53);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
