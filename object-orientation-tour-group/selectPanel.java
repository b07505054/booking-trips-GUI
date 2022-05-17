import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.json.JSONArray;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;

public class selectPanel extends JPanel{
	private JTextField productfieldb;
	private JTextField bnumfieldc;
	private JTextField bnumfields;
	private int selection; //可讓其他class知道哪個按鈕被點
	private Integer[] finddate;
	private Integer[] bookstartdate;
	private Integer[] bookenddate;
	private String countryf;
	private int numpeopleb;
	private int numpeoplec;
	private String[] country;
	
	public void setCountry(String[] country) {
		this.country = country;
	}

	public selectPanel() {
		
		JTabbedPane seltab = new JTabbedPane(JTabbedPane.TOP);
		
		JButton logoutbutton = new JButton("登出");
		logoutbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection=6;
				setVisible(false);
				revalidate();
				repaint();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(seltab, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(753, Short.MAX_VALUE)
					.addComponent(logoutbutton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(162))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(50, Short.MAX_VALUE)
					.addComponent(logoutbutton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(seltab, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE))
		);
		
		JPanel fpanel = new JPanel();
		seltab.addTab("找行程", null, fpanel, null);
		
		country=new String[103];
		String jsondata = readFile("travel_code.json");
		JSONArray jsonarray = new JSONArray(jsondata);
		for (int i=0;i<103;i++) {
			country[i]=jsonarray.getJSONObject(i).getString("travel_code_name");
		}
		JComboBox countrybox = new JComboBox(country);
		
		Integer year[]= {2020,2021};
		JComboBox yearboxf = new JComboBox(year);
		
		Integer month[]= {1,2,3,4,5,6,7,8,9,10,11,12};
		JComboBox monthboxf = new JComboBox(month);
		
		
		Integer day[]= {1,2,3,4,5,6,7,8,9,10,
				11,12,13,14,15,16,17,18,19,20,
				21,22,23,24,25,26,27,28,29,30,31};
		JComboBox dayboxf = new JComboBox(day);
		
		monthboxf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer a=29;
				Integer b=30;
				Integer c=31;
				if (dayboxf.getItemCount()==28) {
					dayboxf.addItem(a);
					dayboxf.addItem(b);
					dayboxf.addItem(c);
				}
				else if (dayboxf.getItemCount()==29) {
					dayboxf.addItem(b);
					dayboxf.addItem(c);
				}
				else if (dayboxf.getItemCount()==30) {
					dayboxf.addItem(c);
				}
				int m=(int) monthboxf.getSelectedItem();
				int n=(int) yearboxf.getSelectedItem();
				switch(m) {
				case 1:
					break;
				case 2:
					dayboxf.removeItemAt(30);
					dayboxf.removeItemAt(29);
					if (n==2021) {
						dayboxf.removeItemAt(28);
					}
					break;
				case 3:
					break;
				case 4:
					dayboxf.removeItemAt(30);
					break;
				case 5:
					break;
				case 6:
					dayboxf.removeItemAt(30);
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					dayboxf.removeItemAt(30);
					break;
				case 10:
					break;
				case 11:
					dayboxf.removeItemAt(30);
					break;
				case 12:
					break;
				}
			}
		});
		
		JLabel selectlabelf = new JLabel("選擇你要的國家:");
		selectlabelf.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JLabel datelabelf = new JLabel("選擇你要的日期:");
		datelabelf.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JLabel labelf1 = new JLabel("/");
		labelf1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JLabel labelf2 = new JLabel("/");
		labelf2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JLabel hintlabelf = new JLabel("(年/月/日)");
		hintlabelf.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		JButton confirmbuttonf = new JButton("確認");
		confirmbuttonf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection=1;
				finddate= new Integer[]{(Integer) yearboxf.getSelectedItem(),(Integer) monthboxf.getSelectedItem(),(Integer) dayboxf.getSelectedItem()};
				countryf=(String) countrybox.getSelectedItem();
				setVisible(false);
				revalidate();
				repaint();
			}
		});
		confirmbuttonf.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		GroupLayout gl_fpanel = new GroupLayout(fpanel);
		gl_fpanel.setHorizontalGroup(
			gl_fpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_fpanel.createSequentialGroup()
					.addGroup(gl_fpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_fpanel.createSequentialGroup()
							.addGap(169)
							.addGroup(gl_fpanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_fpanel.createSequentialGroup()
									.addComponent(selectlabelf)
									.addGap(42))
								.addGroup(gl_fpanel.createSequentialGroup()
									.addComponent(datelabelf)
									.addGap(73)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_fpanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_fpanel.createSequentialGroup()
									.addComponent(yearboxf, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(labelf1, GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(monthboxf, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(labelf2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dayboxf, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
								.addComponent(countrybox, 0, 261, Short.MAX_VALUE))
							.addGap(57)
							.addComponent(hintlabelf))
						.addGroup(gl_fpanel.createSequentialGroup()
							.addGap(268)
							.addComponent(confirmbuttonf, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
					.addGap(199))
		);
		gl_fpanel.setVerticalGroup(
			gl_fpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_fpanel.createSequentialGroup()
					.addGap(103)
					.addGroup(gl_fpanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(selectlabelf)
						.addComponent(countrybox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_fpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_fpanel.createSequentialGroup()
							.addGap(78)
							.addGroup(gl_fpanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(yearboxf, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(datelabelf)
								.addComponent(monthboxf, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(dayboxf, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_fpanel.createSequentialGroup()
							.addGap(87)
							.addComponent(labelf1))
						.addGroup(gl_fpanel.createSequentialGroup()
							.addGap(86)
							.addComponent(labelf2)))
					.addGap(64)
					.addComponent(confirmbuttonf)
					.addContainerGap(141, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_fpanel.createSequentialGroup()
					.addContainerGap(231, Short.MAX_VALUE)
					.addComponent(hintlabelf)
					.addGap(235))
		);
		fpanel.setLayout(gl_fpanel);
		
		JPanel bpanel = new JPanel();
		seltab.addTab("預定行程", null, bpanel, null);
		
		JLabel productlabelb = new JLabel("行程代碼:");
		productlabelb.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JLabel startlabelb = new JLabel("出遊日期:");
		startlabelb.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JLabel endlabelb = new JLabel("返家日期:");
		endlabelb.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JLabel numlabelb = new JLabel("人數:");
		numlabelb.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		productfieldb = new JTextField();
		productfieldb.setColumns(10);
		
		JComboBox yearboxsb = new JComboBox(year);
		
		JComboBox monthboxsb = new JComboBox(month);
		
		JComboBox dayboxsb = new JComboBox(day);
		
		monthboxsb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer a=29;
				Integer b=30;
				Integer c=31;
				if (dayboxsb.getItemCount()==28) {
					dayboxsb.addItem(a);
					dayboxsb.addItem(b);
					dayboxsb.addItem(c);
				}
				else if (dayboxsb.getItemCount()==29) {
					dayboxsb.addItem(b);
					dayboxsb.addItem(c);
				}
				else if (dayboxsb.getItemCount()==30) {
					dayboxsb.addItem(c);
				}
				int m=(int) monthboxsb.getSelectedItem();
				int n=(int) yearboxsb.getSelectedItem();
				switch(m) {
				case 1:
					break;
				case 2:
					dayboxsb.removeItemAt(30);
					dayboxsb.removeItemAt(29);
					if (n==2021) {
						dayboxsb.removeItemAt(28);
					}
					break;
				case 3:
					break;
				case 4:
					dayboxsb.removeItemAt(30);
					break;
				case 5:
					break;
				case 6:
					dayboxsb.removeItemAt(30);
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					dayboxsb.removeItemAt(30);
					break;
				case 10:
					break;
				case 11:
					dayboxsb.removeItemAt(30);
					break;
				case 12:
					break;
				}
			}
		});
		
		JComboBox yearboxeb = new JComboBox(year);
		
		JComboBox monthboxeb = new JComboBox(month);
		
		JComboBox dayboxeb = new JComboBox(day);
		
		monthboxeb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer a=29;
				Integer b=30;
				Integer c=31;
				if (dayboxeb.getItemCount()==28) {
					dayboxeb.addItem(a);
					dayboxeb.addItem(b);
					dayboxeb.addItem(c);
				}
				else if (dayboxeb.getItemCount()==29) {
					dayboxeb.addItem(b);
					dayboxeb.addItem(c);
				}
				else if (dayboxeb.getItemCount()==30) {
					dayboxeb.addItem(c);
				}
				int m=(int) monthboxeb.getSelectedItem();
				int n=(int) yearboxeb.getSelectedItem();
				switch(m) {
				case 1:
					break;
				case 2:
					dayboxeb.removeItemAt(30);
					dayboxeb.removeItemAt(29);
					if (n==2021) {
						dayboxeb.removeItemAt(28);
					}
					break;
				case 3:
					break;
				case 4:
					dayboxeb.removeItemAt(30);
					break;
				case 5:
					break;
				case 6:
					dayboxeb.removeItemAt(30);
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					dayboxeb.removeItemAt(30);
					break;
				case 10:
					break;
				case 11:
					dayboxeb.removeItemAt(30);
					break;
				case 12:
					break;
				}
			}
		});
		
		JLabel labele1 = new JLabel("/");
		labele1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JLabel labele2 = new JLabel("/");
		labele2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JLabel labele3 = new JLabel("/");
		labele3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JLabel labele4 = new JLabel("/");
		labele4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		JLabel hintlabelb = new JLabel("(年/月/日)");
		hintlabelb.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		Integer numofpeople[]= {1,2,3,4,5,6,7,8,9,10,
				11,12,13,14,15,16,17,18,19,20,
				21,22,23,24,25,26,27,28,29,30,
				31,32,33,34,35,36,37,38,39,40,
				41,42,43,44,45,46,47,48,49,50};
		JComboBox numboxb = new JComboBox(numofpeople);
		
		JButton confirmbuttonb = new JButton("確認");
		confirmbuttonb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection=2;
				bookstartdate=new Integer[]{(Integer) yearboxsb.getSelectedItem(),(Integer) monthboxsb.getSelectedItem(),(Integer) dayboxsb.getSelectedItem()};
				bookenddate=new Integer[]{(Integer) yearboxeb.getSelectedItem(),(Integer) monthboxeb.getSelectedItem(),(Integer) dayboxeb.getSelectedItem()};
				numpeopleb=(int) numboxb.getSelectedItem();
				setVisible(false);
				revalidate();
				repaint();
			}
		});
		confirmbuttonb.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		GroupLayout gl_bpanel = new GroupLayout(bpanel);
		gl_bpanel.setHorizontalGroup(
			gl_bpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bpanel.createSequentialGroup()
					.addGap(245)
					.addGroup(gl_bpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bpanel.createSequentialGroup()
							.addComponent(productlabelb)
							.addGap(48)
							.addComponent(productfieldb, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_bpanel.createSequentialGroup()
							.addGroup(gl_bpanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_bpanel.createSequentialGroup()
									.addComponent(startlabelb)
									.addGap(34)
									.addComponent(yearboxsb, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_bpanel.createSequentialGroup()
									.addComponent(endlabelb)
									.addGap(43)
									.addComponent(yearboxeb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(confirmbuttonb, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_bpanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(labele1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(labele3, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_bpanel.createParallelGroup(Alignment.LEADING)
								.addComponent(monthboxeb, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addComponent(monthboxsb, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_bpanel.createSequentialGroup()
							.addComponent(numlabelb, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(numboxb, 0, 66, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_bpanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(labele4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(labele2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_bpanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(dayboxeb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(dayboxsb, 0, 57, Short.MAX_VALUE))
					.addGap(372))
				.addGroup(Alignment.TRAILING, gl_bpanel.createSequentialGroup()
					.addContainerGap(732, Short.MAX_VALUE)
					.addComponent(hintlabelb)
					.addGap(217))
		);
		gl_bpanel.setVerticalGroup(
			gl_bpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bpanel.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_bpanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_bpanel.createSequentialGroup()
							.addGroup(gl_bpanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(productfieldb)
								.addComponent(productlabelb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(55)
							.addGroup(gl_bpanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_bpanel.createSequentialGroup()
									.addGroup(gl_bpanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(startlabelb)
										.addComponent(yearboxsb, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
									.addGap(2))
								.addComponent(labele1)))
						.addComponent(labele2)
						.addComponent(dayboxsb, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(monthboxsb, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_bpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bpanel.createSequentialGroup()
							.addGap(45)
							.addComponent(labele3))
						.addGroup(gl_bpanel.createSequentialGroup()
							.addGap(45)
							.addComponent(labele4))
						.addGroup(gl_bpanel.createSequentialGroup()
							.addGap(14)
							.addComponent(hintlabelb)
							.addGap(5)
							.addGroup(gl_bpanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_bpanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(yearboxeb, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addComponent(endlabelb))
								.addComponent(dayboxeb, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(monthboxeb, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
							.addGap(49)
							.addGroup(gl_bpanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(numlabelb)
								.addComponent(numboxb, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
					.addGap(33)
					.addComponent(confirmbuttonb, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(83, Short.MAX_VALUE))
		);
		bpanel.setLayout(gl_bpanel);
		
		JPanel cpanel = new JPanel();
		seltab.addTab("取消/更改 你的行程", null, cpanel, null);
		
		JLabel bnumlabelc = new JLabel("預定號碼:");
		bnumlabelc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		bnumfieldc = new JTextField();
		bnumfieldc.setColumns(10);
		
		JLabel changelabelc = new JLabel("更改人數:");
		changelabelc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		JSeparator separatorc = new JSeparator();
		separatorc.setBackground(Color.BLACK);
		separatorc.setOrientation(SwingConstants.VERTICAL);
		
		JComboBox numboxc = new JComboBox(numofpeople);
		
		JLabel orlabelc = new JLabel("或");
		orlabelc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		JLabel cancellabelc = new JLabel("取消預定行程");
		cancellabelc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		JButton changebuttonc = new JButton("確定更改");
		changebuttonc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection=3;
				numpeoplec=(int) numboxc.getSelectedItem();
				setVisible(false);
				revalidate();
				repaint();
			}
		});
		changebuttonc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		JButton cancelbuttonc = new JButton("確定取消");
		cancelbuttonc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection=4;
				setVisible(false);
				revalidate();
				repaint();
			}
		});
		cancelbuttonc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		GroupLayout gl_cpanel = new GroupLayout(cpanel);
		gl_cpanel.setHorizontalGroup(
			gl_cpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cpanel.createSequentialGroup()
					.addGroup(gl_cpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cpanel.createSequentialGroup()
							.addGap(192)
							.addComponent(changebuttonc)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_cpanel.createSequentialGroup()
							.addContainerGap(160, Short.MAX_VALUE)
							.addGroup(gl_cpanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(bnumlabelc)
								.addGroup(gl_cpanel.createSequentialGroup()
									.addComponent(changelabelc)
									.addGap(18)
									.addComponent(numboxc, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_cpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cpanel.createSequentialGroup()
							.addGap(18)
							.addComponent(separatorc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cancellabelc)
							.addGap(18)
							.addComponent(cancelbuttonc))
						.addGroup(gl_cpanel.createSequentialGroup()
							.addGap(18)
							.addComponent(bnumfieldc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(209, Short.MAX_VALUE))
				.addGroup(gl_cpanel.createSequentialGroup()
					.addGap(442)
					.addComponent(orlabelc, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(524, Short.MAX_VALUE))
		);
		gl_cpanel.setVerticalGroup(
			gl_cpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cpanel.createSequentialGroup()
					.addGap(121)
					.addGroup(gl_cpanel.createParallelGroup(Alignment.LEADING)
						.addComponent(bnumfieldc, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(bnumlabelc, Alignment.TRAILING))
					.addGap(99)
					.addComponent(orlabelc, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_cpanel.createParallelGroup(Alignment.LEADING)
						.addComponent(cancelbuttonc, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(separatorc, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_cpanel.createSequentialGroup()
							.addGroup(gl_cpanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(numboxc, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(changelabelc))
							.addGap(33)
							.addComponent(changebuttonc, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(cancellabelc)))
		);
		cpanel.setLayout(gl_cpanel);
		
		JPanel spanel = new JPanel();
		seltab.addTab("找你的行程", null, spanel, null);
		
		JLabel bnumlabels = new JLabel("預定號碼:");
		bnumlabels.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		
		bnumfields = new JTextField();
		bnumfields.setColumns(10);
		
		JButton searchbuttons = new JButton("找找");
		searchbuttons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection=5;
				setVisible(false);
				revalidate();
				repaint();
			}
		});
		searchbuttons.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		GroupLayout gl_spanel = new GroupLayout(spanel);
		gl_spanel.setHorizontalGroup(
			gl_spanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanel.createSequentialGroup()
					.addGroup(gl_spanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_spanel.createSequentialGroup()
							.addGap(258)
							.addComponent(bnumlabels)
							.addGap(58)
							.addComponent(bnumfields, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_spanel.createSequentialGroup()
							.addGap(402)
							.addComponent(searchbuttons, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(422, Short.MAX_VALUE))
		);
		gl_spanel.setVerticalGroup(
			gl_spanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanel.createSequentialGroup()
					.addGap(121)
					.addGroup(gl_spanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(bnumfields, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(bnumlabels))
					.addGap(99)
					.addComponent(searchbuttons)
					.addGap(77)
					.addContainerGap(153, Short.MAX_VALUE))
		);
		spanel.setLayout(gl_spanel);
		setLayout(groupLayout);
	}

	public JTextField getProductfieldb() {

		return productfieldb;
	}

	public JTextField getBnumfieldc() {
		return bnumfieldc;
	}

	public JTextField getBnumfields() {
		return bnumfields;
	}
	public int getSelection() {
		return selection;
	}

	public Integer[] getFinddate() {
		return finddate;
	}

	public Integer[] getBookstartdate() {
		return bookstartdate;
	}

	public Integer[] getBookenddate() {
		return bookenddate;
	}

	public String getCountryf() {
		return countryf;
	}

	public int getNumpeopleb() {
		return numpeopleb;
	}

	public int getNumpeoplec() {
		return numpeoplec;
	}
	public static String readFile(String filename) { //讀資料
		String result = "";
	    try {
	        BufferedReader br = new BufferedReader(new FileReader(filename));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        result = sb.toString();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return result;
    }
}
