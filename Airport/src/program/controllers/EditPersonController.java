package program.controllers;

import javafx.fxml.FXML;
import program.models.Person;
import program.models.RegistrationEditModel;
import program.utils.alerts.Alerts;
import program.utils.api.Api;
import program.utils.validation.RegexValidation;
import program.utils.validation.Validation;

public class EditPersonController extends RegistrationEditModel {
    protected Api api;
    private boolean delete = false;

    private Person person;

    public void setPerson(Person person) {
        this.person = person;
        firstNameField.setText(this.person.getFirstName());
        lastNameField.setText(this.person.getLastName());
        loginField.setText(this.person.getLogin());
        emailField.setText(this.person.getEmail());
        phoneField.setText(this.person.getPhoneNumber());
        birthdayPicker.setValue(this.person.getBirthday());
        passwordField.setText(this.person.getPassword());
        passwordRepeatField.setText(this.person.getRepeatPassword());
    }

    /**
     * Инициализация полей
     */
//    TODO: не работает, получение полей через api
//    @FXML
//    public void initialize() {
//        loginField.setText(api.getCurrentLoginPerson().getLogin());
//        emailField.setText(api.getCurrentLoginPerson().getEmail());
//        birthdayPicker.setValue(api.getCurrentLoginPerson().getBirthday());
//    }
    public Person getPerson() {
        return person;
    }

    public boolean isDelete() { return delete; }

    //  TODO действие обновление информации о персоне
    @FXML
    private void handleUpdate() {
        if (Validation.EditPersonDataValidation(this, RegistrationStage)) {
            if(Validation.isValidLength2(this, RegistrationStage)){
                if (Validation.isValidRegistrationRegex(this, RegistrationStage)){
                    if (RegexValidation.checkPhoneNumber(phoneField.getText())){
                        /*TODO: здесь должен быть PUT request с отправкой сущности*/
                        Alerts.showSuccessEditPerson(RegistrationStage);
                    } else {
                        Alerts.showNoValidPhoneNumber(RegistrationStage);
                    }

                }
            }
        }
    }

    @FXML
    private void handleDeleteAcc() {
        delete = Alerts.showDeleteAccount(RegistrationStage);
        if (delete){
            /*TODO Получаем boolean тип, а далее DELETE request*/
        }
    }

}
