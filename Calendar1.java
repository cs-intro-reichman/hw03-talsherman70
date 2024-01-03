/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable is used for debugging purposes:
	    // It counts how many days were advanced so far.
	    int debugDaysCounter = 0; 
	    // Counts how many times Sundays fell on the first day of the month
		int nSundaysOnFirstOfMonth = 0;
	 	while (year < 2000) {
	 		System.out.print(dayOfMonth + "/" + month + "/" + year); 
	 		if (dayOfWeek == 1) {
	 			System.out.print(" Sunday");
	 		}
	 		System.out.println();
	 		
	 		// If the day is a Sunday, and it falls on the first of the month, counts it.
	 		if ( (dayOfWeek == 1) && (dayOfMonth == 1)) {
	 			nSundaysOnFirstOfMonth++;
	 		}
	
	 		advance();
	 		debugDaysCounter++;
	 		//// If you want to stop the loop after n days, replace the condition of the
	 		//// if statement with the condition (debugDaysCounter == n)
	 		if (false) { 
	 			break;
	 		}
        }
	 	System.out.println("During the 20th century, " + nSundaysOnFirstOfMonth + 
	 		               " Sundays fell on the first day of the month");
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		dayOfMonth++;
        if (dayOfMonth > nDaysInMonth) {
       	    dayOfMonth = 1;
       	    month++;
          	nDaysInMonth = nDaysInMonth(month, year);
        }
       	if (month > 12) {
       	    month = 1;
       	    year++;
       	}
       	dayOfWeek = (dayOfWeek + 1) % 7;
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    if ((year % 400) == 0) {
		    return true;
		}
		if ( ((year % 4) == 0) && ((year % 100) != 0) ) {
			return true;
		}
		return false;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		switch (month) {
	        case 4:  return 30;
	        case 6:  return 30;
 	        case 9:  return 30;
	        case 11: return 30;
            case 2:  
         	         if (isLeapYear(year)) {
                         return 29;
	 			     }
	 			     else {
	 				     return 28;
	 			     }
            default: return 31;
		}
	}
}