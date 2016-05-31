package demo;

import java.util.ArrayList;

public class myClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "%one%%two%%%three%%%%";
		//ArrayList<String> sa = new ArrayList<String>();
		String [] sa = test.split("[one,two,three]");
		for (int i = 0; i < sa.length; i++) {
		System.out.print(sa[i] + ", ");
		}
	}

}
