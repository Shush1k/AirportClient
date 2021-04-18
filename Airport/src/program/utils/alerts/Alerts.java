package program.utils.alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * Класс Alerts, содержащий в себе все уведомления
 */
public abstract class Alerts {

    /**
     * Информация об изменении данных пользователя
     *
     * @param stage - текущее окно
     */
    public static void showSuccessEditPerson(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(stage);
        alert.setTitle("Данные изменены");
        alert.setHeaderText("Ваши пользовательские данные успешно изменены");
        alert.showAndWait();
    }

    /**
     * Информация об успешной регистрации пользователя в системе
     *
     * @param stage - текущее окно
     */
    public static void showSuccessRegistration(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(stage);
        alert.setTitle("Успешная регистрация");
        alert.setHeaderText("Ваши пользовательские данные успешно добавлены");
        alert.setContentText("Теперь авторизуйтесь на главной странице!");
        alert.showAndWait();
    }

    /**
     * Отказ регистрации нового пользователя в системе
     *
     * @param stage - текущее окно
     */
    public static void showFailedRegistration(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("В регистрация отказано");
        alert.setHeaderText("Пользователь с таким login/email уже существует");
        alert.setContentText("Введите другие данные!");
        alert.showAndWait();
    }

    /**
     * Ошибка входа
     *
     * @param stage - текущее окно
     */
    public static void showNoValidSignIn(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Ошибка входа");
        alert.setHeaderText("Некорректный логин или пароль");
        alert.setContentText("Введите корректные данные или зарегистрируйтесь!");
        alert.showAndWait();
    }

    /**
     * Ошибка запрещенных символов из списка [% " ' ; :]
     *
     * @param stage - текущее окно
     * @param name  - имя поля
     */
    public static void showNoValidStdRegex(Stage stage, String name) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Запрещенные символы строки");
        alert.setHeaderText("Некорректный формат текстового поля: " + name);
        alert.setContentText("Не допускаются символы из списка: [% \" ' ; :]");
        alert.showAndWait();
    }

    /**
     * Ошибка длины поля
     *
     * @param stage   - текущее окно
     * @param name    - имя поля
     * @param symbols - количество символов
     */
    public static void showNoValidLength(Stage stage, String name, int symbols) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Превышение длины строки");
        alert.setHeaderText("Некорректная длина поля " + name);
        alert.setContentText("Измените значение текстового поля" + "\nМаксимальная длина данного поля " + symbols + " символов!");
        alert.showAndWait();
    }

    /**
     * Ошибка формата пароля
     *
     * @param stage - текущее окно
     */
    public static void showNoValidPasswordFormat(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Некорректный формат пароля");
        alert.setHeaderText("Введите пароль в заданном формате");
        alert.setContentText("""
                Длина пароля: не менее 8 символов
                Пароль должен содержать:
                заглавные буквы, строчные буквы, цифры,
                специальные символы из списка: [@ # $ %]
                """);
        alert.showAndWait();
    }

    /**
     * Неверная информормация введена в поля
     *
     * @param stage        - текущее окно
     * @param errorMessage - сообщение об ошибке
     */
    public static void showNoValidInput(Stage stage, String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Ошибка ввода");
        alert.setHeaderText("Измените некорректно заполненные поля");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    /**
     * Ошибка формата почты
     *
     * @param stage - текущее окно
     */
    public static void showNoValidEmail(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Формат почты");
        alert.setHeaderText("Введите корректную электронную почту!");
        alert.setContentText("Пример почты: jakobknight@mail.ru");
        alert.showAndWait();
    }

    /**
     * Подтверждение от пользователя об удалении аккаунта
     *
     * @param stage - текущее окно
     * @return true - если пользователь выбрал кнопку OK
     */
    public static boolean showDeleteAccount(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(stage);
        alert.setTitle("Удаление профиля");
        alert.setHeaderText("Вы уверены, что хотите удалить свой профиль?");
        for (ButtonType type : alert.getButtonTypes())
            ((Button) alert.getDialogPane().lookupButton(type)).setDefaultButton(type == ButtonType.CANCEL);
        return alert.showAndWait().get() == ButtonType.OK;
    }

}
