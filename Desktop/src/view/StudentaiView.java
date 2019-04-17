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
import BaluSistema.Destytojas;
import BaluSistema.Grupe;
import BaluSistema.Studentas;

public class StudentaiView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private BaluSistema abs;

	

	/**
	 * Create the frame.
	 */
	public StudentaiView(BaluSistema bs) {
		abs = bs;
		setupFrame();
	}
	
	@Override
	public void setVisible(boolean b) {
		displayTable();
		super.setVisible(b);
	}
	
	private void displayTable() {
		Object[][] studTemp = new Object[abs.getStudentai().size()][4];
		int index = 0;
			for(Studentas s : abs.getStudentai()) {
				studTemp[index] = new Object[] {s.getGrupesKodas(), s.getId(), s.getPavarde(), s.getVardas()};
				index++;
			}
			
		table.setModel(new DefaultTableModel(
				studTemp,
				new String[] {
						"Grup\u0117", "ID", "Pavard\u0117", "Vardas"
				}
			));
	}



	private void setupFrame() {
		setTitle("Student\u0173 s\u0105ra\u0161as");
		setBounds(100, 100, 723, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 681, 319);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Grup\u0117", "ID", "Pavard\u0117", "Vardas"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
	}
}
