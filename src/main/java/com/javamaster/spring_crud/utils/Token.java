package com.javamaster.spring_crud.utils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class Token {
    @Getter
    @Setter
    private String token;


    public String token() {

        try {
            HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.verifik.co/v2/auth/login?phone=3106485192&password=Idhuejeuduhed*/"))
                    .headers("Content-Type", "text/plain;charset=UTF-8")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(response.body());
            return node.get("accessToken").asText();

        } catch (InterruptedException | URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

    }



}
