void main(List<String> args) {
  int number = 100;

  // if
  if (number > 0) {
    print("양수 입니다.");
  } else if (number < 0) {
    print("음수 입니다.");
  } else {
    print("0 입니다.");
  }

  // switch
  String grade = "B";
  switch (grade) {
    case "A":
      print("A 학점");
      break;
    case "B":
      print("B 학점");
      break;
    case "C":
      print("C 학점");
      break;
    case "D":
      print("D 학점");
      break;
    default:
      print("유효하지 않습니다.");
  }
}
