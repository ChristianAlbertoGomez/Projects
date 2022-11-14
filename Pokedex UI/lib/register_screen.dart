import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:pokedex_final_project/login.dart';
import 'package:pokedex_final_project/main_page.dart';

/*
  Class: Topics Software Engineering
  Date: 11/13/2022
  Author: Christian Alberto Gomez
  Assignment: Final Project
 */
/// ********************************************************************************************************************
/// The Class in charge of displaying a Register Screen to the user.
/// ********************************************************************************************************************
class RegisterPage extends StatefulWidget {
  const RegisterPage({Key key}) : super(key: key);
  @override
  State<RegisterPage> createState() => _MyRegisterPageState();
}

class _MyRegisterPageState extends State<RegisterPage> {

  ///Catch user's input information
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();

  ///Register method
  Future _register() async {
    await FirebaseAuth.instance.createUserWithEmailAndPassword(
        email: _emailController.text.trim(),
        password: _passwordController.text.trim()
    );
    Navigator.of(context).pushReplacement(
        MaterialPageRoute(
            builder:(context)=>MainPage()
        )
    );

  }

  /// Keep updating user's information.
  @override
  void dispose() {
    _emailController.dispose();
    _passwordController.dispose();
    super.dispose();
  }

  /// Display a screen with 2 buttons and a pikachu picture.
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        backgroundColor: Colors.yellow[700],
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.start,
            children: [
              AppBar(
                backgroundColor: Colors.cyan,
                title: Text('Register'),
              ),
              const SizedBox(height: 25.0,),
              Flexible(
                child: Image.asset('assets/pikachu.png',
                  height: 200,
                ),
              ),
              const SizedBox(height: 15.0,),
              _displayRegisterMessage(),
              const SizedBox(height: 15.0,),
              _userTextField(),
              const SizedBox(height: 15.0,),
              _passwordTextField(),
              const SizedBox(height: 20.0,),
              _buttonCompleteRegistration(),
            ],
          ),
        ),
      ),
    );
  }

  /// Mrthod in charge of displaying a message to register.
  Widget _displayRegisterMessage(){
    return Container(
      alignment: Alignment.center,
      child: Text(
        'Register Now!',
        style: TextStyle(
          fontSize: 40,
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

  /// Method that displays a button where the user can complete his registration.
  Widget _buttonCompleteRegistration(){
    return ElevatedButton(
      onPressed: _register,
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
        child: const Text("Let's go!", style: TextStyle(color: Colors.blueAccent),),
      ),
    );
  }
}