import 'dart:convert';
import 'dart:io';
import 'package:quiz_exercise/QuestionView.dart';
import 'package:quiz_exercise/multiple_choice.dart';
import 'FillBlankQuestion.dart';

/*
 Author: Christian Alberto Gomez
 Class: Topics in Software Engineering
 Professor: Cheon
 */
class Controller{

  late final List _multiListModel = []; ///List of Questions Model.
  final QuestionView _questionView = QuestionView(); ///Question view

  /*
  Getters and Setters for both Model and View question.
   */

  ///Getter for questionView variable
  QuestionView get questionView => _questionView;


  ///Getter for multiListModel variable
  List get multiListModel => _multiListModel;

  ///startQuizzes() method will be in charge to start quizzes from the List.
  void startQuizzes(){

//    print("There are a total of ${multiListModel.length} Quizzes!");
  //  int indexQuiz = questionView.selectQuiz(multiListModel.length);
    //questionView.printQuestionDetails(multiListModel[indexQuiz]);

    var tryAgain;
    do {

      print("There are a total of ${multiListModel.length} Quizzes!");
      int indexQuiz = questionView.selectQuiz(multiListModel.length);
      questionView.printQuestionDetails(multiListModel[indexQuiz]);

      tryAgain = questionView.doAgain();

      if(tryAgain==1){
        startQuizzes();
      }else{
        exit(0);
      }
    }while(tryAgain==1);
    //questionView.printQuestionDetails(multiListModel);
  }

  ///Quizgenerator() method will be in charge to generate a single quiz for
  ///each website quiz##.
  void quizGenerator(var httpBody){
    List quiz = []; ///Return a single quiz with a number of questions inside.

    var decoded = json.decode(httpBody);

    var questionsList = decoded['quiz']['question'];
    var type; ///If 1 then Multiplechoice, if 2 then FillBlank
    var stem; ///Question
    var options; ///Options provided by the question
    var answer; ///Answer of the question

    for(int i = 0; i < questionsList.length; i++){
      type = questionsList[i]['type'];
      ///If type is MultipleChoice then continiue with this part.
      if((type==1)==true){
        stem = questionsList[i]['stem'];
        answer = questionsList[i]['answer'];
        options = questionsList[i]['option'];

        ///This If-Statement will be in charge to identify if the multiplechoice
        ///question is a true and false question.
        if((options[0]=="True")==true){
          MultipleChoice tf = MultipleChoice.trueAndFalse(stem,answer,options);
          quiz.add(tf);
        }else{
          MultipleChoice multi = MultipleChoice.multipleChoice(stem,answer,options);
          quiz.add(multi);
        }
      }else{
        ///Here we just create a FillBlankQuestion.
        stem = questionsList[i]['stem'];
        answer = questionsList[i]['answer'];
        options = "";
        FillBlankQuestion fill = FillBlankQuestion(stem,answer,options);
        quiz.add(fill);
      }
    }//end for loop
    multiListModel.add(quiz);
  }

}