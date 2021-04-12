package program.models;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Route {
    private final LongProperty id;
    private final StringProperty departureCity;
    private final StringProperty arrivalCity;

    /**
     * Конструктор маршрутов
     *
     * @param departureCity - город отправления
     * @param arrivalCity   - город прибытия
     */
    public Route(String departureCity, String arrivalCity) {
        this.id = new SimpleLongProperty();
        this.departureCity = new SimpleStringProperty(departureCity);
        this.arrivalCity = new SimpleStringProperty(arrivalCity);
    }

    /**
     * Конструктор без параметров
     */
    public Route() {
        this(null, null);
    }

    public String getDepartureCity() {
        return departureCity.get();
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity.set(departureCity);
    }

    public String getArrivalCity() {
        return arrivalCity.get();
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity.set(arrivalCity);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", departureCity=" + departureCity +
                ", arrivalCity=" + arrivalCity +
                '}';
    }
}
