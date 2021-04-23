package program.models;

import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Класс Person - содержит данные об аккаунте пользователя
 */
public class Person {
    private final LongProperty id;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty login;
    private final StringProperty email;
    private final StringProperty phoneNumber;
    private final ObjectProperty<LocalDate> birthday;
    private final StringProperty password;
    private final StringProperty repeatPassword;

    /**
     * Констуктор Персоны
     *
     * @param firstName      - имя
     * @param lastName       - фамилия
     * @param login          - логин
     * @param email          - почта
     * @param phoneNumber    - номер телефона
     * @param birthday       - дата рождения
     * @param password       - пароль
     * @param repeatPassword - повторный пароль
     */
    public Person(String firstName,
                  String lastName,
                  String login,
                  String email,
                  String phoneNumber,
                  LocalDate birthday,
                  String password,
                  String repeatPassword) {
        this.id = new SimpleLongProperty();
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.login = new SimpleStringProperty(login);
        this.email = new SimpleStringProperty(email);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.birthday = new SimpleObjectProperty<>(birthday);
        this.password = new SimpleStringProperty(password);
        this.repeatPassword = new SimpleStringProperty(repeatPassword);
    }

    /**
     * Конструктор без phoneNumber, birthday
     *
     * @param firstName      - имя
     * @param lastName       - фамилия
     * @param login          - логин
     * @param email          - почта
     * @param password       - пароль
     * @param repeatPassword - повторный пароль
     */
    public Person(String firstName,
                  String lastName,
                  String login,
                  String email,
                  String password,
                  String repeatPassword) {
        this(
                firstName,
                lastName,
                login,
                email,
                null,
                null,
                password,
                repeatPassword
        );
    }

    /**
     * Конструктор без birthday
     *
     * @param firstName      - имя
     * @param lastName       - фамилия
     * @param login          - логин
     * @param email          - почта
     * @param phoneNumber    - номер телефона
     * @param password       - пароль
     * @param repeatPassword - повторный пароль
     */
    public Person(String firstName,
                  String lastName,
                  String login,
                  String email,
                  String phoneNumber,
                  String password,
                  String repeatPassword) {
        this(
                firstName,
                lastName,
                login,
                email,
                phoneNumber,
                null,
                password,
                repeatPassword
        );
    }

    /**
     * Конструктор без phoneNumber
     *
     * @param firstName      - имя
     * @param lastName       - фамилия
     * @param login          - логин
     * @param email          - почта
     * @param birthday       - дата рождения
     * @param password       - пароль
     * @param repeatPassword - повторный пароль
     */
    public Person(String firstName,
                  String lastName,
                  String login,
                  String email,
                  LocalDate birthday,
                  String password,
                  String repeatPassword) {
        this(
                firstName,
                lastName,
                login,
                email,
                null,
                birthday,
                password,
                repeatPassword
        );
    }


    /**
     * Пустой конструктор
     */
    public Person() {
        this(null, null, null, null, null, null, null, null);
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getLogin() {
        return login.get();
    }

    public StringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getRepeatPassword() {
        return repeatPassword.get();
    }

    public StringProperty repeatPasswordProperty() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword.set(repeatPassword);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", login=" + login +
                ", email=" + email +
                ", phoneNumber=" + phoneNumber +
                ", birthday=" + birthday +
                ", password=" + password +
                ", repeatPassword=" + repeatPassword +
                '}';
    }
}
