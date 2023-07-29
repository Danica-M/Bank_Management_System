import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DepositPanel extends JPanel {

	private JTextField damountTxt;
	private boolean status;
	private JTextField idText;
	private JLabel dbalance;
	private BankAccount bank;

	
	/**
	 * Create the panel.
	 */
	public DepositPanel(Customer cus) {
		setBorder(new LineBorder(new Color(95, 158, 160), 2));
		setBackground(new Color(255, 250, 240));
		setBounds(0,  0, 327, 325);
		setLayout(null);
		
		
		JLabel dheader = new JLabel("DEPOSIT");
		dheader.setFont(new Font("Rockwell", Font.BOLD, 18));
		dheader.setHorizontalAlignment(SwingConstants.CENTER);
		dheader.setBounds(0, 25, 327, 31);
		add(dheader);
		
		JLabel accLabel = new JLabel("Account ID:");
		accLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		accLabel.setBounds(66, 82, 79, 31);
		add(accLabel);
		
		idText = new JTextField();
		idText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// this will not allow user to change inputted account id when bank account is found
				if(bank!=null) {
					idText.setEditable(false);
					JOptionPane.showMessageDialog(null, "Finish or cancel deposit operation to try other account.");
				}
			}
		});
		idText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				//this will check if the inputed bank account ID is owned by the user
				if(BankSystem.getCustomerAcc(cus).size()>0) {
					setCusAcc(cus,idText.getText());
				}
				else {
					JOptionPane.showMessageDialog(null, "you dont have any account under your name!");
				}
			}
		});
		idText.setFont(new Font("SansSerif", Font.BOLD, 14));
		idText.setBounds(155, 84, 86, 27);
		add(idText);
		idText.setColumns(10);
		
		JLabel damountLbl = new JLabel("Amount :");
		damountLbl.setFont(new Font("SansSerif", Font.BOLD, 14));
		damountLbl.setBounds(84, 120, 61, 31);
		add(damountLbl);
		
		//String.valueOf(a.getBalance())
		dbalance = new JLabel();
		dbalance.setFont(new Font("SansSerif", Font.BOLD, 12));
		dbalance.setBounds(157, 162, 84, 27);
		add(dbalance);
		
		JLabel dBalanceLbl = new JLabel("Balance :");
		dBalanceLbl.setFont(new Font("SansSerif", Font.BOLD, 14));
		dBalanceLbl.setBounds(81, 162, 64, 31);
		add(dBalanceLbl);
		
		damountTxt = new JTextField();
		damountTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		damountTxt.setBounds(155, 124, 86, 27);
		add(damountTxt);
		damountTxt.setColumns(10);
		
		JButton DepositButton = new JButton("DEPOSIT");
		DepositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this will not allow user to proceed if he/she left any field empty
				if(damountTxt.getText().equals("") || idText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "There is missing input!");
				}
				else {
					if(bank!=null) {
						try {
							//this will check if user inputed number
							double amount=Double.parseDouble(damountTxt.getText());
							//user must deposit less than 10,000
							if(amount>0 && amount<=10000) {
								bank.deposit(bank.getAccID(),amount);
								JOptionPane.showMessageDialog(null, "You have successfully deposited "+String.format("%.2f",amount)+" to your account!");
								setVisible(false);
								status=true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Deposit amount must be greater that 0 and less than 10,000");
							}
						}catch(NumberFormatException v) {
							//if user inputs string this error will be displayed
							JOptionPane.showMessageDialog(null, "you have entered an invalid amount!");
						}	
					
							
						}
					else {
						JOptionPane.showMessageDialog(null, "This account does not exist or does not belong to you");
					}
				}
			}						
		});
		DepositButton.setForeground(new Color(255, 250, 240));
		DepositButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		DepositButton.setBorderPainted(false);
		DepositButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		DepositButton.setBackground(new Color(255, 99, 71));
		DepositButton.setBounds(42, 217, 103, 34);
		add(DepositButton);
		
		JButton DcancelButton = new JButton("CANCEL");
		DcancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				damountTxt.setText("");
				idText.setText("");
				status=true;
				setVisible(false);
			}
		});
		DcancelButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
		DcancelButton.setBorderPainted(false);
		DcancelButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		DcancelButton.setBackground(new Color(255, 228, 181));
		DcancelButton.setBounds(167, 217, 103, 34);
		add(DcancelButton);

		
	}

	//method to check if customer owns the bank account 
	//will return the bank account
	public void setCusAcc(Customer cus, String x) {
		for(BankAccount acc:BankSystem.getCustomerAcc(cus)) {
			if(x.trim().toUpperCase().equals(acc.getAccID())){
				this.bank=acc;
			}
		}if(bank==null) {
			JOptionPane.showMessageDialog(null, "This account does not exist or does not belong to you");

		}else {
			dbalance.setText(String.format("%.2f",bank.getBalance()));
		}
}
	
	public boolean getStatus() {
		return status;
	} 
}
