package Day10.Ex01_NestedClass;

/*
 * 중첩 클래스
*/
public class X {
   static int num;

   // 인스턴스 이너 클래스
   // *인스턴스 이너 클래스 안에서 static 멤버 사용불가
   class Y {
      int value;
//      static int value2;

      Y() {
         System.out.println("X의 Y객체 생성");
      }

      void method1() {
         System.out.println("Y의 메소드");
      }

   }

   // static 이너 클래스
   static class Z {
      int value1;
      static int value2;

      Z() {
         System.out.println("X의 Z 객체 생성");
      }

      void method1() {
         System.out.println("Z의 메소드");
      }

      static void method2() {
         System.out.println("Z의 static 메소드");
      }

   }

   // 로컬 클래스
   // : 메소드 안에 정의한 클래스
   // - 메소드가 실행될 때만 사용되는 이너 클래스
   void method() {
      class L {
         int value1;
         // int static value2;

         L() {
            System.out.println("L 객체 생성");
         }

         void method1() {
            System.out.println("L의 메소드");
         }

//         static void method2() {
//            System.out.println("L의 static 메소드");
//         }

      }
      
      L l = new L();
      l.value1 = 10;
      System.out.println("로컬 클래스의 L의 변수 - "+l.value1);
      l.method1();
      
   }
}