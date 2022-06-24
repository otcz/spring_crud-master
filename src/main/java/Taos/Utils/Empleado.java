package Taos.Utils;


import lombok.Getter;
import lombok.Setter;

public class Empleado {

    @Getter
    @Setter
    private String email = "OSCAR";

    public Empleado(String email) {
        this.email = email;
    }
}