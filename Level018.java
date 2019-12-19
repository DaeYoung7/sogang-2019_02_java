/**
 * CSE3040 HW3
 * Level018.java
 * Purpose: ���ϰ� �� ���� ������ ���� ������ ������������ ���ĵ� ���·� ����Ѵ�.
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
 * generic type Element ����
 * 
 */
class Element implements Comparable<Element> {
	public String name, price;

	// ��ü�� ������ �� string�� �޾Ƽ� �̸��� ���� ������ ���� �� ���� �ٸ� ������ ����
	public Element(String s) {
		String[] info = s.split(" ");
		name = info[0];
		price = info[1];
	}

	// Element type������ �񱳸� �����ϰ� ����
	// �� ������ price
	public int compareTo(Element anotherEle) {
		float thisVal = Float.parseFloat(price);
		float anotherVal = Float.parseFloat(anotherEle.price);
		return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
	}

	// �̸��� ������ ���Ŀ� �°� ��ģ �� string type���� ������
	public String toString() {
		return name + " " + price;
	}
}

public class Level018 {
	/**
	 * filename�� �ش��ϴ� ������ ���� ������ �о ArrayList type list�� ����
	 * 
	 * @param filename:�����̸�, list: ArrayList type���� ������ ������ �ڷᱸ��
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
