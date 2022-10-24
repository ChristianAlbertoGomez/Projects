import 'package:flutter/material.dart';
import 'package:google_nav_bar/google_nav_bar.dart';
import 'package:loginapputep_exercise/Controller.dart';
import 'package:loginapputep_exercise/QuestionView.dart';
import 'package:loginapputep_exercise/loading_screen.dart';

/*
  Author: Christian Alberto Gomez
 */

///MyReviewScreenPage is a class that will display a screen where the user can
///review the questions from the quiz.
class MyReviewScreenPage extends StatefulWidget {
  const MyReviewScreenPage({Key? key,required this.selectedQuiz,required this.numQuiz}):super(key: key);

  final List selectedQuiz; ///Quiz selected from the user.
  final int numQuiz; ///Number of the quiz.

  @override
  _MyReviewScreenPageState createState() => _MyReviewScreenPageState();
}

class _MyReviewScreenPageState extends State<MyReviewScreenPage> {

  ///Here we are just initializing the Controller() class and QuestionView()
  QuestionView questionView = QuestionView();
  Controller controller = Controller();
  int index = 0; ///index for the question of the quiz.

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Review Quiz ${widget.numQuiz}'),
        backgroundColor: Colors.orange,
      ),
      body: SafeArea(
        child: Center(
          child: Column(
            children: <Widget>[
              const SizedBox(height: 15.0,),
              Text(
                ///Display the Question on the screen.
                '${questionView.displayStem(widget.selectedQuiz[index],index)}',
                style: TextStyle(
                  fontSize: 16,
                  fontStyle: FontStyle.italic,
                  fontFamily: 'Open Sans',
                ),
              ),
              const SizedBox(height: 15.0,),
              Text(
                ///Display the correct answer from the quiz.
                '${questionView.displayCorrectAnswer(widget.selectedQuiz[index],index)}',
                style: TextStyle(
                  fontSize: 16,
                  fontStyle: FontStyle.italic,
                  fontFamily: 'Open Sans',
                ),
              ),
              const SizedBox(height: 15.0,),
              Text(
                ///Display the correct answer from the quiz.
                '${questionView.displayUserAnswer(widget.selectedQuiz[index],index)}',
                style: TextStyle(
                  fontSize: 16,
                  fontStyle: FontStyle.italic,
                  fontFamily: 'Open Sans',
                ),
              ),
            ],
          ),
        ),
      ),
      ///BottomNavigationBar where the user can go back or forward or back home.
      bottomNavigationBar: GNav(
        backgroundColor: Colors.white,
        color: Colors.black,
        activeColor: Colors.white,
        tabBackgroundColor: Colors.blue,
        padding: EdgeInsets.all(20),
        gap: 10,
        tabs: [
          GButton(
            icon: Icons.arrow_back,
            text: 'Previous',
            onPressed: (){
              if(index == 0){
                showDialog(
                  context: context,
                  builder: (BuildContext context) {
                    return AlertDialog(
                      title: new Text("ALERT"),
                      content: new Text('There is no question there.'),
                      actions: <Widget>[
                        new TextButton(
                          child: new Text("Ok"),
                          onPressed: () {
                            Navigator.of(context).pop();
                          },
                        ),
                      ],
                    );
                  },
                );
              }else{
                setState(() {
                  index--;
                });
              }
            },
          ),
          GButton(
            icon: Icons.home,
            text: 'Home',
            onPressed: (){
              Navigator.of(context).pushReplacement(
                MaterialPageRoute(
                  builder: (context)=> LoadingScreenPage(title: 'UTEP LOADING SCREEN'),
                ),
              );
            },
          ),
          GButton(
            icon: Icons.arrow_forward,
            text: 'Next',
            onPressed: (){
              if(index == widget.selectedQuiz.length-1){
                showDialog(
                  context: context,
                  builder: (BuildContext context) {
                    return AlertDialog(
                      title: new Text("ALERT"),
                      content: new Text('No more questions'),
                      actions: <Widget>[
                        new TextButton(
                          child: new Text("Ok"),
                          onPressed: () {
                            Navigator.of(context).pop();
                          },
                        ),
                      ],
                    );
                  },
                );
              }else{
                setState(() {
                  index++;
                });
              }
            },
          ),
        ],
      ),
    );
  }
}