import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class BuchungView {

	JFrame frame;
	private JTable table;
	
	private ArrayList<Buchung> blist = new ArrayList<Buchung>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BuchungView window = new BuchungView();
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
	public BuchungView(ArrayList<Buchung> list) {
		blist = list;
		initialize();
		addRows();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 725, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 227, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u00C4ndern");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x = table.getSelectedRow();
				
				try {
					DBManager manager = DBManager.getInstance();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					Buchung b = blist.get(x);
					b.setVon((String) model.getValueAt(x, 3));
					b.setBis((String) model.getValueAt(x, 4));
					b.setAnz(Integer.parseInt((String)model.getValueAt(x, 5)));
					b.setBezahlt((boolean) model.getValueAt(x, 6));
					manager.updateBuchung(b);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				addRows();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 11, 207, 183);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("L\u00F6schen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x = table.getSelectedRow();
				try {
					DBManager manager = DBManager.getInstance();
					manager.deleteBuchung(Integer.parseInt(blist.get(x).getId()));
					blist.remove(x);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				addRows();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(10, 205, 207, 184);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(234, 0, 485, 400);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 485, 400);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "ZID", "GID", "Von", "Bis", "Anz", "Bezahlt"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		scrollPane.setViewportView(table);
		
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	private void addRows(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowcount = model.getRowCount();
		for (int i = rowcount - 1; i >= 0; i--) {
		    model.removeRow(i);
		}
		
		
		Object rowData[] = new Object[7];
		System.out.println(blist.size());
		for (int i=0; i<blist.size();i++){
			rowData[0]=blist.get(i).getId();
			rowData[1]=blist.get(i).getZid();
			rowData[2]=blist.get(i).getGid();
			rowData[3]=blist.get(i).getVon();
			rowData[4]=blist.get(i).getBis();
			rowData[5]=blist.get(i).getAnz();
			rowData[6]=blist.get(i).isBezahlt();
			model.addRow(rowData);
		}
	}
}
