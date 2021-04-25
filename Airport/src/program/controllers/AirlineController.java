package program.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import program.Main;
import program.models.Airline;
import program.utils.alerts.Alerts;
import program.utils.api.Api;
import program.utils.validation.Validation;

import java.util.List;


public class AirlineController {
    private Main main;
    private Stage stage;
    protected Api api;
    private ObservableList<Airline> airlinesData = FXCollections.observableArrayList();

    @FXML
    private TableView<Airline> airlineTableView;
    @FXML
    private TableColumn<Airline, String> airlineCodeColumn;
    @FXML
    private TableColumn<Airline, String> airlineNameColumn;
    @FXML
    private TableColumn<Airline, String> websiteColumn;
    @FXML
    private TableColumn<Airline, String> telephoneColumn;
    @FXML
    private TableColumn<Airline, String> emailColumn;

    @FXML
    private TextField searchCompany;

    @FXML
    private CheckBox sortAirlineBtn;

    /**
     * Инициализируем данные
     * <p>
     * Добавляем записи в таблицу airlineTableView
     */
    @FXML
    public void initialize() {
        searchCompany.setText(null);

        // устанавливаем значение класса Airline
        airlineCodeColumn.setCellValueFactory(cellData -> cellData.getValue().getCodeProperty());
        airlineNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        websiteColumn.setCellValueFactory(cellData -> cellData.getValue().getWebsiteProperty());
        telephoneColumn.setCellValueFactory(cellData -> cellData.getValue().getPhoneNumberProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());

        // заполняем таблицу данными
        airlineTableView.setItems(airlinesData);

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    //    TODO: запрос по url /airlines/like или /airlines/all если пустая строка
    @FXML
    public void handlerAirlinesBtn() {
        // обнуление таблицы
        if (Validation.checkLength(searchCompany.getText(), 40)) {

            airlineTableView.getItems().clear();
            boolean filter = false;
            filter = sortAirlineBtn.isSelected();
            List<Airline> result;
            if (Validation.isAirlineNameBlank(searchCompany.getText())) {
                // Получаем все авиакомпании
                result = api.getAllAirlines(filter);
            } else {
                // Получаем все авиакомпании по вхождению подстроки
                result = api.getAirlinesBySubCompanyName(searchCompany.getText(), filter);
            }
            airlinesData.addAll(result);
        } else {
            Alerts.showNoValidLength(stage, "поиск", 40);
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setApi(Api api) {
        this.api = api;
    }
}
