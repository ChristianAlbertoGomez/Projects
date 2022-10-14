import 'dart:io';
import 'Question.dart';
/*
 Author: Christian Alberto Gomez
 Class: Topics in Software Engineering
 Professor: Cheon
 */
class QuestionView{

  ///This method will display the questions and options from the quiz.
  void printQuestionDetails(List questions){

    print("Let's start our Quiz!");

    int counter = 0; ///Counter for correct answers
    List userAllAns = []; ///Here we store all user answers for each question.

    ///Here we print all the questions and ask the answer for each of them.
    for(int i = 0; i < questions.length; i++){
      var options = questions[i].options;
      var answers = questions[i].answer;

      if ((options == "") == true) { ///Identify if a question is type fill blank
        print("Q${i+1}) ${questions[i].question}");
        print("[p]previous question [n]next question");
        stdout.write("Provide your answer:");
        String?userInput = stdin.readLineSync();
        userAllAns.add(userInput);
        for (int j = 0; j < answers.length; j++) {
          if ((userInput == answers[j]) == true) {
            counter++;
          }
        }
      } else {
        bool isValid = false; ///boolean to stop while loop.
        while(isValid == false) { ///Repeat this process until user gives the correct answer.
          try { ///Here we will catch a FormatException from the user.
            print("Q${i+1}) ${questions[i].question}");
            print(questions[i].printAllOptions());
            var userInput = prompAnswer(questions[i].options);
            isValid = true;
            userAllAns.add(userInput);
            if ((userInput == questions[i].answer) == true) {
              counter++;
            }
          }on FormatException{
            isValid = false;
            //print("Incorrect Input Type. Try again.");
          }
        }
      }//else
    }
    ///Here we call the grade() method to know the grade of the user.
    grade(counter,questions.length,userAllAns,questions);
  }

  ///prompAnswer() method check if user input is valid or not.
  int prompAnswer(List options){
    var length = options.length;
    var userInput;

    stdout.write("Provide your answer: ");
    int?input = int.parse(stdin.readLineSync()!);

    ///Check if user input is not part of the options provided. If yes, try again.
    if(input > length){
      prompAnswer(options);
    }
    if(input < 1){
      prompAnswer(options);
    }
    userInput = input;
    return userInput;
  }

  ///Method in charge to grade user's quiz.
  void grade(int counter, int numQuestions,List userAllAns,List quiz){
    var total = (counter/numQuestions)*10; ///Get the user's grade.
    print("You got $counter from $numQuestions "); ///total of correct answers.
    print("Grade: $total"); ///Print grade.
    print("Do you want to review your quiz? [1]Yes. [2]No");
    int?review = int.parse(stdin.readLineSync()!);

    if(review==1){
      ///Dsiplay Question with user's answer and the correct answer
      for(int i = 0; i < quiz.length; i++){
        print("Q${i+1}) ${quiz[i].question}");
        print("Your answer:${userAllAns[i]}");
        print("Correct answer:${quiz[i].answer}");
      }
    }else{
      print("Okay!");
    }
  }

  ///Method in charge to know if the user wants to do another quiz or not.
  int doAgain(){
    print("Wanna do the Quiz again? [1]Yes [2]No");
    stdout.write("Provide your answer:");
    int?tryAgain = int.parse(stdin.readLineSync()!);
    return tryAgain;
  }

  int selectQuiz(int numQuizzes){

    print("Which Quiz do you want to do? There are $numQuizzes quizzes");
    stdout.write("Provide your answer:");
    int?select = int.parse(stdin.readLineSync()!);

    return select-1;
  }
}