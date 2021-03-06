package core.java.java8.date.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

public class DateTimePractice {

	/**
	 * java.time.Clock practice
	 */
	@Ignore
	@Test
	public void clock() {
		Clock clock = Clock.systemUTC();
		System.out.println("clock.instant(): " + clock.instant());
		System.out.println("clock.millis(): " + clock.millis());
		System.out.println("clock.getZone(): " + clock.getZone());
	}

	/**
	 * java.time.LocalDate practice. This class will have only date part without time part
	 */
	@Ignore
	@Test
	public void localDate() {
		LocalDate localDate1 = LocalDate.now();
		System.out.println("localDate: " + localDate1);

		Clock clock1 = Clock.systemUTC();
		LocalDate localDate2 = LocalDate.now(clock1);
		System.out.println("localDate2: " + localDate2);
	}

	/**
	 * java.time.LocalTime practice. This class will have only time part without date
	 */
	@Ignore
	@Test
	public void localTime() {
		LocalTime localTime1 = LocalTime.now();
		System.out.println("localTime1: " + localTime1);

		Clock clock1 = Clock.systemUTC();
		LocalTime localTime2 = LocalTime.now(clock1);
		System.out.println("localTime2: " + localTime2);

		Clock clock2 = Clock.systemDefaultZone();
		LocalTime localTime3 = LocalTime.now(clock2);
		System.out.println("localTime3: " + localTime3);
	}

	/**
	 * java.time.LocalDateTime practice. This class useful to work on date or time or both
	 */
	@Ignore
	@Test
	public void localDateTime() {
		LocalDateTime localDateTime1 = LocalDateTime.now();
		System.out.println("localDateTime1: " + localDateTime1);

		Clock clock1 = Clock.systemUTC();
		LocalDateTime localDateTime2 = LocalDateTime.now(clock1);
		System.out.println("localDateTime2: " + localDateTime2);

		Clock clock2 = Clock.systemDefaultZone();
		LocalDateTime localDateTime3 = LocalDateTime.now(clock2);
		System.out.println("localDateTime3: " + localDateTime3);
	}

	/**
	 * java.time.ZonedDateTime practice
	 */
	@Ignore
	@Test
	public void zonedDateTime() {
		ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
		System.out.println("zonedDateTime1: " + zonedDateTime1);

		Clock clock1 = Clock.systemUTC();
		ZonedDateTime zonedDateTime2 = ZonedDateTime.now(clock1);
		System.out.println("zonedDateTime2: " + zonedDateTime2);

		ZonedDateTime zonedDateTime3 = ZonedDateTime.now(ZoneId.of("Asia/Calcutta"));
		System.out.println("zonedDateTime3: " + zonedDateTime3);
	}

	/**
	 * java.time.Duration practice.
	 */
	@Ignore
	@Test
	public void duration() {
		LocalDateTime localDateTime1 = LocalDateTime.of(2014, Month.NOVEMBER, 27, 15, 50);
		LocalDateTime localDateTime2 = LocalDateTime.of(2016, Month.NOVEMBER, 27, 15, 50);

		Duration duration1 = Duration.between(localDateTime1, localDateTime2);
		System.out.println("duration1: " + duration1);
		System.out.println("days: " + duration1.toDays());
		System.out.println("months: " + duration1.toDays() / 30);
		System.out.println("years: " + (duration1.toDays() / 30) / 12);
		System.out.println("hours: " + duration1.toHours());
		System.out.println("minutes: " + duration1.toMinutes());
		System.out.println("seconds: " + duration1.getSeconds());
	}

	/**
	 * Add 1 day, 1 week, 1 month to date
	 */
	@Ignore
	@Test
	public void addDayWeekMonth() {
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate: " + localDate);

		// add 1 day
		LocalDate tomorrow = localDate.plus(1, ChronoUnit.DAYS);
		System.out.println("tomorrow: " + tomorrow);

		// add 1 week
		LocalDate nextWeek = localDate.plus(1, ChronoUnit.WEEKS);
		System.out.println("nextWeek: " + nextWeek);

		// add 1 month
		LocalDate nextMonth = localDate.plus(1, ChronoUnit.MONTHS);
		System.out.println("nextMonth: " + nextMonth);

		// add 1 year
		LocalDate nextYear = localDate.plus(1, ChronoUnit.YEARS);
		System.out.println("nextYear: " + nextYear);

		// add 10 years
		LocalDate nextDecade = localDate.plus(1, ChronoUnit.DECADES);
		System.out.println("nextDecade: " + nextDecade);
	}

	/**
	 * Get next Sunday
	 */
	@Ignore
	@Test
	public void nextSunday() {
		LocalDate today = LocalDate.now();
		LocalDate nextSunday = today.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println("next sunday: " + nextSunday);
	}

	/**
	 * Get next Saturday of next month
	 */
	@Ignore
	@Test
	public void nextMonthSecondSaturday() {
		LocalDate today = LocalDate.now();
		LocalDate nextMonthSecondSaturday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
				.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Next month second saturday: " + nextMonthSecondSaturday);
	}

