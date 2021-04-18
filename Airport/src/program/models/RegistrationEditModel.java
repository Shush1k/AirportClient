package program.models;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import program.Main;

public abstract class RegistrationEditModel {
    protected Stage RegistrationStage;
    protected Main main;

    @FXML
    public TextField firstNameField;

    @FXML
    public TextField lastNameField;

    @FXML
    public TextField loginField;

    @FXML
    public TextField emailField;

    @FXML
    public TextField phoneField;

    @FXML
    public DatePicker birthdayPicker;

    @FXML
    public PasswordField passwordField;

    @FXML
    public PasswordField passwordRepeatField;


    /**
     * Закрытие сцены регистрации
     */
    @FXML
    private void handleCancel(){RegistrationStage.close();}

    /**
     * @param RegistrationStage - установка сцены регистрации
     */
    public void setRegistrationStage(Stage RegistrationStage){this.RegistrationStage = RegistrationStage;}

    public void setMain(Main main) {
        this.main = main;
    }
}
