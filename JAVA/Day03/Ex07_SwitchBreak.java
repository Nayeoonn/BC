package Day03;

import java.util.Scanner;

public class Ex07_SwitchBreak {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력: ");
		
		// 입력 받은 정수를 5로 나눈 나머지가 2보다 작으면 * 출력
		// 그렇지 않으면 ** 출력
		
		int a = sc.nextInt();
		
		switch (a % 5) {
		case 0 :
			System.out.println("*"); // 밑에 출력되는게 같아서 이 문장이 없어도 됨
			break;
		case 1 :
			System.out.println("*");
			break;
		case 2 :
			System.out.println("**"); // 마찬가지
			break;
		case 3 :
			System.out.println("**"); // 마찬가지
			break;
		case 4 :
			System.out.println("**");
			break;



		default:
			System.out.println("**");
			break;
		}
		
		sc.close();
	}
}
