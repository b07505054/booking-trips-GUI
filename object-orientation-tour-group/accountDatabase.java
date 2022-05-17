
public class accountDatabase {
	private Account[] accArray;

	
	public accountDatabase() {
		accArray=null;
	}
	public Account[] getAccArray() {
		return accArray;
	}
	public void setAccArray(Account[] accArray) {
		this.accArray = accArray;
	}
	public void addAccount(Account a) { //新增帳號
		if (accArray==null) {
			accArray=new Account[1];
			accArray[0]=a;
		}
		else {
			Account[] temp=new Account[accArray.length+1];
			for (int i=0;i<accArray.length;i++) {
				temp[i]=accArray[i];
			}
			temp[accArray.length]=a;
			accArray=temp;
		}
	}

	public Account findAccount(String s) { //尋找帳號
		Account temp=null;
		for (int i=0;i<accArray.length;i++) {
			if (s.equals(accArray[i].getUsername())==true) {
				temp=accArray[i];
				break;
			}
		}
		return temp;
	}
	
}
