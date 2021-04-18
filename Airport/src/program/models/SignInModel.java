package program.models;


import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import program.Main;

/**
 * Абстрактный класс SignInModel - модель входа в приложение
 */
public abstract class SignInModel {
    protected Main main;
    protected Stage AuthorizationStage;

    @FXML
    public TextField loginField;

    @FXML
    public PasswordField passwordField;


    @FXML
    private void handleCancel() {
        AuthorizationStage.close();
    }


    public void setAuthorizationStage(Stage authorizationStage) {
        AuthorizationStage = authorizationStage;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}