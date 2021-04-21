package program.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import program.models.BoardModel;
import program.models.Flight;
import program.utils.validation.DateValidation;

import java.util.Arrays;


public class ArrivalBoardController extends BoardModel {

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
     * Инициализация полей
     */
    @FXML
    public void initialize() {
        startDateField.setText(null);
        endDateField.setText(null);
    }

    /**
     * Кнопка отправляет Get запрос
     * получает прибывающие рейсы
     */
    @FXML
    private void handleShowArrival() {
        if (DateValidation.isValidDate(this, stage)){
            System.out.println("успешно");
        }
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
}
