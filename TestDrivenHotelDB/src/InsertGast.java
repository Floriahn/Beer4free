import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class InsertGast {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertGast window = new InsertGast();
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
	public InsertGast() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 399, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(44, 84, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNeuerGast = new JLabel("Neuer Gast:");
		lblNeuerGast.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNeuerGast.setBounds(44, 11, 149, 31);
		frame.getContentPane().add(lblNeuerGast);
		
		JLabel lblNachname = new JLabel("Nachname*");
		lblNachname.setBounds(44, 53, 65, 20);
		frame.getContentPane().add(lblNachname);
		
		textField_1 = new JTextField();
		textField_1.setBounds(251, 84, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(249, 56, 65, 17);
		frame.getContentPane().add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(44, 160, 86, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblGeburtsdatumyyyymmdd = new JLabel("Geburtsdatum (YYYY-MM-DD)*");
		lblGeburtsdatumyyyymmdd.setBounds(44, 132, 149, 20);
		frame.getContentPane().add(lblGeburtsdatumyyyymmdd);
		
		textField_3 = new JTextField();
		textField_3.setBounds(251, 160, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblLand = new JLabel("Land*");
		lblLand.setBounds(249, 135, 65, 17);
		frame.getContentPane().add(lblLand);
		
		textField_4 = new JTextField();
		textField_4.setBounds(44, 235, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(44, 207, 65, 17);
		frame.getContentPane().add(lblTelefon);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(251, 235, 86, 20);
		frame.getContentPane().add(textField_5);
		
		JLabel lblHausnummer = new JLabel("Hausnummer*");
		lblHausnummer.setBounds(249, 208, 104, 17);
		frame.getContentPane().add(lblHausnummer);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(147, 307, 86, 20);
		frame.getContentPane().add(textField_6);
		
		JLabel lblPlz = new JLabel("PLZ*");
		lblPlz.setBounds(147, 279, 65, 17);
		frame.getContentPane().add(lblPlz);
	}
}
