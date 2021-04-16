package program.controllers;

import javafx.fxml.FXML;
import program.models.Person;
import program.models.SignInModel;
import program.utils.alerts.Alerts;
import program.utils.validation.Validation;

public class AuthorizationController extends SignInModel {
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


    /**
     * Нажатие на кнопку Войти
     * отправка данных POST запросом на сервер
     */
    @FXML
    private void handlerSignInBtn() {
//        if (Validation.isValidAuthorization(this, AuthorizationStage)) {
//            if (Validation.isValidAuthorizationRegex(this, AuthorizationStage)) {
                /*TODO: POST запрос на авторизацию*/
                boolean authResult = main.getApi().checkUserExists(loginField.getText(), passwordField.getText());
                if (authResult){
                    main.MainLayout();
                }
                else {
                    Alerts.showNoValidSignIn(AuthorizationStage);
                }

//            }
//        }
    }

    /**
     * Нажатие на кнопку Зарегистрироваться
     */
    @FXML
    private void handlerRegistrationBtn() {
        main.showRegistrationPage();
    }

}
