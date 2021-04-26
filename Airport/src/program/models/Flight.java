package program.models;

import javafx.beans.property.*;

import java.time.LocalDateTime;
import java.util.Arrays;

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
    private final StringProperty airlineName;
    private final StringProperty airlineWebsite;
    private final StringProperty airlinePhone;
    private final StringProperty airlineEmail;

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
     *                      4 параметра!
     */
    public Flight(String flightNumber, LocalDateTime departureDate, LocalDateTime arrivalDate, String arrivalCity, String departureCity, String status, String planeModel,
                  String airlineName, String airlinePhone, String airlineEmail, String airlineWebsite) {
        this.id = new SimpleLongProperty();
        this.flightNumber = new SimpleStringProperty(flightNumber);
        this.departureDate = new SimpleObjectProperty<>(departureDate);
        this.arrivalDate = new SimpleObjectProperty<>(arrivalDate);
        this.arrivalCity = new SimpleStringProperty(arrivalCity);
        this.departureCity = new SimpleStringProperty(departureCity);
        this.status = new SimpleStringProperty(status);
        this.planeModel = new SimpleStringProperty(planeModel);

        this.airlineName = new SimpleStringProperty(airlineName);
        this.airlinePhone = new SimpleStringProperty(airlinePhone);
        this.airlineEmail = new SimpleStringProperty(airlineEmail);
        this.airlineWebsite = new SimpleStringProperty(airlineWebsite);
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
    public Flight(String flightNumber, LocalDateTime departureDate, LocalDateTime arrivalDate, String arrivalCity, String departureCity, String planeModel, String airlineName, String airlinePhone, String airlineEmail, String airlineWebsite) {
        this(flightNumber, departureDate, arrivalDate, arrivalCity, departureCity, null, planeModel, airlineName, airlinePhone, airlineEmail, airlineWebsite);
    } // 4


    /**
     * Конструктор без параметров
     */
    public Flight() {
        this(null, null, null, null, null, null, null, null, null, null, null);
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

    public void setDepartureCity(String departureCity) {
        this.departureCity.set(departureCity);
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity.set(arrivalCity);
    }

    public StringProperty getFlightNumberProperty() {
        return flightNumber;
    }

    public ObjectProperty<LocalDateTime> getDepartureDateProperty() {
        return departureDate;
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

    public String getDepartureCity() {
        return departureCity.get();
    }

    public String getArrivalCity() {
        return arrivalCity.get();
    }

    public String getAirlineName() {
        return airlineName.get();
    }

    public String getPhoneNumber() {
        return airlinePhone.get();
    }

    public String getEmail() {
        return airlineEmail.get();
    }

    public String getWebsite() {
        return airlineWebsite.get();
    }

    public void setAirlineName(String airlineName) {
        this.airlineName.set(airlineName);
    }

    public void setAirlineWebsite(String airlineWebsite) {
        this.airlineWebsite.set(airlineWebsite);
    }

    public void setAirlinePhone(String airlinePhone) {
        this.airlinePhone.set(airlinePhone);
    }

    public void setAirlineEmail(String airlineEmail) {
        this.airlineEmail.set(airlineEmail);
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
