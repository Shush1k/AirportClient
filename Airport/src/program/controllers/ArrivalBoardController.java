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
import java.util.List;


public class ArrivalBoardController extends BoardModel {
    private List<Flight> result;
    private ObservableList<Flight> arrivalFlightsData = FXCollections.observableArrayList();

    @FXML
    private TableView<Flight> arrivalTableView;
    @FXML
    private TableColumn<Flight, String> flightNumberColumn;
    @FXML
    private TableColumn<Flight, String> arrivalDateColumn;
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


        flightNumberColumn.setCellValueFactory(cellData -> cellData.getValue().getFlightNumberProperty());
        //TODO: какой-то формат для даты
//        departureDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDepartureCityProperty());
        //Пока так:
        arrivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
        departureCityColumn.setCellValueFactory(cellData -> cellData.getValue().getDepartureCityProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());
        planeModelColumn.setCellValueFactory(cellData -> cellData.getValue().getPlaneModelProperty());

        // заполняем таблицу данными
        arrivalTableView.setItems(arrivalFlightsData);
    }

    /**
     * Кнопка отправляет Get запрос
     * получает прибывающие рейсы
     */
    @FXML
    private void handleShowArrival() {
        arrivalTableView.getItems().clear();
        if (DateValidation.isBothDatesBlank(this)) {
            // Получаем все рейсы
            List<Flight> result = api.getAllFlights(true);
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).toString());
            }
            arrivalFlightsData.addAll(result);
        } else {
            if (DateValidation.isOneDateBlank(this, stage)) {
                if (DateValidation.isValidDateFormat(this, stage)) {
                    // Получаем прыбывающие рейсы
                    List<Flight> result = api.getFlightsBetweenDates(startDateField.getText(), endDateField.getText(), true);
                    for (int i = 0; i < result.size(); i++) {
                        System.out.println(result.get(i).toString());
                    }
                    arrivalFlightsData.addAll(result);
                }
            }
        }
    }


    public void handleClose() {
        stage.close();
    }
}
