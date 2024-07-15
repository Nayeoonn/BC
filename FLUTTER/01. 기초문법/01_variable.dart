// dart에서는 main() 메소드가 프로그램 시작
void main(List<String> args) {
  // 변수 선언
  int age = 20;
  String name = "홍길동";

  print("age : $age");
  print("name : " + name);

  // 실수
  double weight = 45.66;
  double height = 170.23;

  print("weight : $weight");
  print("height : $height");

  // 불리언
  bool isConfirmed = false;
  print("isConfirmed : $isConfirmed");

  // 널 허용 타입
  // int data = null; -> 에러
  int? data = null;
  print("data = $data");

  // 상수
  const PI = 3.141592;
  final String systemCode;
  systemCode = "SYS0001";

  print("PI : $PI");
  print("systemCode : $systemCode");
}
