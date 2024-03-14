package Day03;

public class Ex09_WhileSum {

	public static void main(String[] args) {
		// 1~100 합계 구하기
		// 1+2+3+4+...+100 = 5050
		
		int a = 1;
		int sum = 0;
		
		while(a <= 100) {
			
			// 방법 1
			sum = sum + a;
			a = a + 1;
			
			// 방법 2
			// sum = sum + a++;
			
			// 방법 3
			// sum += a++;
			
			
		}
		System.out.print("합계 : " + sum);
		
	}
}
