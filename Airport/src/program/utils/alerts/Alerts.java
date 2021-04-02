package program.utils.alerts;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

public abstract class Alerts {

    /**
     * Ошибка входа
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

    public static void showNoValidInput(Stage stage, String errorMessage) {
        /* Если пользователь вводит то, чего не должен*/
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

    public static void shoNoValidPhoneNumber(Stage stage) {
        /* Если пользователь вводит некорректный номер телефона*/
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Формат номера телефона");
        alert.setHeaderText("Введите номер телефона в указанном формате");
        alert.setContentText("Формат ввода: +7{номер телефона} или 8{номер телефона}");
        alert.showAndWait();
    }

}
