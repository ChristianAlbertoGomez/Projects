import 'package:flutter/material.dart';
import 'package:loginapputep_exercise/loading_screen.dart';
import 'package:loginapputep_exercise/review_screen.dart';
import 'package:loginapputep_exercise/summary_table.dart';

/*
  Author: Christian Alberto Gomez
 */

///MyGradeScreenPage will be in charge to display a screen with the grade from
///the user and also provide buttons fro review, back home, and summary table.
class MyGradeScreenPage extends StatefulWidget {
  const MyGradeScreenPage({Key? key,required this.selectedQuiz,required this.numQuiz,required this.score}):super(key: key);

  final List selectedQuiz; ///Quiz selected from the user.
  final int numQuiz; ///Number of the quiz
  final int score; ///Score from the user after answered the quiz.

  @override
  _MyGradeScreenPageState createState() => _MyGradeScreenPageState();
}

class _MyGradeScreenPageState extends State<MyGradeScreenPage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Grade Score'),
        backgroundColor: Colors.orange,
      ),
      body: SafeArea(
        child: Center(
          child: Column(
            ///Display the information and buttons in the screen.
            mainAxisAlignment: MainAxisAlignment.start,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              _displayGrade(widget.score,widget.selectedQuiz.length),
              const SizedBox(height: 15.0,),
              _reviewButton(widget.selectedQuiz),
              const SizedBox(height: 15.0,),
              _summaryTable(),
              const SizedBox(height: 15.0,),
              _backHomePage(),
              const SizedBox(height: 15.0,),
              _displayImage(widget.score,widget.selectedQuiz.length)
            ],
          ),
        ),
      ),
    );
  }

  /// _displayImage() method will display an image to identify if
  /// you did good or bad in the quiz.
  Widget _displayImage(int score, int totalQuestions){
    var grade = (score/totalQuestions)*10;

    if(grade < 6){
      return Image.asset('assets/failed_grade.png',
        height: 200,
      );
    }else if(grade > 6 && grade < 9){
      return Image.asset('assets/you_are_good.png',
        height: 200,
      );
    }else{
      return Image.asset('assets/excellent.jpg',
        height: 200,
      );
    }
  }

  /// _displayGrade() method will display the grade from the user.
  Widget _displayGrade(int score, int totalQuestions){
    var grade = (score/totalQuestions)*10;

    return Text('Total Grade: $grade',
              style: TextStyle(
                fontSize: 35,
                fontStyle: FontStyle.italic,
                fontFamily: 'Open Sans',
              ),
            );
  }

  /// _reviewButton() method will display a button where the user will have
  /// the option to review the quiz he completed.
  Widget _reviewButton(var selectedQuiz){
    return ElevatedButton(
        onPressed: (){
          print('VISITING REVIEW FROM SELECTED QUIZ');
          Navigator.of(context).push(
            MaterialPageRoute(
                builder: (context)=> MyReviewScreenPage(
                    selectedQuiz: widget.selectedQuiz,
                    numQuiz: widget.numQuiz,
                )
            ),
          );
        },
        child: Text('Review'),
    );
  }

  /// _backHomePage() method will take back to he select quiz screen to the user.
  Widget _backHomePage(){
    return ElevatedButton(
      onPressed: (){
        Navigator.of(context).push(
          MaterialPageRoute(
              builder: (context)=> LoadingScreenPage(title: 'UTEP LOADING SCREEN'),
          ),
        );
      },
      child: Text('Back Home'),
    );
  }

  /// _summaryTable() method will display a button where the user can check the
  /// information from each question from the quiz such as Question and Type of question.
  Widget _summaryTable(){
    return ElevatedButton(
      onPressed: (){
        Navigator.of(context).push(
          MaterialPageRoute(
            builder: (context)=> MySummaryTable(
                selectedQuiz: widget.selectedQuiz,
                numQuiz: widget.numQuiz)
          ),
        );
      },
      child: Text('Summary Table'),
    );
  }
}