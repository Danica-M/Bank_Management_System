import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteAccount extends JPanel {
	private JTextField textField;
	private boolean status;

	/**
	 * Create the panel.
	 */
	public DeleteAccount(Customer cus) {
		setBorder(new LineBorder(new Color(95, 158, 160), 2));
		setBackground(new Color(255, 250, 240));
		setBounds(0,  0, 327, 325);
		setLayout(null);
		
		

		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBounds(168, 84, 86, 27);
		add(textField);
		
		JButton deleteButton = new JButton("DELETE");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter the account ID!");
				}
				else {
					BankAccount found=null;
					for(BankAccount bank:BankSystem.getCustomerAcc(cus)) {
						if(bank.getAccID().equals(textField.getText().trim().toUpperCase())) {
							found=bank;
						}
					}
					if(found==null) {
						JOptionPane.showMessageDialog(null, "This account does not exist or does not belong to you");
					}
					else {
						if(found.getBalance()>0) {
							JOptionPane.showMessageDialog(null, "We are unable to delete this account. Please withdraw remaining balance!");
						}
						else {
							if(JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this account? Account deletion cannot be undone.","Account Deletion", JOptionPane.YES_NO_OPTION)== 0) {
								BankSystem.removeAccount(found);
								JOptionPane.showMessageDialog(null, "Account successfully deleted!");
								status=true;
								setVisible(false);

							}
							
						}
						
						
					}
				}
			}
		});
		deleteButton.setForeground(new Color(255, 250, 240));
		deleteButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		deleteButton.setBorderPainted(false);
		deleteButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		deleteButton.setBackground(new Color(255, 99, 71));
		deleteButton.setBounds(54, 131, 103, 34);
		add(deleteButton);
		
		JLabel accLabel = new JLabel("Account ID:");
		accLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		accLabel.setBounds(79, 82, 79, 31);
		add(accLabel);
		
		
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				setVisible(false);
			}
		});
		cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
		cancelButton.setBorderPainted(false);
		cancelButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		cancelButton.setBackground(new Color(255, 228, 181));
		cancelButton.setBounds(179, 131, 103, 34);
		add(cancelButton);
		
		JLabel lblNewLabel = new JLabel("DELETE ACCOUNT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 25, 327, 34);
		add(lblNewLabel);

	}
	public boolean getStatus() {
		return status;
	} 

}
