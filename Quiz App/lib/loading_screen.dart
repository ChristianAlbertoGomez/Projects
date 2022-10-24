import 'package:flutter/material.dart';
import 'package:loginapputep_exercise/Controller.dart';
import 'package:loginapputep_exercise/select_quiz.dart';
import 'package:percent_indicator/circular_percent_indicator.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

/*
  Author: Christian Alberto Gomez
 */

///Class in charge of display a Loading Screen for the user once he/she login.
class LoadingScreenPage extends StatefulWidget {
  const LoadingScreenPage({Key? key, required this.title}) : super(key: key);
  final String title;

  @override
  State<LoadingScreenPage> createState() => _LoadingScreenPageState();
}

class _LoadingScreenPageState extends State<LoadingScreenPage> {
  GetQuizzes getQuizzes = GetQuizzes();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.orange,
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(15.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              ///Display a CircularPercentIndicator for as visual progress for the
              /// user while he/she is waiting for the next screen.
              CircularPercentIndicator(
                onAnimationEnd: (){
                  ///While the animation is running the program will take the
                  /// web service information provided by the professor. Once
                  /// the progress is finished then we move to the select quiz screen.
                  _checkWebsiteResponse().then(
                          (value) => setState((){
                        if(getQuizzes._getAllQuizzes!=null){
                          Navigator.of(context).pushReplacement(
                            MaterialPageRoute(
                              builder: (context)=> SelectQuizPage(title: 'Quiz Page',allQuizzes: getQuizzes._getAllQuizzes),
                            ),
                          );
                        }
                      })
                  );
                },
                animation: true,
                animationDuration: 3500,
                radius: 120,
                lineWidth: 30,
                percent: 1.0,
                progressColor: Colors.blue,
                backgroundColor: Colors.blue.shade200,
                circularStrokeCap: CircularStrokeCap.round,
              ),
            ],
          ),
        ),
      ),
    );
  }

  /// _checkWebsiteResponse() method is in charge to get all the quizzes from the
  /// web service provided by the professor.
  Future<void> _checkWebsiteResponse() async {
    await getQuizzes.AllQuizzes();
  }

}

///CheckLogin Class in charge just to generate all quizzes from the web service.
class GetQuizzes {
  Controller controller = Controller();

  ///Variables needed for the process of taking the web service information.
  bool _websiteResponse = false;
  var _getAllQuizzes = null;

  ///Getters and Setters
  set websiteResponse(bool value) {
    _websiteResponse = value;
  }

  get getAllQuizzes => _getAllQuizzes;

  set getAllQuizzes(value) {
    _getAllQuizzes = value;
  }

  /// AllQuizzes() method is in charge take all the quizzes from the web service
  /// and provide that result to the next screens or classes.
  Future<void> AllQuizzes() async {
    for (int i = 1; i < 100; i++) {
      String temp = i.toString().padLeft(2, '0');
      var url = Uri.https(
          'www.cs.utep.edu', '/cheon/cs4381/homework/quiz/',
          {'quiz': 'quiz${temp}'});

      print("**********************************");
      var response = await http.get(url);
      print("---------------------------------------");
      //print(response.body);
      var httpBody = response.body;
      var decoded = json.decode(httpBody);

      _websiteResponse = decoded['response'];

      if(_websiteResponse == true){
        controller.quizGenerator(httpBody);
      }else{
        break;
      }
      getAllQuizzes = controller.multiListModel;
    }
  }
}