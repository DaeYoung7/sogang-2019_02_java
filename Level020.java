/**
 * CSE3040 HW3
 * Level020.java
 * Purpose: 과일과 그 가격 정보에 대해 가격의 오름차순으로 정렬된 형태로 출력한다.
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
 * 비교기준을 만드는 class이다. map 요소에 대해 value 값을 기준으로 정렬한다. 같을 경우 Key에 대한 비교를 하지 않는데 그
 * 이유는 TreeMap을 사용해서 이미 Key에 대한 정렬이 된 상태이기 때문이다.
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
 * 출력형식을 다르게 하기 위해 새로운 data type을 정의한다. 이 때 각 요소를 정렬된 형태로 저장하기 위해서 TreeMap을
 * 상속한다.
 *
 * @param <K>
 * @param <V>
 */
class NewMap2<K, V> extends TreeMap<K, V> {
	/**
	 * warning 제거용
	 */
	private static final long serialVersionUID = 1L;

	public NewMap2() {
		super();
	}

	/**
	 * value에 대해 sorting을 해야하므로 map을 ArrayList형태로 바꿔준다. 새로 정의한 비교 기준에 따라 list를
	 * sorting하고 iterator 객체를 만든 뒤 출력 형식에 맞게 ret에 저장한다.
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
	 * 파일을 열어서 내용을 읽어온 뒤 map에 저장하는 함수이다.
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
	 * 새로만든 data type을 이용해서 map객체를 생성한다.
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
