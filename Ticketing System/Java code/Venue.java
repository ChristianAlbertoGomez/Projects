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
public abstract class Venue{
    //Attributes
    private String nameAvenue;
    private String nameType; //Venue Type
    private int pctSeats;
    private int capacity;
    private double cost;
    private int vipPct;
    private int goldPct;
    private int silverPct;
    private int bronzePct;
    private int generalPct;
    private int reservedPct;
    private String fireWorks;
    private double fireWorksCost;

    private int totalSeatsVip; //Total seats
    private int totalSeatsGold; //Total seats
    private int totalSeatsSilver; //Total seats
    private int totalSeatsBronze; //Total seats
    private int totalSeatsGeneral; //Total seats

    private double totalVipRevenue;
    private double totalGoldRevenue;
    private double totalSilverRevenue;
    private double totalBronzeRevenue;
    private double totalGeneralRevenue;

    //Constructors

    /**
     * Empty Constructor
     */
    public Venue(){

    }

    /**
     * Constructor
     * @param nameAvenueIn Venue Name
     * @param nameTypeIn Type of venue
     * @param pctSeatsIn Total pct seats.
     * @param capacityIn venue capacity
     * @param costIn venue cost
     * @param vipPctIn vip pct
     * @param goldPctIn gold pct
     * @param silverPctIn silver pct
     * @param bronzePctIn bronze pct
     * @param generalPctIn general pct
     * @param reservedPctIn reserved pct
     * @param fireWorksIn fireworks
     * @param fireWorksCostIn fireworks cost
     */
    public Venue(String nameAvenueIn, String nameTypeIn, int pctSeatsIn, int capacityIn, double costIn, int vipPctIn,
                 int goldPctIn, int silverPctIn, int bronzePctIn, int generalPctIn, int reservedPctIn, String fireWorksIn, double fireWorksCostIn) {
        this.nameAvenue = nameAvenueIn;
        this.nameType = nameTypeIn;
        this.pctSeats = pctSeatsIn;
        this.capacity = capacityIn;
        this.cost = costIn;
        this.vipPct = vipPctIn;
        this.goldPct = goldPctIn;
        this.silverPct = silverPctIn;
        this.bronzePct = bronzePctIn;
        this.generalPct = generalPctIn;
        this.reservedPct = reservedPctIn;
        this.fireWorks = fireWorksIn;
        this.fireWorksCost = fireWorksCostIn;
    }
    /**
     * Constructor
     * @param nameAvenueIn Venue Name
     * @param nameTypeIn Type of venue
     * @param pctSeatsIn Total pct seats.
     * @param capacityIn venue capacity
     * @param costIn venue cost
     * @param vipPctIn vip pct
     * @param goldPctIn gold pct
     * @param silverPctIn silver pct
     * @param bronzePctIn bronze pct
     * @param generalPctIn general pct
     * @param reservedPctIn reserved pct
     */
    public Venue(String nameAvenueIn, String nameTypeIn, int pctSeatsIn, int capacityIn, double costIn, int vipPctIn,
                 int goldPctIn, int silverPctIn, int bronzePctIn, int generalPctIn, int reservedPctIn) {
        this.nameAvenue = nameAvenueIn;
        this.nameType = nameTypeIn;
        this.pctSeats = pctSeatsIn;
        this.capacity = capacityIn;
        this.cost = costIn;
        this.vipPct = vipPctIn;
        this.goldPct = goldPctIn;
        this.silverPct = silverPctIn;
        this.bronzePct = bronzePctIn;
        this.generalPct = generalPctIn;
        this.reservedPct = reservedPctIn;
    }
    //Setters and Getters

    /**
     * Getter of Name Venue.
     * @return Name venue.
     */
    public String getNameAvenue() {
        return nameAvenue;
    }

    /**
     * Setter of Name Venue.
     * @param nameAvenue Name Venue.
     */
    public void setNameAvenue(String nameAvenue) {
        this.nameAvenue = nameAvenue;
    }

    /**
     * Getter of Venue Type
     * @return Venue Type.
     */
    public String getNameType() {
        return nameType;
    }

    /**
     * Setter of Venue Type.
     * @param nameType Venue Tyoe.
     */
    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    /**
     * Getter of PCT Seats.
     * @return PCT Seats.
     */
    public int getPctSeats() {
        return pctSeats;
    }

