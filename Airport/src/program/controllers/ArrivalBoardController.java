package program.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import program.Main;

public class ArrivalBoardController {
    private Main main;
    private Stage arrivalBoardStage;


    /**
     * Кнопка отправляет Get запрос
     * получает прибывающие рейсы
     */
    @FXML
    private void handleShowArrival() {

    }

    public void setArrivalBoardStage(Stage arrivalBoardStage) {
        this.arrivalBoardStage = arrivalBoardStage;
    }

    public void setMain(Main main){this.main = main;}
}
