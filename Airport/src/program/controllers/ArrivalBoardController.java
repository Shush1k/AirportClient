package program.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import program.Main;
import program.models.Flight;

import java.util.Arrays;


public class ArrivalBoardController {
    private Main main;
    private Stage arrivalBoardStage;

    @FXML
    private TableView<Flight> arrivalTableView;
    @FXML
    private TableColumn<Flight, String> flightNumberColumn;
    @FXML
    private TableColumn<Flight, String> arrivalDateColumn;
    @FXML
    private TableColumn<Flight, String> cityFromColumn;
    @FXML
    private TableColumn<Flight, String> statusColumn;
    @FXML
    private TableColumn<Flight, String> planeModelColumn;


    private ObservableList<Flight> flightsData;

    /**
     * Кнопка отправляет Get запрос
     * получает прибывающие рейсы
     */
    @FXML
    private void handleShowArrival() {
    }


    /**
     * Показывает данные в таблице arrivalTableView
     */
    public void showFlightsContent() {
        flightNumberColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        arrivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
        cityFromColumn.setCellValueFactory(new PropertyValueFactory<>("cityFrom"));
        planeModelColumn.setCellValueFactory(new PropertyValueFactory<>("planeModel"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        arrivalTableView.setItems(flightsData);
    }

    /**
     * @param flights - список рейсов
     */
    public void setFlights(Flight[] flights) {
        flightsData = FXCollections.observableArrayList();
        flightsData.addAll(Arrays.asList(flights));
    }

    public void setArrivalBoardStage(Stage arrivalBoardStage) {
        this.arrivalBoardStage = arrivalBoardStage;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
