void main(List<String> args) {
  // for
  for (var i = 0; i < 5; i++) {
    print("count : $i");
  }

  // while
  int count = 0;
  while (count < 5) {
    print("count : $count");
  }

  // do-while
  int number = 0;
  do {
    print("number : $number");
    number--;
  } while (number > 0);

  // 리스트 반복
  List<int> numList = [1, 2, 3, 4, 5];

  for (var item in numList) {
    print("item : $item");
  }

  numList.forEach((item) {
    print("item : $item");
  });
}
