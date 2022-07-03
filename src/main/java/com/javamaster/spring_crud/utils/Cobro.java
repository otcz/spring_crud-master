package com.javamaster.spring_crud.utils;


import com.javamaster.spring_crud.modelo.Vehiculo;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.*;


public class Cobro {


    @Getter
    @Setter
    private List<String> valoresDES = Arrays.asList("180.180", "373.320", "500.850", "564.840", "564.840", "564.840", "588.150", "707.040", "702.360", "831.870", "823.680", "945.180", "659,160", "951,750", "1,203,300", "741,600", "934,740", "1,120,680", "331,920", "440,010", "404,010", "502,650", "471,870", "559,710"
            , "591,660", "755,010", "791,820", "950,760", "410,940", "513,450", "510,840", "631,350", "659,160", "773,190", "983,790", "972,990", "1,411,650");
    @Getter
    @Setter
    private String codePayUCobro;

    private List<String> hrefs = Arrays.asList("B0ed163B327CA04", "B0ed163770C4565", "B0ed163844C9DF8", "B0ed163BAADC6CF", "B0ed163BAADC6CF", "B0ed163BAADC6CF"
            , "B0ed16343CF8024", "B0ed1634F70DEE7", "B0ed16317AD56ED", "B0ed16350E375EA", "B0ed163B427100D", "B0ed163BA7D59CF"
            , "B0ed163A00BF650", "B0ed163651B8EB8", "B0ed163C1031417"
            , "B0ed163619BEB17", "B0ed16332594D40", "B0ed1631C7749F8"
            , "B0ed1636551CA83", "B0ed1632D25F3A2", "B0ed1635C6DBFE4", "B0ed163AA3AE3DD", "B0ed1634A000202", "B0ed163F2670E71"
            , "B0ed163645B1FA9", "B0ed163ECEDF340", "B0ed1637337DFEA", "B0ed163EBDA2A55"
            , "B0ed163A3FBA538", "B0ed1630A9F5FC5", "B0ed1631B2713EE", "B0ed16324EFD1BA", "B0ed163CEF412A8", "B0ed163CEF412A8"
            , "B0ed16309C35D31"
            , "B0ed1632423C84A", "B0ed16312886908");


    @Getter
    @Setter
    private Vehiculo vehiculo;

