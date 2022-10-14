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
public interface CustomerIterator {
    /**
     * Method provided by Christian A. Gomez.
     * This method will indicate if there exist an item next to the current item.
     * @return true or false.
     */
    public boolean hasNext();

    /**
     * Method provided by Christian A. Gomez.
     * This method will return the following customer.
     * @return customer.
     */
    public Customer next();

    /**
     * Method provided by Christian A. Gomez.
     * This method will take the current customer according to our position.
     * @return Customer.
     */
    public Customer current();

    /**
     * Method provided by Christian A. Gomez.
     * This method will take the customer at certain position.
     * @param position position in the array list.
     * @return Customer.
     */
    public Customer atPosition(int position);

    /**
     * Method provided by Christian A. Gomez.
     * This method will look for the customer by his name and last name.
     * @param name First name.
     * @param lastName Last name.
     * @return Customer position.
     */
    public int findCustomer(String name,String lastName);

    /**
     * Method provided by Christian A. Gomez.
     * This method will tell us if the customer is a ticket miner or not.
     * @param position Position in the array list.
     * @return Yes or no.
     */
    public String isTicketMiner(int position);

    /**
     * Method provided by Christian A. Gomez.
     * This method will collect all discount for the customer.
     * @param position Position in the array lost.
     * @param discount Total discount.
     */
    public void collectTotalDiscounts(int position,double discount);

    /**
     * Method provided by Christian A. Gomez.
     * This method will add tickets.
     * @param position Position in the array list.
     * @param ticket An instance of Ticket.
     */
    public void addTicket(int position,Ticket ticket);

    /**
     * Method provided by Christian A. Gomez.
     * Method in charge to withdraw each time there is a purchase.
     * @param position Position in the array list.
     * @param amount total amount.
     */
    public void withdraw(int position,double amount);

    /**
     * Method provided by Christian A. Gomez.
     * This method is in charge to count the total concerts purchased.
     * @param position Position in the array list.
     */
    public void totalConcerts(int position);

    /**
     * Method provided by Christian A. Gomez.
     * This method is in charge to display customer information.
     * @param position Position in the array list.
     */
    public void displayInfo(int position);

    /**
     * Method provided by Christian A. Gomez.
     * This method is in charge to display special information from the customer
     * @param position Position in the array list.
     */
    public void adminAccess(int position);

    /**
     * Method provided by Christian A. Gomez.
     * This method is in charge to help generate an Electronic ticket of the customer.
     * @param position Position in the array list.
     * @return A string with the special information with all the customer's tickets.
     */
    public String electronicTicket(int position);

    /**
     * Method provided by Christian A. Gomez.
     * This method is in charge to check and display the exact balance from the customer.
     * @param position customer's position.
     * @return the total customer's balance.
     */
    public double checkBalance(int position);
}
