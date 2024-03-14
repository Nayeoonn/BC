package Day07.Review;

public class Ex02_ThreeSixNine {
	// 정수 1~100 까지의 수를 반복하여 출력하면서
	// 해당 수가 3 또는 6 또는 9가 될 떄
	// 369의 개수 만큼 정수 대신"*"을 출력하는 프로그램을 작성하시오.
	// ex) 3 	--> 	"*"
	//     33 	-->		"**"
	//	   99 	-->		"**"
	//	   45	-->		45
	
	// 1. 정수를 1~100까지 출력
	// 2. 해당 수가 369가 몇 개인지 판단
	//  2-1. 십의자리수가 369인지 여부 (A) 판단
	//  2-2. 일의자리수가 369인지 여부 (B) 판단
	//  2-3. A and B --> **
	//		 A or B --> *
	// 3. 그 개수만큼 "*" 출력
	
	public static void main(String[] args) {
		
		for(int i = 1; i <= 100; i++) {
			// 십의자리 수 : 해당수(i) / 10 (정수부분만)
			int ten = i / 10;
			// 일의자리 수 : 해당수(i) % 10
			int one = i % 10;
			
			boolean ten369 = ten == 3 || ten == 6 || ten == 9;
			// boolean ten369 = (ten != 0) && (ten % 3 == 0);
			boolean one369 = one == 3 || one == 6 || one == 9;
			// boolean one369 = (one != 0) && (one % 3 == 0);
			
//			if( ten == 3 || ten == 6 || ten == 9) {
//				ten369 = true;
//			}
//			if( one == 3 || one == 6 || one == 9) {
//				one369 = true;
//			}
			
			if(ten369 && one369) {
				System.out.println("**");
			}
			else if(ten369 || one369) {
				System.out.println("*");
			}
			else {
				System.out.println(i);
			}
		}
	}
	
}
