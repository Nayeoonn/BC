package Day02;

import java.util.Scanner;

public class Ex09_InputOperator {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 바로 엔터 shift + enter
		
		System.out.print("x : ");
		int x = sc.nextInt();
		
		System.out.print("y : ");
		int y = sc.nextInt();
		
		System.out.print("z : ");
		int z = sc.nextInt();
		
		// 합계, 평균
		int sum = x + y + z;
		double avg = sum / 3; 
		// (double) = (int) / (int); 
		// int는 정수 자료형으로 실수의 소수부분을 표현할 수 없다.
		// int 혹은 3 둘 중 하나라도 double 타입이 되면 됨
		// ---> 큰 자료형과 작은 자료형을 연산하면 큰 자료형으로 반환
		
		// 강제 형변환 : (자료형) 변수
		double realAvg1 = (double) sum / 3;
		double realAvg2 = sum / 3.0;
		
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("실수자리 까지의 평균1 : " + realAvg1);
		System.out.println("실수자리 까지의 평균2 : " + realAvg2);
		// avg 평균 변수가 정수형(int)라서 소수 표현 x
		// 평균을 소수점까지 표현하기 위해서는 실수형(double)로 변환 필요
		
		
		sc.close();
	}


}
