import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

/*
   Author: Christian Alberto Gomez
 */

class MyBitcoinAppPage extends StatefulWidget {
  const MyBitcoinAppPage({Key? key, required this.title}) : super(key: key);
  final String title;

  @override
  State<MyBitcoinAppPage> createState() => _MyBitcoinAppPageState();
}

class _MyBitcoinAppPageState extends State<MyBitcoinAppPage> {

  BitcoinCurrency _bitcoin = BitcoinCurrency();

  void _getUSDBitcoin(){
    _bitcoin.usdBitcoin().then((value) => setState(() {}));
  }

  void _getEURBitcoin(){
    _bitcoin.eurBitcoin().then((value) => setState(() {}));
  }

  void _getGBPBitcoin(){
    _bitcoin.gbpBitcoin().then((value) => setState(() {}));
  }

  void _resetApp(){
    setState(() {
      _bitcoin.resetApp();
    });
  }

  void _refresh(){
    if(_bitcoin.typeOfCurrency=='USD'){
      setState(() {
        _bitcoin.usdBitcoin().then((value) => setState(() {}));
      });
    }
    if(_bitcoin.typeOfCurrency=='EUR'){
      setState(() {
        _bitcoin.eurBitcoin().then((value) => setState(() {}));
      });
    }
    if(_bitcoin.typeOfCurrency=='GBP'){
      setState(() {
        _bitcoin.gbpBitcoin().then((value) => setState(() {}));
      });
    }
  }

  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
        backgroundColor: Colors.orange,
      ),
      body: Center(
        child: Column(
          children: <Widget>[
            Container(
              margin: const EdgeInsets.all(25),
              child: Text(
                'Welcome to the Bitcoin App by Christian Gomez!',
                style: Theme.of(context).textTheme.headline5,
              ),
            ),
            Container(
              margin: const EdgeInsets.all(25),
              child: Text(
                "Date: ${_bitcoin.time}",
                style: Theme.of(context).textTheme.headline6,
              ),
            ),
            Container(
              margin: const EdgeInsets.all(25),
              child: Text(
                "Code: ${_bitcoin.typeOfCurrency}",
                style: Theme.of(context).textTheme.headline5,
              ),
            ),
            Container(
              margin: const EdgeInsets.all(25),
              child: Text(
                "Price: ${_bitcoin.currencyBitcoin}",
                style: Theme.of(context).textTheme.headline5,
              ),
            ),
            Container(
              margin: const EdgeInsets.all(30),
              alignment: Alignment.topCenter,
              child: ElevatedButton(
                onPressed: _resetApp,
                style: TextButton.styleFrom(backgroundColor:Colors.orange,),
                child: const Text('Clean',
                  style: TextStyle(fontSize: 30,color:Colors.black),),
              ),
            ),
            Container(
              margin: const EdgeInsets.all(30),
              alignment: Alignment.topCenter,
              child: ElevatedButton(
                onPressed: _refresh,
                style: TextButton.styleFrom(backgroundColor:Colors.greenAccent,),
                child: const Text('Refresh',
                  style: TextStyle(fontSize: 30,color:Colors.black),),
              ),
            ),
            Container(
              margin: const EdgeInsets.all(40),
              child: Row(
                children: <Widget>[
                  Expanded(
                    child: ElevatedButton(
                      style: TextButton.styleFrom(backgroundColor:Colors.lightBlueAccent,),
                      onPressed: _getUSDBitcoin,
                      child: const Text('USD Bitcoin',
                        style: TextStyle(fontSize: 20,color: Colors.white),),
                    ),
                  ),
                  Expanded(
                    child: ElevatedButton(
                      style: TextButton.styleFrom(backgroundColor:Colors.yellowAccent),
                      onPressed: _getEURBitcoin,
                      child: const Text('EUR Bitcoin',
                        style: TextStyle(fontSize: 20,color: Colors.black),),
                    ),
                  ),
                  Expanded(
                    child: ElevatedButton(
                      style: TextButton.styleFrom(backgroundColor:Colors.purpleAccent),
                      onPressed: _getGBPBitcoin,
                      child: const Text('GBP Bitcoin',
                        style: TextStyle(fontSize: 20,color: Colors.white),),
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}

///BitcoinCurrency Class will run and provide information
///from the bitcoin API website.
class BitcoinCurrency {

  ///Variables we want for the information
  String _disclaimer = "N/A";
  String _time = "N/A";
  String _currencyBitcoin = "N/A";
  String _typeOfCurrency = "";

  ///Getters for our variables
  get disclaimer => _disclaimer;

  get time => _time;

  get currencyBitcoin => _currencyBitcoin;

  get typeOfCurrency => _typeOfCurrency;
  ///Methods()

  Future<void> usdBitcoin() async{
    var url = Uri.https('api.coindesk.com', '/v1/bpi/currentprice.json');
    var response = await http.get(url);

    var httpBody = response.body;

    var decoded = json.decode(httpBody);
    _disclaimer = decoded['disclaimer'];
    _time = decoded['time']['updated'];
    _currencyBitcoin = decoded['bpi']['USD']['rate'];
    _typeOfCurrency = decoded['bpi']['USD']['code'];
  }

  Future<void> eurBitcoin() async{
    var url = Uri.https('api.coindesk.com', '/v1/bpi/currentprice.json');
    var response = await http.get(url);

    var httpBody = response.body;

    var decoded = json.decode(httpBody);
    _time = decoded['time']['updateduk'];
    _currencyBitcoin = decoded['bpi']['EUR']['rate'];
    _typeOfCurrency = decoded['bpi']['EUR']['code'];
  }

  Future<void> gbpBitcoin() async{
    var url = Uri.https('api.coindesk.com', '/v1/bpi/currentprice.json');
    var response = await http.get(url);

    var httpBody = response.body;

    var decoded = json.decode(httpBody);
    _time = decoded['time']['updateduk'];
    _currencyBitcoin = decoded['bpi']['GBP']['rate'];
    _typeOfCurrency = decoded['bpi']['GBP']['code'];
  }

  void resetApp(){
    _disclaimer = "N/A";
    _time = "N/A";
    _currencyBitcoin = "N/A";
    _typeOfCurrency = "";
  }
}
