package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BaluSistema.BaluSistema;
import BaluSistema.Destytojas;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class DestytojuView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BaluSistema abs; 
	private JTable table;
	private JScrollPane scrollPaneTable;

	public void setAbs(BaluSistema abs) {
		this.abs = abs;
	}


	/**
	 * Create the frame.
	 */
	public DestytojuView(BaluSistema bs) {
		abs = bs;
		setupFrame();
		
	}
	
	
	@Override
	public void setVisible(boolean b) {
		displayTable();
		super.setVisible(b);
	}


	private void displayTable() {
		Object[][] destTemp = new Object[abs.getDestytojai().size()][3];
		int index = 0;
		for(Destytojas d : abs.getDestytojai()) {
			destTemp[index] = new Object[] {d.getId(), d.getPavarde(), d.getVardas()};
			index++;
		}
		table.setModel(new DefaultTableModel(
				destTemp,
				new String[] {
					"ID", "Pavard\u0117", "Vardas"
				}
			));
	}

	private void setupFrame() {
		setTitle("D\u0117stytoj\u0173 s\u0105ra\u0161as");
		setBounds(100, 100, 945, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPaneTable = new JScrollPane();
		scrollPaneTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneTable.setBounds(12, 13, 903, 230);
		contentPane.add(scrollPaneTable);
		
		table = new JTable();
		scrollPaneTable.setViewportView(table);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Pavard\u0117", "Vardas"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}
}
