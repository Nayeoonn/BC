package Day13.Ex03_Generics;

import Day05.Class.Pikachu;

public class BoxEx {
   
   public static void main(String[] args) {
      // 제네릭
      // : 모든 클래스 타입을 다룰 수 있도록
      //     클래스와 메소드를 정의하는 기법
      // - 타입 매개변수 : 모든 클래스타입을 일반화한 변수
      // - 객체를 생성할 때 타입을 결정한다.
      // - 구조 : class 클래스명 <타입매개변수1, 타입매개변수2> { }
      // - 예시 : class Box <T> { }
      // - 생성 : Box<클래스> box = new Box<클래스>();
      
      Box<String> box1 = new Box<String>();
      box1.setT("쿠팡택배");
      String boxName = box1.getT();
      System.out.println("box1 : " + boxName);
      
      Box<Integer> box2 = new Box<Integer>();
      box2.setT(200);
      int value = box2.getT();
      System.out.println("box2 : " + value);
      
      Box<Pikachu> monsterBall = new Box<Pikachu>();
      monsterBall.setT( new Pikachu() );
      Pikachu pikachu = monsterBall.getT();
      System.out.println("pikachu : " + pikachu);
      
      // 제네릭 기법의 타입으로는 "클래스"만 사용할 수 있다.
      // 기본 타입은 저장 할 수 없다.
      // (에러) Box<int> boxInt = new Box<int>();
      Box<int[]> boxBintz = new Box<int[]>();
      boxBintz.setT( new int[] {1,2,3,4,5} );
      int[] bintzArr = boxBintz.getT();
      for (int i : bintzArr) {
         System.out.print(i + " ");
      } 
      System.out.println();
   }

}