package program.utils.api;

import java.util.HashMap;
import java.util.Map;

public class Api {
    private final String HOST = "http://localhost:8080";

    private Boolean checkUserExists(String login, String password){
        Map<String, String> map = new HashMap<>();
        map.put("login", login);
        map.put("password", password);
        String jsonResult = new JSONObject(map);
        String response = HttpRequestImpl.sendPost(HOST+"/users/auth", );
    }
}
