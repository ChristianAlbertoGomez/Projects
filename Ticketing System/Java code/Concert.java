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
public class Concert extends Event{

    //Constructors

    /**
     * Empty Constructor.
     */
    public Concert(){

    }

    /**
     * Constructor of Concert.
     * @param eventIDIn Event ID.
     * @param eventTypeIn Event Type.
     * @param venueTypeIn venue type.
     * @param nameIn Name of the event.
     * @param dateIn Date of the event.
     * @param timeIn Time of the event.
     * @param vipIn Vip price.
     * @param goldIn Gold price.
     * @param silverIn Silver price.
     * @param bronzeIn Bronze price.
     * @param generalIn General price.
     * @param stadium Venue
     */
    public Concert(int eventIDIn,String eventTypeIn,String venueTypeIn,String nameIn,String dateIn,String timeIn,double vipIn,double goldIn,
                 double silverIn,double bronzeIn,double generalIn,Stadium stadium){
        super(eventIDIn,eventTypeIn,venueTypeIn,nameIn,dateIn,timeIn,vipIn,goldIn,silverIn,bronzeIn,generalIn,stadium);
    }
    /**
     * Constructor of Concert.
     * @param eventIDIn Event ID.
     * @param eventTypeIn Event Type.
     * @param venueTypeIn venue type.
     * @param nameIn Name of the event.
     * @param dateIn Date of the event.
     * @param timeIn Time of the event.
     * @param vipIn Vip price.
     * @param goldIn Gold price.
     * @param silverIn Silver price.
     * @param bronzeIn Bronze price.
     * @param generalIn General price.
     * @param arena Venue
     */
    public Concert(int eventIDIn,String eventTypeIn,String venueTypeIn,String nameIn,String dateIn,String timeIn,double vipIn,double goldIn,
                   double silverIn,double bronzeIn,double generalIn,Arena arena){
        super(eventIDIn,eventTypeIn,venueTypeIn,nameIn,dateIn,timeIn,vipIn,goldIn,silverIn,bronzeIn,generalIn,arena);
    }
    /**
     * Constructor of Concert.
     * @param eventIDIn Event ID.
     * @param eventTypeIn Event Type.
     * @param venueTypeIn venue type.
     * @param nameIn Name of the event.
     * @param dateIn Date of the event.
     * @param timeIn Time of the event.
     * @param vipIn Vip price.
     * @param goldIn Gold price.
     * @param silverIn Silver price.
     * @param bronzeIn Bronze price.
     * @param generalIn General price.
     * @param auditoriumIn Venue
     */
    public Concert(int eventIDIn,String eventTypeIn,String venueTypeIn,String nameIn,String dateIn,String timeIn,double vipIn,double goldIn,
                   double silverIn,double bronzeIn,double generalIn,Auditorium auditoriumIn){
        super(eventIDIn,eventTypeIn,venueTypeIn,nameIn,dateIn,timeIn,vipIn,goldIn,silverIn,bronzeIn,generalIn,auditoriumIn);
    }
    /**
     * Constructor of Concert.
     * @param eventIDIn Event ID.
     * @param eventTypeIn Event Type.
     * @param venueTypeIn venue type.
     * @param nameIn Name of the event.
     * @param dateIn Date of the event.
     * @param timeIn Time of the event.
     * @param vipIn Vip price.
     * @param goldIn Gold price.
     * @param silverIn Silver price.
     * @param bronzeIn Bronze price.
     * @param generalIn General price.
     * @param openAirIn Venue.
     */
    public Concert(int eventIDIn,String eventTypeIn,String venueTypeIn,String nameIn,String dateIn,String timeIn,double vipIn,double goldIn,
                   double silverIn,double bronzeIn,double generalIn,OpenAir openAirIn){
        super(eventIDIn,eventTypeIn,venueTypeIn,nameIn,dateIn,timeIn,vipIn,goldIn,silverIn,bronzeIn,generalIn,openAirIn);
    }
}
