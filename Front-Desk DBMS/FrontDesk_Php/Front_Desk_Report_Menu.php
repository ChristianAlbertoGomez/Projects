<!--
/**
 * CS 4342 Database Management
 * @author Instruction team Spring and Fall 2020 with contribution from L. Garnica
 * @version 2.0
 * Description: The purpose of these file is to provide PhP basic elements for an interface to access a DB. 
 * Resources: https://getbootstrap.com/docs/4.5/components/alerts/  -- bootstrap examples
 *
 * @Author Alan Verdin, Christian Gomez
 */
-->

<?php
session_start();
require_once('config.php');
require_once('validate_session.php');
?>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>REPORT MENU: </title>

    <!-- Bootstrap CSS library https://getbootstrap.com/ -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>

<body>
    <div style="margin-top: 20px" class="container">
        <h1>FRONT DESK REPORT MENU</h1>
        <!-- styling of the form for bootstrap https://getbootstrap.com/docs/4.5/components/forms/ -->
        <form action="Front_Desk_Report_Menu.php" method="post">

            <div class="form-group">
                <label>Select from the report options below:<label>
            </div>

            <div class="form-group">
                <button type="button" class="btn btn-warning"><a href="View_All_Request.php">View All Requests</a></button>
            </div>

            <div class="form-group">
                <button type="button" class="btn btn-warning"><a href="View_DeletedRequest.php">View All Deleted Requests</a></button>
            </div>

            <div class="form-group">
                <button type="button" class="btn btn-warning"><a href="FilterByVisitorType.php">Filter Request By Vistor</a></button>
            </div>

            <div class="form-group">
                <button type="button" class="btn btn-warning"><a href="view_RequestsPerWeek.php">View Number of Request Per Week</a></button>
            </div>

            <div class="form-group">
                <button type="button" class="btn btn-warning"><a href="View_MostCommonRequest.php">Most Common Request Description</a></button>
            </div>

            <div class="form-group">
                <button type="button" class="btn btn-warning"><a href="view_NumberOfRequests.php">Most Common Request Type</a></button>
            </div>

            <div class="form-group">
                <button type="button" class="btn btn-warning"><a href="View_MostCommonVisitor.php">Most Common Visitor</a></button>
            </div>

            <div class="form-group">
                <button type="button" class="btn btn-warning"><a href="Front_Desk_Staff_Menu.php">Return To Staff Menu</a></button>
            </div>
        </form>
        <div>

        <style>
        a:link {
            color: black;
             background-color: transparent;
            text-decoration: none;
        }
        a:visited {
            color: black;
            ackground-color: transparent;
            text-decoration: none;
        }
        a:hover {
            color: black;
            background-color: transparent;
            text-decoration: underline;
        }
        a:active {
             color: black;
            background-color: transparent;
            text-decoration: underline;
        }
        </style>

        <!-- jQuery and JS bundle w/ Popper.js -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
    </div>

    <!-- jQuery and JS bundle w/ Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</body>

</html>