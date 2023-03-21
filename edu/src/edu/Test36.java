package edu;

public class Test36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char letter='A';
		int n = (int) letter;
		System.out.println(n);
		System.out.println(n+1);
		char[ ] alphabet = new char [26];
		
		for (int i =0; i<alphabet.length; i++) {
			alphabet[i] = (char) (letter + i);
		}
		for(char c : alphabet) {
			//System.out.println(c);
			System.out.print(" "+c);
		}
	}

}