    public Cobro(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String calcularCobro() {
        String setCobro = "";
        int resul = yearActual() - getVehiculo().getModelo();
        switch (getVehiculo().getIdClase()) {
            case 1:
                if (getVehiculo().getClase() == ("Ciclomotor")) {
                    setCobro = valoresDES.get(0);
                    codePayUCobro = hrefs.get(0);
                } else if ((getVehiculo().getCilindraje()) < 100) {
                    setCobro = valoresDES.get(1);
                    codePayUCobro = hrefs.get(1);
                } else if ((getVehiculo().getCilindraje()) >= 100 && (getVehiculo().getCilindraje()) < 200) {
                    setCobro = valoresDES.get(2);
                    codePayUCobro = hrefs.get(2);
                } else if ((getVehiculo().getCilindraje()) >= 200) {
                    setCobro = valoresDES.get(3);
                    codePayUCobro = hrefs.get(3);
                } else if ((getVehiculo().getClase()) == "Motocarro, tricimoto, Cuatriciclo") {
                    setCobro = valoresDES.get(4);
                    codePayUCobro = hrefs.get(4);
                } else {
                    setCobro = valoresDES.get(5);
                    codePayUCobro = hrefs.get(5);
                }
                break;

            case 2:
                if ((getVehiculo().getCilindraje()) < 1500 && (resul < 10)) {
                    setCobro = valoresDES.get(6);
                    codePayUCobro = hrefs.get(6);
                } else if ((getVehiculo().getCilindraje()) < 1500 && (resul >= 10)) {
                    setCobro = valoresDES.get(7);
                    codePayUCobro = hrefs.get(7);
                } else if ((getVehiculo().getCilindraje()) >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(8);
                    codePayUCobro = hrefs.get(8);
                } else if ((getVehiculo().getCilindraje()) >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(9);
                    codePayUCobro = hrefs.get(9);
                } else if ((getVehiculo().getCilindraje()) > 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(10);
                    codePayUCobro = hrefs.get(10);
                } else if ((getVehiculo().getCilindraje()) > 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(11);
                    codePayUCobro = hrefs.get(11);
                }
                break;
            case 3:
                if (getVehiculo().getToneladas() < 5) {
                    setCobro = valoresDES.get(12);
                    codePayUCobro = hrefs.get(12);
                } else if (getVehiculo().getToneladas() >= 5 && getVehiculo().getToneladas() <= 15) {
                    setCobro = valoresDES.get(13);
                    codePayUCobro = hrefs.get(13);
                } else if (getVehiculo().getToneladas() > 15) {
                    setCobro = valoresDES.get(14);
                    codePayUCobro = hrefs.get(14);
                }

                break;
            case 4:

                if (getVehiculo().getCilindraje() < 1500) {
                    setCobro = valoresDES.get(15);
                    codePayUCobro = hrefs.get(15);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getToneladas() <= 2500) {
                    setCobro = valoresDES.get(16);
                    codePayUCobro = hrefs.get(16);
                } else if (getVehiculo().getCilindraje() > 2500) {
                    setCobro = valoresDES.get(17);
                    codePayUCobro = hrefs.get(17);
                }

                break;
            case 5:

                if (getVehiculo().getCilindraje() < 1500 && (resul < 10)) {
                    setCobro = valoresDES.get(18);
                    codePayUCobro = hrefs.get(18);
                } else if (getVehiculo().getCilindraje() < 1500 && (resul >= 10)) {
                    setCobro = valoresDES.get(19);
                    codePayUCobro = hrefs.get(19);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(20);
                    codePayUCobro = hrefs.get(20);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(21);
                    codePayUCobro = hrefs.get(21);
                } else if (getVehiculo().getCilindraje() > 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(22);
                    codePayUCobro = hrefs.get(22);
                } else if (getVehiculo().getCilindraje() > 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(23);
                    codePayUCobro = hrefs.get(23);
                }
                break;
            case 6:
                if (getVehiculo().getCilindraje() < 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(24);
                    codePayUCobro = hrefs.get(24);
                } else if (getVehiculo().getCilindraje() < 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(25);
                    codePayUCobro = hrefs.get(25);
                } else if (getVehiculo().getCilindraje() >= 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(26);
                    codePayUCobro = hrefs.get(26);
                } else if (getVehiculo().getCilindraje() >= 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(27);
                    codePayUCobro = hrefs.get(27);
                }
                break;
            case 7:
                if (getVehiculo().getCilindraje() < 1500 && (resul < 10)) {
                    setCobro = valoresDES.get(28);
                    codePayUCobro = hrefs.get(28);
                } else if (getVehiculo().getCilindraje() < 1500 && (resul >= 10)) {
                    setCobro = valoresDES.get(29);
                    codePayUCobro = hrefs.get(29);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(30);
                    codePayUCobro = hrefs.get(30);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(31);
                    codePayUCobro = hrefs.get(31);
                } else if (getVehiculo().getCilindraje() > 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(32);
                    codePayUCobro = hrefs.get(32);
                } else if (getVehiculo().getCilindraje() > 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(33);
                    codePayUCobro = hrefs.get(33);
                }
                break;
            case 8:
                setCobro = valoresDES.get(34);
                codePayUCobro = hrefs.get(34);
                break;
            case 9:
                if (getVehiculo().getOcupantes() < 10) {
                    setCobro = valoresDES.get(35);
                    codePayUCobro = hrefs.get(35);
                } else if (getVehiculo().getOcupantes() >= 10) {
                    setCobro = valoresDES.get(36);
                    codePayUCobro = hrefs.get(36);
                }

                break;

        }

        return "$ " + setCobro;
    }

    public int yearActual() {
        Date date = new Date();
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        String currentYear = getYearFormat.format(date);
        return Integer.parseInt(currentYear);
    }


    public String mes() {
        Calendar c1 = Calendar.getInstance();
        List<String> meses = Arrays.asList("ene", "feb", "mar", "abr", ",may", "jun", "jul", "ago", "sep", "oct", "nov", "dic");
        return (String) meses.get(c1.get(Calendar.MONTH));
    }

    public int date(int DATE) {
        Calendar c1 = Calendar.getInstance();
        return c1.get(DATE);
    }

}
