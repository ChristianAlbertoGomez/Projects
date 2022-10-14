import 'dart:io';

import 'package:flutter/material.dart';
import 'package:loginapputep_exercise/home_page2.dart';
import 'package:loginapputep_exercise/select_quiz.dart';
import 'home_page.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
/*
  Author: Christian Alberto Gomez
 */
class LoginPage extends StatefulWidget{
  static String id = "login_page";

  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage>{
  //checklogin class initialize
  CheckLogin checkLogin = CheckLogin();

  //We are looking this information
  final String _logInEmail = "cagomez15";
  final String _logInPassword = "8593";
  String _message = "";

  //Catch user's input information

  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();


  @override
  Widget build(BuildContext context){
    return SafeArea(
        child: Scaffold(
          body: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              children: [
                Flexible(
                  child: Image.asset('assets/utep_logo.png',
                    height: 300,
                  ),
                ),
                const SizedBox(height: 15.0,),
                _userTextField(),
                const SizedBox(height: 15.0,),
                _passwordTextField(),
                const SizedBox(height: 20.0,),
                _buttonLogin(),
                const SizedBox(height: 20.0,),
                _displayInfo(),
              ],
            ),
          ),
        ),
    );
  }

  Widget _userTextField() {
      return Container(
        padding: const EdgeInsets.symmetric(horizontal: 20.0),
        child: TextField(
          controller: _emailController,
          keyboardType: TextInputType.emailAddress,
          decoration: const InputDecoration(
              icon: Icon(Icons.email),
              hintText: 'example@miners.utep.edu'
          ),
        ),
      );
  }

  Widget _passwordTextField(){
      return Container(
        padding: const EdgeInsets.symmetric(horizontal: 20.0),
        child:  TextField(
          controller: _passwordController,
          keyboardType: TextInputType.emailAddress,
          obscureText: true,
          decoration: const InputDecoration(
            icon: Icon(Icons.lock),
            hintText: 'password',
            labelText: 'password',
          ),
        ),
      );
  }

  Widget _buttonLogin(){
      return ElevatedButton(
          onPressed:_movePage,
        style: ElevatedButton.styleFrom(
          primary: Colors.orange,
          onSurface: Colors.deepOrangeAccent,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(10.0),
          ),
          elevation: 10.0,
        ),
          child: Container(
            padding: const EdgeInsets.symmetric(horizontal: 80.0,vertical: 15.0),
            child: const Text("Log In"),
          ),
      );
  }

  void _movePage(){
    checkLogin.username = _emailController.text;
    checkLogin.password = _passwordController.text;
    //_checkWebsiteResponse().then((value) => print("*************************************************${checkLogin._websiteResponse}"));
    _checkWebsiteResponse().then(
            (value) =>setState((){
              if(checkLogin._websiteResponse){
                //_message = "email:$_email\npassword:$_password";
                Navigator.of(context).pushReplacement(
                  MaterialPageRoute(
                    //builder:(context)=>const MyQuizAppPage(title: 'UTEP Bitcoin App'),
                    builder:(context)=>const SelectQuizPage(title: 'Select Your Quiz'),
                  ),
                );
              }else{
                showDialog(
                  context: context,
                  builder: (BuildContext context) {
                    return AlertDialog(
                      title: new Text("Log In Error"),
                      content: new Text('Incorrect Username/Password.'),
                      actions: <Widget>[
                        new TextButton(
                          child: new Text("Try Again"),
                          onPressed: () {
                            Navigator.of(context).pop();
                          },
                        ),
                      ],
                    );
                  },
                );
              }
            })
    );
  }

  Future<void> _checkWebsiteResponse() async {
    await checkLogin.userExists();//then((value) => setState((){}));
  }

  Widget _displayInfo(){
    return Text(_message);
  }
}

///Class to solve Unhandled Exception: HandshakeException: Handshake error in client
class MyHttpOverrides extends HttpOverrides{
  @override
  HttpClient createHttpClient(SecurityContext? context){
    return super.createHttpClient(context)
      ..badCertificateCallback = (X509Certificate cert, String host, int port)=> true;
  }
}

///CheckLogin Class
class CheckLogin{

  ///Variables
  var _username = '';
  var _password = '';
  bool _websiteResponse = false ;

  ///Getters and Setters
  get username => _username;

  set username(value) {
    _username = value;
  }

  get password => _password;

  set password(value) {
    _password = value;
  }

  set websiteResponse(bool value) {
    _websiteResponse = value;
  }

  Future<void> userExists() async {
    var usernameInput = username;
    var passwordInput = password;

    var url = Uri.https(
        'www.cs.utep.edu', '/cheon/cs4381/homework/quiz/login.php',
        {'user':usernameInput,'pin':passwordInput});
    print("**********************************");
    var response = await http.get(url);
    print("---------------------------------------");
    print(response.body);
    var httpBody = response.body;
    var decoded = json.decode(httpBody);

    _websiteResponse = decoded['response'];
  }
}

