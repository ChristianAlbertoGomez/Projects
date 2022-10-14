<!--
/**
 * CS 4342 Database Management
 * @author Instruction team with contribution from L. Garnica and K. Apodaca
 * @version 2.0
 * Description: The purpose of these file is to provide PhP basic elements for an interface to access a DB. 
 * Resources: https://getbootstrap.com/docs/4.5/components/alerts/  -- bootstrap examples
 *
 * This file inserts a new record  into the table Student of your DB.
 * @Author Alan Verdin
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
    <title>Filter Requests By Visitor</title>

    <!-- Importing Bootstrap CSS library https://getbootstrap.com/ -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>

<body>
    <div style="margin-top: 20px" class="container">
        <h1>Filter Requests By Visitor</h1>
        <!-- styling of the form for bootstrap https://getbootstrap.com/docs/4.5/components/forms/ -->
        <form action="FilterByVisitorType.php" method="post">

        <!--Here we ask the name of the anime -->
            <div class="form-group">
                <label for="visitor_type">Enter vistor type:</label>
                <input class="form-control" type="text" id="visitor_type" name="visitor_type">
            </div>

            <div class="form-group">
                <input class="btn btn-primary" name='Submit' type="submit" value="Submit">
            </div>
        </form>
        
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

        <div class="form-group">
            <button type="button" class="btn btn-warning"><a href="Front_Desk_Report_Menu.php">Return To Report Menu</a></button>
        </div>

        <!-- jQuery and JS bundle w/ Popper.js -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
    
    
    <?php
        if (isset($_POST['Submit'])){
            //Takes the user input values into the variable $vType.
            $vType = isset($_POST['visitor_type']) ? $_POST['visitor_type'] : " ";
            

            //Values allowed:
            $valueList = array('Student', 'student', 'Faculty', 'faculty', 'Staff', 'staff', 'Guest', 'guest');
            
            //Checks if user input is in array list of options.
            if(in_array($vType, $valueList)){

                //Gets query call select *from... from procedure.
                $sqlQuery = "CALL getVisitorType('$vType')";
                if ($result = $conn->query($sqlQuery)) {

                    //Prints Data.
                    echo '<br/>';
                    ?>
                         <table class="table" width=50%>
                            <thead>
                            <td> ID</td>
                            <td> Type</td>
                            <td> Visitor</td>
                            <td> Status</td>
                            <td> Description</td>
                        </thead>
                        <tbody>
                            <?php
                             while ($row = $result->fetch_row()) {
                            ?>
                                <tr>
                                <td><?php printf("%s", $row[0]); ?></td>
                                <td><?php printf("%s", $row[1]); ?></td>
                                <td><?php printf("%s", $row[2]); ?></td>
                                <td><?php printf("%s", $row[3]); ?></td>
                                <td><?php printf("%s", $row[4]); ?></td>
                                </tr>
                            <?php
                         }
                         ?>
                    </tbody>
                    </table>
                    <?php
                    echo "<br> Successfully Filtered Request By '$vType'!";
                }
            }
            else{
                echo "<br> Failed To Filter Request By '$vType'!";
                echo "<br> Value '$vType' Not Found!";
            }

            // To redirect the page to the student menu right after the query is executed, use the following statement 
            // header("Location: student_menu.php");
}
?>
</body>
</html>