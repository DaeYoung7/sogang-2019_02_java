package cse3040;

/**
 * CSE3040 HW3
 * Level021.java
 * Purpose: �˶�򿡼� ����Ʈ���� 50�� ���� ��ũ�����ϱ�
 * 
 * @version 1.0 11/26/2019
 * @author Daeyoung Eo
 */
import java.util.*;
import java.net.*;
import java.io.*;

public class Level021 {
	// ����Ʈ html�� ���� ���� ������ �ڷᱸ��
	static ArrayList<String> lines = new ArrayList<>();

	/**
	 * The main method for the program.
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
		String address = "https://aladin.co.kr/shop/common/wbest.aspx?BestType=Bestseller&BranchType=1&CID=0";
		String line = "";
		// html�� �� �پ� �����鼭 ������ �ִٸ� ����Ʈ�� ����
		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = input.readLine()) != null) {
				if (line.trim().length() > 0)
					lines.add(line);
			}
			input.close();
		} catch (IOException e) {
			System.out.println("failed opening url");
			return;
		}
		int rank = 1;
		// statusD: ��¥ ���� ���� �� ���, statusB: å ���� ���� �� ���
		int statusD = 0, statusB = 0;
		// line���� substring���� �� ����ϴ� index
		int indexS, indexF;
		for (String i : lines) {
			// ����, �۰� ���� ��ũ����
			if (statusB >= 0) {
				if (i.contains("div id=\"newbg_body\""))
					statusB = 1;
				if (statusB == 1 && i.contains("div class=\"ss_book_box"))
					statusB = 2;
				if (statusB == 2 && i.contains("div class=\"ss_book_list\""))
					statusB = 3;
				if (statusB == 3 && i.contains("class=\"bo3\"")) {
					statusB = 4;
					indexS = i.indexOf("<b>") + 3;
					indexF = i.indexOf("</b>");
					System.out.print(rank + "��: " + i.substring(indexS, indexF));
				}
				if (statusB == 4 && i.contains("AuthorSearch")) {
					statusB = 1;
					indexS = i.indexOf("1\">") + 3;
					indexF = i.indexOf("</a>");
					System.out.println(" (" + i.substring(indexS, indexF) + ")");
					rank++;
				}
			}
			// ��¥ ���� ��ũ����
			if (statusD >= 0) {
				if (i.contains("form action=\"/shop/common/wbest.aspx"))
					statusD = 1;
				if (statusD == 1 && i.contains("div class=\"newbs_year\"")) {
					statusD = 2;
					indexS = i.indexOf("Year')\">") + 8;
					indexF = i.indexOf("<img src");
					System.out.print("[" + i.substring(indexS, indexF));
				}
				if (statusD == 2 && i.contains("div class=\"newbs_month\"")) {
					statusD = 3;
					indexS = i.indexOf("Month')\">") + 9;
					indexF = i.indexOf("<img src");
					System.out.print(" " + i.substring(indexS, indexF));
				}
				if (statusD == 3 && i.contains("div class=\"newbs_week\"")) {
					indexS = i.indexOf("Week')\">") + 8;
					indexF = i.indexOf("<img src");
					System.out.println(" " + i.substring(indexS, indexF) + "]");
				}
			}
		}
	}
}
