package program.utils.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpRequest {

    public static String sendPost(String urlString, String jsonString) {
        try {
            URL obj = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("POST");


            con.setDoOutput(true);
            OutputStream stream = con.getOutputStream();

            stream.write(jsonString.getBytes(StandardCharsets.UTF_8));
            stream.flush();
            stream.close();

            int responseCode = con.getResponseCode();

            //Успешно отработал
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();

            } else {
                System.out.println("POST получил код " + con.getResponseCode());
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static String sendPut(String urlString, String jsonString) {
        try {
            URL obj = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("PUT");
            con.setDoOutput(true);
            OutputStream stream = con.getOutputStream();

            stream.write(jsonString.getBytes(StandardCharsets.UTF_8));
            stream.flush();
            stream.close();

            int responseCode = con.getResponseCode();

            //Успешно отработал
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();

            } else {
                System.out.println("PUT получил код " + con.getResponseCode());
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }


    public static String sendGet(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            //Если все хорошо
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();

            } else {
                System.out.println("GET получил код " + con.getResponseCode());
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static String sendDelete(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestProperty(
                    "Content-Type", "application/x-www-form-urlencoded");
            httpCon.setRequestMethod("DELETE");

            int responseCode = httpCon.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();

            } else {
                System.out.println("DELETE получил код " + httpCon.getResponseCode());
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }
}