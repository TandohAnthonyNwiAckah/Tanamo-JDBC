package ui;

/*Developer : TANDOH
 * Company  :Tanamo Inc.
 * Email: tanamoinc@gmail.com
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Gui extends JFrame implements ActionListener {

	// Initializing Components....
	private JLabel lb, lb1, lb2, lb3, lb4, lb5;
	private JTextField tf1, tf2, tf3, tf4, tf5;
	private JButton btn;
	private JMenuBar menubar;
	private JMenu m1, m2;

	private JMenuItem mi1;
	private JMenuItem mi2;
	private JMenuItem mi3;
	private JMenu mi4;
	private JMenuItem mi5;
	private JMenuItem mi6;

	// Creating Constructor...
	public Gui() {

		// Title
		super("Tanamo Inc.");

		lb5 = new JLabel("Enter Name:");
		lb5.setBounds(20, 20, 100, 20);

		tf5 = new JTextField("search", 20);
		tf5.setBackground(Color.GREEN);
		tf5.setBounds(130, 20, 200, 20);

		btn = new JButton("Submit");
		btn.setBounds(50, 50, 100, 20);
		btn.addActionListener(this);

		lb = new JLabel("Details");
		lb.setBounds(30, 80, 450, 30);
		lb.setForeground(Color.green);
		lb.setFont(new Font("Serif", Font.BOLD, 21));

		lb1 = new JLabel("Name:");
		lb1.setBounds(20, 120, 100, 20);

		tf1 = new JTextField(50);
		tf1.setBounds(130, 120, 200, 20);

		lb2 = new JLabel("Mail:");
		lb2.setBounds(20, 150, 100, 20);

		tf2 = new JTextField(100);
		tf2.setBounds(130, 150, 200, 20);

		lb3 = new JLabel("Phone:");
		lb3.setBounds(20, 180, 100, 20);

		tf3 = new JTextField(50);
		tf3.setBounds(130, 180, 200, 20);

		lb4 = new JLabel("Country:");
		lb4.setBounds(20, 210, 100, 20);

		tf4 = new JTextField(50);
		tf4.setBounds(130, 210, 100, 20);
		setLayout(null);

		menubar = new JMenuBar();
		m1 = new JMenu("File");
		m2 = new JMenu("Help");
		mi1 = new JMenuItem("Open");
		mi1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				File fil = new File("C://Users//TANDOH//Desktop//");

				if (fil.exists())
					JOptionPane.showMessageDialog(null, "can't Open !!! ", "Tanamo Inc", JOptionPane.WARNING_MESSAGE);

				else
					System.out.println(" it doesn't exist " + " on the desktop ");

			}
		});

		mi2 = new JMenuItem("Exit");
		class Tony implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent nana) {
				System.exit(0);
			}
		}

		mi2.addActionListener(new Tony());
		mi6 = new JMenuItem("New");
		mi6.addActionListener(new ActionListener() { // using inner class.
			@Override
			public void actionPerformed(ActionEvent e) {

				Gui n = new Gui();
				n.setVisible(true);
			}
		});

		mi3 = new JMenuItem("About");
		mi4 = new JMenu("Save");
		mi5 = new JMenuItem("Save As");
		setJMenuBar(menubar);
		menubar.add(m1);
		menubar.add(m2);

		m1.add(mi6);

		m1.add(mi1);

		m1.add(mi4);

		mi4.add(mi5);

		m1.add(mi2);

		m2.add(mi3);

		mi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(mi3, "...Produced by Tandoh.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// Add components to the JFrame ...

		add(tf5);
		add(lb5);
		add(btn);

		add(lb);
		add(lb1);
		add(tf1);
		add(lb2);

		add(tf2);
		add(lb3);
		add(tf3);
		add(lb4);
		add(tf4);

		// Set TextField Editable False
		tf1.setEditable(false);
		tf2.setEditable(false);
		tf3.setEditable(false);
		tf4.setEditable(false);
	}

	public void actionPerformed(ActionEvent e) {

		// DataBase Connection ...
		try {
			String str = tf5.getText();

			Class.forName("com.mysql.jdbc.Driver"); // for mysql database....

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");

			PreparedStatement st = con.prepareStatement("select * from mydb.emp where username =? ");
			st.setString(1, str);

			// Executing Query ...
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				String s = rs.getString(1);
				String s1 = rs.getString(2);
				String s2 = rs.getString(3);
				String s3 = rs.getString(4);

				// Sets Records in TextFields.
				tf1.setText(s);
				tf2.setText(s1);
				tf3.setText(s2);
				tf4.setText(s3);
			} else {
				JOptionPane.showMessageDialog(null, "worker not Found!!!");
			}

			// Create Exception Handler
		} catch (Exception ex) {

			System.out.println(ex);
		}
	}

}