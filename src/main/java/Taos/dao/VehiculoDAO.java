package Taos.dao;

import TaosBackend.Taos.Modelo.Vehiculo;

public interface VehiculoDAO {
    void registrar(Vehiculo vehiculo);

    Vehiculo buscarVehiculoPlaca(String placa);
}
