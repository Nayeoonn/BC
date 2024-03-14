package Day02;

public class Ex01_Variable {

	public static void main(String[] args) {
		// 변수 선언
		// - 자료형 변수명;
		
		// 변수 선언 및 초기화
		// - 자료형 변수명 = 값;
		
		// 변수 선언
		int x;				// int형 변수 x 선언
		int y;				// int형 변수 y 선언
		
		// 여러 변수 동시에 선언
		int a, b;			
		
		// 변수 선언 및 초기화
		int i = 10;
		int j = 20;
		
		// 동시 선언 및 초기화
		int m = 30, n = 40;
		
		// = (대입 연산자)
		x = 100;
		y = 200;
		
		// x + y
		// x, y : 피연산자
		// + : 연산자
		// sysout : ctrl + space
		
		System.out.println("x : " + x);
		System.out.println("y : " + y);
		// 합계
		System.out.println("x + y = " + (x + y));
		// 문자열 데이터, 정수형 데이터이기 때문에 100200 라고 출력됨
		// 정수형이 문자열 데이터가 되기 때문 (연결 연산자)
		// 연산자에 우선순위를 주어야함 () 괄호 사용
		
		// 평균 = 합계 / 개수
		System.out.println("x + y / 2 = " + ((x + y) / 2));
		
		// * 우선순위에 따라서 알맞게 () 지정해서 사용
		// 사칙 연산 우선순위
		// *, / : 연산 우선순위 먼저
		// +, - : 연산 우선순위 나중
		
		
	}

}
