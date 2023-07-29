import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class CreateAccount extends JPanel {
	
	private JTextField firstnameTxt;
	private JTextField addressTxt;
	private JTextField phoneTxt;
	private JTextField emailTxt;
	private JComboBox genderBox;
	private JComboBox AccTypeBox;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField lastnameTxt;
	private String userN;
	private String pass;
	private String fName;
	private String lName;
	private String add; 
	private String gender;
	private String phone; 
	private String id;
	private String email;
	private String accountID;
	private String accountT;
	private boolean status;
	

	/**
	 * Create the panel.
	 */

	public enum Gender {
		Male,
		Female,
		None

	}
	public enum AccountType {
		Checking,
		SeriousSaver,
		FastSaver
	
	

	}
	
	public CreateAccount() {
		
		setVisible(false);
		setBounds(0, 0, 726, 405);
		setBackground(new Color(255, 250, 240));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(null);
		
		//id will be set depending on the length of the customerlist
		int idComp=BankSystem.getCustomerList().size()+1;
		String id= "00"+String.valueOf(idComp);
		JLabel idLabel = new JLabel(id);
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setForeground(Color.BLACK);
		idLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		idLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
		idLabel.setBounds(132, 75, 75, 30);
		add(idLabel);
		
		JPanel idpanel = new JPanel();
		idpanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		idpanel.setBackground(new Color(255, 250, 240));
		idpanel.setBounds(122, 75, 75, 30);
		add(idpanel);
		idpanel.setLayout(null);
		
		
		//JComboBox will use the enum that i created to show gender options
		DefaultComboBoxModel<Gender> gModel = new DefaultComboBoxModel<>(
		          Gender.values());
		JComboBox<Gender> genderBox = new JComboBox<Gender>(gModel);
		genderBox.setBackground(Color.WHITE);
		genderBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		genderBox.setBounds(122, 239, 200, 30);
		add(genderBox);
		
		//this will display an error message when first name requirement is not met
		JLabel Message1 = new JLabel("");
		Message1.setForeground(new Color(255, 99, 71));
		Message1.setFont(new Font("SansSerif", Font.ITALIC, 10));
		Message1.setBounds(122, 144, 114, 14);
		add(Message1);
		
		firstnameTxt = new JTextField();
		firstnameTxt.setBackground(new Color(255, 250, 240));
		firstnameTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		firstnameTxt.setBounds(122, 116, 200, 30);
		firstnameTxt.setForeground(Color.BLACK);
		firstnameTxt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		firstnameTxt.setColumns(10);
		add(firstnameTxt);
		firstnameTxt.addFocusListener(new FocusAdapter() {
			@Override
			//when it lost focus it will check if the first name contains any integer 
			public void focusLost(FocusEvent e) {
				boolean confirm=false;
				for(int i=0; i<firstnameTxt.getText().length(); i++) {
					confirm=Character.isDigit(firstnameTxt.getText().charAt(i)); {	
					}
				}
			if(confirm == true) {
				//if it does contain integer this message will be set as text for the message1
				Message1.setText("Invalid first name");
			}
			else {
				//otherwise message1 will be blank
				Message1.setText("");
			}
			}
		});


		//this will display an error message when last name requirement is not met
		JLabel Message2 = new JLabel("");
		Message2.setForeground(new Color(255, 99, 71));
		Message2.setFont(new Font("SansSerif", Font.ITALIC, 10));
		Message2.setBounds(122, 187, 114, 14);
		add(Message2);

		lastnameTxt = new JTextField();
		lastnameTxt.setBackground(new Color(255, 250, 240));
		lastnameTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		lastnameTxt.setForeground(Color.BLACK);
		lastnameTxt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lastnameTxt.setColumns(10);
		lastnameTxt.setBounds(122, 157, 200, 30);
		add(lastnameTxt);
		lastnameTxt.addFocusListener(new FocusAdapter() {
			@Override
			//same as first name this will also check for integer
			public void focusLost(FocusEvent e) {
				boolean confirm=false;
				for(int i=0; i<lastnameTxt.getText().length(); i++) {
					confirm=Character.isDigit(lastnameTxt.getText().charAt(i)); {	
					}
				}
			if(confirm == true) {
				Message2.setText("Invalid last name");
			}
			else {
				Message2.setText("");
			}
			}
		});
		
		addressTxt = new JTextField();
		addressTxt.setBackground(new Color(255, 250, 240));
		addressTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		addressTxt.setForeground(Color.BLACK);
		addressTxt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		addressTxt.setColumns(10);
		addressTxt.setBounds(122, 198, 200, 30);
		add(addressTxt);
		
		//this will display error message for character/string inputs
		JLabel Message3 = new JLabel("");
		Message3.setFont(new Font("SansSerif", Font.ITALIC, 10));
		Message3.setForeground(new Color(255, 99, 71));
		Message3.setBounds(122, 308, 114, 14);
		add(Message3);
		
		phoneTxt = new JTextField();
		phoneTxt.setBackground(new Color(255, 250, 240));
		phoneTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		phoneTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				//checking it by parsing with number format catch
				try {
					Integer.parseInt(phoneTxt.getText());
					Message3.setText("");
				} catch(NumberFormatException el) {
					Message3.setText("Invalid Phone Number");
				}	
				
			}
		});
		phoneTxt.setForeground(Color.BLACK);
		phoneTxt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(122, 280, 200, 30);
		add(phoneTxt);
		
		//this will display error for invalid email
		JLabel Message4 = new JLabel("");
		Message4.setForeground(new Color(255, 99, 71));
		Message4.setFont(new Font("SansSerif", Font.ITALIC, 10));
		Message4.setBounds(122, 349, 114, 14);
		add(Message4);
		
		emailTxt = new JTextField();
		emailTxt.setBackground(new Color(255, 250, 240));
		emailTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		emailTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					//less than a length of possible email will display error
					if(emailTxt.getText().contains("@") && emailTxt.getText().length()<5) {
						Message4.setText("Invalid Email Address");	
						
					}
					//if any of these conditions are met ,there will be no error
					else if (emailTxt.getText().contains("@") && (emailTxt.getText().substring(emailTxt.getText().length()-4,emailTxt.getText().length()).equalsIgnoreCase(".com") 
							|| emailTxt.getText().contains("@") && emailTxt.getText().substring(emailTxt.getText().length()-6,emailTxt.getText().length()).equalsIgnoreCase(".co.nz"))) {
						Message4.setText("");
					}
					//other than the conditions above it will display an error
					else {
						Message4.setText("Invalid Email Address");	
					}
					//including try and catch as user might input shorter string that the conditions
					//to avoid that error im using indexOutofBoundException
				} catch(IndexOutOfBoundsException ev) {
					
				}
			}	
			});
			
		emailTxt.setForeground(Color.BLACK);
		emailTxt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		emailTxt.setColumns(10);
		emailTxt.setBounds(122, 321, 200, 30);
		add(emailTxt);
		

		// still using an enum for account type option
		DefaultComboBoxModel<AccountType> aModel = new DefaultComboBoxModel<>(
		          AccountType.values());
		JComboBox<AccountType> AccTypeBox = new JComboBox<AccountType>(aModel);
		AccTypeBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		AccTypeBox.setBackground(Color.WHITE);
		AccTypeBox.setBounds(480, 115, 200, 30);
		add(AccTypeBox);
		
		// account id will also be based on the accountList size
		String accountID="A"+String.valueOf(BankSystem.getAccountList().size()+1);
		JLabel accID = new JLabel(accountID);
		accID.setHorizontalAlignment(SwingConstants.LEFT);
		accID.setForeground(Color.BLACK);
		accID.setFont(new Font("SansSerif", Font.PLAIN, 14));
		accID.setBorder(new EmptyBorder(0, 0, 0, 0));
		accID.setBounds(494, 74, 75, 30);
		add(accID);
		

		JPanel userpanel = new JPanel();
		userpanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		userpanel.setBackground(new Color(255, 250, 240));
		userpanel.setBounds(480, 155, 75, 30);
		add(userpanel);
		userpanel.setLayout(null);
		
		//username is using the customer id 
		userN="user"+id;
		JLabel usernameLabel = new JLabel(userN);
		usernameLabel.setBounds(10, 0, 74, 30);
		userpanel.add(usernameLabel);
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setForeground(Color.BLACK);
		usernameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		usernameLabel.setBackground(Color.WHITE);
		
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 250, 240));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 12));
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(480, 197, 200, 30);
		add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(new Color(255, 250, 240));
		passwordField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		passwordField_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		passwordField_1.setForeground(Color.GRAY);
		passwordField_1.setBounds(480, 240, 200, 30);
		add(passwordField_1);
		
		JButton saveButton = new JButton("SAVE");
		saveButton.setForeground(new Color(255, 250, 240));
		saveButton.setBorderPainted(false);
		saveButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		saveButton.setBackground(new Color(255, 99, 71));
		saveButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		saveButton.setBounds(398, 309, 103, 34);
		add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fName=firstnameTxt.getText();
				lName=lastnameTxt.getText();
				add=addressTxt.getText();
				phone=phoneTxt.getText();
				email=emailTxt.getText();
				gender= genderBox.getSelectedItem().toString();
				accountT= AccTypeBox.getSelectedItem().toString();
				
				//if any of the textfields are empty it will show message dialog to complete the form
				if (fName.equals("Ex. John") || fName.trim().isEmpty() ||
						(lName.equals("Ex. Smith") || lName.trim().isEmpty()) ||
						(add.equals("Ex.139 Carrington Road") || add.trim().isEmpty()) ||
						(phone.equals("Ex.02012345678") || phone.trim().isEmpty()) ||
						(email.equals("Ex.danica@gmail.com") || email.trim().isEmpty()) ||
						Message4.getText().equals("Invalid Email Address") || Message3.getText().equals("Invalid Phone Number") ||
						Message1.getText().equals("Invalid first name") || Message2.getText().equals("Invalid last name") ||
						passwordField.getText().trim().isEmpty() || passwordField_1.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please complete the form");
				}
				else {
					//if form is complete it will check if password is confirmed otherwise
					//password boarder will turn red and will clear the password textfields
					if (!passwordField.getText().equals(passwordField_1.getText())){
						passwordField.setBorder(new LineBorder(Color.RED, 3));
						passwordField_1.setBorder(new LineBorder(Color.RED, 3));
						passwordField.setText("");
						passwordField_1.setText("");
						JOptionPane.showMessageDialog(null, "Password did not match");
						status=false;
						}
						else {
						//if two password fields matches boarder will turn green
						pass=passwordField.getText();
						passwordField.setBorder(new LineBorder(Color.GREEN, 3));
						passwordField_1.setBorder(new LineBorder(Color.GREEN, 3));
						Customer cus=new Customer(id, fName, lName, add, gender, phone, email, userN, pass);
						//before adding the customer in the customerlist
						//this will check if customer already exist based on the inputed common information
						if(BankSystem.customerExist(cus)==true) {
							//if customer exist this will show a dialog to log in to the account instead
							JOptionPane.showMessageDialog(null, "Looks like you already have an account. Please log into your account!");
							Reset(Message3,Message4,genderBox,AccTypeBox,passwordField,passwordField_1);
						}
						else {
							//if customer does not exist in the customerlist 
							//account creation will proceed
							BankSystem.addCustomer(cus);
							BankAccount acc=new BankAccount(accountID,accountT,cus.getId());
							BankSystem.addAccount(acc);
							JOptionPane.showMessageDialog(null, "Account is successfully created. Please your username: "+cus.getUserName()+" to log into your account");
							status=true;
							setVisible(false);

						}		
									
					}
				}
			}
		
	});
				
				
					
		
		//Cancel button will clear and reset the form
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(new Color(255, 228, 181));
		cancelButton.setBorderPainted(false);
		cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
		cancelButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		cancelButton.setBounds(536, 308, 103, 34);
		add(cancelButton);
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//message diallog to confirm cancellation
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to cancel?","Exit Confirmation", JOptionPane.YES_NO_OPTION)== 0) {
					Reset(Message3,Message4,genderBox,AccTypeBox,passwordField,passwordField_1);
				}
			}
		});
		
		//these are the labels for the textfields
		JLabel labelID = new JLabel("Customer ID");
		labelID.setForeground(Color.BLACK);
		labelID.setBorder(null);
		labelID.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelID.setBounds(23, 75, 89, 30);
		add(labelID);
		
		JLabel labelfName = new JLabel("First Name");
		labelfName.setForeground(Color.BLACK);
		labelfName.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelfName.setBorder(null);
		labelfName.setBounds(23, 116, 89, 30);
		add(labelfName);
		
		JLabel labellName = new JLabel("Last Name");
		labellName.setForeground(Color.BLACK);
		labellName.setFont(new Font("SansSerif", Font.BOLD, 12));
		labellName.setBorder(null);
		labellName.setBounds(23, 157, 89, 30);
		add(labellName);
		
		JLabel labelAddress = new JLabel("Address");
		labelAddress.setForeground(Color.BLACK);
		labelAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelAddress.setBorder(null);
		labelAddress.setBounds(23, 202, 89, 30);
		add(labelAddress);
		
		JLabel labelGender = new JLabel("Gender");
		labelGender.setForeground(Color.BLACK);
		labelGender.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelGender.setBorder(null);
		labelGender.setBounds(23, 243, 89, 30);
		add(labelGender);
		
		JLabel labelPhone = new JLabel("Phone Number");
		labelPhone.setForeground(Color.BLACK);
		labelPhone.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelPhone.setBorder(null);
		labelPhone.setBounds(23, 284, 89, 30);
		add(labelPhone);
		
		JLabel labelEmail = new JLabel("Email Address");
		labelEmail.setForeground(Color.BLACK);
		labelEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelEmail.setBorder(null);
		labelEmail.setBounds(23, 325, 89, 30);
		add(labelEmail);
		
		JLabel labelUser = new JLabel("Username");
		labelUser.setForeground(Color.BLACK);
		labelUser.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelUser.setBorder(null);
		labelUser.setBounds(366, 161, 89, 30);
		add(labelUser);
		
		JLabel labelPass = new JLabel("Password");
		labelPass.setForeground(Color.BLACK);
		labelPass.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelPass.setBorder(null);
		labelPass.setBounds(366, 202, 89, 30);
		add(labelPass);
		
		JLabel labelPass_1 = new JLabel("Confirm Password");
		labelPass_1.setForeground(Color.BLACK);
		labelPass_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelPass_1.setBorder(null);
		labelPass_1.setBounds(366, 243, 114, 30);
		add(labelPass_1);
		
		JLabel lblNewLabel = new JLabel("CREATE YOUR ACCOUNT");
		lblNewLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(189, 26, 328, 38);
		add(lblNewLabel);
		
		JLabel lblAccountID = new JLabel("Account ID");
		lblAccountID.setForeground(Color.BLACK);
		lblAccountID.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAccountID.setBorder(null);
		lblAccountID.setBounds(366, 76, 89, 30);
		add(lblAccountID);
		
		JPanel accPanel = new JPanel();
		accPanel.setBackground(new Color(255, 250, 240));
		accPanel.setLayout(null);
		accPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		accPanel.setForeground(Color.BLACK);
		accPanel.setBounds(480, 74, 75, 30);
		add(accPanel);
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setForeground(Color.BLACK);
		lblAccountType.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAccountType.setBorder(null);
		lblAccountType.setBounds(366, 115, 89, 30);
		add(lblAccountType);
		
	}
	//this will get the status of create account panel which will trigger the component listener in the maindashboard
	public boolean getStatus() {
		return status;
	}
	//reset method for cancellation and customer exist
	public void Reset(JLabel m1 ,JLabel m2, JComboBox<Gender> c1, JComboBox<AccountType> c2,JPasswordField p1, JPasswordField p2  ) {
		firstnameTxt.setText("");
		lastnameTxt.setText("");
		addressTxt.setText("");
		phoneTxt.setText("");
		emailTxt.setText("");
		c1.setSelectedIndex(0);
		c2.setSelectedIndex(0);
		m1.setText("");
		m2.setText("");
		p1.setText("");
		p2.setText("");
		p1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		p2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
	}
	
	


}
