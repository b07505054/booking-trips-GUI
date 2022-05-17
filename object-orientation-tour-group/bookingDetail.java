
public class bookingDetail {
	private String bookingnumber;
	private String title;
	private String productkey;
	private String price;
	private String startdate;
	private String enddate;
	private String numofpeople;
	private int row; //allDataBase裡第row行的資料
	
	public bookingDetail() {
		this.bookingnumber = null;
		this.title = null;
		this.productkey = null;
		this.price = null;
		this.startdate = null;
		this.enddate = null;
		this.numofpeople = null;
		this.row=0;
	}
	
	public String getBookingnumber() {
		return bookingnumber;
	}

	public bookingDetail(String bookingnumber, String title, String productkey, String price,
			String startdate, String enddate, String numofpeople, int row) {
		this.bookingnumber = bookingnumber;
		this.title = title;
		this.productkey = productkey;
		this.price = price;
		this.startdate = startdate;
		this.enddate = enddate;
		this.numofpeople = numofpeople;
		this.row=row;
	}

	public String getNumofpeople() {
		return numofpeople;
	}

	public void setNumofpeople(String numofpeople) {
		this.numofpeople = numofpeople;
	}

	public String getTitle() {
		return title;
	}

	public String getProductkey() {
		return productkey;
	}

	public String getPrice() {
		return price;
	}

	public String getStartdate() {
		return startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public int getRow() {
		return row;
	}
	
	
}	