
public class Account {
	private String username;
	private String password;
	private bookingDetail[] bookingnum;
	
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public bookingDetail[] getBookingnum() {
		return bookingnum;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Account() {
		this.username = null;
		this.password = null;
		this.bookingnum = null;
	}
	public Account(String username, String password, bookingDetail[] bookingnum) {
		this.username = username;
		this.password = password;
		this.bookingnum = bookingnum;
	}
	public boolean checkPassword(String p) {
		return p.equals(password);
	};
	
	public void addBookingDetail(bookingDetail s) { //新增booking detail
		if (bookingnum==null) {
			bookingnum=new bookingDetail[1];
			bookingnum[0]=s;
		}
		else {
			bookingDetail[] temp=new bookingDetail[bookingnum.length+1];
			for (int i=0;i<bookingnum.length;i++) {
				temp[i]=bookingnum[i];
			}
			temp[bookingnum.length]=s;
			bookingnum=temp;
		}
	}
	public void removeBookingDetail(bookingDetail b) { //移除booking detail
		bookingDetail[] temp=bookingnum;
		bookingnum=null;
		for (int i=0;i<temp.length;i++) {
			if (!temp[i].getBookingnumber().equals(b.getBookingnumber())) {
				this.addBookingDetail(temp[i]);
			}
		}
	}
	public bookingDetail findBookingDetail(String s) { //尋找booking detail
		bookingDetail temp=null;
		if (bookingnum!=null) {
			for (int i=0;i<bookingnum.length;i++) {
				if (s.equals(bookingnum[i].getBookingnumber())==true) {
					temp=bookingnum[i];
					break;
				}
			}
		}
		return temp;
	}
}
