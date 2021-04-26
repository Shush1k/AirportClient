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


    /**
     * Инициализация полей
     */
    @FXML
    public void initialize() {

        startDateField.setText(null);
        endDateField.setText(null);

        searchField.setText("");
        flightNumberLabel.setText("");
        departureCityLabel.setText("");
        arrivalCityLabel.setText("");
        planeModelLabel.setText("");
        statusLabel.setText("");
        departureDateLabel.setText("");
        arrivalDateLabel.setText("");

        companyNameLabel.setText("");
        phoneLabel.setText("");
        emailLabel.setText("");
        websiteLabel.setText("");

        flightNumberColumn.setCellValueFactory(cellData -> cellData.getValue().getFlightNumberProperty());
        //TODO: какой-то формат для даты
//        departureDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDepartureCityProperty());
        //Пока так:
        arrivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
        departureCityColumn.setCellValueFactory(cellData -> cellData.getValue().getDepartureCityProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());
//        planeModelColumn.setCellValueFactory(cellData -> cellData.getValue().getPlaneModelProperty());

        arrivalTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showArrivalFlightDetails(newValue));

        // заполняем таблицу данными
        arrivalTableView.setItems(arrivalFlightsData);
    }

    /**
     * Устанавливаем текст для расширенной информации о прилетающем рейсе
     *
     * @param flight рейс
     */
    private void showArrivalFlightDetails(Flight flight) {
        if (flight != null) {
            flightNumberLabel.setText(flight.getFlightNumber());
            departureCityLabel.setText(flight.getDepartureCity());
            arrivalCityLabel.setText(flight.getArrivalCity());
            planeModelLabel.setText(flight.getPlaneModel());
            statusLabel.setText(flight.getStatus());
            departureDateLabel.setText(String.valueOf(flight.getDepartureDate()));
            arrivalDateLabel.setText(String.valueOf(flight.getArrivalDate()));
            companyNameLabel.setText(flight.getAirlineName());
            phoneLabel.setText(flight.getPhoneNumber());
            emailLabel.setText(flight.getEmail());
            websiteLabel.setText(flight.getWebsite());
        }

    }

    /**
     * Кнопка отправляет Get запрос
     * получает прибывающие рейсы
     */
    @FXML
    private void handleShowArrival() {
        arrivalTableView.getItems().clear();
        if (DateValidation.isBothDatesBlank(this)) {
            if (DateValidation.isDateYesterdayTodayTomorrow(this, stage)) {
                // Получаем все рейсы
                List<Flight> result = api.getAllFlights(searchField.getText(), true);
//                for (int i = 0; i < result.size(); i++) {
//                    System.out.println(result.get(i).toString());
//                }
                arrivalFlightsData.addAll(result);
            }
        } else {
            if (DateValidation.isOneDateBlank(this, stage)) {
                if (DateValidation.isDateYesterdayTodayTomorrow(this, stage)) {
                    // Получаем прыбывающие рейсы
                    List<Flight> result = api.getFlightsBetweenDates(searchField.getText(), startDateField.getText(), endDateField.getText(), true);
//                    for (int i = 0; i < result.size(); i++) {
//                        System.out.println(result.get(i).toString());
//                    }
                    arrivalFlightsData.addAll(result);
                }
            }
        }
    }


    public void handleClose() {
        stage.close();
    }
}
