import 'package:flutter/material.dart';
import 'package:layout_widget/models/students.dart';
import 'package:layout_widget/screens/detail_screen.dart';
import 'package:layout_widget/screens/gridview_screen.dart';
import 'package:layout_widget/screens/listview_screen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  // 🧊 state
  List<Student> studentList = [];

  @override
  void initState() {
    super.initState();

    studentList
        .add(Student(imagePath: "image/jjanggu.jpg", name: '짱구', age: 5));
    studentList.add(Student(imagePath: "image/jjang.jpg", name: '짱아', age: 0));
    studentList
        .add(Student(imagePath: "image/hindoong.jpg", name: '흰둥이', age: 3));
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        // debugShowCheckedModeBanner: false,
        // title: "리스트 뷰",
        // home: ListviewScreen( list: studentList )

        // debugShowCheckedModeBanner: false,
        // title: "그리드 뷰",
        // home: GridviewScreen( list: studentList )

        // debugShowCheckedModeBanner: false,
        // title: "디테일 뷰",
        // home : DetailScreen()

        debugShowCheckedModeBanner: false,
        title: "상세 화면",
        home: ListviewScreen(list: studentList));
  }
}
