package cse3040;

/**
 * CSE3040 HW3
 * Level021.java
 * Purpose: 알라딘에서 베스트셀러 50개 정보 스크래핑하기
 * 
 * @version 1.0 11/26/2019
 * @author Daeyoung Eo
 */
import java.util.*;
import java.net.*;
import java.io.*;

public class Level021 {
	// 사이트 html에 대한 정보 저장할 자료구조
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
		// html을 한 줄씩 읽으면서 정보가 있다면 리스트에 저장
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
		// statusD: 날짜 정보 얻어올 때 사용, statusB: 책 정보 얻어올 때 사용
		int statusD = 0, statusB = 0;
		// line에서 substring구할 때 사용하는 index
		int indexS, indexF;
		for (String i : lines) {
			// 제목, 작가 정보 스크래핑
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
					System.out.print(rank + "위: " + i.substring(indexS, indexF));
				}
				if (statusB == 4 && i.contains("AuthorSearch")) {
					statusB = 1;
					indexS = i.indexOf("1\">") + 3;
					indexF = i.indexOf("</a>");
					System.out.println(" (" + i.substring(indexS, indexF) + ")");
					rank++;
				}
			}
			// 날짜 정보 스크래핑
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
