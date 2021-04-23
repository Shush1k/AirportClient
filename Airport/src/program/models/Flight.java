package program.models;

import javafx.beans.property.*;

import java.time.LocalDateTime;

/**
 * Класс Flight - рейсы
 */
public class Flight {
    private final LongProperty id;
    private final StringProperty flightNumber;
    private final ObjectProperty<LocalDateTime> departureDate;
    private final ObjectProperty<LocalDateTime> arrivalDate;
    private final StringProperty status;
    private final StringProperty planeModel;

    /**
     * Конструктор Рейсов
     *
     * @param flightNumber  - номер рейса
     * @param departureDate - дата отправления
     * @param arrivalDate   - дата прибытия
     * @param status        - статус рейса
     * @param planeModel    - модель самолета
     */
    public Flight(String flightNumber, LocalDateTime departureDate, LocalDateTime arrivalDate, String status, String planeModel) {
        this.id = new SimpleLongProperty();
        this.flightNumber = new SimpleStringProperty(flightNumber);
        this.departureDate = new SimpleObjectProperty<>(departureDate);
        this.arrivalDate = new SimpleObjectProperty<>(arrivalDate);
        this.status = new SimpleStringProperty(status);
        this.planeModel = new SimpleStringProperty(planeModel);
    }

    /**
     * Конструктор без status
     *
     * @param flightNumber  - номер рейса
     * @param departureDate - дата отправления
     * @param arrivalDate   - дата прибытия
     * @param planeModel    - модель самолета
     */
    public Flight(String flightNumber, LocalDateTime departureDate, LocalDateTime arrivalDate, String planeModel) {
        this(flightNumber, departureDate, arrivalDate, null, planeModel);
    }

    /**
     * Конструктор без параметров
     */
    public Flight() {
        this(null, null, null, null, null);
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

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber=" + flightNumber +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", status=" + status +
                ", planeModel=" + planeModel +
                '}';
    }
}
