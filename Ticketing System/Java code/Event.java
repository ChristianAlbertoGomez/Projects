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
public abstract class Event{
    //Attributes
    private int eventID;
    private String eventType;
    private String name;
    private String date;
    private String time;
    String venueType;

    private double vipPrice;
    private double goldPrice;
    private double silverPrice;
    private double bronzePrice;
    private double generalPrice;

    private double totalCollectedVip; //total amount
    private double totalCollectedGold; //total amount
    private double totalCollectedSilver; //total amount
    private double totalCollectedBronze; //total amount
    private double totalCollectedGeneral; //total amount

    private double totalTaxCollected;
    private double totalDiscountCollected;

    private Stadium stadium;
    private Arena arena;
    private Auditorium auditorium;
    private OpenAir openAir;

    //Constructors

    /**
     * Empty Constructor.
     */
    public Event(){

    }

    /**
     * Constructor of Event.
     * @param eventIDIn Event ID.
     * @param eventTypeIn Type of Event such as Sport,Concert, or Special.
     */
    public Event(int eventIDIn,String eventTypeIn){
        this.eventID = eventIDIn;
        this.eventType = eventTypeIn;
    }

    /**
     * Constructor of Event.
     * @param eventID Event ID.
     * @param eventType Event Type.
     * @param venueTypeIn venue type.
     * @param name Name of the event.
     * @param date Date of the event.
     * @param time Time of the event.
     * @param vipPrice Vip price.
     * @param goldPrice Gold price.
     * @param silverPrice Silver price.
     * @param bronzePrice Bronze price.
     * @param generalPrice General price.
     * @param stadiumIn this is venue.
     */
    public Event(int eventID, String eventType,String venueTypeIn, String name, String date, String time, double vipPrice, double goldPrice, double silverPrice, double bronzePrice, double generalPrice,Stadium stadiumIn) {
        this.eventID = eventID;
        this.eventType = eventType;
        this.venueType = venueTypeIn;
        this.name = name;
        this.date = date;
        this.time = time;
        this.vipPrice = vipPrice;
        this.goldPrice = goldPrice;
        this.silverPrice = silverPrice;
        this.bronzePrice = bronzePrice;
        this.generalPrice = generalPrice;
        this.stadium = stadiumIn;
    }
    /**
     * Constructor of Event.
     * @param eventID Event ID.
     * @param eventType Event Type.
     * @param venueTypeIn venue type.
     * @param name Name of the event.
     * @param date Date of the event.
     * @param time Time of the event.
     * @param vipPrice Vip price.
     * @param goldPrice Gold price.
     * @param silverPrice Silver price.
     * @param bronzePrice Bronze price.
     * @param generalPrice General price.
     * @param arenaIn This is venue
     */
    public Event(int eventID, String eventType,String venueTypeIn, String name, String date, String time, double vipPrice, double goldPrice, double silverPrice, double bronzePrice, double generalPrice,Arena arenaIn) {
        this.eventID = eventID;
        this.eventType = eventType;
        this.venueType = venueTypeIn;
        this.name = name;
        this.date = date;
        this.time = time;
        this.vipPrice = vipPrice;
        this.goldPrice = goldPrice;
        this.silverPrice = silverPrice;
        this.bronzePrice = bronzePrice;
        this.generalPrice = generalPrice;
        this.arena = arenaIn;
    }
    /**
     * Constructor of Event.
     * @param eventID Event ID.
     * @param eventType Event Type.
     * @param venueTypeIn venue type.
     * @param name Name of the event.
     * @param date Date of the event.
     * @param time Time of the event.
     * @param vipPrice Vip price.
     * @param goldPrice Gold price.
     * @param silverPrice Silver price.
     * @param bronzePrice Bronze price.
     * @param generalPrice General price.
     * @param auditoriumIn Venue
     */
    public Event(int eventID, String eventType,String venueTypeIn, String name, String date, String time, double vipPrice, double goldPrice, double silverPrice, double bronzePrice, double generalPrice,Auditorium auditoriumIn) {
        this.eventID = eventID;
        this.eventType = eventType;
        this.venueType = venueTypeIn;
        this.name = name;
        this.date = date;
        this.time = time;
        this.vipPrice = vipPrice;
        this.goldPrice = goldPrice;
        this.silverPrice = silverPrice;
        this.bronzePrice = bronzePrice;
        this.generalPrice = generalPrice;
        this.auditorium = auditoriumIn;
    }
    /**
     * Constructor of Event.
     * @param eventID Event ID.
     * @param eventType Event Type.
     * @param venueTypeIn venue type.
     * @param name Name of the event.
     * @param date Date of the event.
     * @param time Time of the event.
     * @param vipPrice Vip price.
     * @param goldPrice Gold price.
     * @param silverPrice Silver price.
     * @param bronzePrice Bronze price.
     * @param generalPrice General price.
     * @param openAirIn Venue
     */
    public Event(int eventID, String eventType,String venueTypeIn, String name, String date, String time, double vipPrice, double goldPrice, double silverPrice, double bronzePrice, double generalPrice,OpenAir openAirIn) {
        this.eventID = eventID;
        this.eventType = eventType;
        this.venueType = venueTypeIn;
        this.name = name;
        this.date = date;
        this.time = time;
        this.vipPrice = vipPrice;
        this.goldPrice = goldPrice;
        this.silverPrice = silverPrice;
        this.bronzePrice = bronzePrice;
        this.generalPrice = generalPrice;
        this.openAir = openAirIn;
    }
    //Setters and Getters
    ////////////////////////////////////////////////////////////

