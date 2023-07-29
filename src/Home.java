import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

public class Home extends JPanel {
	private Image banner= new ImageIcon(Home.class.getResource("/banner.png")).getImage().getScaledInstance(300,350, Image.SCALE_SMOOTH);
	private Image accountDetails= new ImageIcon(Home.class.getResource("/Accounts.png")).getImage().getScaledInstance(350,390, Image.SCALE_SMOOTH);
	
	
	//this panel will only display the bank account information 
	//to mimic real customer based bank application
	public Home() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(new Color(255, 250, 240));
		
		setBounds(0, 0, 726, 405);
		setLayout(null);
		JLabel bannerholder = new JLabel("");
		bannerholder.setBounds(36, 44, 300, 350);
		add(bannerholder);
		bannerholder.setIcon(new ImageIcon(banner));
		
		JLabel accountdetailsLabel = new JLabel("");
		accountdetailsLabel.setBounds(367, 0, 349, 405);
		add(accountdetailsLabel);
		accountdetailsLabel.setIcon(new ImageIcon(accountDetails));
		

	}
}
