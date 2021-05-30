package modeloInfo;

public class FactoryInfoCliente {
    public static InfoCliente getPaqueteNuevoCliente(int dni){
        return new InfoCliente(dni);
    }
}
