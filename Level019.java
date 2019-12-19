/**
 * CSE3040 HW3
 * Level019.java
 * Purpose: ���Ͽ��� ������ �̸��� ���� ������ ���� �� �̸��� ������������ ������ ������ ����� 
 * 
 * @version 1.0 11/26/2019
 * @author Daeyoung Eo
 */
package cse3040;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * ��������� �ٸ��� �ϱ� ���� ���ο� data type�� �����Ѵ�. �� �� �� ��Ҹ� ���ĵ� ���·� �����ϱ� ���ؼ� TreeMap��
 * ����Ѵ�.
 *
 * @param <K>
 * @param <V>
 */

class NewMap<K, V> extends TreeMap<K, V> {
	/**
	 * warning ���ſ�
	 */
	private static final long serialVersionUID = 1L;

	public NewMap() {
		super();
	}

	/**
	 * map�� ����� ������ iterator�� �̿��ؼ� �޾ƿ´� �޾ƿ� ������ �̸��� �������� ������ ������ string�� �����ش�. ������
	 * string�� ret���� �ϳ��� ������� ��� ������ string���� �����ϰ� �ִ� �����̴�.
	 */
	public String toString() {
		Iterator<Map.Entry<K, V>> it = this.entrySet().iterator();
		String ret = "";
		while (it.hasNext()) {
			Map.Entry<K, V> e = it.next();
			ret += e.getKey() + " " + e.getValue() + "\n";
		}
		ret = ret.substring(0, ret.length() - 1);
		return ret;
	}
}

public class Level019 {
	/**
	 * ������ ��� ������ �о�� �� map�� �����ϴ� �Լ��̴�.
	 * 
	 * @param filename
	 * @param map
	 * @return
	 */
	public static int readDataFromFile(String filename, Map<String, Double> map) {
		String[] info = new String[2];
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					br.close();
					break;
				}
				info = line.split(" ");
				map.put(info[0], Double.parseDouble(info[1]));
			}
		} catch (IOException e) {
			return 1;
		}
		return 0;
	}

	/**
	 * ���θ��� data type�� �̿��ؼ� map��ü�� �����Ѵ�.
	 * 
	 * @return
	 */
	public static Map<String, Double> InitializeMap() {
		NewMap<String, Double> map = new NewMap<>();
		return map;
	}

	public static void main(String[] args) throws Exception {
		Map<String, Double> map = InitializeMap();
		int rv = readDataFromFile("./input.txt", map);
		if (rv == 1) {
			System.out.println("input file not found!");
			return;
		}
		System.out.println(map);
	}
}
