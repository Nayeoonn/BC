package Day03;

import java.util.Scanner;

public class Ex11_DoWhile {

	public static void main(String[] args) {
		// 메뉴판
		// 변수 선언 : 메뉴 번호, 메뉴 이름
		
		int menuNo = 0;
		int count = 0;
		String menuName ="";
		Scanner sc = new Scanner(System.in);
		
		// do~while문
		// : 무조건 1회는 실행 후 조건을 검사하여 반복하는 문장
		
		do {
			System.out.println("############ 메뉴판 ############");
			System.out.println("1. 맥도날드");
			System.out.println("2. 법대생김밥");
			System.out.println("3. 돈까스");
			System.out.println("4. 짜장면");
			System.out.println("5. 물만난면");
			System.out.println("0. 종료");
			System.out.print("메뉴 번호: ");
			
			
			// 메뉴 번호 입력
			menuNo = sc.nextInt();
			
			// break : 제어문을 탈출
			if(menuNo == 0) 
				break;
			
			// break는 반복문 탈출해서 제어문 멈춤
			// return 현재 실행중인 메소드를 종료
			//		  메모리 공간 해제, (값)을 메소드를 호출한 자리로 반환
			// if( menuNo == 0) return; -> 메뉴판 종료도 안나옴
			
			switch (menuNo) {
			case 1: menuName = "맥도날드"; 	break;
			case 2: menuName = "법대생김밥"; 	break;
			case 3: menuName = "돈까스"; 		break;
			case 4: menuName = "짜장면";		break;
			case 5: menuName = "물만난면"; 	break;

			default:
				break;
			}
			// 메뉴번호 유효성 검사
			if (menuNo <= 5 && menuNo != 0) {
				System.out.println(menuName + "(을/를) 주문하였습니다.");
				count++;
			}
			else {
				System.out.println("(0~5)번 사이의 번호를 입력해주세요.");
			}
			
		} while (menuNo != 0);

		// 주문한 메뉴 개수를 출력해주세요.
		
		System.out.println(count + " 개의 메뉴를 주문하였습니다.");
		System.out.println("메뉴판을 종료합니다.");
		sc.close();
		//return;
	}
}
