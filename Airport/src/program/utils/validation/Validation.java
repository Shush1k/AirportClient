package program.utils.validation;

import javafx.stage.Stage;
import program.models.RegistrationEditModel;
import program.utils.alerts.Alerts;

public class Validation {

    /**
     * Проверка полей регистрации на корректность
     * @param model - регистрационная модель
     * @param stage
     * @return
     */
    public static boolean RegistrationDataValidation(RegistrationEditModel model, Stage stage) {
        String errorMessage = "";
        if (model.firstNameField.getText() == null || model.firstNameField.getText().length() == 0)
            errorMessage += "Нет имени!\n";
        if (model.lastNameField.getText() == null || model.lastNameField.getText().length() == 0)
            errorMessage += "Нет фамилии!\n";
        if (model.loginField.getText() == null || model.loginField.getText().length() == 0)
            errorMessage += "Нет логина!\n";
        if (model.emailField.getText() == null || model.emailField.getText().length() == 0)
            errorMessage += "Нет почты!\n";
        if (model.passwordField.getText() == null || model.passwordField.getText().length() == 0)
            errorMessage += "Нет пароля!\n";
        if (model.repeatPasswordField.getText() == null || model.repeatPasswordField.getText().length() == 0)
            errorMessage += "Нет повтора пароля!\n";
        if ((model.passwordField.getText() != null && model.repeatPasswordField.getText() != null) &&
                !model.passwordField.getText().equals(model.repeatPasswordField.getText()))
            errorMessage += "Повтор пароля не совпадает с паролем!\n";

        if (errorMessage.length() == 0) return true;
        else {
            Alerts.showNoValidInput(stage, errorMessage.substring(0, errorMessage.length() - 1));
            return false;
        }
    }

}
