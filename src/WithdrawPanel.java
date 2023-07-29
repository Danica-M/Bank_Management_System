import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class WithdrawPanel extends JPanel {
	private JTextField wamountTxt;
	private boolean status;
	private JTextField idText;
	private BankAccount bank;
	private JLabel wbalance;

	/**
	 * Create the panel.
	 */
	public WithdrawPanel(Customer cus) {
		setBorder(new LineBorder(new Color(95, 158, 160), 2));
		setBackground(new Color(255, 250, 240));
		setBounds(0, 0, 327, 325);
		setLayout(null);
	
		idText = new JTextField();
		idText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bank!=null) {
					idText.setEditable(false);
					JOptionPane.showMessageDialog(null, "Finish or cancel transfer operation to try other account.");
				}
			}
		});
		idText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!idText.getText().trim().isEmpty()) {
					if(BankSystem.getCustomerAcc(cus).size()>0) {
						setCusAcc(cus,idText.getText());
					}
					else {
						JOptionPane.showMessageDialog(null, "you dont have any account under your name!");
					}
				}
				
			}
		});
		
		idText.setFont(new Font("SansSerif", Font.BOLD, 14));
		idText.setColumns(10);
		idText.setBounds(148, 84, 86, 27);
		add(idText);
		
		
		
		JLabel Wheader = new JLabel("WITHDRAW");
		Wheader.setHorizontalAlignment(SwingConstants.CENTER);
		Wheader.setFont(new Font("Rockwell", Font.BOLD, 18));
		Wheader.setBounds(0, 25, 327, 31);
		add(Wheader);
		
		JLabel wamountLbl = new JLabel("Amount:");
		wamountLbl.setFont(new Font("SansSerif", Font.BOLD, 14));
		wamountLbl.setBounds(83, 122, 57, 31);
		add(wamountLbl);
		//String.valueOf(a.getBalance())
		wbalance = new JLabel();
		wbalance.setFont(new Font("SansSerif", Font.BOLD, 12));
		wbalance.setBounds(148, 168, 86, 27);
		add(wbalance);
		
		JLabel wbalanceLbl = new JLabel("Balance:");
		wbalanceLbl.setFont(new Font("SansSerif", Font.BOLD, 14));
		wbalanceLbl.setBounds(80, 164, 60, 31);
		add(wbalanceLbl);
		
		wamountTxt = new JTextField();
		wamountTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		wamountTxt.setColumns(10);
		wamountTxt.setBounds(148, 126, 86, 27);
		add(wamountTxt);
		
		JButton WithdrawButton = new JButton("WITHDRAW");
		WithdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//field must be filled
				if(wamountTxt.getText().equals("") || idText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "There is missing input!");
				}
				else {
					if(bank!=null) {
						try {
							//only accepts integer for amount
							double amount=Double.parseDouble(wamountTxt.getText());
							if(amount<=bank.getBalance()) {
								if(amount>0 && amount<=3000) {
									bank.withdraw(bank.getAccID(),amount);
									JOptionPane.showMessageDialog(null, "You have successfully withdrawn "+String.format("%.2f",amount)+" from your account!");
									setVisible(false);
									status=true;
								}
								else {
									JOptionPane.showMessageDialog(null, "Withdraw amount must be greater that 0 and less than 3,000");
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Insufficient funds");
							}
							
						}catch(NumberFormatException v) {
						JOptionPane.showMessageDialog(null, "you have entered an invalid amount!");
						}	
					
					}
					else {
						JOptionPane.showMessageDialog(null, "This account does not exist or does not belong to you");
					}
				
				}
			}		
			
		});
		WithdrawButton.setForeground(new Color(255, 250, 240));
		WithdrawButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		WithdrawButton.setBorderPainted(false);
		WithdrawButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		WithdrawButton.setBackground(new Color(255, 99, 71));
		WithdrawButton.setBounds(39, 217, 103, 34);
		add(WithdrawButton);
		
		JButton WcancelButton = new JButton("CANCEL");
		WcancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wamountTxt.setText("");
				idText.setText("");
				status=true;
				setVisible(false);
			}
		});
		WcancelButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
		WcancelButton.setBorderPainted(false);
		WcancelButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		WcancelButton.setBackground(new Color(255, 228, 181));
		WcancelButton.setBounds(164, 217, 103, 34);
		add(WcancelButton);
		
		JLabel accLabel = new JLabel("Account ID:");
		accLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		accLabel.setBounds(62, 82, 79, 31);
		add(accLabel);
		
		
		

	}
	//method to find bank account
	public void setCusAcc(Customer cus, String x) {
		for(BankAccount acc:BankSystem.getCustomerAcc(cus)) {
			if(x.trim().toUpperCase().equals(acc.getAccID())){
				this.bank=acc;
			}
		}if(bank==null) {
			JOptionPane.showMessageDialog(null, "This account does not exist or does not belong to you");
		}
		else {
			wbalance.setText(String.format("%.2f",bank.getBalance()));
		}
}

	public boolean getStatus() {
		return status;
	} 

}
