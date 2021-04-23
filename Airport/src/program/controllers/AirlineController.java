package program.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import program.Main;
import program.models.Airline;
import program.utils.api.Api;
import program.utils.validation.Validation;

import java.util.Arrays;
import java.util.List;


public class AirlineController {
    private Main main;
    private Stage stage;
    protected Api api;
    ObservableList<Airline> airlinesData = FXCollections.observableArrayList();

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

    public void setAirlines(Airline[] airlines) {
        airlinesData = FXCollections.observableArrayList();
        airlinesData.addAll(Arrays.asList(airlines));
    }

    @FXML
    public void initialize() {
        searchCompany.setText(null);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Добавляем записи в таблицу airlineTableView
     */
    public void showAirlinesContent() {
        airlineCodeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        airlineNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        websiteColumn.setCellValueFactory(new PropertyValueFactory<>("website"));
        telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        airlineTableView.setItems(airlinesData);
    }

    //    TODO: запрос по url /airlines/like или /airlines/all если пустая строка
    @FXML
    public void handlerAirlinesBtn() {
        if (Validation.isAirlineNameBlank(searchCompany.getText())) {
            // Получаем все авиакомпании
            List<Airline> result = api.getAllAirlines();
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).toString());
            }
        } else {
            // TODO: Валидация длины поля, а также реализация на сервер!
            // пока фильтер: true, т.к. нет кнопки
            // Получаем все авиакомпании по вхождению подстроки
            List<Airline> result = api.getAirlinesBySubCompanyName(searchCompany.getText(), true);
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).toString());
            }
        }


    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setApi(Api api) {
        this.api = api;
    }
}
