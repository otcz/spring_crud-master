package com.javamaster.spring_crud.modelo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Entity
@Table(name = "vehiculo")
@ToString
@EqualsAndHashCode
public class Vehiculo {

    @Id
    @Getter
    @Setter
    @Column(name = "placa")
    String placa = "NO"; //EDT345

    @Getter
    @Setter
    @Column(name = "identificacion")
    private Long identificacion = 0L;

    @Getter
    @Setter
    @Nullable
    @Column(name = "nombres")
    private String nombres = "ERROR AL CONSULTAR DATA RUT";

    @Getter
    @Setter
    @Column(name = "telefono")
    private String telefono = "0000000000";


    @Getter
    @Setter
    @Column(name = "tipo")
    String tipo = "NO";//Particular

    @Getter
    @Setter
    @Column(name = "clase")
    String clase = "NO";//AUTOMOVIL


    @Getter
    @Setter
    @Column(name = "marca")
    String marca = "NO";//RENAULT


    @Getter
    @Setter
    @Column(name = "modelo")
    int modelo = 0000;//2007


    @Getter
    @Setter
    @Column(name = "linea")
    String linea = "NO";//R-CLIO II AUTHENTIQUE EO


    @Getter
    @Setter
    @Column(name = "cilindraje")
    int cilindraje = 0000;//1400


    @Getter
    @Setter
    @Column(name = "codigoTarifa")
    String codigoTarifa = "NO";//ROJO AMBAR

    @Getter
    @Setter
    @Column(name = "noVin")
    String noVin = "NO";

    @Getter
    @Setter
    @Column(name = "nomotor")
    String nomotor = "NO";

    @Getter
    @Setter
    @Column(name = "nochasis")
    String nochasis = "NO";

    //________________________________________________
    @Getter
    @Setter
    @Column(name = "nonewsoat")
    String nonewsoat = "NO";

    //________________________________________________
    @Getter
    @Setter
    @Column(name = "yyycomsoat")
    String yyycomsoat = "NO";

    @Getter
    @Setter
    @Column(name = "mmcomsoat")
    String mmcomsoat = "NO";

    @Getter
    @Setter
    @Column(name = "ddcomsoat")
    String ddcomsoat = "NO";

    @Getter
    @Setter
    @Column(name = "yyyvennusoat")
    String yyyvennusoat = "NO";

    @Getter
    @Setter
    @Column(name = "mmvennusoat")
    String mmvennusoat = "NO";

    @Getter
    @Setter
    @Column(name = "ddvennusoat")
    String ddvennusoat = "NO";

    @Getter
    @Setter
    @Column(name = "costoTotal")
    String costoTotal = "NO";

    @Getter
    @Setter
    @Column(name = "prima")
    String prima = "NO";

    @Getter
    @Setter
    @Column(name = "contribucion")
    String contribucion = "NO";


    @Getter
    @Setter
    @Column(name = "runt")
    String runt = "NO";


    //________________________________________________
    @Getter
    @Setter
    @Column(name = "ocupantes")
    int ocupantes = 0;

    @Getter
    @Setter
    @Column(name = "toneladas")
    double toneladas = 0000;


    @Getter
    @Setter
    @Column(name = "compro")
    String compro = "NO";

    @Getter
    @Setter
    @Column(name = "cobro")
    String cobro = "NO";

    public void obtenerDatosVehiculoVerifik(String token) {

        try {
            URL url = new URL("https://api.verifik.co/v2/co/soat/consultarVehiculo?plate=" + getPlaca());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Authorization", "jwt " + token);
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setDoOutput(true);
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                br.close();

                ObjectMapper mapper = new ObjectMapper();
                JsonNode node = mapper.readTree(response.toString());

                setModelo(Integer.parseInt(node.get("data").get("vehiculo").get("modelo").asText()));
                setNochasis(node.get("data").get("vehiculo").get("numeroChasis").asText());
                setMarca(node.get("data").get("vehiculo").get("marca").asText());
                setLinea(node.get("data").get("vehiculo").get("linea").asText());
                setClase(node.get("data").get("vehiculo").get("claseVehiculo").asText());
                setCodigoTarifa(node.get("data").get("vehiculo").get("codigoTarifa").asText());
                setPrima((node.get("data").get("vehiculo").get("prima").asText()));
                setContribucion((node.get("data").get("vehiculo").get("contribucion").asText()));
                setRunt((node.get("data").get("vehiculo").get("rut").asText()));
                setCostoTotal(node.get("data").get("vehiculo").get("costoTotal").asText());

            }

        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void obtenerSOAT(String token) {
        try {
            URL url = new URL("https://api.verifik.co/v2/co/runt/consultarVehiculoCompleto?plate=" + getPlaca());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Authorization", "JWT " + token);
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setDoOutput(true);
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                br.close();
                ObjectMapper mapper = new ObjectMapper();
                JsonNode node = mapper.readTree(response.toString());
                setNombres(String.valueOf(node));
                setTipo(node.get("data").get("vehicle").get("tipoServicio").asText());
                setCilindraje(Integer.parseInt(node.get("data").get("vehicle").get("cilindraje").asText()));
                setNomotor(node.get("data").get("vehicle").get("noMotor").asText());
                setNoVin(node.get("data").get("vehicle").get("noVin").asText());
                setOcupantes(Integer.parseInt(node.get("data").get("vehicle").get("ocupantes").asText()));
                setToneladas(Double.parseDouble(node.get("data").get("vehicle").get("toneladas").asText()));


            }

        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }

    }


}
