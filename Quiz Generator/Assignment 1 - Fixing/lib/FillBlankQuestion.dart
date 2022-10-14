import 'dart:io';

import 'package:quiz_exercise/Question.dart';
/*
 Author: Christian Alberto Gomez
 Class: Topics in Software Engineering
 Professor: Cheon
 */
class FillBlankQuestion extends Question{

  late String _userAns; ///userAns: Stores user answer.
  late String _question; ///question: Stores the question statement.
  late List _answer; ///answer: Stores the answer of the question.
  late String _options; ///options: Stores the options that the question provides.

  ///This is a constructor for FillBlankQuestion class.
  FillBlankQuestion(this._question,this._answer,this._options):
      super(_question,_answer,_options);

  ///Getter method for question variable.
  String get question => _question;

  ///Setter method for question variable
  set question(String value) {
    _question = value;
  }

  ///Getter method for answer variable.
  List get answer => _answer;

  ///Setter method for answer variable.
  set answer(List value) {
    _answer = value;
  }

  ///Getter method for options variable.
  String get options => _options;

  ///Setter method for options variable.
  set options(String value) {
    _options = value;
  }

  ///Getter method for userAns variable.
  String get userAns => _userAns;

  ///Setter method for userAns variable.
  set userAns(String value) {
    this._userAns = value;
  }

  ///This method will be in charge to display the question and ask for the
  ///user answer.
  void askQuestion(){
    int counter = 0;

    print(question);
    userAns = stdin.readLineSync()!;

    if((userAns==answer)==true){
      counter++;
      print("Correct answer!");
    }else{
      print("Incorrect answer!");
    }
  }

  ///toSting method in charge to display the question.
  @override
  String toString() {
    return '$question';
  }
}