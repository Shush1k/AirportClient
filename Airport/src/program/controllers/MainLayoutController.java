package program.controllers;

import javafx.fxml.FXML;
import program.Main;
import program.models.Airline;

public class MainLayoutController {
    /*Данный класс контроллер нужен для управлением ToolBar*/
    private Main main;

    @FXML
    public void openArrivalBoard() {
        main.showArrivalBoardPage();
    }
    @FXML
    public void openDepartureBoard() {
        main.showDepartureBoardPage();
    }
    @FXML
    public void openAirlineInfo() {
        main.showAirlineInfoPage();
    }
    @FXML
    public void openEditPerson(){ main.showEditPersonPage(); }

    public void setMain(Main main) {
        this.main = main;
    }
}
