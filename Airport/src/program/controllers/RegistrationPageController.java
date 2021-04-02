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
     * отправка данных POST запросом на сервер
     */
    @FXML
    private void handleRegistration(){

        if (Validation.RegistrationDataValidation(this, RegistrationStage)) {
            if(Validation.isValidLength(this, RegistrationStage)){
                if (Validation.isValidRegistrationRegex(this, RegistrationStage)){
                    /*TODO: здесь должен быть POST request с отправкой полей регистрации*/
                    RegistrationStage.close();
                }
            }
        }
    }


}

