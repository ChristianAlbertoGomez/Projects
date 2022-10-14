<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>-----WELCOME TO WALMART------</h1>
    <h2>     -----SPRING PRODUCTS-----</h2>
    <h3>Sections:</h3>
    
    <form action="Supermarket.php" method="post">
        Please choose which one are you looking for:
        <input type="submit" name='fruit' value="fruit">
        <input type="submit" name='vegetable' value="vegetable">
    </form>

    <?php

    //OPEN FRUIT MENU
    if(isset($_POST['fruit'])){
        fruitMenu();
    }
    //OPEN VEGETABLE MENU
    if(isset($_POST['vegetable'])){
        vegetableMenu();
    }
    
    //EXECUTE FIND FRUIT
    if(isset($_POST['findFruit'])){
        echo "You selected the FIND FRUIT option!";
        $fruits = fruitTable();
        displayTable($fruits);

        enterFruitProduct();

    }

    //EXECUTE FIND VEGETABLE
    if(isset($_POST['findVegetable'])){
        echo "You selected the FIND VEGETABLE option!";
        $vegetables = vegetableTable();
        displayTable($vegetables);

        enterVegetableProduct();
    }
    //FIND THE FRUIT ACCORDING TO THE USER INPUT
    if(isset($_POST['userFruitProduct'])){
        $fruits = fruitTable();
        $product = $_POST['userFruitProduct'];
        foreach($fruits as $fruit){
            if($fruit['Name']==$product){
                echo "<br>";
                displayFruitOptions();
                echo "<br>";
                echo "This fruit is available: ".$fruit['Name']."<br>";

                $filepath = $fruit['path'];
                echo '<img src="'.$filepath.'">';
            }
            if( $fruit['ID']==$product){
                echo "<br>";
                displayFruitOptions();
                echo "<br>";
                echo "This fruit is available: ".$fruit['Name']."<br>";

                $filepath = $fruit['path'];
                echo '<img src="'.$filepath.'">';
            }
        }
    }

    //FIND THE VEGETABLE ACCORDING TO THE USER INPUT
    if(isset($_POST['userVegetableProduct'])){
        $vegetables = vegetableTable();
        $product = $_POST['userVegetableProduct'];
        foreach($vegetables as $vegetable){
            if($vegetable['Name']==$product){
                echo "<br>";
                displayVegetableOptions();
                echo "<br>";
                echo "This vegetable is available: ".$vegetable['Name']."<br>";

                $filepath = $vegetable['path'];
                echo '<img src="'.$filepath.'">';
            }
            if( $vegetable['ID']==$product){
                echo "<br>";
                displayVegetableOptions();
                echo "<br>";
                echo "This vegetable is available: ".$vegetable['Name']."<br>";

                $filepath = $vegetable['path'];
                echo '<img src="'.$filepath.'">';
            }
        }
    }

    /**The following section is to add a new Fruit. First we click the button add fruit, then ask the password. 
     * If the user enters the correct password then the system will allow him to add a new fruit.
     */
    if(isset($_POST['passwordFruit'])){
        $original_password = "1998";

        $inputPassword = $_POST['passwordFruit'];

        if($inputPassword==$original_password){
            $fruits = fruitTable();
            asort($fruits);
            displayTable($fruits);
    
            addFruitProduct();  
        }else{
            echo "Wrong password! Try again!";
            askFruitPassword();
        }
    }
    //HERE WE EXECUTE THE ADD FRUIT OPTION
    if(isset($_POST['addFruit'])){
        echo "You selected the ADD FRUIT option!";
        askFruitPassword();
    }
    //ONCE THE USER SUBMITTED THE NEW FRUIT THEN WE PUSH THE NEW FRUIT IN OUR TABLE
    if(isset($_POST['newFruit'])){
        $fruits = fruitTable();
        $product = $_POST['newFruit'];

        $newFruit = array('Name'=>$product,'Aliase'=>"N/A",'ID'=>rand(1000,9000));
        array_push($fruits,$newFruit);
        asort($fruits);
        echo "<h3>NEW TABLE</h3>";
        displayTable($fruits);
        displayFruitOptions();
    }
    /**The following section is to add a new Vegetable. First we click the button add vegetable, then ask the password. 
     * If the user enters the correct password then the system will allow him to add a new vegetable.
     */
    if(isset($_POST['passwordVegetable'])){
        $original_password = "1998";

        $inputPassword = $_POST['passwordVegetable'];

        if($inputPassword==$original_password){
            $vegetables = vegetableTable();
            asort($vegetables);
            displayTable($vegetables);
    
            addVegetableProduct();  
        }else{
            echo "Wrong password! Try again!";
            askVegetablePassword();
        }
    }
     //HERE WE EXECUTE THE VEGETABLE FRUIT OPTION
    if(isset($_POST['addVegetable'])){
        echo "You selected the ADD VEGETABLE option!";
        askVegetablePassword();
    }
     //ONCE THE USER SUBMITTED THE NEW VEGETABLE THEN WE PUSH THE NEW FRUIT IN OUR TABLE
    if(isset($_POST['newVegetable'])){
        $vegetables = vegetableTable();
        $product = $_POST['newVegetable'];

        $newVegetable = array('Name'=>$product,'Aliase'=>"N/A",'ID'=>rand(1000,9000));
        array_push($vegetables,$newVegetable);
        asort($vegetables);
        echo "<h3>NEW TABLE</h3>";
        displayTable($vegetables);
        displayVegetableOptions();
    }

    //THIS SECTION WILL BE FOR "EDIT" BUTTON FRUIT
    if(isset($_POST['editFruit'])){
        echo "You selected EDIT FRUIT option!";
        editFruit();
    }
    //HERE WE EXECUTE THE ASLIASE => PUT A SECOND NAME TO AN ACTUAL FRUIT
    if(isset($_POST['aliasesFruit'])){
        $actualFruit = $_POST['actualFruitName'];
        $newFruit = $_POST['newFruitName'];
        $fruits = fruitTable();

        aliasesFruitMethod($actualFruit,$newFruit,$fruits);
    }
    //THIS SECTION WILL BE FOR "EDIT" BUTTON VEGETABLE
    if(isset($_POST['editVegetable'])){
        echo "You selected EDIT VEGETABLE option!";
        editVegetable();
    }
    //HERE WE EXECUTE THE ASLIASE => PUT A SECOND NAME TO AN ACTUAL VEGETABLE
    if(isset($_POST['aliasesVegetable'])){
        $actualVegetable = $_POST['actualVegetableName'];
        $newVegetable = $_POST['newVegetableName'];
        $vegetables = vegetableTable();

        aliasesVegetableMethod($actualVegetable,$newVegetable,$vegetables);
    }

    /*HERE IS THE FRUIT MENU*/
    function fruitMenu(){
        echo "--------Welcome to fruit section--------";
        $fruits = fruitTable();
        asort($fruits);
        displayTable($fruits);
        echo "<h2>WHAT DO YOU WANT TO DO?</h2>";
        displayFruitOptions();
    }
    /**
     * Here we create the fruit content from the supermarket.
     */
    function fruitTable(){
        $fruitsTable = array(array('Name'=>"Apple",'Aliase'=>"N/A",'ID'=>1234,'path'=>"https://static.turbosquid.com/Preview/001327/095/GY/_600.jpg"),
                        array('Name'=>"Banana",'Aliase'=>"N/A",'ID'=>5678,'path'=>"https://media.istockphoto.com/photos/banana-bunch-picture-id173242750?k=20&m=173242750&s=612x612&w=0&h=dgXrAP6otDeY5h6fhy-SRmW-2dFOCKx1_hNS1lLWF7Y="),
                        array('Name'=>"Watermelon",'Aliase'=>"N/A",'ID'=>91011,'path'=>"https://images.heb.com/is/image/HEBGrocery/000583329?fit=constrain,1&wid=800&hei=800&fmt=jpg&qlt=85,0&resMode=sharp2&op_usm=1.75,0.3,2,0"),
                        array('Name'=>"Orange",'Aliase'=>"N/A",'ID'=>1213,'path'=>"https://media.istockphoto.com/photos/orange-picture-id185284489?k=20&m=185284489&s=612x612&w=0&h=LLY2os0YTG2uAzpBKpQZOAC4DGiXBt1jJrltErTJTKI="),
                        array('Name'=>"Mandarina",'Aliase'=>"N/A",'ID'=>1415,'path'=>"https://elpoderdelconsumidor.org/wp-content/uploads/2016/11/mandarina.jpg"),
                        array('Name'=>"Pera",'Aliase'=>"N/A",'ID'=>1617,'path'=>"https://static.wixstatic.com/media/a7dee3_4c558736f7b243329c59427d855d278c~mv2.jpg/v1/fill/w_1000,h_1000,al_c,q_90/a7dee3_4c558736f7b243329c59427d855d278c~mv2.jpg"));
        return $fruitsTable;
    }
     /*HERE IS THE FRUIT MENU*/
    function vegetableMenu(){
        echo "--------Welcome to vegetable section--------";
        $vegetables = vegetableTable();
        displayTable($vegetables);
        echo "<h2>WHAT DO YOU WANT TO DO?</h2>";
        displayVegetableOptions();
    }
    /**
     * Here we create the vegetable content from the supermarket.
     */
    function vegetableTable(){
        $vegetablesTable = array(array('Name'=>"Lechuga",'Aliase'=>"N/A",'ID'=>4321,'path'=>"https://www.smartnfinal.com.mx/wp-content/uploads/2017/09/propiedades-de-la-lechuga.jpg"),
                        array('Name'=>"Tomate",'Aliase'=>"N/A",'ID'=>8765,'path'=>"https://www.ngenespanol.com/wp-content/uploads/2018/08/Dato-del-d%C3%ADa-Tomates-1280x720.jpg"),
                        array('Name'=>"Zanahoria",'Aliase'=>"N/A",'ID'=>6666,'path'=>"https://elpoderdelconsumidor.org/wp-content/uploads/2021/05/zanahorias.png"),
                        array('Name'=>"Rabano",'Aliase'=>"N/A",'ID'=>5489,'path'=>"https://t1.ev.ltmcdn.com/es/posts/9/4/9/problemas_en_el_crecimiento_de_los_rabanos_949_600.jpg"),
                        array('Name'=>"Espinaca",'Aliase'=>"N/A",'ID'=>9187,'path'=>"https://walmartar.vteximg.com.br/arquivos/ids/844933-1000-1000/Espinaca-En-Paquete-X-500-Gr-1-16633.jpg?v=636891453478170000"),
                        array('Name'=>"Pepino",'Aliase'=>"N/A",'ID'=>7856,'path'=>"https://www.chedraui.com.mx/medias/2502954-00-CH1200Wx1200H?context=bWFzdGVyfHJvb3R8MTI5MzY2fGltYWdlL2pwZWd8aDgyL2gwMi85OTYxMzY4Mzg3NjE0LmpwZ3xjMTljNzhmNGQwNzUwOWViMmFjMjZmYTZmMjJlM2I3NjVlNjA5ODcwN2Y5YzQyZWZkMDUxMDQwM2Q5MTdlMDIz"));
        return $vegetablesTable;
    }
    ?>
    
    <?php
    /**
     * This method will be in charge to display the contents from an array. Example: $storage cand be the fruit table or vegetable table.
     */
    function displayTable($storage){
        echo "<table><tr><td>PRODUCT</td><td>ALIASE</td><td>ID</td></tr>";
        foreach($storage as $product){
            echo "<tr><td>".$product['Name']."</td><td>".$product['Aliase']."</td><td>".$product['ID']."</td></tr>";
        }
    }
    ?>

    <?php
    /**
     * Method to display options once the user is in the Fruit section
     */
    function displayFruitOptions(){
        echo '<form action="Supermarket.php" method="post">
         <input type="submit" name="findFruit" value="find fruit">
         <input type="submit" name="addFruit" value="add fruit">
         <input type="submit" name="editFruit" value="edit fruit">
         </form><br/>';
    }
    ?>
    <?php
    /**
     * Method to display options once the user is in the Vegetable section
     */
    function displayVegetableOptions(){
        echo '<form action="Supermarket.php" method="post">
         <input type="submit" name="findVegetable" value="find vegetable">
         <input type="submit" name="addVegetable" value="add vegetable">
         <input type="submit" name="editVegetable" value="edit vegetable">
         </form><br/>';
    }
    ?>

    <?php
    /**
     * Method to display a button to enter which fruit the user wants to see.
     */
    function enterFruitProduct(){
        echo '<form action="Supermarket.php" method="post">
        Please enter NAME or ID of your product:
        <input type="text" name="userFruitProduct" id="">
        <input type="submit" value="Enter">
        </form>';
    }
    ?>

    <?php
    /**
     * Method to display a button to enter which vegetable the user wants to see.
     */
    function enterVegetableProduct(){
        echo '<form action="Supermarket.php" method="post">
        Please enter NAME or ID of your product:
        <input type="text" name="userVegetableProduct" id="">
        <input type="submit" value="Enter">
        </form>';
    }
    ?>

    <?php
    /**
     * Method to display a button to enter a new fruit in the table
     */
    function addFruitProduct(){
        echo '<form action="Supermarket.php" method="post">
        Please enter a new fruit:
        <input type="text" name="newFruit" id="">
        <input type="submit" value="Enter">
        </form>';
    }
    ?>

    <?php
    /**
     * Method to display a button to enter a new vegetable in the table
     */
    function addVegetableProduct(){
        echo '<form action="Supermarket.php" method="post">
        Please enter a new vegetable:
        <input type="text" name="newVegetable" id="">
        <input type="submit" value="Enter">
        </form>';
    }
    ?>

    <?php
    /**
     * Method to display a box where the user has to enter a password to add a new fruit.
     */
    function askFruitPassword(){
        echo '<form action="Supermarket.php" method="post">
        Please enter a password:
        <input type="password" name="passwordFruit" id="">
        <input type="submit" value="Enter">
        </form>';
    }
    ?>

    <?php
    /**
     * Method to display a box where the user has to enter a password to add a new vegetable.
     */
    function askVegetablePassword(){
            echo '<form action="Supermarket.php" method="post">
            Please enter a password:
            <input type="password" name="passwordVegetable" id="">
            <input type="submit" value="Enter">
            </form>';
        }
    ?>

    <?php
    /**
     * Method to display boxes where to put a new aliase to a fruit
     */
    function editFruit(){
        echo '<form action="Supermarket.php" method="post">
        Please enter the fruit you want to Aliase:
        <input type="text" name="actualFruitName" id="">
        <br/>
        Please enter the new fruit you want:
        <input type="text" name="newFruitName" id="">
        <br/>
        <input type="submit" name="aliasesFruit" value="Aliases">
        </form>';
    }
    /**
     * Method to display boxes where to put a new aliase to a vegetable
     */
    function editVegetable(){
        echo '<form action="Supermarket.php" method="post">
        Please enter the vegetable you want to Aliase:
        <input type="text" name="actualVegetableName" id="">
        <br/>
        Please enter the new vegetable you want:
        <input type="text" name="newVegetableName" id="">
        <br/>
        <input type="submit" name="aliasesVegetable" value="Aliases">
        </form>';
    }

    ?>

    <?php
    /**
     * Method in charge to do all the process of aliase in one fruit.
     */
    function aliasesFruitMethod($actualFruit,$newFruit,$fruits){
        echo "<table><tr><td>PRODUCT</td><td>ALIASE</td><td>ID</td></tr>";
        foreach($fruits as $fruit){
            if($fruit['Name']==$actualFruit){
                $fruit['Aliase'] = $newFruit;
                echo "<tr><td>".$fruit['Name']."</td><td>".$fruit['Aliase']."</td><td>".$fruit['ID']."</td></tr>"."<br>";
            }else{
                echo "<tr><td>".$fruit['Name']."</td><td>".$fruit['Aliase']."</td><td>".$fruit['ID']."</td></tr>"."<br>";
            }
        }
    }
    /**
     * Method in charge to do all the process of aliase in one vegetable.
     */
    function aliasesVegetableMethod($actualVegetable,$newVegetable,$vegetables){
        echo "<table><tr><td>PRODUCT</td><td>ALIASE</td><td>ID</td></tr>";
        foreach($vegetables as $vegetable){
            if($vegetable['Name']==$actualVegetable){
                $vegetable['Aliase'] = $newVegetable;
                echo "<tr><td>".$vegetable['Name']."</td><td>".$vegetable['Aliase']."</td><td>".$vegetable['ID']."</td></tr>"."<br>";
            }else{
                echo "<tr><td>".$vegetable['Name']."</td><td>".$vegetable['Aliase']."</td><td>".$vegetable['ID']."</td></tr>"."<br>";
            }
        }
    }
    ?>

</body>
</html>