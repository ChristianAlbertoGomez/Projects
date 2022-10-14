<!--
/**
 * CS 4342 Database Management
 * @author Instruction team with contribution from L. Garnica and K. Apodaca
 * @version 2.0
 * Description: The purpose of these file is to provide PhP basic elements for an interface to access a DB. 
 * Resources: https://getbootstrap.com/docs/4.5/components/alerts/  -- bootstrap examples
 *
 * This file inserts a new record  into the table Student of your DB.
 */

 -> AUTHOR CODE: Christian Alberto Gomez
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
    <title>Create Request</title>

    <!-- Importing Bootstrap CSS library https://getbootstrap.com/ -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>

<body>
    <div style="margin-top: 20px" class="container">
        <h1>Please fill your request</h1>
        <!-- styling of the form for bootstrap https://getbootstrap.com/docs/4.5/components/forms/ -->
        <form action="create_request.php" method="post">

            <div class="form-group">
            <label for="firstName">First Name</label>
            <input class="form-control" type="text" id="firstName" name="firstName">
            </div>

            <div class="form-group">
            <label for="lastName">Last Name</label>
            <input class="form-control" type="text" id="lastName" name="lastName">
            </div>

            <div class="form-group">
            <label for="email">Email</label>
            <input class="form-control" type="text" id="email" name="email">
            </div>

        <!--Here we ask the name of the anime -->
            <div class="form-group">
                <label for="visitorID">Visitor ID</label>
                <input class="form-control" type="text" id="visitorID" name="visitorID">
                <label for="staffID">Staff ID</label>
                <input class="form-control" type="text" id="staffID" name="staffID">
            </div>

            <div class="form-group">
            <label for="Vtype">Created by:</label>
            <select class="form-control" id="Vtype" name="Vtype">
                <option>Staff</option>
            </select>
            </div>

            <div class="form-group">
            <label for="request_type">Select type of Request:</label>
            <select class="form-control" id="request_type" name="request_type">
                <option>Email</option>
                <option>Phone</option>
                <option>Walkin</option>
            </select>
            </div>

           <!-- <div class="form-group">
                <label for="descrip">Description</label>
                <input class="form-control" type="text" id="descrip" name="descrip">
            </div> -->

            <div class="form-group">
            <label for="descrip">Select Description:</label>
            <select class="form-control" id="descrip" name="descrip">
                <option>Need Advising</option>
                <option>Payroll Issues</option>
                <option>Drop Student</option>
                <option>Need Hold Removal</option>
                <option>Schedule Update</option>
                <option>Need Tech Support</option>
                <option>Parking Ticket Issue</option>
                <option>Wifi Issues</option>
                <option>Printers Issues</option>
            </select>
            </div>
 
            <div class="form-group">
            <label for="status">Select the status of the Request:</label>
            <select class="form-control" id="status" name="status">
                <option>Pending</option>
                <option>In Progress</option>
                <option>Closed</option>
            </select>
            </div>
            
            <div class="form-group">
                <input class="btn btn-primary" name='Submit' type="submit" value="Submit">
            </div>
        </form>
            <div class = "container">
            <div class="horizontal-center">
            <button type="button" class="btn btn-warning"><a href="Front_Desk_Staff_Menu.php">Return to Staff Menu</a></button>
            </div>
            </div>

            <style>
            a:link {
            color: black;
            background-color: transparent;
            text-decoration: none;
            }
            a:visited {
            color: black;
            background-color: transparent;
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

            <style>
            .container {
            height: 20px;
            position: relative;
            border: none;
            }

            .horizontal-center{
            margin: 0;
            position: absolute;
            top: 20%;
            -ms-transform: translateX(-10%);
            transform: translateX(-10%);
            }
            </style>

        <!-- jQuery and JS bundle w/ Popper.js -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
    
    
    <?php
        //session_start();
        //require_once('config.php');
        //require_once('validate_session.php');
        if (isset($_POST['Submit'])){

    
            /**
             * Grab information from the form submission and store values into variables.
             */
            $current_date = date_create();
            date_timestamp_set($current_date,date_timestamp_get($current_date)); //Generate our current Date and Time.
            $visitorID = isset($_POST['visitorID']) ? $_POST['visitorID'] : " ";
            $staffID = isset($_POST['staffID']) ? $_POST['staffID'] : " ";
            $date = date_format($current_date,"m-d-Y");
            $date2 = date_format($current_date,"Y-m-d");
            $time = date_format($current_date,"h:i a");
            $firstName = isset($_POST['firstName']) ? $_POST['firstName'] : " ";
            $lastName = isset($_POST['lastName']) ? $_POST['lastName'] : " ";
            $email = isset($_POST['email']) ? $_POST['email'] : " ";
            $rId = rand(0,9999);
            $rType = isset($_POST['request_type']) ? $_POST['request_type'] : " ";
            $vType = isset($_POST['Vtype']) ? $_POST['Vtype'] : " ";
            $status = isset($_POST['status']) ? $_POST['status'] : " ";
            $descrip = isset($_POST['descrip']) ? $_POST['descrip'] : " ";
            
            //Create request by addRequest procedure

            $sqlQuery = "CALL addRequestByStaff('$visitorID','$date','$time','$rId','$firstName','$lastName','$email','$rType','$vType','$status','$descrip')";
            $sqlQuery2 = "CALL assignsByStaff('$date2','$time','$staffID','$rId')";

            // The query sent to the DB can be printed by not commenting the following row
            //echo $queryStudent;
            if ($conn->query($sqlQuery) == TRUE || $conn->query($sqlQuery2) == TRUE) {
            echo "<br> New record created successfully for your request! Here is your Request ID: $rId ";
            } else {
                echo "<br> The record was not created, the query: <br>" . $sqlQuery . "  <br> Generated the error <br>" . $conn->error;
            }

            // To redirect the page to the student menu right after the query is executed, use the following statement 
            // header("Location: student_menu.php");
}
?>


</body>

</html>