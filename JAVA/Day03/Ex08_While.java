package Day03;

public class Ex08_While {
	// 1~10 까지 공백을 두고 출력하시오.
	public static void main(String[] args) {
		int a = 1;
		
		// while(조건){반목 실행문}
		// - 반목문에는 반드시 종료조건이 성립하도록 작성해야함
		// 그렇지 않으면 무한루프
		while(a <= 10) {
			System.out.print(a + " ");
			a = a + 1;
		}
		
		while(a <= 10) {
			System.out.print(a++ + " ");
		}
	}


}
