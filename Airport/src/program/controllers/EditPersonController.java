package program.controllers;

import javafx.fxml.FXML;
import program.models.Person;
import program.models.RegistrationEditModel;
import program.utils.alerts.Alerts;
import program.utils.validation.Validation;

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
        if (Validation.EditPersonDataValidation(this, RegistrationStage)) {
            if(Validation.isValidLength2(this, RegistrationStage)){
                if (Validation.isValidRegistrationRegex(this, RegistrationStage)){
                    /*TODO: здесь должен быть PUT request с отправкой полей:
                    *  ID
                    *  first_name
                    *  last_name
                    *  login
                    *  email
                    */
                    Alerts.showSuccessEditPerson(RegistrationStage);

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
