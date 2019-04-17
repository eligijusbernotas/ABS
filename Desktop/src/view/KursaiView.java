package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BaluSistema.BaluSistema;
import BaluSistema.Kursas;
import BaluSistema.Studentas;

public class KursaiView extends JFrame {

	private JPanel contentPane;
	private JTable kursaiTable;
	private BaluSistema abs;


	private void displayTable() {
			Object[][] temp = new Object[abs.getKursai().size()][2];
			int index = 0;
				for(Kursas k : abs.getKursai()) {
					temp[index] = new Object[] {k.getKodas(), k.getPavadinimas()};
					index++;
				}
				
			kursaiTable.setModel(new DefaultTableModel(
					temp,
					new String[] {
							"Kodas", "Pavadinimas"
					}
				));
		}
	
	@Override
	public void setVisible(boolean b) {
		displayTable();
		super.setVisible(b);
	}
	
	
	 
	public KursaiView(BaluSistema bs) {
		this.abs = bs;
		setTitle("Kurs\u0173 s\u0105ra\u0161as");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		kursaiTable = new JTable();
		kursaiTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Kodas", "Pavadinimas"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(kursaiTable);
	}

}
