package program.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import program.models.BoardModel;
import program.models.Flight;
import program.utils.validation.DateValidation;

import java.util.List;

public class DepartureBoardController extends BoardModel {
    @FXML
    private TableView<Flight> departureTableView;
    @FXML
    private TableColumn<Flight, String> flightNumberColumn;
    @FXML
    private TableColumn<Flight, String> departureDateColumn;
    @FXML
    private TableColumn<Flight, String> cityToColumn;
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
    }

    /**
     * Кнопка отправляет Get запрос
     * получает отбывающие рейсы
     */
    @FXML
    public void handleShowDeparture() {
        if (DateValidation.isBothDatesBlank(this)) {
            // Получаем все рейсы
            List<Flight> result = api.getAllFlights();
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).toString());
            }
        } else {
            if (DateValidation.isOneDateBlank(this, stage)) {
                if (DateValidation.isValidDateFormat(this, stage)) {
                    // Получаем отбывающие рейсы
                    List<Flight> result = api.getFlightsBetweenDates(startDateField.getText(), endDateField.getText(), false);
                    for (int i = 0; i < result.size(); i++) {
                        System.out.println(result.get(i).toString());
                    }
                }
            }
        }
    }
}
