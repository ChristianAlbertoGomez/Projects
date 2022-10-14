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
import java.util.ArrayList;

/**
 * CustomerRepository
 */
public class CustomerRepository implements Container{

    //Here we create an ArrayList where all customers from the csv file will be stored.
    /**
     * An ArrayList of customer.
     */
    public ArrayList<Customer> customers;

    //Empty Constructor

    /**
     * Empty Constructor
     */
    public CustomerRepository(){

    }
    //We create a Constructor that takes an ArrayList provided in the menu and store it here.

    /**
     * Constructor.
     * Method provided by Christian A. Gomez.
     * @param customersIn Customer list provided in the main.
     */
    public CustomerRepository(ArrayList<Customer> customersIn){
        this.customers = customersIn;
    }

    /**
     * MMethod provided by Christian A. Gomez.
     * @return CustomerIterator methods.
     */
    public CustomerIterator getMethod(){
        return new CustomersIterators();
    }

    //We create a private class to start overriding our methods.

    /**
     * Class provided by Christian A. Gomez.
     * A private class of CustomersIterators where we implements CustomerIterator methods
     */
    private class CustomersIterators implements CustomerIterator{
        int index;

        /**
         * Method provided by Christian A. Gomez.
         * This method will indicate if there exist an item next to the current item.
         * @return true or false.
         */
        @Override
        public boolean hasNext() {
            if(index<customers.size()){
                return true;
            }
            return false;
        }

        /**
         * Method provided by Christian A. Gomez.
         * This method will return the following customer.
         * @return customer.
         */
        @Override
        public Customer next() {
            if(this.hasNext()){
                return customers.get(index++);
            }
            return null;
        }

        /**
         * Method provided by Christian A. Gomez.
         * This method will take the current customer according to our position.
         * @return Customer.
         */
        @Override
        public Customer current() {
            return customers.get(index);
        }

        /**
         * Method provided by Christian A. Gomez.
         * This method will take the customer at certain position.
         * @param position position in the array list.
         * @return Customer.
         */
        @Override
        public Customer atPosition(int position) {
            return customers.get(position);
        }

        /**
         * Method provided by Christian A. Gomez.
         * This method will look for the customer by his name and last name.
         * @param name First name.
         * @param lastName Last name.
         * @return Customer position.
         */
        @Override
        public int findCustomer(String name, String lastName) {
            for(int i=0;i<customers.size();i++){
                if(customers.get(i).getFirstName().equals(name) && customers.get(i).getLastName().equals(lastName)){
                    return i;
                }
            }
            return -1;
        }

        /**
         * Method provided by Christian A. Gomez.
         * This method will tell us if the customer is a ticket miner or not.
         * @param position Position in the array list.
         * @return Yes or no.
         */
        @Override
        public String isTicketMiner(int position) {
            return customers.get(position).getTicketMiner();
        }

        /**
         * Method provided by Christian A. Gomez.
         * This method will collect all discount for the customer.
         * @param position Position in the array lost.
         * @param discount Total discount.
         */
        @Override
        public void collectTotalDiscounts(int position,double discount) {
            customers.get(position).collectTotalDiscounts(discount);
        }

        /**
         * Method provided by Christian A. Gomez.
         * This method will add tickets.
         * @param position Position in the array list.
         * @param ticket An instance of Ticket.
         */
        @Override
        public void addTicket(int position, Ticket ticket) {
            customers.get(position).addTickets(ticket);
        }

        /**
         * Method provided by Christian A. Gomez.
         * Method in charge to withdraw each time there is a purchase.
         * @param position Position in the array list.
         * @param amount total amount.
         */
        @Override
        public void withdraw(int position, double amount) {
            customers.get(position).withdraw(amount);
        }

        /**
         * Method provided by Christian A. Gomez.
         * This method is in charge to count the total concerts purchased.
         * @param position Position in the array list.
         */
        @Override
        public void totalConcerts(int position) {
            customers.get(position).totalConcerts();
        }

        /**
         * Method provided by Christian A. Gomez.
         * This method is in charge to display customer information.
         * @param position Position in the array list.
         */
        @Override
        public void displayInfo(int position) {
            System.out.println(customers.get(position));
        }

        /**
         * Method provided by Christian A. Gomez.
         * This method is in charge to display special information from the customer
         * @param position Position in the array list.
         */
        @Override
        public void adminAccess(int position) {
            System.out.println(customers.get(position).printCustomers());
        }

        /**
         * Method provided by Christian A. Gomez.
         * This method is in charge to help generate an Electronic ticket of the customer.
         * @param position Position in the array list.
         * @return A string with the special information with all the customer's tickets.
         */
        @Override
        public String electronicTicket(int position) {
            return customers.get(position).toString2();
        }

        /**
         * Method provided by Christian A. Gomez.
         * This method is in charge to check and display the exact balance from the customer.
         * @param position customer's position.
         * @return the total customer's balance.
         */
        @Override
        public double checkBalance(int position) {
            return customers.get(position).getBalance();
        }
    }
}