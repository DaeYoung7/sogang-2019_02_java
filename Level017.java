/**
 * CSE3040 HW3
 * Level017.java
 * Purpose: 과일과 그 가격 정보에 대해 가장 비싼 것과 가장 싼 것, 전체 품목 개수와 평균을 알려준다.
 * 
 * @version 1.0 11/26/2019
 * @author Daeyoung Eo
 */
package cse3040;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Level017 {
	public static void main(String[] args) {
		// n: 품목의 개수
		int n = 0;
		// sum: 전체 과일 가격의 합, temp: string 형식인 가격을 int로 변환한 뒤 저장
		// max: 최고가, min: 최저가, maxStr: 최고가 과일의 이름, minStr: 최저가 과일의 이름
		float sum = 0, temp = 0, max = -1, min = Float.MAX_VALUE;
		String maxStr = null, minStr = null;
		// 과일의 정보 저장할 배열 한 번에 한 과일만 다룬다.
		String[] info = new String[2];
		try {
			BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					br.close();
					break;
				}
				info = line.split(" ");
				temp = Float.parseFloat(info[1]);
				if (temp < min) {
					min = temp;
					minStr = info[0];
				}
				if (temp > max) {
					max = temp;
					maxStr = info[0];
				}
				n++;
				sum += temp;
			}
		} catch (IOException e) {
			System.out.print("Input file not found!");
			return;
		}
		System.out.println("Summary\n-------");
		System.out.println("number of items: " + n);
		System.out.println("most expensive item: " + maxStr + " (" + max + ")");
		System.out.println("cheapest item: " + minStr + " (" + min + ")");
		System.out.print("average price of items: " + Math.round(sum * 100 / n) / 100.0);
	}
}
