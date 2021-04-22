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
//        if (DateValidation.isValidDateFormat(this, stage)) {
//            System.out.println("Валидный");
//
//        }
        if (DateValidation.isBothDatesBlank(this, stage)) {
            List<Flight> result = api.getAllFlights();
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).toString());
            }
        } else {
            if (DateValidation.isOneDateBlank(this, stage)) {
                if (DateValidation.isValidDateFormat(this, stage)) {
//                TODO: валидация даты по шаблону, иначе Alert
                    List<Flight> result = api.getArrivalFlights(startDateField.getText(), endDateField.getText(), true);
                    for (int i = 0; i < result.size(); i++) {
                        System.out.println(result.get(i).toString());
                    }
                }
            }
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
