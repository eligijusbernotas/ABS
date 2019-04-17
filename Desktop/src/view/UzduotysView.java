package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaluSistema.BaluSistema;
import BaluSistema.Studentas;
import BaluSistema.Uzduotis;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UzduotysView extends JFrame {

	private JPanel contentPane;
	private BaluSistema abs;
	private JTable table;
	private final JButton btnkeltiDarbai = new JButton("\u012Ekelti darbai");
	
	private void displayTable() {
		Object[][] temp = new Object[abs.getUzduotys().size()][7];
		int index = 0;
			for(Uzduotis u : abs.getUzduotys()) {
				temp[index] = new Object[] {u.getPavadinimas(), u.getSalyga(), u.getVertinimoTvarka(), u.getMaxBalai(), u.getTerminas(), u.isGalimaIkelti(), u.getKursoKodas()};
				index++;
			}
			
		table.setModel(new DefaultTableModel(
				temp,
				new String[] {
						"Pavadinimas", "S\u0105lyga", "Vertinimo tvarka", "Max balai", "Terminas", "Kurso Kodas", "Galima \u012Fikelti darb\u0105"
				}
			));
	}
	
	@Override
	public void setVisible(boolean b) {
		displayTable();
		super.setVisible(b);
	}

	
	public UzduotysView(BaluSistema bs) {
		setMinimumSize(new Dimension(1130, 480));
		setTitle("Prid\u0117ti u\u017Eduot\u012F");
		this.abs = bs;
		setBounds(100, 100, 1129, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 866, 423);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Pavadinimas", "S\u0105lyga", "Vertinimo tvarka", "Max balai", "Terminas", "Kurso Kodas", "Galima \u012Fikelti darb\u0105"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Float.class, Date.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		btnkeltiDarbai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount() != 0) {
					DarbasView darbasView = new DarbasView(abs, (String)table.getValueAt(table.getSelectedRow(), 0));
					darbasView.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(UzduotysView.this, "Prasome pasirinkti uzduoti.", "Klaida", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnkeltiDarbai.setBounds(910, 13, 148, 36);
		contentPane.add(btnkeltiDarbai);
	}

}
