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
public interface DateChecker {
    /**
     * Method provided by this interface to check if the input is valid or not.
     * Method provided by Victor Herrera.
     * @param dateStr String with a date.
     * @return true or false.
     */
    boolean isValid(String dateStr);

    /**
     * Method provided by Victor Herrera
     * @param eventDate eventd Date
     * @param s String format
     * @return true or false.
     */
    boolean isDatePast(String eventDate, String s);
}
