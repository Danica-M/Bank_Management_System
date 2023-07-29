import java.awt.Color;


import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class UpdatePanel extends JPanel {
	private JTextField firstnameTxt;
	private JTextField lastnameTxt;
	private JTextField addressTxt;
	private JTextField phoneTxt;
	private JTextField emailTxt;
	private JTextField genderTxt;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField currentpass;
	private String id;
	private String fname;
	private String lname;
	private String add;
	private String gender;
	private String phone;
	private String email;
	private String user;
	private String pass;
	private boolean status;
	

	/**
	 * Create the panel.
	 */
	public UpdatePanel(Customer cus) {
		
		setBorder(new LineBorder(new Color(95, 158, 160), 2));
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		
		
		
		id=cus.getId();
		fname=cus.getFirstName();
		lname=cus.getLastName();
		add=cus.getAddress();
		gender=cus.getGender();
		phone=cus.getPhone();
		email=cus.getEmail();
		user=cus.getUserName();
		pass=cus.getPassWord();
		
		JLabel idLabel = new JLabel(id);
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setForeground(Color.BLACK);
		idLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		idLabel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		idLabel.setBounds(110, 29, 68, 31);
		add(idLabel);
		
		JLabel labelID = new JLabel("Customer ID:");
		labelID.setForeground(Color.BLACK);
		labelID.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		labelID.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelID.setBounds(25, 30, 96, 30);
		add(labelID);
		
		
		firstnameTxt=new JTextField(fname);
		firstnameTxt.setBackground(new Color(255, 250, 240));
		firstnameTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		firstnameTxt.setBounds(115, 56, 166, 30);
		firstnameTxt.setForeground(Color.BLACK);
		firstnameTxt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		firstnameTxt.setColumns(10);
		add(firstnameTxt);
		

		lastnameTxt = new JTextField(lname);
		lastnameTxt.setBackground(new Color(255, 250, 240));
		lastnameTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		lastnameTxt.setForeground(Color.BLACK);
		lastnameTxt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lastnameTxt.setColumns(10);
		lastnameTxt.setBounds(115, 86, 166, 30);
		add(lastnameTxt);
		
		addressTxt = new JTextField(add);
		addressTxt.setBackground(new Color(255, 250, 240));
		addressTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		addressTxt.setForeground(Color.BLACK);
		addressTxt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		addressTxt.setColumns(10);
		addressTxt.setBounds(115, 116, 166, 30);
		add(addressTxt);
		
		genderTxt = new JTextField(gender);
		genderTxt.setBackground(new Color(255, 250, 240));
		genderTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		genderTxt.setForeground(Color.BLACK);
		genderTxt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		genderTxt.setColumns(10);
		genderTxt.setBounds(115, 147, 166, 30);
		add(genderTxt);
		
		phoneTxt = new JTextField(phone);
		phoneTxt.setBackground(new Color(255, 250, 240));
		phoneTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		phoneTxt.setForeground(Color.BLACK);
		phoneTxt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(115, 177, 166, 30);
		add(phoneTxt);
		
		emailTxt = new JTextField(email);
		emailTxt.setBackground(new Color(255, 250, 240));
		emailTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		emailTxt.setForeground(Color.BLACK);
		emailTxt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		emailTxt.setColumns(10);
		emailTxt.setBounds(115, 207, 166, 30);
		add(emailTxt);
		
		JLabel labelfName = new JLabel("First Name:");
		labelfName.setForeground(Color.BLACK);
		labelfName.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelfName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		labelfName.setBounds(25, 56, 96, 30);
		add(labelfName);
		
		JLabel labellName = new JLabel("Last Name:");
		labellName.setForeground(Color.BLACK);
		labellName.setFont(new Font("SansSerif", Font.BOLD, 12));
		labellName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		labellName.setBounds(25, 86, 96, 30);
		add(labellName);
		
		JLabel labelAddress = new JLabel("Address:");
		labelAddress.setForeground(Color.BLACK);
		labelAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelAddress.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		labelAddress.setBounds(25, 116, 96, 30);
		add(labelAddress);
		
		JLabel labelGender = new JLabel("Gender:");
		labelGender.setForeground(Color.BLACK);
		labelGender.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelGender.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		labelGender.setBounds(25, 147, 96, 30);
		add(labelGender);
		
		JLabel labelPhone = new JLabel("Phone Number:");
		labelPhone.setForeground(Color.BLACK);
		labelPhone.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelPhone.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		labelPhone.setBounds(25, 177, 96, 30);
		add(labelPhone);
		
		JLabel labelEmail = new JLabel("Email Address:");
		labelEmail.setForeground(Color.BLACK);
		labelEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		labelEmail.setBounds(25, 207, 96, 30);
		add(labelEmail);
		
		JLabel usernameLabel = new JLabel(user);
		usernameLabel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		usernameLabel.setBounds(95, 277, 68, 31);
		add(usernameLabel);
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setForeground(Color.BLACK);
		usernameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		usernameLabel.setBackground(Color.WHITE);
		
		JLabel labelUser = new JLabel("Username:");
		labelUser.setForeground(Color.BLACK);
		labelUser.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelUser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		labelUser.setBounds(24, 278, 74, 30);
		add(labelUser);
		
		currentpass = new JPasswordField();
		currentpass.setBackground(new Color(255, 250, 240));
		currentpass.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(95, 158, 160)));
		currentpass.setFont(new Font("SansSerif", Font.PLAIN, 12));
		currentpass.setForeground(Color.BLACK);
		currentpass.setBounds(166, 313, 162, 30);
		add(currentpass);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 250, 240));
		passwordField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(95, 158, 160)));
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 12));
		passwordField.setForeground(Color.BLACK);
		passwordField.setBounds(166, 344, 162, 30);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(new Color(255, 250, 240));
		passwordField_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(95, 158, 160)));
		passwordField_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		passwordField_1.setForeground(Color.LIGHT_GRAY);
		passwordField_1.setBounds(166, 376, 162, 30);
		add(passwordField_1);
		
		JLabel labelCurrentPass = new JLabel("Current Password");
		labelCurrentPass.setForeground(Color.BLACK);
		labelCurrentPass.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelCurrentPass.setBorder(new EmptyBorder(0, 0, 0, 0));
		labelCurrentPass.setBounds(24, 313, 145, 30);
		add(labelCurrentPass);
		
		JLabel labelPass = new JLabel("New Password");
		labelPass.setForeground(Color.BLACK);
		labelPass.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelPass.setBorder(new EmptyBorder(0, 0, 0, 0));
		labelPass.setBounds(24, 344, 145, 30);
		add(labelPass);
		
		JLabel labelPass_1 = new JLabel("Confirm  New Password");
		labelPass_1.setForeground(Color.BLACK);
		labelPass_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		labelPass_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		labelPass_1.setBounds(24, 376, 145, 30);
		add(labelPass_1);
		
		JButton saveButton = new JButton("SAVE");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//field must not be left empty
				if(firstnameTxt.getText().trim().equals("") || lastnameTxt.getText().trim().equals("") ||
						addressTxt.getText().trim().equals("") || phoneTxt.getText().trim().equals("") || 
						emailTxt.getText().trim().equals("") || genderTxt.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null,"Some information are missing. Please provide your complete details");
				}
				else {
					//checks if first name is integer
					if(!firstnameTxt.getText().trim().equals(fname)) {
						boolean confirm=false;
						for(int i=0; i<firstnameTxt.getText().length(); i++) {
							confirm=Character.isDigit(firstnameTxt.getText().charAt(i)); {	
							}
						}
						if(confirm == true) {
							JOptionPane.showMessageDialog(null, "Invalid first name");
					}
						else {
							fname=firstnameTxt.getText();
						}
					}

					else if (!lastnameTxt.getText().trim().equals(lname)) {
						boolean confirm=false;
						//checks if last name is integer
						for(int i=0; i<lastnameTxt.getText().length(); i++) {
							confirm=Character.isDigit(lastnameTxt.getText().charAt(i)); {	
							}
						}
						if(confirm == true) {
							JOptionPane.showMessageDialog(null, "Invalid last name");
					}
						else {
							lname=lastnameTxt.getText();
						}
					}
						
					else if (!addressTxt.getText().trim().equals(add)) {
						add=addressTxt.getText();}
					else if(!phoneTxt.getText().trim().equals(phone)) {
						try {
							//checks if phone number contains any letter
							Integer.parseInt(phoneTxt.getText());
							phone=phoneTxt.getText();
						} catch(NumberFormatException el) {
							JOptionPane.showMessageDialog(null, "Invalid phone number!");
						}
						}
					else if(!emailTxt.getText().trim().equals(email)) {
						try {
							//only accepts email that contains @ and ends with .com or .co.nz
							if(emailTxt.getText().contains("@") && emailTxt.getText().length()<5) {
								JOptionPane.showMessageDialog(null, "Invalid email!");
							}
							if (emailTxt.getText().contains("@") && (emailTxt.getText().substring(emailTxt.getText().length()-4,emailTxt.getText().length()).equalsIgnoreCase(".com") 
									|| emailTxt.getText().contains("@") && emailTxt.getText().substring(emailTxt.getText().length()-6,emailTxt.getText().length()).equalsIgnoreCase(".co.nz"))) {
								email=emailTxt.getText();
							}
							else {
								JOptionPane.showMessageDialog(null, "Invalid email!");
							}

						}catch(IndexOutOfBoundsException ev) {
							
						}
					}
					// will only accept male, female or none
					else if(!genderTxt.getText().trim().equals(gender)) {
						if(genderTxt.getText().trim().toLowerCase().equals("male") || genderTxt.getText().trim().toLowerCase().equals("female") 
								|| genderTxt.getText().trim().toLowerCase().equals("none")) {
							gender=genderTxt.getText();
						}
						else {
							JOptionPane.showMessageDialog(null, "Gender info error!! Please enter male ,female or none only");
						}
				}
					else {
						if(currentpass.getText().trim().equals("") && passwordField.getText().trim().equals("") && passwordField_1.getText().trim().equals("")) {
							cus.setFirstName(fname);
							cus.setLastName(lname);
							cus.setAddress(add);
							cus.setGender(gender);
							cus.setPhone(phone);
							cus.setEmail(email);
							JOptionPane.showMessageDialog(null,"Your details has been updated");
							setVisible(false);
							status=true;
							
							
						}else {
							if(currentpass.getText().trim().equals(pass)) {
								if(passwordField.getText().trim().equals(passwordField_1.getText().trim())){
									pass=passwordField.getText().trim();	
									cus.setFirstName(fname);
									cus.setLastName(lname);
									cus.setAddress(add);
									cus.setGender(gender);
									cus.setPhone(phone);
									cus.setEmail(email);
									cus.setPassWord(pass);
									JOptionPane.showMessageDialog(null,"Your details has been updated");
									setVisible(false);
									status=true;
								}
								else {
									JOptionPane.showMessageDialog(null,"New password does not match");
								}
						}
							else {
								JOptionPane.showMessageDialog(null,"Please enter correct current password");
							}						
						}
				}			
				}		
			}
		});
		saveButton.setForeground(new Color(255, 250, 240));
		saveButton.setBorderPainted(false);
		saveButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		saveButton.setBackground(new Color(255, 99, 71));
		saveButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		saveButton.setBounds(77, 417, 103, 34);
		add(saveButton);
		
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				status=true;
				
				
			}
		});
		cancelButton.setBackground(new Color(255, 228, 181));
		cancelButton.setBorderPainted(false);
		cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
		cancelButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		cancelButton.setBounds(202, 417, 103, 34);
		add(cancelButton);
		
		JLabel Personalinfolabel = new JLabel("Personal Information");
		Personalinfolabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		Personalinfolabel.setBounds(25, 0, 171, 40);
		add(Personalinfolabel);
		
		JLabel lblChangePassword = new JLabel("Change Password ");
		lblChangePassword.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblChangePassword.setBounds(25, 248, 153, 40);
		add(lblChangePassword);
		

	}
	public boolean getStatus() {
		return status;
	}
	}

