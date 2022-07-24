package com.javamaster.spring_crud.utils;


import com.javamaster.spring_crud.modelo.Vehiculo;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.*;


public class Configuracion {
    public static int PORCENTAJE = 13;
    @Getter
    @Setter
    Map<String, Object> codePagoPayU;

    @Getter
    @Setter
    private Vehiculo vehiculo;

    public Configuracion(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        codePagoPayU = new HashMap();
        codePagoPayU.put("100", "B0ed163B327CA04");
        codePagoPayU.put("110", "B0ed163770C4565");
        codePagoPayU.put("120", "B0ed163844C9DF8");
        codePagoPayU.put("130", "B0ed163BAADC6CF");
        codePagoPayU.put("140", "B0ed163BAADC6CF");
        codePagoPayU.put("150", "B0ed163BAADC6CF");

        codePagoPayU.put("211", "B0ed16343CF8024");
        codePagoPayU.put("212", "B0ed1634F70DEE7");
        codePagoPayU.put("221", "B0ed16317AD56ED");
        codePagoPayU.put("222", "B0ed16350E375EA");
        codePagoPayU.put("231", "B0ed163B427100D");
        codePagoPayU.put("232", "B0ed163BA7D59CF");


        codePagoPayU.put("310", "B0ed163A00BF650");
        codePagoPayU.put("320", "B0ed163651B8EB8");
        codePagoPayU.put("330", "B0ed163C1031417");

        codePagoPayU.put("410", "B0ed163619BEB17");
        codePagoPayU.put("420", "B0ed16332594D40");
        codePagoPayU.put("430", "B0ed1631C7749F8");

        codePagoPayU.put("511", "B0ed1636551CA83");
        codePagoPayU.put("512", "B0ed1632D25F3A2");
        codePagoPayU.put("521", "B0ed1635C6DBFE4");
        codePagoPayU.put("522", "B0ed163AA3AE3DD");
        codePagoPayU.put("531", "B0ed1634A000202");
        codePagoPayU.put("532", "B0ed163F2670E71");

        codePagoPayU.put("611", "B0ed163645B1FA9");
        codePagoPayU.put("612", "B0ed163ECEDF340");
        codePagoPayU.put("621", "B0ed1637337DFEA");
        codePagoPayU.put("622", "B0ed163EBDA2A55");

        codePagoPayU.put("711", "B0ed163A3FBA538");
        codePagoPayU.put("712", "B0ed1630A9F5FC5");
        codePagoPayU.put("721", "B0ed1631B2713EE");
        codePagoPayU.put("722", "B0ed16324EFD1BA");
        codePagoPayU.put("731", "B0ed163CEF412A8");
        codePagoPayU.put("732", "B0ed163CEF412A8");

        codePagoPayU.put("810", "B0ed16309C35D31");

        codePagoPayU.put("910", "B0ed1632423C84A");
        codePagoPayU.put("920", "B0ed16312886908");
    }

    public Configuracion() {
        codePagoPayU = new HashMap();
        codePagoPayU.put("100", "B0ed163B327CA04");
        codePagoPayU.put("110", "B0ed163770C4565");
        codePagoPayU.put("120", "B0ed163844C9DF8");
        codePagoPayU.put("130", "B0ed163BAADC6CF");
        codePagoPayU.put("140", "B0ed163BAADC6CF");
        codePagoPayU.put("150", "B0ed163BAADC6CF");

        codePagoPayU.put("211", "B0ed16343CF8024");
        codePagoPayU.put("212", "B0ed1634F70DEE7");
        codePagoPayU.put("221", "B0ed16317AD56ED");
        codePagoPayU.put("222", "B0ed16350E375EA");
        codePagoPayU.put("231", "B0ed163B427100D");
        codePagoPayU.put("232", "B0ed163BA7D59CF");


        codePagoPayU.put("310", "B0ed163A00BF650");
        codePagoPayU.put("320", "B0ed163651B8EB8");
        codePagoPayU.put("330", "B0ed163C1031417");

        codePagoPayU.put("410", "B0ed163619BEB17");
        codePagoPayU.put("420", "B0ed16332594D40");
        codePagoPayU.put("430", "B0ed1631C7749F8");

        codePagoPayU.put("511", "B0ed1636551CA83");
        codePagoPayU.put("512", "B0ed1632D25F3A2");
        codePagoPayU.put("521", "B0ed1635C6DBFE4");
        codePagoPayU.put("522", "B0ed163AA3AE3DD");
        codePagoPayU.put("531", "B0ed1634A000202");
        codePagoPayU.put("532", "B0ed163F2670E71");

        codePagoPayU.put("611", "B0ed163645B1FA9");
        codePagoPayU.put("612", "B0ed163ECEDF340");
        codePagoPayU.put("621", "B0ed1637337DFEA");
        codePagoPayU.put("622", "B0ed163EBDA2A55");

        codePagoPayU.put("711", "B0ed163A3FBA538");
        codePagoPayU.put("712", "B0ed1630A9F5FC5");
        codePagoPayU.put("721", "B0ed1631B2713EE");
        codePagoPayU.put("722", "B0ed16324EFD1BA");
        codePagoPayU.put("731", "B0ed163CEF412A8");
        codePagoPayU.put("732", "B0ed163CEF412A8");

        codePagoPayU.put("810", "B0ed16309C35D31");

        codePagoPayU.put("910", "B0ed1632423C84A");
        codePagoPayU.put("920", "B0ed16312886908");
    }

    public int yearActual() {
        Date date = new Date();
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        String currentYear = getYearFormat.format(date);
        return Integer.parseInt(currentYear);
    }


    public String mes() {
        Calendar c1 = Calendar.getInstance();
        List<String> meses = Arrays.asList("ENE", "FEB", "MAR", "ABR", ",MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC");
        return (String) meses.get(c1.get(Calendar.MONTH));
    }

    public int date(int DATE) {
        Calendar c1 = Calendar.getInstance();
        return c1.get(DATE);
    }

}
