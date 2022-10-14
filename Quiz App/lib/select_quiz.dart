import 'package:flutter/material.dart';
import 'package:google_nav_bar/google_nav_bar.dart';
import 'package:loginapputep_exercise/login_page.dart';
/*
   Author: Christian Alberto Gomez
 */

class SelectQuizPage extends StatefulWidget{
  const SelectQuizPage({Key? key, required String title}):super(key: key);

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
            itemCount: 15,
            gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 3),
            itemBuilder: (BuildContext context,int index){
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
                  style: TextButton.styleFrom(
                    primary: Colors.orange,
                    backgroundColor: Colors.orange,
                    onSurface: Colors.grey,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10.0),
                    ),
                  ),
                  onPressed: (){
                    print('***********Quiz ${index+1} have been selected!*************');
                  },
                ),
              );
            },
        ),
      ),
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
              //Navigator.of(context).pushReplacement(
               // MaterialPageRoute(
                  //builder:(context)=>const MyQuizAppPage(title: 'UTEP Bitcoin App'),
                //  builder:(context)=>LoginPage(),
              //  ),
              //);
            },
          ),
        ],
      ),
    );
  }

  void displayQuiz(){
    print('***********A Quiz have been selected!*************');
  }
}//