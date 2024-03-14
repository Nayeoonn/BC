package Day04;

import java.util.Scanner;

public class Ex03_Min {

	public static void main(String[] args) {
		// 첫째 줄에 입력할 개수 N 입력받고,
		// 둘째 줄에 N 개의 정수를 공백을 두고 입력받으시오.
		// N 개의 정수 중, 최솟값을 출력하시오.
		// (입력예시)
		// 5
		// 90 60 70 10 55
		// (출력 예시)
		// 최솟값 : 55
		/*
		 * (순서도) 
		 * 1. 정수 하나를 입력받는다. 
		 * 2. 입력받은 정수를 변수 N에 대입한다. 
		 * 3. N번 반복하여 N개의 정수를 입력받는다. 
		 * 4.입력받은 N개의 정수를 배열 arr에 저장한다. 
		 * 5. 배열 arr을 반복하여, 최댓값 변수 max와 i번째 배열 요소를 비교한다. 
		 * 6. 두 요소 중 더 큰 요소를 max에 대입한다. 
		 * 7. 반복이 끝나고, 변수 max를 출력한다.
		 */

		// 1. 정수 하나를 입력받는다.
		// 2. 입력받은 정수를 변수 N에 대입한다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N이 입력 받을 정수 개수
		int arr[] = new int[N];
		// 최솟값 선언
		int min = Integer.MAX_VALUE; // int 타입의 최솟값 : -21억 xxx
										// 최솟값 구할 댄 Interger.MAX_VALUE
		// 3. N번 반복하여 N개의 정수를 입력받는다.
		// 4. 입력받은 N개의 정수를 배열 arr에 저장한다.
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			
			// 입력과 최솟값 비교를 동시에 할 수도 있다.
			// if ( min > arr[i]{
			//		min = arr[i];
			// }                  --> 반복문 두번 안 돌리고 한 번에

		}

		for (int i = 0; i < arr.length; i++) { // arr.length 대신 N 써도 됨
			// 5. 배열 arr을 반복하여, 최솟값 변수 min와와 i번째 배열 요소를 비교한다.
			if (min > arr[i]) {
				// 6. 두 요소 중 더 큰 요소를 min에 대입한다.
				min = arr[i];
			}
		}
		// 7. 반복이 끝나고, 변수 min를 출력한다.
		System.out.println("최솟값 : " + min);
		sc.close();

	}
}
