import 'package:flutter/material.dart';
import 'package:google_nav_bar/google_nav_bar.dart';
import 'package:loginapputep_exercise/login_page.dart';
import 'package:loginapputep_exercise/quiz_screen.dart';

/*
   Author: Christian Alberto Gomez
 */

/// SelectQuizPage class will provide a screen where the user will select a quiz
/// from the provided by the web service.
class SelectQuizPage extends StatefulWidget{
  const SelectQuizPage({Key? key, required String title,required this.allQuizzes}):super(key: key);
  final List allQuizzes; ///Here we have a list with all the quizzes.

  @override
  State<SelectQuizPage> createState()=> _SelectQuizPageState();
}

class _SelectQuizPageState extends State<SelectQuizPage>{

  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(
        title: Text(
          'Select a Quiz'
        ),
        backgroundColor: Colors.orange,
      ),
      body: Scrollbar(
        child: GridView.builder(
            itemCount: widget.allQuizzes.length,
            gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 3),
            itemBuilder: (BuildContext context,int index){
              ///Here we create a bunch of buttons that says "Quiz ##".
              return Center(
                child: TextButton(
                  child: Text(
                    'Quiz ${index+1}',
                    style: TextStyle(
                      color: Colors.white,
                    fontSize: 18,
                    fontStyle: FontStyle.italic,
                    fontFamily: 'Open Sans',
                  ),
                ),
                  ///Here we are just giving some style to the buttons that are displayed.
                  style: TextButton.styleFrom(
                    primary: Colors.orange,
                    backgroundColor: Colors.orange,
                    onSurface: Colors.grey,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10.0),
                    ),
                  ),
                  ///If user selects a quiz the we move to the following screen
                  /// where the user will take that quiz.
                  onPressed: (){
                    print('***********Quiz ${index+1} have been selected!*************');
                    Navigator.of(context).push(
                      MaterialPageRoute(
                          builder: (context)=>QuizScreenPage(
                              selectedQuiz: widget.allQuizzes[index],
                              numQuiz: index+1
                          ),
                      )
                    );
                  },
                ),
              );
            },
        ),
      ),
      ///A button at the end of the screen where the user will have the option to
      /// log out from the app.
      bottomNavigationBar: GNav(
        backgroundColor: Colors.white,
        color: Colors.black,
        activeColor: Colors.white,
        tabBackgroundColor: Colors.blue,
        padding: EdgeInsets.all(20),
        gap: 10,
        tabs: [
          GButton(
            icon: Icons.exit_to_app,
            text: 'Log Out',
            onPressed: (){
              print('******LOG OUT***********');
              showDialog(
                  context: context,
                  builder: (BuildContext context){
                    return AlertDialog(
                      ///If the user wants to log out then the app will ask for
                      /// a confirmation from the user to do this action.
                      title: new Text("Log Out Confirmation"),
                      content: new Text('Are you sure you want to log out?'),
                      actions: <Widget>[
                        new TextButton(
                          child: new Text("Yes"),
                          onPressed: () {
                            Navigator.of(context).pushReplacement(
                              MaterialPageRoute(
                                  builder: (context)=>LoginPage(),
                              ),
                            );
                            //Navigator.of(context).pop();
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
                  }
              );
            },
          ),
        ],
      ),
    );
  }

  /// displayQuiz() method will just notify what quiz has been selected by the user.
  void displayQuiz(){
    print('***********A Quiz have been selected!*************');
  }
}//