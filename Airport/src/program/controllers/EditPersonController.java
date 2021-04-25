package program.controllers;

import javafx.fxml.FXML;
import program.models.Person;
import program.models.RegistrationEditModel;
import program.utils.alerts.Alerts;
import program.utils.validation.Validation;

import java.time.LocalDate;

public class EditPersonController extends RegistrationEditModel {
    private boolean delete = false;
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
        firstNameField.setText(this.person.getFirstName());
        lastNameField.setText(this.person.getLastName());
        loginField.setText(this.person.getLogin());
        emailField.setText(this.person.getEmail());
        phoneField.setText(this.person.getPhoneNumber());
        if (this.person.getBirthday() != null) {
            birthdayPicker.setValue(LocalDate.from(this.person.getBirthday()));
        }
        passwordField.setText(this.person.getPassword());
    }


    public Person getPerson() {
        return person;
    }

    public boolean isDelete() {
        return delete;
    }

    /**
     * Кнопка обновления информации о пользователе
     */
    @FXML
    private void handleUpdate() {
        if (Validation.EditPersonDataValidation(this, RegistrationStage)) { // Поля не пустые
            if (Validation.isValidLength2(this, RegistrationStage)) { // Длина полей не большая
                if (Validation.isValidEditPersonRegex(this, RegistrationStage)) {
                    boolean authResult = main.getApi().checkUserExists(emailField.getText(), passwordField.getText());
                    if (authResult) {
                        boolean updateResult = api.updateUser(firstNameField.getText(), lastNameField.getText(), loginField.getText(),
                                emailField.getText(), phoneField.getText(), birthdayPicker.getValue(), passwordField.getText());
                        if (updateResult) {
                            // устанавливаем новые значения полей для currentLoginPerson
                            api.currentLoginPerson.setFirstName(firstNameField.getText());
                            api.currentLoginPerson.setLastName(lastNameField.getText());
                            api.currentLoginPerson.setLogin(loginField.getText());
                            api.currentLoginPerson.setEmail(emailField.getText());

                            if (phoneField.getText() != null)
                                api.currentLoginPerson.setPhoneNumber(phoneField.getText());
                            if (birthdayPicker.getValue() != null)
                                api.currentLoginPerson.setBirthday(LocalDate.from(birthdayPicker.getValue()));
                            Alerts.showSuccessEditPerson(RegistrationStage);
                        }
                    } else {
                        Alerts.showNoValidAccountPassword(RegistrationStage);
                    }
                }
            }
        }
    }

    /**
     * Кнопка удаления аккаунта пользователя
     */
    @FXML
    private void handleDeleteAcc() {
        if (Validation.isValidPassword(this, RegistrationStage)) {
            delete = Alerts.showDeleteAccount(RegistrationStage);
            if (delete) {
                boolean result = api.deleteUser(person.getEmail(), passwordField.getText());
                if (result) {
                    main.initRootLayout();
                } else {
                    Alerts.showNoValidAccountPassword(RegistrationStage);
                }
            }
        }

    }

}
