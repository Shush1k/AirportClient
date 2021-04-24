package program.utils.validation;

import javafx.stage.Stage;
import program.models.BoardModel;
import program.utils.alerts.Alerts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidation {
    public static final String PATTERN = "yyyy-MM-dd HH:mm";

    /**
     * Проверка, что оба поля пустые
     *
     * @param model - модель
     * @return
     */
    public static boolean isBothDatesBlank(BoardModel model) {
        int fieldCount = 0;
        if (model.startDateField.getText() == null || model.startDateField.getText().length() == 0) {
            fieldCount++;
        }
        if (model.endDateField.getText() == null || model.endDateField.getText().length() == 0) {
            fieldCount++;
        }
        if (fieldCount == 2) return true;
        return false;
    }

    /**
     * Проверка, если одно поле пустое
     *
     * @param model модель
     * @param stage текущее окно
     * @return true если все верно
     */
    public static boolean isOneDateBlank(BoardModel model, Stage stage) {
        String errorMessage = "";
        if (model.startDateField.getText() == null || model.startDateField.getText().length() == 0) {
            errorMessage += "Заполните первую дату!\n";
        } else {
            if (model.endDateField.getText() == null || model.endDateField.getText().length() == 0) {
                errorMessage += "Заполните вторую дату!\n";
            }
        }
        if (errorMessage.length() == 0) return true;
        else {
            Alerts.showNoValidInput(stage, errorMessage.substring(0, errorMessage.length() - 1));
            return false;
        }
    }

    /**
     * Валидация формата даты и попадание ее в временной диапазон
     * вчера-завтра
     *
     * @param model модель
     * @param stage текущее окно
     * @return true если все верно
     */
    public static boolean isDateYesterdayTodayTomorrow(BoardModel model, Stage stage) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate tomorrow = today.plusDays(1);

        // если поля ввода дат пустые
        if ((model.startDateField.getText() == null) && (model.endDateField.getText() == null)) {
            LocalDate startDateTime = LocalDate.from(yesterday);
            LocalDate endDateTime = LocalDate.from(tomorrow);
            return true;
        } else {
            try {
                LocalDate startDateTime = LocalDate.parse(model.startDateField.getText(), formatter);
                LocalDate endDateTime = LocalDate.parse(model.endDateField.getText(), formatter);
                if ((LocalDate.from(startDateTime).isBefore(yesterday)) || (LocalDate.from(endDateTime).isAfter(tomorrow))) {
                    Alerts.showNoValidDateFormat(stage);
                    return false;
                }
            } catch (DateTimeParseException e) {
                Alerts.showNoValidDateFormat(stage);
                return false;
            }
        }

        return true;
    }

}
