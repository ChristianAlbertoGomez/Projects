import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:pokedex_final_project/home_page.dart';
import 'package:pokedex_final_project/login.dart';


/*
  Class: Topics Software Engineering
  Date: 11/13/2022
  Author: Christian Alberto Gomez
  Assignment: Final Project
 */
/// ********************************************************************************************************************
/// The Class in charge of displaying HomePage and LoginPage depending on the CallBack status
/// ********************************************************************************************************************
class MainPage extends StatelessWidget{
  const MainPage({Key key}):super(key:key);

  @override
  Widget build(BuildContext context){
    return Scaffold(
      body: StreamBuilder<User>(
        stream: FirebaseAuth.instance.authStateChanges(),
      builder: (context,snapshot){
          if(snapshot.hasData){
            return HomePage(title: 'My Home Page',);
          }else{
            return LoginPage();
          }
          },
      ),
    );
  }
}