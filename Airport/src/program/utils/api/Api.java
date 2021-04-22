package program.utils.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import program.models.Flight;
import program.models.Person;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Api {
    private final String HOST = "http://localhost:8080";
    private Person currentLoginPerson;

    /**
     * Метод проверки авторизации пользователя на сервере
     *
     * @param login    - логин
     * @param password - пароль
     * @return true если есть в БД
     */
    public Boolean checkUserExists(String login, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("login", login);
        map.put("password", password);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        String URL = String.format("%s/users/auth", HOST);
        String response = HttpRequest.sendPost(URL, json);
        JsonObject jsonResult = JsonParser.parseString(response).getAsJsonObject();
        if (jsonResult.get("success").getAsBoolean()) {
            JsonObject result = jsonResult.get("result").getAsJsonObject();
            currentLoginPerson = new Person();
            currentLoginPerson.setLogin(result.get("login").getAsString());
            currentLoginPerson.setEmail(result.get("email").getAsString());
            currentLoginPerson.setFirstName(result.get("firstName").getAsString());
            currentLoginPerson.setLastName(result.get("lastName").getAsString());
            currentLoginPerson.setId(result.get("id").getAsLong());
            return true;
        }

        return false;
    }

    /**
     * Метод создания пользователя
     *
     * @param firstName - имя
     * @param lastName  - фамилия
     * @param login     - логин
     * @param email     - почта
     * @param password  - пароль
     * @return true - если добавлен в БД
     */
//    TODO: сделать метод рабочим
    public Boolean createUser(String firstName, String lastName, String login, String email, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("login", login);
        map.put("firstName", firstName);
        map.put("lastName", lastName);
        map.put("email", email);
        map.put("password", password);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        String URL = String.format("%s/users/registration", HOST);
        String response = HttpRequest.sendPost(URL, json);
        JsonObject jsonResult = JsonParser.parseString(response).getAsJsonObject();
        if (jsonResult.get("success").getAsBoolean()) {
            return true;
        }
        return false;
    }

    public List<Flight> getArrivalFlights(String startDate, String endDate, Boolean isArrive) {

        startDate = URLEncoder.encode(startDate, StandardCharsets.UTF_8);
        endDate = URLEncoder.encode(endDate, StandardCharsets.UTF_8);


        String URL = String.format("%s/flights/dates?startDate=%s&endDate=%s&isArrive=%s", HOST, startDate, endDate, isArrive.toString());
        List<Flight> result = new ArrayList<>();
        String response = HttpRequest.sendGet(URL);
        JsonArray jsonArray = JsonParser.parseString(response).getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject flightJson = jsonArray.get(i).getAsJsonObject();
            Flight flight = new Flight();
            flight.setId(flightJson.get("flight_id").getAsInt());
            flight.setFlightNumber(flightJson.get("flightNumber").getAsString());
            LocalDateTime departureDate = DateConvert.stringToDate(flightJson.get("departureDate").getAsString());
            flight.setDepartureDate(departureDate);
            LocalDateTime arrivalDate = DateConvert.stringToDate(flightJson.get("arrivalDate").getAsString());
            flight.setArrivalDate(arrivalDate);
            flight.setStatus(flightJson.get("status").getAsString());
            flight.setPlaneModel(flightJson.get("planeModel").getAsString());
            result.add(flight);
        }
        return result;

    }

    /**
     * Получаем список всех рейсов
     *
     * @return список рейсов
     */
    public List<Flight> getAllFlights() {
        String URL = String.format("%s/flights/all", HOST);
        List<Flight> result = new ArrayList<>();
        String response = HttpRequest.sendGet(URL);
        JsonArray jsonArray = JsonParser.parseString(response).getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject flightJson = jsonArray.get(i).getAsJsonObject();
            Flight flight = new Flight();
            flight.setId(flightJson.get("flight_id").getAsInt());
            flight.setFlightNumber(flightJson.get("flightNumber").getAsString());
            LocalDateTime departureDate = DateConvert.stringToDate(flightJson.get("departureDate").getAsString());
            flight.setDepartureDate(departureDate);
            LocalDateTime arrivalDate = DateConvert.stringToDate(flightJson.get("arrivalDate").getAsString());
            flight.setArrivalDate(arrivalDate);
            flight.setStatus(flightJson.get("status").getAsString());
            flight.setPlaneModel(flightJson.get("planeModel").getAsString());
            result.add(flight);
        }
        return result;

    }

//    public List<Flight> getDepartureFlights();
}
