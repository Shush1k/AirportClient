package program.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import program.Main;
import program.models.Airline;

import java.util.Arrays;

public class AirlineInfoController {
    private Main main;
    private Stage airlineInfoStage;
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

    public void setAirlines(Airline[] airlines) {
        //TODO airlines[0] не работает
        airlines[0] = new Airline("1", "2", "3", "4", "5");
        airlinesData = FXCollections.observableArrayList();
        airlinesData.addAll(Arrays.asList(airlines));
    }


    public void setAirlineInfoStage(Stage airlineInfoStage) {
        this.airlineInfoStage = airlineInfoStage;
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
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
