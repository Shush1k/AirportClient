package program.models;


import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public abstract class SignInModel {
    @FXML
    public TextField loginField;

    @FXML
    public PasswordField passwordField;


    protected Stage dialStage;


    @FXML
    private void handleCancel() {
        dialStage.close();
    }

    public void setDialStage(Stage dialStage) {
        this.dialStage = dialStage;
    }
}