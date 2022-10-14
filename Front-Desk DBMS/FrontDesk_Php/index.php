<!--
/**
 * CS 4342 Database Management
 * @author Instruction team Spring and Fall 2020 with contribution from L. Garnica
 * @version 2.0
 * Description: The purpose of these file is to provide PhP basic elements for an interface to access a DB. 
 * Resources: https://getbootstrap.com/docs/4.5/components/alerts/  -- bootstrap examples
 * Include your name here - ex. Modified by Villanueva for Assignment 2
 */


 CODE AUTHORS: Christian Gomez & Alan Verdin
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
    
    <h1>Front Desk Menu</h1>
    <h2>Staff Login</h2>
    <form action="index.php" method="post">
      <div class="form-group">
        <label for="username">User Name</label>
        <input class="form-control" type="text" id="username" name="username">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input class="form-control" type="password" id="password" name="password">
      </div>
      <div class="form-group">
        <input class="btn btn-primary" name='Submit' type="submit" value="Submit">
      </div>

    </form>
    <!--<a href="create_user.php">Don't have an account? Create one now!</a><br><br> -->

   <!-- <a href="Front_Desk_Menu.php">Enter Visitor Menu</a> -->

   <div class = "container">
      <div class="horizontal-center">
       <button type="button" class="btn btn-warning"><a href="Front_Desk_Menu.php">Enter Visitor Menu</a></button>
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
    
  </div>
    
  </div>

  <!-- jQuery and JS bundle w/ Popper.js -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


</body>

</html>


<?php

session_start();
require_once("config.php");
$_SESSION['logged_in'] = false;

if (!empty($_POST)) {
  if (isset($_POST['Submit'])) {
    $input_username = isset($_POST['username']) ? $_POST['username'] : " ";
    $input_password = isset($_POST['password']) ? $_POST['password'] : " ";

    $queryUser = "SELECT * FROM User  WHERE Uusername='" . $input_username . "' AND UPassword='" . $input_password . "';";
    $resultUser = $conn->query($queryUser);

    if ($resultUser->num_rows > 0) {
      //if there is a result, that means that the user was found in the database
      $_SESSION['user'] = $input_username;
      $_SESSION['logged_in'] = true;
      
      echo "Session logged_in is: ".$_SESSION['logged_in'];
      
      // You can comment the next line (header) to check if the user was successfully logged in. 
      // But it will not redirect to the student_menu file automatically.
      //header("Location: testingMenu.php");
      header("Location: Front_Desk_Staff_Menu.php");
    } else {
      echo "User not found.";
    }
    die();
  }
}
?>