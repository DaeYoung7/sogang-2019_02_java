/**
 * CSE3040 HW3
 * Level017.java
 * Purpose: ���ϰ� �� ���� ������ ���� ���� ��� �Ͱ� ���� �� ��, ��ü ǰ�� ������ ����� �˷��ش�.
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
		// n: ǰ���� ����
		int n = 0;
		// sum: ��ü ���� ������ ��, temp: string ������ ������ int�� ��ȯ�� �� ����
		// max: �ְ�, min: ������, maxStr: �ְ� ������ �̸�, minStr: ������ ������ �̸�
		float sum = 0, temp = 0, max = -1, min = Float.MAX_VALUE;
		String maxStr = null, minStr = null;
		// ������ ���� ������ �迭 �� ���� �� ���ϸ� �ٷ��.
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
