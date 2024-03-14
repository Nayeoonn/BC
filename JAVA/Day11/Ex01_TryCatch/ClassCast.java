package Day11.Ex01_TryCatch;

/* 
 * 예외처리
 * * ClassCastException
 * : 클래스 간의 타입 변환시, 올바르지 않은 변환으로 인해 발생하는 예외 상황
 * - 업캐스팅이 전제되지 않은 다운캐스팅을 하는 경우
 * - 부모/자식의 관계가 아닌 클래스로 캐스팅하는 경우
 */

class Animal{ 
	
}

class Dog extends Animal{
	
}

class Cat extends Animal{
	
}

public class ClassCast {
	// 부모 클래스			자식클래스
	// Animal	 <---	Dog, Cat
	// Animal = Cat 으로 업캐스팅 한 이후에
	// 다시 Animal을 Dog로 다운캐스팅할 수 없다
	// - Cat을 Dog로 타입 변환할 수 없다.
	
	public static void main(String[] args) {
		
		Dog dog = new Dog();
		
		
		Cat cat = new Cat();
		
		
	}

	public static void changeToDog(Animal animal) { // 매개변수로 받는 과정에서 업캐스팅
		// 예외 메시지 : java.lang.ClassCastException
		try {
			Dog dog = (Dog) animal;					// 다운캐스팅
			
		} catch (ClassCastException e) {
			System.err.println("Cat을 Dog로 변활할 수 없습니다.");
		}
		
	}
}

