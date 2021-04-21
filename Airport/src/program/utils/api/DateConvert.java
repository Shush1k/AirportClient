package program.utils.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConvert {
    public static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    public static String dateToString(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        return date.format(formatter);
    }

    public static LocalDateTime stringToDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);

        return LocalDateTime.parse(date, formatter);
    }

}
