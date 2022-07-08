package com.javamaster.spring_crud.controller;


import com.javamaster.spring_crud.dao.UsuarioDao;
import com.javamaster.spring_crud.dao.VehiculoDAO;
import com.javamaster.spring_crud.modelo.Usuario;
import com.javamaster.spring_crud.modelo.Vehiculo;
import com.javamaster.spring_crud.utils.Cobro;
import com.javamaster.spring_crud.utils.EnviarMensajeMSN;
import com.javamaster.spring_crud.utils.SOAT;
import com.javamaster.spring_crud.utils.Token;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

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


        return vehiculoDAO.buscarVehiculoPlaca(comprador.getPlaca());
    }

    @WebServlet("soatcolpatria.herokuapp.com/soat/download")
    public class DownloadServlet extends HttpServlet {
        private final int ARBITARY_SIZE = 1048;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {

            resp.setContentType("text/plain");
            resp.setHeader("Content-disposition", "attachment; filename=sample.txt");

            try (InputStream in = req.getServletContext().getResourceAsStream("/WEB-INF/sample.txt");
                 OutputStream out = resp.getOutputStream()) {

                byte[] buffer = new byte[ARBITARY_SIZE];

                int numBytesRead;
                while ((numBytesRead = in.read(buffer)) > 0) {
                    out.write(buffer, 0, numBytesRead);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @RequestMapping(value = "soatcolpatria.herokuapp.com/documentPDF{placa}")
    public Vehiculo documet(HttpServletResponse response, @PathVariable String placa) {
        try {

            SOAT soat = new SOAT(vehiculoDAO.buscarVehiculoPlaca(placa));
            byte[] pdfReport = soat.generarSOAT();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "reporte.pdf"));
            response.setContentLength(pdfReport.length);
            ByteArrayInputStream inStream = new ByteArrayInputStream(pdfReport);
            FileCopyUtils.copy(inStream, response.getOutputStream());
            JasperExportManager.exportReportToPdfStream(soat.generarPrintSOAT(), response.getOutputStream());

        } catch (IOException | JRException e) {
            throw new RuntimeException(e);
        }
        return null;
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
