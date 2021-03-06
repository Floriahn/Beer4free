package bibimpab;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InsertGast {

	JFrame frame;
	private JTextField nachnametxt;
	private JTextField nametxt;
	private JTextField GDtxt;
	private JTextField landtxt;
	private JTextField telefontxt;
	private JTextField hntxt;
	private JTextField plztxt;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InsertGast window = new InsertGast();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public InsertGast() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 399, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nachnametxt = new JTextField();
		nachnametxt.setBounds(44, 84, 86, 20);
		frame.getContentPane().add(nachnametxt);
		nachnametxt.setColumns(10);
		
		JLabel lblNeuerGast = new JLabel("Neuer Gast:");
		lblNeuerGast.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNeuerGast.setBounds(44, 11, 149, 31);
		frame.getContentPane().add(lblNeuerGast);
		
		JLabel lblNachname = new JLabel("Nachname*");
		lblNachname.setBounds(44, 53, 96, 20);
		frame.getContentPane().add(lblNachname);
		
		nametxt = new JTextField();
		nametxt.setBounds(251, 84, 86, 20);
		frame.getContentPane().add(nametxt);
		nametxt.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(249, 56, 65, 17);
		frame.getContentPane().add(lblName);
		
		GDtxt = new JTextField();
		GDtxt.setColumns(10);
		GDtxt.setBounds(44, 160, 86, 20);
		frame.getContentPane().add(GDtxt);
		
		JLabel lblGeburtsdatumyyyymmdd = new JLabel("Geburtsdatum (YYYY-MM-DD)*");
		lblGeburtsdatumyyyymmdd.setBounds(44, 132, 195, 20);
		frame.getContentPane().add(lblGeburtsdatumyyyymmdd);
		
		landtxt = new JTextField();
		landtxt.setBounds(251, 160, 86, 20);
		frame.getContentPane().add(landtxt);
		landtxt.setColumns(10);
		
		JLabel lblLand = new JLabel("Land*");
		lblLand.setBounds(249, 135, 65, 17);
		frame.getContentPane().add(lblLand);
		
		telefontxt = new JTextField();
		telefontxt.setBounds(44, 235, 86, 20);
		frame.getContentPane().add(telefontxt);
		telefontxt.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(44, 207, 65, 17);
		frame.getContentPane().add(lblTelefon);
		
		hntxt = new JTextField();
		hntxt.setColumns(10);
		hntxt.setBounds(251, 235, 86, 20);
		frame.getContentPane().add(hntxt);
		
		JLabel lblHausnummer = new JLabel("Hausnummer*");
		lblHausnummer.setBounds(249, 208, 104, 17);
		frame.getContentPane().add(lblHausnummer);
		
		plztxt = new JTextField();
		plztxt.setColumns(10);
		plztxt.setBounds(147, 307, 86, 20);
		frame.getContentPane().add(plztxt);
		
		JLabel lblPlz = new JLabel("PLZ*");
		lblPlz.setBounds(147, 279, 65, 17);
		frame.getContentPane().add(lblPlz);
		
		JButton btnNewButton = new JButton("Speichern");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gast g = new Gast(nachnametxt.getText(), GDtxt.getText(), plztxt.getText(), landtxt.getText(), hntxt.getText(), telefontxt.getText(), nametxt.getText());
				try {
					DBManager manager = DBManager.getInstance();
					manager.insertGast(g);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nachnametxt.setText(""); GDtxt.setText("");plztxt.setText("");landtxt.setText("");hntxt.setText("");telefontxt.setText("");nametxt.setText("");
			}
		});
		
		btnNewButton.setBounds(140, 359, 104, 31);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblMuss = new JLabel("* = muss angegeben werden");
		lblMuss.setBounds(10, 393, 256, 14);
		frame.getContentPane().add(lblMuss);
		
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
