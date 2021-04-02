package program.controllers;

import javafx.fxml.FXML;
import program.models.RegistrationEditModel;
import program.utils.validation.Validation;


public class RegistrationPageController extends RegistrationEditModel{

    /**
     * Инициализация полей
     */
    @FXML
    public void initialize(){
        firstNameField.setText(null);
        lastNameField.setText(null);
        loginField.setText(null);
        emailField.setText(null);
        passwordField.setText(null);
        passwordRepeatField.setText(null);

    }

    /**
     * Нажатие на кнопку регистрации
     * POST запрос
     */
    @FXML
    private void handleRegistration(){
        /*TODO: действия после нажатия на кнопку Зарегистрироваться
           POST request
         */
        if (Validation.RegistrationDataValidation(this, RegistrationStage)) {
            /*TODO: проверка через Regex*/
            RegistrationStage.close();
        }

    }


}

