<!--
/**
 * CS 4342 Database Management
 * @author Instruction team with contribution from L. Garnica and K. Apodaca
 * @version 2.0
 * Description: The purpose of these file is to provide PhP basic elements for an interface to access a DB.
 * Resources: https://getbootstrap.com/docs/4.5/components/alerts/  -- bootstrap examples
 *
 * This file deletes a record from the request table
 * @Author Garrett Jones, Alan Verdin
 */
-->

<?php
/*
* Reference for tables: https://getbootstrap.com/docs/4.5/content/tables/
*/

session_start();
require_once('config.php');
require_once('validate_session.php');
?>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Delete A Request By Request ID</title>

    <!-- Importing Bootstrap CSS library https://getbootstrap.com/ -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>

<body>
    <div style="margin-top: 20px" class="container">
        <h1>DELETE REQUEST BY ID</h1>
        <!-- styling of the form for bootstrap https://getbootstrap.com/docs/4.5/components/forms/ -->
        <form action="DeleteRequest.php" method="post">

        <!--Here we ask the name of the anime -->
            <div class="form-group">
                <label for="Rrequest_ID">Enter request ID:</label>
                <input class="form-control" type="text" id="Rrequest_ID" name="Rrequest_ID">
            </div>

            <div class="form-group">
                <input class="btn btn-primary" name='Submit' type="submit" value="Submit">
            </div>
        </form>
        <div>
            <br>
            <a href="Front_Desk_Staff_Menu.php">Return To Staff Menu</a></br>
        </div>

        <!-- jQuery and JS bundle w/ Popper.js -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>


    <?php
        if (isset($_POST['Submit'])){
            //Takes the user input values into the variable $vType.
            $rid = isset($_POST['Rrequest_ID']) ? $_POST['Rrequest_ID'] : " ";

            $randNum = rand(0,2);
            if($randNum == 0){
                $staffID = 4003;
            }
            if($randNum == 1){
                $staffID = 4002;
            }
            if($randNum == 2){
                $staffID = 4001;
            }

            //Check if ID is a valid 4-digit ID
            if(is_numeric($rid)){
                //Gets query call select *from... from procedure.
                $sqlQuery = "CALL DeleteByRequest_ID('$rid', '$staffID')";
                if ($result = $conn->query($sqlQuery)) {
                    echo "<br> Request ID: '$rid' Deleted!";
                    echo "<br> Value '$rid' Found!";
                }
            }
            else{
                echo "<br> Failed To Delete Request '$rid'!";
                echo "<br> Value '$rid' Not Found!";
            }

            // To redirect the page to the student menu right after the query is executed, use the following statement
            // header("Location: student_menu.php");
}
?>
</body>
</html>
