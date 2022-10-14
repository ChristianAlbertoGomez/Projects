<!--
/**
 * CS 4342 Database Management
 * @author Instruction team Spring and Fall 2020 with contribution from L. Garnica
 * @version 2.0
 * Description: The purpose of these file is to provide PhP basic elements for an interface to access a DB. 
 * Resources: https://getbootstrap.com/docs/4.5/components/alerts/  -- bootstrap examples
 * Include your name here - ex. Modified by Villanueva for Assignment 2
 */


 -> AUTHOR CODE: Christian Alberto Gomez
-->

<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Front Desk System</title>

  <!-- Bootstrap CSS library https://getbootstrap.com/ -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>

<body>
<div style="margin-top: 20px" class="container">
        <h1>Please fill your request</h1>
        <!-- styling of the form for bootstrap https://getbootstrap.com/docs/4.5/components/forms/ -->
        <form action="create_request_visitor.php" method="post">

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
            <label for="visitorID">UTEP ID(If Guest then introduce your current ID)</label>
            <input class="form-control" type="text" id="visitorID" name="visitorID">
        </div>

        <div class="form-group">
            <label for="Vtype">Select type of visitor:</label>
            <select class="form-control" id="Vtype" name="Vtype">
                <option>Guest</option>
                <option>Student</option>
                <option>Staff</option>
                <option>Faculty</option>
            </select>
        </div>

        <div class="form-group">
            <label for="description">Select Description:</label>
            <select class="form-control" id="description" name="description">
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
            <input class="btn btn-primary" name='Submit' type="submit" value="Submit">
        </div>
        
    <div>
        <button type="button" class="btn btn-warning"><a href="index.php">Return To Login Menu</a></button>
    </div>

  <!-- jQuery and JS bundle w/ Popper.js -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

  <!-- AQUI ES DONDE DEBO PONER MI PROCEDURE -->
  <?php
       
        session_start();
        require_once('config.php');
        require_once('validate_session.php');
        if (isset($_POST['Submit'])){

    
            /**
             * Grab information from the form submission and store values into variables.
             */
            $current_date = date_create();
            date_timestamp_set($current_date,1651251954); //Generate our current Date and Time.
            $visitorID = isset($_POST['visitorID']) ? $_POST['visitorID'] : " ";
            $firstName = isset($_POST['firstName']) ? $_POST['firstName'] : " ";
            $lastName = isset($_POST['lastName']) ? $_POST['lastName'] : " ";
            $email = isset($_POST['email']) ? $_POST['email'] : " ";
            $date = $date = date_format($current_date,"m-d-Y");
            $time = date_format($current_date,"h:i a");
            $rId = rand(0,9999);
            $rType = "Walkin";
            //$rType = isset($_POST['rType']) ? $_POST['rType'] : " ";
            $vType = isset($_POST['Vtype']) ? $_POST['Vtype'] : " ";
            $status = "Pending";
            $description = isset($_POST['description']) ? $_POST['description'] : " ";
            
            //Create request by addRequest procedure

            $sqlQuery = "CALL addRequestByVisitor('$visitorID','$date','$time','$rId','$firstName','$lastName','$email','$rType','$vType','$status','$description')";

            // The query sent to the DB can be printed by not commenting the following row
            //echo $queryStudent;
            if ($conn->query($sqlQuery) == TRUE) {
            echo "<br> New record created successfully for your request! Here is your Request ID: $rId";
            } else {
                echo "<br> The record was not created, the query: <br>" . $sqlQuery . "  <br> Generated the error <br>" . $conn->error;
            }

            // To redirect the page to the student menu right after the query is executed, use the following statement 
            // header("Location: student_menu.php");
            
}
?>
</body>

</html>