    /**
     * Setter of PCT Seats.
     * @param pctSeats Pct seats.
     */
    public void setPctSeats(int pctSeats) {
        this.pctSeats = pctSeats;
    }

    /**
     * Getter of Capacity.
     * @return Capacity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Setter of Capacity.
     * @param capacity Capacity.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Getter of Cost.
     * @return Cost.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Setter of Cost.
     * @param cost Cost.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Getter of VIP pct.
     * @return VIP pct.
     */
    public int getVipPct() {
        return vipPct;
    }

    /**
     * Setter of VIP pct.
     * @param vipPct VIP pct.
     */
    public void setVipPct(int vipPct) {
        this.vipPct = vipPct;
    }

    /**
     * Getter of Gold pct.
     * @return Gold pct.
     */
    public int getGoldPct() {
        return goldPct;
    }

    /**
     * Setter of Gold pct.
     * @param goldPct Gold pct.
     */
    public void setGoldPct(int goldPct) {
        this.goldPct = goldPct;
    }

    /**
     * Getter of Silver pct.
     * @return Silver pct.
     */
    public int getSilverPct() {
        return silverPct;
    }

    /**
     * Setter of Silver pct.
     * @param silverPct Silver pct.
     */
    public void setSilverPct(int silverPct) {
        this.silverPct = silverPct;
    }

    /**
     * Getter of Bronze pct.
     * @return Bronze pct.
     */
    public int getBronzePct() {
        return bronzePct;
    }

    /**
     * Setter of Bronze pct.
     * @param bronzePct Bronze pct.
     */
    public void setBronzePct(int bronzePct) {
        this.bronzePct = bronzePct;
    }

    /**
     * Getter of General pct.
     * @return General pct.
     */
    public int getGeneralPct() {
        return generalPct;
    }

    /**
     * Setter of General pct.
     * @param generalPct General pct.
     */
    public void setGeneralPct(int generalPct) {
        this.generalPct = generalPct;
    }

    /**
     * Getter of Reserved pct.
     * @return Reserved pct.
     */
    public int getReservedPct() {
        return reservedPct;
    }

    /**
     * Setter of Reserved pct.
     * @param reservedPct Reserved pct.
     */
    public void setReservedPct(int reservedPct) {
        this.reservedPct = reservedPct;
    }

    /**
     * Getter of fireworks.
     * @return fireworks.
     */
    public String getFireWorks() {
        return fireWorks;
    }

    /**
     * Setter of fireworks.
     * @param fireWorks fireworks.
     */
    public void setFireWorks(String fireWorks) {
        this.fireWorks = fireWorks;
    }

    /**
     * Getter of fireworks cost.
     * @return fireworks cost.
     */
    public double getFireWorksCost() {
        return fireWorksCost;
    }

    /**
     * Setter of fireworks cost.
     * @param fireWorksCost fireworks cost.
     */
    public void setFireWorksCost(double fireWorksCost) {
        this.fireWorksCost = fireWorksCost;
    }

    /**
     * Getter of total vip seats.
     * @return total vip seats.
     */
    public int getTotalSeatsVip() {
        return totalSeatsVip;
    }

    /**
     * Setter of total vip seats.
     * @param totalSeatsVip total vip seats.
     */
    public void setTotalSeatsVip(int totalSeatsVip) {
        this.totalSeatsVip = totalSeatsVip;
    }

    /**
     * Getter of total gold seats.
     * @return gold seats.
     */
    public int getTotalSeatsGold() {
        return totalSeatsGold;
    }

    /**
     * Setter of total gold seats.
     * @param totalSeatsGold gold seats.
     */
    public void setTotalSeatsGold(int totalSeatsGold) {
        this.totalSeatsGold = totalSeatsGold;
    }

    /**
     * Getter of total silver seats.
     * @return silver seats.
     */
    public int getTotalSeatsSilver() {
        return totalSeatsSilver;
    }

    /**
     * Setter of total silver seats.
     * @param totalSeatsSilver silver seats.
     */
    public void setTotalSeatsSilver(int totalSeatsSilver) {
        this.totalSeatsSilver = totalSeatsSilver;
    }

    /**
     * Getter of total bronze seats.
     * @return bronze seats.
     */
    public int getTotalSeatsBronze() {
        return totalSeatsBronze;
    }

