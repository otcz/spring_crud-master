package com.javamaster.spring_crud.modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Entity
@Table(name = "usuario")
@ToString
@EqualsAndHashCode
public class Usuario {
    @Id
    @Getter
    @Setter
    @Column(name = "identificacion")
    private Long identificacion;

    @Getter
    @Setter
    @Nullable
    @Column(name = "nombres")
    private String nombres;

    @Getter
    @Setter
    @Column(name = "telefono")
    private String telefono;

    @Getter
    @Setter
    @Column(name = "placa")
    private String placa;


    public void obetnerNombreUsuario(String token) {
        try {
            HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.verifik.co/v2/co/runt/consultarConductor?documentType=CC&documentNumber=" + getIdentificacion()))
                    .headers("Authorization", "jwt " + token)
                    .GET().build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject json = new JSONObject(response.body());

            setNombres(json.getJSONObject("data").getString("fullName"));

        } catch (JSONException | InterruptedException | URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }


    }


}
