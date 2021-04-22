package program.utils.validation;

import javafx.stage.Stage;
import program.models.BoardModel;
import program.utils.alerts.Alerts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidation {
    public static final String PATTERN = "yyyy-MM-dd HH:mm";

    /**
     * Проверка, что оба поля пустые
     *
     * @param model - модель
     * @param stage - текущее окно
     * @return
     */
    public static boolean isBothDatesBlank(BoardModel model, Stage stage) {
        int fieldCount = 0;
        if (model.startDateField.getText() == null || model.startDateField.getText().length() == 0) {
            fieldCount++;
        }
        if (model.endDateField.getText() == null || model.endDateField.getText().length() == 0){
            fieldCount++;
        }
        if (fieldCount == 2) return true;
        return false;
    }

    /**
     * Проверка, если одно поле пустое
     *
     * @param model - модель
     * @param stage - текущее окно
     * @return true - если все верно
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
     * Валидация формата даты
     *
     * @param model - модель
     * @param stage - текущее окно
     * @return
     */
    public static boolean isValidDateFormat(BoardModel model, Stage stage){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        try {
            LocalDateTime.parse(model.startDateField.getText(), formatter);
            LocalDateTime.parse(model.endDateField.getText(), formatter);
        } catch (DateTimeParseException e){
            Alerts.showNoValidDateFormat(stage);
            return false;
        }
        return true;
    }
}
