import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransferPanel extends JPanel {
	private JTextField tamountTxt;
	private boolean status;
	private JTextField taccIDTxt;
	private JTextField idText;
	private BankAccount bank;
	private JLabel tBalance;

	/**
	 * Create the panel.
	 */
	public TransferPanel(Customer cus) {
		setBorder(new LineBorder(new Color(95, 158, 160), 2));
		setBackground(new Color(255, 250, 240));
		setBounds(0, 0, 327, 325);
		setLayout(null);
		
		
		JLabel theader = new JLabel("TRANSFER");
		theader.setHorizontalAlignment(SwingConstants.CENTER);
		theader.setFont(new Font("Rockwell", Font.BOLD, 18));
		theader.setBounds(0, 28, 327, 31);
		add(theader);
	
		JLabel tamountLbl = new JLabel("Amount :");
		tamountLbl.setFont(new Font("SansSerif", Font.BOLD, 14));
		tamountLbl.setBounds(104, 194, 61, 31);
		add(tamountLbl);
		
		JLabel tAccidLbl = new JLabel("Receiver Account ID :");
		tAccidLbl.setFont(new Font("SansSerif", Font.BOLD, 14));
		tAccidLbl.setBounds(10, 114, 155, 31);
		add(tAccidLbl);
		
		tamountTxt = new JTextField();
		tamountTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		tamountTxt.setColumns(10);
		tamountTxt.setBounds(170, 198, 110, 27);
		add(tamountTxt);
		
		taccIDTxt = new JTextField();
		taccIDTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
					if(bank!=null) {
						// system will not allow transfer operation if sender and receiver account ID is the same
						if(taccIDTxt.getText().trim().toUpperCase().equals(bank.getAccID())) {
							JOptionPane.showMessageDialog(null,"Sorry transfer operation does not apply in the same account!");
							taccIDTxt.setText("");
						}
					}
			}
		});
			
			
		taccIDTxt.setColumns(10);
		taccIDTxt.setBounds(170, 118, 110, 27);
		add(taccIDTxt);
		
		JButton TransferButton = new JButton("TRANSFER");
		TransferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tamountTxt.getText().equals("") || idText.getText().equals("") || taccIDTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "There is missing input!");
				} 
				else {
					if(bank!=null) {
						BankAccount found=null;
						// will look for the receiver account ID
						if(BankSystem.getAccountList().size()>1) {
							for(BankAccount acc:BankSystem.getAccountList()) {
								if(taccIDTxt.getText().trim().toLowerCase().equals(acc.getAccID().toLowerCase())){
									 found=acc;
									break;
								}
							}
								if (found==null) {
									JOptionPane.showMessageDialog(null, "Recipient account does not exist!!");
								}
								else {
									try {
										double amount=Double.parseDouble(tamountTxt.getText());
										if(amount<=bank.getBalance()) {
											if(amount>0 && amount<=3000) {
												bank.transfer(bank.getAccID(),amount,found);
												JOptionPane.showMessageDialog(null, "You have successfully transferred "+String.format("%.2f",amount)+" to "+found.getAccID()+" account!");
												setVisible(false);
												status=true;
											}	
											else {
												JOptionPane.showMessageDialog(null, "Transfer amount must be greater that 0 and less than 3,000");
											}
										}
										else {
											JOptionPane.showMessageDialog(null, "Insufficient funds");
										}
									}catch(NumberFormatException v) {
										JOptionPane.showMessageDialog(null, "you have entered an invalid amount!");
									}
								}
						}
						else {
							JOptionPane.showMessageDialog(null, "there is no other account in the AccountList!");
						}
							
					}	
					else {
						JOptionPane.showMessageDialog(null, "This account does not exist or does not belong to you");
					}
					
				}
			}
		});
		TransferButton.setForeground(new Color(255, 250, 240));
		TransferButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		TransferButton.setBorderPainted(false);
		TransferButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		TransferButton.setBackground(new Color(255, 99, 71));
		TransferButton.setBounds(54, 255, 103, 34);
		add(TransferButton);
		
		JButton TcancelButton = new JButton("CANCEL");
		TcancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tamountTxt.setText("");
				taccIDTxt.setText("");
				idText.setText("");
				status=true;
				setVisible(false);
			}
		});
		TcancelButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
		TcancelButton.setBorderPainted(false);
		TcancelButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		TcancelButton.setBackground(new Color(255, 228, 181));
		TcancelButton.setBounds(179, 255, 103, 34);
		add(TcancelButton);
		
		JLabel accLabel = new JLabel("Sender Account ID :");
		accLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		accLabel.setBounds(24, 70, 141, 31);
		add(accLabel);
		
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
		idText.setBounds(170, 72, 110, 27);
		add(idText);
		
		tBalance = new JLabel();
		tBalance.setFont(new Font("SansSerif", Font.BOLD, 12));
		tBalance.setBounds(170, 156, 110, 27);
		add(tBalance);
		
		JLabel tBalanceLbl = new JLabel("Balance :");
		tBalanceLbl.setFont(new Font("SansSerif", Font.BOLD, 14));
		tBalanceLbl.setBounds(100, 156, 65, 31);
		add(tBalanceLbl);
		
	}
	public BankAccount getAcc(String x) {
		BankAccount found=null;
		for(BankAccount acc:BankSystem.getAccountList()) {
			if (acc.getAccID().equals(x)){
				found=acc;
				
			}
		}
		return found;
	
	}
	//method will return bank account
	public void setCusAcc(Customer cus, String x) {
		for(BankAccount acc:BankSystem.getCustomerAcc(cus)) {
			if(x.trim().toUpperCase().equals(acc.getAccID())){
				this.bank=acc;
			}
		}if(bank==null) {
			JOptionPane.showMessageDialog(null, "This account does not exist or does not belong to you");
		}else {
			tBalance.setText(String.format("%.2f",bank.getBalance()));
		}
}
	public boolean getStatus() {
		return status;
	} 
}
