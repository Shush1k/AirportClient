package program.models;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Класс Airline - авиакомпании
 */
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
     * @param code        - код IATA
     * @param name        - название авиакомпании
     * @param website     - сайт
     * @param phoneNumber - номер телефона
     * @param email       - почта
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
     * @param code        - код IATA
     * @param name        - название авиакомпании
     * @param website     - сайт
     * @param phoneNumber - номер телефона
     */

    public Airline(String code,
                   String name,
                   String website,
                   String phoneNumber) {
        this(code, name, website, phoneNumber, null);

    }

    /**
     * Конструктор без phoneNumber
     *
     * @param code    - код IATA
     * @param name    - название авиакомпании
     * @param website - сайт
     * @param email   - почта
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
     * @param code    - код IATA
     * @param name    - название авиакомпании
     * @param website - сайт
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

    public void setId(long id) {
        this.id.set(id);
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setWebsite(String website) {
        this.website.set(website);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public void setEmail(String email) {
        this.email.set(email);
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
