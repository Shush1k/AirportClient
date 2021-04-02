package program.models;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private final LongProperty id;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty login;
    private final StringProperty email;
    private final StringProperty password;
    private final StringProperty repeatPassword;

    public Person(String firstName,
                  String lastName,
                  String login,
                  String email,
                  String password,
                  String repeatPassword) {
        this.id = new SimpleLongProperty();
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.login = new SimpleStringProperty(login);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.repeatPassword = new SimpleStringProperty(repeatPassword);
    }


    public Person() {
        this(null, null, null, null, null, null);
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id.get() +
                ", firstName=" + firstName.get() +
                ", lastName=" + lastName.get() +
                ", login=" + login.get() +
                ", email=" + email.get() +
                ", password=" + password.get() +
                ", repeatPassword=" + repeatPassword.get() +
                '}';
    }
}
