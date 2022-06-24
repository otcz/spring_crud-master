package com.javamaster.spring_crud.utils;


import com.javamaster.spring_crud.modelo.Vehiculo;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Cobro {


    @Getter
    @Setter
    private List<String> valoresDES = List.of("180.180", "373.320", "500.850", "564.840", "564.840", "564.840", "588.150", "707.040", "702.360", "831.870", "823.680", "945.180", "659,160", "951,750", "1,203,300", "741,600", "934,740", "1,120,680", "331,920", "440,010", "404,010", "502,650", "471,870", "559,710"
            , "591,660", "755,010", "791,820", "950,760", "410,940", "513,450", "510,840", "631,350", "659,160", "773,190", "983,790", "972,990", "1,411,650");

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
                } else if ((getVehiculo().getCilindraje()) < 100) {
                    setCobro = valoresDES.get(1);
                } else if ((getVehiculo().getCilindraje()) >= 100 && (getVehiculo().getCilindraje()) < 200) {
                    setCobro = valoresDES.get(2);
                } else if ((getVehiculo().getCilindraje()) >= 200) {
                    setCobro = valoresDES.get(3);
                } else if ((getVehiculo().getClase()) == "Motocarro, tricimoto, Cuatriciclo") {
                    setCobro = valoresDES.get(4);
                } else {
                    setCobro = valoresDES.get(5);
                }
                break;

            case 2:
                if ((getVehiculo().getCilindraje()) < 1500 && (resul < 10)) {
                    setCobro = valoresDES.get(6);
                } else if ((getVehiculo().getCilindraje()) < 1500 && (resul >= 10)) {
                    setCobro = valoresDES.get(7);
                } else if ((getVehiculo().getCilindraje()) >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(8);
                } else if ((getVehiculo().getCilindraje()) >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(9);
                } else if ((getVehiculo().getCilindraje()) > 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(10);
                } else if ((getVehiculo().getCilindraje()) > 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(11);
                }
                break;
            case 3:
                if (getVehiculo().getToneladas() < 5) {
                    setCobro = valoresDES.get(12);
                } else if (getVehiculo().getToneladas() >= 5 && getVehiculo().getToneladas() <= 15) {
                    setCobro = valoresDES.get(13);
                } else if (getVehiculo().getToneladas() > 15) {
                    setCobro = valoresDES.get(14);
                }

                break;
            case 4:

                if (getVehiculo().getCilindraje() < 1500) {
                    setCobro = valoresDES.get(15);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getToneladas() <= 2500) {
                    setCobro = valoresDES.get(16);
                } else if (getVehiculo().getCilindraje() > 2500) {
                    setCobro = valoresDES.get(17);
                }

                break;
            case 5:

                if (getVehiculo().getCilindraje() < 1500 && (resul < 10)) {
                    setCobro = valoresDES.get(18);
                } else if (getVehiculo().getCilindraje() < 1500 && (resul >= 10)) {
                    setCobro = valoresDES.get(19);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(20);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(21);
                } else if (getVehiculo().getCilindraje() > 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(22);
                } else if (getVehiculo().getCilindraje() > 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(23);
                }
                break;
            case 6:
                if (getVehiculo().getCilindraje() < 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(24);
                } else if (getVehiculo().getCilindraje() < 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(25);
                } else if (getVehiculo().getCilindraje() >= 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(26);
                } else if (getVehiculo().getCilindraje() >= 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(27);
                }
                break;
            case 7:
                if (getVehiculo().getCilindraje() < 1500 && (resul < 10)) {
                    setCobro = valoresDES.get(28);
                } else if (getVehiculo().getCilindraje() < 1500 && (resul >= 10)) {
                    setCobro = valoresDES.get(29);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(30);
                } else if (getVehiculo().getCilindraje() >= 1500 && getVehiculo().getCilindraje() <= 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(31);
                } else if (getVehiculo().getCilindraje() > 2500 && (resul < 10)) {
                    setCobro = valoresDES.get(32);
                } else if (getVehiculo().getCilindraje() > 2500 && (resul >= 10)) {
                    setCobro = valoresDES.get(33);
                }
                break;
            case 8:
                setCobro = valoresDES.get(34);
                break;
            case 9:
                if (getVehiculo().getOcupantes() < 10) {
                    setCobro = valoresDES.get(35);
                } else if (getVehiculo().getOcupantes() >= 10) {
                    setCobro = valoresDES.get(36);
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
        List meses = List.of("ene", "feb", "mar", "abr", ",may", "jun", "jul", "ago", "sep", "oct", "nov", "dic");
        return (String) meses.get(c1.get(Calendar.MONTH));
    }

    public int date(int DATE) {
        Calendar c1 = Calendar.getInstance();
        return c1.get(DATE);
    }

}