    /**
     * Setter of total bronze seats.
     * @param totalSeatsBronze bronze seats.
     */
    public void setTotalSeatsBronze(int totalSeatsBronze) {
        this.totalSeatsBronze = totalSeatsBronze;
    }

    /**
     * Getter of total general seats.
     * @return general seats.
     */
    public int getTotalSeatsGeneral() {
        return totalSeatsGeneral;
    }

    /**
     * Setter of total general seats.
     * @param totalSeatsGeneral general seats.
     */
    public void setTotalSeatsGeneral(int totalSeatsGeneral) {
        this.totalSeatsGeneral = totalSeatsGeneral;
    }

    /**
     * Getter of total vip revenue.
     * @return total vip revenue.
     */
    public double getTotalVipRevenue() {
        return totalVipRevenue;
    }

    /**
     * Setter of total vip revenue.
     * @param totalVipRevenue total vip revenue.
     */
    public void setTotalVipRevenue(double totalVipRevenue) {
        this.totalVipRevenue = totalVipRevenue;
    }

    /**
     * Getter of total gold revenue.
     * @return total gold revenue.
     */
    public double getTotalGoldRevenue() {
        return totalGoldRevenue;
    }

    /**
     * Setter of total gold revenue.
     * @param totalGoldRevenue total gold revenue.
     */
    public void setTotalGoldRevenue(double totalGoldRevenue) {
        this.totalGoldRevenue = totalGoldRevenue;
    }

    /**
     * Getter of total silver revenue.
     * @return total silver revenue.
     */
    public double getTotalSilverRevenue() {
        return totalSilverRevenue;
    }

    /**
     * Setter of total silver revenue.
     * @param totalSilverRevenue total silver revenue.
     */
    public void setTotalSilverRevenue(double totalSilverRevenue) {
        this.totalSilverRevenue = totalSilverRevenue;
    }

    /**
     * Getter of total bronze revenue.
     * @return total bronze revenue.
     */
    public double getTotalBronzeRevenue() {
        return totalBronzeRevenue;
    }

    /**
     * Setter of total bronze revenue.
     * @param totalBronzeRevenue total bronze revenue.
     */
    public void setTotalBronzeRevenue(double totalBronzeRevenue) {
        this.totalBronzeRevenue = totalBronzeRevenue;
    }

    /**
     * Getter of total general revenue.
     * @return total general revenue.
     */
    public double getTotalGeneralRevenue() {
        return totalGeneralRevenue;
    }

    /**
     * Setter of total general revenue.
     * @param totalGeneralRevenue total general revenue.
     */
    public void setTotalGeneralRevenue(double totalGeneralRevenue) {
        this.totalGeneralRevenue = totalGeneralRevenue;
    }

