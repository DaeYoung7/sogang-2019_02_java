/**
 * CSE3040 HW3
 * Level019.java
 * Purpose: 파일에서 과일의 이름과 가격 정보를 얻어온 뒤 이름의 오름차순으로 정렬한 내용을 출력함 
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
 * 출력형식을 다르게 하기 위해 새로운 data type을 정의한다. 이 때 각 요소를 정렬된 형태로 저장하기 위해서 TreeMap을
 * 상속한다.
 *
 * @param <K>
 * @param <V>
 */

class NewMap<K, V> extends TreeMap<K, V> {
	/**
	 * warning 제거용
	 */
	private static final long serialVersionUID = 1L;

	public NewMap() {
		super();
	}

	/**
	 * map에 저장된 정보를 iterator를 이용해서 받아온다 받아온 정보를 이름과 가격으로 나눠서 기존의 string에 더해준다. 기존의
	 * string은 ret으로 하나씩 얻어지는 요소 정보를 string으로 저장하고 있는 변수이다.
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
