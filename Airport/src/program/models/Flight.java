package program.models;

import javafx.beans.property.*;
import program.utils.api.DateConvert;
import program.utils.validation.DateValidation;

import java.time.LocalDateTime;

/**
 * Класс Flight - рейсы
 */
public class Flight {
    private final LongProperty id;
    private final StringProperty flightNumber;
    private final ObjectProperty<LocalDateTime> departureDate;
    private final ObjectProperty<LocalDateTime> arrivalDate;
    private final StringProperty departureCity;
    private final StringProperty arrivalCity;
    private final StringProperty status;
    private final StringProperty planeModel;

    /**
     * Конструктор Рейсов
     *
     * @param flightNumber  номер рейса
     * @param departureDate дата отправления
     * @param arrivalDate   дата прибытия
     * @param arrivalCity   город прибытия
     * @param departureCity город отправления
     * @param status        статус рейса
     * @param planeModel    модель самолета
     */
    public Flight(String flightNumber, LocalDateTime departureDate, LocalDateTime arrivalDate, String arrivalCity, String departureCity, String status, String planeModel) {
        this.id = new SimpleLongProperty();
        this.flightNumber = new SimpleStringProperty(flightNumber);
        this.departureDate = new SimpleObjectProperty<>(departureDate);
        this.arrivalDate = new SimpleObjectProperty<>(arrivalDate);
        this.arrivalCity = new SimpleStringProperty(arrivalCity);
        this.departureCity = new SimpleStringProperty(departureCity);
        this.status = new SimpleStringProperty(status);
        this.planeModel = new SimpleStringProperty(planeModel);
    }

    /**
     * Конструктор без status
     *
     * @param flightNumber  номер рейса
     * @param departureDate дата отправления
     * @param arrivalDate   дата прибытия
     * @param arrivalCity   город прибытия
     * @param departureCity город отправления
     * @param planeModel    модель самолета
     */
    public Flight(String flightNumber, LocalDateTime departureDate, LocalDateTime arrivalDate, String arrivalCity, String departureCity, String planeModel) {
        this(flightNumber, departureDate, arrivalDate, arrivalCity, departureCity, null, planeModel);
    }

    /**
     * Конструктор без параметров
     */
    public Flight() {
        this(null, null, null, null, null, null, null);
    }

    public long getId() {
        return id.get();
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getFlightNumber() {
        return flightNumber.get();
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber.set(flightNumber);
    }

    public LocalDateTime getDepartureDate() {
        return departureDate.get();
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate.set(departureDate);
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate.get();
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate.set(arrivalDate);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getPlaneModel() {
        return planeModel.get();
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel.set(planeModel);
    }

    public StringProperty getFlightNumberProperty() {
        return flightNumber;
    }

    //TODO: Что-то придумать с датой
    public String getDepartureDateProperty() {
        return DateConvert.DateToStringProperty(departureDate.getValue());
    }

    public ObjectProperty<LocalDateTime> getArrivalDateProperty() {
        return arrivalDate;
    }

    public StringProperty getStatusProperty() {
        return status;
    }

    public StringProperty getPlaneModelProperty() {
        return planeModel;
    }

    public StringProperty getArrivalCityProperty() {
        return arrivalCity;
    }

    public StringProperty getDepartureCityProperty() {
        return departureCity;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber=" + flightNumber +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", departureCity=" + departureCity +
                ", arrivalCity=" + arrivalCity +
                ", status=" + status +
                ", planeModel=" + planeModel +
                '}';
    }
}
