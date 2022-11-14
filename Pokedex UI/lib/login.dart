import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:pokedex_final_project/register_screen.dart';

/*
  Class: Topics Software Engineering
  Date: 11/13/2022
  Author: Christian Alberto Gomez
  Assignment: Final Project
 */
/// ********************************************************************************************************************
/// The Class in charge of displaying a Login Screen for the user.
/// ********************************************************************************************************************
class LoginPage extends StatefulWidget{
  const LoginPage({Key key,}) : super(key: key);
  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {

  ///Catch user's input information
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();

  ///Login method
  Future logIn() async {
    await FirebaseAuth.instance.signInWithEmailAndPassword(
        email: _emailController.text.trim(),
        password: _passwordController.text.trim(),
    );
  }

  ///Keep updated the user's information.
  @override
  void dispose() {
    _emailController.dispose();
    _passwordController.dispose();
    super.dispose();
  }

  ///Provide a body where we will have a bunch of buttons and an image.
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        backgroundColor: Colors.yellow[700],
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.start,
            children: [
              Flexible(
                child: Image.asset('assets/pokemon_logo.svg',
                  height: 200,
                ),
              ),
              const SizedBox(height: 15.0,),
              _userTextField(),
              const SizedBox(height: 15.0,),
              _passwordTextField(),
              const SizedBox(height: 20.0,),
              _buttonLogin(),
              const SizedBox(height: 20.0,),
              _buttonRegister(),
            ],
          ),
        ),
      ),
    );
  }

  ///_userTextFiel() method is in charge of provide a TextBox where the user
  ///will be able to enter his/her user.
  Widget _userTextField() {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 25.0),
      child: Container(
        decoration: BoxDecoration(
          color: Colors.grey[200],
          border: Border.all(color: Colors.white),
          borderRadius: BorderRadius.circular(12),
        ),
        child: Padding(
          padding: const EdgeInsets.only(left: 20.0),
          child: TextField(
            controller: _emailController,
            keyboardType: TextInputType.emailAddress,
            decoration: InputDecoration(
              border: InputBorder.none,
              icon: Icon(Icons.email),
              hintText: 'Email',
            ),
          ),
        ),
      ),
    );
  }

  /// _passwordTextField() method is in charge of provide a TextBox where the
  /// user will be able to enter his/her password.
  Widget _passwordTextField() {
    return Padding(
        padding: const EdgeInsets.symmetric(horizontal: 25.0),
      child: Container(
        decoration: BoxDecoration(
          color: Colors.grey[200],
          border: Border.all(color: Colors.white),
          borderRadius: BorderRadius.circular(12),
        ),
        child: Padding(
          padding: const EdgeInsets.only(left: 20.0),
          child: TextField(
            controller: _passwordController,
            obscureText: true,
            decoration: InputDecoration(
              border: InputBorder.none,
              icon: Icon(Icons.lock),
              hintText: 'Password',
            ),
          ),
        ),
      ),
    );
  }

  /// _buttonLogin() method is in charge of execute login action. If the user
  /// click this button the the method will take the user's username and password
  /// to check if exits.
  Widget _buttonLogin() {
    return ElevatedButton(
      onPressed: logIn,
      style: ElevatedButton.styleFrom(
        primary: Colors.yellow,
        onSurface: Colors.yellow,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(10.0),
        ),
        elevation: 10.0,
      ),
      child: Container(
        padding: const EdgeInsets.symmetric(horizontal: 80.0, vertical: 15.0),
        child: const Text("Log In", style: TextStyle(color: Colors.blueAccent),),
      ),
    );
  }

  ///_buttonRegister() method is in charge of displaying a register button. If
  ///the user clicks this button the app will display a new register screen.
  Widget _buttonRegister(){
    return ElevatedButton(
      onPressed:(){
        Navigator.of(context).push(
          MaterialPageRoute(
              builder: (context)=>RegisterPage()
          ),
        );
      },
      style: ElevatedButton.styleFrom(
        primary: Colors.lightBlueAccent,
        onSurface: Colors.yellow,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(10.0),
        ),
        elevation: 10.0,
      ),
      child: Container(
        padding: const EdgeInsets.symmetric(horizontal: 80.0, vertical: 15.0),
        child: const Text("Register", style: TextStyle(color: Colors.white),),
      ),
    );
  }
}
