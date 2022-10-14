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
public class AutoPurchase{
    private String firstName;
    private String lastName;
    private String action;
    private int eventID;
    private String eventName;
    private int ticketQuantity;
    private String ticketType;

    /**
     * Empty constructor
     */
    public AutoPurchase(){

    }

    /**
     * AutoPurchase Constructor.
     * @param firstNameIn Name of the customer.
     * @param lastNameIn Last name of the customer.
     * @param actionIn Buy
     * @param eventIDIn Event ID interested
     * @param eventNameIn Event Name interested
     * @param ticketQuantityIn number of tickets the customer wants to purchase
     * @param ticketTypeIn type of ticket such as vip,gold,silver,etc.
     */
    public AutoPurchase(String firstNameIn,String lastNameIn,String actionIn,int eventIDIn,String eventNameIn,
                        int ticketQuantityIn,String ticketTypeIn){
        this.firstName = firstNameIn;
        this.lastName = lastNameIn;
        this.action = actionIn;
        this.eventID = eventIDIn;
        this.eventName = eventNameIn;
        this.ticketQuantity = ticketQuantityIn;
        this.ticketType = ticketTypeIn;
    }
    //Setters and Getters

    /**
     * Method provided by Christian A. Gomez.
     * Getter for the first name of the customer.
     * @return customer's name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method provided by Christian A. Gomez.
     *  setter for the fist name of the customer.
     * @param firstName set customer's name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter for the last name of the customer.
     * @return customer's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter for the last name of the customer.
     * @param lastName Set customer's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method provided by Christian A. Gomez.
     *  Getter for the type of action from the customer.
     * @return customer's action.
     */
    public String getAction() {
        return action;
    }

    /**
     * Method provided by Christian A. Gomez.
     *  Setter for the type of action from the customer.
     * @param action Set customer's action.
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter for the event ID that the customer is interested.
     * @return event ID.
     */
    public int getEventID() {
        return eventID;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter for the event ID that the customer is interested.
     * @param eventID Set event ID.
     */
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter for the event name that the customer is interested.
     * @return event name.
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter for the event name that the customer is interested.
     * @param eventName Set event name.
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter for the ticket quantity from the event that the customer is interested.
     * @return ticket quantity.
     */
    public int getTicketQuantity() {
        return ticketQuantity;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter for the ticket quantity from the event that the customer is interested.
     * @param ticketQuantity Set ticket quantity
     */
    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter for the ticket type from the event that the customer is interested.
     * @return ticket type
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter for the ticket type from the event that the customer is interested.
     * @param ticketType Set ticket type
     */
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    //toString() method

    /**
     * Method provided by Christian A. Gomez.
     * toString() will be in charge to display the information from this class.
     * @return information from this class.
     */
    @Override
    public String toString() {
        return "AutoPurchase{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", action='" + action + '\'' +
                ", eventID=" + eventID +
                ", eventName='" + eventName + '\'' +
                ", ticketQuantity=" + ticketQuantity +
                ", ticketType='" + ticketType + '\'' +
                '}';
    }
}