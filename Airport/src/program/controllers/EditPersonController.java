package program.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import program.models.Person;
import program.models.RegistrationEditModel;

public class EditPersonController extends RegistrationEditModel {

    private boolean delete = false;
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
        firstNameField.setText(this.person.getFirstName());
        lastNameField.setText(this.person.getLastName());
        loginField.setText(this.person.getLogin());
        emailField.setText(this.person.getEmail());
        passwordField.setText(this.person.getPassword());
        passwordRepeatField.setText(this.person.getRepeatPassword());
    }


    public Person getPerson() {
        return person;
    }

    public boolean isDelete() { return delete; }

    //  TODO действие обновление информации о персоне
    @FXML
    private void handleUpdate() {
    }

    //  TODO действие удаления аккаунта
    @FXML
    private void handleDeleteAcc() {
    }

}
