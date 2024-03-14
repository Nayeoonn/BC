package Day07.Review;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Comparator;


public class Ex04_Lotto {
	
	public static void main(String[] args) {
		// Math.random() : 0.xxxx~0.9XXX 사의 난수를 반환하는 메소드
		double random = Math.random();
		System.out.println(random);
		
		// 1~6 사이의 정수 : 주사위
		// Math.random() * 10 			:0.xxxx~9.XXXX
		// (int) (Math.random() * 10) 	:0 ~ 9 10개
		// (int) (Math.random() * 6) 	:0 ~ 5 6개
		// (int) (Math.random() * 6)+1 	:1 ~ 6 6개
		int dice = ((int) (Math.random() * 6) + 1);
		System.out.println("주사위 : " + dice);
		
		// 1~45 사이의 정수 : 로또
		int lotto = (int) (Math.random() * 45);
		System.out.println("로또 랜덤 번호: " + lotto);
		
		// 공식 : (int) (Math.random() * [개수]) + [시작숫자]
		
		// 1~20 사이의 랜덤수
		int rand = (int) (Math.random() * 20) + 1;
		System.out.println("1~20 : " + rand );
		
		// -20~20 사이의 랜덤수
		int rand2 = (int) (Math.random() * 40) -20;
		System.out.println("-20~20 : " + rand2 );
		
		// 1~45 사이의 랜덤수 6개를 배열에 중복없이 오름차순으로 저장하시오.
		// (과제) : 중복제거, 오름차순 정렬
		int arr[] = new int [6];
		
		
		for (int i = 0; i < arr.length; i++) {
			int r = (int) (Math.random() * 45) + 1;
			arr[i] = r;
			
			

			for (int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					
					break;
				}
			}
		
		}
		
		for (int j1 = 0; j1 < arr.length-1; j1++) {
			for (int j2 = 0; j2 < arr.length-1-j1; j2++) {
				if(arr[j2] > arr[j2+1]) {
					int tmp = arr[j2];
					arr[j2] = arr[j2+1];
					arr[j2+1] = tmp;
					
				}
			}
		}
		//Arrays.sort(arr); --> 출력전에 정렬해야함
		
		for (int i : arr) {			
			System.out.print(i + " ");
		}
		
		System.out.println();
				
	}

}
