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
    private String cobro;


    private List<String> hrefs = Arrays.asList("B0ed163C6C916D3", "B0ed16310623B9B", "B0ed16381C0BC86", "B0ed163A59F093E", "B0ed163A59F093E", "B0ed163A59F093E"
            , "B0ed163B31C2EEA", "B0ed1639FDA0A94", "B0ed163BF879DA2", "B0ed163578AE938", "B0ed163C20E2A58", "B0ed1630ED8BFD6"
            , "B0ed16322B5A900", "B0ed163E7E757FA", "B0ed16314A74035"
            , "B0ed1633C34FF9D", "B0ed163D94F552F", "B0ed16371C557DA"
            , "B0ed163733B16FB", "B0ed1639734FE88", "B0ed163587F43B1", "B0ed16348E69F18", "B0ed163CC1F689A", "B0ed1634774E6B1"
            , "B0ed163D4C0F5DB", "B0ed163BB632174", "B0ed16391FB1BB0", "B0ed1633D22E06D"
            ,"B0ed16395FB189D","B0ed1637AE38648","B0ed1637DB9842B","B0ed1638EB19173","B0ed163406F4F36","B0ed16327C32CB5"
            , "B0ed1633FFE815B"
            , "B0ed163B66DE0FE", "B0ed1639AA13E67");


    @Getter
    @Setter
    private Vehiculo vehiculo;

    public Cobro(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String calcularCobro() {
        String setCobro = "";
        int resul = yearActual() - getVehiculo().getModelo();
        switch (getVehiculo().getCostoTotal()) {
            case 1:
                if (getVehiculo().getClase() == ("Ciclomotor")) {
                    setCobro = valoresDES.get(0);
                    cobro = hrefs.get(0);
                } else if ((getVehiculo().getCilindraje()) < 100) {
                    setCobro = valoresDES.get(1);
                    cobro = hrefs.get(1);
                } else if ((getVehiculo().getCilindraje()) >= 100 && (getVehiculo().getCilindraje()) < 200) {
                    setCobro = valoresDES.get(2);
                    cobro = hrefs.get(2);
                } else if ((getVehiculo().getCilindraje()) >= 200) {
                    setCobro = valoresDES.get(3);
                    cobro = hrefs.get(3);
                } else if ((getVehiculo().getClase()) == "Motocarro, tricimoto, Cuatriciclo") {
                    setCobro = valoresDES.get(4);
                    cobro = hrefs.get(4);
                } else {
                    setCobro = valoresDES.get(5);
                    cobro = hrefs.get(5);
                }
                break;

            case 2:
                if ((getVehiculo().getCilindraje()) < 1500 && (resul < 10)) {
                    setCobro = valoresDES.get(6);
                    cobro = hrefs.get(6);
                } else if ((getVehiculo().getCilindraje()) < 1500 && (resul >= 10)) {
                    setCobro = valoresDES.get(7);
                    cobro = hrefs.get(7);
                } else if ((getVehiculo().getCilindraje()) >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(8);
                    cobro = hrefs.get(8);
                } else if ((getVehiculo().getCilindraje()) >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(9);
                    cobro = hrefs.get(9);
                } else if ((getVehiculo().getCilindraje()) > 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(10);
                    cobro = hrefs.get(10);
                } else if ((getVehiculo().getCilindraje()) > 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(11);
                    cobro = hrefs.get(11);
                }
                break;
            case 3:
                if (getVehiculo().getToneladas() < 5) {
                    setCobro = valoresDES.get(12);
                    cobro = hrefs.get(12);
                } else if (getVehiculo().getToneladas() >= 5 && getVehiculo().getToneladas() <= 15) {
                    setCobro = valoresDES.get(13);
                    cobro = hrefs.get(13);
                } else if (getVehiculo().getToneladas() > 15) {
                    setCobro = valoresDES.get(14);
                    cobro = hrefs.get(14);
                }

                break;
            case 4:

                if (getVehiculo().getCilindraje() < 1500) {
                    setCobro = valoresDES.get(15);
                    cobro = hrefs.get(15);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getToneladas() <= 2500) {
                    setCobro = valoresDES.get(16);
                    cobro = hrefs.get(16);
                } else if (getVehiculo().getCilindraje() > 2500) {
                    setCobro = valoresDES.get(17);
                    cobro = hrefs.get(17);
                }

                break;
            case 5:

                if (getVehiculo().getCilindraje() < 1500 && (resul < 10)) {
                    setCobro = valoresDES.get(18);
                    cobro = hrefs.get(18);
                } else if (getVehiculo().getCilindraje() < 1500 && (resul >= 10)) {
                    setCobro = valoresDES.get(19);
                    cobro = hrefs.get(19);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(20);
                    cobro = hrefs.get(20);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(21);
                    cobro = hrefs.get(21);
                } else if (getVehiculo().getCilindraje() > 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(22);
                    cobro = hrefs.get(22);
                } else if (getVehiculo().getCilindraje() > 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(23);
                    cobro = hrefs.get(23);
                }
                break;
            case 6:
                if (getVehiculo().getCilindraje() < 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(24);
                    cobro = hrefs.get(24);
                } else if (getVehiculo().getCilindraje() < 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(25);
                    cobro = hrefs.get(25);
                } else if (getVehiculo().getCilindraje() >= 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(26);
                    cobro = hrefs.get(26);
                } else if (getVehiculo().getCilindraje() >= 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(27);
                    cobro = hrefs.get(27);
                }
                break;
            case 7:
                if (getVehiculo().getCilindraje() < 1500 && (resul < 10)) {
                    setCobro = valoresDES.get(28);
                    cobro = hrefs.get(28);
                } else if (getVehiculo().getCilindraje() < 1500 && (resul >= 10)) {
                    setCobro = valoresDES.get(29);
                    cobro = hrefs.get(29);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(30);
                    cobro = hrefs.get(30);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(31);
                    cobro = hrefs.get(31);
                } else if (getVehiculo().getCilindraje() > 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(32);
                    cobro = hrefs.get(32);
                } else if (getVehiculo().getCilindraje() > 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(33);
                    cobro = hrefs.get(33);
                }
                break;
            case 8:
                setCobro = valoresDES.get(34);
                cobro = hrefs.get(34);
                break;
            case 9:
                if (getVehiculo().getOcupantes() < 10) {
                    setCobro = valoresDES.get(35);
                    cobro = hrefs.get(35);
                } else if (getVehiculo().getOcupantes() >= 10) {
                    setCobro = valoresDES.get(36);
                    cobro = hrefs.get(36);
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
