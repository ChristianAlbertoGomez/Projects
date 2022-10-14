
<!--
/**
 * CS 4342 Database Management
 * @author Instruction team Spring and Fall 2020 with contribution from L. Garnica
 * @version 2.0
 * Description: The purpose of these file is to provide PhP basic elements for an interface to access a DB. 
 * Resources: https://getbootstrap.com/docs/4.5/components/alerts/  -- bootstrap examples
 * Modified by Miguel Rodarte for Assignment 3
 */
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

        <h1 style="text-align:center;">Update Request</h1>
        <!-- styling of the form for bootstrap https://getbootstrap.com/docs/4.5/components/forms/ -->
        <form action="Update_Request.php" method="post">

        <!--Gather information of the employee and request to be updated. -->
            <div class="form-group">
                <label for="employeeID">Employee ID</label>
                <input class="form-control" type="text" id="employeeID" name="employeeID">
                <label for="requestID">Request ID</label>
                <input class="form-control" type="text" id="requestID" name="requestID">
            </div>
            
            <!-- Here we choose the fields which the employee would like to update -->
            <h5 style="text-align:center;">Please Update The Following Fields</h5>
            
            <div class="form-group">
                <label for="Rtype">Request Type</label>
                <select class="form-control" id="Rtype" name="Rtype"> 
                    <option>Email</option>
                    <option>Phone</option>
                    <option>Walkin</option>
                </select>
            </div>

            <div class="form-group">
                <label for="Vtype">Visitor Type</label>
                <select class="form-control" id="Vtype" name="Vtype">
                    <option>Student</option>
                    <option>Faculty</option>
                    <option>Staff</option>
                </select>
            </div>

            <div class="form-group">
                <label for="Rstatus">Request Status</label>
                <select class="form-control" id="Rstatus" name="Rstatus">
                    <option>Pending</option>
                    <option>In Progress</option>
                    <option>Closed</option>
                    <option>Deleted</option>
                </select>
                <label for="Rdescription">Request Description</label>
                <input class="form-control" id="Rdescription" name="Rdescription">
                </select>
                   
            </div>

            <div class="form-group">
                <input class="btn btn-primary" name='Submit' type="submit" value="Submit">
            </div>
        
        </form>
        
        <div>
            <a href="Front_Desk_Staff_Menu.php">Back to Front Desk Menu</a>
        </div>
    </div>

        <!-- jQuery and JS bundle w/ Popper.js -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        
  <!-- CALL PROCEDURE TO UPDATE REQUEST -->
<?php
    session_start();
    require_once('config.php');
    require_once('validate_session.php');
    if (isset($_POST['Submit'])){


        /**
         * Grab information from the form submission and store values into variables.
         */
        //if ($_POST['Rtype'] === '') {
        //    $_POST['Rtype'] = NULL; 
        //}
        
        $emId = isset($_POST['employeeID']) ? $_POST['employeeID'] : " ";
        $reqID = isset($_POST['requestID']) ? $_POST['requestID'] : " ";
        $reqType = isset($_POST['Rtype']) ? $_POST['Rtype'] : " ";            
        $visitType = isset($_POST['Vtype']) ? $_POST['Vtype'] : " ";
        $reqStatus = isset($_POST['Rstatus']) ? $_POST['Rstatus'] : " ";
        $reqDesc = isset($_POST['Rdescription']) ? $_POST['Rdescription'] : " ";
        //Update request by UpdateRequest procedure

        $sqlQuery = "CALL UpdateRequest('$emId','$reqID','$reqType','$visitType','$reqStatus','$reqDesc')";

        // The query sent to the DB can be printed by not commenting the following row
        //echo $queryStudent;
        if ($conn->query($sqlQuery) == TRUE) {
        echo "<br> Request updated succesfully! ";
        } else {
            echo "<br> The record was not created, the query: <br>" . $sqlQuery . "  <br> Generated the error <br>" . $conn->error;
        }

        // To redirect the page to the student menu right after the query is executed, use the following statement 
        // header("Location: student_menu.php");
        
    }
?>
</body>

</html>
