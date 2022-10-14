import 'dart:io';
import 'dart:math';
import 'package:quiz_exercise/FillBlankQuestion.dart';
import 'package:quiz_exercise/Controller.dart';
import 'package:quiz_exercise/QuestionView.dart';
import 'package:quiz_exercise/multiple_choice.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

/*
 Author: Christian Alberto Gomez
 Class: Topics in Software Engineering
 Professor: Cheon
 */

///Testing class for our Model View Controller Quiz.
void main() async {


  Controller controller = Controller();

  ///Here I created a for loop to take all quizzes that exists
  for(int i = 1; i < 100; i++) {
    String temp = i.toString().padLeft(2,'0');
    var url = Uri.https(
        'www.cs.utep.edu', '/cheon/cs4381/homework/quiz/',
        {'quiz': 'quiz${temp}'});
    var response = await http.get(url);
    var httpBody = response.body;
    var decoded = json.decode(httpBody);

    var websiteResponse = decoded['response'];

    if(websiteResponse==true){
      ///If the website quiz## exists then create a quiz with its questions.
      controller.quizGenerator(httpBody);
    }else{
      ///If the website does not exists then finish the process here.
      break;
    }
  }
  ///Here we start displaying the quizzes. O means the first quiz saved from
  ///the website.
  controller.startQuizzes();
}