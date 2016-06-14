package com.li.pulljar;

import java.util.Locale;
import java.util.TimeZone;
import hirondelle.date4j.DateTime;

public class Date4JTest {
	public static void main(String [] args){
		DateTime dateAndTime = new DateTime("2010-01-19 23:59:59");
//		DateTime dateAndTime = new DateTime("2010-01-19 23:59:59.123456789");
		DateTime dateOnly = new DateTime("2010-01-19");
		DateTime timeOnly = new DateTime("23:59:59");
//		DateTime dateOnly = DateTime.forDateOnly(2010,01,19);
//		DateTime timeOnly = DateTime.forTimeOnly(23,59,59,0);

		DateTime dt = new DateTime("2010-01-15 13:59:15");
//		DateTime dtt = new DateTime();
		dt.format("YYYYMMDD hhmmss");
		System.out.print(dt.toString());
		boolean leap = dt.isLeapYear(); //false
		dt.getNumDaysInMonth(); //31
		dt.getStartOfMonth(); //2010-01-01, 00:00:00.000000000
		dt.getEndOfDay(); //2010-01-15, 23:59:59.999999999
		dt.format("YYYY-MM-DD"); //formats as '2010-01-15'
		dt.plusDays(30); //30 days after Jan 15
//		dt.numDaysFrom(someDate); //returns an int
//		dueDate.lt(someDate); //less-than
//		dueDate.lteq(someDate); //less-than-or-equal-to
		
		Date4JTest examples = new Date4JTest();
		examples.currentDateTime();
		examples.currentDateTimeInCairo();
		examples.ageIfBornOnCertainDate();
		examples.optionsExpiry();
		examples.daysTillChristmas();
		examples.whenIs90DaysFromToday();
		examples.whenIs3Months5DaysFromToday();
		examples.hoursDifferenceBetweenParisAndPerth();
		examples.weeksSinceStart();
		examples.timeTillMidnight();
		examples.imitateISOFormat();
		examples.firstDayOfThisWeek();
		examples.jdkDatesSuctorial();
	}
	
	private static void log(Object aMsg) {
		System.out.println(String.valueOf(aMsg));
	}

	private void currentDateTime() {
		DateTime now = DateTime.now(TimeZone.getDefault());
//		String result = now.format("YYYY-MM-DD hh:mm:ss");
		String result = now.format("YYYYMMDDhhmmss");
		log("Current date-time in default time zone : " + result);
	}

	private void currentDateTimeInCairo() {
		DateTime now = DateTime.now(TimeZone.getTimeZone("Africa/Cairo"));
		String result = now.format("YYYY-MM-DD hh:mm:ss (WWWW)",
				Locale.getDefault());
		log("Current date-time in Cairo : " + result);
	}

	private void ageIfBornOnCertainDate() {
		DateTime today = DateTime.today(TimeZone.getDefault());
		DateTime birthdate = DateTime.forDateOnly(Integer.valueOf(1995),
				Integer.valueOf(5), Integer.valueOf(16));
		int age = today.getYear().intValue() - birthdate.getYear().intValue();
		if (today.getDayOfYear().intValue() < birthdate.getDayOfYear()
				.intValue()) {
			age -= 1;
		}
		log("Age of someone born May 16, 1995 is : " + age);
	}

	private void optionsExpiry() {
		DateTime today = DateTime.today(TimeZone.getDefault());
		DateTime firstOfMonth = today.getStartOfMonth();
		int result = 0;
		if (firstOfMonth.getWeekDay().intValue() == 7) {
			result = 21;
		} else {
			result = 21 - firstOfMonth.getWeekDay().intValue();
		}
		DateTime thirdFriday = DateTime.forDateOnly(firstOfMonth.getYear(),
				firstOfMonth.getMonth(), Integer.valueOf(result));
		log("The 3rd Friday of this month is : "
				+ thirdFriday.format("YYYY-MM-DD"));
	}

	private void daysTillChristmas() {
		DateTime today = DateTime.today(TimeZone.getDefault());
		DateTime christmas = DateTime.forDateOnly(today.getYear(),
				Integer.valueOf(12), Integer.valueOf(25));
		int result = 0;
		if (!(today.isSameDayAs(christmas))) {
			if (today.lt(christmas)) {
				result = today.numDaysFrom(christmas);
			} else if (today.gt(christmas)) {
				DateTime christmasNextYear = DateTime.forDateOnly(
						Integer.valueOf(today.getYear().intValue() + 1),
						Integer.valueOf(12), Integer.valueOf(25));
				result = today.numDaysFrom(christmasNextYear);
			}
		}
		log("Number of days till Christmas : " + result);
	}

	private void whenIs90DaysFromToday() {
		DateTime today = DateTime.today(TimeZone.getDefault());
		log("90 days from today is : "
				+ today.plusDays(Integer.valueOf(90)).format("YYYY-MM-DD"));
	}

	private void whenIs3Months5DaysFromToday() {
		DateTime today = DateTime.today(TimeZone.getDefault());
		DateTime result = today.plus(Integer.valueOf(0), Integer.valueOf(3),
				Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0),
				Integer.valueOf(0), Integer.valueOf(0),
				DateTime.DayOverflow.FirstDay);
		log("3 months and 5 days from today is : "
				+ result.format("YYYY-MM-DD"));
	}

	private void hoursDifferenceBetweenParisAndPerth() {
		DateTime paris = DateTime.now(TimeZone.getTimeZone("Europe/Paris"));
		DateTime perth = DateTime.now(TimeZone.getTimeZone("Australia/Perth"));
		int result = perth.getHour().intValue() - paris.getHour().intValue();
		if (result < 0) {
			result += 24;
		}
		log("Numbers of hours difference between Paris and Perth : " + result);
	}

	private void weeksSinceStart() {
		DateTime today = DateTime.today(TimeZone.getDefault());
		DateTime startOfProject = DateTime.forDateOnly(Integer.valueOf(2010),
				Integer.valueOf(9), Integer.valueOf(6));
		int result = today.getWeekIndex().intValue()
				- startOfProject.getWeekIndex().intValue();
		log("The number of weeks since Sep 6, 2010 : " + result);
	}

	private void timeTillMidnight() {
		DateTime now = DateTime.now(TimeZone.getDefault());
		DateTime midnight = now.plusDays(Integer.valueOf(1)).getStartOfDay();
		long result = now.numSecondsFrom(midnight);
		log("This many seconds till midnight : " + result);
	}

	private void imitateISOFormat() {
		DateTime now = DateTime.now(TimeZone.getDefault());
		log("Output using an ISO format: " + now.format("YYYY-MM-DDThh:mm:ss"));
	}

	private void firstDayOfThisWeek() {
		DateTime today = DateTime.today(TimeZone.getDefault());
		DateTime firstDayThisWeek = today;
		int todaysWeekday = today.getWeekDay().intValue();
		int SUNDAY = 1;
		if (todaysWeekday > SUNDAY) {
			int numDaysFromSunday = todaysWeekday - SUNDAY;
			firstDayThisWeek = today.minusDays(Integer
					.valueOf(numDaysFromSunday));
		}
		log("The first day of this week is : " + firstDayThisWeek);
	}

	private void jdkDatesSuctorial() {
		DateTime today = DateTime.today(TimeZone.getDefault());
		DateTime jdkFirstPublished = DateTime.forDateOnly(
				Integer.valueOf(1996), Integer.valueOf(1), Integer.valueOf(23));
		int result = today.getYear().intValue()
				- jdkFirstPublished.getYear().intValue();
		log("The number of years the JDK date-time API has been suctorial : "
				+ result);
	}
}
