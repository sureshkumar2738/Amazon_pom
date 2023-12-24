package multiple_dropdown;

import java.util.Scanner;

public class count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str;
		int len =0;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the String : ");
		str = s.nextLine();
		char[] strChars = str.toCharArray();
		for(char ch : strChars) {
			len++;
		}
		System.out.println("Length of string : "+len);
		
		
		for(int i=0; i<str.length(); i++) {
			for(int j= i+1; j<str.length(); j++) {
				if(strChars[i] == strChars[j]) {
					System.out.print(strChars[j]+ " ");
					break;
				}
			}
		}
	}

}
