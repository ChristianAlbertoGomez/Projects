import 'package:flutter/material.dart';
import 'package:google_nav_bar/google_nav_bar.dart';
import 'package:loginapputep_exercise/Controller.dart';
import 'package:loginapputep_exercise/QuestionView.dart';
import 'package:loginapputep_exercise/grade_screen.dart';

/*
  Author: Christian Alberto Gomez
 */

/// QuizScreenPage will display a screen with all the questions from the quiz
/// selected by the user.
class QuizScreenPage extends StatefulWidget{
  const QuizScreenPage({Key? key,required this.selectedQuiz,required this.numQuiz}):super(key: key);
  final List selectedQuiz; ///Quiz we are going to display and use
  final int numQuiz; ///Just the number of the quiz for the top bar presentation

  @override
  State<QuizScreenPage> createState()=> _QuizScreenPageState();
}

class _QuizScreenPageState extends State<QuizScreenPage>{

  ///Here we are just initializing the Controller() class and QuestionView()
  Controller controller = Controller();
  QuestionView questionView = QuestionView();
  int index = 0; ///Position inside of the quiz selected
  int score = 0; ///Score/correct answers from the user.


  ///Here we get the user's answer from each question.
  TextEditingController userAns = TextEditingController();

  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(
        title: Text('Quiz ${widget.numQuiz}(Total Questions:${widget.selectedQuiz.length})'),
        backgroundColor: Colors.orange,
      ),
      body: SafeArea(
        child: Center(
          child: Column(
            children: <Widget>[
              const SizedBox(height: 15.0,),
              ///Display Question.
              Text(
                '${questionView.displayStem(widget.selectedQuiz[index],index)}',
              style: TextStyle(
                fontSize: 16,
                fontStyle: FontStyle.italic,
                fontFamily: 'Open Sans',
              ),
              ),
              const SizedBox(height: 15.0,),
              ///Display options depending of the type of question that will be
              ///displayed on screen.
              Column(
                children: checkWhatOptionsDisplay(widget.selectedQuiz[index])
              ),
              //_displayAllOptions(widget.selectedQuiz[index])
            ],
          ),
        ),
      ),
      ///BottomNavigationBar will provide the options to move from one question
      ///to another question and submit user's answer.
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
              icon: Icons.upload,
            text: 'Submit',
            onPressed: (){
              widget.selectedQuiz[index].userAns = userAns.text;
              print("USER ANSWER:${userAns.text}");
              print('Question:${widget.selectedQuiz[index].question}');

              ///Check if user's answer is correct or not!
              ///If yes then counter + 1, if not then counter stays the same.
              if(isCorrectAnswer(widget.selectedQuiz[index], userAns.text)){
                setState(() {
                  score++;
                });
              }


              ///If we get the last question the we can ask to the user if he wants
              ///to proceed to grade his answers.
              if(index == widget.selectedQuiz.length-1){
                showDialog(
                  context: context,
                  builder: (BuildContext context) {
                    return AlertDialog(
                      title: new Text("Grade Quiz"),
                      content: new Text('Are you ready for grading?'),
                      actions: <Widget>[
                        new TextButton(
                          child: new Text("Yes!"),
                          onPressed: () {
                            Navigator.of(context).push(
                              MaterialPageRoute(
                                  builder: (context)=> MyGradeScreenPage(
                                      selectedQuiz: widget.selectedQuiz,
                                      numQuiz: widget.numQuiz,
                                      score: score)
                              )
                            );
                          },
                        ),
                        new TextButton(
                          child: new Text("No"),
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
          GButton(
              icon: Icons.arrow_forward,
            text: 'Next',
            onPressed: (){
              ///If we get the last question the we can ask to the user if he wants
              ///to proceed to grade his answers.
              if(index == widget.selectedQuiz.length-1){
                showDialog(
                  context: context,
                  builder: (BuildContext context) {
                    return AlertDialog(
                      title: new Text("Grade Quiz"),
                      content: new Text('Are you ready for grading?'),
                      actions: <Widget>[
                        new TextButton(
                          child: new Text("Yes!"),
                          onPressed: () {
                            Navigator.of(context).push(
                                MaterialPageRoute(
                                    builder: (context)=> MyGradeScreenPage(
                                        selectedQuiz: widget.selectedQuiz,
                                        numQuiz: widget.numQuiz,
                                        score: score)
                                )
                            );
                          },
                        ),
                        new TextButton(
                          child: new Text("No"),
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

  ///isCorrectAnswer() method is in charge to confirm if the user answer is
  ///correct or not. If yes then return true, if not then return false.
  bool isCorrectAnswer(var question,var userAnswer){
    bool isCorrect = false;
    var options = question.options;

    if(options==""){
      for(int i = 0;i < options.length; i++){
        if(userAnswer==options[i]){
          print('print answer: ${options[i]}');
          print('user answer:$userAnswer');
          isCorrect = true;
          print("Correct answer!");
        }
      }
    }else{
      int answer = question.answer; ///This will be an int such as 1,2,3,etc.
      var  questionAnswer = options[answer];/// options[1],options[2], etc.
      print('print answer $questionAnswer');
      print('user answer:$userAnswer');

      if(userAnswer==questionAnswer){
        isCorrect = true;
        print('Correct answer!');
      }
    }
    return isCorrect;
  }


  ///variable in charge of getting user's option as his answer.
  String selectedOption = '';

  ///checkWhatOptionsDisplay() method will be in charge to display all the options
  ///from the question.
  List<Widget> checkWhatOptionsDisplay(var question){

    ///Get question options and check what type of options display.
    List<Widget> displayOptions = [];
    var options = question.options;

    ///Here we display the options from a question type Fill in Blank
    if(options==""){
      displayOptions.add(
          TextField(
            controller: userAns,
            keyboardType: TextInputType.text,
            decoration: InputDecoration(
              hintText: 'Answer Fill in Blank',
              labelText: 'Answer Fill in Blank',
            ),
          )
      );
    }else{
      ///Here we display the options from a question type Multiple Choice
      for(String option in options){
        displayOptions.add(
          RadioListTile(
            value: option,
            groupValue: userAns.text,
            title: Text(option),
            onChanged:(currentOption){
              setSelectedOption(currentOption);
            } ,
            selected: userAns.text == option,
          )
        );
      }
    }
    return displayOptions;
  }

  ///Update the user's selection from the radio button list.
  setSelectedOption(var option) {
    setState(() {
      userAns.text = option;
    });
  }
}