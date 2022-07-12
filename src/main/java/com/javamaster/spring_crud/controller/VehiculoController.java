package com.javamaster.spring_crud.controller;


import com.javamaster.spring_crud.dao.UsuarioDao;
import com.javamaster.spring_crud.dao.VehiculoDAO;
import com.javamaster.spring_crud.modelo.Usuario;
import com.javamaster.spring_crud.modelo.Vehiculo;
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

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
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

    public Vehiculo vehiculoComprador;

    @RequestMapping(value = "soatcolpatria.herokuapp.com/soat/vehiculo", method = RequestMethod.POST)
    public Vehiculo getUsuarios(@RequestBody Usuario comprador) {
        this.comprador = comprador;
        // String sToken = token.obtenerToken();
        // comprador.completarNombreUsuario(sToken);
        // Vehiculo vehiculo = new Vehiculo();
        // vehiculo.setPlaca(comprador.getPlaca());
        // vehiculo.setNombres(comprador.getNombres());
        // vehiculo.setIdentificacion(comprador.getIdentificacion());
        // vehiculo.setTelefono(comprador.getTelefono());
        // vehiculo.obtenerDatosVehiculoVerifik(sToken);
        // Cobro cobro = new Cobro(vehiculo);
        // vehiculo.setValnewsoat(cobro.calcularCobro());
        // vehiculo.setYyycomsoat(String.valueOf(cobro.date(Calendar.YEAR)));
        // vehiculo.setMmcomsoat(cobro.mes());
        // vehiculo.setDdcomsoat(String.valueOf(cobro.date(Calendar.DATE)));
        // vehiculo.setYyyvennusoat(String.valueOf((cobro.date(Calendar.YEAR) + 1)));
        // vehiculo.setMmvennusoat(cobro.mes());
        // vehiculo.setDdvennusoat(String.valueOf(cobro.date(Calendar.DATE)));
        // vehiculo.setCobro(cobro.getCobro());
        // vehiculo.setCompro("NO");
        // vehiculoDAO.registrar(vehiculo);
        // return vehiculo;
        //  vehiculoDAO.registrar(vehiculo);

        vehiculoComprador = vehiculoDAO.buscarVehiculoPlaca(comprador.getPlaca());
        return vehiculoDAO.buscarVehiculoPlaca(comprador.getPlaca());
    }

    @RequestMapping(value = "soatcolpatria.herokuapp.com/documento", method = RequestMethod.POST)
    public void documento(HttpServletResponse response, @PathVariable String placa) {
        try {
            SOAT soat = new SOAT(vehiculoDAO.buscarVehiculoPlaca(placa));
            // Prepare.
            byte[] pdfData = soat.generarSOAT();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            response = (HttpServletResponse) externalContext.getResponse();

            // Initialize response.
            response.reset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
            response.setContentType("application/pdf"); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ServletContext#getMimeType() for auto-detection based on filename.
            response.setHeader("Content-disposition", "attachment; filename=\"name.pdf\""); // The Save As popup magic is done here. You can give it any filename you want, this only won't work in MSIE, it will use current request URL as filename instead.

            // Write file to response.
            OutputStream output = null;

            output = response.getOutputStream();

            output.write(pdfData);
            output.close();

            // Inform JSF to not take the response in hands.
            facesContext.responseComplete(); // Important! Else JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "http://www.tusoatcolpatria.com/document/{placa}", method = RequestMethod.GET)
    public void doGet(HttpServletResponse response, @PathVariable String placa) {
        try {

            SOAT soat = new SOAT(vehiculoComprador);
            byte[] pdfReport = soat.generarSOAT();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "reporte.pdf"));
            response.setContentLength(pdfReport.length);
            ByteArrayInputStream inStream = new ByteArrayInputStream(pdfReport);
            FileCopyUtils.copy(inStream, response.getOutputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //PDF
    @RequestMapping(value = "https://tusoatcolpatria.com/documentPDF", method = RequestMethod.GET)
    public void documentPDF(HttpServletResponse response) {
        try {
            Vehiculo vehiculo = vehiculoDAO.buscarVehiculoPlaca(comprador.getPlaca());
            if (vehiculo.getCompro().equals("NO")) {
                SOAT soat = new SOAT(vehiculo);
                byte[] pdfReport = soat.generarSOAT();
                String mimeType = "application/pdf";
                response.setContentType(mimeType);
                response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "reporte.pdf"));
                response.setContentLength(pdfReport.length);
                ByteArrayInputStream inStream = new ByteArrayInputStream(pdfReport);
                FileCopyUtils.copy(inStream, response.getOutputStream());

                //SE DEBE ACTUALIZAR EL CAMPO DE COMPRO
            }

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
