/**
 * CSE3040 HW3
 * Level020.java
 * Purpose: ���ϰ� �� ���� ������ ���� ������ ������������ ���ĵ� ���·� ����Ѵ�.
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
 * �񱳱����� ����� class�̴�. map ��ҿ� ���� value ���� �������� �����Ѵ�. ���� ��� Key�� ���� �񱳸� ���� �ʴµ� ��
 * ������ TreeMap�� ����ؼ� �̹� Key�� ���� ������ �� �����̱� �����̴�.
 */
@SuppressWarnings("unchecked")
class ValueComparator<T> implements Comparator<T> {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
			Map.Entry<String, Double> e1 = (Map.Entry<String, Double>) o1;
			Map.Entry<String, Double> e2 = (Map.Entry<String, Double>) o2;
			double d1 = e1.getValue();
			double d2 = e2.getValue();
			if (d1 > d2)
				return 1;
			else if (d1 < d2)
				return -1;
			else
				return 0;
		}
		return -1;
	}
}

/**
 * ��������� �ٸ��� �ϱ� ���� ���ο� data type�� �����Ѵ�. �� �� �� ��Ҹ� ���ĵ� ���·� �����ϱ� ���ؼ� TreeMap��
 * ����Ѵ�.
 *
 * @param <K>
 * @param <V>
 */
class NewMap2<K, V> extends TreeMap<K, V> {
	/**
	 * warning ���ſ�
	 */
	private static final long serialVersionUID = 1L;

	public NewMap2() {
		super();
	}

	/**
	 * value�� ���� sorting�� �ؾ��ϹǷ� map�� ArrayList���·� �ٲ��ش�. ���� ������ �� ���ؿ� ���� list��
	 * sorting�ϰ� iterator ��ü�� ���� �� ��� ���Ŀ� �°� ret�� �����Ѵ�.
	 */
	public String toString() {

		List<Map.Entry<K, V>> list = new ArrayList<>(this.entrySet());
		Collections.sort(list, new ValueComparator<Map.Entry<K, V>>());
		Iterator<Map.Entry<K, V>> it = list.iterator();
		String ret = "";
		while (it.hasNext()) {
			Map.Entry<K, V> e = it.next();
			ret += e.getKey() + " " + e.getValue() + "\n";
		}
		ret = ret.substring(0, ret.length() - 1);
		return ret;
	}
}

public class Level020 {
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
		NewMap2<String, Double> map = new NewMap2<>();
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
