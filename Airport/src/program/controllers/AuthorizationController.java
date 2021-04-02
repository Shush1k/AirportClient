package program.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import program.Main;
import program.models.Person;
import program.models.SignInModel;
import program.utils.validation.Validation;

public class AuthorizationController extends SignInModel {

    private Main main;
    private Stage AuthorizationStage;
    private Person person;


    @FXML
    private void initialize() {
        loginField.setText(null);
        passwordField.setText(null);
        person = new Person();
    }

    public Person getPerson() {
        return person;
    }

    public void setAuthorizationStage(Stage authorizationStage) {
        AuthorizationStage = authorizationStage;
    }

    /**
     * Нажатие на кнопку Войти
     * отправка данных POST запросом на сервер
     */
    @FXML
    private void handlerSignInBtn() {
        if (Validation.isValidAuthorization(this, AuthorizationStage)) {
            if (Validation.isValidAuthorizationRegex(this, AuthorizationStage)) {
                /*TODO: POST запрос на авторизацию*/
                main.MainLayout();
            }
        }
    }

    /**
     * Нажатие на кнопку Зарегистрироваться
     */
    @FXML
    private void handlerRegistrationBtn() {
        main.showRegistrationPage();
    }


    public void setMain(Main main) {
        this.main = main;
    }


}
