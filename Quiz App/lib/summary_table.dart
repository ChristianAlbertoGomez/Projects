import 'package:flutter/material.dart';
import 'package:google_nav_bar/google_nav_bar.dart';
import 'package:loginapputep_exercise/loading_screen.dart';

/*
  Author: Christian Alberto Gomez
 */

///This class will display a Summary Table from the Quiz that the user made.
class MySummaryTable extends StatefulWidget {
  const MySummaryTable({Key? key,required this.selectedQuiz,required this.numQuiz}):super(key: key);
  final List selectedQuiz; ///Selected quiz from the user.
  final int numQuiz; ///Number of the quiz.

  @override
  _MySummaryTableState createState() => _MySummaryTableState();
}
class _MySummaryTableState extends State<MySummaryTable> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.orange,
          title: Text('Quiz ${widget.numQuiz} Summary'),
        ),
        body: ListView(
          children: [
            _createDataTable(),
            _homeButton()
          ],
        ),
      ),
    );
  }

  Widget _homeButton(){
    return ElevatedButton(
      onPressed: (){
        Navigator.of(context).push(
          MaterialPageRoute(
            builder: (context)=> LoadingScreenPage(title: 'UTEP LOADING SCREEN'),
          ),
        );
      },
      child: Text('Back Home'),
    );
  }

  DataTable _createDataTable() {
    return DataTable(columns: _createColumns(), rows: _createRows(widget.selectedQuiz));
  }
  List<DataColumn> _createColumns() {
    return [
      const DataColumn(label: Text('Question')),
      const DataColumn(label: Text('Type')),
    ];
  }
  List<DataRow> _createRows(var selectedQuiz) {
    List<DataRow> dataRow = [];

    for(int i = 0; i < selectedQuiz.length; i++){
      if(selectedQuiz[i].options == ""){
        dataRow.add(
          DataRow(cells: [
            DataCell(Text(selectedQuiz[i].question)),
            DataCell(Text('Fill in Blank')),
          ]),
        );
      }else{
        dataRow.add(
          DataRow(cells: [
            DataCell(Text(selectedQuiz[i].question)),
            DataCell(Text('MultipleChoice')),
          ]),
        );
      }
    }
    return dataRow;
  }
}