    //Methods
    /**
     * Method provided by Christian A. Gomez.
     * Method that updates the total vip seats after a reservation.
     * @param numSeats total number of seats remain.
     */
    public void subVipPct(int numSeats){ //Remember pct means seats
        vipPct-=numSeats;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that updates the total gold seats after a reservation.
     * @param numSeats total number of seats remain.
     */
    public void subGoldPct(int numSeats){
        goldPct-=numSeats;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that updates the total silver seats after a reservation.
     * @param numSeats total number of seats remain.
     */
    public void subSilverPct(int numSeats){
        silverPct-=numSeats;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that updates the total bronze seats after a reservation.
     * @param numSeats total number of seats remain.
     */
    public void subBronzePct(int numSeats){
        bronzePct-=numSeats;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that updates the total general seats after a reservation.
     * @param numSeats total number of seats remain.
     */
    public void subGeneralPct(int numSeats){
        generalPct-=numSeats;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total of vip seats that were sold.
     * @param numSeats total of seats sold.
     */
    public void totalSeatsVipSold(int numSeats){
        totalSeatsVip+=numSeats;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total of gold seats that were sold.
     * @param numSeats total of seats sold.
     */
    public void totalSeatsGoldSold(int numSeats){
        totalSeatsGold+=numSeats;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total of silver seats that were sold.
     * @param numSeats total of seats sold.
     */
    public void totalSeatsSilverSold(int numSeats){
        totalSeatsSilver+=numSeats;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total of bronze seats that were sold.
     * @param numSeats total of seats sold.
     */
    public void totalSeatsBronzeSold(int numSeats){
        totalSeatsBronze+=numSeats;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total of general seats that were sold.
     * @param numSeats total of seats sold.
     */
    public void totalSeatsGeneralSold(int numSeats){
        totalSeatsGeneral+=numSeats;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total of seats that were sold for a specific event.
     * @return sum of total seats that were sold.
     */
    public int totalSeatsSoldEvent(){
        return totalSeatsVip+totalSeatsGold+totalSeatsSilver+totalSeatsBronze+totalSeatsGeneral;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total of money that was recollected for vip tickets in a specific event.
     * @param numSeats Number of seats that were sold.
     * @param price vip seat price.
     */
    public void totalVipRevenue(int numSeats,double price){
        double total = numSeats*price;
        totalVipRevenue+=total;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total of money that was recollected for gold tickets in a specific event.
     * @param numSeats Number of seats that were sold.
     * @param price gold seat price.
     */
    public void totalGoldRevenue(int numSeats,double price){
        double total = numSeats*price;
        totalGoldRevenue+=total;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total of money that was recollected for silver tickets in a specific event.
     * @param numSeats Number of seats that were sold.
     * @param price silver seat price.
     */
    public void totalSilverRevenue(int numSeats,double price){
        double total = numSeats*price;
        totalSilverRevenue+=total;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total of money that was recollected for bronze tickets in a specific event.
     * @param numSeats Number of seats that were sold.
     * @param price bronze seat price.
     */
    public void totalBronzeRevenue(int numSeats,double price){
        double total = numSeats*price;
        totalBronzeRevenue+=total;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the total of money that was recollected for general tickets in a specific event.
     * @param numSeats Number of seats that were sold.
     * @param price general seat price.
     */
    public void totalGeneralRevenue(int numSeats,double price){
        double total = numSeats*price;
        totalGeneralRevenue+=total;
    }

    /**
     * Method provided by Christian A. Gomez.
     * Method that calculates the actual profit of the event.
     * @return the actual profit number of the event.
     */
    public double actualProfit(){
        return getCost()-(totalVipRevenue+totalGeneralRevenue+totalSilverRevenue+totalBronzeRevenue+totalGeneralRevenue);
    }

    //toString

    @Override
    public String toString() {
        return "\t->nameAvenue:" + nameAvenue+
                "\t->nameType:" + nameType;
    }

    /**
     * Method provided by Christian A. Gomez.
     * toStringAdmin() method.
     * @return A String with specific information.
     */
    public String toStringAdmin() {
        return "\t->nameAvenue:" + nameAvenue +"\n" +
                "\t->nameType:" + nameType +"\n" +
                "\t->pctSeats:" + pctSeats +"\n"+
                "\t->capacity:" + capacity +"\n"+
                "\t->cost:" + cost +"\n"+
                "\t->vipPct:" + vipPct +"\n"+
                "\t->goldPct:" + goldPct +"\n"+
                "\t->silverPct:" + silverPct +"\n"+
                "\t->bronzePct:" + bronzePct +"\n"+
                "\t->generalPct:" + generalPct +"\n"+
                "\t->reservedPct:" + reservedPct +"\n"+
                "\t->fireWorks:" + fireWorks + '\'' +"\n"+
                "\t->fireWorksCost:" + fireWorksCost +"\n"+
                "\t->totalSeatsVip:" + totalSeatsVip +"\n"+
                "\t->totalSeatsGold:" + totalSeatsGold +"\n"+
                "\t->totalSeatsSilver:" + totalSeatsSilver +"\n"+
                "\t->totalSeatsBronze:" + totalSeatsBronze +"\n"+
                "\t->totalSeatsGeneral:" + totalSeatsGeneral +"\n"+
                "\t->totalVipRevenue:" + totalVipRevenue +"\n"+
                "\t->totalGoldRevenue:" + totalGoldRevenue +"\n"+
                "\t->totalSilverRevenue:" + totalSilverRevenue +"\n"+
                "\t->totalBronzeRevenue:" + totalBronzeRevenue +"\n"+
                "\t->totalGeneralRevenue:" + totalGeneralRevenue+"\n"+
                "\t->Actual profit:"+actualProfit();
    }
}