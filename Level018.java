/**
 * CSE3040 HW3
 * Level018.java
 * Purpose: 과일과 그 가격 정보에 대해 가격의 오름차순으로 정렬된 형태로 출력한다.
 * 
 * @version 1.0 11/26/2019
 * @author Daeyoung Eo
 */
package cse3040;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * generic type Element 정의
 * 
 */
class Element implements Comparable<Element> {
	public String name, price;

	// 객체를 생성할 때 string을 받아서 이름과 가격 정보로 나눈 뒤 각각 다른 변수에 저장
	public Element(String s) {
		String[] info = s.split(" ");
		name = info[0];
		price = info[1];
	}

	// Element type끼리의 비교를 가능하게 해줌
	// 비교 기준은 price
	public int compareTo(Element anotherEle) {
		float thisVal = Float.parseFloat(price);
		float anotherVal = Float.parseFloat(anotherEle.price);
		return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
	}

	// 이름과 가격을 형식에 맞게 고친 뒤 string type으로 돌려줌
	public String toString() {
		return name + " " + price;
	}
}

public class Level018 {
	/**
	 * filename에 해당하는 파일을 열고 내용을 읽어서 ArrayList type list에 저장
	 * 
	 * @param filename:파일이름, list: ArrayList type으로 정보를 저장할 자료구조
	 */
	public static int readDataFromFile(String filename, ArrayList<Element> list) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					br.close();
					break;
				}
				Element e = new Element(line);
				list.add(e);
			}
		} catch (IOException ex) {
			return 1;
		}
		return 0;
	}

	/**
	 * The main method for the program.
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args) throws Exception {
		ArrayList<Element> list = new ArrayList<>();
		int rv = readDataFromFile("./input.txt", list);
		if (rv == 1) {
			System.out.println("input file not found!");
			return;
		}
		Collections.sort(list);
		Iterator<Element> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
