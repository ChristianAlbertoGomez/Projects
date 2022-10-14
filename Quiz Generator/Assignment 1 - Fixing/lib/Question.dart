/*
 Author: Christian Alberto Gomez
 Class: Topics in Software Engineering
 Professor: Cheon
 */
class Question{

  late var _question; ///question: Stores the question statement.
  late var _answer; ///answer: Stores the answer of the question.
  late var _options; ///options: Stores the options that the question provides.

  ///Constructor for Question class.
  Question(var question, var answer, var options){
    this._question = question;
    this._answer = answer;
    this._options = options;
  }
}