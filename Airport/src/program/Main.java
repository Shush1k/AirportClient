package program;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import program.controllers.*;
import program.models.Person;
import program.utils.api.Api;

import java.io.IOException;

/**
 * Класс Main запускает приложение Airport
 */
public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private BorderPane mainLayout;
    private final Api api;
    private final ObservableList<Person> personData = FXCollections.observableArrayList();

    public Api getApi() {
        return api;
    }

    /**
     * Пустой конструктор с экземпляром класса api
     */
    public Main() {
        api = new Api();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    /**
     * Метод, которые устанавливает первое окно приложения
     *
     * @param primaryStage установка сцены
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Airport App");

        initRootLayout();

    }

    /**
     * Загрузка сцены rootLayout
     * Меню содержит строку об авторе
     */
    @FXML
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/rootLayout.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);

            RootLayoutController rootLayoutController = loader.getController();
            rootLayoutController.setMain(this);
            primaryStage.show();
            showAuthorizationPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Главное окно с Toolbar
     * Панель на которой расположены основные окна программы по умолчанию запускаем Табло прилетов
     */
    public void MainLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/mainLayout.fxml"));
            mainLayout = loader.load();

            Scene scene = new Scene(mainLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();

            MainLayoutController mainLayoutController = loader.getController();
            mainLayoutController.setApi(api);
            mainLayoutController.setMain(this);
            mainLayoutController.showHelloMessage();
            mainLayoutController.openArrivalBoard();
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Окно авторизации пользователя
     * расположено в центре rootLayout
     */
    public void showAuthorizationPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/authorization.fxml"));
            AnchorPane authorizationPage = loader.load();

            rootLayout.setCenter(authorizationPage);

            AuthorizationController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Окно регистрации пользователя
     */
    public void showRegistrationPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/registration.fxml"));
            AnchorPane registrationPage = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Регистрация");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(primaryStage);
            stage.setResizable(false);

            Scene scene = new Scene(registrationPage);
            stage.setScene(scene);

            RegistrationPageController controller = loader.getController();
            controller.setRegistrationStage(stage);
            controller.setApi(api);
            controller.setMain(this);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Окно об авторе
     */
    public void showAboutPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/aboutPage.fxml"));
            AnchorPane aboutPage = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Shush1k страница");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(primaryStage);
            stage.setResizable(false);

            Scene scene = new Scene(aboutPage);
            stage.setScene(scene);

            AboutPageController controller = loader.getController();
            controller.setAboutStage(stage);
            controller.setHostServices(getHostServices());
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Окно редактирования данных пользователя
     * расположено в центре mainLayout
     */
    public void showEditPersonPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/editPerson.fxml"));
            AnchorPane editPersonPage = loader.load();

            mainLayout.setCenter(editPersonPage);

            EditPersonController controller = loader.getController();
            controller.setApi(api);
            controller.setPerson(api.currentLoginPerson);
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Окно Табло прилетов
     * расположено в центре mainLayout
     */
    public void showArrivalBoardPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/arrivalBoard.fxml"));
            BorderPane arrivalBoardPage = loader.load();

            mainLayout.setCenter(arrivalBoardPage);
            ArrivalBoardController controller = loader.getController();
            controller.setStage(primaryStage);
            controller.setApi(api);
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Окно Табло вылетов
     * расположено в центре mainLayout
     */
    public void showDepartureBoardPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/departureBoard.fxml"));
            BorderPane departureBoardPage = loader.load();

            mainLayout.setCenter(departureBoardPage);

            DepartureBoardController controller = loader.getController();
            controller.setStage(primaryStage);
            controller.setApi(api);
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Окно информации об авиакомпании
     * расположено в центре mainLayout
     */
    public void showAirlineInfoPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/airlinesPage.fxml"));
            BorderPane airlineInfoPage = loader.load();

            mainLayout.setCenter(airlineInfoPage);

            AirlineController controller = loader.getController();
            controller.setMain(this);
            controller.setStage(primaryStage);
            controller.setApi(api);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
