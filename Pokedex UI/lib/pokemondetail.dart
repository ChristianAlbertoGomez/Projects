import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:pokedex_final_project/pokemon.dart';


/*
  Class: Topics Software Engineering
  Date: 11/13/2022
  Author: Christian Alberto Gomez
  Assignment: Final Project
 */
/// ********************************************************************************************************************
/// The Class in charge of displaying a screen with more pokemon details.
/// ********************************************************************************************************************
class PokeDetail extends StatelessWidget {
  ///Pokemon selected to display its information.
  final Pokemon pokemon;

  ///Constructor
  PokeDetail({this.pokemon});

  ///Determine the color of the card depending on the pokemon element.
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

  /// Display card information.
  bodyWidget(BuildContext context) => Stack(
    children: <Widget>[
      Positioned(
        height: MediaQuery.of(context).size.height / 1.5,
        width: MediaQuery.of(context).size.width - 20,
        left: 10.0,
        top: MediaQuery.of(context).size.height * 0.1,
        child: Card(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(15.0),
          ),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: <Widget>[
              SizedBox(
                height: 70.0,
              ),
              Text(
                pokemon.name,
                style:
                TextStyle(fontSize: 25.0, fontWeight: FontWeight.bold),
              ),
              Text("Height: ${pokemon.height}"),
              Text("Weight: ${pokemon.weight}"),
              Text(
                "Types",
                style: TextStyle(fontWeight: FontWeight.bold),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: pokemon.type
                    .map((t) => FilterChip(
                    backgroundColor: Colors.amber,
                    label: Text(t),
                    onSelected: (b) {}))
                    .toList(),
              ),
              Text("Weakness",
                  style: TextStyle(fontWeight: FontWeight.bold)),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: pokemon.weaknesses
                    .map((t) => FilterChip(
                    backgroundColor: Colors.red,
                    label: Text(
                      t,
                      style: TextStyle(color: Colors.white),
                    ),
                    onSelected: (b) {}))
                    .toList(),
              ),
              Text("Next Evolution",
                  style: TextStyle(fontWeight: FontWeight.bold)),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: pokemon.nextEvolution == null
                    ? <Widget>[Text("This is the final form")]
                    : pokemon.nextEvolution
                    .map((n) => FilterChip(
                  backgroundColor: Colors.green,
                  label: Text(
                    n.name,
                    style: TextStyle(color: Colors.white),
                  ),
                  onSelected: (b) {},
                ))
                    .toList(),
              )
            ],
          ),
        ),
      ),
      Align(
        alignment: Alignment.topCenter,
        child: Hero(
            tag: pokemon.img,
            child: Container(
              height: 200.0,
              width: 200.0,
              decoration: BoxDecoration(
                  image: DecorationImage(
                      fit: BoxFit.cover, image: NetworkImage(pokemon.img))),
            )),
      )
    ],
  );

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: selectColor(pokemon.type),
      appBar: AppBar(
        elevation: 0.0,
        backgroundColor: selectColor(pokemon.type),
        title: Text(pokemon.name),
      ),
      body: bodyWidget(context),
    );
  }
}