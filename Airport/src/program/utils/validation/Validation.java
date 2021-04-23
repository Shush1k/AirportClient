package program.utils.validation;

import javafx.stage.Stage;
import program.models.RegistrationEditModel;
import program.models.SignInModel;
import program.utils.alerts.Alerts;

/**
 * Класс Validation содержит проверки пользовательского ввода
 */
public class Validation {

    /**
     * Проверка полей на корректность через регулярные выражения
     *
     * @param model - модель Регистрации
     * @param stage - текущее окно
     * @return true если нет ошибок
     */
    public static boolean isValidRegistrationRegex(RegistrationEditModel model, Stage stage) {
        if (!RegexValidation.checkStandard(model.firstNameField.getText()))
            Alerts.showNoValidStdRegex(stage, "Имя");
        else if (!RegexValidation.checkStandard(model.lastNameField.getText()))
            Alerts.showNoValidStdRegex(stage, "Фамилия");
        else if (!RegexValidation.checkStandard(model.loginField.getText()))
            Alerts.showNoValidStdRegex(stage, "Логин");
        else if (!RegexValidation.checkPassword(model.passwordField.getText()))
            Alerts.showNoValidPasswordFormat(stage);
        else
            return true;
        return false;
    }

    /**
     * Проверка полей регистрации на корректность
     *
     * @param model - модель Регистрации
     * @param stage - текущее окно
     * @return true если нет ошибок
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
        if (model.passwordRepeatField.getText() == null || model.passwordRepeatField.getText().length() == 0)
            errorMessage += "Нет повтора пароля!\n";
        if ((model.emailField.getText() != null && model.loginField.getText() != null) &&
                !model.emailField.getText().equals(model.loginField.getText())){
            errorMessage += "Логин должен совпадать с почтой!\n";

        }
        if ((model.passwordField.getText() != null && model.passwordRepeatField.getText() != null) &&
                !model.passwordField.getText().equals(model.passwordRepeatField.getText()))
            errorMessage += "Повтор пароля не совпадает с паролем!\n";

        if (errorMessage.length() == 0) return true;
        else {
            Alerts.showNoValidInput(stage, errorMessage.substring(0, errorMessage.length() - 1));
            return false;
        }
    }

    /**
     * Проверка полей изменения информации пользователя на корректность
     *
     * @param model - модель Регистрации
     * @param stage - текущее окно
     * @return true если нет ошибок
     */
    public static boolean EditPersonDataValidation(RegistrationEditModel model, Stage stage) {
        String errorMessage = "";
        if (model.firstNameField.getText() == null || model.firstNameField.getText().length() == 0)
            errorMessage += "Нет имени!\n";
        if (model.lastNameField.getText() == null || model.lastNameField.getText().length() == 0)
            errorMessage += "Нет фамилии!\n";
        if (model.phoneField.getText() == null || model.phoneField.getText().length() == 0)
            errorMessage += "Нет номера телефона!\n";
        if (model.passwordField.getText() == null || model.passwordField.getText().length() == 0)
            errorMessage += "Нет пароля!\n";
        if (errorMessage.length() == 0) return true;
        else {
            Alerts.showNoValidInput(stage, errorMessage.substring(0, errorMessage.length() - 1));
            return false;
        }
    }

    /**
     * Проверка полей авторизации
     *
     * @param model - модель Регистрации
     * @param stage - текущее окно
     * @return true - если нет ошибок
     */
    public static boolean isValidAuthorizationRegex(SignInModel model, Stage stage) {
        if (RegexValidation.checkStandard(model.loginField.getText()) && RegexValidation.checkPassword(model.passwordField.getText()))
            return true;
        else {
            Alerts.showNoValidSignIn(stage);
            return false;
        }
    }

    /**
     * Проверка максимальной длины полей
     *
     * @param model - модель Регистрации
     * @param stage - текущее окно
     * @return true - если нет ошибок
     */
    public static boolean isValidLength(RegistrationEditModel model, Stage stage) {
        if (!Validation.checkLength(model.firstNameField.getText(), 50))
            Alerts.showNoValidLength(stage, "Имя", 50);
        else if (!Validation.checkLength(model.lastNameField.getText(), 50))
            Alerts.showNoValidLength(stage, "Фамилия", 50);
        else if (!Validation.checkLength(model.loginField.getText(), 50))
            Alerts.showNoValidLength(stage, "Логин", 50);
        else if (!Validation.checkLength(model.emailField.getText(), 50))
            Alerts.showNoValidLength(stage, "Email", 50);
        else if (!Validation.checkLength(model.passwordField.getText(), 50))
            Alerts.showNoValidLength(stage, "Пароль", 50);
        else if (!Validation.checkLength(model.passwordRepeatField.getText(), 50))
            Alerts.showNoValidLength(stage, "Повторный пароль", 50);
        else
            return true;
        return false;
    }

    /**
     * Проверка длины полей
     *
     * @param model - модель Регистрации
     * @param stage - текущее окно
     * @return true - если нет ошибок
     */
    public static boolean isValidLength2(RegistrationEditModel model, Stage stage) {
        if (!Validation.checkLength(model.firstNameField.getText(), 50))
            Alerts.showNoValidLength(stage, "Имя", 50);
        else if (!Validation.checkLength(model.lastNameField.getText(), 50))
            Alerts.showNoValidLength(stage, "Фамилия", 50);
        else if (!Validation.checkLength(model.phoneField.getText(), 50))
            Alerts.showNoValidLength(stage, "Телефон", 50);
        else if (!Validation.checkLength(model.passwordField.getText(), 50))
            Alerts.showNoValidLength(stage, "Пароль", 50);
        else
            return true;
        return false;
    }

    /**
     * Проверка ввода логина и пароля
     *
     * @param model - модель Авторизации
     * @param stage - текущее окно
     * @return true - если нет ошибок
     */
    public static boolean isValidAuthorization(SignInModel model, Stage stage) {
        String errorMessage = "";
        if (model.loginField.getText() == null || model.loginField.getText().length() == 0) {
            errorMessage += "Нет логина!\n";
        }
        if (model.passwordField.getText() == null || model.passwordField.getText().length() == 0) {
            errorMessage += "Нет пароля!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alerts.showNoValidInput(stage, errorMessage);
            return false;
        }
    }

    /**
     * Проверка длины сообщения
     *
     * @param text - сообщение
     * @param len  - длина поля в БД
     * @return true - если длина сообщения меньше возможной
     */
    public static boolean checkLength(String text, int len) {
        return text.length() <= len;
    }

    public static boolean isAirlineNameBlank(String text) {
        if (text == null || text.length() == 0) {
            return true;
        }
        return false;
    }
}
