package program.utils.api;

import javafx.beans.property.ObjectProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс конвертации LocalDateTime в строку и обратно
 */
public class DateConvert {
    public static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

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
     * Конвертация строки в дату и время
     *
     * @param date - строка даты и времени
     * @return дата и время(LocalDateTime)
     */
    public static LocalDateTime stringToDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        return LocalDateTime.parse(date, formatter);
    }

    /**
     * Конвертация строки в дату
     *
     * @param date - строка даты
     * @return дата (LocalDate)
     */
    public static LocalDate stringToDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return LocalDate.parse(date, formatter);
    }
}