    /**
     * Getter for venue type.
     * @return Venue type.
     */
    public String getVenueType() {
        return venueType;
    }

    /**
     * Setter for venue type.
     * @param venueType Setter for venue type.
     */
    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    ////////////////////////////////////////////////////////////
    /**
     * Method provided by Christian A. Gomez.
     * Getter of Stadium.
     * @return stadium.
     */
    public Stadium getStadium() {
        return stadium;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Arena.
     * @return arena.
     */
    public Arena getArena() {
        return arena;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Auditorium.
     * @return auditorium.
     */
    public Auditorium getAuditorium() {
        return auditorium;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of OpenAir.
     * @return openAir.
     */
    public OpenAir getOpenAir() {
        return openAir;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Event ID.
     * @return Event ID.
     */
    public int getEventID() {
        return eventID;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Event ID.
     * @param eventID Event ID.
     */
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Event Type.
     * @return Event Type.
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Event Type.
     * @param eventType Event Type.
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Event name.
     * @return Event Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Event name.
     * @param name Event name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Event Date.
     * @return Event Date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Event Date.
     * @param date Event Date.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Event Time.
     * @return Event Time.
     */
    public String getTime() {
        return time;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Event Time.
     * @param time Event Time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of VIP Price.
     * @return Price.
     */
    public double getVipPrice() {
        return vipPrice;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Vip Price.
     * @param vipPrice vip Price.
     */
    public void setVipPrice(double vipPrice) {
        this.vipPrice = vipPrice;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Gold Price.
     * @return Price.
     */
    public double getGoldPrice() {
        return goldPrice;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Gold Price.
     * @param goldPrice gold Price.
     */
    public void setGoldPrice(double goldPrice) {
        this.goldPrice = goldPrice;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Silver Price.
     * @return Price.
     */
    public double getSilverPrice() {
        return silverPrice;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Silver Price.
     * @param silverPrice Silve price
     */
    public void setSilverPrice(double silverPrice) {
        this.silverPrice = silverPrice;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Bronze Price.
     * @return Price.
     */
    public double getBronzePrice() {
        return bronzePrice;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Bronze Price.
     * @param bronzePrice Bronze price.
     */
    public void setBronzePrice(double bronzePrice) {
        this.bronzePrice = bronzePrice;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of General Price.
     * @return Price.
     */
    public double getGeneralPrice() {
        return generalPrice;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of General Price.
     * @param generalPrice General price
     */
    public void setGeneralPrice(double generalPrice) {
        this.generalPrice = generalPrice;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Total VIP Revenue collected.
     * @return vip revenue.
     */
    public double getTotalCollectedVip() {
        return totalCollectedVip;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Total VIP Revenue collected.
     * @param totalCollectedVip Vip revenue collected.
     */
    public void setTotalCollectedVip(double totalCollectedVip) {
        this.totalCollectedVip = totalCollectedVip;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Total Gold Revenue collected.
     * @return Gold Revenue Collected.
     */
    public double getTotalCollectedGold() {
        return totalCollectedGold;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Total Gold Revenue collected.
     * @param totalCollectedGold Gold Revenue Collected.
     */
    public void setTotalCollectedGold(double totalCollectedGold) {
        this.totalCollectedGold = totalCollectedGold;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Total Silver Revenue collected.
     * @return Silver Revenue Collected.
     */
    public double getTotalCollectedSilver() {
        return totalCollectedSilver;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Total Silver Revenue collected.
     * @param totalCollectedSilver Silver revenue collected.
     */
    public void setTotalCollectedSilver(double totalCollectedSilver) {
        this.totalCollectedSilver = totalCollectedSilver;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Total Bronze Revenue collected.
     * @return Bronze Revenue Collected.
     */
    public double getTotalCollectedBronze() {
        return totalCollectedBronze;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Total Bronze Revenue collected.
     * @param totalCollectedBronze bronze revenue collected.
     */
    public void setTotalCollectedBronze(double totalCollectedBronze) {
        this.totalCollectedBronze = totalCollectedBronze;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Total General Revenue collected.
     * @return General Revenue Collected.
     */
    public double getTotalCollectedGeneral() {
        return totalCollectedGeneral;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Total General Revenue collected.
     * @param totalCollectedGeneral General Revenue Collected.
     */
    public void setTotalCollectedGeneral(double totalCollectedGeneral) {
        this.totalCollectedGeneral = totalCollectedGeneral;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Total Tax Revenue collected.
     * @return Total Tax Revenue Collected
     */
    public double getTotalTaxCollected() {
        return totalTaxCollected;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Total Tax Revenue collected.
     * @param totalTaxCollected Total Tax Revenue Collected.
     */
    public void setTotalTaxCollected(double totalTaxCollected) {
        this.totalTaxCollected = totalTaxCollected;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Getter of Total Discount Revenue collected.
     * @return Total Discount Collected.
     */
    public double getTotalDiscountCollected() {
        return totalDiscountCollected;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Setter of Total Discount Revenue collected.
     * @param totalDiscountCollected Total Discount Collected.
     */
    public void setTotalDiscountCollected(double totalDiscountCollected) {
        this.totalDiscountCollected = totalDiscountCollected;
    }
    //Methods

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total collected for vip tickets.
     * @param numTicket number of tickets.
     * @return total amount.
     */
    public double totalSumVip(int numTicket){
        double total = getVipPrice()*numTicket;
        totalCollectedVip+=total;
        return totalCollectedVip;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total collected for Gold tickets.
     * @param numTicket number of tickets.
     * @return total amount.
     */
    public double totalSumGold(int numTicket){
        double total = getGoldPrice()*numTicket;
        totalCollectedGold+=total;
        return totalCollectedGold;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total collected for Silver tickets.
     * @param numTicket Number of tickets.
     * @return total amount.
     */
    public double totalSumSilver(int numTicket){
        double total = getSilverPrice()*numTicket;
        totalCollectedSilver+=total;
        return totalCollectedSilver;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total collected for Bronze tickets.
     * @param numTicket number of tickets.
     * @return total amount.
     */
    public double totalSumBronze(int numTicket){
        double total = getBronzePrice()*numTicket;
        totalCollectedBronze+=total;
        return totalCollectedBronze;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total collected for General tickets.
     * @param numTicket number of tickets.
     * @return total amount.
     */
    public double totalSumGeneral(int numTicket){
        double total = getGeneralPrice()*numTicket;
        totalCollectedGeneral+=total;
        return totalCollectedGeneral;
    }

    /**
     * Method provided by Christian A. Gomez.
     *Method that calculates the total collected for all type of tickets.
     * @return TOTAL MAX COLLECTED.
     */
    public double totalCollected(){
        return totalCollectedVip+totalCollectedGold+totalCollectedSilver
                +totalCollectedBronze+totalCollectedGeneral;
    }
    /**
     * Method provided by Christian A. Gomez.
     * Method provided by the TexasSalesTax interface. This method will collect all the tax from each event.
     * @param amount tax that was added in each purchase.
     */
    public void collectTotalTaxEvent(double amount) {
        totalTaxCollected+=amount;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method provided by the TexasSalesTax interface. This method will collect all the discounts from each event.
     * @param amount total discount from each event purchase.
     */
    public void collectTotalDiscounts(double amount){
        totalDiscountCollected+=amount;
    }
    //toString

    /**
     * Method provided by Christian A. Gomez.
     * toString() method.
     * @return information from the event.
     */
    @Override
    public String toString() {
        if(getVenueType().equals("Stadium")){
            return "Event ID:"+eventID+"\t"+
                    "->Event Type:"+eventType+"\t"+
                    "->Event Name:"+name+"\t"+
                    "->Date:"+date+"\t"+
                    "->Time:"+time+"\t"+
                    "->Vip Price:"+vipPrice+"\t"+
                    "->Gold Price:"+goldPrice+"\t"+
                    "->Silver Price:"+silverPrice+"\t"+
                    "->Bronze Price:"+bronzePrice+"\t"+
                    "->General Price:"+generalPrice+"\t"+
                    stadium+"\t";
        }else if(getVenueType().equals("Arena")){
            return "Event ID:"+eventID+"\t"+
                    "->Event Type:"+eventType+"\t"+
                    "->Event Name:"+name+"\t"+
                    "->Date:"+date+"\t"+
                    "->Time:"+time+"\t"+
                    "->Vip Price:"+vipPrice+"\t"+
                    "->Gold Price:"+goldPrice+"\t"+
                    "->Silver Price:"+silverPrice+"\t"+
                    "->Bronze Price:"+bronzePrice+"\t"+
                    "->General Price:"+generalPrice+"\t"+
                    arena+"\t";
        }else if(getVenueType().equals("Auditorium")){
            return "Event ID:"+eventID+"\t"+
                    "->Event Type:"+eventType+"\t"+
                    "->Event Name:"+name+"\t"+
                    "->Date:"+date+"\t"+
                    "->Time:"+time+"\t"+
                    "->Vip Price:"+vipPrice+"\t"+
                    "->Gold Price:"+goldPrice+"\t"+
                    "->Silver Price:"+silverPrice+"\t"+
                    "->Bronze Price:"+bronzePrice+"\t"+
                    "->General Price:"+generalPrice+"\t"+
                    auditorium+"\t";
        }else if(getVenueType().equals("Open Air")){
            return "Event ID:"+eventID+"\t"+
                    "->Event Type:"+eventType+"\t"+
                    "->Event Name:"+name+"\t"+
                    "->Date:"+date+"\t"+
                    "->Time:"+time+"\t"+
                    "->Vip Price:"+vipPrice+"\t"+
                    "->Gold Price:"+goldPrice+"\t"+
                    "->Silver Price:"+silverPrice+"\t"+
                    "->Bronze Price:"+bronzePrice+"\t"+
                    "->General Price:"+generalPrice+"\t"+
                    openAir+"\n";
        }else{
            return "";
        }
    }
    /**
     * Method provided by Christian A. Gomez.
     * toString() method.
     * @return information from the event.
     */
    public String toStringCustomer() {
        if(getVenueType().equals("Stadium")){
            return "Event ID:"+eventID+"\n"+
                    "->Event Type:"+eventType+"\n"+
                    "->Event Name:"+name+"\n"+
                    "->Date:"+date+"\n"+
                    "->Time:"+time+"\n"+
                    "->Vip Price:"+vipPrice+"\n"+
                    "->Gold Price:"+goldPrice+"\n"+
                    "->Silver Price:"+silverPrice+"\n"+
                    "->Bronze Price:"+bronzePrice+"\n"+
                    "->General Price:"+generalPrice+"\n"+
                    stadium+"\n";
        }else if(getVenueType().equals("Arena")){
            return "Event ID:"+eventID+"\n"+
                    "->Event Type:"+eventType+"\n"+
                    "->Event Name:"+name+"\n"+
                    "->Date:"+date+"\n"+
                    "->Time:"+time+"\n"+
                    "->Vip Price:"+vipPrice+"\n"+
                    "->Gold Price:"+goldPrice+"\n"+
                    "->Silver Price:"+silverPrice+"\n"+
                    "->Bronze Price:"+bronzePrice+"\n"+
                    "->General Price:"+generalPrice+"\n"+
                    arena+"\n";
        }else if(getVenueType().equals("Auditorium")){
            return "Event ID:"+eventID+"\n"+
                    "->Event Type:"+eventType+"\n"+
                    "->Event Name:"+name+"\n"+
                    "->Date:"+date+"\n"+
                    "->Time:"+time+"\n"+
                    "->Vip Price:"+vipPrice+"\n"+
                    "->Gold Price:"+goldPrice+"\n"+
                    "->Silver Price:"+silverPrice+"\n"+
                    "->Bronze Price:"+bronzePrice+"\n"+
                    "->General Price:"+generalPrice+"\n"+
                    auditorium+"\n";
        }else if(getVenueType().equals("Open Air")){
            return "Event ID:"+eventID+"\n"+
                    "->Event Type:"+eventType+"\n"+
                    "->Event Name:"+name+"\n"+
                    "->Date:"+date+"\n"+
                    "->Time:"+time+"\n"+
                    "->Vip Price:"+vipPrice+"\n"+
                    "->Gold Price:"+goldPrice+"\n"+
                    "->Silver Price:"+silverPrice+"\n"+
                    "->Bronze Price:"+bronzePrice+"\n"+
                    "->General Price:"+generalPrice+"\n"+
                    openAir+"\n";
        }else{
            return "";
        }
    }
    /**
     * Method provided by Christian A. Gomez.
     * This method display specific information to the administrator.
     * @return A string with specific information.
     */
    public String displayAdmin2(){
        if(getVenueType().equals("Stadium")){
            return "\t ->name: " + getName()+"\n"+
                    "\t ->date: " + getDate()+"\n"+
                    "\t ->time: " + getTime()+"\n"+
                    "\t ->Total revenue for VIP tickets:" +totalCollectedVip+"\n"+
                    "\t ->Total revenue for Gold tickets:" + totalCollectedGold+"\n"+
                    "\t ->Total revenue for Silver tickets:" + totalCollectedSilver+"\n"+
                    "\t ->Total revenue for Bronze tickets:: " + totalCollectedBronze+"\n"+
                    "\t ->Total revenue for General tickets:" + totalCollectedGeneral+"\n"+
                    "\t ->Total revenue for all tickets:"+ totalCollected()+"\n"+
                    "\t ->Total Taxes Collected:"+totalTaxCollected+"\n"+
                    "\t ->Total Discount Collected:"+getTotalDiscountCollected()+"\n"+
                    "\t"+ stadium.toStringAdmin()+"\n";
        }else if(getVenueType().equals("Arena")){
            return "\t ->name: " + getName()+"\n"+
                    "\t ->date: " + getDate()+"\n"+
                    "\t ->time: " + getTime()+"\n"+
                    "\t ->Total revenue for VIP tickets:" +totalCollectedVip+"\n"+
                    "\t ->Total revenue for Gold tickets:" + totalCollectedGold+"\n"+
                    "\t ->Total revenue for Silver tickets:" + totalCollectedSilver+"\n"+
                    "\t ->Total revenue for Bronze tickets:: " + totalCollectedBronze+"\n"+
                    "\t ->Total revenue for General tickets:" + totalCollectedGeneral+"\n"+
                    "\t ->Total revenue for all tickets:"+ totalCollected()+"\n"+
                    "\t ->Total Taxes Collected:"+totalTaxCollected+"\n"+
                    "\t ->Total Discount Collected:"+getTotalDiscountCollected()+"\n"+
                    "\t"+ arena.toStringAdmin()+"\n";
        }else if(getVenueType().equals("Auditorium")){
            return "\t ->name: " + getName()+"\n"+
                    "\t ->date: " + getDate()+"\n"+
                    "\t ->time: " + getTime()+"\n"+
                    "\t ->Total revenue for VIP tickets:" +totalCollectedVip+"\n"+
                    "\t ->Total revenue for Gold tickets:" + totalCollectedGold+"\n"+
                    "\t ->Total revenue for Silver tickets:" + totalCollectedSilver+"\n"+
                    "\t ->Total revenue for Bronze tickets:: " + totalCollectedBronze+"\n"+
                    "\t ->Total revenue for General tickets:" + totalCollectedGeneral+"\n"+
                    "\t ->Total revenue for all tickets:"+ totalCollected()+"\n"+
                    "\t ->Total Taxes Collected:"+totalTaxCollected+"\n"+
                    "\t ->Total Discount Collected:"+getTotalDiscountCollected()+"\n"+
                    "\t"+ auditorium.toStringAdmin()+"\n";
        }else if(getVenueType().equals("Open Air")){
            return "\t ->name: " + getName()+"\n"+
                    "\t ->date: " + getDate()+"\n"+
                    "\t ->time: " + getTime()+"\n"+
                    "\t ->Total revenue for VIP tickets:" +totalCollectedVip+"\n"+
                    "\t ->Total revenue for Gold tickets:" + totalCollectedGold+"\n"+
                    "\t ->Total revenue for Silver tickets:" + totalCollectedSilver+"\n"+
                    "\t ->Total revenue for Bronze tickets:: " + totalCollectedBronze+"\n"+
                    "\t ->Total revenue for General tickets:" + totalCollectedGeneral+"\n"+
                    "\t ->Total revenue for all tickets:"+ totalCollected()+"\n"+
                    "\t ->Total Taxes Collected:"+totalTaxCollected+"\n"+
                    "\t ->Total Discount Collected:"+getTotalDiscountCollected()+"\n"+
                    "\t"+ openAir.toStringAdmin()+"\n";
        }else {
            return "";
        }
    }
}