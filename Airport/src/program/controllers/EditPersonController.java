package program.controllers;

import javafx.fxml.FXML;
import program.models.Person;
import program.models.RegistrationEditModel;
import program.utils.alerts.Alerts;
import program.utils.validation.RegexValidation;
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
        phoneField.setText(this.person.getPhoneNumber());
        birthdayPicker.setValue(this.person.getBirthday());
        passwordField.setText(this.person.getPassword());
//        passwordRepeatField.setText(this.person.getRepeatPassword());
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
        System.out.println(person.getEmail());
//        if (Validation.EditPersonDataValidation(this, RegistrationStage)) {
//            if(Validation.isValidLength2(this, RegistrationStage)){
//                if (Validation.isValidRegistrationRegex(this, RegistrationStage)){
//                    if (RegexValidation.checkPhoneNumber(phoneField.getText())){
//                        /*TODO: здесь должен быть PUT request с отправкой сущности*/
//                        Alerts.showSuccessEditPerson(RegistrationStage);
//                    } else {
//                        Alerts.showNoValidPhoneNumber(RegistrationStage);
//                    }
//
//                }
//            }
//        }
    }

    /**
     *
     */
    @FXML
    private void handleDeleteAcc() {
        // валидация
        if (Validation.isValidPassword(this, RegistrationStage)){
//            if (RegexValidation.checkPassword(passwordField.getText())){
                delete = Alerts.showDeleteAccount(RegistrationStage);
                if (delete){
                    // Пока не знаем как получать данные о email у currentLoginPerson, поэтому строка test@email.ru
                    /* TODO сделать проверку поля
                        если пустое значение, пишем пользователю,
                        что необходимо указать верный пароль, чтобы удалить аккаунт
                    */
                    boolean result = api.deleteUser("test@email.ru", passwordField.getText());
                    if (result){
                        main.initRootLayout();
                    } else {
                        Alerts.showNoValidPasswordDeleteAction(RegistrationStage);
                    }
                }
//            } else {
//                Alerts.showNoValidPasswordFormat(RegistrationStage);
//            }
        }

    }

}
