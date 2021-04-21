package program.utils.validation;

import javafx.stage.Stage;
import program.models.BoardModel;
import program.utils.alerts.Alerts;

public class DateValidation {

    /**
     * Проверка заполнены ли поля с датами
     *
     * @param model - модель
     * @param stage - текущее окно
     * @return
     */
    public static boolean isValidDate(BoardModel model, Stage stage) {

        String errorMessage = "";
        if (model.startDateField.getText() == null || model.startDateField.getText().length() == 0)
            errorMessage += "Нет начальной даты!\n";
        if (model.endDateField.getText() == null || model.endDateField.getText().length() == 0)
            errorMessage += "Нет конечной даты!\n";
        if (errorMessage.length() == 0) return true;
        else {
            Alerts.showNoValidInput(stage, errorMessage.substring(0, errorMessage.length() - 1));
            return false;
        }
    }

// TODO: формат отправления даты
    public static boolean isDateFormat(){
        return true;
    }
}
