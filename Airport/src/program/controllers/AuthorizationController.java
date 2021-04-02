package program.controllers;

import javafx.fxml.FXML;

import javafx.stage.Stage;
import program.Main;
import program.models.Person;
import program.models.SignInModel;
import program.utils.alerts.Alerts;
import program.utils.validation.Validation;

public class AuthorizationController extends SignInModel {

    private Main main;
    private Stage AuthorizationStage;
    private Person person;


    @FXML
    private void initialize(){
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

    @FXML
    private void handlerSignInBtn(){
        /*Нажатие на кнопку Войти
        * Alert type - showNoValidSignIn */
        if (Validation.isValidAuthorization(this, AuthorizationStage)){
            // TODO Добавить регулярки (на проверку ввода логина и пароля) в utils папку
            main.MainLayout();
        }
    }

    @FXML
    private void handlerRegistrationBtn(){
        /*Нажатие на кнопку Зарегистрироваться*/
        main.showRegistrationPage();
    }



    public void setMain(Main main) { this.main = main; }


}
