package Day02;

public class Ex02_Char {

	public static void main(String[] args) {
		// 문자 데이터 : char
		// 리터럴(Literal)
		// : 소스코드에 표기하는 데이터 (숫자인지, 문자인지, 문자열인지 의미 부여)
		
		char c1 = 'A';			// 문자 리터럴 : 'A' (작은 따옴표)
		char c2 = 65;			// 십진수 --> 아스키코드표에 매핑된 문자
		char c3 = '\u0041'; 	// 유니코드로 지정
		
		char c4 = '가';
		char c5 = 44032;
		char c6 = '\uac00';
		
		int unicode = c1;
		
		// char b = (c2 + 1);   ---> error
		// c2 -> char , 1 -> int 
		// char + int -> int가 자료형이 더 크기 때문에 int
		// 좌변 char 우변 int  좌변<우변 --> error
		// 형 변환 필요 (형 변환, 캐스팅, 강제 형변환, 명시적 형변환)
		
		char b = (char) (c2 + 1);
		// (c2 + 1)				:(char) + (int) = (int)	자동 형변환
		// b = (c2 + 1)			:char = (char) int 강제 형 변환
		// 작은 자료형과 큰 자료형을 연산하면, 그 결과는 큰 자료형이 된다.
		
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		System.out.println("c3 : " + c3);
		System.out.println("c4 : " + c4);
		System.out.println("c5 : " + c5);
		System.out.println("c6 : " + c6);
		System.out.println("A의 코드값 : " + unicode);
		System.out.println("b : " + b);
	}

}
