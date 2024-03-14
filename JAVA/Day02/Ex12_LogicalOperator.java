package Day02;

public class Ex12_LogicalOperator {

	public static void main(String[] args) {

		// 논리 연산자
		// AND (&&)
		// A AND B		: A 와 B 둘다 true 일 때, 결과가 true
		// A     B	   결과
		// -----------------
		// F	 F	 	F
		// T	 F	 	F
		// F	 T		F
		// T	 T	    T
		System.out.println(true && true);		// T
		System.out.println(true && false);		// F
		System.out.println(false && true);		// F
		System.out.println(false && false);		// T
		System.out.println();
		
		// OR (||)
		// A OR B		: A 와 B 둘 중 하나라도 true면, 결과가 true
		// A     B	   결과
		// -----------------
		// F	 F	 	F
		// T	 F	 	T
		// F	 T		T
		// T	 T	    T
		System.out.println(true || true);		// T
		System.out.println(true || false);		// T
		System.out.println(false || true);		// T
		System.out.println(false || false);		// G
		System.out.println();
		
		// NOT (!)
		// !A			 : A가 true면, 결과가 flase / flase면 true
		System.out.println(!true);		
		System.out.println(!false);		
		System.out.println();
		
		// 쇼트 서킷
		// : 논리 연산의 결과를 미리 알아서, 남은 논리식을 확인하지 않는 것
		int value1 = 3;
		System.out.println(false && ++value1 > 10);  // flase -> 이미 죽은 코드
		System.out.println("value1 : " + value1);    // 3 그래서 증감 시키지 않음
		
		int value2 = 3;
		System.out.println(true || ++value2 > 10);	 // true -> 마찬가지
		System.out.println("value2 : " + value2);	 // 3
		
		
		// 비트 연산자의 경우 쇼트 서킷이 적용되지 않는다.
		int value3 = 3;
		System.out.println(false & ++value3 > 10);   // flase 
		System.out.println("value3 : " + value3);    // 4
		
		int value4 = 3;
		System.out.println(true | ++value4 > 10);	 // true
		System.out.println("value4 : " + value4);	 // 4
		
		
	}

}
