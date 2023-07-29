import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CustomerDashboard extends JFrame {

	private JPanel contentPane;
	private Image img_logo= new ImageIcon(CustomerDashboard.class.getResource("/logo.png")).getImage().getScaledInstance(120,120, Image.SCALE_SMOOTH);
	int ymouse;
	int xmouse;

	public CustomerDashboard(Customer cus) {
		setBackground(new Color(255, 250, 240));		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 530);
		contentPane = new JPanel();		
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(95, 158, 160), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Creating Jpanel objects that will be used for this customer dashboard
		DepositPanel deposit=new DepositPanel(cus);
		deposit.setBounds(0,  0, 327, 325);
		
		WithdrawPanel withdraw=new WithdrawPanel(cus);
		withdraw.setBounds(0,  0, 327, 325);
		
		TransferPanel transfer= new TransferPanel(cus);
		transfer.setBounds(0,  0, 327, 325);
		
		AccountDetailsPanel account=new AccountDetailsPanel(cus);
		account.setBounds(0,  0, 327, 325);
		
		OpenAccount open=new OpenAccount(cus);
		open.setBounds(0,  0, 327, 325);
		
		UpdatePanel update= new UpdatePanel(cus);
		update.setBounds(0, 0, 386, 460);
		
		Profile profile=new Profile(cus);
		profile.setBounds(0, 0, 386, 460);
		
		Transaction transac=new Transaction(cus);
		transac.setBounds(0, 0, 386, 460);
		
		DeleteAccount delete=new DeleteAccount(cus);
		delete.setBounds(0,  0, 327, 325);
		
		
		
		//component listeners of the JPanel objects
		deposit.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				if(deposit.getStatus()== true) {
					dispose();
					CustomerDashboard userdash=new CustomerDashboard(cus);
					userdash.setVisible(true);
				}
			}
		});
		
		withdraw.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				if(withdraw.getStatus()== true) {
					dispose();
					CustomerDashboard userdash=new CustomerDashboard(cus);
					userdash.setVisible(true);
				}
			}
		});
		
		transfer.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				if(transfer.getStatus()== true) {
					dispose();
					CustomerDashboard userdash=new CustomerDashboard(cus);
					userdash.setVisible(true);
				}
			}
		});
		
		account.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				if(account.getStatus()== true) {
					dispose();
					CustomerDashboard userdash=new CustomerDashboard(cus);
					userdash.setVisible(true);
				}
			}
		});
		open.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				if(open.getStatus()== true) {
					dispose();
					CustomerDashboard userdash=new CustomerDashboard(cus);
					userdash.setVisible(true);
				}
			}
		});
		
		update.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				if(update.getStatus()== true) {
					dispose();
					CustomerDashboard userdash=new CustomerDashboard(cus);
					userdash.setVisible(true);
				}
			}
		});
		
		transac.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				if(transac.getStatus()== true) {
					dispose();
					CustomerDashboard userdash=new CustomerDashboard(cus);
					userdash.setVisible(true);
				}
			}
		});

		delete.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				if(delete.getStatus()== true) {
					dispose();
					CustomerDashboard userdash=new CustomerDashboard(cus);
					userdash.setVisible(true);
				}
			}
		});
		
		
		//contentPanel and subcontentPanel will hold the JPanel objects in place
		JPanel Contentpanel = new JPanel();
		Contentpanel.setBackground(new Color(255, 250, 240));
		Contentpanel.setBounds(282, 36, 386, 460);
		contentPane.add(Contentpanel);
		Contentpanel.setLayout(null);
		Contentpanel.add(update);
		Contentpanel.add(transac);
		Contentpanel.add(profile);

		JPanel SubContentPanel = new JPanel();
		SubContentPanel.setBackground(new Color(255, 250, 240));
		SubContentPanel.setBounds(0, 0, 327, 325);
		Contentpanel.add(SubContentPanel);
		SubContentPanel.setLayout(null);
		SubContentPanel.add(deposit);
		SubContentPanel.add(withdraw);
		SubContentPanel.add(transfer);
		SubContentPanel.add(account);
		SubContentPanel.add(open);
		SubContentPanel.add(delete);
		
		//initially all the Jpanels will not be visible except for the profile panel
		update.setVisible(false);
		withdraw.setVisible(false);
		transfer.setVisible(false);
		account.setVisible(false);
		deposit.setVisible(false);
		open.setVisible(false);
		transac.setVisible(false);
		delete.setVisible(false);
		profile.setVisible(true);
		
		//actionPerformed on this deposit button will hide the other panels except of the deposit
		JButton btnDeposit = new JButton("DEPOSIT");
		btnDeposit.setBorderPainted(false);
		btnDeposit.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnDeposit.setBackground(new Color(95, 158, 160));
		btnDeposit.setForeground(new Color(255, 250, 240));
		btnDeposit.addMouseListener(new MenuButtonMouseAdapter(btnDeposit));
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw.setVisible(false);
				transfer.setVisible(false);
				account.setVisible(false);
				update.setVisible(false);
				open.setVisible(false);
				transac.setVisible(false);
				profile.setVisible(false);
				delete.setVisible(false);
				deposit.setVisible(true);
				
			}
		});
		btnDeposit.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDeposit.setBounds(27, 198, 212, 29);
		getContentPane().add(btnDeposit);
		
		//just like the deposit button when clicking each button corresponding panel will be visible 
		//and hide the rest
		JButton btnWithdraw = new JButton("WITHDRAW");
		btnWithdraw.setBorderPainted(false);
		btnWithdraw.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnWithdraw.setBackground(new Color(95, 158, 160));
		btnWithdraw.setForeground(new Color(255, 250, 240));
		btnWithdraw.addMouseListener(new MenuButtonMouseAdapter(btnWithdraw));
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposit.setVisible(false);
				transfer.setVisible(false);
				account.setVisible(false);
				update.setVisible(false);
				open.setVisible(false);
				profile.setVisible(false);
				transac.setVisible(false);
				delete.setVisible(false);
				withdraw.setVisible(true);
			}
		});
		btnWithdraw.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnWithdraw.setBounds(27, 233, 212, 29);
		getContentPane().add(btnWithdraw);
		
		//just like the deposit button when clicking each button corresponding panel will be visible 
		//and hide the rest
		JButton btnTransfer = new JButton("TRANSFER");
		btnTransfer.setBorderPainted(false);
		btnTransfer.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnTransfer.setBackground(new Color(95, 158, 160));
		btnTransfer.setForeground(new Color(255, 250, 240));
		btnTransfer.addMouseListener(new MenuButtonMouseAdapter(btnTransfer));
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposit.setVisible(false);
				withdraw.setVisible(false);
				account.setVisible(false);
				update.setVisible(false);
				open.setVisible(false);
				profile.setVisible(false);
				transac.setVisible(false);
				delete.setVisible(false);
				transfer.setVisible(true);
			}
		});
		btnTransfer.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnTransfer.setBounds(27, 270, 212, 29);
		getContentPane().add(btnTransfer);
		
		//just like the deposit button when clicking each button corresponding panel will be visible 
		//and hide the rest
		JButton btnTransactionHistory = new JButton("TRANSACTION HISTORY");
		btnTransactionHistory.setBorderPainted(false);
		btnTransactionHistory.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnTransactionHistory.setBackground(new Color(95, 158, 160));
		btnTransactionHistory.setForeground(new Color(255, 250, 240));
		btnTransactionHistory.addMouseListener(new MenuButtonMouseAdapter(btnTransactionHistory));
		btnTransactionHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw.setVisible(false);
				transfer.setVisible(false);
				account.setVisible(false);
				update.setVisible(false);
				open.setVisible(false);
				profile.setVisible(false);
				deposit.setVisible(false);
				delete.setVisible(false);
				transac.setVisible(true);
			}
		});
		btnTransactionHistory.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnTransactionHistory.setBounds(27, 310, 212, 29);
		getContentPane().add(btnTransactionHistory);
		
		//just like the deposit button when clicking each button corresponding panel will be visible 
		//and hide the rest
		JButton btnAccountDetails = new JButton("ACCOUNT DETAILS");
		btnAccountDetails.setBorderPainted(false);
		btnAccountDetails.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAccountDetails.setBackground(new Color(95, 158, 160));
		btnAccountDetails.setForeground(new Color(255, 250, 240));
		btnAccountDetails.addMouseListener(new MenuButtonMouseAdapter(btnAccountDetails));
		btnAccountDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposit.setVisible(false);
				withdraw.setVisible(false);
				transfer.setVisible(false);
				update.setVisible(false);
				open.setVisible(false);
				transac.setVisible(false);
				profile.setVisible(false);
				delete.setVisible(false);
				account.setVisible(true);
			}
		});
		btnAccountDetails.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAccountDetails.setBounds(27, 160, 212, 29);
		getContentPane().add(btnAccountDetails);
		
		//just like the deposit button when clicking each button corresponding panel will be visible 
		//and hide the rest
		JButton btnOpenAccount = new JButton("OPEN ACCOUNT");
		btnOpenAccount.setBorderPainted(false);
		btnOpenAccount.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnOpenAccount.setBackground(new Color(95, 158, 160));
		btnOpenAccount.setForeground(new Color(255, 250, 240));
		btnOpenAccount.addMouseListener(new MenuButtonMouseAdapter(btnOpenAccount));
		btnOpenAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposit.setVisible(false);
				withdraw.setVisible(false);
				transfer.setVisible(false);
				update.setVisible(false);
				account.setVisible(false);
				transac.setVisible(false);
				profile.setVisible(false);
				delete.setVisible(false);
				open.setVisible(true);
			}
		});
		btnOpenAccount.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnOpenAccount.setBounds(27, 350, 212, 29);
		contentPane.add(btnOpenAccount);
		
		//just like the deposit button when clicking each button corresponding panel will be visible 
		//and hide the rest
		JButton btnUpdateDetails = new JButton("UPDATE DETAILS");
		btnUpdateDetails.setBorderPainted(false);
		btnUpdateDetails.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnUpdateDetails.setBackground(new Color(95, 158, 160));
		btnUpdateDetails.setForeground(new Color(255, 250, 240));
		btnUpdateDetails.addMouseListener(new MenuButtonMouseAdapter(btnUpdateDetails));
		btnUpdateDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposit.setVisible(false);
				withdraw.setVisible(false);
				transfer.setVisible(false);
				account.setVisible(false);
				open.setVisible(false);
				transac.setVisible(false);
				profile.setVisible(false);
				delete.setVisible(false);
				update.setVisible(true);
			}
		});
		btnUpdateDetails.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnUpdateDetails.setBounds(27, 427, 212, 29);
		contentPane.add(btnUpdateDetails);
		
		//log out will dispose() customer dashboard and will open up the main dashboard
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setBorderPainted(false);
		btnLogOut.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnLogOut.setBackground(new Color(95, 158, 160));
		btnLogOut.setForeground(new Color(255, 250, 240));
		btnLogOut.addMouseListener(new MenuButtonMouseAdapter(btnLogOut));
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//will reconfirm before disposing
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to log out?","Exit Confirmation", JOptionPane.YES_NO_OPTION)== 0) {
					dispose();
					MainDashboard home=new MainDashboard();
					home.setVisible(true);
				}
			}
		});
		btnLogOut.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnLogOut.setBounds(27, 467, 212, 29);
		contentPane.add(btnLogOut);
		
		//just like the deposit button when clicking each button corresponding panel will be visible 
		//and hide the rest
		JButton btnProfile = new JButton("PROFILE");
		btnProfile.setBorderPainted(false);
		btnProfile.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnProfile.setBackground(new Color(95, 158, 160));
		btnProfile.setForeground(new Color(255, 250, 240));
		btnProfile.addMouseListener(new MenuButtonMouseAdapter(btnProfile));
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposit.setVisible(false);
				withdraw.setVisible(false);
				transfer.setVisible(false);
				account.setVisible(false);
				open.setVisible(false);
				transac.setVisible(false);
				update.setVisible(false);
				delete.setVisible(false);
				profile.setVisible(true);
			}
		});
		btnProfile.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnProfile.setBounds(27, 120, 212, 29);
		contentPane.add(btnProfile);
		
		//just like the deposit button when clicking each button corresponding panel will be visible 
		//and hide the rest
		JButton btnDeleteAccount = new JButton("DELETE ACCOUNT");
		btnDeleteAccount.setBorderPainted(false);
		btnDeleteAccount.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnDeleteAccount.setBackground(new Color(95, 158, 160));
		btnDeleteAccount.setForeground(new Color(255, 250, 240));
		btnDeleteAccount.addMouseListener(new MenuButtonMouseAdapter(btnDeleteAccount));
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposit.setVisible(false);
				withdraw.setVisible(false);
				transfer.setVisible(false);
				account.setVisible(false);
				open.setVisible(false);
				transac.setVisible(false);
				update.setVisible(false);
				profile.setVisible(false);
				delete.setVisible(true);
			}
		});
		btnDeleteAccount.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDeleteAccount.setBounds(27, 390, 212, 29);
		contentPane.add(btnDeleteAccount);
		
		//clicking the logo will bring you back to the main dashboard 
		JLabel logoLabel = new JLabel("");
		logoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//will reconfirm before disposing
				if(JOptionPane.showConfirmDialog(null,"Do you want to go bank to the main dashboard?","Exit Confirmation", JOptionPane.YES_NO_OPTION)== 0) {
					dispose();
					MainDashboard home=new MainDashboard();
					home.setVisible(true);
				}
			}
		});
		logoLabel.setBounds(10, 11, 115, 111);
		contentPane.add(logoLabel);
		logoLabel.setIcon(new ImageIcon(img_logo));

		JLabel userLabel = new JLabel("Hi "+cus.getFirstName()+" !");
		userLabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		userLabel.setBounds(115, 50, 157, 29);
		contentPane.add(userLabel);
		
		
		//Window accessibility as explained in the main dashboard
		JLabel exitLabel = new JLabel("X");
		exitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to log out?","Exit Confirmation", JOptionPane.YES_NO_OPTION)== 0) {
					dispose();
					MainDashboard home=new MainDashboard();
					home.setVisible(true);
				}
			}
		});
		exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exitLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		exitLabel.setBounds(710, 1, 40, 41);
		contentPane.add(exitLabel);
		
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
				CustomerDashboard.this.setLocation(x-xmouse,y-(ymouse/10));
			}
		});
		
		FrameDrag.setBounds(0, -1, 750, 41);
		contentPane.add(FrameDrag);
		
		
	}
	
	//will change the color of the buttons when hovered this is to show emphasize each button
	public class MenuButtonMouseAdapter extends MouseAdapter{
		JButton button;
		public MenuButtonMouseAdapter(JButton button) {
			this.button=button;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			button.setBackground(new Color(72, 209, 204));
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			button.setBackground(new Color(95, 158, 160));
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			button.setBackground(new Color(72, 209, 204));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			button.setBackground(new Color(95, 158, 160));
			}
	
}

}

	
