package program.models;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public abstract class RegistrationEditModel {
    @FXML
    public TextField firstNameField;

    @FXML
    public TextField lastNameField;

    @FXML
    public TextField loginField;

    @FXML
    public TextField emailField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public PasswordField repeatPasswordField;

    protected Stage stage;

    @FXML
    private void handleCancel() { stage.close(); }

    public void setDialStage(Stage stage) { this.stage = stage; }
}
