package Day03;

import java.util.Scanner;

public class Ex03_ElseIf {

	public static void main(String[] args) {

		// 학생의 성적을 입력받고, 성적에 따라 학점 출력
		//90점 이상 A
		//80점 이상 B
		//70점 이상 C
		//60점 이상 D
		//60점 미만 F
		
		Scanner sc = new Scanner(System.in);
		System.out.print("성적 : ");
		int score = sc.nextInt();
		
		// 조건을 만족할 때 실행할 실행문이 1문장이면 {} 생략가능
		if(score >= 90 && score <= 100) {
			System.out.println("학점 : A");
		}
		if(score >= 80 && score < 90) {
			System.out.println("학점 : B");
		}
		if(score >= 70 && score < 80) {
			System.out.println("학점 : C");
		}
		if(score >= 60 && score < 70) {
			System.out.println("학점 : D");
		}
		if(score < 60 && score >= 0) {
			System.out.println("학점 : F");
		}
		
		
		// 5개 학점 출력문을 1개로 줄이기
		char grade = 'F'; // 초기화를 안 하면 에러가 남
						  // 값을 없는 걸 가져올 수 없기 때문에
						  // ---> 단독 if문이기 때문에
		if(score >= 90 && score <= 100)		grade = 'A';
		if(score >= 80 && score < 90) 		grade = 'B';
		if(score >= 70 && score < 80) 		grade = 'C';
		if(score >= 60 && score < 70) 		grade = 'D';
		if(score < 60 && score >= 0)		grade = 'F';

		System.out.println("학점 : " + grade);
	
		// if ~ else
		if(score >= 90 && score <= 100)
			grade = 'A';
		else if(score >= 80) 
			grade = 'B';
		else if(score >= 70) 
			grade = 'C';
		else if(score >= 60) 	
			grade = 'D';
		else
			grade = 'F';
		System.out.println("학점 : " + grade);
		sc.close();
		
	}

}
