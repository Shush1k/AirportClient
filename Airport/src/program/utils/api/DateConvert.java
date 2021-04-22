package program.utils.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс конвертации LocalDateTime в строку и обратно
 */
public class DateConvert {
    public static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

    /**
     * Конвертация даты в строку
     *
     * @param date - дата (LocalDateTime)
     * @return строка, в заданном формате
     */
    public static String dateToString(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        return date.format(formatter);
    }

    /**
     * Конвертация строки в дату
     *
     * @param date - строка даты
     * @return дата (LocalDateTime)
     */
    public static LocalDateTime stringToDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        return LocalDateTime.parse(date, formatter);
    }

}
