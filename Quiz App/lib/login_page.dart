import 'dart:io';

import 'package:flutter/material.dart';
import 'package:loginapputep_exercise/loading_screen.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
/*
  Author: Christian Alberto Gomez
 */

///Class in charge of displaying a Login Screen for the user.
class LoginPage extends StatefulWidget{
  static String id = "login_page"; ///Id of the screen page.

  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage>{
  ///checkLogin class initialize
  CheckLogin checkLogin = CheckLogin();

  ///Display a message just in case of an error or something.
  String _message = ""; ///

  ///Catch user's input information
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
                _userTextField(), ///Enter user name
                const SizedBox(height: 15.0,),
                _passwordTextField(), ///Enter password
                const SizedBox(height: 20.0,),
                _buttonLogin(), ///Log in button
                const SizedBox(height: 20.0,),
                _displayInfo(), ///In case of error display an error
              ],
            ),
          ),
        ),
    );
  }

  ///_userTextFiel() method is in charge of provide a TextBox where the user
  ///will be able to enter his/her user.
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

  /// _passwordTextField() method is in charge of provide a TextBox where the
  /// user will be able to enter his/her password.
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

  /// _buttonLogin() method is in charge of execute login action. If the user
  /// click this button the the method will take the user's username and password
  /// to check if exits.
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

  /// _movePage() method is in charge to check if the credentials of the user
  /// exists. If yes, then give access to the main screen. If no, then try again.
  void _movePage(){
    checkLogin.username = _emailController.text; ///Get username.
    checkLogin.password = _passwordController.text; ///Get password

    ///If website response is true then use the navigator.
    _checkWebsiteResponse().then(
            (value) =>setState((){
              if(checkLogin._websiteResponse){
                Navigator.of(context).pushReplacement(
                  MaterialPageRoute(
                    builder:(context)=> LoadingScreenPage(title: 'UTEP Quiz'),
                  ),
                );
              }else{
                ///If user's credentials are incorrect then display a message.
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

  /// _checkWebsiteResponse() method is in charge of await the end process of
  /// userExists() method.
  Future<void> _checkWebsiteResponse() async {
    await checkLogin.userExists();//then((value) => setState((){}));
  }

  /// _displayInfo() method is just in charge to display a message if there is
  /// an error.
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

  ///userExists() method is in charge to read and take the information from the
  ///web service provided by professor Cheon.
  Future<void> userExists() async {
    var usernameInput = username; ///Username from the user.
    var passwordInput = password; ///Password from the user.

    ///Read and get the information from the web service.
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

