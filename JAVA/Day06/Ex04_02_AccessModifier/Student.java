package Day06.Ex04_02_AccessModifier;

import Day06.Ex04_01_AccessModifier.Person;

public class Student extends Person{

	// 생성자
	public Student() {
		super();
	}

	public Student(String name, int age, int height, int weight) {
		super(name, age, height, weight);
	}
	
	public void defaultSetting() {
		name = "이름없음";  // public은 어디서든 접근가능
		age = 20;		 // protected는 상속받았기 때문에 접근 가능
		//height = 150;    // default 접근지정자라 같은 패키지에서만 접근 가능 
						   //	다른 패키지라 접근 불가
		//weight = 40;     // pirvate는 접근지정자라 접근 불가
						   // 해당 클래스에서만 접근 가능 
		setHeight(150);
		setWeight(40);
		
	}
	
	

}
