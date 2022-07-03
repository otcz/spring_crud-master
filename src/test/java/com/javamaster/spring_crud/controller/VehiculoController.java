package com.javamaster.spring_crud.controller;


import com.javamaster.spring_crud.dao.UsuarioDao;
import com.javamaster.spring_crud.dao.VehiculoDAO;
import com.javamaster.spring_crud.modelo.Usuario;
import com.javamaster.spring_crud.modelo.Vehiculo;
import com.javamaster.spring_crud.utils.Cobro;
import com.javamaster.spring_crud.utils.EnviarMensajeMSN;
import com.javamaster.spring_crud.utils.SOAT;
import com.javamaster.spring_crud.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Calendar;

@RestController
public class VehiculoController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private VehiculoDAO vehiculoDAO;

    @Autowired
    private Token token;

    @RequestMapping(value = "https://soatcolpatria.herokuapp.com/soat/vehiculo", method = RequestMethod.POST)
    public Vehiculo getUsuarios(@RequestBody Usuario comprador) {

        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setPlaca("EBP399");
        vehiculo.setNombres("OSCAR TOMAS CARRILLO ZULETA");
        vehiculo.setNochasis("354456356");
        vehiculo.setNomotor("3453453");
        vehiculo.setLinea("SPARK");
        vehiculo.setModelo(2018);
        vehiculo.setMarca("CHEVROLET");
        vehiculo.setOcupantes(5);
        vehiculo.setCilindraje(1250);
        vehiculo.setToneladas(0);
        vehiculo.setColor("NEGRO");
        vehiculo.setTipo("Particular");
        vehiculo.setClase("AUTOMOVIL");
        vehiculo.setNoserie("3565432");
        vehiculo.setIdClase(5);
        vehiculo.setIdentificacion(1073995282L);
        vehiculo.setTelefono("3135331533");
        vehiculo.setNonewsoat("465656");

        Cobro cobro = new Cobro(vehiculo);
        vehiculo.setValnewsoat(cobro.calcularCobro());
        vehiculo.setYyycomsoat(String.valueOf(cobro.date(Calendar.YEAR)));
        vehiculo.setMmcomsoat(cobro.mes());
        vehiculo.setDdcomsoat(String.valueOf(cobro.date(Calendar.DATE)));
        vehiculo.setYyyvennusoat(String.valueOf((cobro.date(Calendar.YEAR) + 1)));
        vehiculo.setMmvennusoat(cobro.mes());
        vehiculo.setDdvennusoat(String.valueOf(cobro.date(Calendar.DATE)));
        vehiculo.setCodePayU("cobro.getCodePayU()");
        vehiculo.setCompro("NO");

        vehiculoDAO.registrar(vehiculo);

        return vehiculo;
    }

    @RequestMapping(value = "https://soatcolpatria.herokuapp.com/document/{placa}")
    public Vehiculo documet(HttpServletResponse response,@PathVariable String placa) {
        try {

            SOAT soat = new SOAT(vehiculoDAO.buscarVehiculoPlaca(placa));
            byte[] pdfReport = soat.generarSOAT();
            String mimeType = "application/pdf";
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "reporte.pdf"));
            response.setContentLength(pdfReport.length);
            ByteArrayInputStream inStream = new ByteArrayInputStream(pdfReport);
            FileCopyUtils.copy(inStream, response.getOutputStream());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @RequestMapping(value = "https://soatcolpatria.herokuapp.com/api/enviar/{id}")
    public void enviarMSN(@PathVariable int id) {
        if (id == 1) {
            com.javamaster.spring_crud.utils.EnviarMensajeMSN mensajeMSN = new EnviarMensajeMSN("+573135331533");

            mensajeMSN.setNumeroWhatsApp("whatsapp:+573209972451");
            mensajeMSN.enviarWhatsApp();

            mensajeMSN.enviarWhatsApp("whatsapp:+573209972451");
            mensajeMSN.enviarMNS();


        }


    }
}
