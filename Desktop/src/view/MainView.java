package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaluSistema.BaluSistema;
import BaluSistema.Destytojas;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Dimension;

public class MainView extends JFrame {

	private JPanel contentPane;
	private BaluSistema abs = new BaluSistema();
	private DestIvesti destIvesti;
	private DestytojuView destytojuView = new DestytojuView(abs);
	private StudentaiView studentaiView = new StudentaiView(abs);
	private UzduotysView uzduotysView = new UzduotysView(abs);
	private KursaiView kursaiView = new KursaiView(abs);
	private StudIvesti studIvesti;
	private GrupeIvesti grupeIvesti;
	private KursasPrideti kursasPrideti;
	private UzduotisPrideti uzduotisPrideti;
	private JTextField destIDTextField;
	private String dabartinisDest = "";


	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setMinimumSize(new Dimension(562, 203));
		
		setTitle("Aktyvumo balu sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 203);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFailas = new JMenu("Failas");
		menuBar.add(mnFailas);
		
		JMenuItem mntmBaigtiDarb = new JMenuItem("Baigti darb\u0105");
		mntmBaigtiDarb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(2);
			}
		});
		mnFailas.add(mntmBaigtiDarb);
		
		JMenu mnNewMenu = new JMenu("D\u0117stytojai");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("D\u0117stytoj\u0173 s\u0105ra\u0161as");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				destytojuView.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_5 = new JMenu("Prid\u0117ti...");
		mnNewMenu.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u012Evesti");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				destIvesti = new DestIvesti(abs);
				destIvesti.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Studentai");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmPridtiGrup = new JMenuItem("Prid\u0117ti grup\u0119");
		mntmPridtiGrup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grupeIvesti = new GrupeIvesti(abs);
				grupeIvesti.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmPridtiGrup);
		
		JMenuItem mntmPridtiStudent = new JMenuItem("Prid\u0117ti student\u0105");
		mntmPridtiStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studIvesti = new StudIvesti(abs);
				studIvesti.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmPridtiStudent);
		
		JMenuItem mntmStudentSraas = new JMenuItem("Student\u0173 s\u0105ra\u0161as");
		mntmStudentSraas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				studentaiView.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmStudentSraas);
		
		JMenu mnNewMenu_2 = new JMenu("Kursai");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmKursSraas = new JMenuItem("Kurs\u0173 s\u0105ra\u0161as");
		mntmKursSraas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(dabartinisDest.equals("")) {
					JOptionPane.showMessageDialog(MainView.this, "Prasome parinkti dabartines darbos sesijos destytoja.", "Klaida", JOptionPane.ERROR_MESSAGE);
				}else {
					kursaiView.setVisible(true);
				}
			}
		});
		
		JMenuItem mntmPridtiKurs = new JMenuItem("Prid\u0117ti kurs\u0105");
		mntmPridtiKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(dabartinisDest.equals("")) {
					JOptionPane.showMessageDialog(MainView.this, "Prasome parinkti dabartines darbos sesijos destytoja.", "Klaida", JOptionPane.ERROR_MESSAGE);
				}else {
					kursaiView.setVisible(true);
				}
			}
		});
		mnNewMenu_2.add(mntmPridtiKurs);
		mnNewMenu_2.add(mntmKursSraas);
		
		JMenu mnNewMenu_3 = new JMenu("U\u017Eduotys");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmPridtiUduot = new JMenuItem("Prid\u0117ti u\u017Eduot\u012F");
		mntmPridtiUduot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uzduotisPrideti = new UzduotisPrideti(abs);
				uzduotisPrideti.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmPridtiUduot);
		
		JMenuItem mntmUduoiSraas = new JMenuItem("U\u017Eduo\u010Di\u0173 s\u0105ra\u0161as");
		mntmUduoiSraas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uzduotysView.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmUduoiSraas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAktybumoBaluSistema = new JLabel("");
		lblAktybumoBaluSistema.setBounds(5, 5, 571, 0);
		lblAktybumoBaluSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblAktybumoBaluSistema.setFont(UIManager.getFont("Label.font"));
		contentPane.add(lblAktybumoBaluSistema);
		
		JButton btnNewButton = new JButton("Registruoti d\u0117stytoj\u0105");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				destIvesti = new DestIvesti(abs);
				destIvesti.setVisible(true);
			}
		});
		btnNewButton.setBounds(34, 72, 155, 45);
		contentPane.add(btnNewButton);
		
		JButton btnPridtiKurs = new JButton("Prid\u0117ti kurs\u0105");
		btnPridtiKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dabartinisDest.equals("")) {
					JOptionPane.showMessageDialog(MainView.this, "Prasome parinkti dabartines darbos sesijos destytoja.", "Klaida", JOptionPane.ERROR_MESSAGE);
				}else {
					kursasPrideti = new KursasPrideti(abs, dabartinisDest);
					kursasPrideti.setVisible(true);
				}
			}
		});
		btnPridtiKurs.setBounds(331, 72, 155, 45);
		contentPane.add(btnPridtiKurs);
		
		JLabel lblNewLabel = new JLabel("D\u0117stytojo ID");
		lblNewLabel.setBounds(12, 35, 75, 22);
		contentPane.add(lblNewLabel);
		
		destIDTextField = new JTextField();
		destIDTextField.setBounds(99, 35, 116, 22);
		contentPane.add(destIDTextField);
		destIDTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Darbuotojo pasirinkimas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(12, 5, 178, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel dabartinisDestLabel = new JLabel("");
		dabartinisDestLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		dabartinisDestLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		dabartinisDestLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dabartinisDestLabel.setBounds(368, 18, 162, 16);
		contentPane.add(dabartinisDestLabel);
		
		JButton btnNewButton_1 = new JButton("Pasirinkti");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				for(Destytojas d : abs.getDestytojai()) {
					if(d.getId() == Integer.parseInt(destIDTextField.getText())) {
						dabartinisDest = destIDTextField.getText();
						dabartinisDestLabel.setText(d.getVardas() + " " + d.getPavarde());
						return;
					}
				}
				JOptionPane.showMessageDialog(MainView.this, "Tokio d\u0117stytojo n\u0117ra sistemoje.", "Klaida", JOptionPane.ERROR_MESSAGE);
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(MainView.this, "Prasome ivesti skaiciu.", "Klaida", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(231, 34, 97, 25);
		contentPane.add(btnNewButton_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("Prisijungta kaip:");
		lblNewLabel_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel_2.setBounds(433, 0, 97, 16);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setAutoscrolls(true);
		separator.setBackground(Color.BLACK);
		separator.setBounds(22, 72, 0, 5);
		contentPane.add(separator);
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				separator.setBounds(contentPane.getX(), contentPane.getY() + 42, contentPane.getWidth(), 5);
			}
		});
		
	}
}
