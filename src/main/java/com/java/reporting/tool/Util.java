package com.java.reporting.tool;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*This class is for the purpose of utility functions used by the springboot main class*/
public class Util {

	private static final Set<String> CURRENCY_DIFFERENT_WORKWEEK = new HashSet<>(Arrays.asList("AED", "SAR"));
	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd-MMM-yyyy", java.util.Locale.ENGLISH);

	/*This method sets the settlement date
	1) Parse the date into the format - dd-MMM-yyyy
	2) Get the day of the week (it returns an int where Sunday = 1, Saturday =7)
	3) Check if the currency is AED/SAR, then if the given settle date is not within sun- thu, change it to the appropriate next working day
	4) Else check if the given settle date is not within mon - fri, change it to the appropriate next working day
	5) return in the same format as input  
	*/

	public String getSettlementDate(String currency, String date) {
		
		Calendar calendar = Calendar.getInstance();
		Date currentDate;
		try {
			currentDate = FORMATTER.parse(date.replaceAll("\\s", "-"));
			calendar.setTime(currentDate);
		} catch (ParseException e) {
			System.out.println("Error in parsing the settlement date");
		}

		int weekday = calendar.get(Calendar.DAY_OF_WEEK);

		if (CURRENCY_DIFFERENT_WORKWEEK.contains(currency)) {
			if (weekday == 6 || weekday == 7) {
				int days = getDays(weekday,true);
				calendar.add(Calendar.DAY_OF_YEAR, days);
			}
		} else {
			if (weekday == 1 || weekday == 7) {
				int days = getDays(weekday,false);
				calendar.add(Calendar.DAY_OF_YEAR, days);
			}
		}

		Date addDate = calendar.getTime();
		String newFormattedDate = FORMATTER.format(addDate);
		return newFormattedDate.replaceAll("-", " ");
		

	}

	/*This method gets the number of days that needss to be added to a current settlement day to make it an appropriate working day settlement date.
	1) Case 1 is when the day is a sunday- occurs in case the currency is not AED/SAR - then  add one day to the calendar to make it monday.
	2) Case 6 is when the day is Friday - occurs in the case where currency is AED/SAR - then  add 2 days to make it  Sunday.
	3) Case 7 is when the day is a saturday- occurs in both cases - if AED/SAR then  add one day to the calendar to make it Sunday else two days to make it Monday.
	*/
	
	public int getDays(int day,boolean val) {

		switch (day) {
		case 1:
			return (1 % 7);

		case 6:
			return (Calendar.SATURDAY - day + 1) % 7;

		case 7:
			if(val) {
				return (Calendar.SATURDAY - day + 1) % 7;
			}
			else {
				return (Calendar.SATURDAY - day + 2) % 7;
			}

		}
		return day;
	}
	
	void printRanking(Map<String, BigDecimal> map) {
		map.entrySet().stream().sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed()).limit(10)
				.forEach(System.out::println);
	}
}
