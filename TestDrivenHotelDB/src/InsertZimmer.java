import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InsertZimmer {

	JFrame frame;
	private JTextField bettentxt;
	private JTextField lagetxt;
	private JTextField eigenschafttxt;
	private JTextField preistxt;
	private JTextField nummertxt;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InsertZimmer window = new InsertZimmer();
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
	public InsertZimmer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 399, 358);
		frame.getContentPane().setLayout(null);
		
		bettentxt = new JTextField();
		bettentxt.setColumns(10);
		bettentxt.setBounds(44, 73, 86, 20);
		frame.getContentPane().add(bettentxt);
		
		JLabel lblNeuesZimmer = new JLabel("Neues Zimmer:");
		lblNeuesZimmer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNeuesZimmer.setBounds(44, 0, 149, 31);
		frame.getContentPane().add(lblNeuesZimmer);
		
		JLabel lblBetten = new JLabel("Betten*");
		lblBetten.setBounds(44, 42, 96, 20);
		frame.getContentPane().add(lblBetten);
		
		lagetxt = new JTextField();
		lagetxt.setColumns(10);
		lagetxt.setBounds(251, 73, 86, 20);
		frame.getContentPane().add(lagetxt);
		
		JLabel lagelbl = new JLabel("Lage*");
		lagelbl.setBounds(249, 45, 65, 17);
		frame.getContentPane().add(lagelbl);
		
		eigenschafttxt = new JTextField();
		eigenschafttxt.setColumns(10);
		eigenschafttxt.setBounds(44, 149, 86, 20);
		frame.getContentPane().add(eigenschafttxt);
		
		JLabel lblEigenschaft = new JLabel("Eigenschaft");
		lblEigenschaft.setBounds(44, 121, 195, 20);
		frame.getContentPane().add(lblEigenschaft);
		
		JLabel lblFernseher = new JLabel("Fernseher*");
		lblFernseher.setBounds(249, 124, 65, 17);
		frame.getContentPane().add(lblFernseher);
		
		preistxt = new JTextField();
		preistxt.setColumns(10);
		preistxt.setBounds(44, 224, 86, 20);
		frame.getContentPane().add(preistxt);
		
		JLabel lblPreisnacht = new JLabel("Preis/Nacht*");
		lblPreisnacht.setBounds(44, 196, 114, 17);
		frame.getContentPane().add(lblPreisnacht);
		
		nummertxt = new JTextField();
		nummertxt.setColumns(10);
		nummertxt.setBounds(251, 224, 86, 20);
		frame.getContentPane().add(nummertxt);
		
		JLabel lblNummer = new JLabel("Nummer*");
		lblNummer.setBounds(249, 197, 104, 17);
		frame.getContentPane().add(lblNummer);
		
		JLabel label_8 = new JLabel("* = muss angegeben werden");
		label_8.setBounds(10, 307, 256, 14);
		frame.getContentPane().add(label_8);
		
		JCheckBox fernchk = new JCheckBox("Vorhanden");
		fernchk.setBounds(251, 148, 97, 23);
		frame.getContentPane().add(fernchk);
		
		JButton button = new JButton("Speichern");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Zimmer z = new Zimmer(nummertxt.getText(), Integer.parseInt(bettentxt.getText()), fernchk.isSelected(), lagetxt.getText(), Double.parseDouble(preistxt.getText()), eigenschafttxt.getText());
				
				try {
					DBManager manager = DBManager.getInstance();
					manager.insertZimmer(z);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nummertxt.setText("");bettentxt.setText("");fernchk.setEnabled(false);lagetxt.setText("");preistxt.setText("");eigenschafttxt.setText("");
			}
		});
		button.setBounds(139, 265, 104, 31);
		frame.getContentPane().add(button);
		
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
