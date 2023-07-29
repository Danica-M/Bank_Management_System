import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainDashboard extends JFrame {

	int ymouse;
	int xmouse;
	
	private JPanel contentPane;
	//loading image into a image icon
	
	private Image img_logo= new ImageIcon(MainDashboard.class.getResource("/logo.png")).getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
	private Image img_home= new ImageIcon(MainDashboard.class.getResource("/home.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	private Image img_log= new ImageIcon(MainDashboard.class.getResource("/key.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	private Image img_reg= new ImageIcon(MainDashboard.class.getResource("/edit.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankSystem.read();
					MainDashboard frame = new MainDashboard();	
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
	public MainDashboard() {
		
		
		setBackground(new Color(255, 250, 240));
		//setUndercorated mean the frame header along with the accessibility icon will be disabled
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(95, 158, 160), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//creating objects of the JPanels that ill be needing on this MainDashboard Class
		//createA JPanel contains the form for creating account
		CreateAccount createA=new CreateAccount();
				
		//home JPanel contains information about the accounts, does not have any functions
		Home info=new Home();
		info.setBounds(0, 0, 726, 405);
						
		//log JPanel if an interface to allow customer to log in
		LoginPanel log=new LoginPanel();
					

		//this logoLabel will hold the img_logo global variable that was loaded with the an image
		JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(40, 1, 150, 135);
		contentPane.add(logoLabel);
		logoLabel.setIcon(new ImageIcon(img_logo));
		
			
				
		// this will hold the createA object and home
		//having these object inside a panel allows me to position on my liking
		JPanel dashboardContent = new JPanel();
		dashboardContent.setBorder(new EmptyBorder(0, 0, 0, 0));
		dashboardContent.setBackground(new Color(255, 250, 240));
		dashboardContent.setBounds(10, 114, 726, 405);
		contentPane.add(dashboardContent);
		dashboardContent.setLayout(null);
		dashboardContent.add(createA);
		dashboardContent.add(info);
		

		//this holds the login
		//log in panel is smaller therefore i needed to create this panel so i can center it
		JPanel subContent = new JPanel();
		subContent.setBorder(new EmptyBorder(0, 0, 0, 0));
		subContent.setBackground(new Color(255, 250, 240));
		subContent.setBounds(153, 41, 406, 286);
		dashboardContent.add(subContent);
		subContent.setLayout(null);
		subContent.add(log);
		
		
		//Component listeners of createA and log
		//since these objects are JPanel added into the MainDashboard frame i add component listener
		// these component listener will dispose() the mainDashboard when triggered
		createA.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				if(createA.getStatus() == true) {
					dispose();
					MainDashboard home=new MainDashboard();
					home.setVisible(true);}
			}
		});
		log.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				if(log.getStatus()== true) {
					dispose();
				}
			}
		});
		
		//menupanel holds all the menu such as home, create account and log in
		JPanel menupanel = new JPanel();
		menupanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		menupanel.setBackground(new Color(95, 158, 160));
		menupanel.setBounds(10, 51, 726, 52);
		contentPane.add(menupanel);
		menupanel.setLayout(null);
		
		//JPanels and Labels for the menu
		JPanel homepanel = new JPanel();
		homepanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		homepanel.setBackground(new Color(95, 158, 160));
		homepanel.setBounds(192, 0, 122, 52);
		menupanel.add(homepanel);
		homepanel.setLayout(null);
		
		JLabel homeLabel = new JLabel("HOME");
		homeLabel.setBounds(0, 0, 122, 52);
		homepanel.add(homeLabel);
		homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		homeLabel.setIcon(new ImageIcon(img_home));
		homeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JPanel CreatePanel = new JPanel();
		CreatePanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		CreatePanel.setBackground(new Color(95, 158, 160));
		CreatePanel.setBounds(319, 0, 196, 52);
		menupanel.add(CreatePanel);
		CreatePanel.setLayout(null);
		
		JLabel createLabel = new JLabel("CREATE ACCOUNT");
		createLabel.setBounds(10, 0, 196, 52);
		CreatePanel.add(createLabel);
		createLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		createLabel.setHorizontalAlignment(SwingConstants.CENTER);
		createLabel.setIcon(new ImageIcon(img_reg));
		
		JPanel LogPanel = new JPanel();
		LogPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		LogPanel.setBackground(new Color(95, 158, 160));
		LogPanel.setBounds(525, 0, 138, 52);
		menupanel.add(LogPanel);
		LogPanel.setLayout(null);
		
		JLabel loginLabel = new JLabel("LOG IN");
		loginLabel.setBounds(10, 0, 137, 52);
		LogPanel.add(loginLabel);
		loginLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setIcon(new ImageIcon(img_log));
		
		
		//mouselistener for mouse clicked event for the menu panels that i created
		// this mouseclicked listeners will hide the other two panels and who the corresponding panel to the clicked option
		//MenuButtonMouseAdapter a method that extends mouse adapter
		homepanel.addMouseListener(new MenuButtonMouseAdapter(homepanel) {
			public void mouseClicked(MouseEvent e) {
				log.setVisible(false);
				createA.setVisible(false);
				info.setVisible(true);
			}
		});
		CreatePanel.addMouseListener(new MenuButtonMouseAdapter(CreatePanel){
			public void mouseClicked(MouseEvent e) {
				log.setVisible(false);
				info.setVisible(false);
				createA.setVisible(true);
			}
			
		});
		
		LogPanel.addMouseListener(new MenuButtonMouseAdapter(LogPanel) {
			public void mouseClicked(MouseEvent e) {
				createA.setVisible(false);
				info.setVisible(false);
				log.setVisible(true);
			}
		});
		


		
		//since the frame is undercorated
		//i add frame accessibility options
		
		//exitlabel will exit the system when mouseclicked
		JLabel exitLabel = new JLabel("X");
		exitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this Application?","Exit Confirmation", JOptionPane.YES_NO_OPTION)== 0) {
					BankSystem.write();
					System.exit(0);
				}
			}
		});
		exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exitLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		exitLabel.setBounds(710, 1, 40, 41);
		contentPane.add(exitLabel);
		
		//minimizeLabel will iconify the frame when mouseclicked
		JLabel minimizeLabel = new JLabel("-");
		minimizeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(MainDashboard.ICONIFIED);
			}
		});
		minimizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		minimizeLabel.setBounds(674, 1, 40, 41);
		contentPane.add(minimizeLabel);
		
		//this will allow frame to be drag across the monitor
		JLabel FrameDrag = new JLabel("");
		FrameDrag.setBackground(new Color(255, 250, 240));
		FrameDrag.setForeground(new Color(255, 250, 240));
		FrameDrag.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xmouse=e.getX();
				ymouse=e.getX();	
			}
		});
		
		FrameDrag.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				MainDashboard.this.setLocation(x-xmouse,y-(ymouse/10));
			}
		});
		FrameDrag.setBounds(0, -1, 750, 52);
		contentPane.add(FrameDrag);
	}
	
	// this method will give change the colour when mouse is dragged or pressed on or across the panel.
	// this will give hovering effect
	public class MenuButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public MenuButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(175, 238, 238));
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(95, 158, 160));
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(175, 238, 238));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(95, 158, 160));
			}
	
	}
	
}


