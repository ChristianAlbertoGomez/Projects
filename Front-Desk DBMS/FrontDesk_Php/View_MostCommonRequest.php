<!--
/**
 * CS 4342 Database Management
 * @author Instruction team Spring and Fall 2020 with contribution from L. Garnica
 * @version 2.0
 * Description: The purpose of these file is to provide PhP basic elements for an interface to access a DB. 
 * Resources: https://getbootstrap.com/docs/4.5/components/alerts/  -- bootstrap examples
 *
 * This file retrieves and displays the records of the table Student.
 *
 * AUTHOR CODE: Christian Gomez & Alan Verdin
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

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Importing Bootstrap CSS library https://getbootstrap.com/ -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>

<body>
    <div style="margin-top: 20px" class="container">
        <h1>MOST COMMON REQUEST DESCRIPTION REPORT</h1>
        <!-- styling of the form for bootstrap https://getbootstrap.com/docs/4.5/components/forms/ -->
        <form action="View_MostCommonRequest.php" method="post">

            <div class="form-group">
                <label>Most Common Request Description Shown Below:<label>
            </div>

        <?php $sql = "SELECT * FROM Most_Common_Request";
        if ($result = $conn->query($sql)) {
        ?>
        
        <table class="table" width=50%>
            <thead>
                <td> Request Description</td>
                <td> Frequency</td>
            </thead>
            <tbody>
                <?php
                while ($row = $result->fetch_row()) {
                ?>
                    <tr>
                    <td><?php printf("%s", $row[0]); ?></td>
                        <td><?php printf("%s", $row[1]); ?></td>
                    </tr>
                <?php
                }
                ?>
            </tbody>
        </table>
    <?php
    }
    ?>
   

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

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>