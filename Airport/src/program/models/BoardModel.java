package program.models;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import program.Main;
import program.utils.api.Api;

public abstract class BoardModel {
    protected Stage stage;
    protected Main main;
    protected Api api;


    //    Формат даты в POSTMAN такой: "2021-04-17T17:30"
    @FXML
    public TextField startDateField;

    @FXML
    public TextField endDateField;

    @FXML
    public TextField searchField;

    @FXML
    public Label departureCityLabel;

    @FXML
    public Label arrivalCityLabel;

    @FXML
    public Label planeModelLabel;

    @FXML
    public Label statusLabel;

    @FXML
    public Label departureDateLabel;

    @FXML
    public Label arrivalDateLabel;

    @FXML
    public Label flightNumberLabel;

    /**
     * Закрытие сцены
     */
    @FXML
    private void handleCancel() {
        stage.close();
    }

    /**
     * @param stage - установка сцены
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setApi(Api api) {
        this.api = api;
    }
}

