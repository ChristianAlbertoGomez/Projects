import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:pokedex_final_project/firebase_options.dart';
import 'package:pokedex_final_project/login.dart';
import 'package:pokedex_final_project/main_page.dart';
import 'package:dcdg/dcdg.dart';

/*
  Class: Topics Software Engineering
  Date: 11/13/2022
  Author: Christian Alberto Gomez
  Assignment: Final Project
 */
/// ********************************************************************************************************************
/// The Main Class will just help to run the Pokedex UI App.
/// ********************************************************************************************************************
Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  runApp(MyApp());
}

///MyApp class will be in charge to run the mobile app.
class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context){
    return MaterialApp(
      title: "Pokedex App",
      debugShowCheckedModeBanner: false,
      home: MainPage(),
    );
  }
}