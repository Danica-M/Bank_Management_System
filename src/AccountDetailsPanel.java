import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class AccountDetailsPanel extends JPanel {
	private JTextField idText;
	private BankAccount bank;
	private JLabel balanceLabel;
	private JLabel monfeeLabel;
	private JLabel IntLabel;
	private JLabel AccTypeLabel;
	private String text;
	private boolean status;


	/**
	 * Create the panel.
	 */
	public AccountDetailsPanel(Customer cus) {
		setBorder(new LineBorder(new Color(95, 158, 160), 2));

		setBounds(0, 0, 327, 325);
		setBackground(new Color(255, 250, 240));
		setLayout(null);


		AccTypeLabel = new JLabel();
		AccTypeLabel.setForeground(Color.BLACK);
		AccTypeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		AccTypeLabel.setBounds(152, 112, 118, 32);
		add(AccTypeLabel);
		
		IntLabel = new JLabel();
		IntLabel.setForeground(Color.BLACK);
		IntLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		IntLabel.setBounds(152, 145, 118, 32);
		add(IntLabel);
		
		monfeeLabel = new JLabel();
		monfeeLabel.setForeground(Color.BLACK);
		monfeeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		monfeeLabel.setBounds(152, 178, 118, 32);
		add(monfeeLabel);
		
		balanceLabel = new JLabel();
		balanceLabel.setForeground(Color.BLACK);
		balanceLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		balanceLabel.setBounds(152, 211, 118, 32);
		add(balanceLabel);
		
		
		JLabel ALabel = new JLabel("Account Type:");
		ALabel.setBounds(41, 112, 101, 32);
		ALabel.setForeground(Color.BLACK);
		ALabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		add(ALabel);
		
		JLabel ILabel = new JLabel("Interest Rate:");
		ILabel.setBounds(41, 145, 101, 32);
		ILabel.setForeground(Color.BLACK);
		ILabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		add(ILabel);
		
		JLabel mLabel = new JLabel("Monthly Fee:");
		mLabel.setBounds(41, 178, 101, 32);
		mLabel.setForeground(Color.BLACK);
		mLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		add(mLabel);
		
		JLabel bLabel = new JLabel("Balance:");
		bLabel.setForeground(Color.BLACK);
		bLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		bLabel.setBounds(41, 211, 101, 32);
		add(bLabel);
		
		JLabel panelLabel = new JLabel("ACCOUNT DETAILS");
		panelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelLabel.setFont(new Font("Rockwell", Font.BOLD, 18));
		panelLabel.setBounds(0, 25, 327, 32);
		add(panelLabel);
		
		JLabel accLabel = new JLabel("Account ID:");
		accLabel.setForeground(Color.BLACK);
		accLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		accLabel.setBounds(41, 82, 101, 31);
		add(accLabel);
		
		idText = new JTextField();	
		idText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(text!=null && !balanceLabel.getText().equals("")) {
					status=true;
					JOptionPane.showMessageDialog(null, "Do you want check different account?");
					setVisible(false);
				}
			}
			public void focusLost(FocusEvent e) {
				setText(idText.getText());

			
			}
		});
		idText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				balanceLabel.setText("");
				monfeeLabel.setText("");
				IntLabel.setText("");
				AccTypeLabel.setText("");
				
			}
		});
	
		idText.setFont(new Font("SansSerif", Font.BOLD, 14));
		idText.setColumns(10);
		idText.setBounds(152, 84, 86, 27);
		add(idText);
		
		
		JButton showDetailsButton = new JButton("Show Details");
		showDetailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(!text.equals("")) {
					if(BankSystem.getCustomerAcc(cus).size()>0) {
						setCusAcc(cus,text);
					}
					else {
						JOptionPane.showMessageDialog(null, "you dont have any account under your name!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please provide account ID!");
				}	
			}	
				
		});
		showDetailsButton.setForeground(new Color(255, 250, 240));
		showDetailsButton.setBorderPainted(false);
		showDetailsButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		showDetailsButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		showDetailsButton.setBackground(new Color(255, 99, 71));
		showDetailsButton.setBounds(96, 265, 123, 32);
		add(showDetailsButton);
		
	}
	public void setText(String x) {
		this.text=x;
	}
	
	public void setCusAcc(Customer cus, String x) {
		for(BankAccount acc:BankSystem.getCustomerAcc(cus)) {
			if(x.trim().toUpperCase().equals(acc.getAccID())){
				this.bank=acc;
			}
		}if(bank==null) {
			JOptionPane.showMessageDialog(null, "This account does not exist or does not belong to you");
		}else {
			balanceLabel.setText(String.format("%.2f",bank.getBalance()));
			monfeeLabel.setText(String.format("%.2f",bank.getMonthlyFee()));
			IntLabel.setText(String.valueOf(bank.getInterest())+"%");
			AccTypeLabel.setText(bank.getAccType());
		}
}
	public boolean getStatus() {
		return status;
	} 
}
