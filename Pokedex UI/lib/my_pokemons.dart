import 'package:flutter/material.dart';
import 'package:pokedex_final_project/pokemon.dart';
import 'package:pokedex_final_project/pokemondetail.dart';


/*
  Class: Topics Software Engineering
  Date: 11/13/2022
  Author: Christian Alberto Gomez
  Assignment: Final Project
 */
/// ********************************************************************************************************************
/// The Class in charge of displaying user's favorite pokemons.
/// ********************************************************************************************************************
class MyPokemonsPage extends StatefulWidget {
  const MyPokemonsPage({Key key, this.myPokemons}) : super(key: key);
  final List<Pokemon> myPokemons;

  @override
  State<MyPokemonsPage> createState() => _MyPokemonsPageState();
}

class _MyPokemonsPageState extends State<MyPokemonsPage> {

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

  @override
  ///Display favorite pokemons in a List Format.
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('My Pokemons'),
      ),
      body: GridView.count(
        crossAxisCount: 1,
        children: widget.myPokemons
            .map((poke) => Padding(
          padding: const EdgeInsets.all(2.0),
          child: InkWell(
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
    );
  }
}
