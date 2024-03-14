package Day08.Ex01_SingleTon;

public class SingleTonTest {
	
	public static void main(String[] args) {
		// SingleTon s = new SingleTon();  private로 막아놓음 그래서 오류
		
		SingleTon s01 = SingleTon.getInstance();
		SingleTon s02 = SingleTon.getInstance();
		
		// 인스턴스가 메모리 공간에 하나로 할당되어 있는지 확인
		System.out.print("s01과 s02가 같은지 여부 : ");
		System.out.println(s01 == s02);
	}

}
