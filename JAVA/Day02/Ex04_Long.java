package Day02;

public class Ex04_Long {

	public static void main(String[] args) {

		// int (4bytes : 32bits) -> 2^32개 (약 42억 개)
		// int 수 표현 범위 : -21억 xxx ~ 21억 xxx
		
		// long (8bytes : 64bits) -> 2^64개
		long ln1 = 1000;
		long ln2 = 2100000000;
		// long 타입 리터럴 : 숫자L
		// L을 봍이지 않으면 기본 정소는 int 타입으로 취급
		
		// long ln3 = 2200000000; -> 우변은 int형인데 범위를 벗어남
		long ln3 = 2200000000L;
		
		System.out.println("ln1 : " + ln1);
		System.out.println("ln2 : " + ln2);
		System.out.println("ln3 : " + ln3);
	}

}
