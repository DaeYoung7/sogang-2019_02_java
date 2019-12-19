/**
 * CSE3040 HW3
 * Level022.java
 * Purpose: 알라딘 상위 50위 책 정보 스크래핑
 * 
 * @version 1.0 11/26/2019
 * @author Daeyoung Eo
 */
package web;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class Level022 {

	public static void main(String[] args) {
		String url = "https://aladin.co.kr/shop/common/wbest.aspx?BestType=Bestseller&BranchType=1&CID=0";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// 날짜정보 스크래핑
		String year = doc.select("div.newbs_year").select("div[onmouseover]").text();
		String month = doc.select("div.newbs_month").text();
		String week = doc.select("div.newbs_week").text();
		System.out.println("[" + year + " " + month + " " + week + "]");

		// 책정보 스크래핑
		Elements bestSellers = doc.select("div.ss_book_box");
		Elements bookLists = bestSellers.select("div.ss_book_list");
		// checkIndex1: 짝수 단위에만 필요한 정보가 있다.
		// checkIndex2: 제목 다음은 지은이가 나온다. 제목의 index+1하는 용도로 사용.
		// rank:순위
		int checkIndex1 = 0, checkIndex2 = 0, rank = 1;
		for (Element i : bookLists) {
			if (checkIndex1 % 2 == 0) {
				Elements liLists = i.select("li");
				checkIndex2 = 0;
				for (Element j : liLists) {
					// class "bo3"은 제목 정보를 담고 있다.
					// 제목 다음의 li는 지은이 정보를 담고 있다.
					// 다른 text가 같이 출력될 수 있어서 처음 나오는 text의 index를 이용해서 출력했다.
					if (j.toString().contains("bo3")) {
						System.out.print(rank + "위: " + j.select(".bo3").text());
						String str = liLists.get(checkIndex2 + 1).toString();
						int index1 = str.indexOf("Type=1");
						int index2 = str.indexOf("</a>");
						System.out.println(" (" + str.substring(index1 + 8, index2) + ")");
					}
					checkIndex2++;
				}
				rank++;
			}
			checkIndex1++;
		}
	}
}