	@Ignore
	@Test
	public void convertUtilDateToLocalDate() {
		Date date = new Date();
		System.out.println("convertUtilDateToLocalDate() date: " + date);

		Instant instant = date.toInstant();
		System.out.println("convertUtilDateToLocalDate() instant: " + instant);

		ZoneId systemDefaultZoneId = ZoneId.systemDefault();
		LocalDate localDate = instant.atZone(systemDefaultZoneId).toLocalDate();
		System.out.println("convertUtilDateToLocalDate() localDate: " + localDate);
	}

	@Ignore
	@Test
	public void convertLocalDateToUtilDate() {
		LocalDate localDate = LocalDate.now();
		System.out.println("convertLocalDateToUtilDate() localDate: " + localDate);

		ZoneId zoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());
		System.out.println("convertLocalDateToUtilDate() date: " + date);
	}

	@Ignore
	@Test
	public void convertUtilDateToLocalDateTime() {
		Date date = new Date();
		System.out.println("convertUtilDateToLocalDateTime() date: " + date);

		// method 1
		Instant instant = date.toInstant();
		System.out.println("convertUtilDateToLocalDateTime() instant: " + instant);

		ZoneId systemDefaultZoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = instant.atZone(systemDefaultZoneId).toLocalDateTime();
		System.out.println("convertUtilDateToLocalDateTime() localDateTime: " + localDateTime);

		// method 2
		LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant, systemDefaultZoneId);
		System.out.println("localDateTime2: " + localDateTime2);
	}

	@Ignore
	@Test
	public void convertLocalDateTimeToUtilDate() {
		Clock clock = Clock.systemDefaultZone();
		LocalDateTime localDateTime = LocalDateTime.now(clock);
		System.out.println("convertLocalDateTimeToUtilDate() localDateTime: " + localDateTime);

		ZoneId zoneId = ZoneId.systemDefault();
		Date date = Date.from(localDateTime.atZone(zoneId).toInstant());
		System.out.println("convertLocalDateTimeToUtilDate() date: " + date);
	}

	@Ignore
	@Test
	public void convertUtilDateToLocalTime() {
		Date date = new Date();
		System.out.println("convertUtilDateToLocalTime() date: " + date);

		Instant instant = date.toInstant();
		System.out.println("convertUtilDateToLocalTime() instant: " + instant);

		ZoneId systemDefaultZoneId = ZoneId.systemDefault();
		LocalTime localTime = instant.atZone(systemDefaultZoneId).toLocalTime();
		System.out.println("convertUtilDateToLocalTime() localTime: " + localTime);
	}

	@Ignore
	@Test
	public void convertUtilDateToZonedDateTime() {
		Date date = new Date();
		System.out.println("date: " + date);

		// method 1
		Instant instant = date.toInstant();
		System.out.println("instant: " + instant);

		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = instant.atZone(zoneId);
		System.out.println("zonedDateTime: " + zonedDateTime);

		// method 2
		ZonedDateTime zonedDateTime2 = ZonedDateTime.ofInstant(instant, zoneId);
		System.out.println("zonedDateTime2: " + zonedDateTime2);
	}

	@Ignore
	@Test
	public void convertZonedDateTimeToUtilDate() {
		Clock clock = Clock.systemDefaultZone();
		ZonedDateTime zonedDateTime = ZonedDateTime.now(clock);
		System.out.println("convertZonedDateTimeToUtilDate() zonedDateTime: " + zonedDateTime);

		Date date = Date.from(zonedDateTime.toInstant());
		System.out.println("convertZonedDateTimeToUtilDate() date: " + date);
	}

	@Ignore
	@Test
	public void convertLocalDateTimeToZonedDateTime() {
		Clock clock = Clock.systemDefaultZone();
		LocalDateTime localDateTime = LocalDateTime.now(clock);
		System.out.println("convertLocalDateTimeToZonedDateTime() localDateTime: " + localDateTime);

		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		System.out.println("convertLocalDateTimeToZonedDateTime() zonedDateTime: " + zonedDateTime);
	}

	/**
	 * Method to convert one date format to another date format
	 * @throws ParseException 
	 */
	@Ignore
	@Test
	public void converDateFormat1() throws ParseException {
		/*convert date from yyyy-mm-dd to mm/dd/yyyy*/
		DateFormat fromFormat1 = new SimpleDateFormat("yyyy-mm-dd");
		DateFormat toFormat1 = new SimpleDateFormat("mm/dd/yyyy");

		Date date = fromFormat1.parse("2017-01-27");
		String convertedDate1 = toFormat1.format(date);
		System.out.println("convertedDate1: " + convertedDate1);

		/*convert date from yyyy-mm-dd to dd/mm/yyyy*/
		DateFormat fromFormat2 = new SimpleDateFormat("yyyy-mm-dd");
		DateFormat toFormat2 = new SimpleDateFormat("dd/mm/yyyy");
		Date date2 = fromFormat2.parse("2017-01-27");
		String convertedDate2 = toFormat2.format(date2);
		System.out.println("convertedDate2: " + convertedDate2);

		/*convert date from dd/mm/yyyy to yyyy-mm-dd*/
		DateFormat fromFormat3 = new SimpleDateFormat("dd/mm/yyyy");
		DateFormat toFormat3 = new SimpleDateFormat("yyyy-mm-dd");
		Date date3 = fromFormat3.parse("27/01/2017");
		String convertedDate3 = toFormat3.format(date3);
		System.out.println("convertedDate3: " + convertedDate3);

		/* dd/MMM/yyyy == convert date format. Display short form of month like Jan, May
		 * hh:mm:ss ==  time in 12 hours format. 
		 * HH:mm:ss == time in 24 hours format
		 * a == display AM/PM*/
		DateFormat dateFormat4 = new SimpleDateFormat("dd/MMM/yyyy hh:mm:ss a");
		Date date4 = new Date();
		String convertedDate4 = dateFormat4.format(date4);
		System.out.println("convertedDate4: " + convertedDate4);
	}

	/**
	 * Convert String to java.util.Date
	 * 
	 * String to Date -> SimpleDateFormat.parse(String)
	 * Date to String -> SimpleDateFormat.format(date)
	 * @throws ParseException 
	 */
	@Ignore
	@Test
	public void convertStringToUtilDate() throws ParseException {
		// 20-Jul-2017
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
		String date1 = "20-Jul-2017";

		Date convertedDate1 = simpleDateFormat1.parse(date1);
		System.out.println("convertedDate1: " + convertedDate1);
		System.out.println("simpleDateFormat1.format(convertedDate1): "
				+ simpleDateFormat1.format(convertedDate1));

		// 20/07/2017
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
		String date2 = "20/07/2017";
		Date convertedDate2 = simpleDateFormat2.parse(date2);
		System.out.println("convertedDate2: " + convertedDate2);
		System.out.println("simpleDateFormat2.format(convertedDate2): "
				+ simpleDateFormat2.format(convertedDate2));

		//Thu, July 20 2017
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("E, MMM dd yyyy");
		String date3 = "Thu, July 20 2017";
		Date convertedDate3 = simpleDateFormat3.parse(date3);
		System.out.println("convertedDate3: " + convertedDate3);
		System.out.println("simpleDateFormat3.format(convertedDate3): "
				+ simpleDateFormat3.format(convertedDate3));

		//Thursday, July 10 2017 12:10:08 PM
		SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("EEEE, MMM dd yyyy HH:mm:ss a");
		String date4 = "Thursday, July 20 2017 12:10:08 PM";
		Date convertedDate4 = simpleDateFormat4.parse(date4);
		System.out.println("convertedDate4: " + convertedDate4);
		System.out.println("simpleDateFormat4.format(convertedDate4): "
				+ simpleDateFormat4.format(convertedDate4));
	}

	/**
	 * Convert String to java.time.LocalDate
	 */
	@Ignore
	@Test
	public void convertStringToLocalDate() {
		// 20/07/2017
		String date1 = "20/07/2017";
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate localDate1 = LocalDate.parse(date1, formatter1);
		System.out.println("localDate1: " + localDate1);
		System.out.println("formatter1.format(localDate1): " + formatter1.format(localDate1));

		//20-07-2017
		String date2 = "2017-07-21";
		LocalDate localDate2 = LocalDate.parse(date2);
		System.out.println("localDate2: " + localDate2);

		// 20-Jul-2017
		String date3 = "20-Jul-2017";
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		LocalDate localDate3 = LocalDate.parse(date3, formatter2);
		System.out.println("localDate3: " + localDate3);
		System.out.println("formatter2.format(localDate3): " + formatter2.format(localDate3));

		//Thu, Jul 20 2017
		String date4 = "Thu, Jul 20 2017";
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("E, MMM d yyyy");
		LocalDate localDate4 = LocalDate.parse(date4, formatter3);
		System.out.println("localDate4: " + localDate4);
		System.out.println("formatter3.format(localDate4): " + formatter3.format(localDate4));

		//Thursday, Jul 10 2017 12:10:08 PM
		String date5 = "Thursday, Jul 20 2017 12:10:08 PM";
		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("EEEE, MMM d yyyy HH:mm:ss a");
		LocalDateTime localDate5 = LocalDateTime.parse(date5, formatter4);
		System.out.println("localDate5: " + localDate5);
		System.out.println("formatter4.format(localDate5): " + formatter4.format(localDate5));
	}

	/**
	 * Print day of week if date is given
	 */
	@Ignore
	@Test
	public void getDayOfWeek() {
		int year = 2015;
		int month = 8;
		int day = 5;

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		Date date = calendar.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
		System.out.println(simpleDateFormat.format(date).toUpperCase());
	}

}