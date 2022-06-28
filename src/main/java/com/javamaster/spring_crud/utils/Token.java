package com.javamaster.spring_crud.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@Component
public class Token {
    @Getter
    @Setter
    private String token;


    public String token() {

        // try {
        // HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        //HttpRequest request = HttpRequest.newBuilder()
        //      .uri(new URI("https://api.verifik.co/v2/auth/login?phone=3106485192&password=Idhuejeuduhed*/"))
        //    .headers("Content-Type", "text/plain;charset=UTF-8")
        //  .POST(HttpRequest.BodyPublishers.noBody())
        //.build();

        //HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //ObjectMapper mapper = new ObjectMapper();
        //JsonNode node = mapper.readTree(response.body());
        //return node.get("accessToken").asText();

        //} catch (InterruptedException | URISyntaxException | IOException e) {
        //    throw new RuntimeException(e);
        //}
        return null;
    }

    public String consultarTokens() {
        try {
            String POST_PARAMS = "userName=Pankaj";

            URL obj = new URL("https://api.verifik.co/v2/auth/login?phone=3046602241&password=Idhuejeuduhed*/");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);

            // For POST only - START
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();

            int responseCode = con.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                return response.toString();
            } else {
                System.out.println("POST request not worked");
            }
        } catch (MalformedURLException | ProtocolException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
