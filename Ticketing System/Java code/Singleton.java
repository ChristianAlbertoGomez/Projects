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
public class Singleton {
    /**
     * Private constructor
     **/
    private Singleton() {
    }

    /**
     * Creating an instance of the class
     **/
    public static final Singleton singleInstance = new Singleton();

    /**
     * Global access point of the instance
     * @return something.
     **/
    public static Singleton getInstance() {
        return singleInstance;
    }
    /**
     * Method provided by Victor Herrera
     * Will be used to intance to print string values to screen.
     * @param input String input.
     * @return input
     * Returns input passed to parameter
     * **/
    public String printMessage(String input) {
        System.out.println(input);
        return input;
    }
}
