import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

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
public class Date implements DateChecker {
    private String date;

    /**
     * Constructor for Date.
     * @param dateFormat Date provided by the user.
     */
    public Date(String dateFormat) {
        this.date = dateFormat;
    }

    /**
     * Method provided by the interface DateChecker to verify if the date fits with the format required.
     * @param dateStr String with a date.
     * @return true or flase.
     */
    @Override
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.date);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Method provided by the interface DateChecker to verify if the date fits with the format required.
     * @param date String with a date.
     * @param dateFormat Date format.
     * @return True or False.
     */
    public  boolean isDatePast(final String date, final String dateFormat) {

        LocalDate localDate = LocalDate.now(ZoneId.systemDefault());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate inputDate = LocalDate.parse(date, dtf);
        return inputDate.isBefore(localDate);
    }
}