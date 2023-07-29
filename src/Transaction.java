import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;


public class Transaction extends JPanel {
	private JTextField IdText;
	private boolean status;
	private String text;
	private BankAccount bank;
	

	/**
	 * Create the panel.
	 */
	public Transaction(Customer cus) {
		
		setBounds(0, 0, 327, 402);
		setBorder(new LineBorder(new Color(95, 158, 160), 2));
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		
		IdText = new JTextField();
		IdText.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(text!=null && bank!=null) {
					status=true;
					JOptionPane.showMessageDialog(null, "Do you want check different account?");
					setVisible(false);
				}
			}
			public void focusLost(FocusEvent e) {
				text=IdText.getText();
				System.out.print(text);

			
			}
		});
		IdText.setBounds(155, 63, 86, 28);
		add(IdText);
		IdText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Account ID: ");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(70, 61, 103, 28);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 250, 240));
		scrollPane.setBorder(new LineBorder(new Color(95, 158, 160), 2));
		scrollPane.setBounds(47, 95, 225, 257);
		add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBackground(new Color(255, 250, 240));
		panel.setLayout(null);
		
		JList<String> amountList = new JList<String>();
		amountList.setBounds(0, 0, 59, 242);
		panel.add(amountList);
		amountList.setBackground(new Color(255, 250, 240));
		amountList.setFont(new Font("SansSerif", Font.PLAIN, 12)); 
		
		JList<String> transacList = new JList<String>();
		transacList.setBounds(69, 0, 75, 242);
		panel.add(transacList);
		transacList.setBackground(new Color(255, 250, 240));
		transacList.setFont(new Font("SansSerif", Font.ITALIC, 12));
		
		JLabel lblBalanceTransaction = new JLabel("BALANCE | TRANSACTION AMOUNT");
		scrollPane.setColumnHeaderView(lblBalanceTransaction);
		lblBalanceTransaction.setFont(new Font("Rockwell", Font.BOLD, 12));
		
		JButton btnShow = new JButton("SHOW");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> dlmT=new DefaultListModel<String>();
				DefaultListModel<String> dlmA=new DefaultListModel<String>();
				
				if(text!=null) {
					if(BankSystem.getCustomerAcc(cus).size()>0) {
						setCusAcc(cus,text);
						if(bank!=null) {
							for(int i=0; i<BankSystem.getCusTransactions(bank.getAccID()).size(); i++) {
								dlmT.addElement(BankSystem.getCusTransactions(bank.getAccID()).get(i));
								
							}
							for(int i=0;i<BankSystem.getCusAmount(bank.getAccID()).size(); i++) {
								dlmA.addElement(BankSystem.getCusAmount(bank.getAccID()).get(i));
							}
							
							if(BankSystem.getCusTransactions(bank.getAccID()).size()==0) {
								lblBalanceTransaction.setText("no transaction history");
							}
							else {
								dlmA.addElement(String.valueOf(bank.getBalance()));
								transacList.setModel(dlmT);
								amountList.setModel(dlmA);
							}
						}
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
	
		btnShow.setForeground(new Color(255, 250, 240));
		btnShow.setBackground(new Color(255, 99, 71));
		btnShow.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnShow.setBorderPainted(false);
		btnShow.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnShow.setBounds(103, 363, 117, 23);
		add(btnShow);
		
		JLabel tHeader = new JLabel("TRANSACTION HISTORY");
		tHeader.setHorizontalAlignment(SwingConstants.CENTER);
		tHeader.setFont(new Font("Rockwell", Font.BOLD, 18));
		tHeader.setBounds(0, 25, 327, 28);
		add(tHeader);
		
		
		
		
		

	}
	public void setCusAcc(Customer cus, String x) {
		for(BankAccount acc:BankSystem.getCustomerAcc(cus)) {
			if(x.trim().toUpperCase().equals(acc.getAccID())){
				this.bank=acc;
			}
		}if(bank==null) {
			JOptionPane.showMessageDialog(null, "This account does not exist or does not belong to you");
		}

	}
	public boolean getStatus() {
		return status;
	}
}
