import 'dart:convert';

import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:pokedex_final_project/my_pokemons.dart';
import 'package:pokedex_final_project/pokemon.dart';
import 'package:pokedex_final_project/pokemondetail.dart';

/*
  Class: Topics Software Engineering
  Date: 11/13/2022
  Author: Christian Alberto Gomez
  Assignment: Final Project
 */
/// ********************************************************************************************************************
/// The Class in charge of displaying all pokemons from the API.
/// ********************************************************************************************************************

class HomePage extends StatefulWidget {
  const HomePage({Key key, this.title}) : super(key: key);
  final String title;

  @override
  State<HomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<HomePage> {

  /// Variables and Initiations needed for the app.
  final user = FirebaseAuth.instance.currentUser;
  var url = "https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/pokedex.json";
  PokeHub pokeHub;
  List<Pokemon> userFavoritePokemons = [];

  /// Start getting all data from the API.
  @override
  void initState(){
    super.initState();
    fetchData();
  }

  /// Work on getting API information and provide all the pokemons provided.
  fetchData() async{
    var res = await http.get(Uri.parse(url));
    var decodedJson = jsonDecode(res.body);
    pokeHub = PokeHub.fromJson(decodedJson);
    print(pokeHub.toJson());
    setState(() {});
  }

  /// Method in charge of save all user's favorite pokemons.
  addFavoritePokemon(Pokemon pokemon){
    userFavoritePokemons.add(pokemon);
  }

  /// Mehtod in charge of determine the Card color depending on the
  /// pokemon's element.
  selectColor(List types){
    var type = types[0];
    if(type=='Grass'){
      return Colors.greenAccent;
    }else if(type=='Fire'){
      return Colors.redAccent;
    }else if(type=='Water'){
      return Colors.lightBlueAccent;
    }else if(type=='Fighting'){
      return Colors.orange;
    }else if(type=='Normal'){
      return Colors.amberAccent;
    }else if(type=='Bug'){
      return Colors.deepPurple;
    }else if(type=='Ground'){
      return Colors.brown;
    }else if(type=='Psychic'){
      return Colors.purple;
    }else if(type=='Rock'){
      return Colors.grey;
    }else if(type=='Electric'){
      return Colors.yellowAccent;
    }else if(type=='Poison'){
      return Colors.deepPurpleAccent;
    }else if(type=='Ghost'){
      return Colors.blue;
    }
  }


  /// Start building the initial screen.
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Pokedex App'),
        backgroundColor: Colors.cyan,
      ),
      body: pokeHub == null
          ? Center(
        child: CircularProgressIndicator(),
      )
          : GridView.count(
        crossAxisCount: 2,
        children: pokeHub.pokemon
            .map((poke) => Padding(
          padding: const EdgeInsets.all(2.0),
          child: InkWell(
            ///Add 3 options where the user can 'add fav','See details','Close'.
            onTap: () {
              showDialog(
                  context: context,
                  builder: (BuildContext context){
                    return AlertDialog(
                      title: Text('Pokemon Options'),
                      content: Text('Select one of the following options'),
                      actions: [
                        new TextButton(
                            onPressed: (){
                              print('This is my fav pokemon! ${poke.name}');
                              ///Here is where we store favorite pokemons from the user.
                              addFavoritePokemon(poke);
                              Navigator.of(context).pop();
                            },
                            child: Text('Favorite')
                        ),
                        new TextButton(
                            onPressed: (){
                              Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                      builder: (context) => PokeDetail(
                                        pokemon: poke,
                                      )
                                  )
                              );
                            },
                            child: Text('Poke Details')
                        ),
                        new TextButton(
                            onPressed: (){
                              Navigator.of(context).pop();
                            },
                            child: Text('Close')
                        ),
                      ],
                    );
                  }
              );
            },
            child: Hero(
              tag: poke.img,
              child: Card(
                color: selectColor(poke.type),
                child: Column(
                  mainAxisSize: MainAxisSize.max,
                  mainAxisAlignment:
                  MainAxisAlignment.spaceEvenly,
                  children: <Widget>[
                    Container(
                      height: MediaQuery.of(context).size.height *
                          0.2,
                      width:
                      MediaQuery.of(context).size.width * 0.4,
                      decoration: BoxDecoration(
                          image: DecorationImage(
                              fit: BoxFit.cover,
                              image: NetworkImage(poke.img))),
                    ),
                    Text(
                      poke.name,
                      style: TextStyle(
                        fontSize: 10.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ),
        ))
            .toList(),
      ),
      drawer: Drawer(
        child: Container(
          color: Colors.cyan,
          child: ListView(
            children: [
              DrawerHeader(
                  child: Icon(Icons.home,size: 40,)
              ),
              ListTile(
                leading: Icon(Icons.person),
                title: Text('${user.email}',style: TextStyle(fontSize: 15),),
              ),
              ListTile(
                leading: Icon(Icons.list),
                title: Text('My Pokemons',style: TextStyle(fontSize: 15),),
                onTap: (){
                  print('Clicking my list of pokemons');
                  Navigator.of(context).push(
                   MaterialPageRoute(
                       builder: (context)=>MyPokemonsPage(myPokemons: userFavoritePokemons,)
                   ),
                  );
                },
              ),
              ListTile(
                leading: Icon(Icons.subdirectory_arrow_left_sharp),
                title: Text('Log Out',style: TextStyle(fontSize: 15),),
                onTap: (){
                  return showDialog(
                      context: context,
                      builder: (BuildContext context){
                        return AlertDialog(
                          title: Text('Log Out'),
                          content: Text('Are you sure you want to log out?'),
                          actions: [
                            new TextButton(
                              onPressed: (){
                                FirebaseAuth.instance.signOut();
                                Navigator.of(context).pop();
                              },
                              child: Text('Yes'),
                            ),
                            new TextButton(
                              onPressed: (){
                                Navigator.of(context).pop();
                              },
                              child: Text('No'),
                            ),
                          ],
                        );
                      }
                  );
                },
              ),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        backgroundColor: Colors.cyan,
        child: Icon(Icons.refresh),
      ),
    );
  }
}