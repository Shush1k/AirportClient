package program.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import program.Main;
import program.utils.api.Api;

/**
 * Класс MainLayoutController, отвечает за переключения между сценами
 * <p>
 * прилетов, вылетов, авиакомпаний и ЛК
 */
public class MainLayoutController {
    private Main main;
    protected Api api;

    @FXML
    private Label helloMessage;

    /**
     * Открытие сцены табло прилетов
     */
    @FXML
    public void openArrivalBoard() {
        main.showArrivalBoardPage();
    }

    /**
     * Открытие сцены табло вылетов
     */
    @FXML
    public void openDepartureBoard() {
        main.showDepartureBoardPage();
    }

    /**
     * Открытие сцены информации авиакомпаний
     */
    @FXML
    public void openAirlineInfo() {
        main.showAirlineInfoPage();
    }

    /**
     * Открытие сцены ЛК пользователя
     */
    @FXML
    public void openEditPerson() {
        main.showEditPersonPage();
    }

    @FXML
    public void showHelloMessage() {
        helloMessage.setText("Здравствуйте, " + api.currentLoginPerson.getLogin());
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setApi(Api api) {
        this.api = api;
    }
}
