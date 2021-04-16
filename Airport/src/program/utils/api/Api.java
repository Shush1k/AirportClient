package program.utils.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class Api {
    private final String HOST = "http://localhost:8080";
    private Long userId;
    private String userFirstName;
    private String userLastName;
    private String userLogin;
    private String userEmail;

    /**
     * Метод проверки авторизации пользователя на сервере
     * @param login
     * @param password
     * @return
     */
    public Boolean checkUserExists(String login, String password){
        Map<String, String> map = new HashMap<>();
        map.put("login", login);
        map.put("password", password);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        String response = HttpRequestImpl.sendPost(HOST+"/users/auth", json);
        JsonObject jsonResult = JsonParser.parseString(response).getAsJsonObject();
        if (jsonResult.get("success").getAsBoolean()){
            JsonObject result = jsonResult.get("result").getAsJsonObject();
            this.userFirstName = result.get("firstName").getAsString();
            this.userLastName = result.get("lastName").getAsString();
            this.userEmail = result.get("email").getAsString();
            this.userLogin = result.get("login").getAsString();
            this.userId = result.get("id").getAsLong();
            return true;
        }

        return false;
    }
}
