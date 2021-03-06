import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.GlyphJustificationInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class View {
	
	JLabel lagelbl = new JLabel("...");
	JLabel eigenlbl = new JLabel("...");
	JLabel tvlbl = new JLabel("...");
	JLabel preislbl = new JLabel("...");
	JLabel label = new JLabel("...");
	
	private JFrame frame;
	private JTextField nachnametxt;
	
	private int counter =0;
	private int zcounter =0;
	
	ArrayList<Gast> gastl = new ArrayList<>();
	ArrayList<Zimmer> zimmerl = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	JLabel namelbl = new JLabel("...");
	JLabel gdlbl = new JLabel("...");
	JLabel landlbl = new JLabel("...");
	JLabel telefonlbl = new JLabel("...");
	JLabel hnrlbl = new JLabel("...");
	JLabel plzlbl = new JLabel("...");
	private JTextField bettentxt;
	private JTextField vontxt;
	private JTextField bistxt;
	private JTextField personentxt;
	
	private void initialize() {
		System.out.println("");
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1163, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 399, 499);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGast = new JLabel("Gast");
		lblGast.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGast.setBounds(174, 11, 70, 25);
		panel.add(lblGast);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 47, 379, 2);
		panel.add(separator_1);
		
		nachnametxt = new JTextField();
		nachnametxt.setBounds(144, 81, 103, 20);
		panel.add(nachnametxt);
		nachnametxt.setColumns(10);
		
		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(144, 56, 100, 14);
		panel.add(lblNachname);
		
		JButton button = new JButton("");
		
		button.setIcon(new ImageIcon("C:\\Users\\FlorianGriesebner\\Documents\\GitHub\\Beer4free\\TestDrivenHotelDB\\icons\\Find24.gif"));
		button.setBounds(257, 81, 28, 22);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\FlorianGriesebner\\Documents\\GitHub\\Beer4free\\TestDrivenHotelDB\\icons\\Back24.gif"));
		button_1.setBounds(136, 11, 28, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_1.setEnabled(true);
				if(counter == gastl.size()-2){
					button_2.setEnabled(false);
				}
				counter++;
				displayGast(gastl.get(counter));
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\FlorianGriesebner\\Documents\\GitHub\\Beer4free\\TestDrivenHotelDB\\icons\\Forward24.gif"));
		button_2.setBounds(225, 11, 28, 23);
		panel.add(button_2);
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_2.setEnabled(true);
				if(counter == 1){
					button_1.setEnabled(false);
				}
				counter--;
				displayGast(gastl.get(counter));
			}
		});
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 115, 46, 14);
		panel.add(lblName);
		
		
		namelbl.setBounds(66, 115, 323, 14);
		panel.add(namelbl);
		
		JLabel lblNewLabel = new JLabel("Geburtsdatum:");
		lblNewLabel.setBounds(10, 140, 85, 14);
		panel.add(lblNewLabel);
		
		
		gdlbl.setBounds(105, 140, 284, 14);
		panel.add(gdlbl);
		
		JLabel lblNewLabel_1 = new JLabel("Land:");
		lblNewLabel_1.setBounds(10, 165, 46, 14);
		panel.add(lblNewLabel_1);
		
		
		landlbl.setBounds(66, 165, 323, 14);
		panel.add(landlbl);
		
		JLabel lblNewLabel_2 = new JLabel("Telefon:");
		lblNewLabel_2.setBounds(10, 190, 46, 14);
		panel.add(lblNewLabel_2);
		
		
		telefonlbl.setBounds(66, 190, 323, 14);
		panel.add(telefonlbl);
		
		JLabel lblHausnr = new JLabel("Hausnr:");
		lblHausnr.setBounds(10, 215, 46, 14);
		panel.add(lblHausnr);
		
		
		hnrlbl.setBounds(66, 215, 323, 14);
		panel.add(hnrlbl);
		
		JLabel lblNewLabel_3 = new JLabel("Plz:");
		lblNewLabel_3.setBounds(10, 240, 46, 14);
		panel.add(lblNewLabel_3);
		
		
		plzlbl.setBounds(66, 240, 323, 14);
		panel.add(plzlbl);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(748, 11, 399, 499);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblZimmer = new JLabel("Zimmer");
		lblZimmer.setBounds(165, 11, 77, 32);
		lblZimmer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblZimmer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 54, 379, 2);
		panel_1.add(separator);
		
		JLabel lbl5 = new JLabel("Nummer:");
		lbl5.setBounds(10, 226, 53, 14);
		panel_1.add(lbl5);
		
		JLabel lbl4 = new JLabel("Preis/Nacht:");
		lbl4.setBounds(10, 201, 77, 14);
		panel_1.add(lbl4);
		
		
		preislbl.setBounds(105, 201, 284, 14);
		panel_1.add(preislbl);
		
		JLabel lbl3 = new JLabel("TV:");
		lbl3.setBounds(10, 176, 46, 14);
		panel_1.add(lbl3);
		
		
		tvlbl.setBounds(66, 176, 323, 14);
		panel_1.add(tvlbl);
		
		JLabel lbl1 = new JLabel("Eigenschaft:");
		lbl1.setBounds(10, 151, 85, 14);
		panel_1.add(lbl1);
		
		
		eigenlbl.setBounds(105, 151, 284, 14);
		panel_1.add(eigenlbl);
		
		JLabel lbl2 = new JLabel("Lage:");
		lbl2.setBounds(10, 126, 46, 14);
		panel_1.add(lbl2);
		
		
		lagelbl.setBounds(66, 126, 323, 14);
		panel_1.add(lagelbl);
		
		bettentxt = new JTextField();
		bettentxt.setColumns(10);
		bettentxt.setBounds(144, 92, 103, 20);
		panel_1.add(bettentxt);
		
		JButton button_3 = new JButton("");
		
		button_3.setIcon(new ImageIcon("C:\\Users\\FlorianGriesebner\\Documents\\GitHub\\Beer4free\\TestDrivenHotelDB\\icons\\Find24.gif"));
		button_3.setBounds(257, 92, 28, 22);
		panel_1.add(button_3);
		
		JLabel lblbeten = new JLabel("Betten");
		lblbeten.setBounds(144, 67, 100, 14);
		panel_1.add(lblbeten);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon("C:\\Users\\FlorianGriesebner\\Documents\\GitHub\\Beer4free\\TestDrivenHotelDB\\icons\\Back24.gif"));
		button_4.setBounds(127, 11, 28, 23);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_4.setEnabled(true);
				if(zcounter == zimmerl.size()-2){
					button_5.setEnabled(false);
				}
				zcounter++;
				displayZimmer(zimmerl.get(zcounter));
			}
		});
		button_5.setIcon(new ImageIcon("C:\\Users\\FlorianGriesebner\\Documents\\GitHub\\Beer4free\\TestDrivenHotelDB\\icons\\Forward24.gif"));
		button_5.setBounds(245, 11, 28, 23);
		panel_1.add(button_5);
		
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					button_5.setEnabled(true);
					if(zcounter == 1){
						button_4.setEnabled(false);
					}
					zcounter--;
					displayZimmer(zimmerl.get(zcounter));
			}
		});
		
		label.setBounds(66, 226, 284, 14);
		panel_1.add(label);
		
		JLabel lblBuchen = new JLabel("Buchen");
		lblBuchen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBuchen.setBounds(539, 120, 79, 25);
		frame.getContentPane().add(lblBuchen);
		
		vontxt = new JTextField();
		vontxt.setBounds(453, 193, 86, 20);
		frame.getContentPane().add(vontxt);
		vontxt.setColumns(10);
		
		JLabel lblVon = new JLabel("Von: (YYYY-MM-DD)");
		lblVon.setBounds(453, 168, 122, 14);
		frame.getContentPane().add(lblVon);
		
		JLabel lblBis = new JLabel("Bis: (YYYY-MM-DD)");
		lblBis.setBounds(609, 168, 115, 14);
		frame.getContentPane().add(lblBis);
		
		bistxt = new JTextField();
		bistxt.setColumns(10);
		bistxt.setBounds(609, 193, 86, 20);
		frame.getContentPane().add(bistxt);
		
		JCheckBox bezahltchk = new JCheckBox("Bezahtlt?");
		bezahltchk.setBounds(536, 232, 97, 23);
		frame.getContentPane().add(bezahltchk);
		
		JLabel lblPersonen = new JLabel("Personen:");
		lblPersonen.setBounds(532, 262, 65, 14);
		frame.getContentPane().add(lblPersonen);
		
		personentxt = new JTextField();
		personentxt.setColumns(10);
		personentxt.setBounds(532, 287, 86, 20);
		frame.getContentPane().add(personentxt);
		
		JButton btnBuchen = new JButton("Buchen");
		btnBuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buchung b = new Buchung(gastl.get(counter), zimmerl.get(zcounter), vontxt.getText(), bistxt.getText(), Integer.parseInt(personentxt.getText()), bezahltchk.isSelected());
				
				try {
					DBManager manager = DBManager.getInstance();
					manager.insertBuchung(b);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBuchen.setBounds(529, 343, 89, 23);
		frame.getContentPane().add(btnBuchen);
		
		JButton button_6 = new JButton("<-Buchungen");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DBManager manager = DBManager.getInstance();
					ArrayList<Buchung> buch = new ArrayList<Buchung>();
					buch = manager.readGidBuchung(Integer.parseInt(gastl.get(counter).getId()));
					BuchungView view = new BuchungView(buch);
					view.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_6.setBounds(429, 24, 122, 23);
		frame.getContentPane().add(button_6);
		
		JButton btnBuchungen = new JButton("Buchungen->");
		btnBuchungen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DBManager manager = DBManager.getInstance();
					ArrayList<Buchung> buch = new ArrayList<Buchung>();
					buch = manager.readZidBuchung(Integer.parseInt(zimmerl.get(zcounter).getId()));
					BuchungView view = new BuchungView(buch);
					view.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBuchungen.setBounds(609, 24, 122, 23);
		frame.getContentPane().add(btnBuchungen);
		
		JButton button_7 = new JButton("<-Buchungen->");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DBManager manager = DBManager.getInstance();
					ArrayList<Buchung> buch = new ArrayList<Buchung>();
					buch = manager.readAllBuchung();
					BuchungView view = new BuchungView(buch);
					view.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button_7.setBounds(510, 55, 137, 23);
		frame.getContentPane().add(button_7);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnStammdaten = new JMenu("Stammdaten");
		menuBar.add(mnStammdaten);
		
		JMenu mnAnlegen = new JMenu("Anlegen");
		mnStammdaten.add(mnAnlegen);
		
		
		JMenuItem mntmZimmer = new JMenuItem("Zimmer");
		mntmZimmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("gast");
				InsertZimmer zimmer = new InsertZimmer();
				zimmer.frame.setVisible(true);
			}
		});
		mnAnlegen.add(mntmZimmer);
		
		JMenuItem mntmGast = new JMenuItem("Gast");
		mntmGast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("gast");
				InsertGast gast = new InsertGast();
				gast.frame.setVisible(true);
			}
		});
		mnAnlegen.add(mntmGast);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_1.setEnabled(false);
				try {
					DBManager manager = DBManager.getInstance();
					gastl = manager.readGastbySurName(nachnametxt.getText());
					counter=0;
					if(gastl.size()>1){
						button_2.setEnabled(true);						
					}else{
						button_2.setEnabled(false);	
					}
					displayGast(gastl.get(counter));
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_4.setEnabled(false);
				try {
					DBManager manager = DBManager.getInstance();
					zimmerl = manager.readZimmerbyBetten(Integer.parseInt(bettentxt.getText()));
					zcounter=0;
					if(zimmerl.size()>1){
						button_5.setEnabled(true);						
					}else{
						button_5.setEnabled(false);												
					}
					displayZimmer(zimmerl.get(zcounter));
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
	public void displayZimmer(Zimmer z){
		lagelbl.setText(z.getLage());
		eigenlbl.setText(z.getEingenschaft());
		if(z.isFernseh()){
			tvlbl.setText("Vorhanden");
		}else{
			tvlbl.setText("Nicht Vorhanden");
		}
		preislbl.setText(z.getPreispronacht()+" �");
		System.out.println(z.getNummer());
		label.setText(z.getNummer());
	}
	
	public void displayGast(Gast g){
		nachnametxt.setText(g.getNachname());
		namelbl.setText(g.getName()+"");
		gdlbl.setText(g.getGebdat()+"");
		landlbl.setText(g.getLand());
		telefonlbl.setText(g.getNumber()+"");
		hnrlbl.setText(g.getHausnmr());
		plzlbl.setText(g.getPlz());
	}
}
