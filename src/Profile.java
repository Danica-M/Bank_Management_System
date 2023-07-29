import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Profile extends JPanel {

	/**
	 * Create the panel.
	 */
	public Profile(Customer cus) {
		setBorder(new LineBorder(new Color(95, 158, 160), 2));
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PERSONAL PROFILE");
		lblNewLabel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 30, 158, 27);
		add(lblNewLabel);
		
		JLabel nameLabel = new JLabel("Name :   "+cus.getFirstName()+" "+cus.getLastName());
		nameLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		nameLabel.setBounds(20, 68, 322, 27);
		add(nameLabel);
		
		JLabel addressLabel = new JLabel("Address :   "+cus.getAddress());
		addressLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		addressLabel.setBounds(20, 94, 322, 27);
		add(addressLabel);
		
		JLabel genderLabel = new JLabel("Gender :   "+cus.getGender());
		genderLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		genderLabel.setBounds(20, 122, 322, 27);
		add(genderLabel);
		
		JLabel phoneLabel = new JLabel("Phone Number :   "+cus.getPhone());
		phoneLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		phoneLabel.setBounds(20, 149, 322, 27);
		add(phoneLabel);
		
		JLabel emailLabel = new JLabel("Email Address :   "+cus.getEmail());
		emailLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		emailLabel.setBounds(20, 177, 322, 27);
		add(emailLabel);
		
		JLabel lblAccounts = new JLabel("ACCOUNT/S");
		lblAccounts.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		lblAccounts.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblAccounts.setBounds(20, 233, 87, 27);
		add(lblAccounts);
		
		JList<String> currentList = new JList<String>();
		currentList.setBackground(new Color(255, 250, 240));
		currentList.setFont(new Font("SansSerif", Font.BOLD, 13));
		currentList.setBounds(20, 277, 100, 108);
		add(currentList);
		
		JLabel noAccLabel = new JLabel();
		noAccLabel.setFont(new Font("SansSerif", Font.ITALIC, 11));
		noAccLabel.setBounds(20, 260, 138, 17);
		add(noAccLabel);
		
		DefaultListModel<String> dlmC= new DefaultListModel<String>();
		if(BankSystem.getCustomerAcc(cus).size()==0) {
			noAccLabel.setText("No bank account");
		}
		else {
			for(BankAccount bank:BankSystem.getCustomerAcc(cus)) {
				dlmC.addElement(bank.getAccID());
			}
			currentList.setModel(dlmC);
		}
		
		
		
		JLabel lblAccountHISTORY = new JLabel("DELETED ACCOUNTS");
		lblAccountHISTORY.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblAccountHISTORY.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(95, 158, 160)));
		lblAccountHISTORY.setBounds(189, 233, 153, 27);
		add(lblAccountHISTORY);
		
		JLabel noAccHisLabel = new JLabel();
		noAccHisLabel.setFont(new Font("SansSerif", Font.ITALIC, 11));
		noAccHisLabel.setBounds(189, 260, 138, 17);
		add(noAccHisLabel);
		
		JList<String> historyList = new JList<String>();
		historyList.setFont(new Font("SansSerif", Font.BOLD, 13));
		historyList.setBackground(new Color(255, 250, 240));
		historyList.setBounds(189, 277, 100, 108);
		add(historyList);
		DefaultListModel<String> dlmD= new DefaultListModel<String>();
		if(BankSystem.getDeletedAcc(cus).size()==0) {
			noAccHisLabel.setText("No deleted bank account");
		}
		else {
			for(BankAccount bank:BankSystem.getDeletedAcc(cus)) {
				dlmD.addElement(bank.getAccID());
			}
			historyList.setModel(dlmD);
		}
		
		

	}
}
