import 'package:flutter/material.dart';
import 'package:input_widget/screen/join_screen.dart';
import 'package:input_widget/screen/login_screen.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen>
    with SingleTickerProviderStateMixin {
  late TabController controller; // late 키워드, 지금 선언할 때 에러 발생 x

  @override
  void initState() {
    super.initState();
    // length : 탭의 개수
    // async :
    // with SingleTickerProviderStateMixin 를 지정해서 this 를 사용
    controller = TabController(length: 2, vsync: this);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("홈 화면"),
      ),
      body: TabBarView(
        controller: controller,
        children: const [
          JoinScreen(),
          LoginScreen(),
        ],
      ),
      bottomNavigationBar: TabBar(
        tabs: const [
          Tab(
            child: Text("회원가입"),
          ),
          Tab(
            child: Text("로그인"),
          ),
        ],
        controller: controller,
      ),
    );
  }
}
