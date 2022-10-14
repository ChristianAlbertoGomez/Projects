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
import java.util.Arrays;

/**
 * CUSTOMER CLASS WORKS AND USES AGGREGATION WITH TICKET CLASS
 */
public class Customer implements CustomerInterface{
    //Attributes
    private int customerID;
    private String firstName;
    private String lastName;
    private double balance;
    private int totalConcertsPurchased;
    private String ticketMiner;
    private String userName;
    private String password;
    private Ticket ticket;

    private final Ticket[] tickets = new Ticket[500];
    private int size = 0;
    //6 DE OCTUBRE!!!
    private double totalDiscount;

    //Constructors

    /**
     * Empty constructor
     */
    public Customer() {

    }

    /**
     * Constructor for Customer.
     * @param customerIdIn Customer ID.
     * @param firstNameIn Customer Name.
     * @param lastNameIn Customer Last Name.
     * @param balanceIn Customer total money.
     * @param totalConcertsPurchasedIn Customer total purchased tickets.
     * @param ticketMinerIn Is customer a ticketMiner?
     * @param userNameIn Customer Username.
     * @param passwordIn Customer Password.
     */
    public Customer(int customerIdIn, String firstNameIn, String lastNameIn, double balanceIn,
                    int totalConcertsPurchasedIn, String ticketMinerIn, String userNameIn, String passwordIn) {

        this.customerID = customerIdIn;
        this.firstName = firstNameIn;
        this.lastName = lastNameIn;
        this.balance = balanceIn;
        this.totalConcertsPurchased = totalConcertsPurchasedIn;
        this.ticketMiner = ticketMinerIn;
        this.userName = userNameIn;
        this.password = passwordIn;
    }

    /**
     * Customer's constructor.
     * @param firstNameIn customer's first name.
     * @param lastNameIn Customer's last name.
     */
    public Customer(String firstNameIn,String lastNameIn){
        this.firstName = firstNameIn;
        this.lastName = lastNameIn;
    }
    //Setters and Getters
////////////////////////////////////////////////////

    /**
     * Method provided by Christian A. Gomez.
     * Getter for the total of tickets the user purchased.
     * @return all the tickets.
     */
    public Ticket[] getTickets() {
        return tickets;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method in charge to keep adding tickets each time the customer do a purchase.
     * @param ticket Customer's ticket.
     */
    public void addTickets(Ticket ticket){
        this.tickets[this.size] = ticket;
        this.size++;
    }
    ////////////////////////////////////////////////////
    /**
     * Method provided by Christian A. Gomez.
     * Getter for Customer ID.
     * @return customer ID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter for Customer ID.
     * @param customerID set/store Customer ID.
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter for Customer's first name.
     * @return customer's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter for Customer's first name.
     * @param firstName set/store Customer's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter for Customer's last name.
     * @return customer's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter for customer's last name.
     * @param lastName customer's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Get the balance/total money from the customer.
     * @return total balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Set the total balance of the customer.
     * @param balance set total balance.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Get the total purchased tickets from the Customer.
     * @return total purchased tickets.
     */
    public int getTotalConcertsPurchased() {
        return totalConcertsPurchased;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Set a total of purchased tickets from the customer.
     * @param totalConcertsPurchased total purchased tickets.
     */
    public void setTotalConcertsPurchased(int totalConcertsPurchased) {
        this.totalConcertsPurchased = totalConcertsPurchased;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter to check if the customer is TicketMiner.
     * @return ticketMiner;
     */
    public String getTicketMiner() {
        return ticketMiner;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter to customer if ticketMiner.
     * @param ticketMiner is a ticketMiner? Yes? or No?
     */
    public void setTicketMiner(String ticketMiner) {
        this.ticketMiner = ticketMiner;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Get the customer's username.
     * @return username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Set the customer's username.
     * @param userName customer's username.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Get the customer's password.
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Set a password to the customer.
     * @param password customer's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Get the customer's ticket.
     * @return Customer's ticket.
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Set the customer's ticket.
     * @param ticketIn customer's ticket.
     */
    public void setTicket(Ticket ticketIn) {
        this.ticket = ticketIn;
    }

    //6 DE OCTUBRE
    /**
     * Method provided by Christian A. Gomez.
     * Getter for the total discount collected for each customer.
     * @return total discount collected.
     */
    public double getTotalDiscount() {
        return totalDiscount;
    }

    //Methods
    /**
     * Method provided by Christian A. Gomez.
     * Method to withdraw an amount of money from the customer's balance.
     * @param amount amount that will be subtracted from the balance.
     */
    public void withdraw(double amount){
        balance-=amount;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method to check if the customer has enough money to buy tickets.
     * @return True or False.
     */
    public boolean checkBalance(){
        return getBalance() > 0;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method to add 1 each time the customer buy a new ticket.
     */
    public void totalConcerts(){
        totalConcertsPurchased++;
    }

    //6 DE OCTUBRE!!

    /**
     * Method provided by Christian A. Gomez.
     * Method in charge to calculate and collect each discount that the customer receives.
     * @param discount discounts collected for each customer.
     */
    @Override
    public void collectTotalDiscounts(double discount) {
        totalDiscount+=discount;
    }
    //toString()
    /**
     * Method provided by Christian A. Gomez.
     * Method to print/display the customer's information.
     * @return Customer's infomration.
     */
    @Override
    public String toString() {
        return "Customer:" +
                "customerID:" + getCustomerID() +
                ", firstName:'" + getFirstName() + '\'' +
                ", lastName:'" + getLastName() + '\'' +
                ", balance:" + getBalance() +"\n";
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that display the basic information from a customer to the administrator.
     * @return A string with all the customer's information.
     */
    public String printCustomers() {
        return "\t->ID:"+getCustomerID()+"\t-> Name::"+getFirstName()+" "+getLastName()+
                "\t->Balance:"+getBalance()+"\t->concert Purchased:"+getTotalConcertsPurchased()+
                "\t->Username:"+getUserName()+"\t ->Discounts collected:"+getTotalDiscount();
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method taht will display all the important information from the customer such as all the tickets that the
     * customer purchased and all that stuff.
     * @return Customer's important information.
     */
    public String toString2() {
        return "Customer:" +
                "customerID:" + getCustomerID() +
                ", firstName:'" + getFirstName() + '\'' +
                ", lastName:'" + getLastName() + '\'' +
                ", balance:" + getBalance() +"\n"+
                Arrays.toString(tickets);
    }
}
