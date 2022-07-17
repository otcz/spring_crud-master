package com.javamaster.spring_crud.controller;


import com.javamaster.spring_crud.dao.UsuarioDao;
import com.javamaster.spring_crud.dao.VehiculoDAO;
import com.javamaster.spring_crud.modelo.Usuario;
import com.javamaster.spring_crud.modelo.Vehiculo;
import com.javamaster.spring_crud.utils.Cobro;
import com.javamaster.spring_crud.utils.EnviarMensajeMSN;
import com.javamaster.spring_crud.utils.SOAT;
import com.javamaster.spring_crud.utils.Token;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class VehiculoController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private VehiculoDAO vehiculoDAO;

    @Autowired
    private Token token;

    public Usuario comprador;

    @RequestMapping(value = "soatcolpatria.herokuapp.com/soat/vehiculo", method = RequestMethod.POST)
    public Vehiculo getUsuarios(@RequestBody Usuario comprador) {
        this.comprador = comprador;
        String sToken = token.obtenerToken();
        comprador.completarNombreUsuario(sToken);
        Vehiculo vehiculo = new Vehiculo();
        //vehiculo.setPlaca(comprador.getPlaca());
        //vehiculo.setNombres(comprador.getNombres());
        //vehiculo.setIdentificacion(comprador.getIdentificacion());
        //vehiculo.setTelefono(comprador.getTelefono());
        //vehiculo.obtenerDatosVehiculoVerifik(sToken);
        //Cobro cobro = new Cobro(vehiculo);
        //vehiculo.setValnewsoat(cobro.calcularCobro());
        //vehiculo.setYyycomsoat(String.valueOf(cobro.date(Calendar.YEAR)));
        //vehiculo.setMmcomsoat(cobro.mes());
        //vehiculo.setDdcomsoat(String.valueOf(cobro.date(Calendar.DATE)));
        //vehiculo.setYyyvennusoat(String.valueOf((cobro.date(Calendar.YEAR) + 1)));
        //vehiculo.setMmvennusoat(cobro.mes());
        //vehiculo.setDdvennusoat(String.valueOf(cobro.date(Calendar.DATE)));
        //vehiculo.setCobro(cobro.getCobro());
        //vehiculo.setCompro("NO");
        //vehiculoDAO.registrar(vehiculo);
        vehiculo.setNombres(comprador.getNombres());
        return vehiculo;

    }

    @RequestMapping(value = "soatcolpatria.herokuapp.com/documento", method = RequestMethod.POST)
    public void documento(HttpServletResponse response, @RequestBody String placa) {
        Vehiculo vehiculo = vehiculoDAO.buscarVehiculoPlaca(placa);
        SOAT soat = new SOAT(vehiculo);
        byte[] pdfReport = soat.generarSOAT();
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "reporte.pdf"));
        response.setContentLength(pdfReport.length);
        ByteArrayInputStream inStream = new ByteArrayInputStream(pdfReport);
        try {
            FileCopyUtils.copy(inStream, response.getOutputStream());
            vehiculo.setCompro("SI");
            vehiculoDAO.registrar(vehiculo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //enviarMSN y WHATSAPP
    @RequestMapping(value = "tusoatcolpatria.com/consulta/enviar/{id}")
    public void enviarMSN(@PathVariable int id) {
        if (id == 1) {
            EnviarMensajeMSN mensajeMSN = new EnviarMensajeMSN("+573135331533");
            mensajeMSN.setNumeroWhatsApp("whatsapp:+573209972451");
            mensajeMSN.enviarWhatsApp();
            mensajeMSN.enviarWhatsApp("whatsapp:+573209972451");
            mensajeMSN.enviarMNS();
        }


    }


}
