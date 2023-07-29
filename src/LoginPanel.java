import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

public class LoginPanel extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private boolean status;
	
	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setBounds(0,0,406,286);
		setBackground(new Color(255, 250, 240));
		setBorder(new LineBorder(new Color(95, 158, 160), 4));
		setLayout(null);
		setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(95, 158, 160), 2));
		panel.setBackground(Color.WHITE);
		panel.setBounds(77, 78, 250, 42);
		add(panel);
		panel.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//once username field gained focus and value is still the default "username" it will set the textfiel into empty
				if(usernameField.getText().equals("USERNAME")) {
					usernameField.setText("");
				}
				else {
					//otherwise when it gained focus and value is different it will just select all the text
					usernameField.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				//when it lost focus and it is empty it will return back to its default text "username"
				if(usernameField.getText().equals(""))
					usernameField.setText("USERNAME");
			}
		});
		usernameField.setBorder(null);
		usernameField.setFont(new Font("SansSerif", Font.PLAIN, 12));
		usernameField.setText("USERNAME");
		usernameField.setBounds(10, 11, 200, 20);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(95, 158, 160), 2));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(77, 131, 250, 42);
		add(panel_1);
		panel_1.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 12));
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//same as username field when gained focus with its default value it will set the text field into empty
				if(passwordField.getText().equals("PASSWORD")) {
					passwordField.setText("");
					passwordField.setEchoChar(('*'));
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				//when empty it will set "password" and disable the echo char 
				if(passwordField.getText().equals("")) {
					passwordField.setText("PASSWORD");
					passwordField.setEchoChar((char)0);
				}
					
			}
		});
		passwordField.setBorder(null);
		passwordField.setEchoChar((char)0);
		passwordField.setText("PASSWORD");
		passwordField.setBounds(10, 11, 200, 20);
		panel_1.add(passwordField);

		JPanel loginPanelB = new JPanel();
		loginPanelB.addMouseListener(new MouseAdapter() {
			//disables the .getText method warning from passwordField
			@Override
			public void mouseEntered(MouseEvent e) {
				loginPanelB.setBackground(new Color(255, 160, 122));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				loginPanelB.setBackground(new Color(255, 99, 71));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//if customer username or password is empty or still have the default text it will show a message dialog
				if (usernameField.getText().equals("") || usernameField.getText().equals("USERNAME") ||
						passwordField.getText().equals("") || passwordField.getText().equals("PASSWORD")) {
					JOptionPane.showMessageDialog(null, "Please enter your username and password");
				}
				else {
					//otherwise it will check if username and password is the same as any of the customer in the customerlist
					for(Customer cus: BankSystem.getCustomerList()) {
						if(usernameField.getText().equals(cus.getUserName()) && 
								passwordField.getText().equals(cus.getPassWord())) {
							System.out.print("ok");
							status=true;
							setVisible(false);
							CustomerDashboard userdash=new CustomerDashboard(cus);
							userdash.setVisible(true);
							//if it matches user will be redirected to the customer dashboard
						}
					} 
					//otherwise it will show a error message dialog
					if(status==false){
						JOptionPane.showMessageDialog(null, "Username and Password does not match");
					}
				}
				
			}
				
			
		});
					
			
		loginPanelB.setBorder(new EmptyBorder(0, 0, 0, 0));
		loginPanelB.setBackground(new Color(255, 99, 71));
		loginPanelB.setBounds(77, 192, 250, 42);
		add(loginPanelB);
		loginPanelB.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(255, 250, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(93, 0, 67, 42);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		loginPanelB.add(lblNewLabel);
		
		JLabel loginLabel = new JLabel("Log in to Your Account");
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Rockwell", Font.BOLD, 16));
		loginLabel.setBounds(77, 35, 250, 32);
		add(loginLabel);
	


	}
	//status of the login page which will also trigger the component listener in main dashboard
	public boolean getStatus() {
		return status;
	}

}
