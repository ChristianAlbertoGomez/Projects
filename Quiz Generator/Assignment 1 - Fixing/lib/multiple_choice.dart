import 'dart:io';
import 'Question.dart';
/*
 Author: Christian Alberto Gomez
 Class: Topics in Software Engineering
 Professor: Cheon
 */
class MultipleChoice extends Question{

  late String _userAns; ///userAns: Stores user answer.
  late String _question; ///question: Stores the question statement.
  late int _answer; ///answer: Stores the answer of the question.
  late List _options; ///options: Stores the options that the question provides.

  ///Constructor for multipleChoice question type.
  MultipleChoice.multipleChoice(this._question,this._answer,this._options):
        super(_question,_answer,_options);

  ///Constructor for True and False question type.
  MultipleChoice.trueAndFalse(this._question,this._answer,this._options):
        super(_question,_answer,_options);

  /*
    Getters and Setters
   */

  ///Getter method for question variable.
  String get question => _question;

  ///Setter method for question variable
  set question(String value) {
    _question = value;
  }

  ///Getter method for answer variable.
  int get answer => _answer;

  ///Setter method for answer variable.
  set answer(int value) {
    _answer = value;
  }

  ///Getter method for options variable.
  List get options => _options;

  ///Setter method for options variable.
  set options(List value) {
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
  ///This method is in charge to print all the options from a question.
  void printAllOptions(){
    for(int i = 0; i < options.length; i++){
      print("[${i+1}] ${options[i]}");
    }
  }
} //End of the class