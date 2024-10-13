package src.main.java.MyCode;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ChekTime {

    public static void main(String[] args) {

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime reportEndTime = LocalDateTime.now(ZoneOffset.UTC);
        ZonedDateTime ldtZoned = start.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC"));
        //ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));
        LocalDateTime utcTime = ldtZoned.toLocalDateTime();



        System.out.println("local date india " + start);
        System.out.println("UTC timing for end  " + reportEndTime);
        System.out.println("UTC timing for string  " + utcTime);
        System.out.println("convereted timing for string  " + reportEndTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("convereted timing for string  " + reportEndTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        if(start.format(DateTimeFormatter.ISO_DATE_TIME).equals(start.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
        {
            System.out.println("true");
        } else {
            System.out.println("false");
        }





    }
}
