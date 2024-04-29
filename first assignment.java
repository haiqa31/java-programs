import java.util.Scanner; import java.time.LocalDate; import java.time.format.DateTimeFormatter; import java.time.temporal.ChronoUnit;

public class DateDifferenceCalculator { public static void main(String[] args) { Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the first date (YYYY-MM-DD):");
    String firstDateStr = scanner.nextLine();
    
    System.out.println("Enter the second date (YYYY-MM-DD):");
    String secondDateStr = scanner.nextLine();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate firstDate = LocalDate.parse(firstDateStr, formatter);
    LocalDate secondDate = LocalDate.parse(secondDateStr, formatter);

    long differenceInDays = ChronoUnit.DAYS.between(firstDate, secondDate);
    
    System.out.println("Difference between the dates in days: " + Math.abs(differenceInDays));
}
}

///TIME CONVERSION:

import java.time.LocalTime; 

public class TimeConverter { public static void main(String[] args) { Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the time in 24-hour format (HH:mm):");
    String time24Hour = scanner.nextLine();

    DateTimeFormatter formatter24Hour = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime time = LocalTime.parse(time24Hour, formatter24Hour);

    DateTimeFormatter formatter12Hour = DateTimeFormatter.ofPattern("h:mm a");
    String time12Hour = time.format(formatter12Hour);
    
    System.out.println("Time in 12-hour format: " + time12Hour);
}
}

///BIRTHDAY CALCULATOR:

import java.time.Period;

public class AgeCalculator { public static void main(String[] args) { Scanner scanner = new Scanner(System.in);

    System.out.println("Enter your birth date (YYYY-MM-DD):");
    String birthDateStr = scanner.nextLine();

    LocalDate birthDate = LocalDate.parse(birthDateStr);

    LocalDate currentDate = LocalDate.now();
    Period age = Period.between(birthDate, currentDate);

    System.out.println("Your current age is: " + age.getYears() + " years");
}
}

///DATE PARSING:

import java.time.format.DateTimeParseException;

public class DateParser { public static void main(String[] args) { Scanner scanner = new Scanner(System.in);

    System.out.println("Enter a date in the format yyyy-MM-dd:");
    String dateString = scanner.nextLine();
    
    try {
        LocalDate date = LocalDate.parse(dateString);
        System.out.println("Parsed date: " + date);
    } catch (DateTimeParseException e) {
        System.out.println("Error: Invalid date format. Please enter date in yyyy-MM-dd format.");
    }
}
}

///DURATION BETWEEN EVENT:

import java.time.LocalDateTime; import java.time.Duration;

public class EventDurationCalculator { public static void main(String[] args) {

    LocalDateTime startTime = LocalDateTime.of(2024, 4, 26, 9, 0);
    LocalDateTime endTime = LocalDateTime.of(2024, 4, 26, 13, 30);

    Duration duration = Duration.between(startTime, endTime);

    long hours = duration.toHours();
    long minutes = duration.toMinutes() % 60;
    
    System.out.println("Event duration: " + hours + " hours " + minutes + " minutes");
}
}

///TIME ZONE CONVERSION:

import java.time.ZoneId; import java.time.ZonedDateTime;  

public class TimeZoneConverter { public static void main(String[] args) { Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the date and time (yyyy-MM-dd HH:mm:ss): ");
    String dateTimeStr = scanner.nextLine();
    LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    System.out.println("Enter the source time zone (e.g., UTC): ");
    String sourceTimeZone = scanner.nextLine();

    System.out.println("Enter the target time zone (e.g., America/Los_Angeles): ");
    String targetTimeZone = scanner.nextLine();
    ZonedDateTime sourceZonedDateTime = localDateTime.atZone(ZoneId.of(sourceTimeZone));

    ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimeZone));

    System.out.println("Converted date and time in " + targetTimeZone + ": " + targetZonedDateTime);
}
}

///PERIODIC REMINDER:

import java.util.Date; import java.util.Timer; import java.util.TimerTask; import java.text.SimpleDateFormat;

public class ReminderSystem {
     public static void main(String[] args) {

    String reminderDateTime = "2024-04-27 15:30"; 
    String reminderMessage = "Don't forget to call ZAINAB.";

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Date reminderDate = null;
    try {
        reminderDate = dateFormat.parse(reminderDateTime);
    } catch (Exception e) {
        System.out.println("Invalid date format. Please use format: yyyy-MM-dd HH:mm");
        return;
    }

    Timer timer = new Timer();
    timer.schedule(new ReminderTask(reminderMessage), reminderDate);
}
}

class ReminderTask extends TimerTask { private String message;

public ReminderTask(String message) {
    this.message = message;
}

public void run() {
    System.out.println("Reminder: " + message);
}
}

///DATE AND TIME VALIDATION:

import java.text.ParseException;  

public class DateTimeValidator {
     public static void main(String[] args) { 
        String userInput = "2024-04-27 15:30";

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Date currentDate = new Date();

    try {
        Date inputDate = dateFormat.parse(userInput);
     
        if (inputDate.after(currentDate)) {
            System.out.println("Input is a valid future date and time.");
        } else {
            System.out.println("Input must be a future date and time.");
        }
    } catch (ParseException e) {
        System.out.println("Invalid date and time format. Please use format: yyyy-MM-dd HH:mm");
    }
}
}

///HOLIDAY CALENDAR:

import java.util.HashMap; import java.util.Map;

public class HolidayList { public static void main(String[] args) {

    int year = 2024; 

    Map<String, String> holidays = new HashMap<>();
    holidays.put("New Year's Day", "-01-01");
    holidays.put("Valentine's Day", "-02-14");
    holidays.put("St. Patrick's Day", "-03-17");
    holidays.put("Easter Sunday", "-04-21"); 
    holidays.put("Independence Day", "-07-04");
    holidays.put("Halloween", "-10-31");
    holidays.put("Thanksgiving Day", "-11-28"); 
    holidays.put("Christmas Day", "-12-25");

    System.out.println("Major holidays for " + year + ":");
    for (String holiday : holidays.keySet()) {
        String date = holidays.get(holiday);
        LocalDate holidayDate = LocalDate.parse(year + date);
        System.out.println("- " + holiday + ": " + holidayDate.getDayOfWeek() + ", " + holidayDate);
    }
}
}