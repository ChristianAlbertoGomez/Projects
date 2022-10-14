import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Here we have all the test methods.
 */
public class TestMethods {

    //Here we are going to test many methods.
    //Many methods will be from the customer since we are testing the Iterator Design Pattern.
    /**
     * Test method provided by Christian A. Gomez.
     */
    @Test
    public void test1(){
        //First we create many customers.
        Customer customer1 = new Customer(65,"Christian","Gomez",5000,0,"true","cagomez15","alucard345");
        Customer customer2 = new Customer(32,"Abril","Gomez",5000,0,"true","agomez19","abrilCa15");
        Customer customer3 = new Customer(1,"Amairani","Garza",18000,0,"false","amablitz","UHNANANA");
        Customer customer4 = new Customer(120,"Hercules","Disney",20000,0,"false","HerculesSemiDios","Olimpo99");
        Customer customer5 = new Customer(100,"Hades","Disney",105000,0,"true","ReyDelInframundo","Hell345");
        Customer customer6 = new Customer(5,"Mickey","Mouse",123456,0,"true","DisneyWorld","WaltDisney1978");

        //Now we store them into an ArrayList of Customer
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);

        //We use the customerRepository. This uses the Iterator Design Pattern.
        CustomerRepository customerRepository = new CustomerRepository(customers);
        int position = customerRepository.getMethod().findCustomer("Hades","Disney");
        assertEquals(4,position);
    }

    /**
     * Test method provided by Christian A. Gomez.
     */
    @Test
    public void test2(){
        //First we create many customers.
        Customer customer1 = new Customer(65,"Christian","Gomez",5000,0,"true","cagomez15","alucard345");
        Customer customer2 = new Customer(32,"Abril","Gomez",5000,0,"true","agomez19","abrilCa15");
        Customer customer3 = new Customer(1,"Amairani","Garza",18000,0,"false","amablitz","UHNANANA");
        Customer customer4 = new Customer(120,"Hercules","Disney",20000,0,"false","HerculesSemiDios","Olimpo99");
        Customer customer5 = new Customer(100,"Hades","Disney",105000,0,"true","ReyDelInframundo","Hell345");
        Customer customer6 = new Customer(5,"Mickey","Mouse",123456,0,"true","DisneyWorld","WaltDisney1978");

        //Now we store them into an ArrayList of Customer
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);

        //We use the customerRepository. This uses the Iterator Design Pattern.
        CustomerRepository customerRepository = new CustomerRepository(customers);

        //Now we are going to withdraw 2,000 dollars from the Hades' balance.
        int position = customerRepository.getMethod().findCustomer("Hades","Disney");
        customerRepository.getMethod().withdraw(position,2000);

        //Now we check Hades' balance. It should be 18,000 dollars.
        double hadesBalance = customerRepository.getMethod().checkBalance(position);

        assertEquals(103000,hadesBalance);
    }

    /**
     * Test method provided by Christian A. Gomez.
     */
    @Test
    public void test3(){
        //First we create many customers.
        Customer customer1 = new Customer(65,"Christian","Gomez",5000,0,"true","cagomez15","alucard345");
        Customer customer2 = new Customer(32,"Abril","Gomez",5000,0,"true","agomez19","abrilCa15");
        Customer customer3 = new Customer(1,"Amairani","Garza",18000,0,"false","amablitz","UHNANANA");
        Customer customer4 = new Customer(120,"Hercules","Disney",20000,0,"false","HerculesSemiDios","Olimpo99");
        Customer customer5 = new Customer(100,"Hades","Disney",105000,0,"true","ReyDelInframundo","Hell345");
        Customer customer6 = new Customer(5,"Mickey","Mouse",123456,0,"true","DisneyWorld","WaltDisney1978");

        //Now we store them into an ArrayList of Customer
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);

        //We use the customerRepository. This uses the Iterator Design Pattern.
        CustomerRepository customerRepository = new CustomerRepository(customers);

        //Now we are going to check if a customer password is correct.
        //For this we are going to check if amablitz password is UHNANANA.

        boolean sentinel = false;

        for(CustomerIterator iterator = customerRepository.getMethod(); iterator.hasNext();){
            Customer customer = iterator.next();
            if(customer.getFirstName().equals("Amairani") && customer.getLastName().equals("Garza")){
                if(customer.getPassword().equals("UHNANANA")){
                    sentinel = true;
                }
            }
        }
        assertTrue(sentinel);
    }

    /**
     * Test Method provided by Christian A. Gomez.
     */
    @Test
    public void test4(){
        AutoPurchase auto = new AutoPurchase("Christian","Gomez","buy",1,"Eminem Live",3,"Vip");
        assertEquals(3,auto.getTicketQuantity());
        assertEquals("Gomez",auto.getLastName());
        assertEquals("Eminem Live",auto.getEventName());
    }

    /**
     * Test Method provided by Christian A. Gomez.
     */
    @Test
    public void test5(){
        AutoPurchase auto = new AutoPurchase("Christian","Gomez","buy",1,"Eminem Live",3,"Vip");

        auto.setEventName("Lady Gaga Concert");
        auto.setTicketQuantity(4);
        auto.setFirstName("Alberto");
        auto.setLastName("De Luna");

        assertEquals("Lady Gaga Concert",auto.getEventName());
        assertEquals(4,auto.getTicketQuantity());
        assertEquals("Alberto",auto.getFirstName());
        assertEquals("De Luna",auto.getLastName());
    }
    @Test
    /*
     * Testing userNameCheck method from RunTicket which verifies the username is correct.
     * Test provided Victor Herrera
     * Expectations: Test should fail as input does not apply to correct users.
     * Result: Test failed as expected. Method provided functions correctly.
     *
     *
     * */
    public void test6()
    {

        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer1 = new Customer(65,"Christian","Gomez",5000,0,"true","cagomez15","alucard345");
        Customer customer2 = new Customer(32,"Abril","Gomez",5000,0,"true","agomez19","abrilCa15");
        Customer customer3 = new Customer(1,"Amairani","Garza",18000,0,"false","amablitz","UHNANANA");
        Customer customer4 = new Customer(120,"Hercules","Disney",20000,0,"false","HerculesSemiDios","Olimpo99");
        Customer customer5 = new Customer(100,"Hades","Disney",105000,0,"true","ReyDelInframundo","Hell345");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        CustomerRepository customerRepository = new CustomerRepository(customers);
        assertFalse(userNameCheck(customer1.getFirstName(),customer2.getLastName(),customer3.getUserName(),customerRepository));

    }
    @Test
    /*
     * Testing
     * Test provided Victor Herrera
     * Expectations: Test Should Fail
     * Result: Expectations met
     * Conclusion: Method function tested passed test.
     * to get to pass change the id value to corresponding value of an Event
     * */
    public void test7(){
        int id =99;
        assertFalse(getEventId(id));

    }
    private static boolean userNameCheck(String firstName,String lastName,String userName,CustomerRepository customerRepository){
        for(CustomerIterator iterator = customerRepository.getMethod(); iterator.hasNext();){
            Customer customer = iterator.next();
            if(customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName)&&customer.getUserName().equals(userName)){
                return customer.getUserName().equals(userName);
            }
        }
        return false;
    }

    /**
     * Method provided by Victor Herrera.
     * This method is in charge to get an event by its ID.
     * @param id Event ID required by the user.
     * @return Event information.
     */
    public static boolean getEventId(int id){
        RunTicketMiner obj = new RunTicketMiner();
        ArrayList<Event>listOfIds= obj.generateEventList();

        for(int i =0;i<listOfIds.size();i++){
            if(listOfIds.get(i).getEventID()==id){
                return true;
            }
        }
        return false;
    }
    @Test
    /* Test provided by Victor Herrera
     * Testing invalid input for Event type.
     * Expectations: Different inputs will vary both pass and fail.
     * Results: Expectations met
     * */
    public void test8() {
        RunTicketMiner event = new RunTicketMiner();
        ArrayList<Event> listOfSports = event.generateEventList();
        String evenType1 = "Sport";
        String evenType2 = "Concert";
        String eventType3 = "Extreme";
        for (int i = 0; i < listOfSports.size(); i++) {

            // Case Passed
            /*if(listOfSports.get(i).getEventType().equals("Sport")){
                assertEquals(evenType1,listOfSports.get(i).getEventType());
            }*/
            // Case Passed
           /* if(listOfSports.get(i).getEventType().equals("Concert")){
                assertEquals(evenType2,listOfSports.get(i).getEventType());
            }*/

            /*Case Passed
             * The condition does not update as the information given is
             * Invalid so the codition is never executed.
             */
            if (listOfSports.get(i).getEventType().equals("Apple")) {
                System.out.println("Inside Loop ");
                assertEquals(eventType3, listOfSports.get(i).getEventType());
                System.out.println("This case should fail...");
            }

        }
    }
    }
