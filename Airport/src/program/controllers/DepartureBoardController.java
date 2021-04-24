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

import java.util.List;

public class DepartureBoardController extends BoardModel {
    private List<Flight> result;
    private ObservableList<Flight> flightsData = FXCollections.observableArrayList();
    @FXML
    private TableView<Flight> departureTableView;
    @FXML
    private TableColumn<Flight, String> flightNumberColumn;
    @FXML
    private TableColumn<Flight, String> departureDateColumn;
    @FXML
    private TableColumn<Flight, String> departureCityColumn;
    @FXML
    private TableColumn<Flight, String> statusColumn;
    @FXML
    private TableColumn<Flight, String> planeModelColumn;

    /**
     * Инициализация полей
     */
    @FXML
    public void initialize() {

        startDateField.setText(null);
        endDateField.setText(null);


        // устанавливаем значение класса Airline
        flightNumberColumn.setCellValueFactory(cellData -> cellData.getValue().getFlightNumberProperty());
        //TODO: какой-то формат для даты
//        departureDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDepartureCityProperty());
        //Пока так:
        departureDateColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
        departureCityColumn.setCellValueFactory(cellData -> cellData.getValue().getDepartureCityProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());
        planeModelColumn.setCellValueFactory(cellData -> cellData.getValue().getPlaneModelProperty());

        // заполняем таблицу данными
        departureTableView.setItems(flightsData);
    }

    /**
     * Кнопка отправляет Get запрос
     * получает отбывающие рейсы
     */
    @FXML
    public void handleShowDeparture() {
        //TODO: получать город прибытия и город отправления, для этого сделать связь рейсов с маршрутами
        departureTableView.getItems().clear();

        if (DateValidation.isBothDatesBlank(this)) {
            // Получаем все рейсы
            List<Flight> result = api.getAllFlights(false);
//            for (int i = 0; i < result.size(); i++) {
//                System.out.println(result.get(i).toString());
//            }
            flightsData.addAll(result);
        } else {
            if (DateValidation.isOneDateBlank(this, stage)) {
                if (DateValidation.isValidDateFormat(this, stage)) {
                    // Получаем отбывающие рейсы
                    List<Flight> result = api.getFlightsBetweenDates(startDateField.getText(), endDateField.getText(), false);
//                    for (int i = 0; i < result.size(); i++) {
//                        System.out.println(result.get(i).toString());
//                    }
                    flightsData.addAll(result);
                }
            }
        }
    }
}
