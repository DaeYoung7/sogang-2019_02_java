package myown;

import java.util.Scanner;

//find pattern in text for O(n+m) n:length of text, m:length of pattern
class KmpClass {
	private String text;
	private String pat;
	private int failure[];

	public KmpClass(String t, String f) {
		this.text = new String(t);
		this.pat = new String(f);
		this.failure = new int[f.length()];
	}

	int pMatch()
	{
		int i=0,j=0;
		int lens=this.text.length();
		int lenp=this.pat.length();
		while(i<lens && j<lenp)
		{
			if(this.text.charAt(i)==this.pat.charAt(j))
			{
				i++;j++;
			}
			else if(j==0) i++;
			else j=failure[j-1]+1;
		}
		return ((j==lenp)?(i-lenp):-1);
	}

	// find patten's prefix, suffix
	void fail() {
		int i, j, n = this.pat.length();
		this.failure[0] = -1;
		for (j = 1; j < n; j++) {
			i = this.failure[j - 1];
			while ((this.pat.charAt(i + 1) != this.pat.charAt(j)) && (i >= 0))
				i = this.failure[i];
			if (this.pat.charAt(j) == this.pat.charAt(i + 1))
				failure[j] = i + 1;
			else
				this.failure[j] = -1;
		}
	}
}

public class kmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int index;

		System.out.print("Enter a text: ");
		String text = scan.nextLine();

		System.out.print("Enter a string: ");
		String find = scan.nextLine();

		KmpClass findPat = new KmpClass(text, find);
		findPat.fail();
		index=findPat.pMatch();
		
		System.out.printf("I have found \"%s\" at %d index of text", find, index);
		
		scan.close();
	}

}

