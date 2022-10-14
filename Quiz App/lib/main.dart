import 'dart:io';

import 'package:flutter/material.dart';
import 'package:loginapputep_exercise/login_page.dart';

/*
  Author: Christian Alberto Gomez
 */
void main() async {
  ///This piece will help us to solve error:
  ///Unhandled Exception: HandshakeException: Handshake error in client
  HttpOverrides.global = MyHttpOverrides();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context){
    return MaterialApp(
      title: "LoginApp Demo",
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      initialRoute: LoginPage.id,
      routes:{
        LoginPage.id: (context) => LoginPage(),
      } ,
    );
  }
}

