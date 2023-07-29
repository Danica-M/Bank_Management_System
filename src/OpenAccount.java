import javax.swing.JPanel;


import java.awt.Color;
import javax.swing.border.LineBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class OpenAccount extends JPanel {
	private JTextField deposittextField;
	private boolean status;
	private int accountID;

	/**
	 * Create the panel.
	 */


	public enum AccountType {
		Checking,
		SeriousSaver,
		FastSaver
	}
	public OpenAccount(Customer cus) {	
		setBorder(new LineBorder(new Color(95, 158, 160), 3));
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		setBounds(0,  0, 327, 325);
		
		DefaultComboBoxModel<AccountType> aModel = new DefaultComboBoxModel<>(
		          AccountType.values());
		JComboBox<AccountType> AccTypeBox = new JComboBox<AccountType>(aModel);
		AccTypeBox.setBounds(139, 123, 142, 30);
		add(AccTypeBox);
		
		deposittextField = new JTextField();
		deposittextField.setHorizontalAlignment(SwingConstants.RIGHT);
		deposittextField.setBorder(new LineBorder(new Color(95, 158, 160), 2));
		deposittextField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		deposittextField.setBounds(139, 164, 142, 30);
		add(deposittextField);
		deposittextField.setColumns(10);
		
		JLabel accnumLabel = new JLabel("Account ID.");
		accnumLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		accnumLabel.setBounds(40, 82, 89, 25);
		add(accnumLabel);
		
		JLabel accLabel = new JLabel("Account Type");
		accLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		accLabel.setBounds(40, 125, 89, 25);
		add(accLabel);
		
		JLabel depLabel = new JLabel("Initial Deposit");
		depLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		depLabel.setBounds(40, 166, 89, 25);
		add(depLabel);
		
		if(BankSystem.getDeletedAcc(cus).size()==0) {
			accountID=BankSystem.getAccountList().size()+1;
		}
		else {
			accountID=BankSystem.getAccountList().size()+11;
		}
		
		JLabel accIDLabel = new JLabel("A"+cus.getId()+String.valueOf(accountID));
		accIDLabel.setHorizontalAlignment(SwingConstants.LEFT);
		accIDLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		accIDLabel.setBounds(139, 79, 142, 30);
		add(accIDLabel);
		
		JButton SubmitBtn = new JButton("SUBMIT");
		SubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accountT = AccTypeBox.getSelectedItem().toString();
				if(BankSystem.getCustomerAcc(cus).size()==3) {
					JOptionPane.showMessageDialog(null, "You have reached the number of accounts limit");
					status=true;
					setVisible(false);
				}
				else {
					if(deposittextField.getText().equals("")) {
						BankAccount acc=new BankAccount("A"+cus.getId()+String.valueOf(accountID),accountT,cus.getId());
						BankSystem.addAccount(acc);
						JOptionPane.showMessageDialog(null, "You have successfully created new account");
						status=true;
						setVisible(false);
					}
					else {
						try {
							double deposit=Double.parseDouble(deposittextField.getText());
							if(deposit>0) {
								BankAccount acc=new BankAccount("A"+cus.getId()+String.valueOf(accountID),accountT,cus.getId());
								BankSystem.addAccount(acc);
								acc.deposit(acc.getAccID(),deposit);
								JOptionPane.showMessageDialog(null, "You have successfully created new account");
								status=true;
								setVisible(false);

								}
							
						}catch(NumberFormatException ev) {
							JOptionPane.showMessageDialog(null, "You have entered an invalid deposit amount");
							
						}
					}
					
				}
				
			}
			
		});
		SubmitBtn.setForeground(new Color(255, 250, 240));
		SubmitBtn.setBorderPainted(false);
		SubmitBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		SubmitBtn.setBackground(new Color(255, 99, 71));
		SubmitBtn.setFont(new Font("SansSerif", Font.BOLD, 13));
		SubmitBtn.setBounds(64, 220, 85, 35);
		add(SubmitBtn);
		
		JButton CancelBtn_1 = new JButton("CANCEL");
		CancelBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposittextField.setText("");
				AccTypeBox.setSelectedIndex(0);
				status=true;
				setVisible(false);
				
			}
		});
		CancelBtn_1.setBackground(new Color(255, 228, 181));
		CancelBtn_1.setBorderPainted(false);
		CancelBtn_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		CancelBtn_1.setBounds(159, 220, 89, 35);
		add(CancelBtn_1);
		
		JLabel oHeader = new JLabel("OPEN NEW ACCOUNT");
		oHeader.setHorizontalAlignment(SwingConstants.CENTER);
		oHeader.setFont(new Font("Rockwell", Font.BOLD, 18));
		oHeader.setBounds(0, 25, 327, 35);
		add(oHeader);

	}
	public boolean getStatus() {
		return status;
	} 
}
