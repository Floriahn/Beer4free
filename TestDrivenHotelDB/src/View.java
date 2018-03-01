import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View {

	private JFrame frame;

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
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1010, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
	}
	
}
