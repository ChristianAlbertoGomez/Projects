import 'package:flutter/material.dart';
import 'package:google_nav_bar/google_nav_bar.dart';

/*
   Author: Christian Alberto Gomez
 */

class MyQuizAppPage extends StatefulWidget{
  const MyQuizAppPage({Key? key, required String title}):super(key: key);

  @override
  State<MyQuizAppPage> createState()=> _MyQuizAppPageState();
}

class _MyQuizAppPageState extends State<MyQuizAppPage>{
  int currentIndex = 0;

  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(
        title: Text("UTEP Quiz App"),
        backgroundColor: Colors.orange,
      ),
      bottomNavigationBar: GNav(
      backgroundColor: Colors.white,
      color: Colors.black,
      activeColor: Colors.white,
      tabBackgroundColor: Colors.blue,
      padding: EdgeInsets.all(20),
      gap: 8,
      tabs: [
        GButton(
          icon: Icons.quiz,
          text: 'Quiz',
          onPressed: _displayQuiz,
        ),
        GButton(
          icon: Icons.history,
          text: 'History',
          onPressed: _displayHistory,
        ),
        GButton(
          icon: Icons.settings,
          text: 'Logout',
          onPressed: _logout,
        ),
      ],
      ),
    );
  }

  Widget _displayQuiz(){
    return Container(
      child: Text(
        "Your are in the display quiz section"
      ),
    );
  }

  Widget _displayHistory(){
    return Container(
      child: Text(
        "You are in the display History section"
      ),
    );
  }

  Widget _logout(){
    return Container(
      child: Text(
        "Your are in the Logout section"
      ),
    );
  }
}
