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

public class View {

	private JFrame frame;
	private JTextField nachnametxt;
	
	public int counter =0;
	
	ArrayList<Gast> gastl = new ArrayList<>();

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
	
	private void initialize() {
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
		lblZimmer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblZimmer.setBounds(165, 11, 77, 32);
		panel_1.add(lblZimmer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 54, 379, 2);
		panel_1.add(separator);
		
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
				button_2.setEnabled(true);
				try {
					DBManager manager = DBManager.getInstance();
					gastl = manager.readGastbySurName(nachnametxt.getText());
					counter=0;
					displayGast(gastl.get(counter));
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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
