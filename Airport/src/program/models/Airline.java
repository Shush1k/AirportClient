package program.models;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

public class Airline {
    private final LongProperty id;
    private final StringProperty code;
    private final StringProperty name;
    private final StringProperty website;
    private final StringProperty phoneNumber;
    private final StringProperty email;

    /**
     * Конструктор авиакомпании
     *
     * @param code
     * @param name
     * @param website
     * @param phoneNumber
     * @param email
     */
    public Airline(String code,
                   String name,
                   String website,
                   String phoneNumber,
                   String email) {
        this.id = new SimpleLongProperty();
        this.code = new SimpleStringProperty(code);
        this.name = new SimpleStringProperty(name);
        this.website = new SimpleStringProperty(website);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.email = new SimpleStringProperty(email);


    }

    /**
     * Констуктор без email
     *
     * @param code
     * @param name
     * @param website
     * @param phoneNumber
     */
    public Airline(String code,
                   String name,
                   String website,
                   String phoneNumber) {
        this(code, name, website, phoneNumber, null);

    }

    /**
     * Конструктор без phoneNumber
     * @param code
     * @param name
     * @param website
     * @param email
     */
    public Airline(String code,
                   String name,
                   String website,
                   Character[] email) {
        this(code, name, website, null, Arrays.toString(email));

    }

    /**
     * Конструктор без phoneNumber, email
     *
     * @param code
     * @param name
     * @param website
     */
    public Airline(String code,
                   String name,
                   String website) {
        this(code, name, website, null, null);

    }

    /**
     * Пустой конструктор Авиакомпании
     */
    public Airline() {
        this(null, null, null, null, null);
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", code=" + code +
                ", name=" + name +
                ", website=" + website +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                '}';
    }
}
