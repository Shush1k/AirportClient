package program.controllers;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

/**
 * Класс, содержащий информации об авторе программы
 *
 * @author Shush1k
 */
public class AboutPageController {
    @FXML
    private Hyperlink vkLink;
    @FXML
    private Hyperlink githubLink;

    private Stage stage;
    private HostServices hostServices;

    public HostServices getHostServices() {
        return hostServices;
    }

    public void setAboutStage(Stage stage) {
        this.stage = stage;
    }

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    /**
     * Ссылки на страницы в соц.сетях
     */
    @FXML
    public void initialize() {
        vkLink = new Hyperlink("https://vk.com/shush1k_s");
        githubLink = new Hyperlink("https://github.com/Shush1k");
    }

    /**
     * Переход по ссылке VK
     */
    @FXML
    public void openVk() {
        hostServices.showDocument(vkLink.getText());
    }

    /**
     * Переход по ссылке GitHub
     */
    @FXML
    public void openGithub() {
        hostServices.showDocument(githubLink.getText());
    }

    /**
     * закрытие окна "об Авторе"
     */
    @FXML
    public void handleBackBtn() {
        stage.close();
    }
}
