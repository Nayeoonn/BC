package Day03;

import java.util.Scanner;

public class Ex13_Gugu {

	public static void main(String[] args) {
		// 구구단 (1~9단)
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int a = sc.nextInt();
		
		
		for (int i = 1; i <= 9 ; i ++) {
			int b = a * i;
			System.out.println(a + "*" + i + "=" + b);
			
		}
		sc.close();
	}
}
