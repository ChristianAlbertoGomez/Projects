/**
 * ->Author:Christian Alberto Gomez and Victor Herrera.
 * ->Date: 11/21/2021
 * ->Course: CS-3331
 * ->Instructor: Daniel Mejia
 * ->Programming Assignment 5.
 *
 * ->Lab Description:
 *   -You have recently been hired to work for the TicketMiner, a company that sells tickets for sporting events,
 *   concerts,special events,etc. You have a few customer's thar are interested in creating their events using your
 *   system.
 *
 * ->By means of this communication I swear that all the program/code written here
 *   came from me and was not copied or stolen from any other student or internet user.
 *   Also, by this communication I confirm that I did not request or use
 *   any type of prohibited assistance for this assignment.
 */
public class HandleIdException extends Exception{
    private String message;

    /**
     * Constructor for HandleIdException.
     * @param message1 exception messsage.
     */
    public HandleIdException(String message1) {

        this.message = message1;
    }

    /**
     * Display message information.
     * @return Exception message.
     */
    public String getMessage() {
        return message;
    }
    /**
     * Method Provided by Victor Herrera
     * Method is designed to check the event ids.
     * User enters invalid Id exception is handled.
     * @return a
     * return valid Id type.
     * **/
    public int eventId(int a) throws HandleIdException {

        if (a<1||a >71) {
            throw new HandleIdException("Id Entered does not exist Enter Valid Id");
        } else {
            return a;
        }
    }

    /**
     * This method is in charge to check if the corresponding purchase fits with the range of tickets
     * allowed by the system.
     * @param b number of tickets.
     * @return number of tickets
     * @throws HandleIdException Throw and exception if there are more than 6 tickets or less than 2 tickets.
     */
    public int numTicketsPurchase(int b) throws HandleIdException{
        if(b<2||b>6){
            throw new HandleIdException("You can only purchase 2 to 6 tickets");
        }else{
            return b;
        }
    }

    /**
     * Method in charge to provide some information about the exception.
     * @param a input
     * @return something
     * @throws HandleIdException if there is an error.
     */
    public int checkInput(int a) throws HandleIdException{
        if(((Object)a).getClass().getSimpleName()!=((Object)a).getClass().getSimpleName()){

            System.out.println("error");
        }
        return 0;
    }
    /**
     * Method provided by Victor Herrera
     * Throws exception when an input exceeds designated number.
     * @return a
     * returns the value of when correct.
     *
     * **/
    public int checkMultipleUsers(int a)throws HandleIdException{
        if (a<1||a >10) {
            throw new HandleIdException("Exceeds number of users at once.");
        } else {
            return a;
        }
    }
}
