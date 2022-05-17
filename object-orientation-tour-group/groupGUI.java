import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;





public class groupGUI extends JFrame{
	private loginPanel lpanel;
	private selectPanel spanel;
	private loginErrorPanel lepanel;
	private accountDatabase adb;
	private Account a1;
	private Account a2;
	private Account a3;
	private Account a4;
	private Account a5;
	private allDatabase alldb;
	private bookingDetailDatabase bdd;
	
	public groupGUI() {
		setTitle("承昇旅遊");
		adb=new accountDatabase();
		alldb=new allDatabase();
		bdd=new bookingDetailDatabase();
		a1=new Account("b07505007","b07505007",null);
		a2=new Account("b07505021","b07505021",null);
		a3=new Account("b07505051","b07505051",null);
		a4=new Account("b07505054","b07505054",null);
		a5=new Account("1","1",null);
		adb.addAccount(a1);
		adb.addAccount(a2);
		adb.addAccount(a3);
		adb.addAccount(a4);
		adb.addAccount(a5);

		
		lpanel = new loginPanel();
		lpanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				remove(lpanel);
				if (adb.findAccount(lpanel.getUserfield().getText())==null) { //帳號不存在
					getContentPane().add(lepanel, BorderLayout.CENTER);
					lepanel.setVisible(true);
				}
				else {
					if (adb.findAccount(lpanel.getUserfield().getText()).checkPassword(lpanel.getPassfield().getText())==false) { //密碼錯誤
						getContentPane().add(lepanel, BorderLayout.CENTER);
						lepanel.setVisible(true);
					}
					else {
						getContentPane().add(spanel, BorderLayout.CENTER);
						spanel.setVisible(true);
					}
				}
				revalidate();
				repaint();
			}
		});
		
		JPanel spanelchild1=new JPanel();
		
		JButton back=new JButton("返回選單"); 
		back.setBounds(50,100,95,30);
		back.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				spanelchild1.setVisible(false);
				remove(spanelchild1);
				getContentPane().add(spanel, BorderLayout.CENTER);
				spanel.setVisible(true);

				revalidate();
				repaint();
			        }  
			    });
		
		JLabel failf = new JLabel("該時段無出團資訊");
		GroupLayout gl_spanelchild1 = new GroupLayout(spanelchild1);
		gl_spanelchild1.setHorizontalGroup(
			gl_spanelchild1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanelchild1.createSequentialGroup()
					.addGap(271)
					.addGroup(gl_spanelchild1.createParallelGroup(Alignment.LEADING)
						.addComponent(failf)
						.addComponent(back))
					.addContainerGap(662, Short.MAX_VALUE))
		);
		gl_spanelchild1.setVerticalGroup(
			gl_spanelchild1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_spanelchild1.createSequentialGroup()
					.addContainerGap(207, Short.MAX_VALUE)
					.addComponent(failf)
					.addGap(77)
					.addComponent(back)
					.addGap(241))
		);
		spanelchild1.setLayout(gl_spanelchild1);
		
		
		JPanel spanelchild2=new JPanel();
        JLabel title = new JLabel("行程:");
		
		JLabel price = new JLabel("價格:");
		
		JLabel min = new JLabel("*人數下限:");
		
		JLabel max = new JLabel("*人數上限:");
		
		JLabel startdate = new JLabel("*出遊日期:");
		
		JLabel enddate = new JLabel("*返家日期:");
		
		JLabel title1 = new JLabel("New label");
		
		JLabel price1 = new JLabel("New label");
		
		JLabel min2 = new JLabel("New label");
		
		JLabel max1 = new JLabel("New label");
		
		JLabel startdate1 = new JLabel("New label");
		
		JLabel enddate1 = new JLabel("New label");
		
		JButton back2 = new JButton("返回選單");
		back2.setBounds(50,100,95,30);
		back2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				spanelchild2.setVisible(false);
				remove(spanelchild2);
				getContentPane().add(spanel, BorderLayout.CENTER);
				spanel.setVisible(true);

				revalidate();
				repaint();
			    }  
			}); 
		
		JLabel product = new JLabel("*行程代碼:");
		
		JLabel product1 = new JLabel("New label");
	
		GroupLayout gl_spanelchild2 = new GroupLayout(spanelchild2);
		gl_spanelchild2.setHorizontalGroup(
			gl_spanelchild2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_spanelchild2.createSequentialGroup()
					.addContainerGap(566, Short.MAX_VALUE)
					.addComponent(back2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(349))
				.addGroup(gl_spanelchild2.createSequentialGroup()
					.addGap(132)
					.addGroup(gl_spanelchild2.createParallelGroup(Alignment.LEADING)
						.addComponent(title1)
						.addComponent(title)
						.addGroup(gl_spanelchild2.createSequentialGroup()
							.addGroup(gl_spanelchild2.createParallelGroup(Alignment.LEADING)
								.addComponent(price)
								.addComponent(min)
								.addComponent(max)
								.addComponent(enddate)
								.addComponent(startdate)
								.addComponent(product))
							.addGap(111)
							.addGroup(gl_spanelchild2.createParallelGroup(Alignment.LEADING)
								.addComponent(product1)
								.addComponent(startdate1)
								.addComponent(enddate1)
								.addComponent(max1)
								.addComponent(min2)
								.addComponent(price1))))
					.addContainerGap(654, Short.MAX_VALUE))
		);
		gl_spanelchild2.setVerticalGroup(
			gl_spanelchild2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanelchild2.createSequentialGroup()
					.addGap(32)
					.addComponent(title)
					.addGap(31)
					.addComponent(title1)
					.addGap(33)
					.addGroup(gl_spanelchild2.createParallelGroup(Alignment.BASELINE)
						.addComponent(price)
						.addComponent(price1))
					.addGap(37)
					.addGroup(gl_spanelchild2.createParallelGroup(Alignment.BASELINE)
						.addComponent(min)
						.addComponent(min2))
					.addGap(44)
					.addGroup(gl_spanelchild2.createParallelGroup(Alignment.BASELINE)
						.addComponent(max)
						.addComponent(max1))
					.addGap(9)
					.addComponent(back2)
					.addGap(18)
					.addGroup(gl_spanelchild2.createParallelGroup(Alignment.BASELINE)
						.addComponent(startdate)
						.addComponent(startdate1))
					.addGap(49)
					.addGroup(gl_spanelchild2.createParallelGroup(Alignment.BASELINE)
						.addComponent(enddate)
						.addComponent(enddate1))
					.addGap(58)
					.addGroup(gl_spanelchild2.createParallelGroup(Alignment.BASELINE)
						.addComponent(product)
						.addComponent(product1))
					.addContainerGap(146, Short.MAX_VALUE))
		);
		spanelchild2.setLayout(gl_spanelchild2);
		
		JPanel spanelchild3=new JPanel();
		
		JLabel failb = new JLabel("New label");
		
		JButton back3 = new JButton("返回選單");
		back3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spanelchild3.setVisible(false);
				remove(spanelchild3);
				getContentPane().add(spanel, BorderLayout.CENTER);
				spanel.setVisible(true);

				revalidate();
				repaint();
			}
		});
		GroupLayout gl_spanelchild3 = new GroupLayout(spanelchild3);
		gl_spanelchild3.setHorizontalGroup(
			gl_spanelchild3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanelchild3.createSequentialGroup()
					.addGap(138)
					.addGroup(gl_spanelchild3.createParallelGroup(Alignment.LEADING)
						.addComponent(back3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addComponent(failb))
					.addContainerGap(763, Short.MAX_VALUE))
		);
		gl_spanelchild3.setVerticalGroup(
			gl_spanelchild3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanelchild3.createSequentialGroup()
					.addGap(139)
					.addComponent(failb)
					.addGap(157)
					.addComponent(back3)
					.addContainerGap(229, Short.MAX_VALUE))
		);
		spanelchild3.setLayout(gl_spanelchild3);
		
		JPanel spanelchild4=new JPanel();
		
		JLabel successlabel = new JLabel("預定成功!!");
		
		JLabel bnumb = new JLabel("預定號碼:");
		
		JLabel bnumb1 = new JLabel("New label");
		
		JLabel titleb = new JLabel("行程:");
		
		JLabel titleb1 = new JLabel("New label");
		
		JLabel dateb = new JLabel("日期:");
		
		JLabel dateb1 = new JLabel("New label");
		
		JLabel priceb = new JLabel("價格:");
		
		JLabel priceb1 = new JLabel("New label");
		
		JLabel numpplb = new JLabel("人數:");
		
		JLabel numpplb1 = new JLabel("New label");
		
		JButton back4 = new JButton("返回選單");
		back4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spanelchild4.setVisible(false);
				remove(spanelchild4);
				getContentPane().add(spanel, BorderLayout.CENTER);
				spanel.setVisible(true);

				revalidate();
				repaint();
			}
		});
		GroupLayout gl_spanelchild4 = new GroupLayout(spanelchild4);
		gl_spanelchild4.setHorizontalGroup(
			gl_spanelchild4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanelchild4.createSequentialGroup()
					.addGap(114)
					.addGroup(gl_spanelchild4.createParallelGroup(Alignment.LEADING)
						.addComponent(titleb1)
						.addComponent(titleb)
						.addComponent(successlabel)
						.addGroup(gl_spanelchild4.createSequentialGroup()
							.addGroup(gl_spanelchild4.createParallelGroup(Alignment.LEADING)
								.addComponent(bnumb)
								.addComponent(dateb)
								.addComponent(priceb)
								.addComponent(numpplb))
							.addGap(109)
							.addGroup(gl_spanelchild4.createParallelGroup(Alignment.LEADING)
								.addComponent(numpplb1)
								.addGroup(gl_spanelchild4.createSequentialGroup()
									.addComponent(priceb1)
									.addGap(202)
									.addComponent(back4, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
								.addComponent(dateb1)
								.addComponent(bnumb1))))
					.addContainerGap(384, Short.MAX_VALUE))
		);
		gl_spanelchild4.setVerticalGroup(
			gl_spanelchild4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanelchild4.createSequentialGroup()
					.addGap(50)
					.addComponent(successlabel)
					.addGap(51)
					.addGroup(gl_spanelchild4.createParallelGroup(Alignment.BASELINE)
						.addComponent(bnumb)
						.addComponent(bnumb1))
					.addGap(41)
					.addComponent(titleb)
					.addGap(40)
					.addComponent(titleb1)
					.addGap(50)
					.addGroup(gl_spanelchild4.createParallelGroup(Alignment.BASELINE)
						.addComponent(dateb)
						.addComponent(dateb1))
					.addGap(49)
					.addGroup(gl_spanelchild4.createParallelGroup(Alignment.BASELINE)
						.addComponent(priceb)
						.addComponent(priceb1))
					.addGap(56)
					.addGroup(gl_spanelchild4.createParallelGroup(Alignment.BASELINE)
						.addComponent(numpplb)
						.addComponent(numpplb1))
					.addContainerGap(121, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_spanelchild4.createSequentialGroup()
					.addContainerGap(368, Short.MAX_VALUE)
					.addComponent(back4)
					.addGap(172))
		);
		spanelchild4.setLayout(gl_spanelchild4);
		
		JPanel spanelchild5=new JPanel();
		
		JLabel failc = new JLabel("New label");
		
		JButton back5 = new JButton("返回選單");
		back5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spanelchild5.setVisible(false);
				remove(spanelchild5);
				getContentPane().add(spanel, BorderLayout.CENTER);
				spanel.setVisible(true);
				revalidate();
				repaint();
			}
		});
		GroupLayout gl_spanelchild5 = new GroupLayout(spanelchild5);
		gl_spanelchild5.setHorizontalGroup(
			gl_spanelchild5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanelchild5.createSequentialGroup()
					.addGroup(gl_spanelchild5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_spanelchild5.createSequentialGroup()
							.addGap(275)
							.addComponent(failc))
						.addGroup(gl_spanelchild5.createSequentialGroup()
							.addGap(254)
							.addComponent(back5, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(647, Short.MAX_VALUE))
		);
		gl_spanelchild5.setVerticalGroup(
			gl_spanelchild5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanelchild5.createSequentialGroup()
					.addGap(207)
					.addComponent(failc)
					.addGap(88)
					.addComponent(back5)
					.addContainerGap(230, Short.MAX_VALUE))
		);
		spanelchild5.setLayout(gl_spanelchild5);
		
		JPanel spanelchild6=new JPanel();
		
		JLabel successc = new JLabel("New label");
		
		JButton back6 = new JButton("返回選單");
		back6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spanelchild6.setVisible(false);
				remove(spanelchild6);
				getContentPane().add(spanel, BorderLayout.CENTER);
				spanel.setVisible(true);
				revalidate();
				repaint();
			}
		});
		GroupLayout gl_spanelchild6 = new GroupLayout(spanelchild6);
		gl_spanelchild6.setHorizontalGroup(
			gl_spanelchild6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanelchild6.createSequentialGroup()
					.addGap(230)
					.addGroup(gl_spanelchild6.createParallelGroup(Alignment.LEADING)
						.addComponent(back6, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addComponent(successc))
					.addContainerGap(671, Short.MAX_VALUE))
		);
		gl_spanelchild6.setVerticalGroup(
			gl_spanelchild6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanelchild6.createSequentialGroup()
					.addGap(199)
					.addComponent(successc)
					.addGap(119)
					.addComponent(back6)
					.addContainerGap(207, Short.MAX_VALUE))
		);
		spanelchild6.setLayout(gl_spanelchild6);
		JPanel spanelchild10=new JPanel();

		
		JLabel bookingnumber11 = new JLabel("預定號碼:");
		
		JLabel numofpeople11 = new JLabel("人數:");
		
		JLabel startdate11 = new JLabel("出遊日期:");
		
		JLabel enddate11 = new JLabel("返家日期:");
		
		JLabel price11 = new JLabel("價格:");
		
		JLabel bookingnumber22 = new JLabel("New label");
		
		JLabel numofpeople22 = new JLabel("New label");
		
		JLabel startdate22 = new JLabel("New label");
		
		JLabel enddate22 = new JLabel("New label");
		
		JLabel price22 = new JLabel("New label");
		
		JLabel title11 = new JLabel("行程:");
		
		JLabel title22 = new JLabel("New label");
		
		JButton backk = new JButton("返回選單");
		backk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spanelchild10.setVisible(false);
				remove(spanelchild10);
				getContentPane().add(spanel, BorderLayout.CENTER);
				spanel.setVisible(true);
				revalidate();
				repaint();
			}
		});
		GroupLayout gl_spanelchild10 = new GroupLayout(spanelchild10);
		gl_spanelchild10.setHorizontalGroup(
			gl_spanelchild10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanelchild10.createSequentialGroup()
					.addGap(135)
					.addGroup(gl_spanelchild10.createParallelGroup(Alignment.LEADING)
						.addComponent(price11)
						.addComponent(enddate11)
						.addComponent(startdate11)
						.addComponent(numofpeople11)
						.addComponent(bookingnumber11)
						.addComponent(title11))
					.addGap(64)
					.addGroup(gl_spanelchild10.createParallelGroup(Alignment.LEADING)
						.addComponent(title22)
						.addComponent(bookingnumber22)
						.addComponent(numofpeople22)
						.addComponent(startdate22)
						.addComponent(enddate22)
						.addComponent(price22))
					.addContainerGap(695, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_spanelchild10.createSequentialGroup()
					.addContainerGap(510, Short.MAX_VALUE)
					.addComponent(backk, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(391))
		);
		gl_spanelchild10.setVerticalGroup(
			gl_spanelchild10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spanelchild10.createSequentialGroup()
					.addGap(121)
					.addGroup(gl_spanelchild10.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookingnumber11)
						.addComponent(bookingnumber22))
					.addGap(53)
					.addGroup(gl_spanelchild10.createParallelGroup(Alignment.BASELINE)
						.addComponent(title11)
						.addComponent(title22))
					.addGap(52)
					.addGroup(gl_spanelchild10.createParallelGroup(Alignment.BASELINE)
						.addComponent(numofpeople11)
						.addComponent(numofpeople22))
					.addGap(45)
					.addGroup(gl_spanelchild10.createParallelGroup(Alignment.BASELINE)
						.addComponent(startdate11)
						.addComponent(startdate22))
					.addGap(52)
					.addGroup(gl_spanelchild10.createParallelGroup(Alignment.BASELINE)
						.addComponent(enddate11)
						.addComponent(enddate22))
					.addGap(39)
					.addGroup(gl_spanelchild10.createParallelGroup(Alignment.BASELINE)
						.addComponent(price11)
						.addComponent(price22))
					.addContainerGap(111, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_spanelchild10.createSequentialGroup()
					.addContainerGap(291, Short.MAX_VALUE)
					.addComponent(backk)
					.addGap(249))
		);
		spanelchild10.setLayout(gl_spanelchild10);
		
		
        JPanel spanelchild11=new JPanel();

		 
		 JLabel wrong = new JLabel("預訂號碼不存在");
		 
		 JButton back22 = new JButton("返回選單");
			back22.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					spanelchild11.setVisible(false);
					remove(spanelchild11);
					getContentPane().add(spanel, BorderLayout.CENTER);
					spanel.setVisible(true);
					revalidate();
					repaint();
				}
			});
		 GroupLayout gl_spanelchild11 = new GroupLayout(spanelchild11);
		 gl_spanelchild11.setHorizontalGroup(
		 	gl_spanelchild11.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_spanelchild11.createSequentialGroup()
		 			.addGroup(gl_spanelchild11.createParallelGroup(Alignment.LEADING)
		 				.addGroup(gl_spanelchild11.createSequentialGroup()
		 					.addGap(227)
		 					.addComponent(wrong, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
		 				.addGroup(gl_spanelchild11.createSequentialGroup()
		 					.addGap(378)
		 					.addComponent(back22, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
		 			.addContainerGap(342, Short.MAX_VALUE))
		 );
		 gl_spanelchild11.setVerticalGroup(
		 	gl_spanelchild11.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_spanelchild11.createSequentialGroup()
		 			.addGap(190)
		 			.addComponent(wrong, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
		 			.addGap(127)
		 			.addComponent(back22)
		 			.addContainerGap(184, Short.MAX_VALUE))
		 );
		 spanelchild11.setLayout(gl_spanelchild11);
		 
		
		
		spanel = new selectPanel();
		spanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				remove(spanel);
				switch (spanel.getSelection()) {
				case 1:
					String k=alldb.countrytotravelcode(spanel.getCountryf());
					int i=0;
					boolean a=false;
					try {
						//為了節省時間，不要每次都跑一萬多遍
					    while(!alldb.totravelcode(i).equals(k)) {
						    i++;
					    }
					    while(alldb.totravelcode(i).equals(k)) {
						    if(a==true||i==10140)
							    break;
						    if(alldb.checkdate(spanel.getFinddate(), alldb.todatestrings(i)))
						    	a=true;
						    else
						    	i++;
					    }
					}
					catch(ArrayIndexOutOfBoundsException A) {
						;
					}
					
					if(a) {
						if (alldb.checkIsTaken(i)) { //行程已被預訂
							getContentPane().add(spanelchild1, BorderLayout.CENTER);
						    spanelchild1.setVisible(true);
						}
						else {
						String[] b=alldb.toalldata(i);
						title1.setText(b[0]);
						price1.setText(b[3]);
						min2.setText(b[6]);
						max1.setText(b[7]);
						startdate1.setText(b[4]);
						enddate1.setText(b[5]);
						product1.setText(b[2]);
						getContentPane().add(spanelchild2, BorderLayout.CENTER);
						spanelchild2.setVisible(true);
						}
					}
					else {
					    getContentPane().add(spanelchild1, BorderLayout.CENTER);
					    spanelchild1.setVisible(true);
					}
					break;
				case 2:
					int i2=0;
					int l2=0;
					boolean a2=false; //行程代碼的flag
					boolean a3=false; //日期的flag
					try {
						while(!alldb.toproductkey(i2).equals(spanel.getProductfieldb().getText())) {
							i2++;
						}
						for (int l=i2;l<10140;l++) {
							a2=true;
							if (alldb.toproductkey(l).equals(spanel.getProductfieldb().getText())==true&&alldb.checkdate(spanel.getBookstartdate(), alldb.todatestrings(l))==true&&alldb.checkdate(spanel.getBookenddate(), alldb.todatestringe(l))==true) {
								a3=true;
								l2=l;
								break;
							}
						}
					}
					catch(ArrayIndexOutOfBoundsException A) {
						;
					}
					if (!a2) {
						failb.setText("行程代碼不存在");
						getContentPane().add(spanelchild3, BorderLayout.CENTER);
						spanelchild3.setVisible(true);
					}
					else {
						if (!a3) {
							failb.setText("該時段無出團資訊");
							getContentPane().add(spanelchild3, BorderLayout.CENTER);
							spanelchild3.setVisible(true);
						}
						else {
							if (!alldb.checkNumofPeople(l2, spanel.getNumpeopleb())) {
								failb.setText("人數太多或太少");
								getContentPane().add(spanelchild3, BorderLayout.CENTER);
								spanelchild3.setVisible(true);
							}
							else {
								if (alldb.checkIsTaken(l2)) { 
									failb.setText("行程已被預定");
									getContentPane().add(spanelchild3, BorderLayout.CENTER);
									spanelchild3.setVisible(true);
								}
								else {
									String[] b2=alldb.toalldata(l2);
									bookingDetail bd=new bookingDetail(bdd.generateBookingNumber(),b2[0],b2[2],b2[3],b2[4],b2[5],String.valueOf(spanel.getNumpeopleb()),l2);
									adb.findAccount(lpanel.getUserfield().getText()).addBookingDetail(bd);
									bnumb1.setText(bd.getBookingnumber());
									titleb1.setText(bd.getTitle());
									dateb1.setText(bd.getStartdate()+" ~ "+bd.getEnddate());
									priceb1.setText(bd.getPrice());
									numpplb1.setText(bd.getNumofpeople());
									alldb.setIsTaken(l2, true);
									getContentPane().add(spanelchild4, BorderLayout.CENTER);
									spanelchild4.setVisible(true);
								}
							}
						}
					}
					break;
				case 3:
					bookingDetail b3=adb.findAccount(lpanel.getUserfield().getText()).findBookingDetail(spanel.getBnumfieldc().getText());
					if (b3==null) {
						failc.setText("預定號碼不存在");
						getContentPane().add(spanelchild5, BorderLayout.CENTER);
						spanelchild5.setVisible(true);
					}
					else {
						if (!alldb.checkNumofPeople(b3.getRow(), spanel.getNumpeoplec())) {
							failc.setText("人數太多或太少");
							getContentPane().add(spanelchild5, BorderLayout.CENTER);
							spanelchild5.setVisible(true);
						}
						else {
							b3.setNumofpeople(String.valueOf(spanel.getNumpeoplec()));
							successc.setText("成功更改人數為 "+String.valueOf(spanel.getNumpeoplec()));
							getContentPane().add(spanelchild6, BorderLayout.CENTER);
							spanelchild6.setVisible(true);
						}
					}
					break;
				case 4:
					bookingDetail b4=adb.findAccount(lpanel.getUserfield().getText()).findBookingDetail(spanel.getBnumfieldc().getText());
					if (b4==null) {
						failc.setText("預定號碼不存在");
						getContentPane().add(spanelchild5, BorderLayout.CENTER);
						spanelchild5.setVisible(true);
					}
					else {
						alldb.setIsTaken(b4.getRow(), false);
						adb.findAccount(lpanel.getUserfield().getText()).removeBookingDetail(b4);
						successc.setText("成功取消預定行程");
						getContentPane().add(spanelchild6, BorderLayout.CENTER);
						spanelchild6.setVisible(true);
					}
					break;
				case 5:
					boolean Z=false;
					bookingDetail b5=adb.findAccount(lpanel.getUserfield().getText()).findBookingDetail(spanel.getBnumfields().getText());
					bookingDetail[] c=adb.findAccount(lpanel.getUserfield().getText()).getBookingnum();
					int P=0;
					try{
						for(int I=0;I<adb.findAccount(lpanel.getUserfield().getText()).getBookingnum().length;I++){
						
							if(b5.getBookingnumber().equals(c[I].getBookingnumber())) {
								Z=true;
								P=I;
								break;
							}
						}
					}catch(NullPointerException e1) {
						;
					}
					if(Z) {
						getContentPane().add(spanelchild10, BorderLayout.CENTER);
						spanelchild10.setVisible(true);
						 bookingnumber22.setText(c[P].getBookingnumber()); 							
						 numofpeople22.setText(c[P].getNumofpeople());					
						 startdate22.setText(c[P].getStartdate());							
					     enddate22.setText(c[P].getEnddate());
						 price22.setText(c[P].getPrice());
						 title22.setText(c[P].getTitle());
					}
					else {
					
						getContentPane().add(spanelchild11, BorderLayout.CENTER);
						spanelchild11.setVisible(true);
						
							
					}
					break;
				case 6:
					getContentPane().add(lpanel, BorderLayout.CENTER);
					lpanel.setVisible(true);
					break;
				}
				revalidate();
				repaint();
			}
		});
		lepanel=new loginErrorPanel();
		lepanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				remove(lepanel);
				getContentPane().add(lpanel, BorderLayout.CENTER);
				lpanel.setVisible(true);
				revalidate();
				repaint();
			}
		});
		
	this.getContentPane().add(lpanel, BorderLayout.CENTER);
	
	setSize(1000, 600);  
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true); 
		 
		 
	}
}
