import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;

public class allDatabase {
	private String[][] csvData;
	private String[][] jsonData;
	private boolean[] isTaken;
	
	public String[][] getCsvData() {
		return csvData;
	}
	public String[][] getJsonData() {
		return jsonData;
	}
	
	public allDatabase() {
		int i=0;
		String[][] alldata = new String[10140][8];
		String[][] alldata2 = new String[103][2];
		isTaken=new boolean[10140];
		for (int q=0;q<10140;q++) {
			isTaken[q]=false;
		}
		String line = "";
		try   
		{  
		BufferedReader br = new BufferedReader(new FileReader("trip_data_all.csv"));  
		while ((line = br.readLine()) != null){  
		 String[] temp= line.split(",");  
		 for (int j=0;j<8;j++) {
			 alldata[i][j]=temp[j];
		 }
		 i++;
		}
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();  
		}
		csvData=alldata;
		String jsondata = readFile("travel_code.json");
		JSONArray jsonarray = new JSONArray(jsondata);
		for (int j=0;j<103;j++) {
			alldata2[j][0]=jsonarray.getJSONObject(j).getString("travel_code");
			alldata2[j][1]=jsonarray.getJSONObject(j).getString("travel_code_name");
		}
		jsonData=alldata2;
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
	public String[] getAllCountry() { //把所有國家放進一個String的array
		String[] temp=new String[103];
		for (int i=0;i<103;i++) {
			temp[i]=jsonData[i][1];
		}
		return temp;
	}

	public String countrytotravelcode(String s) { //回傳所選國家的travel code
		int k=0;
		for(int i=0;i<103;i++) {
			if(jsonData[i][1].equals(s)) {
				k=i;
				break;
			}
			else
				continue;
		}
		return jsonData[k][0];
	}
	
	
	public String[] toalldata(int i) { //找出第i行的資料
		String[] a=new String[8];
		for(int j=0;j<8;j++) {
			a[j]=csvData[i][j];
		}
		
		return a;

	}
	public String todatestrings(int i) { //找出第i行的start date
		String[] a=toalldata(i);
		String b=a[4];
		return b;
	}
	public String todatestringe(int i) { //找出第i行的end date
		String[] a=toalldata(i);
		String b=a[5];
		return b;
	}
	public String totravelcode(int i) { //找出第i行的travel code
		String[] a=toalldata(i);
		String b=a[1];
		return b;
	}
	public String toproductkey(int i) { //找出第i行的product key
		String[] a=toalldata(i);
		String b=a[2];
		return b;
	}

	public boolean checkdate(Integer[] a,String b) { //檢查日期是否一致
		String[] c=b.split("-");
		int  k0=Integer.parseInt(c[0]);
		int  k1=Integer.parseInt(c[1]);
		int  k2=Integer.parseInt(c[2]);
		int l0=a[0].intValue();
		int l1=a[1].intValue();
		int l2=a[2].intValue();
		if(l0==k0&&l1==k1&&l2==k2) {
			return true;
		}
		else
			return false;
	}
	
	public boolean checkIsTaken(int i) { //檢查第i行的行程是否已被預訂
		return isTaken[i];
	}
	public void setIsTaken(int i,boolean b) {
		isTaken[i]=b;
	}
	public boolean checkNumofPeople(int i,int j) { //檢查j是否在第i行的人數上限及下限之間
		int a1=Integer.parseInt(csvData[i][6]);
		int a2=Integer.parseInt(csvData[i][7]);
		if (j>=a1&&j<=a2) {
			return true;
		}
		else {
			return false;
		}
	}
	
}



