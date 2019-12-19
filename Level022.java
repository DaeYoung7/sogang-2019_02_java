/**
 * CSE3040 HW3
 * Level022.java
 * Purpose: �˶�� ���� 50�� å ���� ��ũ����
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

		// ��¥���� ��ũ����
		String year = doc.select("div.newbs_year").select("div[onmouseover]").text();
		String month = doc.select("div.newbs_month").text();
		String week = doc.select("div.newbs_week").text();
		System.out.println("[" + year + " " + month + " " + week + "]");

		// å���� ��ũ����
		Elements bestSellers = doc.select("div.ss_book_box");
		Elements bookLists = bestSellers.select("div.ss_book_list");
		// checkIndex1: ¦�� �������� �ʿ��� ������ �ִ�.
		// checkIndex2: ���� ������ �����̰� ���´�. ������ index+1�ϴ� �뵵�� ���.
		// rank:����
		int checkIndex1 = 0, checkIndex2 = 0, rank = 1;
		for (Element i : bookLists) {
			if (checkIndex1 % 2 == 0) {
				Elements liLists = i.select("li");
				checkIndex2 = 0;
				for (Element j : liLists) {
					// class "bo3"�� ���� ������ ��� �ִ�.
					// ���� ������ li�� ������ ������ ��� �ִ�.
					// �ٸ� text�� ���� ��µ� �� �־ ó�� ������ text�� index�� �̿��ؼ� ����ߴ�.
					if (j.toString().contains("bo3")) {
						System.out.print(rank + "��: " + j.select(".bo3").text());
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
