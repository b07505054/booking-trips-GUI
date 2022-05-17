import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginPanel extends JPanel{
	private JTextField userfield;
	private JPasswordField passfield;
	
	public loginPanel() {
		
		JLabel userlabel = new JLabel("帳號:");
		userlabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JLabel passlabel = new JLabel("密碼:");
		passlabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		userfield = new JTextField();
		userfield.setColumns(10);
		
		passfield = new JPasswordField();
		
		JButton loginbutton = new JButton("登入");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				revalidate();
				repaint();
			}
		});
		loginbutton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(276)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(userlabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
								.addComponent(passlabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(passfield, 114, 114, 114)
								.addComponent(userfield, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(312)
							.addComponent(loginbutton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							)
							)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGap(167)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(userlabel)
						.addComponent(userfield, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passlabel)
						.addComponent(passfield, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addComponent(loginbutton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}

	public JTextField getUserfield() {
		return userfield;
	}

	public JPasswordField getPassfield() {
		return passfield;
	}
}
