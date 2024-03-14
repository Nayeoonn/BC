package Day02;

public class Ex03_Byte {

	public static void main(String[] args) {
		// bytes는 1byte 범위의 정수 데이터를 표현
		// 8bits		(0000 0000) : 2^8 (256개)
		// 양수와 음수로 나누ㅏ면, -128 ~ 127 범위로 표현가능
		
		byte var1 = -128;
		byte var2 = -30;
		byte var3 = 0;
		byte var4 = 30;
		// byte var5 = 128; -> error  
		// 에러 메시지 : Type mismatch
		// -> 자료형(타입)이 불일치, 데이터 범위를 벗어남(overflow)
		byte var5 = (byte) 128;
		// int를 강제로 byte로 바꿈 --> -128이 출력됨
		// byte는 -128 ~ 127. 128 표현할 수 없어 한 바퀴 돌아 -128로 출력됨 
		
		System.out.println("var1 : " + var1);
		System.out.println("var2 : " + var2);
		System.out.println("var3 : " + var3);
		System.out.println("var4 : " + var4);
		System.out.println("var5 : " + var5);
		
	}

}
