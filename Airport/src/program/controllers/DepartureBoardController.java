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
    private ObservableList<Flight> departureFlightsData = FXCollections.observableArrayList();
    @FXML
    private TableView<Flight> departureTableView;
    @FXML
    private TableColumn<Flight, String> flightNumberColumn;
    @FXML
    private TableColumn<Flight, String> departureDateColumn;
    @FXML
    private TableColumn<Flight, String> arrivalCityColumn;
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
        departureDateColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
        arrivalCityColumn.setCellValueFactory(cellData -> cellData.getValue().getArrivalCityProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());

        departureTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDepartureFlightDetails(newValue));
        // заполняем таблицу данными
        departureTableView.setItems(departureFlightsData);
    }

    /**
     * Устанавливаем текст для расширенной информации о вылетающем рейсе
     *
     * @param flight рейс
     */
    private void showDepartureFlightDetails(Flight flight) {
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
     * получает отбывающие рейсы
     */
    @FXML
    public void handleShowDeparture() {
        //TODO: получать город прибытия и город отправления, для этого сделать связь рейсов с маршрутами
        departureTableView.getItems().clear();

        if (DateValidation.isBothDatesBlank(this)) {
            if (DateValidation.isDateYesterdayTodayTomorrow(this, stage)) {
                // Получаем все рейсы
                List<Flight> result = api.getAllFlights(searchField.getText(), false);
//            for (int i = 0; i < result.size(); i++) {
//                System.out.println(result.get(i).toString());
//            }
                departureFlightsData.addAll(result);
            }
        } else {
            if (DateValidation.isOneDateBlank(this, stage)) {
                if (DateValidation.isDateYesterdayTodayTomorrow(this, stage)) {
                    // Получаем отбывающие рейсы
                    List<Flight> result = api.getFlightsBetweenDates(searchField.getText(), startDateField.getText(), endDateField.getText(), false);
//                    for (int i = 0; i < result.size(); i++) {
//                        System.out.println(result.get(i).toString());
//                    }
                    departureFlightsData.addAll(result);
                }
            }
        }
    }
}
