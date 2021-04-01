package program.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import program.Main;
import program.models.Person;
import program.models.RegistrationEditModel;
import program.utils.validation.Validation;


public class RegistrationPageController extends RegistrationEditModel{

    private boolean okClicked = false;
    private Stage RegistrationStage;
    private Person person;
    private Main main;

    /**
     * Инициализация полей
     */
    @FXML
    public void initialize(){
        /*Пока задокументируем*/
//        loginField.setText(null);
//        firstNameField.setText(null);
//        lastNameField.setText(null);
//        birthdayField.setValue(null);
//        sexField.setText(null);
//        seriesField.setText(null);
//        numberField.setText(null);
//        emailField.setText(null);
//        phoneField.setText(null);
//        passwordField.setText(null);
//        passwordRepeatField.setText(null);
        person = new Person();

    }
    public boolean isOkClicked(){return okClicked;}

    /**
     * @param RegistrationStage - установка сцены регистрации
     */
    public void setRegistrationStage(Stage RegistrationStage){this.RegistrationStage = RegistrationStage;}

    /**
     * Закрытие сцены регистрации
     */
    @FXML
    private void handleCancel(){RegistrationStage.close();}

    /**
     * Нажатие на кнопку регистрации
     * POST запрос
     */
    @FXML
    private void handleRegistration(){
        /*TODO: действия после нажатия на кнопку Зарегистрироваться
           POST request
         */
        RegistrationStage.close();
    }

    public void setMain(Main main) {
        this.main = main;
    }
}

