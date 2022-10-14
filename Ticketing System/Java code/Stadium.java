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
public class Stadium extends Venue{
    //Constructors

    /**
     * Empty Constructor.
     */
    public Stadium(){

    }
    /**
     * Constructor of Stadium.
     * @param nameVenue Name of the venue.
     * @param venueType Type of the venue.
     * @param pctSeats Number of pct seats.
     * @param capacity Venue capacity.
     * @param cost Venue cost.
     * @param vipPct Number of VIP seats.
     * @param goldPct Number of Gold seats.
     * @param silverPct Number of Silver seats.
     * @param bronzePct Number of Bronze seats.
     * @param generalPct Number of General seats.
     * @param reservedPct Number of Reserved seats.
     * @param fireWorks If there will be fireworks.
     * @param fireWorksCost Cost of fireworks.
     */
    public Stadium(String nameVenue,String venueType,int pctSeats,int capacity,double cost,int vipPct,int goldPct,int silverPct,
                   int bronzePct,int generalPct,int reservedPct,String fireWorks,double fireWorksCost){
        super(nameVenue,venueType,pctSeats,capacity,cost,vipPct,goldPct,silverPct,bronzePct,generalPct,reservedPct,fireWorks,fireWorksCost);
    }
    /**
     * Constructor of Stadium.
     * @param nameVenue Name of the venue.
     * @param venueType Type of the venue.
     * @param pctSeats Number of pct seats.
     * @param capacity Venue capacity.
     * @param cost Venue cost.
     * @param vipPct Number of VIP seats.
     * @param goldPct Number of Gold seats.
     * @param silverPct Number of Silver seats.
     * @param bronzePct Number of Bronze seats.
     * @param generalPct Number of General seats.
     * @param reservedPct Number of Reserved seats.
     */
    public Stadium(String nameVenue,String venueType,int pctSeats,int capacity,double cost,int vipPct,int goldPct,int silverPct,
                   int bronzePct,int generalPct,int reservedPct){
        super(nameVenue,venueType,pctSeats,capacity,cost,vipPct,goldPct,silverPct,bronzePct,generalPct,reservedPct);
    }
}
