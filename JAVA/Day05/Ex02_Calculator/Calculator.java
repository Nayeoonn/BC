package Day05.Ex02_Calculator;

/*
 * 계산기
 * - 피연산자를 2개로 하는 계산기
 * - 기능
 * 		1. 덧셈 : 정수 2개 덧셈
 * 		2. 뺄셈 : 정수 인자1 - 인자2 연산을 하는 뺄셈
 * 		3. 곱셈 : 실수 2개 곱셈
 * 		4. 나눗셈 : 실수 인자1 / 인자2 연산을 하는 나눗셈
 * 		5. 나머지 : 실수 인자1 % 인자2 연산을 하는 나눗셈
 * 		6. 합계 : 배열을 매개변수로 전달받아, 모든 요소의 합을 구함
 * 		6. 평균 : 배열을 매개변수로 전달받아, 모든 요소의 평균을 구함
 * 
 * 		* 메소드명
 * 		: plus, minus, multiple, divide, remain, sum, avg
 * */
public class Calculator {
	
	// 덧셈
	public int plus(int a, int b) {
//		int plus = 0;
//		
//		plus = a + b;
//		return plus;
		
		int result = a + b;
		return result;
	}
	
	// 뺄셈
	public int minus(int a, int b) {
//		int minus = 0;
//		
//		minus = a - b;
//		return minus;
		
		int result = a - b;
		return result;
		
		
	}
	
	// 곱셈
	public double multiple(double a, double b) {
//		int multiple = 0;
//		
//		multiple = a * b;
//		return multiple;
		
		double result = a * b;
		return result;
	}
	
	// 나눗셈
	public double divide(double a, double b) {
//		int divide = 0;
//		
//		divide = a / b;
//		return divide;
		
		double result = a / b;
		return result;
	}
	
	// 나머지
	public double remain(double a, double b) {
//		int remain = 0;
//		
//		remain = a % b;
//		return remain;
		
		double result = a % b;
		return result;
	}
	
	// 합계
	public double sum(int[] arr) {
		
		int sum = 0;
//		for(int i:scores)
//			sum += i;
		
		for (int i = 0; i < arr.length; i ++) {
			// sum += arr[i];
			sum += arr[i];
		}
			
		return sum;
	}
	
	// 평균
	public double avg(int[] arr) {
		
		double sum = sum (arr);
		double avg = 0.0;
		avg = (double) sum / arr.length;
		return avg;
		
//		double avg = 0.0;
//		int sum = 0;
//		
////		for(int i : arr)		// foreach
////			sum += i;			// sum = sum + i
////		
////		// 평균을 구해보세요
//		avg = (double) sum / arr.length;
//		return avg;
		
		// 위 보다 메소드 호출하는 것이 더 나음
		// 메소드 호출 : 메소드명 (전달인자1, 전달인자2)
		
		
		
	}
	
	

}
