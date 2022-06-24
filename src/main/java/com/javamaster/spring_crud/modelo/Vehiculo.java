package com.javamaster.spring_crud.modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//import org.json.JSONException;
//import org.json.JSONObject;
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
@Table(name = "vehiculo")
@ToString
@EqualsAndHashCode
public class Vehiculo {



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

    @Id
    @Getter
    @Setter
    @Column(name = "placa")
    String placa; //EDT345

    @Getter
    @Setter
    @Column(name = "tipo")
    String tipo;//Particular

    @Getter
    @Setter
    @Column(name = "clase")
    String clase;//AUTOMOVIL

    @Getter
    @Setter
    @Column(name = "idclase")
    int idClase;//1-9

    @Getter
    @Setter
    @Column(name = "marca")
    String marca;//RENAULT


    @Getter
    @Setter
    @Column(name = "modelo")
    int modelo;//2007


    @Getter
    @Setter
    @Column(name = "linea")
    String linea;//R-CLIO II AUTHENTIQUE EO


    @Getter
    @Setter
    @Column(name = "cilindraje")
    int cilindraje;//1400


    @Getter
    @Setter
    @Column(name = "color")
    String color;//ROJO AMBAR

    @Getter
    @Setter
    @Column(name = "noserie")
    String noserie;

    @Getter
    @Setter
    @Column(name = "nomotor")
    String nomotor;

    @Getter
    @Setter
    @Column(name = "nochasis")
    String nochasis;

    //________________________________________________
    @Getter
    @Setter
    @Column(name = "nonewsoat")
    String nonewsoat;

    //________________________________________________
    @Getter
    @Setter
    @Column(name = "yyycomsoat")
    String yyycomsoat;

    @Getter
    @Setter
    @Column(name = "mmcomsoat")
    String mmcomsoat;

    @Getter
    @Setter
    @Column(name = "ddcomsoat")
    String ddcomsoat;

    @Getter
    @Setter
    @Column(name = "yyyvennusoat")
    String yyyvennusoat;

    @Getter
    @Setter
    @Column(name = "mmvennusoat")
    String mmvennusoat;

    @Getter
    @Setter
    @Column(name = "ddvennusoat")
    String ddvennusoat;

    @Getter
    @Setter
    @Column(name = "valnewsoat")
    String valnewsoat;
//________________________________________________

    @Getter
    @Setter
    @Column(name = "toneladas")
    double toneladas;

    @Getter
    @Setter
    @Column(name = "ocupantes")
    int ocupantes;

    @Getter
    @Setter
    @Column(name = "compro")
    String compro;

    public void obtenerDatosVehiculoVerifik(String token) {
      /*  try {
            HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.verifik.co/v2/co/runt/consultarVehiculoCompleto?plate=" + getPlaca()))
                    .headers("Authorization", "jwt " + token)
                    .GET().build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject json = new JSONObject(response.body());
            setPlaca(String.valueOf(json.getJSONObject("data").get("plate")));
            setTipo(String.valueOf(json.getJSONObject("data").getJSONObject("vehicle").get("tipoServicio")));
            setClase(String.valueOf(json.getJSONObject("data").getJSONObject("vehicle").get("claseVehiculo")));
            setIdClase(Integer.parseInt(json.getJSONObject("data").getJSONObject("vehicle").get("codClaseSise").toString()));
            setMarca(String.valueOf(json.getJSONObject("data").getJSONObject("vehicle").get("marca")));
            setModelo(Integer.parseInt(json.getJSONObject("data").getJSONObject("vehicle").get("modelo").toString()));
            setLinea(String.valueOf(json.getJSONObject("data").getJSONObject("vehicle").get("linea")));
            setCilindraje(Integer.parseInt(json.getJSONObject("data").getJSONObject("vehicle").get("cilindraje").toString()));
            setColor(String.valueOf(json.getJSONObject("data").getJSONObject("vehicle").get("color")));
            setNoserie(String.valueOf(json.getJSONObject("data").getJSONObject("vehicle").get("noSerie")));
            setNomotor(String.valueOf(json.getJSONObject("data").getJSONObject("vehicle").get("noMotor")));
            setNochasis(String.valueOf(json.getJSONObject("data").getJSONObject("vehicle").get("noChasis")));
            setOcupantes(Integer.parseInt(json.getJSONObject("data").getJSONObject("vehicle").get("ocupantes").toString()));
            setToneladas(Double.parseDouble(json.getJSONObject("data").getJSONObject("vehicle").get("toneladas").toString()));

        } catch (JSONException | InterruptedException | URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }*/
    }


}
