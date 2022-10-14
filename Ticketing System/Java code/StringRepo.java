import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ->Author:Christian Alberto Gomez and Victor Herrera.
 * ->Date: 11/19/21
 * ->Course: CS-3331
 * ->Instructor: Daniel Mejia
 * ->Programming Assignment 5.
 *
 * ->Lab Description:
 *   -You have recently been hired to work for the TicketMiner, a company that sells tickets for sporting events,
 *   concerts,special events,etc. You have a few customers thar are interested in creating their events using your
 *   system.
 *
 * ->By means of this communication I swear that all the program/code written here
 *   came from me and was not copied or stolen from any other student or internet user.
 *   Also, by this communication I confirm that I did not request or use
 *   any type of prohibited assistance for this assignment.
 *
 *   Class StringRepo designated to retrieve default message that will be used by the RunTickeMiner Class
 */
public class StringRepo {
    private String errorMessage;
    /**
     * Default Constructor.
     * **/
    public StringRepo(){

    }
    /**
     * Constructor
     * @param
     * errorMessage;
     * **/
    public StringRepo(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    /**
     * @return returns message
     * **/
    public String getErrorMessage() {
        return errorMessage;
    }
    /**
     * @param errorMessage
     * updates the value of error message.
     * **/

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    /**
     * Method provided  by Victor Herrera
     * @return input
     * return string designated message
     * **/
    public String  messageError(){
        String input = "Expecting an integer Value received invalid input";
        return input;
    }
    /**
     * Method provided  by Victor Herrera
     * @return info
     * return string designated message
     * **/
    public String messageInfo(){
        String info = "Please enter the number of tickets you want:";
        return info;
    }
    /**
     * Method provided  by Victor Herrera
     * @return menu
     * return string designated message
     * **/
    public String menuMessage(){
        String menu = "To return to Login Menu enter 7";
        return menu;
    }
    /**
     * Method provided  by Victor Herrera
     * @return StartMenu
     * return string designated message
     * **/
    public String startMenuMessage(){
        String startMenu = "To return to Main Menu enter 8";
        return startMenu;
    }
    /**
     * Method provided  by Victor Herrera
     * @return mainMenu
     * return string
     * **/
    public String returningMainMenu(){
        String mainMenu ="Refreshing......Returning to Main Menu....";
        return mainMenu;
    }
    /**
     * Method provided  by Victor Herrera
     * @return mainMenu
     * return string
     * **/

    public String mainMenuLogIn(){
        String menuLog = "To return to Main Menu enter: (M)";
        return menuLog;
    }
    /**
     * Method provided  by Victor Herrera
     * @return last
     * returns designated message for error in RunTicketMiner
     * **/
    public String lastNameMessage(){
        String last ="The Last Name is not in the system or  does not match our records please enter correct last name again";
        return last;
    }
    /**
     * Method provided  by Victor Herrera
     * @return userName
     * returns designated message for error in RunTicketMiner
     * **/
    public String userNameMessage(){
        String userName ="Incorrect UserName or username does not match our records please enter correct User Name";

        return userName;
    }
    /**
     * Method provided  by Victor Herrera
     * @return firstName
     * returns designated message for error in RunTicketMiner
     * **/
    public String firstNameMessage(){
        String firstName ="The First Name is not in System or does not match our records please enter correct first name";
        return firstName;
    }
    /**
     * Method provided  by Victor Herrera
     * @return error
     * returns designated message for error in RunTicketMiner
     * **/
    public String stringErrorMessage(){
        String error = "You have entered invalid entry please try again";
        return error;
    }
    /**
     * Method provided  by Victor Herrera
     * @return option
     * returns designated message for error in RunTicketMiner
     * **/
    public String menuOptions(){
        String option = "Enter:(0) To return to Main Menu";
        return option;

    }
    /**
     * Method provided  by Victor Herrera
     * @return option
     * returns designated message for error in RunTicketMiner
     * **/
    public String exceededInput(){
        String exceed = "You have exceeded invalid inputs returning to Main Menu........";
        return exceed;
    }

    /**
     * Method provided by Victor Herrera
     * @return Login.
     */
    public String enterOptionForLogIn(){
        String logIn = "Enter 11 to return to customer Login Menu";
        return logIn;
    }
    /**
     * Method provided by Victor Herrera
     * @return Login.
     */
    public String returningToLogIn(){
        String returnLogin = "Returning to Customer Login Menu.........";
        return returnLogin;
    }

    /**
     * Method provided by Victor Herrera
     * @return customer Login window.
     */
    public String customerLoginWindow(){
        String window = "To go back enter(L)";
        return window;
    }
}