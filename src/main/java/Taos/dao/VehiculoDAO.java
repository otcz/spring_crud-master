package Taos.dao;

import Taos.Modelo.Vehiculo;

public interface VehiculoDAO {
    void registrar(Vehiculo vehiculo);

    Vehiculo buscarVehiculoPlaca(String placa);
}
