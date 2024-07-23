import 'dart:math';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Maze Game',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  static const int initialRows = 10;
  static const int initialCols = 10;
  List<List<int>> maze = [];
  int playerRow = 1;
  int playerCol = 1;
  int exitRow = 0; // 초기화
  int exitCol = 0; // 초기화
  int level = 1;
  FocusNode _focusNode = FocusNode();

  @override
  void initState() {
    super.initState();
    _initializeGame();
  }

  void _initializeGame() {
    int size = initialRows + (level - 1) * 2;
    maze = _generateMaze(size, size);
    playerRow = 1;
    playerCol = 1;
    _placeExit(size, size);
    _focusNode.requestFocus();
  }

  void _placeExit(int rows, int cols) {
    Random rand = Random();
    do {
      exitRow = rand.nextInt(rows ~/ 2) * 2 + 1; // 홀수 위치
      exitCol = rand.nextInt(cols ~/ 2) * 2 + 1; // 홀수 위치
    } while (maze[exitRow][exitCol] == 1 ||
        (exitRow == 1 && exitCol == 1)); // 출구가 벽 또는 시작 위치와 겹치지 않도록
    maze[exitRow][exitCol] = 0;
  }

  List<List<int>> _generateMaze(int rows, int cols) {
    List<List<int>> maze =
        List.generate(rows, (_) => List.generate(cols, (_) => 1));
    Random rand = Random();

    void carvePassagesFrom(int cx, int cy) {
      List<int> directions = [0, 1, 2, 3];
      directions.shuffle(rand);

      for (var direction in directions) {
        int nx, ny;

        switch (direction) {
          case 0: // Up
            nx = cx;
            ny = cy - 2;
            break;
          case 1: // Right
            nx = cx + 2;
            ny = cy;
            break;
          case 2: // Down
            nx = cx;
            ny = cy + 2;
            break;
          case 3: // Left
            nx = cx - 2;
            ny = cy;
            break;
          default:
            nx = cx;
            ny = cy;
        }

        if (nx > 0 &&
            nx < rows - 1 &&
            ny > 0 &&
            ny < cols - 1 &&
            maze[nx][ny] == 1) {
          maze[nx][ny] = 0;
          maze[cx + (nx - cx) ~/ 2][cy + (ny - cy) ~/ 2] = 0;
          carvePassagesFrom(nx, ny);
        }
      }
    }

    maze[1][1] = 0;
    carvePassagesFrom(1, 1);

    // Ensure path from start to exit
    _ensurePathFromStartToExit(maze, 1, 1);

    return maze;
  }

  void _ensurePathFromStartToExit(
      List<List<int>> maze, int startX, int startY) {
    List<List<bool>> visited = List.generate(
        maze.length, (_) => List.generate(maze[0].length, (_) => false));
    _dfs(maze, visited, startX, startY);
  }

  bool _dfs(List<List<int>> maze, List<List<bool>> visited, int x, int y) {
    if (x == exitRow && y == exitCol) {
      return true;
    }

    visited[x][y] = true;

    List<List<int>> directions = [
      [0, -1], // Left
      [0, 1], // Right
      [-1, 0], // Up
      [1, 0], // Down
    ];

    for (var dir in directions) {
      int nx = x + dir[0];
      int ny = y + dir[1];

      if (nx >= 0 &&
          nx < maze.length &&
          ny >= 0 &&
          ny < maze[0].length &&
          maze[nx][ny] == 0 &&
          !visited[nx][ny]) {
        if (_dfs(maze, visited, nx, ny)) {
          return true;
        }
      }
    }

    return false;
  }

  void _movePlayer(int dx, int dy) {
    int newRow = playerRow + dx;
    int newCol = playerCol + dy;
    if (newRow >= 0 &&
        newRow < maze.length &&
        newCol >= 0 &&
        newCol < maze[0].length &&
        maze[newRow][newCol] == 0) {
      setState(() {
        playerRow = newRow;
        playerCol = newCol;
        if (playerRow == exitRow && playerCol == exitCol) {
          level++;
          _initializeGame();
        }
      });
    }
  }

  void _handleKey(RawKeyEvent event) {
    if (event is RawKeyDownEvent) {
      final key = event.logicalKey;
      if (key == LogicalKeyboardKey.arrowUp) {
        _movePlayer(-1, 0);
      } else if (key == LogicalKeyboardKey.arrowDown) {
        _movePlayer(1, 0);
      } else if (key == LogicalKeyboardKey.arrowLeft) {
        _movePlayer(0, -1);
      } else if (key == LogicalKeyboardKey.arrowRight) {
        _movePlayer(0, 1);
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Maze Game - Level $level'),
      ),
      body: RawKeyboardListener(
        focusNode: _focusNode,
        onKey: _handleKey,
        autofocus: true,
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              for (int i = 0; i < maze.length; i++)
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    for (int j = 0; j < maze[i].length; j++)
                      Container(
                        width: 20,
                        height: 20,
                        color: i == playerRow && j == playerCol
                            ? Colors.red
                            : i == exitRow && j == exitCol
                                ? Colors.green
                                : maze[i][j] == 1
                                    ? Colors.black
                                    : Colors.white,
                      ),
                  ],
                ),
            ],
          ),
        ),
      ),
    );
  }
}
