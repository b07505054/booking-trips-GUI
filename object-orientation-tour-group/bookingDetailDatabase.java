
public class bookingDetailDatabase {
	private Integer random;
	
	public bookingDetailDatabase() {
		random=0;
	}

	public String generateBookingNumber() { //產生一個booking number
		random+=1;
		return random.toString();
	}
}
