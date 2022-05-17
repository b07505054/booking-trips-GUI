import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginErrorPanel extends JPanel {
	public loginErrorPanel() {
		
		JLabel lflabel = new JLabel("帳號或密碼錯誤");
		lflabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JButton retrybutton = new JButton("重試");
		retrybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				revalidate();
				repaint();
			}
		});
		retrybutton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(423)
							.addComponent(lflabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(433)
							.addComponent(retrybutton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(466, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(210)
					.addComponent(lflabel)
					.addGap(58)
					.addComponent(retrybutton)
					.addContainerGap(282, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
